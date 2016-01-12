/*
 *   산술연산자 
 *     (+ , - , * , / , %)
 *      +,-,* : 형변환
 *      10+20.5
 *     ===
 *     10.0 (큰데이터형으로 변경) ==> 자동 형변환
 *     10.0+20.5 ==> 30.5
 *     
 *     'A'+5
 *     ===
 *     65
 *     65+5=70
 *     
 *     int a=10.5+10.5;
 *     ===== =========
 *       4       8   ==> error
 *     int a=(int)(10.5+10.5) ===> 21
 *                ============
 *             2      1(21.0) ==> 21
 *     int a=(int)10.5+(int)10.5;
 *           =====     =====
 *             10 + 10 ==> 20
 *     /
 *     1) 0으로 나눌 경우에 error 
 *        10/0
 *     2) 정수/정수 = 정수 
 *        10/3 ==> 3
 *        
 *     % : 결과값이 왼쪽 부호가 남는다 
 *         5%2  = 1
 *         -5%2 = -1
 *         -5%-2= -1
 *         5%-2 = 1
 *         
 *         
 *         ==> 데이터형  41페이지
 *         ==> 변수,변수 만들기  42,43페이지
 *         ==> 형변환 64페이지 (자동,강제)
 *             => 자료형의 크기 (67페이지)
 *         ==> 연산자의 종류 (72페이지)
 *         ==> 산술연산자 (74페이지)
 *         ==> 증감연산자 (92페이지,93페이지) 
 */
public class 산술연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*int kor=85;
        int eng=78;
        int math=81;
        int total=kor+eng+math;
        double avg=total/3.0;
        System.out.println("국어점수:"+kor);
        System.out.println("영어점수:"+eng);
        System.out.println("수학점수:"+math);
        System.out.println("총점:"+total);
        //System.out.println("평균:"+avg);
        System.out.printf("평균:%.2f",avg);
        // 서식 : %c(문자) %d(정수) %f(실수) %s(문자열)
*/	
		// *,/ ,% > +,-
	    System.out.println("5%2="+5%2);// 1
	    System.out.println("-5%2="+ -5%2);// -1
	    System.out.println("5%-2="+ 5%-2);//1
	    System.out.println("-5%-2="+ -5%-2);//-1
	    
	    System.out.println("5/2="+5/2);//2
	    System.out.println("10/0="+10/0);
	    
	}

}




