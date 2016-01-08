/*
 * 
 *	문자열 ==> 문자 여러개 묶어서 사용
 *			char []  ==> 조작해서 만든 클래스: String
 *
 *	사용 형식
 *		String 변수명 = "값";
 *		------ ---
 *		 클래스	객체	  객체변수값 => 객체 : 사용자 정의 데이터형에 대한 변수명
 *
 *		String 변수명 = new String("값");
 *					 ===
 *					새로운 메모리 생성 =>저장
 *					new => System.gc();
 *
 *		String str = new String("Java");
 *
 *		자바 메메모리
 *		
 *		========================
 *		 메소드 영역
 *		========================
 *  	스택		지역변수, 파라미터
 *		========================
 *		힙 		new로 할당, gc가 해제
 *		========================
 * 
 * 		String str = new String ("java");
 * 		===stack===  ===heap===
 * 		   str			(java)
 * 		   100			200
 * 		========== 	 ==========
 * 		참조변수 : 배열, String
 * 
 * 	String : 데이터형, 기능 
 * 	1)	equals					: 문자열 비교  equalsIgnoreCase :대소문자구분x
 * 	2)	length					: 문자 개수
 *  3)	substring				: 문자 분해
 *  4)	split					: 문자 분해
 *  5)	stratsWith, endsWith	: 자동완성기
 *  6)	trim					: 좌, 우 공백 제거
 *  7)	indexOf, lastIndexOf	: 원하는 위치의 문자 위치
 *  8)	replace					: 다른 값으로 변경
 *  9)	valueOf					: 모든 데이터형을 문자열로 변경
 *  10)	charAt					: 해당 문자열에서 문자 한개를 가지고 올때
 * 
 */

public class 문자열 {
	public static void main(String [] args)
	{
		String str = "hello";
		String str1= "hello";
		String str2 = new String("Hello");
		if(str==str1)
			System.out.println("str 과  str1은 같다.(주소)");
		if(str==str2)
			System.out.println("str 과  str2는 같다.(주소)");
		else
			System.out.println("다르다");
		
		if(str.equalsIgnoreCase(str2))
			System.out.println("str 과 str2는 같다 (문자열)");
		
	}
}
