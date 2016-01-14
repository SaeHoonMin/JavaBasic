
public class Beverage {
	private BeverageType type;
	private String name;
	private int price;
	
	public Beverage(BeverageType type, String name, int price)
	{
		this.type = type;
		this.name = new String(name);
		this.price = price;
	}

	public BeverageType getType() {
		return type;
	}


	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String toString()
	{
		return "음료 타입 : "+type.toString()
		                   + " 음료 이름 : "+name+" 가격  : "+price;
	}
	
}
