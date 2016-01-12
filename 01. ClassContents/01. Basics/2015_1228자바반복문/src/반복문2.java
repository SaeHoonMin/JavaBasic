// while문 
// 단을 입력받아서 => 해당 단을 출력 
// 입력값 
import java.util.Scanner;
public class 반복문2 {
    static void gugudan()
    {
    	Scanner scan=new Scanner(System.in);
		System.out.print("단 입력:");
		int dan=scan.nextInt();
		// 단을 받아서 구구단 출력 
		System.out.println("while처리");
		int i=1;
		while(i<=9)
		{
			System.out.println(dan+"*"+i+"="+dan*i);
			i++;
		}
		System.out.println("do~while처리");
		i=1; // int j=1;
		do
		{
			System.out.println(dan+"*"+i+"="+dan*i);
			i++;
		}while(i<=9);
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 단을 입력해라 
		//gugudan();
		//gugudan();
		// 변수 ==> 사용후에 다시 사용이 가능 
		/*
		 *   int i=10;
		 *   
		 *   i=5;
		 */
		/*
		 *    int i=10;
		 *    if(i==10)
		 *    {
		 *       int j=20;
		 *       if(j==20)
		 *       {
		 *          int k=30;
		 *          // k
		 *       }
		 *       // j 
		 *    }
		 *    // i
		 */
	}

}






