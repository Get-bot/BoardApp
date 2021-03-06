package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.BoardDAO;
import dto.BoardDTO;
import dto.PageDTO;

public class BoardListPagingService {
	/* 상수 선언
	 *  상수 : 바뀌지 않는 값이며, 현재 클래스 내에서 고정값으로 사용이 가능함. 
	 *  	  상수에 담긴 값을 변환을 할 수 없음. */
	// PAGE_LIMIT : 한페이지에 보여줄 글 갯수 
	private static final int PAGE_LIMIT = 3;
	// BLOCK_LIMIT : 한 화면상에 노출되는 페이지 갯수 
	// 예를 들어 1~5까지 보이고 그다음은 6~10, 11~15 .......
	private static final int BLOCK_LIMIT = 5;
	
	
	public List<BoardDTO> listPagingService(HttpServletRequest request, HttpServletResponse response) {
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		int startRow = (page-1) * PAGE_LIMIT + 1;
		int endRow = page * PAGE_LIMIT;
		/*page 1일때
		 * startrow = (1-1)*3+1=1
		 * endrow = 1*3=3
		 * 
		 */
		List<BoardDTO> boardList = bDAO.boardListPaging(startRow, endRow);
		bDAO.dbClose();
		
		return boardList;
	}


	public PageDTO paging(HttpServletRequest request, HttpServletResponse response) {
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		//db에 전체글갯수 호출
		int listCount = bDAO.listCount();
		bDAO.dbClose();
		//최대 필요한 페이지 갯수
		int maxPage = (int)(Math.ceil((double)listCount/PAGE_LIMIT)); //ceil올림함수 소수점이하 올림
		//시작 페이지
		int startPage = (((int)(Math.ceil((double)page/BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
		//마지막 페이지
		int endPage = startPage + BLOCK_LIMIT - 1;

		if (endPage > maxPage) {
			endPage = maxPage;
		}
		PageDTO paging = new PageDTO();
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		
		return paging;
	}

	
}
