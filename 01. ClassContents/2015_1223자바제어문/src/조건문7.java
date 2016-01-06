import java.util.Scanner;
public class 조건문7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*System.out.println((int)'+');
        System.out.println((int)'-');
        System.out.println((int)'*');
        System.out.println((int)'/');*/
        char op='/';
        Scanner scan=new Scanner(System.in);
        System.out.print("첫번째 정수 입력:");
        int num1=scan.nextInt();
        System.out.print("두번째 정수 입력:");
        int num2=scan.nextInt();
        int num3=0;
        if(op=='+')
        {
        	num3=num1+num2;
        }
        else if(op=='-')
        {
        	num3=num1-num2;
        }
        else if(op=='*')
        {
        	num3=num1*num2;
        }
        else if(op=='/')
        {
        	//if(num2!=0)
        	num3=num1/num2;
        }
        System.out.printf("%d%c%d=%d",num1,op,
        		 num2,num3);
        
	}

}



