import java.util.Scanner;

public class Human {
	private String name;
	private int money;
	
	public Human(String name, int money)
	{
		this.name = new String(name);
		this.money = money;
	}
	public int getMoney()
	{
		return money;
	}
	public String getName()
	{
		return name;
	}
	/* ���� ���� */
	public void insertMoney(VendingMachine target,
			CurrencyType type)
	{
		if( money< type.toInt() )
		{	
			System.out.println("���� ���� �����մϴ�.");
			return;
		}
		target.addMoney(type);
		money -= type.toInt();
	}
	public void refundMoney(VendingMachine target)
	{
		int a = target.refundMoney();
		if(a==0)
			System.out.println("�������� �ܵ��� �����ϴ�.");
		money+=a;
	}
	public void buyBeverage(VendingMachine target)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("������ �ݾ��� ���ϼ���.");
		System.out.println("0 : ���� , 1 : 5000��, 2: 1000��, 3: 500��, 4: 100��");
		while (true) {
			System.out.print("������("+money+") ������("+target.getCurrentMoney()+") �Է� : ");
			int input = scan.nextInt();
			if (input == 0)
				break;
			switch (input) {
			case 1:
				insertMoney(target, CurrencyType._5000won);
				break;
			case 2:
				insertMoney(target, CurrencyType._1000won);
				break;
			case 3:
				insertMoney(target, CurrencyType._500won);
				break;
			case 4:
				insertMoney(target, CurrencyType._100won);
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�. ");
				continue;
			}
		}
		System.out.println();
		target.showMenu();
		while(true)
		{
			System.out.println("������ ���� ��ȣ�� �����ϼ���.");
			System.out.print("������("+target.getCurrentMoney()+") �Է�  (0 to quit):");
			int input = scan.nextInt();
			if(input ==0)
				break;
			
			if(	target.buyBeverage(input) );
			{
				System.out.println();
				target.showMenu();
			}
		}
		System.out.println("\n ���� ���Ű� �Ϸ�Ǿ����ϴ�. �Ž������� ��ȯ�޽��ϴ�.");
		refundMoney(target);
		System.out.println("�Ž����� �ް� ���� �� : "+ money);
	}
}
