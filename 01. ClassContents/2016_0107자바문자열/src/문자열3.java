import java.util.Scanner;

public class 문자열3 {
	
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
				return "0으로 나누기 오류";
			res = Integer.toString(a/b);
			break;
		default:		
			res = "잘못된 오퍼랜드";
		}
		return res;
	}
	public static void process()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("첫 번째 정수 입력 : ");
		int a= scan.nextInt();
		System.out.print("연산자 입력(+,-,*,/) : ");
		String op = scan.next();
		System.out.print("두 번째 정수 입력 : ");
		int b = scan.nextInt();
		
		System.out.println(calc(a,b,op.charAt(0)));
	}
	
	public static void main(String [] args)
	{
		process();
	}

}
