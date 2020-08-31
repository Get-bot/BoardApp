package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import dto.PageDTO;
import service.BoardListPagingService;


@WebServlet("/boardlistpaging")
public class BoardListPagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardListPagingController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");	
    BoardListPagingService bListPGService = new BoardListPagingService();
    List<BoardDTO> boardListPG = new ArrayList<BoardDTO>();
    //클릭한 페이지 필요한 글만 가져오기 위한 메서드
    boardListPG = bListPGService.listPagingService(request,response);
    //페이지 번호와 관련된 정보 결정 메서드
    PageDTO paging = bListPGService.paging(request, response);
    
    	request.setAttribute("paging", paging);
		request.setAttribute("boardListPG", boardListPG);
		RequestDispatcher dispatcher = request.getRequestDispatcher("BoardListPaging.jsp");
		dispatcher.forward(request, response);
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
