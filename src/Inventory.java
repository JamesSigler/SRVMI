import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class Inventory {
	protected ArrayList<InventoryItem> items;
	
	Inventory()
	{
		this.items = new ArrayList<InventoryItem>();
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
		
		//The inventory object holds all of the data
		Inventory inven = new Inventory();
		
		
		
		
		/*====================================================================================================================================================================================================================================
		 * 
		 * //make a bunch of fake inventory
		 * 
		 * 
		 * 
		 * 
		 * 
		 *====================================================================================================================================================================================================================================
		 * */
		
		
		
		
		
		
		
		//random data to fill all objects
		
		String drinkNames[] = {"Water", "Coke", "Dr. Pepper", "Sprite", "Diet Coke", "Diet Dr. Pepper", "Diet Sprite", "Sweet Tea", "UnSweet Tea", "Beer", "Mixed Drink"};
		String appNames[] = {"Chips and Queso", "Chips and Guacamole", "Chips and Salsa", "Fried Pickles", "Mozzarella Sticks", "Soup of the Day", "Salad", "Onion Rings"};
		String entreeNames[] = {"Burger", "Hot Dog", "Pizza", "Pasta", "Quesidilla", "Tacos", "Salad", "Ribs", "Chicken Strips", "Chicken Nuggets", "Chicken Salad", "Sandwiches", 
				"Salmon", "Tuna", "Steak", "Mac & Cheese"};
		String dessertNames[] = {"Ice Cream", "Chocolate Cake", "Vanilla Cake", "Apple Pie", "Cherry Pie", "Brownies", "Cookies"};
		String alergiesNames[] = {"None", "Gluten", "Dairy", "Peanuts"};
		
		
		//number of each type
		int numBevs = 10;
		int numApps = 30;
		int numEntr = 50;
		int numDesr = 10;
		
		DecimalFormat df = new DecimalFormat(".##");
		Double db = 0.0;
		Random ran = new Random();
		
		
		
		//add beverages
		for(int i = 0; i < numBevs; i++)
		{
			//new InventoryItem(new Beverage(drinkNames[ran.nextInt(drinkNames.length)], ran.nextDouble()*100, alergiesNames[ran.nextInt(drinkNames.length)], false),ran.nextInt(100)), ran.nextInt()
			
			
			
			db = Double.parseDouble(df.format(ran.nextDouble()*10));
			inven.addInventoryItem(new InventoryItem(new Beverage(drinkNames[ran.nextInt(drinkNames.length)], db, alergiesNames[ran.nextInt(alergiesNames.length)], ran.nextBoolean()), ran.nextInt(100)));
		}
		
		//add appetizers
		for(int i = 0; i < numApps; i++)
		{
			db = Double.parseDouble(df.format(ran.nextDouble()*10));
			inven.addInventoryItem(new InventoryItem(new Appetizer(appNames[ran.nextInt(appNames.length)], db, alergiesNames[ran.nextInt(alergiesNames.length)], ran.nextBoolean(), ran.nextInt(5)), ran.nextInt(100)));
		}
		
		//add entree
		for(int i = 0; i < numEntr; i++)
		{
			db = Double.parseDouble(df.format(ran.nextDouble()*100));
			inven.addInventoryItem(new InventoryItem(new Entree(entreeNames[ran.nextInt(entreeNames.length)], db, alergiesNames[ran.nextInt(alergiesNames.length)], ran.nextBoolean(), ran.nextInt(5)), ran.nextInt(100)));
		}
		
		//add deserts
		for(int i = 0; i < numDesr; i++)
		{
			db = Double.parseDouble(df.format(ran.nextDouble()*20));
			inven.addInventoryItem(new InventoryItem(new Dessert(dessertNames[ran.nextInt(dessertNames.length)], db, alergiesNames[ran.nextInt(alergiesNames.length)], ran.nextBoolean(), ran.nextInt(5)), ran.nextInt(100)));
		}
		
		
		/*====================================================================================================================================================================================================================================
		 * 
		 * After this mark the inventory will be full of random objects to display and such 
		 * 
		 * 
		 * I am working on bringing on this info from the DB but this should help for display purposes 
		 *
		 * 
		 * 
		 * 
		 * 
		 * 
		 *====================================================================================================================================================================================================================================
		 * */
		
		
		
		/*
		//Checking all of the inventory types
		ArrayList<Beverage> ray = inven.getBeverages();
		
		for(int i = 0; i < ray.size(); i++)
		{
			System.out.println((i+1) + ") " + ray.get(i) + "\n");
		}
		
		ArrayList<Appetizer> ray1 = inven.getAppetizer();
		
		for(int i = 0; i < ray1.size(); i++)
		{
			System.out.println((i+1) + ") " + ray1.get(i) + "\n");
		}
		
		ArrayList<Entree> ray2 = inven.getEntree();
		
		for(int i = 0; i < ray2.size(); i++)
		{
			System.out.println((i+1) + ") " + ray2.get(i) + "\n");
		}
		
		ArrayList<Dessert> ray3 = inven.getDessert();
		
		for(int i = 0; i < ray3.size(); i++)
		{
			System.out.println((i+1) + ") " + ray3.get(i) + "\n");
		}
		
		
		*/
	}
}
