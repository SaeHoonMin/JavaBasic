/*
 *   ������� (Ŭ���� ����ñ��� ����� ����)
 *     = static : Ŭ�������� (Ŭ�������� ���ؼ� ����� ����)
 *                => ���� Ŭ���� ��ü�� �������� ���Ǵ� ����
 *                => ���� �ӽ��� 
 *                   Ŭ�����δ��� ���ؼ� �ε�Ǿ��� �޸� �Ҵ�
 *                   �޼ҵ念���� ����
 *       class A
 *       {
 *          static int age;
 *       }
 *       A a=new A(); // age
 *       A a1=new A(); // age
 *     = instance : ��ü���� (��ü�� �����ϰ� ����� ����)
 *       heap����
 */
import javax.swing.*;
public class ������� {
    String name;// null
    String phoneNumber;
    String addr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
                  ������� a=new �������();// name������ ���� 
        a.name=JOptionPane.showInputDialog("�̸� �Է�");
        a.phoneNumber = JOptionPane.showInputDialog("�� �� �� �� �� �� �� ");
        a.addr = JOptionPane.showInputDialog("�ּ� �Է� : ");
        JOptionPane.showMessageDialog(null, a.name +"\n" 
        								   + a.phoneNumber + "\n"
        								   + a.addr);
       
	}

}



