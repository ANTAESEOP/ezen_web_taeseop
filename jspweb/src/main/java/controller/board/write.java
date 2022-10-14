package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dto.dao.BoardDao;
import model.dto.dao.MemberDao;

@WebServlet("/board/write")
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	/*	
		String mid = (String)request.getSession().getAttribute("mid"); 
		// 세션호출 getSession() 이용한 mid 세션 호출 + 형변환
		int mno = MemberDao.getInstance().getMno(mid);

		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		System.out.println(btitle);
		System.out.println(bcontent);
		
		boolean result =
		BoardDao.getInstance().write(btitle, bcontent , mno);
		System.out.println(result);
		
		// form 전송용 
			//if(result) {response.sendRedirect("list.jsp");} // 글 작성 성공시 list.jsp 이동
			//else {response.sendRedirect("write.jsp");} // 글 작성 실패시 write.jsp 이동
		 
		// js 전송용
		response.getWriter().print(result);
	*/	
		
	}
    public write() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 첨부파일 [ cos.jar 라이브러리 필요 ]
			// 1. cos.jar 빌드 추가
			// 2. HttpServlerRequest : 첨부파일 지원 X[ 소량의 문자만 지원 ]
			// 3. MultipartRequeste : 첨부파일 지원 O [ 대용량의 문자 가능 ]	
				// 첨부파일 : http post메소드 지원
			// new MultipartRequest( 1. 요청방식 , 2. 파일저장경로 , 3. 최대용량범위 , 4. 인코딩타입 5. 기타(보안가능) )
		
		// 1. 저장경로 [ 프로젝트 저장 ]
		String uploadpath = "C:\\Users\\504\\git\\ezen_web_taeseop\\jspweb\\src\\main\\webapp\\upload";
		
		// 2. Multipart 객체 생성
		MultipartRequest multi = new MultipartRequest(
			request , 						// 1. 요청 방식
			uploadpath , 					// 2. 저장 경로
			1024 * 1024 * 10, 				// 1MB [ 1024 : 1KB / 1024 * 1024 : 1MB / 1024*1024*1024 : 1GB ]
			"UTF-8", 						// 한글 인코딩
			new DefaultFileRenamePolicy() 	// 5. 업로드된 파일의 이름이 중복일경우 자동 이름 변경
		); // 생성자 end
		
		// 3. 해당 저장경로에 첨부파일 업로드가 된다.
		
		// 4. 나머지 데이터를 직접 요청
		String btitle = multi.getParameter("btitle"); // request -> multi
			System.out.println(btitle); // 확인
		String bcontent = multi.getParameter("bcontent");
			System.out.println(bcontent); // 확인
		response.getWriter().print("확인");
		// * 어떤 파일을 업로드 했는지 db에 저장 할 첨부파일 경로 / 이름 
		String bfile = multi.getFilesystemName("bfile");
			System.out.println(bfile);
			// * 회원아이디 ---> 회원번호
		int mno = MemberDao.getInstance().getMno( (String)request.getSession().getAttribute("mid"));	
		
		// 5. db 처리
		boolean result
			= BoardDao.getInstance().write(btitle, bcontent, mno , bfile);
		// 6. 응답
		response.getWriter().print(result);
	}

}
