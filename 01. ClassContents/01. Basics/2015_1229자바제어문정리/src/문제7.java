// 1~50 ==> 5�� ��� , 5�� ��� �� 
public class ����7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int value=0;
        for(int i=1;i<=50;i++)
        {
        	if(i%5==0)
        	{
        		value+=i; // value=value+i
        		System.out.print(i+" ");
        	}
        }
        System.out.println("\n1~50���� 5�� ����� ��:"+value);
	}

}
