package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dto.dao.ProductDao;
import model.dto.dto.PcategoryDto;


@WebServlet("/board/pcategory")
public class pcategory extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청
		request.setCharacterEncoding("UTF-8");
		String pcname = request.getParameter("pcname");
		// 2. dao 처리
		boolean result = new ProductDao().setpcategory(pcname); // 싱글톤객체 사용하지 않을 경우 메소드 호출방식
		// 3. 응답
		response.getWriter().print(result);
		
	}
	
	private static final long serialVersionUID = 1L;
       

    public pcategory() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청
		// 2. dao 처리
		ArrayList<PcategoryDto> list = new ProductDao().getpcategory();
		// 3. 응답
		JSONArray array = new JSONArray();
		for(PcategoryDto dto : list ) {
			JSONObject object = new JSONObject();
			object.put("pcno" , dto.getPcno() );
			object.put("pcname" , dto.getPcname() );
			array.add(object);
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(list);
		
	}




}
