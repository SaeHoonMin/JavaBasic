import java.util.Scanner;

//charAt
/*
 * 
 * 	String str = "abcdef" ;
 * 	char c = str.charAt(1);
 *  c==>b
 * 
 */
public class ���ڿ�2 {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("���ڿ� �Է� : ");
		String str = scan.nextLine();
		int count = 0;
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='a' || str.charAt(i)=='A')
				count++;
		}
		System.out.println("count :"+count);
	}
}
