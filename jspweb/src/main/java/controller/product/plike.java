package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.dao.MemberDao;
import model.dto.dao.ProductDao;

/**
 * Servlet implementation class plike
 */
@WebServlet("/product/plike")
public class plike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public plike() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청
		int pno = Integer.parseInt(request.getParameter("pno") );
		int mno = MemberDao.getInstance().getMno( (String)request.getSession().getAttribute("mid"));
		
		// 2. db처리
		int result = new ProductDao().setPlike(pno , mno);
		// 3. 응답
		response.getWriter().print(result); // true : 등록 false : 취소
	}

}
