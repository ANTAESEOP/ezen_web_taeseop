package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.dao.BoardDao;
import model.dto.dao.MemberDao;

@WebServlet("/board/write")
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mid = (String)request.getSession().getAttribute("mid"); 
		// 세션호출 getSession() 이용한 mid 세션 호출 + 형변환
		int mno = MemberDao.getInstance().getMno(mid);

		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		System.out.println(btitle);
		System.out.println(bcontent);
		
		boolean result =
		BoardDao.getInstance().write(btitle, bcontent , mno);
		System.out.println(result);
		
		/* form 전송용 */
			//if(result) {response.sendRedirect("list.jsp");} // 글 작성 성공시 list.jsp 이동
			//else {response.sendRedirect("write.jsp");} // 글 작성 실패시 write.jsp 이동
		 
		/* js 전송용*/
		response.getWriter().print(result);
		
	}
    public write() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
