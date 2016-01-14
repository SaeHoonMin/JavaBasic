
public enum CurrencyType {
	_5000won,_1000won,_500won,_100won;
	
	public String toString()
	{
		switch(this)
		{
			case _5000won:
				return "5000원";
			case _1000won:
				return "1000원";
			case _500won:
				return "500원";
			case _100won:
				return "100원";
			default:
				return "Undefined";
		}
	}
	public int toInt()
	{
		switch(this)
		{
			case _5000won:
				return 5000;
			case _1000won:
				return 1000;
			case _500won:
				return 500;
			case _100won:
				return 100;
			default:
				return 0;
		}
	}
}
