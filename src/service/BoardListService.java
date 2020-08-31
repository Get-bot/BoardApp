package service;

import java.util.ArrayList;
import java.util.List;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardListService {

	public List<BoardDTO> listService() {
		BoardDAO bDAO = new BoardDAO();
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		
		bDAO.dbConnection();
		boardList = bDAO.boardList();
		bDAO.dbClose();
		return boardList;
	}
	
}
