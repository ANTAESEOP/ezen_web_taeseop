package reply;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.dao.BoardDao;
import model.dto.dao.MemberDao;

@WebServlet("/reply/rwrite")
public class rwrite extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 타입 요청 [ 0 : 댓글 1: 대댓글 [ 답글 ] ]
		String type = request.getParameter("type");
		String rcontent = request.getParameter("rcontent"); 
		int mno = MemberDao.getInstance().getMno( (String) request.getSession().getAttribute("mid") 
				);
		if( mno == 0 ) { response.getWriter().print("0"); return;}
		int bno = (Integer)request.getSession().getAttribute("bno");
		
		boolean result = false;
		if( type.equals( "reply" ) ) { // 댓글일경우
			result = BoardDao.getInstance().rwrite( rcontent, mno, bno);
		}else if ( type.equals("rereply") ) { // 대댓글 일 경우
			int rindex = Integer.parseInt(request.getParameter("rno") );
			result = BoardDao.getInstance().rrwrite( rcontent, mno, bno , rindex);
		}
		// 3. 결과 반환
		if(result) {response.getWriter().print("1");}
		else {response.getWriter().print("2");}
	}
	
	private static final long serialVersionUID = 1L;

    public rwrite() {
        super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}



}
