package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.dao.BoardDao;
import model.dto.dto.BoardDto;

@WebServlet("/board/bviewup")
public class bviewup extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 조회수 올릴 게시물 번호 불러오기
		int bno = (Integer)request.getSession().getAttribute("bno");
		
		BoardDto dto = new BoardDao().getInstance().getboard(bno);
		
		boolean result = BoardDao.getInstance().bviewup(bno);
		
		response.getWriter().print(result);
	}

	
	private static final long serialVersionUID = 1L;

    public bviewup() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
