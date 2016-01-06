// 1~100 3의 배수를 구하고 , 3의 배수의 합 
public class 문제9 {

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
        System.out.println("\n합:"+ val);
	}

}
