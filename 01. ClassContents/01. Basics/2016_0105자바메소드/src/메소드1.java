/*
 *   �޼ҵ� : �Ѱ��� ����� �����ϴ� ��ɹ��� ���� 
 *         ======= (������ ����)
 *         �ݺ������ϴ� ��� 
 *         ����)
 *             ����� (��������) �޼ҵ��(�Է°�....)
 *             {
 *                  ó�� 
 *                  ������� �����ش� 
 *                  return �����
 *                  *** void�� ��쿡�� ������ ���� 
 *             }
 *             
 *             ȣ�� ==> �޼ҵ��(�Է°�)
 *             
 *             �����  �Է°� 
 *             ========
 *              O   O
 *              O   X
 *              X   O
 *              X(void)   X()
 *              
 *              => void main(String[] args)
 *                  �����(X) �Ű�����(O)
 *                 double random()
 *                  ����� (O) �Ű����� (X)
 *                 int nextInt()
 *                  ����� (O) �Ű�����(X)
 *                 
 *                 int indexOf(����)
 *                  
 */
import java.util.Scanner;
public class �޼ҵ�1 {
    // �Ű�����(����� �Է°�),������(ó�� �����)
	static int plus(int a,int b)
	{
		// ó�� 
		int c=a+b;
		return c;
	}
	static int minus(int a,int b)
	{
		int c=a-b;
		return c;
	}
	static int gop(int a,int b)
	{
		int c=a*b;
		return c;
	}
	static double div(int a,int b)
	{
		double d=a/(double)b;
		return d;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*
         *   ���� ������ ���� (����) �� �Է�
         *   = �����Է� 
         *   int a=10;
         *   int a=scan.nextInt()
         *   int a=(int)(Math.random()*100);
         */
		Scanner scan=new Scanner(System.in);
		System.out.print("1' ���� �Է�:");
		int a=scan.nextInt();
		System.out.print("2' ���� �Է�:");
		int b=scan.nextInt();
		
		// +
		int res=plus(a,b);
		System.out.println("res="+res);
		// -
		res=minus(a,b);
		System.out.println("res="+res);
		// *
		res=gop(a,b);
		System.out.println("res="+res);
		// /
		double d=div(a,b);
		System.out.println("d="+d);
		
	}

}
