import java.util.Scanner;
public class ����6�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("���� �Է�:");
        int age=scan.nextInt();
        if(age>=19)
        {
        	System.out.println("��ȭ�� ������ �� �ֽ��ϴ�");
        }
        if(age>=15 && age<19)
        {
        	System.out.println("������ ������ ��� ��ȭ�� ������ �� �ֽ��ϴ�");
        }
        if(age<15)
        {
        	System.out.println("��ȭ�� ���� �� �� �����ϴ�");
        }
	}

}
