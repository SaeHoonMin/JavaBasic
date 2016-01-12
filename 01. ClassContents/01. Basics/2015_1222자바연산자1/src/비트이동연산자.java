/*
 *    프로그램 구현 방법 
 *      1) 데이터 저장  => 변수
 *      2) 데이터 연산처리 => 연산자
 *      3) 처리된 결과 출력 => System.out.println()
 *         => System.out.println() : new Line
 *            System.out.println(" a b  c");
 *            System.out.println("d  e  f");
 *            abc
 *            def
 *            System.out.print("abc")
 *            System.out.print("def")
 *            abcdef
 *            System.out.printf(): 서식을 가지고 있는 출력
 *            System.out.printf("%5d%5d%5d",10,20,30)
 *            10   20   30
 *    연산자 
 *      
 *    SUN ==> Oracle
 *   =====   ========
 *    1.7      1.8 => pointer  <-  람다식,나즈혼 
 *              c + 파이씬
 *              
 *    비트이동 연산자 (<< 왼쪽이동, >>  오른쪽이동)
 *    10<<2 ==> 이진법으로 변환후에 뒤에 0을 2붙여라 
 *    10 => 1010 (101000) 
 *    X<<Y ==> X*2^Y
 *    
 *    10>>2 ==> 이진법으로 변환후에 뒤에서 2개 제외 
 *    10 => 10(10)X == 10(2)
 *    X>>Y ==> X/2^Y
 *    
 */
public class 비트이동연산자 {

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




