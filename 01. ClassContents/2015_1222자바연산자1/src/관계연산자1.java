
public class 관계연산자1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a=10;
        int b=9;
        boolean result=(a<b);
        System.out.println("result="+result);// f
        result=(a>b);
        System.out.println("result="+result);// t
        result=(a<=b); // a<b || a==b
        System.out.println("result="+result);// f
        result=(a>=b); // a>b || a==b
        System.out.println("result="+result);// t
	}

}
