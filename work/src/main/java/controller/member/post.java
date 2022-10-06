package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.postDao;
import model.dto.postDto;

@WebServlet("/post")
public class post extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String ptitle = request.getParameter("ptitle");	
	String pwriter = request.getParameter("pwriter");	
	String pcontent = request.getParameter("pcontent");	
	String ppassword = request.getParameter("ppassword");	
	
	postDto dto = new postDto(0 , ptitle , pwriter , pcontent , ppassword, 0);
	
	System.out.println(dto.toString() );
	
	boolean result = postDao.getInstance().inputpost(dto);
	
	if( result ) {System.out.println("게시판 작성 성공");}
	else { System.out.println("작성실패");}
	
	
	
	
	}
	
	
	
	private static final long serialVersionUID = 1L;

    public post() {super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}



}
