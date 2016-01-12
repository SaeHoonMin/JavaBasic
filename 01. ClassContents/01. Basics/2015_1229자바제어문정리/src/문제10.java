
public class 문제10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int num=(int)(Math.random()*100)+1;
        int sum=0;
        for(int i=1;i<=num;i++)
        {
        	sum+=i;
        }
        System.out.println("입력값:"+num);
        System.out.println("1~"+num+"까지의 합:"+sum);
	}

}
