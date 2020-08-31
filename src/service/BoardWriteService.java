package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardWriteService {

	public int writeService(HttpServletRequest request, HttpServletResponse response) {
		String bwriter = request.getParameter("bwriter");
		String btitle = request.getParameter("btitle");
		String bcontents = request.getParameter("bcontents");
		
		BoardDTO bDTO = new BoardDTO();
		bDTO.setBwriter(bwriter);
		bDTO.setBtitle(btitle);
		bDTO.setBcontents(bcontents);
		
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		int boardWrite = bDAO.boardWrite(bDTO);
		bDAO.dbClose();
		return boardWrite;
	}

}
