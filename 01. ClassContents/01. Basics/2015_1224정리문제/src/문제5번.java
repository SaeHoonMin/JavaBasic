import java.util.Scanner;

public class 문제5번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("정수 입력:");
		int num=scan.nextInt();
		if(num%3==0)
        	System.out.println(num+"는(은) 3의 배수다");
        if(num%5==0)
        	System.out.println(num+"는(은) 5의 배수다");
        if(num%8==0)
        	System.out.println(num+"는(은) 8의 배수다");
	}

}
