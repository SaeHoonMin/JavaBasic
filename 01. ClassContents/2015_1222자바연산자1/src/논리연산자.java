/*
 *    논리연산자  ==> 결과값 (true,false) => boolean
 *    조건  && 조건 
 *    ===========================
 *                     &&     ||
 *    ===========================
 *     true true     true    true
 *    ===========================
 *     true false    false   true
 *    ===========================
 *     false true    false   true
 *    ===========================
 *     false false   false   false
 *    ===========================
 *    *** 최적화 연산 처리 
 *    &&는 앞에 있는 조건이 false면 뒤에 있는 조건은 처리하지 않는다 
 *    ||는 앞에 있는 조건이 true면 뒤에 있는 조건은 처리하지 않는다 
 *    
 */
public class 논리연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a=10;
        int b=9;
        boolean result=(a<b || ++b==a);
        System.out.println("result="+result);
        System.out.println("a="+a);
        System.out.println("b="+b);
	}

}




