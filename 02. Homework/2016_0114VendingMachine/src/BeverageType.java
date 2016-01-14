
public enum BeverageType {
	SODA, MILK, WATER, JUICE;
	public String toString()
	{
		switch(this)
		{
			case SODA:
				return "Soda";
			case MILK:
				return "Milk";
			case WATER:
				return "Water";
			case JUICE:
				return "Juice";
			default:
				return "Undefined";
		}
	}
}
