/*
 *   UP - DOWN ���� 
 */
import java.util.Scanner;
public class �ݺ���3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        // ���� ������ �߻� => 1~100
        int com=(int)(Math.random()*100)+1;
        // 0.0~0.99 => 0.0~99.0 => 0~99 ==> 1~100
        int count=0;
        for(;;) // ���ѷ���
        {
        	System.out.print("1~100���� ������ ���� �Է�:");
        	int user=scan.nextInt();
        	
        	if(user<1 || user>100)
        	{
        		System.out.println("�߸��� �Է��Դϴ�");
        		continue;
        	}
        	count++;
        	// ��
        	if(com>user)
        	{
        		System.out.println("�Է°����� ���� ���� �Է��ϼ���");
        	}
        	else if(com<user)
        	{
        		System.out.println("�Է°����� ���� ���� �Է��ϼ���");
        	}
        	else // ==
        	{
        		System.out.println("Game Over!!");
        		System.out.println("�Է�Ƚ��:"+count);
        		 break;
        	}
        }
	}

}



