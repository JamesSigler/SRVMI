//Author: Brian Rothschild
public class Item {
	protected double price;
	protected String name;
	protected String itemIdentifier;
	protected String alergies;
	
	
	Item(){
		this.price = 0.0;
		this.name = "Empty";
		this.itemIdentifier = this.name + this.price;
		
		this.alergies = "";
	}
	
	Item(String nm, double pr, String al)
	{
		this.name = nm;
		this.price = pr;
		this.itemIdentifier = this.name + this.price;
		this.alergies = al;
	}

	public String getAlergies() {
		return alergies;
	}

	public void setAlergies(String alergies) {
		this.alergies = alergies;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItemIdentifier() {
		return itemIdentifier;
	}

	public void setItemIdentifier(String itemIdentifier) {
		this.itemIdentifier = itemIdentifier;
	}

	@Override
	public String toString() {
		String output = "";
		
		output += "Item Name : " + this.name + "\n";
		output += "Price     : $" + this.price + "\n";
		output += "Alergies  : " + this.alergies + '\n';
		output += "ID        : " + this.itemIdentifier + "\n";
		return output;
	}
	
	
}
