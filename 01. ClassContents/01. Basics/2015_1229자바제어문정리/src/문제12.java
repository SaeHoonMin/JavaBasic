/*
 *    변수 : 저장된 데이터의 메모리 주소 별칭
 *         단일데이터 저장 가능
 *         변수는 변경해서 사용이 가능
 *    ===================== 데이터 저장 방법 
 *    처리 
 *     = 연산자 
 *        = 단항 연산자 ( ++ , -- , !) => (type)
 *        = 산술 연산자 ( +, -, * , / ,% )
 *        = 논리 연산자  ( && , || ) ==> true/false
 *        = 관계 연산자  ( == , != , < , > , <= ,>= )
 *        = 대입 연산자  ( = , += , -= )
 *     = 제어문 
 *        = 조건문  
 *           => if 
 *           => if ~ else
 *           => if ~ else if...else
 *        = 선택문
 *           => switch ~ case
 *        = 반복문
 *           => for , while
 *        = 반복제어문 
 *           => break, continue
 *           
 *     ===> break,continue
 *     break : 반복수행을 중단 
 *     continue : 특정 부분을 제외 
 *       => for일 경우에는 => 증가식
 *          while일 경우에는 => 조건식 
 *     
 */
// 숫자 야구 게임 
/*
 *    3 4 5
 *      => 1 2 3
 *         0S-1B
 *      => 4 5 6
 *         0S-2B
 *      => 3 5 4
 *         1S-2B
 *      => 3 4 5
 *         3S-0B  ==> break
 */
/*
 *    1. 난수 발생 ==> 숫자 3개 저장 
 *    2. 입력 요청 => 사용자 3개 정수 입력
 *    3. 입력값,난수값을 비교 
 *    4. 힌트 제공
 *    5. 3S인지 확인 => 2으로 전송
 *               => break;
 */
import java.util.Scanner;
public class 문제12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] com={7,5,8};
        int[] user=new int[3];
        Scanner scan=new Scanner(System.in);
        while(true)
        {
        	System.out.print("세자리 정수를 입력하세요:");
        	int input=scan.nextInt();
        	if(input<100 || input>999)
        	{
        		System.out.println("잘못된 입력입니다");
        		continue;
        	}
        	user[0]=input/100;
        	user[1]=(input%100)/10;
        	user[2]=input%10;
        	if(user[0]==user[1]||user[1]==user[2]
        	   ||user[0]==user[2])
        	{
        		System.out.println("중복된 수는 사용할 수 없습니다");
        		continue;
        	}
        	// 처리 비교
        	int s=0;
        	int b=0;
        	for(int i=0;i<3;i++)// com
        	{
        		for(int j=0;j<3;j++)// user
        		{
        			if(com[i]==user[j])
        			{
        				if(i==j)
        					s++;
        				else
        					b++;
        			}
        		}
        	}
        	// 결과 출력
        	System.out.printf("Input Number:%d,Result:%dS-%dB\n",input,s,b);
        	System.out.println("===================");
        	System.out.print("S:");
        	for(int i=0;i<s;i++)
        	{
        		System.out.print("●");
        	}
        	System.out.println();
        	System.out.print("B:");
        	for(int i=0;i<b;i++)
        	{
        		System.out.print("○");
        	}
        	System.out.println();
        	System.out.println("===================");
        	if(s==3)
        	{
        		System.out.println("\"Game Over!!\"");
        		System.out.println("c:\\javaDev\\javaStudy");
        		break;
        	}
        	
        }
	}

}




