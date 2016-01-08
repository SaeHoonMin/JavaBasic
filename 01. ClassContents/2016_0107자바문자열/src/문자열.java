/*
 * 
 *	���ڿ� ==> ���� ������ ��� ���
 *			char []  ==> �����ؼ� ���� Ŭ����: String
 *
 *	��� ����
 *		String ������ = "��";
 *		------ ---
 *		 Ŭ����	��ü	  ��ü������ => ��ü : ����� ���� ���������� ���� ������
 *
 *		String ������ = new String("��");
 *					 ===
 *					���ο� �޸� ���� =>����
 *					new => System.gc();
 *
 *		String str = new String("Java");
 *
 *		�ڹ� �޸޸�
 *		
 *		========================
 *		 �޼ҵ� ����
 *		========================
 *  	����		��������, �Ķ����
 *		========================
 *		�� 		new�� �Ҵ�, gc�� ����
 *		========================
 * 
 * 		String str = new String ("java");
 * 		===stack===  ===heap===
 * 		   str			(java)
 * 		   100			200
 * 		========== 	 ==========
 * 		�������� : �迭, String
 * 
 * 	String : ��������, ��� 
 * 	1)	equals					: ���ڿ� ��  equalsIgnoreCase :��ҹ��ڱ���x
 * 	2)	length					: ���� ����
 *  3)	substring				: ���� ����
 *  4)	split					: ���� ����
 *  5)	stratsWith, endsWith	: �ڵ��ϼ���
 *  6)	trim					: ��, �� ���� ����
 *  7)	indexOf, lastIndexOf	: ���ϴ� ��ġ�� ���� ��ġ
 *  8)	replace					: �ٸ� ������ ����
 *  9)	valueOf					: ��� ���������� ���ڿ��� ����
 *  10)	charAt					: �ش� ���ڿ����� ���� �Ѱ��� ������ �ö�
 * 
 */

public class ���ڿ� {
	public static void main(String [] args)
	{
		String str = "hello";
		String str1= "hello";
		String str2 = new String("Hello");
		if(str==str1)
			System.out.println("str ��  str1�� ����.(�ּ�)");
		if(str==str2)
			System.out.println("str ��  str2�� ����.(�ּ�)");
		else
			System.out.println("�ٸ���");
		
		if(str.equalsIgnoreCase(str2))
			System.out.println("str �� str2�� ���� (���ڿ�)");
		
	}
}
