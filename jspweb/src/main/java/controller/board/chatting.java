package controller.board;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

// @WebServlet("/board/chatting")	// 서블릿 URL 만들기
@ServerEndpoint("/chatting/{mid}") 		// 웹 서버에 웹 소켓 URL 만들기
public class chatting {
	// 서버소켓 들어온 클레이언트 소켓 명단 ( 세션 )
		// arraylist vs Vector [ 동기화 ㄴ vs 동기화 ㅇ ]
	public static Hashtable<Session , String> clients = new Hashtable<>();
	@OnOpen		// 서버 소켓이 들어 왔을 때 [ Session = 클라이언트소켓 = 접속된 유저 ]
	public void OnOpen ( Session session , @PathParam("mid") String mid ) throws IOException { // @PathParam(경로상의변수명) : 경로상의 변수 호출
		clients.put(session, mid); // 접속된 클라이언트 소켓을 저장
		
		// 접속했다고 다른 사람에게 알리기
		for(Session s : clients.keySet() ) { // map 저장된 모든 key 호출 [ .ketSet() ]
			s.getBasicRemote().sendText(clients.get(s) + "님이 접속 했습니다.");
		}
		
		System.out.println(mid + "님이 접속 했습니다.");	
	}// System.out.println(session); // session 접속마다 자동할당 = 식별불가 X
	
	@OnClose	// 서버 소켓을 나갔을 때 [ 서버소켓[서버가 재부팅 / 시작 ] 꺼지나 클라이언트 소켓이 닫기 요청
	public void OnClose ( Session session ) {
		// 1. 종료된 세션을 접속명단에서 제거
		clients.remove(session); // map객체명.remove(key) : 해당 key의 엔트리 삭제
		
		
		
		
	}
	@OnMessage	// 서버 소켓에 메세지 왔을 때
	public void OnMessage( Session session , String msg ) throws IOException {
		for( Session s : clients.keySet()) {
			// 접속된 클라이언트 소켓을 하나씩 호출
			s.getBasicRemote().sendText(msg);
		}
	}
}
