package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import dto.BoardDTO;

public class BoardDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void dbConnection() {
		con = DBConnection.getConnection();
	}
	
	public void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void pstmtClose() {
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void rsClose() {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int boardWrite(BoardDTO bDTO) {
		int result = 0;
		String sql = "INSERT INTO BOARD1(BNUMBER,BWRITER,BTITLE,BCONTENTS,BDATE,BHITS)"
				+ "VALUES(SEQ_BNUMBER.NEXTVAL,?,?,?,SYSDATE,0)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bDTO.getBwriter());
			pstmt.setString(2, bDTO.getBtitle());
			pstmt.setString(3, bDTO.getBcontents());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return result;
	}

	public int boardWriteFile(BoardDTO bDTO) {
		int result = 0;
		String sql = "INSERT INTO BOARD1(BNUMBER,BWRITER,BTITLE,BCONTENTS,BDATE,BHITS,BFILENAME)"
				+ "VALUES(SEQ_BNUMBER.NEXTVAL,?,?,?,SYSDATE,0,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bDTO.getBwriter());
			pstmt.setString(2, bDTO.getBtitle());
			pstmt.setString(3, bDTO.getBcontents());
			pstmt.setString(4, bDTO.getBfilename());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return result;
	}

	public List<BoardDTO> boardList() {
		String sql = "SELECT * FROM BOARD1 ORDER BY BNUMBER DESC";
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		BoardDTO bDTO = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bDTO = new BoardDTO();
				bDTO.setBnumber(rs.getInt("BNUMBER"));
				bDTO.setBwriter(rs.getString("BWRITER"));
				bDTO.setBtitle(rs.getString("BTITLE"));
				bDTO.setBcontents(rs.getString("BCONTENTS"));
				bDTO.setBdate(rs.getString("BDATE"));
				bDTO.setBhits(rs.getInt("BHITS"));
				
				boardList.add(bDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
			pstmtClose();
		}
		return boardList;
	}
	

	public BoardDTO boardView(int bnumber) {
		String sql = "SELECT * FROM BOARD1 WHERE BNUMBER = ?";
		BoardDTO bDTO = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,bnumber);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bDTO = new BoardDTO();
				bDTO.setBnumber(rs.getInt("BNUMBER"));
				bDTO.setBwriter(rs.getString("BWRITER"));
				bDTO.setBtitle(rs.getString("BTITLE"));
				bDTO.setBcontents(rs.getString("BCONTENTS"));
				bDTO.setBdate(rs.getString("BDATE"));
				bDTO.setBhits(rs.getInt("BHITS"));
				bDTO.setBfilename(rs.getString("BFILENAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
			pstmtClose();
		}
		
		return bDTO;
	}

	public void boardHits(int bnumber) {
		String sql = "UPDATE   BOARD1 SET BHITS=BHITS+1 WHERE BNUMBER = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,bnumber);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		
	}

	public int boardupp(BoardDTO board) {
		String sql = "UPDATE  BOARD1 SET BWRITER=? ,BTITLE=? ,BCONTENTS= ?,BDATE = SYSDATE WHERE BNUMBER = ?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,board.getBwriter());
			pstmt.setString(2,board.getBtitle());
			pstmt.setString(3,board.getBcontents());
			pstmt.setInt(4,board.getBnumber());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		
		return result;
	}
	public int boardDelete(int bnumber) {
		String sql = "DELETE FROM BOARD1 WHERE BNUMBER=?";
		int deleteResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			deleteResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		
		return deleteResult;
	}

	public List<BoardDTO> boardSearch(String key) {
		String sql = "SELECT * FROM BOARD1 WHERE BTITLE LIKE ? ORDER BY BNUMBER DESC";
		List<BoardDTO> boardSearch = new ArrayList<BoardDTO>();
		BoardDTO bDTO = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, '%'+key+'%');
			rs = pstmt.executeQuery();	
			while(rs.next()) {
				bDTO = new BoardDTO();
				bDTO.setBnumber(rs.getInt("BNUMBER"));
				bDTO.setBwriter(rs.getString("BWRITER"));
				bDTO.setBtitle(rs.getString("BTITLE"));
				bDTO.setBcontents(rs.getString("BCONTENTS"));
				bDTO.setBdate(rs.getString("BDATE"));
				bDTO.setBhits(rs.getInt("BHITS"));
				
				boardSearch.add(bDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rsClose();
			pstmtClose();
		}
		return boardSearch;
	}
	

	public int listCount() {
		String sql = "SELECT COUNT(BNUMBER) FROM BOARDLIST";
		int listCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listCount = rs.getInt(1);
				//첫번째 결과
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return listCount;
	}

	public List<BoardDTO> boardListPaging(int startRow, int endRow) {
		String sql = "SELECT * FROM BOARDLIST WHERE RN BETWEEN ? AND ?";
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		BoardDTO board = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new BoardDTO();
				board.setBnumber(rs.getInt("BNUMBER"));
				board.setBwriter(rs.getString("BWRITER"));
				board.setBtitle(rs.getString("BTITLE"));
				board.setBcontents(rs.getString("BCONTENTS"));
				board.setBdate(rs.getString("BDATE"));
				board.setBhits(rs.getInt("BHITS"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return boardList;
	}
	
}



