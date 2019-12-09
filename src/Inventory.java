//Author: Brian Rothschild
import java.util.ArrayList;


public class Inventory {
	protected ArrayList<InventoryItem> items;
	
	Inventory()
	{
		this.items = new ArrayList<InventoryItem>();
	}
	Inventory(ArrayList<InventoryItem> itms)
	{
		this.items = itms;
	}
	
	public void addInventoryItem(InventoryItem nw)
	{
		this.items.add(nw);
	}
	public void addItem(Item it)
	{
		this.items.add(new InventoryItem(it, 0));
	}
	
	
	@Override
	public String toString() {
		String output = "";
		
		for(int i = 0; i < this.items.size(); i++)
		{
			output += this.items.get(i).toString();
			output += "\n\n\n";
		}
		
		return output;
	}
	
	
	//get all the Beverages in an arraylist
	public ArrayList<Beverage> getBeverages()
	{
		ArrayList<Beverage> out = new ArrayList<Beverage>();
		
		for(int i = 0; i < this.items.size(); i++)
		{
			if((this.items.get(i).getItm().getClass() + "").substring(6).equals("Beverage"))
			{
				out.add((Beverage) this.items.get(i).getItm());
			}
		}
		
		
		return out;
	}
	
	
	//get all the Appetizers in an arraylist
	public ArrayList<Appetizer> getAppetizer()
	{
		ArrayList<Appetizer> out = new ArrayList<Appetizer>();
		
		for(int i = 0; i < this.items.size(); i++)
		{
			if((this.items.get(i).getItm().getClass() + "").substring(6).equals("Appetizer"))
			{
				out.add((Appetizer) this.items.get(i).getItm());
			}
		}
		
		
		return out;
	}
	
	
	//get all the Entrees in an arraylist
	public ArrayList<Entree> getEntree()
	{
		ArrayList<Entree> out = new ArrayList<Entree>();
		
		for(int i = 0; i < this.items.size(); i++)
		{
			if((this.items.get(i).getItm().getClass() + "").substring(6).equals("Entree"))
			{
				out.add((Entree) this.items.get(i).getItm());
			}
		}
		
		
		return out;
	}
	
	
	//get all the desserts in an arraylist
	public ArrayList<Dessert> getDessert()
	{
		ArrayList<Dessert> out = new ArrayList<Dessert>();
		
		for(int i = 0; i < this.items.size(); i++)
		{
			if((this.items.get(i).getItm().getClass() + "").substring(6).equals("Dessert"))
			{
				out.add((Dessert) this.items.get(i).getItm());
			}
		}
		
		
		return out;
	}
	
	
	
	
	public static void main(String[] args) {
		
				
	}
}
