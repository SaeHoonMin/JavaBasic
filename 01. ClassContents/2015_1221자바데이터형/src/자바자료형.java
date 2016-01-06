/*
 *    �ڷ��� 
 *     ������
 *       byte (1byte) -128~127 (����,��Ʈ��ũ�󿡼� �̿�)
 *       short (2byte) -32768~32767(���󵵰� ����)
 *       int (4byte) -21�� 4õ ~ 21��  4õ
 *          => �Ϲ� ���� (default=>int)
 *       long (8byte) -2^63 ~ 2^63-1
 *          ******* int vs long => 100L(l)
 *     �Ǽ���
 *       float (4byte) : �Ҽ������� 6�ڸ�
 *       double (8byte):�Ҽ������� 15�ڸ�
 *        => �Ϲ� �Ǽ� (default => double)
 *          ******* float vs double (10.5F,10.5D)
 *              D�� ������ ���� 
 *     ������
 *       char (2byte) : �����Ѱ��� ǥ��  'A','ȫ'
 *           0~65535 => ������ �� ǥ���� �� �ִ� (�����ڵ�)
 *     ���� 
 *       boolean (1byte) : true/false
 *          ==> ���ǻ�� 
 *     =====> ������ ����� �޸� ũ�⸦ ������ �� ���
 *     
 *     ==> ������ ���� ��� 
 *        1) ���� ������ �����ϴ� �޸��� ��Ī : ���� 
 *           ���� : ���ϴ� ��(�������� �ʿ�ø��� �����ؼ� ����� ����)
 *           ��� : ������ �ʴ� �� (�������� �ʿ�)
 *           
 *           => ���� ���� 
 *              �޸� ũ�⼱�� ������ ���� = ��
 *               int a=10;
 *               *** ���� ���󿡼� ���� �̸��� ������ 
 *                   ��� �� �� ���� 
 *               {
 *                 int a=10; 4
 *                 int a=20; 8   a => error
 *               }
 *              �����Ŀ� ���߿� ���� ����
 *              int a;
 *              a=10;
 *              int a,b,c;
 *              int a=10,b=20,c=30;
 *           => ������ ����� (�ĺ���)
 *              1) ���ĺ��̳� �ѱ۷� ���� 
 *                 (�� �˹ٺ��� ��ҹ��ڸ� ����)
 *              2) ���� ����� ���� 
 *                 (�� �տ� ����� �� �� ����)
 *              3) Ư�����ڸ� ��� �� �� �ִ�
 *                 ( $ , - )
 *              4) Ű����� ��� �� �� ����
 *                 �ڹٿ��� �̹� ������� �ܾ�)
 *                 int,long...
 *              5) ������ ���̴� ������ ���� (3~7��)
 *            ****** ���� (X)
 *               ��ӵ� �κ� (�ڹٰ�����) 
 *               1) Ŭ�������� �빮�� (ù��)
 *                  Main ...
 *               2) ����,�޼ҵ� (ù��) �ҹ���
 *                  a,b, kor...
 *               3) �ΰ��̻��� �ܾ �̿��Ҷ� 
 *                  �ι�° ������ �빮�ڷ� �Ѵ� (��Ÿ���� ǥ����)
 *                  MainClass,fileName...
 *          => �ڷ����� ��ȯ 
 *             �ڷ����� ũ�� 
 *             byte < short < int < long < float < double
 *                    char 
 *             => �ڷ��� �۰� �����
 *                (int)10.5 => (double=>int)
 *                                8      4
 *                 ���� ����ȯ (down-casting)
 *             => �ڷ��� ũ�� ����� 
 *                (double)10 => int => double
 *                               4       8
 *                 ===> �ڵ�����ȯ (���� ����ø���)
 *                 'A'+1 
 *                 1) 'A' => 65
 *                 2) 65+1 => 66
 *               (long)
 *             => int a=10000000000(long) => (int)10000000000L
 *                      ===========
 *                          1
 *                    ==
 *                     2 
 *             => int����(byte,short,char) => ���������� int
 *             byte+byte=int
 *             char+char=int
 *             short+short=int 
 *             => �������� ū ���������� ���� ���� 
 *             byte+int = int
 *             int + long =long
 *             double+int = double
 *             float+int = float
 */
public class �ڹ��ڷ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        byte byteValue=127;
        short shortValue=32767;
        int intValue=2140000000;
        long longValue=300000000000000L;
        float floatValue=10.5F;
        double doubleValue=10.5;
        char charValue='ȫ';
        boolean booleanValue=true;
        System.out.println("byteValue="+byteValue);
        
	}

}




