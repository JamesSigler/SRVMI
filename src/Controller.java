import java.util.ArrayList;
public class Controller {

	protected Inventory inventory;
	protected ArrayList<Table> tables;
	
	
	Controller()
	{
		this.inventory = new Inventory();
		this.tables = new ArrayList<Table>();
	}
	
	Controller(Inventory i, ArrayList<Table> ts)
	{
		this.inventory = i;
		this.tables = ts;
	}
	
	public void addTable(Table t)
	{
		this.tables.add(t);
	}
	
	public boolean remTable(String tableID)
	{
		for(int i = 0; i < this.tables.size(); i ++)
		{
			if (this.tables.get(i).getTableIdentifier().equals(tableID))
			{
				//when DB is set up you'll need to use this to commit it to the DB
				this.tables.remove(i);
				return true;
			}
		}
		
		//if ID is never found return false 
		return false;
	}
	
	public void addInventoryItem(InventoryItem ii)
	{
		this.inventory.addInventoryItem(ii);
	}
	
	public void addItem(Item i)
	{
		this.inventory.addItem(i);
	}
	
	@Override
	public String toString() {
		return "Not sure this needs a toString but Ill just generate it now ";
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public ArrayList<Table> getTables() {
		return tables;
	}

	public void setTables(ArrayList<Table> tables) {
		this.tables = tables;
	}


}
