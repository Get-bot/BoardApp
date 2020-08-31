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
import service.BoardSearchService;

@WebServlet("/boardsearch")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSearchController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardSearchService bSearchService = new BoardSearchService();
    	List<BoardDTO> serchList =new ArrayList<BoardDTO>();
    	serchList = bSearchService.boardSearch(request, response);
    	if(serchList !=null ) {
    		request.setAttribute("boardList", serchList);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("BoardList.jsp");
    		dispatcher.forward(request, response);  				
    	} else {
    		response.sendRedirect("BoardSearchFalil.jsp");
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
