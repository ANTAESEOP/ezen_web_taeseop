package controller.board;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dto.dao.BoardDao;
import model.dto.dto.BoardDto;


@WebServlet("/board/bupdate")
public class bupdate extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 서버 내 업로드 폴더 경로 찾기
		String uploadpath = request.getSession().getServletContext().getRealPath("/upload");
		// 2. MultipartRequest 객체
		MultipartRequest multi = new MultipartRequest(
				request, 
				uploadpath,
				1024*1024*10,
				new DefaultFileRenamePolicy() );
		
		// 3. 요청
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
			
		// * 수정할 게시물의 번호
		int bno = (Integer)request.getSession().getAttribute("bno");
		
		BoardDto dto = BoardDao.getInstance().getboard(bno);
				
		// * 기존 첨부파일 변경 여부 판단
		boolean bfilechange = true;
		
		if( bfile == null ) { bfile = dto.getBfile(); bfilechange = false; } // 2. * 수정시 첨부파일 등록이 없을경우 [ 기존 첨부파일 등록 ]
		
		// 4. dao 처리
		boolean result = BoardDao.getInstance().bupdate(bno , btitle , bcontent , bfile);
		if (result) {
			if(bfilechange) {
				String deletepath = request.getSession().getServletContext().getRealPath("/upload/"+ dto.getBfile());
				File file = new File(deletepath); if( file.exists() ) file.delete();
			}
		}
		// 5. 결과 반환
		response.getWriter().print(result);

		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	private static final long serialVersionUID = 1L;

    public bupdate() {
        super();
        // TODO Auto-generated constructor stub
    }


}
