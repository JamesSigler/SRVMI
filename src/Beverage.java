//Author: Brian Rothschild
public class Beverage extends Item {
	
	//object vars
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
	
	//construct via the csv line
	Beverage(String csvLine[])
	{
		super(csvLine[1], Double.parseDouble(csvLine[2]), csvLine[3]);
		
		if(csvLine[4].equals("TRUE"))
		{
			this.hasAlcohol = true;
		}
		else
		{
			this.hasAlcohol = false;
		}
		this.itemIdentifier = csvLine[0];
		
		
	}

	public boolean isHasAlcohol() {
		return hasAlcohol;
	}

	public void setHasAlcohol(boolean hasAlcohol) {
		this.hasAlcohol = hasAlcohol;
	}
	
	public String printToCSV()
	{
		String output = "";
		
		output += this.itemIdentifier + ",";
		
		output += this.name + ",";
		
		output += this.price + ",";
		
		output += this.alergies + ",";
		
		output += this.hasAlcohol + "";
		
		
		return output;
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
