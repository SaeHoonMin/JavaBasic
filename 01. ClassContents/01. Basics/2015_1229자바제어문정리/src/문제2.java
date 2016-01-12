/*
 *    2. 임의의 수를 입력받아서 홀수,짝수 확인 
 *    => 조건문 
 *       단일 IF
 *         = 형식) 
 *               if(조건문)
 *                 문장       => 
 *               1) 조건 확인  true면 문장을 수행
 *                  false명 문장을 수행하지 않는다 
 *               ***** 모든 제어문은 바로 밑에 있는 문장만 제어를 한다 
 *               ==> 여러개의 문장을 동시 처리시에는 
 *                   반드시 {}을 사용한다 
 *       선택 IF
 *               형식) 
 *                   if(조건문)
 *                   {
 *                     문장
 *                     문장 
 *                   }
 *                   else
 *                     문장 
 *                     
 *                  => 조건문이 true if의 문장 수행
 *                     false면 else의 문장을 수행 
 *       다중 IF
 *           if(조건문)
 *           {
 *              true=>문장을 수행후 종료
 *              false=> 다음의 if의 조건을 수행
 *           }
 *           else if(조건문)
 *           {
 *              true=>문장을 수행후 종료
 *              false=> 다음의 if의 조건을 수행
 *           }
 *           else if(조건문)
 *           {
 *              true=>문장을 수행후 종료
 *              false=> 다음의 if의 조건을 수행
 *           }
 *           else
 *           {
 *               맞는 조건이 없으면 else문장을 수행한다 
 *               
 *           }
 *           
 */
import java.util.Scanner;
public class 문제2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("정수 입력:");
        int num=scan.nextInt();
        // 처리 => 결과값 출력 
        if(num%2==0)
        	System.out.println(num+"는(은) 짝수");
        else
        	System.out.println(num+"는(은) 홀수");
	}

}








