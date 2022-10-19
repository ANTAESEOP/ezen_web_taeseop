package reply;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import model.dto.dao.BoardDao;

@WebServlet("/reply/rlist")
public class rlist extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		int bno = (Integer)request.getSession().getAttribute("bno"); // 1. 요청
		
		JSONArray  array = new JSONArray();
		if( type.equals("reply") ) {
			array = BoardDao.getInstance().getrlist(bno);
		}else if(type.equals("rereply") ) {
			int rindex = Integer.parseInt(request.getParameter("rno") );
			array = BoardDao.getInstance().getrrlist(bno , rindex);
		}
		
		response.setCharacterEncoding("UTF-8"); // 3. 결과
		response.getWriter().print(array);
		
	}

	private static final long serialVersionUID = 1L;

    public rlist() {
        super();
        // TODO Auto-generated constructor stub
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
