// 정수를 입력을 받아서 구구단을 출력 
/*
 *    3
 *    3*1=3
 *    --
 *    --
 *    3*9=27
 */
import java.util.Scanner;
public class 반복문2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       /*Scanner scan=new Scanner(System.in);
       System.out.print("정수(2~9)입력:");
       int dan=scan.nextInt();
       for(int i=1;i<=9;i++)
       {
    	   System.out.printf("%d*%d=%d\n",dan,i,dan*i);
       }*/
		// for을 이용해서 1~100까지의 정수를 누적한 값을 출력 
		/*int sum=0;
		for(int i=1;i<=100;i++)
		{
			sum+=i;
			System.out.println(i+":"+sum);
		}
		
		System.out.println("sum="+sum);*/
		// 1~100 : 짝수의 합,홀수의 합,전체의 합을 구한다
		int even=0;
		int odd=0;
		int sum=0;
		for(int i=1;i<=100;i++)
		{
			if(i%2==0)
				even+=i;
			/*
			 *   even = 0
			 *   even+=i => even=even+i;
			 *               even=0+2;
			 *               even=2;
			 *              even+=i
			 *              even=even+i
			 *                   ====
			 *                     2  4 => even=6
			 */
			else 
				odd+=i;
			
			sum+=i;
				
				
		}
		System.out.println("1~100의 짝수의 합:"+even);
		System.out.println("1~100의 홀수의 합:"+odd);
		System.out.println("1~100의 전체의 합:"+sum);
		
		int a=0;
		int b=0;
		int c=0;
		for(int i=1;i<=100;i++)
		{
			if(i%3==0)
				a+=i;
			if(i%5==0)
				b+=i;
			if(i%7==0)
				c+=i;
				
		}
		System.out.println("1~100의 3의 배수합:"+a);
		System.out.println("1~100의 5의 배수 합:"+b);
		System.out.println("1~100의 7의 배수 합:"+c);
		
	}

}





