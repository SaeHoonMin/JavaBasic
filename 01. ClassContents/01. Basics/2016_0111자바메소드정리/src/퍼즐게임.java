import java.util.Scanner;

/*
 * 
 * 
 * 	���
 * 	1)	����
 * 	2)	���
 * 	3)	�Է�
 * 	4)	����
 * 	5)	����
 * 
 * 
 * 	����
 * 	1)	������ ����		�޸� ��ġ		�޸� ���� ����
 * 		=============================
 * 		static		method		������ �� �ڵ�
 * 			=>���뺯��, Ŭ��������		(Ŭ���� ��ü)
 * 			  Ŭ�����̸�.������
 * 		=============================
 * 		instance	heap		new ������ ����
 * 								(Ŭ���� ��ü)
 *			=>��ü����
 *			    ��ü�̸�.������
 * 		===============================
 * 		local		stack		�޼ҵ� ȣ�� ��
 * 
 */
public class ������� {

	static int [][] panCount = new int[3][3];
	static int brow, bcol;
	
	//���� �߻�
	static void getRand()
	{
		int [] temp = new int[9];
		int su =0;
		
		for(int i=0;i<9;i++)
		{
			temp[i] = (int)(Math.random()*9);
			panCount[i/3][i%3] = temp[i];
		    for(int j=0;j<i;j++)
		    {
		    	if(temp[j]==temp[i])
		    		i--;
		    }
		}

	}
	static void display()
	{
		for(int i=0;i<panCount.length;i++)
		{
			for(int j=0;j<panCount[i].length;j++)
			{
				if(panCount[i][j]!=0)
					System.out.printf("%2d",panCount[i][j]);
				else
				{
					System.out.printf("  ");
					brow=i;
					bcol=j;
				}
			}
			System.out.println();
		}

	}
	
	static boolean isEnd()
	{
		int k=0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(panCount[i][j]!=k)
					return false;
				k++;
			}
		}
		return true;
	}
	
	static void process()
	{
		getRand();
		display();
		Scanner scan = new Scanner(System.in);
		while(true)
		{
			System.out.print("1~8 ���� ���� �Է� :");
			int input = scan.nextInt();
			
			int a=0, b=0;
			
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					if(panCount[i][j]==input)
					{
						panCount[i][j]=0;
						a=i;
						b=j;
					}
				}
			}
			panCount[brow][bcol] = input;
			brow = a;
			bcol = b;

			if(isEnd())
			{
				display();
				System.out.println("the end");
				return;
			}
			
				
			display();
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process();
	}

}
