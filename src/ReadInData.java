//Author: Brian Rothschild
import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;

public class ReadInData {

	protected String rootPath;
	
	ReadInData()
	{
		this.rootPath = "C:/Users/brian/Desktop/TableFolder/";
	}
	ReadInData(String path)
	{
		this.rootPath = path;
	}
	
	public Controller initData()
	{
		Controller control = new Controller();
		
		//Init Buffer to read in files
		
		//init buffer reader
		BufferedReader csvReader;
		
		
		//arrayLists to hold info from the CSV's
		ArrayList<String[]> itemInfoArrays = new ArrayList<String[]>();
		ArrayList<String[]> tableInfoArrays = new ArrayList<String[]>();
		ArrayList<String[]> inventoryRows = new ArrayList<String[]>();
		ArrayList<InventoryItem> inventory = new ArrayList<InventoryItem>();
		
		

		//will hold all of the items, to be put together with the InventoryItems
		ArrayList<Item> wholeMenu = new ArrayList<Item>();
		
		
		//temp Vars
		String row;
		
		/*
		 * 
		 * Read in the whole menu from the files
		 * 
		 * */
		
		//read in the whole menu
		
		
		//beverages
		try
		{
			csvReader = new BufferedReader(new FileReader(this.rootPath + "menu/beverageInfo.csv"));
			
			
			//get rid of header line
			csvReader.readLine();
			
			
			while ((row = csvReader.readLine()) != null) {
			    wholeMenu.add(new Beverage(row.split(",")));
			    // do something with the data
			}
			
			
			csvReader.close();
			
			

			
			
			
		}
		catch (Exception e)
		{
			System.out.println("Error Getting Beverage info");
		}
		
		
		//appetizers
		try
		{
			csvReader = new BufferedReader(new FileReader(this.rootPath + "menu/appetizerInfo.csv"));
			
			//get rid of header line
			csvReader.readLine();			
			
			while ((row = csvReader.readLine()) != null) {
			    wholeMenu.add(new Appetizer(row.split(",")));
			    // do something with the data
			}
			
			
			csvReader.close();
			
			

			
			
			
		}
		catch (Exception e)
		{
			System.out.println("Error Getting appetizer info");
		}
		
		
		
		
		//entrees 
		try
		{
			csvReader = new BufferedReader(new FileReader(this.rootPath + "menu/entreeInfo.csv"));
			
			//get rid of header line
			csvReader.readLine();
			
			while ((row = csvReader.readLine()) != null) {
			    wholeMenu.add(new Entree(row.split(",")));
			    // do something with the data
			}
			
			
			csvReader.close();
			
			

			
			
			
		}
		catch (Exception e)
		{
			System.out.println("Error Getting Entree info");
		}
		
		
		//Desserts
		try
		{
			csvReader = new BufferedReader(new FileReader(this.rootPath + "menu/dessertInfo.csv"));
			
			//get rid of header line
			csvReader.readLine();
			
			while ((row = csvReader.readLine()) != null) {
			    wholeMenu.add(new Dessert(row.split(",")));
			    // do something with the data
			}
			
			
			csvReader.close();
			
			

			
			
			
		}
		catch (Exception e)
		{
			System.out.println("Error Getting dessert info");
		}
		
		
		
		//now I need to link the inventory with all of the items that I got in the previous gets
		
		
		
		
		
		
		//read in the inventory 
		try
		{
			csvReader = new BufferedReader(new FileReader(this.rootPath + "inventory.csv"));
			
			//get rid of header line
			csvReader.readLine();
			
			while ((row = csvReader.readLine()) != null) {
				inventoryRows.add(row.split(","));
			    // do something with the data
			}
			//inventory
			
			csvReader.close();
			
			for(int i = 0; i < inventoryRows.size(); i++)
			{
				for(int j = 0; j < wholeMenu.size(); j++)
				{
					
					
					if(inventoryRows.get(i)[0].equals(wholeMenu.get(j).getItemIdentifier()))
					{
						inventory.add(new InventoryItem(wholeMenu.get(j), Integer.parseInt(inventoryRows.get(i)[1])));
						j = wholeMenu.size();
					}
				}
			}
			
			
			
			

			
			
			
		}
		catch (Exception e)
		{
			System.out.println("Error Getting Inventory info");
		}
		
		
		
		
		
		
		
		/*
		 * 
		 * Read in all of the table and their items ordered 
		 * 
		 * */
		
		//load in all table info
		try
		{
			csvReader = new BufferedReader(new FileReader(this.rootPath + "tableInfo.csv"));
			
			//get rid of header line
			csvReader.readLine();
			
			while ((row = csvReader.readLine()) != null) {
			    tableInfoArrays.add(row.split(","));
			    // do something with the data
			}
			
			
			csvReader.close();
			
			
			
			
			
		}
		catch (Exception e)
		{
			System.out.println("Error Getting Table info");
		}
		
		
		//load in all table info
		try
		{
			csvReader = new BufferedReader(new FileReader(this.rootPath + "itemInfo.csv"));
			
			//get rid of header line
			csvReader.readLine();
			
			while ((row = csvReader.readLine()) != null) {
			    itemInfoArrays.add(row.split(","));
			    // do something with the data
			}
			
			
			csvReader.close();
			
			
			
			//now parse the itemCodes
						
			
			
		}
		catch (Exception e)
		{
			System.out.println("Error Getting item info");
		}
		
		
		/*
		 * 
		 * 
		 * Now that I have all of the inventory and the table info loaded into arrays I need to combine them all 
		 * 
		 * 
		 * */
		
		
		//I need to connect the the itemInfoArrays, and tableInfoArrays with its correct match
		
		ArrayList<String[]> tableMergedContent = new ArrayList<String[]>();
		
		for(int i = 0; i < tableInfoArrays.size(); i++)
		{
			for (int j = 0; j < itemInfoArrays.size(); j++)
			{
				if(tableInfoArrays.get(i)[0].equals(itemInfoArrays.get(i)[0]))
				{
					//merge the needed content from the two arrays
					String[] tempRay = {tableInfoArrays.get(i)[0], tableInfoArrays.get(i)[1], tableInfoArrays.get(i)[2], tableInfoArrays.get(i)[3], 
							tableInfoArrays.get(i)[4], tableInfoArrays.get(i)[5], itemInfoArrays.get(i)[1]};
					//add the merged content to the arraylist
					tableMergedContent.add(tempRay);
					j = itemInfoArrays.size();
				}
			}
		}
		
		
		
		
		
		

		ArrayList<Item> tempItems = new ArrayList<Item>();
		
		ArrayList<Table> tables = new ArrayList<Table>();
		
		Table tempTable;
		
		//loop through all tables in the tableInfoArrays
		
		for(int i = 0; i < tableMergedContent.size(); i++)
		{
			//now loop through the items for this table
			String[] items = tableMergedContent.get(i)[6].split("/");
			
			
			
			
			//loop through the items and add the selected items 
			for(int j = 0; j < items.length; j++)
			{
				//now loop through the inventory and add the specfic item to the tempItems
				
				for(int l = 0; l < inventory.size(); l++)
				{
					if(inventory.get(l).getItm().getItemIdentifier().equals(items[j]))
					{
						
						tempItems.add(inventory.get(l).getItm());
						l = inventory.size();
					}
				}
			}
			
			//tableMergedContent.get(i)
			
			tempTable = new Table();
			
			
			//set all the attributes to the table
			tempTable.setTableIdentifier(tableMergedContent.get(i)[0]);
			
			tempTable.setTableNumber(tableMergedContent.get(i)[1]);
			
			tempTable.setNumPeople(Integer.parseInt(tableMergedContent.get(i)[2]));
			
			tempTable.setStartTime(tableMergedContent.get(i)[3]);
			
			tempTable.setEndTime(tableMergedContent.get(i)[4]);
			
			tempTable.setItems(tempItems);
			
			
			
			tables.add(tempTable);
			
			
			
			//clear out tempItems for next use 
			tempItems = new ArrayList<Item>();
		}
		
		
		control = new Controller(new Inventory(inventory), tables);
		
		
		
		
		
		System.out.println("Done Reading Info");
		
		
		
		
		
		
		//returns a controller to hold all of the info for the started system
		return control;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReadInData reader = new ReadInData();
		
		reader.initData();

	}

}
