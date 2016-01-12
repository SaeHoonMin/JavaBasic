/*
 *    1~100까지 난수 발생 
 *    난수를 맞추는 프로그램 
 */
import java.util.Scanner;
public class 메소드5 {
    static int getRand()
    {
    	//int rand=(int)(Math.random()*100)+1;
    	return (int)(Math.random()*100)+1;
    }
    static int input()
    {
    	Scanner scan=new Scanner(System.in);
    	System.out.print("1~100까지 사이의 정수 입력:");
    	return scan.nextInt();
    }
    static boolean hint(int com,int user)
    {
    	boolean bCheck=false;
    	if(com>user)
    	{
    		System.out.println("입력값보다 큰 값 입력...");
    	}
    	else if(com<user)
    	{
    		System.out.println("입력값보다 작은 값 입력...");
    	}
    	else
    	{
    		bCheck=true;
    	}
    	return bCheck;
    }
    static void process()
    {
    	int com=getRand();
    	while(true)
    	{
    		int user=input();
    		boolean bCheck=hint(com,user);
    		if(bCheck==true)
    		{
    			System.out.println("게임을 다시할까요(yes(1)/no(2))?");
    			Scanner scan=new Scanner(System.in);
    			int res=scan.nextInt();
    			if(res==1)
    			{
    				process();
    			}
    			else
    			{
    				System.out.println("Game Over!!");
    				System.exit(0);// 프로그램을 완전 종료
    			}
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        process();
	}

}
