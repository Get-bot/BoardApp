package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardViewService;

@WebServlet("/boardview")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardViewController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        BoardViewService bViewService = new BoardViewService();
        BoardDTO boardView = bViewService.viewService(request,response);
        
        if(boardView != null) {
    		request.setAttribute("boardView", boardView);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("BoardView.jsp");
    		dispatcher.forward(request, response);
        }else{
        	response.sendRedirect("BoardViewFail.jsp");
        }
    }
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
