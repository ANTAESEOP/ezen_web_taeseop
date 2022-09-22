package ch13컬렉션프레임워크;

import java.util.Vector;

public class Ex2_vector {
	
	public static void main(String[] args) {
		
		Vector<Board> list = new Vector<>();
		
		list.add( new Board("제목1" , "내용1" , "글쓴이1"));
		list.add( new Board("제목2" , "내용2" , "글쓴이2"));
		list.add( new Board("제목3" , "내용3" , "글쓴이3"));
		list.add( new Board("제목4" , "내용4" , "글쓴이4"));
		list.add( new Board("제목5" , "내용5" , "글쓴이5"));
		
		for( Board b : list) {
			System.out.println(b.subject + "\t" + b.content + "\t" + b.writer);
		}
		
		list.remove(2);		// 2번 인덱스 삭제		제목3
		list.remove(3);		// 3번 인덱스 삭제		제목5
		
		System.out.println("---------------------");
		for( Board b : list) {
			System.out.println(b.subject + "\t" + b.content + "\t" + b.writer);
		}
	}
	

}
/*

	ArrayList <---> Vector
	동기화 X 			동기화O
	단일실행			멀티실행
					안정성보장
					
	동기화 : 특정 메소드의 하나의 쓰레드만 사용 가능하도록 대기상태
	
	list.add( new Board("제목1" , "내용1" , "글쓴이1")); // 바로 집어넣냐
		
	Board board = new Board("제목2" , "내용2" , "글쓴이2"); // 객체를 만들어 집어넣냐
	list.add( board );
		




*/