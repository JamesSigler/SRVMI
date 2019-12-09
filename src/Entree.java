//Author: Brian Rothschild
public class Entree extends Item {
	protected boolean forTable;
	protected int serves;
	
	Entree()
	{
		super();
		this.forTable = false;
		this.serves = 0;
	}
	Entree(String nm, double pr, String al, boolean fT, int svrs)
	{
		super(nm, pr, al);
		this.forTable = fT;
		this.serves = svrs;
	}
	
	
	//construct via the csv
	Entree(String csvLine[])
	{
		super(csvLine[1], Double.parseDouble(csvLine[2]), csvLine[3]);
		
		if(csvLine[4].equals("TRUE"))
		{
			this.forTable = true;
		}
		else
		{
			this.forTable = false;
		}
		
		this.serves = Integer.parseInt(csvLine[5]);
		this.itemIdentifier = csvLine[0];
		
		
	}
	
	public void setForTable(boolean ft)
	{
		this.forTable = ft;
	}
	
	public void setServer(int srvs)
	{
		this.serves = srvs;
	}
	
	public boolean getForTable()
	{
		return this.forTable;
	}
	
	public int getServes()
	{
		return this.serves;
	}
	
	public String printToCSV()
	{
		String output = "";
		
		output += this.itemIdentifier + ",";
		
		output += this.name + ",";
		
		output += this.price + ",";
		
		output += this.alergies + ",";
		
		output += this.forTable + ",";
		
		output += this.serves + "";
		
		
		return output;
	}
	
	@Override
	public String toString() {
		String output = "";
		
		output += super.toString();
		
		if(this.forTable)
		{
			output += "This Serves the whole table. \n";
		}
		else
		{
			output += "This doesn't serve the whole table \n";
		}
		output += "This entree serves " + this.serves + " people.\n";
		
		return output;
	}
}
