import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
	List <Beverage> beverages;
	int currentMoney;
	
	
	public VendingMachine()
	{
		beverages = new ArrayList<Beverage>();
		currentMoney=0;
	}
	//����ֱ�
	public void addBeverage(Beverage b)
	{
		beverages.add(b);
		System.out.println(b.toString()+"�� ���Ǳ⿡ �߰��Ǿ����ϴ�.");
	}
	//���ứ��
	public void showMenu()
	{
		System.out.println("==========������ ���� ������� �ֽ��ϴ�.==========");
		for(int i=0; i<beverages.size(); i++)
		{
			System.out.println(i+1+" : "+beverages.get(i).toString());
		}
		System.out.println("======================================");
	}
	
	//���ᱸ��
	public boolean buyBeverage(int index)
	{
		if(index<0 || index>beverages.size())
		{
			System.out.println("�������� �ʴ� �����Դϴ�.");
			return false;
		}
		Beverage b = beverages.get(index-1);
		if(b.getPrice()>currentMoney)
		{
			System.out.println("���� �����մϴ�."); 
			return false;
		}
		System.out.println(b.getName() + " ���� ���� !");
		currentMoney -= b.getPrice();
		beverages.remove(index-1);
		return true;
	}

	//�ݾ�����
	public void addMoney(CurrencyType type)
	{
		currentMoney += type.toInt();
	}
	public int getCurrentMoney()
	{
		return currentMoney;
	}
	//�ݾ׹�ȯ
	public int refundMoney()
	{
		int a = currentMoney;
		currentMoney=0;
		return a;
	}
	//�ܵ�ǥ��
	public void showCurrentMoney()
	{
		System.out.println(currentMoney);
	}
}
