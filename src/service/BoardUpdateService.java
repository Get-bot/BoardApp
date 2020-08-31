package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardUpdateService {

	public BoardDTO boardUpdate(HttpServletRequest request, HttpServletResponse response) {
		int bnumber = Integer.parseInt(request.getParameter("bnumber"));	
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		BoardDTO boardUpdate = bDAO.boardView(bnumber);
		bDAO.dbClose();
		
		return boardUpdate;
		
	}

}
