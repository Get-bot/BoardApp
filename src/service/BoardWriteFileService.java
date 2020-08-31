package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardWriteFileService {

	public int writeFileService(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//파일이 저장된 위치를 savePath 변수에 저장
		String savePath= "D:\\source\\servlet\\BoardProject\\WebContent\\UploadFile";
		MultipartRequest multi = new MultipartRequest(request, savePath, 10*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		
		BoardDTO bDTO = new BoardDTO();
		String bwriter = multi.getParameter("bwriter");
		String btitle = multi.getParameter("btitle");
		String bcontents = multi.getParameter("bcontents");
		String bfile = multi.getOriginalFileName((String)multi.getFileNames().nextElement());
		
		bDTO.setBwriter(bwriter);
		bDTO.setBtitle(btitle);
		bDTO.setBcontents(bcontents);
		bDTO.setBfilename(bfile);
		
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		int boardWriteFile = bDAO.boardWriteFile(bDTO);
		bDAO.dbClose();
		return boardWriteFile;
	}

}
