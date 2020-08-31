package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardViewService {

	public BoardDTO viewService(HttpServletRequest request, HttpServletResponse response) {
		int bnumber = Integer.parseInt(request.getParameter("bnumber"));	
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		bDAO.boardHits(bnumber);
		BoardDTO boardView = bDAO.boardView(bnumber);
		bDAO.dbClose();
		
		return boardView;
	}

}
