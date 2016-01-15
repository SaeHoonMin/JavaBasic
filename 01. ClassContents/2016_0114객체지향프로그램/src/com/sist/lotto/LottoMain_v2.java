package com.sist.lotto;

import javax.swing.JOptionPane;

public class LottoMain_v2 {
	
	int [] lotto = new int[7];
	int [] user = new int [6];

	int count = 0;
	
	//���� �߻� �޼ҵ�
	void getRand()
	{
		boolean bDash;
		int su = 0;
		for(int i=0;i<7;i++)
		{
			bDash=true;
			while(bDash)
			{
				su=(int)(Math.random()*45)+1;
				bDash=false;
				for(int j=0;j<i;j++)
				{
					if(lotto[j]==su)
					{
						bDash=true;
						break;
					}
				}
			}
			lotto[i]=su;
			
		}
	}

	void sort(int[] arr){
		
		int length = arr.length;
		if(length==7)
			length--;
		
		for (int i = 0; i < length-1; i++) {
			for (int j = i+1; j < length; j++) {
				if (lotto[i] > lotto[j]){
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
	}
	
	void print(int [] arr)
	{
		for(int e : arr)
			System.out.print(e + " ");
		System.out.println();
	}
	void process()
	{
		getRand();
		sort(lotto);
		print(lotto);
		System.out.println();
		userInput();
		sort(user);
		print(user);
		check();
		showResult();
	}
	
	void userInput()
	{
		for (int i = 0; i < user.length; i++) {
			String strNum = JOptionPane.showInputDialog("1~45���� ���� �Է�:");
			int num = Integer.parseInt(strNum);
			// ���������� (���ڿ�)
			// �� �������� => ����� ó�� �Ҽ� �ְ� ���� Ŭ���� : Wrapper
			// int => Integer, byte=>Byte, Double...
			// => ������,��(������ ����� �� ����) ==> ���������� ����
			if (num < 1 || num > 45) {
				JOptionPane.showMessageDialog(null, "�߸��� �Է��Դϴ�!!");
				i--;
				continue;// ������
			}
			int a = 0;
			for (int j = 0; j < i; j++) {
				if (num == user[j]) {
					a = 1;
					break;
				}
			}
			if (a == 0) {
				user[i] = num;
			} else {
				JOptionPane.showMessageDialog(null, "�ߺ��� ���� ��� �� �� �����ϴ�");
				i--;
				continue;
			}
		}
	}
	
	void check(){
		for (int i = 0; i < lotto.length - 1; i++) {
			for (int j = 0; j < user.length; j++) {
				if (lotto[i] == user[j]) {
					count++;
				}
			}
		}
	}
	
	void showResult()
	{
		int b = 0;
		String result = "";
		if (count == 5) {
			for (int i = 0; i < user.length; i++) {
				if (user[i] == lotto[6]) {
					b = 1;
					result = "�����մϴ�\n2�� ��÷�Դϴ�!!";
				}
			}
		}

		switch (count) {
		case 3:
			result = "�����մϴ�\n5�� ��÷�Դϴ�!!";
			break;
		case 4:
			result = "�����մϴ�\n4�� ��÷�Դϴ�!!";
			break;
		case 5:
			if (b != 1)
				result = "�����մϴ�\n3�� ��÷�Դϴ�!!";
			break;
		case 6:
			result = "�����մϴ�\n1�� ��÷�Դϴ�!!";
			break;
		default:
			result = "��÷�Դϴ�!!";
		}
		JOptionPane.showMessageDialog(null, result);

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LottoMain_v2 lmain = new LottoMain_v2();
		lmain.process();
	}

}
