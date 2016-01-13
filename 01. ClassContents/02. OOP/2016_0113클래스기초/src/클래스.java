import java.util.Scanner;

import javax.swing.JOptionPane;

/*
 *    Ŭ���� ���� ���� 
 *      ����  ==> �迭  ==> ����ü  ==> Ŭ���� 
 *      : �����͸� ��Ƽ� ���� 
 *      ���� : ���� �����͸� �����ؼ� ���
 *      �迭 : ���� ũ���� �����͸� �����ؼ� ���
 *      ����ü : �ٸ� ũ���� �����͸� ��Ƽ� ��� (��� ������=>����)
 *      Ŭ���� : ����ü + �޼ҵ� (�����)
 *    Ŭ������ ���� ��� 
 *      ������(�Ӽ�)
 *        => ������� 
 *            ���뺯��(Ŭ��������) ==> static 
 *            ��ü���� (�ν��Ͻ� ����) ==> (X)
 *            ���� 
 *              class A
 *              {
 *                 int a;
 *                 static int b;
 *              }
 *              b������ Ŭ������ ����ӽ� �о��� ��쿡 ���� 
 *              a������ ���� ���� �����Ŀ� ����� ���� (new)
 *              A aa=new A();
 *              stack
 *              == aa
 *              100          heap
 *              ==           === 100
 *                            a
 *                           ===
 *      �޼ҵ�(���) : ����� ������ ���ؼ� ���� ���� 
 *      
 *      Ŭ���� ���� 
 *      1) �߻�ȭ �۾� : ����(�𵨸�)
 *          => ���Ǽ����� ��� �繰�� �ܼ�ȭ 
 *          ��� 
 *          =========
 *           �̸�
 *           ����
 *           �ֹι�ȣ
 *           ��
 *           �� 
 *           ��
 *           ��
 *           ===========
 *             �� => ���ϴ�
 *             �� => ��´�
 *             �� => ����
 *           ===========
 *      2) ��üȭ �۾� : �𵨸� ������ ��ķ��̼� 
 *      
 *      1) ���� ==> �迭 , Ŭ����
 *      2) ��ɹ� ==> �޼ҵ�
 *      3) Ŭ���� ==> ��Ű��
 *      
 *      ======================
 *      Ŭ���� ����( java )
 *      1) package
 *      2) import ==> ������ 
 *      3) class className
 *         {
 *             ���� ����
 *            ============
 *             �޼ҵ� ����
 *            ============
 *             ������ ���� => ����
 *            ============
 *         }
 *         
 *      ���ھ߱����� 
 *      ���� �߻�    ==> com[]
 *      �Է�           ==> user[]
 *      ��           ==> com[],user[] ==> s,b
 *      ��Ʈ          ==> s,b
 *      ����         ==> s
 */

/*
 * 
 * 	���� : extends Object
 * 		 import java.lang*
 * 				==========
 * 				String, Math, System..
 * 		 
 * 
 * 
 */
public class Ŭ���� {
	
	int [] com = new int [3] ; 
	int [] user = new int [3];
    int s, b;
    
    void getRand()
    {
    	for(int i=0;i<3;i++)
    	{
    		com[i] = (int)(Math.random()*9);
    		for(int j=0;j<i;j++)
    		{
    			if(com[i]==com[j])
    				i--;
    		}
    	}
    }
    void userInput()
    {
    	int num;
    	while(true)
    	{
    		String input = JOptionPane.showInputDialog("�� �ڸ� ���� �Է�");
    		num = Integer.parseInt(input);
    		if(num>999 || num<0)
    		{
    			JOptionPane.showMessageDialog(null, "�� �ڸ� ������ �Է��ؾ� �մϴ�.");
    			continue;
    		}
    		user[0] = input.charAt(0)-'0';
    		user[1] = input.charAt(1)-'0';
    		user[2] = input.charAt(2)-'0';
    		if(user[0] == user[1] || user[0]==user[2] || user[1]==user[2])
    		{
    			JOptionPane.showMessageDialog(null, "�ߺ��� ���� ���Ұ�");
    			continue;
    		}
    		else
    			break;
    	}
    }
    void hint()
    {
    	System.out.printf("Input Number : %d-%d-%d\nResult:%dS-%dB\n",
    						user[0],user[1],user[2],s,b);
    }
    void compare()
    {
    	s=0;
    	b=0;
    	for(int i=0; i<3;i++)
    	{
    		for(int j=0;j<3;j++)
    		{
    			if(i==j && com[i]==user[j])
    				s++;
    			else if(com[i]==user[j])
    				b++;
    		}
    	}
    }
    boolean isEnd()
    {
    	if(s==3)
    		return true;
    	return false;
    }
    void process()
    {
    	getRand();
    	while(true)
    	{
    	 	userInput();
        	compare();
        	hint();
        	if(isEnd())
        	{
        		int a = JOptionPane.showConfirmDialog(null, 
        				"�����ұ��? ","����",JOptionPane.YES_NO_OPTION);
        		if(a==JOptionPane.YES_OPTION)
        		{
        			JOptionPane.showMessageDialog(null, "������ �����Ѵ�.");
        			System.exit(0);
        		}
        		else
        		{
        			JOptionPane.showMessageDialog(null, "�� ������ ���۵Ǿ���");
        			process();
        		}        			
        	}
    	}
   
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ŭ���� myClass = new Ŭ����();
		myClass.process();
	}

}
