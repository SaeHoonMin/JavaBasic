/*
 *     국어,영어 수학 => 입력받아서 총점,평균 
 *     => 산술연산자 
 *        = +
 *        = -
 *        = *
 *        ================== 형변환 (큰데이터형으로 변경)
 *        = /   : 정수/정수=정수 ( 소수점: 정수/실수)
 *        = %   : 부호 관리 (왼쪽편 부호)
 */
import java.util.Scanner;
public class 문제1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *   변수는 같은 블럭상에서 중복된 이름을 사용할 수 없다
		 *   ==> 변수는 블럭안에서만 사용이 가능 
		 *       블럭변수,지역변수 
		 */
        Scanner scan=new Scanner(System.in);
        System.out.print("국어점수 입력:");
        int kor=scan.nextInt();
        System.out.print("영어점수 입력:");
        int eng=scan.nextInt();
        System.out.print("수학점수 입력:");
        int math=scan.nextInt();
        // 처리 
        int total=kor+eng+math;
        double avg=total/3.0;
        // 출력 
        System.out.println("국어:"+kor);
        System.out.println("영어:"+eng);
        System.out.println("수학:"+math);
        System.out.println("총점:"+total);
        System.out.printf("평균:%.2f",avg);
	}

}



