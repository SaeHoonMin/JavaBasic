
public class ����1�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int won=278970;
        // ������
        int val1=won/10000;
        int val2=(won%10000)/5000;
        int val3=(won%5000)/1000;
        int val4=(won%1000)/500;
        int val5=(won%500)/100;
        int val6=(won%100)/50;
        int val7=(won%50)/10;
        
        System.out.println("10000����=>"+val1+"��");
        System.out.println("5000����=>"+val2+"��");
        System.out.println("1000����=>"+val3+"��");
        System.out.println("500����=>"+val4+"��");
        System.out.println("100����=>"+val5+"��");
        System.out.println("50����=>"+val6+"��");
        System.out.println("10����=>"+val7+"��");
	}

}
