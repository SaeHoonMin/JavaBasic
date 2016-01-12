/*
 *   단일 IF
 *     if(조건문)
 *       문장1
 *     
 *     if(조건문)
 *       문장1
 *       문장2
 *       
 *     if(조건문)
 *     {
 *        문장1
 *        문장2
 *     }
 */
public class 조건문2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        char ch='a';// char ==> 연산자가 들어가면 정수
        /*
         *   && : 포함 
         *   || : 범위를 벗어난 경우 
         *   
         *   1) !
         *   2) 관계연산자 
         *   3) 논리연산자 
         */
        if(ch>='A' && ch<='Z')
        	System.out.println(ch+"는(은) 대문자다");
        /*if(ch>='a' && ch<='z')
        	System.out.println(ch+"는(은) 소문자다");*/
        if(!(ch>='A' && ch<='Z'))
        	System.out.println(ch+"는(은) 소문자다");
        	
	}

}



