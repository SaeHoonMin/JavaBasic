/*
 *   ��������� 
 *     (+ , - , * , / , %)
 *      +,-,* : ����ȯ
 *      10+20.5
 *     ===
 *     10.0 (ū������������ ����) ==> �ڵ� ����ȯ
 *     10.0+20.5 ==> 30.5
 *     
 *     'A'+5
 *     ===
 *     65
 *     65+5=70
 *     
 *     int a=10.5+10.5;
 *     ===== =========
 *       4       8   ==> error
 *     int a=(int)(10.5+10.5) ===> 21
 *                ============
 *             2      1(21.0) ==> 21
 *     int a=(int)10.5+(int)10.5;
 *           =====     =====
 *             10 + 10 ==> 20
 *     /
 *     1) 0���� ���� ��쿡 error 
 *        10/0
 *     2) ����/���� = ���� 
 *        10/3 ==> 3
 *        
 *     % : ������� ���� ��ȣ�� ���´� 
 *         5%2  = 1
 *         -5%2 = -1
 *         -5%-2= -1
 *         5%-2 = 1
 *         
 *         
 *         ==> ��������  41������
 *         ==> ����,���� �����  42,43������
 *         ==> ����ȯ 64������ (�ڵ�,����)
 *             => �ڷ����� ũ�� (67������)
 *         ==> �������� ���� (72������)
 *         ==> ��������� (74������)
 *         ==> ���������� (92������,93������) 
 */
public class ��������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*int kor=85;
        int eng=78;
        int math=81;
        int total=kor+eng+math;
        double avg=total/3.0;
        System.out.println("��������:"+kor);
        System.out.println("��������:"+eng);
        System.out.println("��������:"+math);
        System.out.println("����:"+total);
        //System.out.println("���:"+avg);
        System.out.printf("���:%.2f",avg);
        // ���� : %c(����) %d(����) %f(�Ǽ�) %s(���ڿ�)
*/	
		// *,/ ,% > +,-
	    System.out.println("5%2="+5%2);// 1
	    System.out.println("-5%2="+ -5%2);// -1
	    System.out.println("5%-2="+ 5%-2);//1
	    System.out.println("-5%-2="+ -5%-2);//-1
	    
	    System.out.println("5/2="+5/2);//2
	    System.out.println("10/0="+10/0);
	    
	}

}




