package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardUpdateProcessService {

	public int boardUpdateP(HttpServletRequest request, HttpServletResponse response) {
		int bnumber = Integer.parseInt(request.getParameter("bnumber"));
		String setBwriter = request.getParameter("bwriter");
		String setBtitle = request.getParameter("btitle");
		String setBcontents = request.getParameter("bcontents");
		
		BoardDTO board = new BoardDTO();
		board.setBnumber(bnumber);
		board.setBwriter(setBwriter);
		board.setBtitle(setBtitle);
		board.setBcontents(setBcontents);
		
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		int boardUpdate = bDAO.boardupp(board);
		bDAO.dbClose();	
		return boardUpdate;
	}

}
