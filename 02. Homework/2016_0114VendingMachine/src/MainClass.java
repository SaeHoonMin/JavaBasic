
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendingMachine vMachine = new VendingMachine();
		
		vMachine.addBeverage(new Beverage(BeverageType.SODA,"부라더소다",1500));
		vMachine.addBeverage(new Beverage(BeverageType.MILK,"초코에몽",1500));
		vMachine.addBeverage(new Beverage(BeverageType.WATER,"에비앙",1000));
		vMachine.addBeverage(new Beverage(BeverageType.WATER,"육다수",500));
		vMachine.addBeverage(new Beverage(BeverageType.JUICE,"문키스트 오렌지",700));
		
		Human human = new Human("Seny", 15000);
		System.out.println("당신의 이름은 " +human.getName()+"이며, 가진 돈은 "+human.getMoney()+"입니다.");
		System.out.println("자판기에 접근합니다.");
		System.out.println("음료 구매를 시작합니다...");
		human.buyBeverage(vMachine);
		
	}

}
