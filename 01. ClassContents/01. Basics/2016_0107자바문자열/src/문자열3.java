import java.util.Scanner;

public class ���ڿ�3 {
	
	static String calc(int a, int b, char op)
	{
		String res = new String();
		
		switch(op)
		{
		case '+':
			res = String.valueOf(a+b);
			break;
		case '-':
			res = String.valueOf(a-b);
			break;
		case '*':
			res = Integer.toString(a*b);
			break;
		case '/':
			if(b==0)
				return "0���� ������ ����";
			res = Integer.toString(a/b);
			break;
		default:		
			res = "�߸��� ���۷���";
		}
		return res;
	}
	public static void process()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("ù ��° ���� �Է� : ");
		int a= scan.nextInt();
		System.out.print("������ �Է�(+,-,*,/) : ");
		String op = scan.next();
		System.out.print("�� ��° ���� �Է� : ");
		int b = scan.nextInt();
		
		System.out.println(calc(a,b,op.charAt(0)));
	}
	
	public static void main(String [] args)
	{
		process();
	}

}
