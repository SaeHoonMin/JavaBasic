import java.util.Scanner;

/*
 *    1) 중복없는 난수  ==> int[] com  {}
 *    2) 입력               ==> int[] user
 *    3) 비교   ==> s,b
 *    4) 힌트   s, b
 *    5) 종료  s==3
 */
public class 숫자야구게임 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] com=new int[3];
        int[] user=new int[3];
        int s,b;
        // 중복없는 난수 
        int su=0; // 난수 저장
        boolean bDash=false; // 중복여부 확인
        for(int i=0;i<3;i++)
        {
        	bDash=true;
        	while(bDash)
        	{
        		// 난수 발생
        		su=(int)(Math.random()*9)+1;
        		bDash=false;
        		for(int j=0;j<i;j++)
        		{
        			if(com[j]==su)
        			{
        				bDash=true;
        				break; // while문의 조건문으로 이동
        			}
        		}
        	}
        	com[i]=su;
        }
        /*for(int i=0;i<3;i++)
        {
        	System.out.print(com[i]+" ");
        }*/
        // 사용자 입력 
      
        Scanner scan=new Scanner(System.in);
        while(true)
        {
        	// 사용자 입력
        	System.out.print("세자리 정수 입력:");
        	int input=scan.nextInt();
        	// 오류 
        	if(input<100 || input>999)
        	{
        		System.out.println("세자리 정수만 입력해야 합니다");
        		continue;
        		/*
        		 *   for => 증가식
        		 *   while => 조건식
        		 */
        	}
        	//  345/100  ==> 3 ==> 45/10
        	/*
        	 *    234
        	 *    222   1S-2B
        	 *    문자열을 입력을 받아서 좌우 대칭인지 확인 
        	 *    aba abba
        	 *       0 3
        	 *       1 2
        	 */
        	user[0]=input/100;
        	user[1]=(input%100)/10;
        	user[2]=input%10;
        	
        	if(user[0]==user[1]||user[1]==user[2]||
        	  user[0]==user[2])
        	{
        		System.out.println("중복된 수는 사용할 수 없다");
        		continue;
        	}
        	if(user[0]==0 || user[1]==0 || user[2]==0)
        	{
        		System.out.println("0은 사용할 수 없다 ");
        		continue;
        	}
        	// 비교
        	s=0;
        	b=0;
        	for(int i=0;i<3;i++) //com
        	{
        		for(int j=0;j<3;j++)//user
        		{
        			if(com[i]==user[j])// 비교 => 같은 수가 있다면
        			{
        				if(i==j) s++;
        				else b++;
        			}
        		}
        	}
        	// 힌트
        	System.out.printf("Input Number:%d,Result:%dS-%dB\n",input,s,b);
        	// 종료
        	if(s==3)
        	{
        		System.out.println("Game Over!!");
        		break;
        	}
        }
	}

}







