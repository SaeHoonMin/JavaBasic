// while�� 
// ���� �Է¹޾Ƽ� => �ش� ���� ��� 
// �Է°� 
import java.util.Scanner;
public class �ݺ���2 {
    static void gugudan()
    {
    	Scanner scan=new Scanner(System.in);
		System.out.print("�� �Է�:");
		int dan=scan.nextInt();
		// ���� �޾Ƽ� ������ ��� 
		System.out.println("whileó��");
		int i=1;
		while(i<=9)
		{
			System.out.println(dan+"*"+i+"="+dan*i);
			i++;
		}
		System.out.println("do~whileó��");
		i=1; // int j=1;
		do
		{
			System.out.println(dan+"*"+i+"="+dan*i);
			i++;
		}while(i<=9);
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // ���� �Է��ض� 
		//gugudan();
		//gugudan();
		// ���� ==> ����Ŀ� �ٽ� ����� ���� 
		/*
		 *   int i=10;
		 *   
		 *   i=5;
		 */
		/*
		 *    int i=10;
		 *    if(i==10)
		 *    {
		 *       int j=20;
		 *       if(j==20)
		 *       {
		 *          int k=30;
		 *          // k
		 *       }
		 *       // j 
		 *    }
		 *    // i
		 */
	}

}






