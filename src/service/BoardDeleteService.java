package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;


public class BoardDeleteService {

	public int boardDelete(HttpServletRequest request, HttpServletResponse response) {
		int bnumber =Integer.parseInt( request.getParameter("bnumber"));
		
		BoardDAO mDAO = new BoardDAO();
		mDAO.dbConnection();
		
		int deleteResult = mDAO.boardDelete(bnumber);
		mDAO.dbClose();
		
		return deleteResult;
	}

}







