
public class _01_Rank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []score  = new int[5];
		int []rank	= new int[5];
		
		for(int i=0; i<5;i++)
		{
			System.out.print((i+1)+"��° �л� ���� �Է� : ");
			score[i] = MyScanner.nextInt();
		}
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(score[i]<score[j])
					rank[i]++;
			}
		}
		System.out.println("\t�л�1\t�л�2\t�л�3\t�л�4\t�л�5");
		System.out.print("���� : ");
		for(int i=0; i<5;i++)
		{
			System.out.printf("\t%d",score[i]);
		}
		System.out.print("\n��� : ");
		for(int i=0; i<5;i++)
		{
			System.out.printf("\t%d",rank[i]+1);
		}
	}

}
