/*
 *    자료형 
 *     정수형
 *       byte (1byte) -128~127 (파일,네트워크상에서 이용)
 *       short (2byte) -32768~32767(사용빈도가 없다)
 *       int (4byte) -21억 4천 ~ 21억  4천
 *          => 일반 정수 (default=>int)
 *       long (8byte) -2^63 ~ 2^63-1
 *          ******* int vs long => 100L(l)
 *     실수형
 *       float (4byte) : 소수점이하 6자리
 *       double (8byte):소수점이하 15자리
 *        => 일반 실수 (default => double)
 *          ******* float vs double (10.5F,10.5D)
 *              D는 생략이 가능 
 *     문자형
 *       char (2byte) : 문자한개를 표현  'A','홍'
 *           0~65535 => 각국의 언어를 표현할 수 있다 (유니코드)
 *     논리형 
 *       boolean (1byte) : true/false
 *          ==> 조건사용 
 *     =====> 데이터 저장시 메모리 크기를 결정할 때 사용
 *     
 *     ==> 데이터 저장 방법 
 *        1) 단일 데이터 저장하는 메모리의 별칭 : 변수 
 *           변수 : 변하는 값(언제든지 필요시마다 변경해서 사용이 가능)
 *           상수 : 변하지 않는 값 (고정값이 필요)
 *           
 *           => 변수 사용법 
 *              메모리 크기선언 변수명 설정 = 값
 *               int a=10;
 *               *** 같은 블럭상에서 같은 이름의 변수는 
 *                   사용 할 수 없다 
 *               {
 *                 int a=10; 4
 *                 int a=20; 8   a => error
 *               }
 *              선언후에 나중에 값을 대입
 *              int a;
 *              a=10;
 *              int a,b,c;
 *              int a=10,b=20,c=30;
 *           => 변수명 만들기 (식별자)
 *              1) 알파벳이나 한글로 시작 
 *                 (단 알바벳은 대소문자를 구분)
 *              2) 숫자 사용이 가능 
 *                 (단 앞에 사용을 할 수 없다)
 *              3) 특수문자를 사용 할 수 있다
 *                 ( $ , - )
 *              4) 키워드는 사용 할 수 없다
 *                 자바에서 이미 사용중인 단어)
 *                 int,long...
 *              5) 변수의 길이는 제한이 없다 (3~7자)
 *            ****** 문법 (X)
 *               약속된 부분 (자바개발자) 
 *               1) 클래스명은 대문자 (첫자)
 *                  Main ...
 *               2) 변수,메소드 (첫자) 소문자
 *                  a,b, kor...
 *               3) 두개이상의 단어를 이용할때 
 *                  두번째 시작은 대문자로 한다 (헝거리언식 표현법)
 *                  MainClass,fileName...
 *          => 자료형의 변환 
 *             자료형의 크기 
 *             byte < short < int < long < float < double
 *                    char 
 *             => 자료형 작게 만든다
 *                (int)10.5 => (double=>int)
 *                                8      4
 *                 강제 형변환 (down-casting)
 *             => 자료형 크게 만든다 
 *                (double)10 => int => double
 *                               4       8
 *                 ===> 자동형변환 (연산 수행시마다)
 *                 'A'+1 
 *                 1) 'A' => 65
 *                 2) 65+1 => 66
 *               (long)
 *             => int a=10000000000(long) => (int)10000000000L
 *                      ===========
 *                          1
 *                    ==
 *                     2 
 *             => int이하(byte,short,char) => 연산결과값은 int
 *             byte+byte=int
 *             char+char=int
 *             short+short=int 
 *             => 나머지는 큰 데이터형을 따라 간다 
 *             byte+int = int
 *             int + long =long
 *             double+int = double
 *             float+int = float
 */
public class 자바자료형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        byte byteValue=127;
        short shortValue=32767;
        int intValue=2140000000;
        long longValue=300000000000000L;
        float floatValue=10.5F;
        double doubleValue=10.5;
        char charValue='홍';
        boolean booleanValue=true;
        System.out.println("byteValue="+byteValue);
        
	}

}




