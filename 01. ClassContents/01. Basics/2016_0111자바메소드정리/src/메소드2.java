import java.util.Scanner;

/*
 * 
 * 
 * 		[0] [1][2][3] [4]
 * 		===================
 * 				1
 * 		===================
 * 			2	3	4
 * 		===================
 * 		5	6	7	8	9
 * 		===================
 * 			10	11	12
 * 		===================
 * 				13
 * 
 * 		0		2-2
 * 		1		1-3
 * 		2		0-4
 * 		3		1-3
 * 		4		2-2
 * 
 */
public class �޼ҵ�2 {
	public static void main(String []args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("n*n �迭 ũ�� �Է� (Ȧ����): ");
		
		int size = scan.nextInt();
		if(size%2==0)
			size++;				//����ó��
		int half = size/2;
		int [][] arr = new int [size][size];
		int k=1;
		
		for(int i=0;i<size;i++)
		{
			for(int j= Math.abs(half-i) ; j < Math.abs(half-i)*-1 + size ;j++)
			{
				arr[i][j]=k;
				k++;
			}
		}
		
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				if(arr[i][j]==0)
					System.out.print("\t");
				else
					System.out.print(arr[i][j]+"\t");
			}
			//�ٰ���
			System.out.println("\n");
		}
	}
}
