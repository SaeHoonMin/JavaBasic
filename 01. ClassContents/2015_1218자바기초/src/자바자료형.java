/*
 *   �ڷ��� : �޸� ũ�� ==> ������ ����ø��� �޸� ũ�⸦ ���� 
 *   (1btye,2byte,4byte,8byte)
 *   
 *   1) ���� ���� 
 *       byte (1byte)  -128~127 
 *       short (2byte) -32768~32767  33000
 *       int (4byte)   -21�� 4õ  ~ 21��4õ (default)
 *       long (8byte)  100L , 100
 *         10,10,10,10
 *   2) �Ǽ� ���� 
 *       float (4byte)  10.5F => �Ҽ��� 6�ڸ�
 *       double (8byte) 10.5 (default)
 *            �Ҽ��� 15�ڸ�
 *   3) ���� ���� (2byte) => - ���� ���� (0~65535)
 *         �̱۹���Ʈ (1byte) : ASC
 *         ��Ƽ����Ʈ (2byte) : Unicode
 *         char
 *   4) �� ���� (1byte)
 *         boolean => true/false
 *   5) ���� ==> Ŭ����,�迭
 */
public class �ڹ��ڷ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//short a=127;
		/*
		 *    (int)(10.5+10.5)
		 *         ===========  21.0 ==> 21 
		 *    (int)10.5+(int)10.5
		 *    =====     =====
		 *        10+10 ==> 20
		 */
        System.out.println((int)'A');
        System.out.println((char)67);
        System.out.println(10.5);
        System.out.println((int)10.5);
        /*
         *   1
         *   1.11111
         *   1.00000
         *   
         *    byte <short <int <long <float <double
         *         char
         *         
         *    = ��ȯ 
         *      UP DOWN
         *      (char)65
         *      (int)10.5
         *      (double)10
         *      
         *      10 + 10.5 ==> 20.5
         *      ===
         *      10.0
         *      int  double   double
         *      'A'+1 ==> 66
         *      ===
         *       65
         *       char + int = int
         *       char + char = int
         *       byte+byte = int
         *       byte+short =int 
         */
        byte b1=100;
        byte b2=30;
        byte b3=(byte) (b1+b2);
        System.out.println(b3);
        /*
         *    128 64 32 16 8 4 2 0
         *     1   0  0  0 0 0 1 0 
         */
	}

}





