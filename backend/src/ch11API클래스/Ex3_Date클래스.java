package ch11API클래스;

import java.util.Date;

import javax.print.CancelablePrintJob;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Ex3_Date클래스 {
	
	public static void main(String[] args) {
		
		// 1. Date 클래스 : 현재 날짜 / 시간 호출
		Date now = new Date();					System.out.println( now );
		String strNow1 = now.toString(); 		System.out.println( strNow1 );
		
		// 2. SimpleDateFormat() : 날짜 / 시간 형식[모양] 변환
			// 1. new SimpleDateFormat 변수명 = new SimpleDateFormat( " 형식 " )
			// 2. 객체명.format( 데이터 )
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String strNow2 = sdf.format( new Date() );
		System.out.println(strNow2);
		
		// 3. Calendar 클래스
		Calendar cal = Calendar.getInstance(); // 운영체제에서 설정되어 있는 시간대 날짜와 시간의 정보를 호출
				// 객체명.get( 해당 필드명 )
					// 번호 : Calendar.필드 => Calendar.YEAR -> 1
		int year = cal.get(1);							System.out.println(year);
		int month = cal.get(Calendar.MONTH);			System.out.println(month);
						// 1월[0] 2월[1] 3월 [2] 4월 [3] 5월[4] ~~ 12월[11]
		int day = cal.get(Calendar.DAY_OF_MONTH) + 1;	System.out.println(day);
		
		int week = cal.get(Calendar.DAY_OF_WEEK);		System.out.println(week);
						// 일[1] 월[2] 화[3] 수[4] 목[5] 금[6] 토[7]
		String strWeek = null;
		switch ( week ) {
			case Calendar.MONDAY 	: strWeek = "월"; break; // case 1 : strWeek = "월"; break;
			case Calendar.TUESDAY 	: strWeek = "화"; break; // case 2 : strWeek = "화"; break;
			case Calendar.WEDNESDAY : strWeek = "수"; break; // case 3 : strWeek = "수"; break;
			case Calendar.THURSDAY 	: strWeek = "목"; break; // case 4 : strWeek = "목"; break;
			case Calendar.FRIDAY 	: strWeek = "금"; break; // case 5 : strWeek = "금"; break;
			case Calendar.SATURDAY 	: strWeek = "토"; break; // case 6 : strWeek = "토"; break;
			case Calendar.SUNDAY 	: strWeek = "일"; break; // case 7 : strWeek = "일"; break;
			default:
		}
		System.out.println( strWeek );
		
		int amPm = cal.get(Calendar.AM_PM);				System.out.println(amPm);
						// 오전[0]	오후[1]
		if( amPm == Calendar.AM) {System.out.println("오전");}
		else {System.out.println("오후");}
		
		int hour = cal.get(Calendar.HOUR);				System.out.println(hour);
		int minute = cal.get(Calendar.MINUTE);			System.out.println(minute);
		int second = cal.get(Calendar.SECOND);			System.out.println(second);
		
		// 다른 클래스의 메소드 호출하는 방법
		// 1. static 정적맴버일 경우 : 클래스명.메소드
		// 2. new 객체 생성 -> 객체명.메소드명
		// 3. 싱글톤 -> 클래스명.get싱글톤.메소드명 (getInstance();)
			// * 현재 클래스의 메소드 호출시 : 메소드명() 
		new Ex4_달력().run();
		
		// Ex4_달력 ex = new Ex4_달력();
		// ex.run();
		
		
		
		
		
		
		
		
		
		

	}
}
