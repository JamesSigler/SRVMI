//Author: Brian Rothschild
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;  
import java.util.Date;
public class Table {
	//vars
	protected ArrayList<Item> items;
	protected int numPeople;
	protected String tableNumber;
	protected String tableIdentifier;
	protected String startTime;
	protected String endTime;
	protected ArrayList<PayInformation> payInfo;
	
	
	
	public Table() {
		this.items = new ArrayList<Item>();
		this.numPeople = 0;
		this.tableNumber = "NA";
		
		//get start time
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    this.startTime = formatter.format(date);  
		
	    //generate table identifier, this should have no collisions, as well as give some 
	    //general information about the table 
	    this.tableIdentifier = this.tableNumber + this.startTime;
	    
	    
	    //there is no end time yet, the table is still open
	    this.endTime = "";
	    
	    this.payInfo = null;
	}
	
	public Table(int numberOfPeople, String tablNumber) {
		this.items = new ArrayList<Item>();
		this.numPeople = numberOfPeople;
		this.tableNumber = tablNumber;
		
		//get start time
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    this.startTime = formatter.format(date);  
		
	    //generate table identifier, this should have no collisions, as well as give some 
	    //general information about the table 
	    this.tableIdentifier = this.tableNumber + this.startTime;
	    
	    //there is no end time yet, the table is still open
	    this.endTime = "";
	    
	    
	    this.payInfo = null;
	}
	
	//print the object to a form for the csv
	public String printForCsv()
	{
		String output = "";
		
		output += this.tableIdentifier + ",";
		
		output += this.tableNumber + ",";
		
		output += this.numPeople + ",";
		
		output += this.startTime + ",";
		output += this.endTime + ",";

		
		output += this.getCost() + ",";

		
		
		return output;
	}
	
	
	public String printItemsForCsv()
	{
		String output = "";
		
		output += this.tableIdentifier + ",";
		
		for(int i = 0; i < items.size(); i++)
		{
			output += items.get(i).getItemIdentifier() + "/";
		}
		
		
		return output;
	}
	
	
	
	
	public boolean addItem(Item i)
	{
		this.items.add(i);
		return true;
	}

	public double getCost() 
	{
		double spent = 0;
		
		for(int i = 0; i < this.items.size(); i++)
		{
			spent += this.items.get(i).getPrice();
		}
		DecimalFormat df = new DecimalFormat(".##");
		
		
		return Double.parseDouble(df.format(spent));
	}
	
	public double getTax()
	{
		DecimalFormat df = new DecimalFormat(".##");
		return Double.parseDouble(df.format(this.getCost()*.0625));
	}
	
	public double getTotal()
	{
		DecimalFormat df = new DecimalFormat(".##");
		return Double.parseDouble(df.format(this.getCost()+this.getTax()));
	}


	public ArrayList<Item> getItems() {
		return items;
	}




	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}




	public int getNumPeople() {
		return numPeople;
	}




	public void setNumPeople(int numPeople) {
		this.numPeople = numPeople;
	}




	public String getTableNumber() {
		return tableNumber;
	}




	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}




	public String getTableIdentifier() {
		return tableIdentifier;
	}




	public void setTableIdentifier(String tableIdentifier) {
		this.tableIdentifier = tableIdentifier;
	}




	public String getStartTime() {
		return startTime;
	}




	public void setStartTime(String startTime) {
		this.startTime = startTime;
		this.tableIdentifier = this.tableNumber + this.startTime;
	}




	public String getEndTime() {
		return endTime;
	}
	
	public void closeTable()
	{
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    this.endTime = formatter.format(date);  
		 
	}




	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
	
	public ArrayList<PayInformation> getPayInfo() {
		return payInfo;
	}

	public void setPayInfo(PayInformation payInfo) {
		this.payInfo.add(payInfo);
	}
	
	
	public int getNumItems()
	{
		return this.items.size();
	}
	
	
	//print a recepit for the table
	public String printReceipt()
	{
		String receipt = "\t  Resturaunt Name\t";
		receipt += "\n\n";
		receipt += "Table opened at :: " + this.startTime + "\n\n";
		
		for(int i = 0; i < this.items.size(); i++)
		{
			receipt += this.items.get(i).getName();
			for(int j = this.items.get(i).getName().length(); j < ("Table opened at :: " + this.startTime).length() - ("$" + this.items.get(i).getPrice()).length(); j++)
			{
				receipt += ' ';
			}
			receipt += "$" + this.items.get(i).getPrice() + "\n";
		}
		receipt += "\n";
		
		//print the sub total
		receipt += "       SubTotal";
		for(int i = ("SubTotal").length(); i < ("Table opened at :: " + this.startTime).length() - ("       $" + this.getCost()).length(); i++)
		{
			receipt += ' ';
		}
		receipt += "$" + this.getCost();
		receipt += "\n";
		
		//print the tax
		receipt += "       Tax";
		for(int i = ("Tax").length(); i < ("Table opened at :: " + this.startTime).length() - ("       $" + this.getTax()).length(); i++)
		{
			receipt += ' ';
		}
		receipt += "$" + this.getTax();
		receipt += "\n";
		
		//print the total
		receipt += "       Total";
		for(int i = ("Total").length(); i < ("Table opened at :: " + this.startTime).length() - ("       $" + this.getTotal()).length(); i++)
		{
			receipt += ' ';
		}
		receipt += "$" + this.getTotal();
		receipt += "\n\n\n";
		
		//print tip and total line 
		
		receipt += "       Tip";
		for(int i = ("Tip").length(); i < ("Table opened at :: " + this.startTime).length() - ("       ").length(); i++)
		{
			receipt += '_';
		}
		receipt += "\n\n\n";
		
		receipt += "       Total";
		for(int i = ("Total").length(); i < ("Table opened at :: " + this.startTime).length() - ("       ").length(); i++)
		{
			receipt += '_';
		}
		
		
		receipt += "\n\n\n";
		
		//print the signature 
		receipt += "Signature";
		for(int i = ("Signature").length(); i < ("Table opened at :: " + this.startTime).length(); i++)
		{
			receipt += '_';
		}
		
		
		receipt += "\n\n\n";
		return receipt;
	}

	
	/*This method will print the general infomation about the table 
	 * so there is an easy way to get all of the data at one time*/
	public String toString() {
		String output = "";
		
		output += "This table Identifier is " + this.tableIdentifier + "\n";
		
		output += "They are seated at table number " + this.tableNumber + ", and they have " + this.numPeople + " guests\n\n";
		
		//printing the items 
		if(this.items.size() < 1)
		{
			output += "They Have not ordered anything yet";
		}
		else
		{
			output += "Items ordered below\n";
			
			for(int i = 0; i < this.items.size(); i++)
			{
				output += this.items.get(i).toString() + "\n\n";
			}
		}
		
		//print the cost
		
		output += "The cost of the check is $" + this.getCost() + "\n";
		
		//print the times
		
		output += "They entered the restruaunt at :: " + this.startTime + "\n";
		
		//formatting for the endtime 
		
		if(this.endTime.equals(""))
		{
			output += "Their check has not been closed\n\n";
		}
		else
		{
			output += "They left at " + this.endTime + "\n\n";
		}
		
		
		//print pay info if applicable
		if(this.payInfo == null)
		{
			output += "This check has not been paid\n";
		}
		else
		{
			for(int i = 0; i < this.payInfo.size(); i++)
			{
				output += this.payInfo.get(i).toString();
			}
		}
		
		return output;
	}

}
