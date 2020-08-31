package service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;


public class BoardSearchService {

	public List<BoardDTO> boardSearch(HttpServletRequest request, HttpServletResponse response) {
		String key =request.getParameter("keyword");
		BoardDAO bDAO = new BoardDAO();
		List<BoardDTO> searchList = new ArrayList<BoardDTO>();
		
		bDAO.dbConnection();
		searchList = bDAO.boardSearch(key);
		bDAO.dbClose();
		return searchList;
	}

}






