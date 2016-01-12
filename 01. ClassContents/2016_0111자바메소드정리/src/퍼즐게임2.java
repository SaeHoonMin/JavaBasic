/*
 *    기능 
 *    1) 난수  ==> 배열 저장 
 *    2) 출력  ==> 출력 (배열)
 *    3) 입력  ==> 정수
 *    4) 종료  ==> 배열의 순서  
 *    5) 조립 
 *    
 *    변수
 *     1) 변수의 종류 
 *                   메모리위치   메모리 저장 시점
 *        ==============================
 *          static     method 컴파일시에 자동 (클래스 전체)
 *             ==> 공통변수 , 클래스 변수 
 *                 클래스이름.변수명
 *                 ==> 메모리 공간 1개 
 *        ==============================
 *          instance    heap  new연산자 사용시에 
 *                             (클래스 전체)
 *             ==> 객체 변수 
 *                 객체이름.변수명 
 *                 ==> new사용 갯수만큼 생성 
 *        ==============================
 *          local       stack  메소드호출시 
 *                             (메소드 영역에서만)
 *            ==> 지역변수 
 *        ==============================
 */
import java.util.Scanner;
public class 퍼즐게임 {
    static int[][] panCount=new int[3][3];
    static int brow,bcol;
    // 멤버변수 => 자동으로 초기화 (int=0,String=null..)
    // 난수 발생 
    static void getRand()
    {
    	int[] temp=new int[9];
    	int su=0;
    	boolean bDash=false;
    	for(int i=0;i<9;i++)
    	{
    		bDash=true;
    		while(bDash)
    		{
    			// 난수 발생 
    			su=(int)(Math.random()*9);
    			bDash=false;
    			for(int j=0;j<i;j++)
    			{
    				if(temp[j]==su)
    				{
    					bDash=true;//while이동
    					break;
    				}
    			}
    		}
    		temp[i]=su;
    		panCount[i/3][i%3]=temp[i];
    		if(su==8)
    		{
    			brow=i/3;
    			bcol=i%3;
    		}
    		/*
    		 *    =======================
    		 *      0        1     2
    		 *    0/3,0%3  1/3 1%3 2/3 2%3
    		 *      00      01      02
    		 *    =======================
    		 *      3        4      5
    		 *    3/3 3%3  4/3 4%3 5/3 5%3
    		 *      10      11      12
    		 *    =======================
    		 *      6
    		 *    6/3 6%3  7/3 7%3  8/3 8%3
    		 *      20      21       22
    		 *      
    		 *      2*3+0  2*3+1     2*3+2
    		 *    =======================
    		 * 
    		 */
    		
    	}
    }
    static void display()
    {
    	for(int i=0;i<3;i++)
    	{
    		for(int j=0;j<3;j++)
    		{
    			if(i==brow && j==bcol)
    				System.out.print("  ");
    			else
    				System.out.print((panCount[i][j]+1)+" ");
    		}
    		System.out.println();
    	}
    }
    static void process()
    {
    	getRand();
    	display();
    	Scanner scan=new Scanner(System.in);
    	while(true)
    	{
    		System.out.print("1~8까지 정수입력:");
    		int input=scan.nextInt();
    		int a=0; b=0;
    		for(int i=0;i<3;i++)
    		{
    			for(int j=0;j<3;j++)
    			{
    				if((panCount[i][j])==input)
    				{
    					panCount[brow][bcol]=
    							panCount[i][j];
    					panCount[i][j]=0;
    					a=i;
    					b=j;
    					display();
    					break;
    				}
    			}
    		}
    		brow=a;
    		bcol=b;
    		panCount[a][b]=input;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        process();
	}

}




