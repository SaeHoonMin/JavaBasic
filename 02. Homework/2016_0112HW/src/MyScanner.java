import java.util.Scanner;

public class MyScanner {
	static MyScanner mInstance;
	static Scanner s;
	
	public static int nextInt()
	{
		if(mInstance==null)
		{
			mInstance = new MyScanner();
			s	= new Scanner(System.in);
		}
		return s.nextInt();
	}
}
