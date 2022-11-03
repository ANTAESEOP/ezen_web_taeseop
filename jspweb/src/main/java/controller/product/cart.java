package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.dto.dao.MemberDao;
import model.dto.dao.ProductDao;


@WebServlet("/product/cart")
public class cart extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청
		request.setCharacterEncoding("UTF-8");
		String data = request.getParameter("data"); // productlist 요청
		int pno = Integer.parseInt(request.getParameter("pno"));
		int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("mid"));
		
		System.out.println(data);
		// 문자열 ----> JSON 형 변환
		
		try {
			
			JSONParser parser = new JSONParser(); // 1. JSONParser parser 객체생성
			JSONArray array = (JSONArray) parser.parse(data); // 2. parser.parse( "문자열" )
			System.out.println( array );
			
			for( int i = 0 ; i<array.size() ; i++) {
				JSONObject object = (JSONObject) array.get(i); // 순서대로 객체 꺼내기
				System.out.println(object.toString());
				// 2. db처리								// json리스트객체.get(인덱스) => 해당 인덱스
				
				String psize = (String)object.get("psize");		System.out.println( psize );
				int amount = Integer.parseInt(String.valueOf(object.get("amount")));	System.out.println( amount );
				String pcolor = (String)object.get("pcolor");	System.out.println( pcolor );
				boolean result = new ProductDao().setcart(pno , psize  , amount , pcolor , mno);
				// 3. 응답 [ 만약에 옵션들 중에 하나라도 실패하면 false 반환 ]
				if(result == false ) {response.getWriter().print(result); return;}
			}
		} catch (Exception e) {System.out.println("JSON으로 변환 실패" + e ) ; }
		
		// 3. 응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print("true");
	}
	
	private static final long serialVersionUID = 1L;

    public cart() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}



}
/*
	JSON					강제 형 변환 [ 부모가 자식 ]
		"문자" : 문자열 String	(String) ----> O [ 클래스가 동일하니까 ]
		숫자 : Long			(String) ----> X 메소드 이용 [ String.valueOf( )
*/
