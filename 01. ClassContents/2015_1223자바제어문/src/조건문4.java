import java.util.Scanner;
public class 조건문4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("국어점수 입력:");
        int kor=scan.nextInt();
        System.out.print("수학점수 입력:");
        int math=scan.nextInt();
        System.out.print("영어점수 입력:");
        int eng=scan.nextInt();
        // 총점 
        int total=kor+math+eng;
        // 평균
        double avg=total/3.0;
        // 출력
        System.out.println("총점:"+total);
        System.out.printf("평균:%.2f\n",avg);
        /*
         *     \n => new Line
         *     \t => 일정 간격
         */
        // 학점
        if(kor>=90 && kor<=100)
        	System.out.println("국어 학점:A");
        if(kor>=80 && kor<90)
        	System.out.println("국어 학점:B");
        if(kor>=70 && kor<80)
        	System.out.println("국어 학점:C");
        if(kor>=60 && kor<70)
        	System.out.println("국어 학점:D");
        if(kor<60)
        	System.out.println("국어 학점:F");
	}

}




