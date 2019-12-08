
public class Beverage extends Item {
	protected boolean hasAlcohol;
	
	Beverage()
	{
		super();
		this.hasAlcohol = false;
	}
	
	Beverage(String nm, double pr, String al, boolean hA)
	{
		super(nm, pr, al);
		this.hasAlcohol = hA;
	}

	public boolean isHasAlcohol() {
		return hasAlcohol;
	}

	public void setHasAlcohol(boolean hasAlcohol) {
		this.hasAlcohol = hasAlcohol;
	}

	@Override
	public String toString() {
		String output = "";
		
		output += super.toString();
		
		if(this.hasAlcohol)
		{
			output += "This Drink Contains Alcohol" + "\n";
		}
		else
		{
			output += "This Drink Does Not Contain Alcohol" + "\n";
		}
		
		return output;
	}
	
}
