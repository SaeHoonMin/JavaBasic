/*
 *    ���迬���� ==> ����� (true/false) boolean 
 *      ==  ���� (********)
 *      !=  ���� �ʴ�
 *      <   �۴�
 *      >   ũ��
 *      <=  �۰ų� ����
 *      >=  ũ�ų� ���� 
 */
public class ���迬���� {

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




