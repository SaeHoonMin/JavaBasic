import java.util.Scanner;
public class 문제3번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("첫번째 실수:");
		double d1=scan.nextDouble();
		System.out.print("두번째 실수:");
		double d2=scan.nextDouble();
		System.out.println("***** Result *****");
		System.out.printf("%.2f+%.2f=%.2f\n",d1,d2,d1+d2);
		System.out.printf("%.2f-%.2f=%.2f\n",d1,d2,d1-d2);
		System.out.printf("%.2f*%.2f=%.2f\n",d1,d2,d1*d2);
	}

}
