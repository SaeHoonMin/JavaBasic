import java.util.Scanner;
public class 문제2번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("국어:");
		int kor=scan.nextInt();
		System.out.print("영어:");
		int eng=scan.nextInt();
		System.out.print("수학:");
		int math=scan.nextInt();
        int total=kor+eng+math;
        double avg=total/3.0;
        System.out.println("국어점수:"+kor);
        System.out.println("영어점수:"+eng);
        System.out.println("수학점수:"+math);
        System.out.println("총점:"+total);
        System.out.printf("평균:%.2f",avg);
	}

}
