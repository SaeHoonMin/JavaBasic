/*
 *     ����,���� ���� => �Է¹޾Ƽ� ����,��� 
 *     => ��������� 
 *        = +
 *        = -
 *        = *
 *        ================== ����ȯ (ū������������ ����)
 *        = /   : ����/����=���� ( �Ҽ���: ����/�Ǽ�)
 *        = %   : ��ȣ ���� (������ ��ȣ)
 */
import java.util.Scanner;
public class ����1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *   ������ ���� ���󿡼� �ߺ��� �̸��� ����� �� ����
		 *   ==> ������ ���ȿ����� ����� ���� 
		 *       ������,�������� 
		 */
        Scanner scan=new Scanner(System.in);
        System.out.print("�������� �Է�:");
        int kor=scan.nextInt();
        System.out.print("�������� �Է�:");
        int eng=scan.nextInt();
        System.out.print("�������� �Է�:");
        int math=scan.nextInt();
        // ó�� 
        int total=kor+eng+math;
        double avg=total/3.0;
        // ��� 
        System.out.println("����:"+kor);
        System.out.println("����:"+eng);
        System.out.println("����:"+math);
        System.out.println("����:"+total);
        System.out.printf("���:%.2f",avg);
	}

}



