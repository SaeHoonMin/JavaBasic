/*
 *    �ּ� 
 *     1) �ڹ� ���� 
 *        A.java ========> A.class ========> ����
 *             javac(����� ��ȯ)     java(����������)
 *                                ==============
 *                                    JVM
 *     2) �ڹٿ��� ����ϴ� ������ ǥ���� 
 *        1. ����
 *            = 10���� : 100,200...
 *            = 8����   : 0(����)
 *            = 16����  : 0x(����)
 *            100 (4byte) 100L (8byte)
 *        2. ����
 *            = 'A' , 'ȫ' , '0' : ������ȣ (ASC)
 *              'A' : 65  'A'+1 ==> 66
 *              'a' : 97
 *              '0' : 48
 *        3. ���ڿ� 
 *            = "ȫ�浿"
 *        4. �Ǽ� 
 *            = 10.5D (8byte), 10.5F(4byte)
 *        5. ��
 *            = true,false
 */
public class �ڹٱ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���� ��� 
        System.out.println(10);
        // 8����
        System.out.println(011); // 8*1+1*1 => 9
        // 16����
        System.out.println(0x55);// 16*5 + 5 = 85
        // ���� ǥ�� 
        System.out.println('A');
        System.out.println('ȫ');
        // ���ڿ� 
        System.out.println("ȫ�浿");
        // �Ǽ�
        System.out.println(10.5); // 8byte
        System.out.println(10.5F); // 4byte
        // ��
        System.out.println(true);
        System.out.println(false);
        
        // ���ڿ� ����    (+) 
        System.out.println("7"+7+"7"+7+7);
        // "7"+7 => "77"+"7" ==> "777"+7 ==> "7777"+7 ===>"77777"
        // 7+7+7+7+7 ==> 35
        // 7+7+7+7+"7" => 287 +(����)
        System.out.println(7+7+7+7+7);
        System.out.println(7+7+7+7+"7");
	}

}




