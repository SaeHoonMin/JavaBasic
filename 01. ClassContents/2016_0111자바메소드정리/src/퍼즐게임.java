import java.util.Scanner;

/*
 * 
 * 
 * 	기능
 * 	1)	난수
 * 	2)	출력
 * 	3)	입력
 * 	4)	종료
 * 	5)	조립
 * 
 * 
 * 	변수
 * 	1)	변수의 종류		메모리 위치		메모리 저장 시점
 * 		=============================
 * 		static		method		컴파일 시 자동
 * 			=>공통변수, 클래스변수		(클래스 전체)
 * 			  클래스이름.변수명
 * 		=============================
 * 		instance	heap		new 연산자 사용시
 * 								(클래스 전체)
 *			=>객체변수
 *			    객체이름.변수명
 * 		===============================
 * 		local		stack		메소드 호출 시
 * 
 */
public class 퍼즐게임 {

	static int [][] panCount = new int[3][3];
	static int brow, bcol;
	
	//난수 발생
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
			System.out.print("1~8 까지 정수 입력 :");
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
