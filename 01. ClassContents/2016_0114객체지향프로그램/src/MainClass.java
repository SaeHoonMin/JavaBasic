
public class MainClass {

	void swap(int a, int b)
	{
		System.out.println("������ : " + a + " "+b);
		int temp = a;
		a = b;
		b = temp; 
		System.out.println("������ : " + a + " "+b);
	}
	void swap2(int [] arr)
	{
		System.out.println();
	}
	void process()
	{
		int a= 10;
		int b= 20;
		swap(a,b);
		System.out.println("���� ������ : ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
