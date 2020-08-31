package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardWriteFileService;

@WebServlet("/boardwritefile")
public class BoardWriteFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardWriteFileController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardWriteFileService bWriteFileService = new BoardWriteFileService();
    	int result = bWriteFileService.writeFileService(request, response);
    	
    	if(result > 0) {
    		response.sendRedirect("boardlist");
    	} else {
    		response.sendRedirect("BoardListFail.jsp");
    	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
