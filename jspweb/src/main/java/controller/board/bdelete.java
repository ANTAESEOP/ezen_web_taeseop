package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.dao.BoardDao;
import model.dto.dto.BoardDto;

/**
 * Servlet implementation class bdelete
 */
@WebServlet("/board/bdelete")
public class bdelete extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 삭제할 번호 요청
		int bno = Integer.parseInt( request.getParameter("bno") );
		
		BoardDto dto = BoardDao.getInstance().getboard(bno); // 삭제할 게시물 정보를 먼저 호출
		
		// 2. DAO 처리
		boolean result = BoardDao.getInstance().bdelete(bno); 
		if(result) {
			String deletepath = request.getSession().getServletContext().getRealPath("/upload/"+ dto.getBfile() );
			File file = new File(deletepath);
			if(file.exists() ) file.delete(); // 해당 경로에 존재하는 파일을 삭제
			// File 클래스
				// 자바 외부에 존재 하는 파일 조작 / 제어 메소드 제공하는 클래스
				// 1. 객체명.length() : 해당 파일의 바이트 길이
				// 2. 객체명.delete() : 해당 파일의 삭제
				// 3. 객체명.exists() : 해당 파일이 존재하면 true / 존재하지 않으면 false
			
		}
		
		
		// 3. 결과 응답
		response.getWriter().print(result);
	}	
	
	private static final long serialVersionUID = 1L;

    public bdelete() {
        super();}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
