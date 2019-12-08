public class Appetizer extends Item {
	protected boolean forTable;
	protected int serves;
	
	Appetizer()
	{
		super();
		this.forTable = false;
		this.serves = 0;
	}
	Appetizer(String nm, double pr, String al, boolean fT, int svrs)
	{
		super(nm, pr, al);
		this.forTable = fT;
		this.serves = svrs;
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
		output += "This appetizer serves " + this.serves + " people.\n";
		
		return output;
	}
	
}
