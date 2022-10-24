package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.json.simple.JSONArray;

import model.dto.dao.BoardDao;


@WebServlet("/board/api2")
public class api2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		JSONArray array = BoardDao.getInstance().getapi();
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);		
	}	
	
	private static final long serialVersionUID = 1L;

    public api2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
