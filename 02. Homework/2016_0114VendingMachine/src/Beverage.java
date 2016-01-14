
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
		return "���� Ÿ�� : "+type.toString()
		                   + " ���� �̸� : "+name+" ����  : "+price;
	}
	
}
