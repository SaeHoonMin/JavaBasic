/*
 * 
 * startsWith	
 * endsWith		==> boolean
 * 
 */
import java.util.Scanner;
public class ���ڿ�3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] data = {
				"java Program",
				"java end jsp",
				"ajax and html",
				"oracle and java",
				"oracle program"
		};
		Scanner scan = new Scanner(System.in);
		System.out.print("�˻��� �Է� :");
		String find = scan.next();
		for(int i=0; i<data.length;i++)
		{
			if(data[i].startsWith(find))
			{
				System.out.println(data[i]);
			}
			else if(data[i].endsWith(find))
				System.out.println(data[i]);
		}
	}

}
