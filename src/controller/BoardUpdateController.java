package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardUpdateService;

/**
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/boardupdate")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8"); 
    	BoardUpdateService BoardUpService = new BoardUpdateService();
    	BoardDTO boardUpdate = BoardUpService.boardUpdate(request,response);
    	
        if(boardUpdate != null) 
    	request.setAttribute("boardUpdate", boardUpdate);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("boardUpdate.jsp");
    	dispatcher.forward(request, response);
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
