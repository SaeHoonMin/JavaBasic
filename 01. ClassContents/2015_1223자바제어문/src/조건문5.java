/*
 *   선택 IF
 *     형식)
 *         if(조건문)  조건문 (true/false)
 *           문장1 ==> true일때 수행 
 *         else
 *           문장2 ==> false일때 수행
 *           
 *         if(조건문)
 *         {
 *           문장1
 *           문장2
 *         }
 *         else
 *         {
 *           문장3
 *           문장4
 *         }
 *         
 */
import java.util.Scanner;
public class 조건문5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("1~100사이의 정수 입력:");
        int num=scan.nextInt();
        if(num<1 || num>100)
        {
        	System.out.println("잘못된 입력입니다");
        }
        else // 정상 입력이면 
        {
        	//System.out.println("정상 입력입니다");
        	if(num%2==0)
        	{
        		System.out.println(num+"는(은) 짝수다");
        	}
        	else
        	{
        		System.out.println(num+"는(은) 홀수다");
        	}
        }
	}

}




