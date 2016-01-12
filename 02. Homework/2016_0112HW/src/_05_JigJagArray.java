
public class _05_JigJagArray {
	public static void main(String[] str)
	{
		int [][]arr=new int[5][5];
		int begin = 0, end = 4, sw=1;
		int k=1;
		for(int i=0;i<5;i++)
		{
			for(int j = begin ; ((i%2==0)? (j<=end) : (j>=end)) ; j+=sw)
				arr[i][j] = k++;
			int temp  = begin;
			begin = end;
			end= temp;
			sw *=-1;
			
		}
		
		for(int [] e : arr)
		{
			for(int f: e)
				System.out.printf("%3d",f);
			System.out.println();
		}
	}
}
