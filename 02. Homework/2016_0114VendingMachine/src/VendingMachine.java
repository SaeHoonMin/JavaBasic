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
	//음료넣기
	public void addBeverage(Beverage b)
	{
		beverages.add(b);
		System.out.println(b.toString()+"가 자판기에 추가되었습니다.");
	}
	//음료빼기
	public void showMenu()
	{
		System.out.println("==========다음과 같은 음료들이 있습니다.==========");
		for(int i=0; i<beverages.size(); i++)
		{
			System.out.println(i+1+" : "+beverages.get(i).toString());
		}
		System.out.println("======================================");
	}
	
	//음료구매
	public boolean buyBeverage(int index)
	{
		if(index<0 || index>beverages.size())
		{
			System.out.println("존재하지 않는 음료입니다.");
			return false;
		}
		Beverage b = beverages.get(index-1);
		if(b.getPrice()>currentMoney)
		{
			System.out.println("돈이 부족합니다."); 
			return false;
		}
		System.out.println(b.getName() + " 구매 성공 !");
		currentMoney -= b.getPrice();
		beverages.remove(index-1);
		return true;
	}

	//금액투입
	public void addMoney(CurrencyType type)
	{
		currentMoney += type.toInt();
	}
	public int getCurrentMoney()
	{
		return currentMoney;
	}
	//금액반환
	public int refundMoney()
	{
		int a = currentMoney;
		currentMoney=0;
		return a;
	}
	//잔돈표시
	public void showCurrentMoney()
	{
		System.out.println(currentMoney);
	}
}
