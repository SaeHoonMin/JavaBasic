import java.util.Scanner;
public class ����2�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("����:");
		int kor=scan.nextInt();
		System.out.print("����:");
		int eng=scan.nextInt();
		System.out.print("����:");
		int math=scan.nextInt();
        int total=kor+eng+math;
        double avg=total/3.0;
        System.out.println("��������:"+kor);
        System.out.println("��������:"+eng);
        System.out.println("��������:"+math);
        System.out.println("����:"+total);
        System.out.printf("���:%.2f",avg);
	}

}
