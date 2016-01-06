/*
 *   난수 발생 ==> O,X
 */
import java.util.Scanner;
public class 반복문5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int count=0;
        Scanner scan=new Scanner(System.in);
        for(int i=1;i<=10;i++)
        {
        	int dap=(int)(Math.random()*2);
        	// 0,1
        	System.out.print("X(0),O(1)입력:");
        	int user=scan.nextInt();
        	if(dap==0)
        	{
        		System.out.println("X");
        	}
        	if(dap==1)
        	{
        		System.out.println("O");
        	}
        	if(user==0)
        	{
        		System.out.println("X");
        	}
        	if(user==1)
        	{
        		System.out.println("O");
        	}
        	// 결과값
        	if(dap==user)
        	{
        		count++;
        	}
        }
        System.out.println("채점 결과:"+(count*10)+"점");
	}

}




