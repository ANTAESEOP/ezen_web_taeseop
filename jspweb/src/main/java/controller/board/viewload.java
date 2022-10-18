package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dto.dao.BoardDao;

/**
 * Servlet implementation class viewload
 */
@WebServlet("/board/viewload")
public class viewload extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청 [ 클릭한 게시물의 번호 저장 = backend ]
		// * 세션 : 웹서버에 저장할수 있는 메모리 공간
			// 브라우저마다 할당 [ 유저 마다 메모리 웹서버 할당 ]
			// 서버 종료되거나 시간타이머 브라우저 종료되었을때
			// 세션 == Object
		
		// 1. 요청 [ 클릭한 게시물의 번호 저장 = backend ]
		int bno = Integer.parseInt(request.getParameter("bno") ) ;
		
		// 2. 클릭한 게시물 번호를 세션 저장
		request.getSession().setAttribute("bno", bno);
		
		String mid = (String)request.getSession().getAttribute("mid");
		HttpSession session = request.getSession();
		
		// 해당 유조가 24시간 내 한번도 클락한 적이 없으면 [ 세션이 없으면 ]
		if(session.getAttribute(bno + mid) == null ) {
			// 3. DAO 조회수 증가
			BoardDao.getInstance().bviewup(bno);
			// 3. 생명주기 (초 단위) [ 현재 유저가 조회수 한 기록 남기기 조회수 올린적 있다 / 없다]
			request.getSession().setAttribute(bno + mid, true);
			request.getSession().setMaxInactiveInterval(60*60*24); // 하루
		}


	}
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}