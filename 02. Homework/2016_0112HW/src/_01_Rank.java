
public class _01_Rank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []score  = new int[5];
		int []rank	= new int[5];
		
		for(int i=0; i<5;i++)
		{
			System.out.print((i+1)+"번째 학생 점수 입력 : ");
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
		System.out.println("\t학생1\t학생2\t학생3\t학생4\t학생5");
		System.out.print("점수 : ");
		for(int i=0; i<5;i++)
		{
			System.out.printf("\t%d",score[i]);
		}
		System.out.print("\n등수 : ");
		for(int i=0; i<5;i++)
		{
			System.out.printf("\t%d",rank[i]+1);
		}
	}

}
