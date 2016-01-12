import java.util.Scanner;

public class 로또프로그램 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] com=new int[6];
		int su=0; // 난수 저장
        boolean bDash=false; // 중복여부 확인
        for(int i=0;i<6;i++)
        {
        	bDash=true;
        	while(bDash)
        	{
        		// 난수 발생
        		su=(int)(Math.random()*45)+1;
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
        // 사용자 입력 
        Scanner scan=new Scanner(System.in);
        int[] user=new int[6];
        for(int i=0;i<6;i++)
        {
        	System.out.print("1~45까지 정수 입력:");
        	int no=scan.nextInt();
        	if(no<1 || no>45)
        	{
        		System.out.println("1~45까지 정수만 입력하세요");
        		i--;
        		continue;
        	}
        	user[i]=no;
        }
        System.out.println("로또 당첨번호");
        for(int i=0;i<6;i++)
        {
        	System.out.print(com[i]+" ");
        }
        System.out.println();
        System.out.println("본인 입력값");
        for(int i=0;i<6;i++)
        {
        	System.out.print(user[i]+" ");
        }
        System.out.println();
        int count=0;
        for(int i=0;i<6;i++)
        {
        	for(int j=0;j<6;j++)
        	{
        		if(com[i]==user[j])
        			count++;
        	}
        }
        switch(count)
        {
        case 0:
        case 1:
        case 2:
        	System.out.println("꽝");
        	break;
        case 3:
        	System.out.println("4등 당첨 (5,000)");
        	break;
        case 4:
        	System.out.println("3등 당첨(1,500,000)");
        	break;
        case 5:
        	System.out.println("2등당첨(56,000,000)");
        	break;
        case 6:
        	System.out.println("1등당첨(1조)");
        	break;
        }
	}

}





