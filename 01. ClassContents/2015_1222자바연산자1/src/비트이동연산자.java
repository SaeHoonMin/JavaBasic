/*
 *    ���α׷� ���� ��� 
 *      1) ������ ����  => ����
 *      2) ������ ����ó�� => ������
 *      3) ó���� ��� ��� => System.out.println()
 *         => System.out.println() : new Line
 *            System.out.println(" a b  c");
 *            System.out.println("d  e  f");
 *            abc
 *            def
 *            System.out.print("abc")
 *            System.out.print("def")
 *            abcdef
 *            System.out.printf(): ������ ������ �ִ� ���
 *            System.out.printf("%5d%5d%5d",10,20,30)
 *            10   20   30
 *    ������ 
 *      
 *    SUN ==> Oracle
 *   =====   ========
 *    1.7      1.8 => pointer  <-  ���ٽ�,����ȥ 
 *              c + ���̾�
 *              
 *    ��Ʈ�̵� ������ (<< �����̵�, >>  �������̵�)
 *    10<<2 ==> ���������� ��ȯ�Ŀ� �ڿ� 0�� 2�ٿ��� 
 *    10 => 1010 (101000) 
 *    X<<Y ==> X*2^Y
 *    
 *    10>>2 ==> ���������� ��ȯ�Ŀ� �ڿ��� 2�� ���� 
 *    10 => 10(10)X == 10(2)
 *    X>>Y ==> X/2^Y
 *    
 */
public class ��Ʈ�̵������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //System.out.printf("%-5d%-5d",10,20);
		int a=10;
		int b=2;
		/*
		 *     1010  <<
		 *   1010(00)
		 *     1010  >>
		 *       10(10)
		 */
		int c=a<<b;
		int d=a>>b;
		//System.out.println(Integer.toBinaryString(a));
		System.out.println("c="+c);
		System.out.println("d="+d);
		
	}

}




