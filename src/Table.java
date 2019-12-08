import java.util.ArrayList;
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
	}




	public String getEndTime() {
		return endTime;
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

	
	/*This method will print the general infomation about the table 
	 * so there is an easy way to get all of the data at one time*/
	@Override
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
