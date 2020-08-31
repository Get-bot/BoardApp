package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardDeleteService;

@WebServlet("/boarddelete")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardDeleteController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardDeleteService bDeleteService = new BoardDeleteService();
    	int deleteResult = bDeleteService.boardDelete(request, response);
    	
    	if(deleteResult > 0) {
    		// JSP 파일로 redirect를 하는 것이 아니라 
    		// memberlist 주소를 redirect 하는 방법 
    		// 이렇게 하면 MemberListController가 바로 호출 되면서 
    		// 최종 결과는 MemberList.jsp가 출력됨 
    		response.sendRedirect("boardlist");
    	} else {
    		response.sendRedirect("Deletefail.jsp");
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
