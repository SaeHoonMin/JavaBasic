// 1~100 3�� ����� ���ϰ� , 3�� ����� �� 
public class ����9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int i=1;
        int val=0;
        do
        {
        	if(i%3==0)
        	{
        		val+=i;
        		System.out.print(i+" ");
        	}
        	i++;
        }while(i<=100);
        System.out.println("\n��:"+ val);
	}

}
