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
	/* 음료 관련 */
	public void insertMoney(VendingMachine target,
			CurrencyType type)
	{
		if( money< type.toInt() )
		{	
			System.out.println("가진 돈이 부족합니다.");
			return;
		}
		target.addMoney(type);
		money -= type.toInt();
	}
	public void refundMoney(VendingMachine target)
	{
		int a = target.refundMoney();
		if(a==0)
			System.out.println("돌려받을 잔돈이 없습니다.");
		money+=a;
	}
	public void buyBeverage(VendingMachine target)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("투입할 금액을 정하세요.");
		System.out.println("0 : 종료 , 1 : 5000원, 2: 1000원, 3: 500원, 4: 100원");
		while (true) {
			System.out.print("가진돈("+money+") 넣은돈("+target.getCurrentMoney()+") 입력 : ");
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
				System.out.println("잘못된 입력입니다. ");
				continue;
			}
		}
		System.out.println();
		target.showMenu();
		while(true)
		{
			System.out.println("구매할 음료 번호를 선택하세요.");
			System.out.print("남은돈("+target.getCurrentMoney()+") 입력  (0 to quit):");
			int input = scan.nextInt();
			if(input ==0)
				break;
			
			if(	target.buyBeverage(input) );
			{
				System.out.println();
				target.showMenu();
			}
		}
		System.out.println("\n 음료 구매가 완료되었습니다. 거스름돈을 반환받습니다.");
		refundMoney(target);
		System.out.println("거스름돈 받고 남은 돈 : "+ money);
	}
}
