//Author: Brian Rothschild
public class InventoryItem {
	protected Item itm;
	protected int quantity;
	
	InventoryItem()
	{
		this.itm = new Item();
		this.quantity = 0;
	}
	
	InventoryItem(Item i, int q)
	{
		this.itm = i;
		this.quantity = q;
	}
	
	public boolean hasStock()
	{
		return this.quantity > 0;
	}
	
	public Item getItm() {
		return itm;
	}
	public void setItm(Item itm) {
		this.itm = itm;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getItemType()
	{
		String out = itm.getClass() + "";
		return out.substring(6);
	}
	
	public String printForCsv()
	{
		String output = "";
		
		output += this.itm.getItemIdentifier() + ",";
		
		output += this.quantity;
		
		
		return output;
	}

	@Override
	public String toString() {
		String output = "";
		output += this.itm.toString();
		output += "There are " + this.quantity + " of them in stock.";
		return output;
	}
	
	
	
}
