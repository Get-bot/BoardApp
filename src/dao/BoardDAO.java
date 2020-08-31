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
	
}



