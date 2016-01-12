
public class _06_SnailArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr = new int [5][5];
		int k=1,sw=1,n=5;
		int i=0,j=-1;
		while(true)
		{
			for(int p =0; p<n; p++)
			{
				j+=sw;
				arr[i][j]=k++;
			}
			n--;
			
			if(n==0)
				break;
			for(int p=0;p<n;p++)
			{
				i+=sw;
				arr[i][j]=k++;
			}
			sw*=-1;
		}
		
		for(int [] e : arr)
		{
			for(int f: e)
				System.out.printf("%3d",f);
			System.out.println();
		}
	}

}
