//Author: Brian Rothschild
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;


/*
 * This Object is used to create a bunch of fictional data,
 * used to test all of the statistics and such
 * 
 * 
 * 
 * */

public class GenerateResturauntInfo {

	public static void main(String[] args) {
		//The inventory object holds all of the data
		
		//Initeate the controller  
		Controller controller = new Controller();
		



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
		int numApps = 25;
		int numEntr = 50;
		int numDesr = 10;

		DecimalFormat df = new DecimalFormat(".##");
		Random ran = new Random();



		//add beverages
		for(int i = 0; i < numBevs; i++)
		{
			//new InventoryItem(new Beverage(drinkNames[ran.nextInt(drinkNames.length)], ran.nextDouble()*100, alergiesNames[ran.nextInt(drinkNames.length)], false),ran.nextInt(100)), ran.nextInt()

			controller.inventory.addInventoryItem(new InventoryItem(new Beverage(drinkNames[ran.nextInt(drinkNames.length)], Double.parseDouble(df.format(ran.nextDouble()*10) + 1), alergiesNames[ran.nextInt(alergiesNames.length)], ran.nextBoolean()), ran.nextInt(250) + 50));
		}

		//add appetizers
		for(int i = 0; i < numApps; i++)
		{
			controller.inventory.addInventoryItem(new InventoryItem(new Appetizer(appNames[ran.nextInt(appNames.length)], Double.parseDouble(df.format(ran.nextDouble()*10 + 1)), alergiesNames[ran.nextInt(alergiesNames.length)], ran.nextBoolean(), ran.nextInt(4)+1), ran.nextInt(250) + 50));
		}

		//add entree
		for(int i = 0; i < numEntr; i++)
		{
			controller.inventory.addInventoryItem(new InventoryItem(new Entree(entreeNames[ran.nextInt(entreeNames.length)], Double.parseDouble(df.format(ran.nextDouble()*100 + 1)), alergiesNames[ran.nextInt(alergiesNames.length)], ran.nextBoolean(), ran.nextInt(4)+1), ran.nextInt(250) + 50));
		}

		//add deserts
		for(int i = 0; i < numDesr; i++)
		{
			controller.inventory.addInventoryItem(new InventoryItem(new Dessert(dessertNames[ran.nextInt(dessertNames.length)], Double.parseDouble(df.format(ran.nextDouble()*20 + 1)), alergiesNames[ran.nextInt(alergiesNames.length)], ran.nextBoolean(), ran.nextInt(4)+1), ran.nextInt(250) + 50));
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




		//create all of the lists of beverages and such 
		ArrayList<Beverage> bevList = controller.inventory.getBeverages();
		ArrayList<Appetizer> appList = controller.inventory.getAppetizer();
		ArrayList<Entree> entList = controller.inventory.getEntree();
		ArrayList<Dessert> desList = controller.inventory.getDessert();

		
		
		/*
		 * 
		 * These printed all the menu items, for debugging
		 * 
		 * 
		 * 
		 * 
		for(int i = 0; i < bevList.size(); i++)
		{
			System.out.println((i+1) + ") " + bevList.get(i) + "\n");
		}

		for(int i = 0; i < appList.size(); i++)
		{
			System.out.println((i+1) + ") " + appList.get(i) + "\n");
		}

		for(int i = 0; i < entList.size(); i++)
		{
			System.out.println((i+1) + ") " + entList.get(i) + "\n");
		}

		for(int i = 0; i < desList.size(); i++)
		{
			System.out.println((i+1) + ") " + desList.get(i) + "\n");
		}
*/

		/*
		 * 
		 * Generate a list of dates dating back to a year ago, so that you can use those dates to create 
		 * historical tables, to be used to generate data to be queried 
		 * 
		 * 
		 * 
		 * */
		
		
		ArrayList<String> startTimes = new ArrayList<String>();
		ArrayList<String> endTimes = new ArrayList<String>();
		
		
		
		//days in each month
		int daysInMonth[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		//gives a range for the random number of tables to be chosen between 
		int tablesPerHourTop[] =    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 25, 15, 10, 10, 15, 25, 30, 40, 35, 30, 25, 20};
		int tablesPerHourBottom[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 10, 6, 3, 3, 8, 10, 8, 15, 12, 10, 10, 5};
		

		
	    
	    
	    //tempVars
	    String tempOpen, minSec, tempClose;
	    int tblRng, randMinute, randSecond, minutesStayed, tempHour, tempMin;
	    //loop through months 
	    
	    for(int month = 1; month < 13; month++)
	    {
	    	//loop through days
	    	for(int day = 1; day < daysInMonth[month]; day++)
	    	{
	    		//loop through hours
	    		for(int hour = 11; hour < 24; hour ++)
	    		{
	    			//now generate the random number of dates and create that many of them 
	    			tblRng = ran.nextInt(tablesPerHourTop[hour])+tablesPerHourBottom[hour];
	    			for(int numTables = 0; numTables < tblRng; numTables++)
	    			{
	    				/*
	    				 * 
	    				 * Create the time in which the table was opened 
	    				 * 
	    				 * 
	    				 * */
	    				
	    				
	    				
	    				
	    				//create random minutes and seconds, going to do so before hand to account for the length issues 
	    				randMinute = ran.nextInt(60);
	    				randSecond = ran.nextInt(60);
	    				
	    				/*
	    				 * Decided to format the minutes/seconds seperately so there wouldnt be to many nested ifs, because that would be confusing
	    				 * */
	    				
	    				
	    				
	    				//formatting the minutes and seconds
	    				if(randMinute < 10)
	    				{
	    					if(randSecond < 10)
	    					{
	    						minSec = ":0" + randMinute + ":0" + randSecond;  
	    					}
	    					else
	    					{
	    						minSec = ":0" + randMinute + ":" + randSecond;
	    					}
	    				}
	    				else
	    				{
	    					if(randSecond < 10)
	    					{
	    						minSec = ":" + randMinute + ":0" + randSecond;  
	    					}
	    					else
	    					{
	    						minSec = ":" + randMinute + ":" + randSecond;
	    					}
	    				}
	    				
	    				
	    				
	    				//formatting the monthes and days 
	    				if(month < 10)
	    				{
	    					//need to add zero in from of month
	    					if(day < 10)
	    					{
	    						//need zero in front of day
	    						tempOpen = "0" + day + "/" + "0" + month + "/2018" + " " + hour + minSec;
	    					}
	    					else
	    					{
	    						//dont need 0 in front of day
	    						tempOpen = day + "/" + "0" + month + "/2018" + " " + hour + minSec;
	    					}
	    				}
	    				else
	    				{
	    					//don't need 0 in front of month
	    					if(day < 10)
	    					{
	    						//need zero in front of day
	    						tempOpen = "0" + day + "/" + month + "/2018" + " " + hour + minSec;
	    					}
	    					else
	    					{
	    						//dont need 0 in front of day
	    						tempOpen = day + "/" + month + "/2018" + " " + hour + minSec;
	    					}
	    					
	    				}
	    				//add start time String to the allDates list 
	    				startTimes.add(tempOpen);
	    				
	    				
	    				
	    				/*
	    				 * Now I need to come up with the time they left the restuaunt 
	    				 * 
	    				 * */
	    				
	    				
	    				//create minutes stayed between 105 and 20 minutes
	    				
	    				minutesStayed = ran.nextInt(105) + 20;
	    				
	    				
	    				//now decide the if its been more than an hour, for that
	    				//i need to parse out the hour and the minutes
	    				tempHour = Integer.parseInt(tempOpen.substring(11, 13));
	    				tempMin = Integer.parseInt(tempOpen.substring(14, 16));
	    				
	    				if(tempMin + minutesStayed > 59)
	    				{
	    					//if hour needs to be incremented at least once
	    					if(tempMin + minutesStayed > 119)
	    					{
	    						//if hour needs to be incremented twice
	    						tempHour += 2;
	    						minutesStayed -= 119;
	    						tempMin += minutesStayed;
	    						
	    						//now make the string again
	    						if (tempMin < 10)
	    						{
	    							tempClose = tempOpen.substring(0, 11) + tempHour + ":0" + tempMin + ":" + "00";
	    						}
	    						else
	    						{
	    							tempClose = tempOpen.substring(0, 11) + tempHour + ":" + tempMin + ":" + "00";
	    						}
	    						
	    						
	    						
	    					}
	    					else
	    					{
	    						//if hour needs to be incremented once
	    						tempHour += 1;
	    						minutesStayed -= 59;
	    						tempMin += minutesStayed;
	    						
	    						
	    						//now make the string again
	    						if (tempMin < 10)
	    						{
	    							tempClose = tempOpen.substring(0, 11) + tempHour + ":0" + tempMin + ":" + "00";
	    						}
	    						else
	    						{
	    							tempClose = tempOpen.substring(0, 11) + tempHour + ":" + tempMin + ":" + "00";
	    						}
	    					}
	    				}
	    				else
	    				{
	    					//hour does not need to be incremented
    						tempMin += minutesStayed;
    						
    						
    						//now make the string again
    						if (tempMin < 10)
    						{
    							tempClose = tempOpen.substring(0, 11) + tempHour + ":0" + tempMin + ":" + "00";
    						}
    						else
    						{
    							tempClose = tempOpen.substring(0, 11) + tempHour + ":" + tempMin + ":" + "00";
    						}
	    				}
	    				
	    				//add the date to the list of closing ticket times
	    				endTimes.add(tempClose);
	    				
	    				
	    			}
	    			
	    		}
	    	}
	    }
		
	    
	    //System.out.println(startTimes.size());
		
		
		
		
		
		
		
		
		
		/*====================================================================================================================================================================================================================================
		 * 
		 * Add tables to the controller 
		 * 
		 * 
		 * ====================================================================================================================================================================================================================================
		 * */
		
		
		
		
		//generate a bunch of fake tables
		for(int i = 0; i < startTimes.size(); i++)
		{
			//create Table
			controller.addTable(new Table(ran.nextInt(5)+1, ran.nextInt(40) + ""));
			
			//add beverages
			for(int j = 0; j < controller.tables.get(i).getNumPeople(); j++)
			{
				controller.tables.get(i).addItem(bevList.get(ran.nextInt(bevList.size())));
			}
			
			//add appetizers
			for(int j = 0; j < ran.nextInt(2); j++)
			{
				controller.tables.get(i).addItem(appList.get(ran.nextInt(appList.size())));
			}
			
			//add entrees  
			for(int j = 0; j < controller.tables.get(i).getNumPeople(); j++)
			{
				controller.tables.get(i).addItem(entList.get(ran.nextInt(entList.size())));
			}
			
			//add desserts
			for(int j = 0; j < ran.nextInt(2); j++)
			{
				controller.tables.get(i).addItem(desList.get(ran.nextInt(desList.size())));
			}
			
			controller.tables.get(i).closeTable();
			
			
			
			controller.tables.get(i).setStartTime(startTimes.get(i));
			controller.tables.get(i).setEndTime(endTimes.get(i));
			
			//System.out.println(contr.tables.get(i).printReceipt());

		}
		
		System.out.println("Done generating data");
		
		
		/*
		 * 
		 * Now writing to all of the CSV's 
		 * 
		 * 
		 * */
		
		
		
		
		
		
		
		//write all table info to a csv
		try
		{
			PrintWriter writer = new PrintWriter("C:/Users/brian/Desktop/TableFolder/tableInfo.csv", "UTF-8");
			
			
			writer.println("tableIdentifier,tableNumber,numPeople,startTime,endTime,cost");
			
			
			for(int i = 0; i < controller.tables.size(); i++)
			{
				writer.println(controller.tables.get(i).printForCsv());
				//System.out.println(i);
			}
			writer.close();
		}
		catch (Exception e)
		{
			System.out.println("Something went wrong writing the tableinfo");
		}
		
		
		//write all item info to a csv
		try
		{
			PrintWriter writer = new PrintWriter("C:/Users/brian/Desktop/TableFolder/itemInfo.csv", "UTF-8");
			
			
			writer.println("tableIdentifier,itemCodes");
			
			
			for(int i = 0; i < controller.tables.size(); i++)
			{
				writer.println(controller.tables.get(i).printItemsForCsv());
				//System.out.println(i);
			}
			writer.close();
		}
		catch (Exception e)
		{
			System.out.println("Something went wrong writing the iteminfo");
		}
		
		
		//write all inventory to a csv
		try
		{
			PrintWriter writer = new PrintWriter("C:/Users/brian/Desktop/TableFolder/inventory.csv", "UTF-8");
			
			
			writer.println("itemIdentifier,quantity");
			
			
			for(int i = 0; i < controller.inventory.items.size(); i++)
			{
				writer.println(controller.inventory.items.get(i).printForCsv());
				//System.out.println(i);
			}
			writer.close();
		}
		catch (Exception e)
		{
			System.out.println("Something went wrong writing the iteminfo");
		}
		
		
		
		 

		
		
		//write beverages to a csv
		try
		{
			PrintWriter writer = new PrintWriter("C:/Users/brian/Desktop/TableFolder/menu/beverageInfo.csv", "UTF-8");
			
			
			writer.println("tableIdentifier,name, price, alergies, hasAlcohol");
			
			
			for(int i = 0; i < bevList.size(); i++)
			{
				writer.println(bevList.get(i).printToCSV());
				//System.out.println(i);
			}
			writer.close();
		}
		catch (Exception e)
		{
			System.out.println("Something went wrong writing the beverages info");
		}
		
		
		
		
		//write apps  to a csv
		try
		{
			PrintWriter writer = new PrintWriter("C:/Users/brian/Desktop/TableFolder/menu/appetizerInfo.csv", "UTF-8");
			
			
			writer.println("tableIdentifier,name, price, alergies, forTable, serves");
			
			
			for(int i = 0; i < appList.size(); i++)
			{
				writer.println(appList.get(i).printToCSV());
				//System.out.println(i);
			}
			writer.close();
		}
		catch (Exception e)
		{
			System.out.println("Something went wrong writing the appetizer info");
		}
		
		
		//write entrees to a csv
		try
		{
			PrintWriter writer = new PrintWriter("C:/Users/brian/Desktop/TableFolder/menu/entreeInfo.csv", "UTF-8");
			
			
			writer.println("tableIdentifier,name, price, alergies, forTable, serves");
			
			
			for(int i = 0; i < entList.size(); i++)
			{
				writer.println(entList.get(i).printToCSV());
				//System.out.println(i);
			}
			writer.close();
		}
		catch (Exception e)
		{
			System.out.println("Something went wrong writing the entree info");
		}
		
		
		//write desserts to a csv
		try
		{
			PrintWriter writer = new PrintWriter("C:/Users/brian/Desktop/TableFolder/menu/dessertInfo.csv", "UTF-8");
			
			
			writer.println("tableIdentifier,name, price, alergies, forTable, serves");
			
			
			for(int i = 0; i < desList.size(); i++)
			{
				writer.println(desList.get(i).printToCSV());
				//System.out.println(i);
			}
			writer.close();
		}
		catch (Exception e)
		{
			System.out.println("Something went wrong writing the dessert info");
		}
		
		
		
		
		
		
		
		System.out.println("Done Writing");
		
		
	}
}
