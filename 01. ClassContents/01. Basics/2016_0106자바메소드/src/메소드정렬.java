import sun.security.util.Length;

public class 메소드정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= new int[10];
	
			
		
		System.out.print("정렬 전 : ");
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = (int)(Math.random()*100)+1;
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		
		bubbleSort(arr);
		selectionSort(arr);
		insertionSort(arr);
		
	}
	
	static int[] copyArray(int [] arrp)
	{
		int [] arr = new int[arrp.length];
		for(int i=0;i<arr.length;i++)
			arr[i]=arrp[i];
		return arr;
	}
	
	static void insertionSort(int [] arrp)
	{
		int [] arr =copyArray(arrp);
		
		int min=0;
		
		for(int i=0; i<arr.length-1; i++)
		{
			min=i;
			for(int j=i+1; j<arr.length;j++)
			{
				if(arr[min]>arr[j])
				{
					min=j;
				}
			}
			if(min!=i)
			{
				int t = arr[min];
				arr[min] = arr[i];
				arr[i] = t;
			}
		}
		
		System.out.println("after insertionSort:");
		for(int e : arr)
			System.out.print(e+" ");
		System.out.println();
	}
	
	static void selectionSort(int [] arrp)
	{
		int [] arr= copyArray(arrp);
		
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		System.out.println("after selectionSort:");
		for(int e : arr)
			System.out.print(e+" ");
		System.out.println();
	}
	
	static void bubbleSort(int [] arrp)
	{
		int [] arr = copyArray(arrp);
		

		
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=0;j<arr.length-1-i;j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println("after BubbleSort:");
		for(int e : arr)
			System.out.print(e+" ");
		System.out.println();
	}

}
