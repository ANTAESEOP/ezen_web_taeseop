package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dto.dto.ProductDto;

@WebServlet("/admin/regist")
public class regist extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 첨부파일이 있을 경우에만 [ 업로드 용 ] */
		MultipartRequest multi = new MultipartRequest(
				request,
				request.getSession().getServletContext().getRealPath("/admin/pimg") ,
				1024*1024*10, // 용량
				"UTF-8",		// 인코딩
				new DefaultFileRenamePolicy() );
		
		String pname = multi.getParameter("pname");			
		String pcoment = multi.getParameter("pcoment");		
		int pprice = Integer.parseInt(multi.getContentType("pprice") );
		float pdiscount = Float.parseFloat(multi.getParameter("pdiscount") ); 
		String pimg = multi.getFilesystemName("pimg"); // 첨부파일 = getFilesystemName 
		
		System.out.println(pname);
		System.out.println(pcoment);
		System.out.println(pprice);
		System.out.println(pdiscount);
		System.out.println(pimg);
		
		
		ProductDto dto = new ProductDto(0 , pname , pcoment , pprice , pdiscount , (byte)0 , pimg , null , 0 );
		System.out.println(dto.toString());
		
	}
	private static final long serialVersionUID = 1L;

    public regist() {
        super();}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	


}
