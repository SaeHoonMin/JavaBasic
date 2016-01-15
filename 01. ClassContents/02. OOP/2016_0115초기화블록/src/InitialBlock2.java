
public class InitialBlock2 {
	static int a=0;
	static{
		for(int i=0;i<10;i++)
			a+=i;
	}
	public static void main(String [] args)
	{
		System.out.println(a);
	}
}
