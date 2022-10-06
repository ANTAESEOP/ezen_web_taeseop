package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.dao.MemberDao;

@WebServlet("member/login") // URL 정의 : 해당 클래스로 들어올 수 있는 경로 설정
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public login() {super();}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mid = request.getParameter("mid");
		String mpassword = request.getParameter("mpassword");
		// 2. 변수 2개 --> dto x
		// 3. dao 메소드 호출 [ 싱글톤 ]
		boolean result = MemberDao.getInstance().login(mid, mpassword);
		// 4. 결과 제어 [ true이면 index.jsp  false 이면 login.jsp ]
		if( result ) { response.sendRedirect("/jspweb/index.jsp"); }
		else{ response.sendRedirect("/jspweb/member/login.jsp"); }
		
		
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}



}
