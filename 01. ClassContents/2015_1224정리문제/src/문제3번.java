import java.util.Scanner;
public class ����3�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("ù��° �Ǽ�:");
		double d1=scan.nextDouble();
		System.out.print("�ι�° �Ǽ�:");
		double d2=scan.nextDouble();
		System.out.println("***** Result *****");
		System.out.printf("%.2f+%.2f=%.2f\n",d1,d2,d1+d2);
		System.out.printf("%.2f-%.2f=%.2f\n",d1,d2,d1-d2);
		System.out.printf("%.2f*%.2f=%.2f\n",d1,d2,d1*d2);
	}

}
