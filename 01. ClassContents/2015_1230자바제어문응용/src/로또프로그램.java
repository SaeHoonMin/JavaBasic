import java.util.Scanner;

public class �ζ����α׷� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] com=new int[6];
		int su=0; // ���� ����
        boolean bDash=false; // �ߺ����� Ȯ��
        for(int i=0;i<6;i++)
        {
        	bDash=true;
        	while(bDash)
        	{
        		// ���� �߻�
        		su=(int)(Math.random()*45)+1;
        		bDash=false;
        		for(int j=0;j<i;j++)
        		{
        			if(com[j]==su)
        			{
        				bDash=true;
        				break; // while���� ���ǹ����� �̵�
        			}
        		}
        	}
        	com[i]=su;
        }
        // ����� �Է� 
        Scanner scan=new Scanner(System.in);
        int[] user=new int[6];
        for(int i=0;i<6;i++)
        {
        	System.out.print("1~45���� ���� �Է�:");
        	int no=scan.nextInt();
        	if(no<1 || no>45)
        	{
        		System.out.println("1~45���� ������ �Է��ϼ���");
        		i--;
        		continue;
        	}
        	user[i]=no;
        }
        System.out.println("�ζ� ��÷��ȣ");
        for(int i=0;i<6;i++)
        {
        	System.out.print(com[i]+" ");
        }
        System.out.println();
        System.out.println("���� �Է°�");
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
        	System.out.println("��");
        	break;
        case 3:
        	System.out.println("4�� ��÷ (5,000)");
        	break;
        case 4:
        	System.out.println("3�� ��÷(1,500,000)");
        	break;
        case 5:
        	System.out.println("2���÷(56,000,000)");
        	break;
        case 6:
        	System.out.println("1���÷(1��)");
        	break;
        }
	}

}





