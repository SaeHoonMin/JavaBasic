/*
 *   자료형 : 메모리 크기 ==> 데이터 저장시마다 메모리 크기를 결정 
 *   (1btye,2byte,4byte,8byte)
 *   
 *   1) 정수 저장 
 *       byte (1byte)  -128~127 
 *       short (2byte) -32768~32767  33000
 *       int (4byte)   -21억 4천  ~ 21억4천 (default)
 *       long (8byte)  100L , 100
 *         10,10,10,10
 *   2) 실수 저장 
 *       float (4byte)  10.5F => 소수점 6자리
 *       double (8byte) 10.5 (default)
 *            소수점 15자리
 *   3) 문자 저장 (2byte) => - 값이 없다 (0~65535)
 *         싱글바이트 (1byte) : ASC
 *         멀티바이트 (2byte) : Unicode
 *         char
 *   4) 논리 저장 (1byte)
 *         boolean => true/false
 *   5) 참조 ==> 클래스,배열
 */
public class 자바자료형 {

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
         *    = 변환 
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





