package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.postDao;
import model.dto.postDto;


@WebServlet("/post/postlist")
public class postlist extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject boards = new JSONObject();
		ArrayList<postDto> list = postDao.getInstance().postlist();
		JSONArray array = new JSONArray();
		for(int i = 0 ; i<list.size(); i++) {
			JSONObject object = new JSONObject();
			object.put("pno", list.get(i).getPno());
			object.put("ptitle", list.get(i).getPtitle());
			object.put("pwriter", list.get(i).getPwriter());
			object.put("pdate", list.get(i).getPdate());
			object.put("pview", list.get(i).getPview());
			array.add(object);
		}
		
		// 응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(boards);
	}
	
	private static final long serialVersionUID = 1L;

    public postlist() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
