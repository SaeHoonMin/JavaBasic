
public class 문제1번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int won=278970;
        // 만단위
        int val1=won/10000;
        int val2=(won%10000)/5000;
        int val3=(won%5000)/1000;
        int val4=(won%1000)/500;
        int val5=(won%500)/100;
        int val6=(won%100)/50;
        int val7=(won%50)/10;
        
        System.out.println("10000원권=>"+val1+"개");
        System.out.println("5000원권=>"+val2+"개");
        System.out.println("1000원권=>"+val3+"개");
        System.out.println("500원권=>"+val4+"개");
        System.out.println("100원권=>"+val5+"개");
        System.out.println("50원권=>"+val6+"개");
        System.out.println("10원권=>"+val7+"개");
	}

}
