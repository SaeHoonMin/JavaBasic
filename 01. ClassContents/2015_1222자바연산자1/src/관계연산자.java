/*
 *    관계연산자 ==> 결과값 (true/false) boolean 
 *      ==  같다 (********)
 *      !=  같지 않다
 *      <   작다
 *      >   크다
 *      <=  작거나 같다
 *      >=  크거나 같다 
 */
public class 관계연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       /* int a=10;
        int b=9;
        boolean result=(a == ++b); // 10
        System.out.println("b="+b);
        System.out.println("result="+result);
        result=(a == b++); // 10
        System.out.println("b="+b); // 11
        System.out.println("result="+result);
        
        result=(a == b); // 11
        System.out.println("b="+b);
        System.out.println("result="+result);*/
		int a=10;
		int b=9;
		boolean result=(a!=b);// true
		System.out.println("result="+result);
		int c=b++; // c=9
		/*
		 *    int a=10;
		 *    int c= ++a  ==> c=11
		 *        -- --
		 *         2  1
		 *    
		 *    int c=a ++  ==> c=10
		 *         -- --
		 *          1  2
		 */
		result=(a!=c); // b=10
		System.out.println("result="+result);
				
	}

}




