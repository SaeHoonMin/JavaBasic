
public class MainClass2 {
	void dataInput(int [] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = (int) (Math.random()*100)+1;
		}
	}
	
	void swap(String str)
	{
		str.replace('l', 'H');
		System.out.println(str);
	}
	
	void process()
	{
		int [] arr={1,2,3,4,5};
		dataInput(arr);
		for(int e:arr)
			System.out.print(e+ " ");
		
		String str = " Hello ";
		swap(str);
		System.out.println(str);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainClass2 mc2 = new MainClass2();
		
		mc2.process();
	}

}
