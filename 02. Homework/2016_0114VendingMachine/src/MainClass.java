
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendingMachine vMachine = new VendingMachine();
		
		vMachine.addBeverage(new Beverage(BeverageType.SODA,"�ζ���Ҵ�",1500));
		vMachine.addBeverage(new Beverage(BeverageType.MILK,"���ڿ���",1500));
		vMachine.addBeverage(new Beverage(BeverageType.WATER,"�����",1000));
		vMachine.addBeverage(new Beverage(BeverageType.WATER,"���ټ�",500));
		vMachine.addBeverage(new Beverage(BeverageType.JUICE,"��Ű��Ʈ ������",700));
		
		Human human = new Human("Seny", 15000);
		System.out.println("����� �̸��� " +human.getName()+"�̸�, ���� ���� "+human.getMoney()+"�Դϴ�.");
		System.out.println("���Ǳ⿡ �����մϴ�.");
		System.out.println("���� ���Ÿ� �����մϴ�...");
		human.buyBeverage(vMachine);
		
	}

}
