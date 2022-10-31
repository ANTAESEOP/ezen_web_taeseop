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

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.member.delete;
import model.dto.dao.ProductDao;
import model.dto.dto.ProductDto;

@WebServlet("/admin/regist")
public class regist extends HttpServlet {
	
//////////////////////////////// 제품 등록 메소드 ////////////////////////////////
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 첨부파일이 있을 경우에만 [ 업로드 용 ] */
		MultipartRequest multi = new MultipartRequest(
				request, 
				request.getSession().getServletContext().getRealPath("/admin/pimg"), 
				1024*1024*10,
				"UTF-8", 
				new DefaultFileRenamePolicy() );
		
		String pname = multi.getParameter("pname");			
		String pcomment = multi.getParameter("pcomment");		
		int pprice = Integer.parseInt(multi.getParameter("pprice") );
		float pdiscount = Float.parseFloat(multi.getParameter("pdiscount") ); 
		String pimg = multi.getFilesystemName("pimg"); // 첨부파일 = getFilesystemName 
		
		int pcno = Integer.parseInt(multi.getParameter("pcno") );
		
		
		ProductDto dto = new ProductDto(0 , pname , pcomment ,
				pprice , pdiscount , (byte)0 ,
				pimg , null , pcno );
		
		System.out.println(dto.toString()); // dto 확인용
		
		// DAO 처리
		boolean result = new ProductDao().setproduct(dto);
		response.getWriter().print(result);
		
	}
	private static final long serialVersionUID = 1L;

    public regist() {
        super();}
    
    // 2. 제품 출력 메소드 [ GET ]
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// * 타입 : 1 [ 모든 제품 출력 ] 2 [ 개별 제품 출력 ]
		String type = request.getParameter("type");
		response.setCharacterEncoding("UTF-8");
		if(type.equals("1") ) {
			
			// 1. 전체 출력 2. 판매중 출력
				String option = request.getParameter("option");
				System.out.println(option);

			//////////////////////////////// 모든 제품 출력 ////////////////////////////////
			ArrayList<ProductDto> list = new ProductDao().getProductlist(option);	// DAO 처리
			JSONArray array = new JSONArray(); // LIST - > JSON
			for( int i = 0 ; i<list.size(); i++) {
				JSONObject object = new JSONObject();
				object.put("pno", list.get(i).getPno()); 			object.put("pname",list.get(i).getPname()  );
				object.put("pcomment",list.get(i).getPcomment()); 	object.put("pprice",list.get(i).getPprice()  );
				object.put("pdiscount",list.get(i).getPdiscount()); object.put("pactive",list.get(i).getPactive()  );
				object.put("pimg",list.get(i).getPimg());			object.put("pdate",list.get(i).getPdate()  );
				object.put("pcno",list.get(i).getPcno());			
				array.add(object);
			}
			response.getWriter().print(array);
			System.out.println(array);
			////////////////////////////////모든 제품 출력 ////////////////////////////////
		}else if(type.equals("2")) {
			////////////////////////////////개별 제품 출력 ////////////////////////////////
			// 1. 호출 할 제품번호 요청
			int pno = Integer.parseInt(request.getParameter("pno") );
			// 2. dao
			ProductDto dto = new ProductDao().getProduct( pno );
			// 3. 응답
			JSONObject object = new JSONObject();
			object.put("pno", dto.getPno()); 			object.put("pname",dto.getPname()  );
			object.put("pcomment",dto.getPcomment()); 	object.put("pprice",dto.getPprice()  );
			object.put("pdiscount",dto.getPdiscount()); object.put("pactive",dto.getPactive()  );
			object.put("pimg",dto.getPimg());			object.put("pdate",dto.getPdate()  );
			object.put("pcno",dto.getPcno());			
			// 4. 응답
			response.getWriter().print(object);
			////////////////////////////////개별 제품 출력 ////////////////////////////////
		}
	}
	
	// 제품 수정 메소드 [ PUT ]
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uploadpath = req.getSession().getServletContext().getRealPath("/upload");
		
		/* 첨부파일이 있을 경우에만 [ 업로드 용 ] */
		MultipartRequest multi = new MultipartRequest(
				req, 
				req.getSession().getServletContext().getRealPath("/admin/pimg"), 
				1024*1024*10,
				"UTF-8", 
				new DefaultFileRenamePolicy() );
		
		int pno = Integer.parseInt(multi.getParameter("pno"));
		byte pactive = Byte.parseByte(multi.getParameter("pactive"));
		
		String pname = multi.getParameter("pname");			
		String pcomment = multi.getParameter("pcomment");		
		int pprice = Integer.parseInt(multi.getParameter("pprice") );
		float pdiscount = Float.parseFloat(multi.getParameter("pdiscount") ); 
		String pimg = multi.getFilesystemName("pimg"); // 첨부파일 = getFilesystemName 
	
		int pcno = Integer.parseInt(multi.getParameter("pcno"));
		
		
		ProductDto dto = new ProductDto(
				0 , pname ,
				pcomment , pprice ,
				pdiscount , pactive ,
				pimg , null , pcno );
		
		System.out.println(dto.toString()); // dto 확인용
		
		//DAO 처리
		boolean result = new ProductDao().updateproduct(pno, pname, pcomment, pprice, pdiscount, pimg, pactive , pcno);
		resp.getWriter().print(result);
		
		
	}
	
	// 제품 삭제 메소드 [ DELETE ]
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 삭제할 제품번호 요청
		int pno = Integer.parseInt(req.getParameter("pno") );
		// 2. dao
		boolean result = new ProductDao().deleteproduct(pno);
		// 3. 응답
		resp.getWriter().print(result);
	}
	
	
	
}
