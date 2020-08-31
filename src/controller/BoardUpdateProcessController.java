package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardUpdateProcessService;
import service.BoardViewService;

@WebServlet("/boardupdateprocess")
public class BoardUpdateProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardUpdateProcessController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardUpdateProcessService bUpdateProcessService = new BoardUpdateProcessService();
		int updateResult = bUpdateProcessService.boardUpdateP(request, response);
		BoardViewService bViewService = new BoardViewService();
		BoardDTO boardView = bViewService.viewService(request,response);
		 
		if(updateResult > 0) {
    		request.setAttribute("boardView", boardView);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("BoardView.jsp");
    		dispatcher.forward(request, response);
		} else {
			response.sendRedirect("Boardupfail.jsp");
		}
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
