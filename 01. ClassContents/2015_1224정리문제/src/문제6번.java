import java.util.Scanner;
public class 문제6번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("나이 입력:");
        int age=scan.nextInt();
        if(age>=19)
        {
        	System.out.println("영화를 관람할 수 있습니다");
        }
        if(age>=15 && age<19)
        {
        	System.out.println("성인을 동반한 경우 영화를 관람할 수 있습니다");
        }
        if(age<15)
        {
        	System.out.println("영화를 관람 할 수 없습니다");
        }
	}

}
