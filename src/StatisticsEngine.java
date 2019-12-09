//Author: Brian Rothschild
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class StatisticsEngine {

	StatisticsEngine()
	{
		//Dont need anything in this 
		;
	}
	
	
	
	//calculate the time spent at the table
	private int getTimeSpent(Table tab)
	{
		
		/*
		 * Example times
		 * 01/01/2018 13:43
		 * 1/1/2018 11:52

		 * 
		 * 
		 * */
		
		String startTime = tab.getStartTime().substring(11);
		String endTime = tab.getEndTime().substring(11);

		
		
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		try
		{
			Date date1 = format.parse(startTime);
			Date date2 = format.parse(endTime);
			
			//subtract the dates
			long difference = date2.getTime() - date1.getTime();
			
			//return the number of minutes between the start and end times
			return (int) difference/60000;
		}
		catch (Exception e)
		{
			return 0;
		}
		
	}
	
	
	private ArrayList<int[]> tablesToArray(ArrayList<Table> tables)
	{
		ArrayList<int[]> rowTables = new ArrayList<int[]>();
		
		//take the row objects and break it up into the arrays you want
		
		
		/*
		 * Array format
		 * {year, Month, Day, Hour, numPeople, cost, numItems, spentPerPerson, avgTimeSpent, numTables}
		 * 
		 * getYear = tables.get(100).getStartTime().substring(6,10)
		 * 
		 * getMonth = tables.get(100).getStartTime().substring(3,5)
		 * 
		 * getDay  = tables.get(100).getStartTime().substring(0,2)
		 * 
		 * getHour = tables.get(0).getStartTime().substring(11,13)
		 * 
		 * 
		 * */
		
		
		//turn the objects into a large 2D array 
		for(int i = 0; i < tables.size(); i++)
		{
			int a = Integer.parseInt(tables.get(i).getStartTime().substring(6,10));
			int b = Integer.parseInt(tables.get(i).getStartTime().substring(3,5));
			int c = Integer.parseInt(tables.get(i).getStartTime().substring(0,2));
			int d = Integer.parseInt(tables.get(i).getStartTime().substring(11,13));
			int e = tables.get(i).getNumPeople();
			int f = (int) Math.round(tables.get(i).getCost());
			int g = tables.get(i).getNumItems();
			int h = (int) Math.round(tables.get(i).getCost()/tables.get(i).getNumPeople());
			int ii = this.getTimeSpent(tables.get(i));
			int[] tempRay = {a, b, c, d, e, f, g, h, ii, 1};
			
			rowTables.add(tempRay);
		}
		
		
		//now group the like rows by the date 
		
		rowTables = this.groupByDates(rowTables);
		
		
		
		return rowTables;
	}
	
	private ArrayList<int[]> groupByDates(ArrayList<int[]> allTables)
	{
		ArrayList<int[]> combinedTables = new ArrayList<int[]>();
		
		
		//generate a bunch of rows to be combined into
		
		for (int year = 16; year < 20; year++)
		{
			for(int month = 1;month < 13; month++)
			{
				for(int day = 1; day < 32; day++)
				{
					for(int hour = 10; hour < 24; hour++)
					{
						int[] tempRay = {Integer.parseInt("20" + year), month, day, hour, 0, 0, 0, 0, 0, 0, 0};
						combinedTables.add(tempRay);
					}
					
					
				}
			}
		}
		
		
		
		/*
		 * These loops go through all of the rows and combine them all into rows with like years, months, days, and hours 
		 * */
		
		
		for(int i = 0; i < combinedTables.size(); i++)
		{
			for(int j = 0; j < allTables.size(); j++)
			{
				//if both rows have the same Year, month, day and hour
				if(combinedTables.get(i)[0] == allTables.get(j)[0] && combinedTables.get(i)[1] == allTables.get(j)[1] && combinedTables.get(i)[2] == allTables.get(j)[2] &&
						combinedTables.get(i)[3] == allTables.get(j)[3])
				{
					int[] tempTable = combinedTables.get(i);
					
					tempTable[4] += allTables.get(j)[4];
					tempTable[5] += allTables.get(j)[5];
					tempTable[6] += allTables.get(j)[6];
					tempTable[7] += allTables.get(j)[7];
					tempTable[8] += allTables.get(j)[8];
					tempTable[9] = tempTable[9] + 1;
					
					
					combinedTables.set(i, tempTable);
				}
			}
		}
		
		
		//this should take a while, but this will tell you when your done
		System.out.println("Done combining tables");
		
		//now remove all the rows where there isnt any data in the rows
		
		for(int i = 0; i < combinedTables.size(); i++)
		{
			if(combinedTables.get(i)[9] < 1)
			{
				combinedTables.remove(i);
				i--;
			}
		}
		
		
		//now divide the needed values by the number 
		for(int i = 0; i < combinedTables.size(); i++)
		{
			int[] tempTable = combinedTables.get(i);
			
			tempTable[7] /= combinedTables.get(i)[9];
			tempTable[8] /= combinedTables.get(i)[9];
			
			
			combinedTables.set(i, tempTable);
		}
		System.out.println("Done taking Averages");
		
		
		return combinedTables;
	}
	
	
	
	
	public String generateCSV(Controller control)
	{
		String output = "";
		
		
		//turn all of the tables into a 2D array
		
		ArrayList<int[]> rows = this.tablesToArray(control.tables);
		
		
		
		

		/*
		 * Send all of the data calculated to a CSV along with all of
		 * the other tables saved
		 * 
		 * */
		
		try
		{
			PrintWriter writer = new PrintWriter("C:/Users/brian/Desktop/TableFolder/stats.csv", "UTF-8");
			
			
			writer.println("year, Month, Day, Hour, numPeople, spentInHour, numItems, spentPerPerson, avgTimeSpent, numTables");
			
			
			for(int i = 0; i < rows.size(); i++)
			{
				writer.println(rows.get(i)[0] + "," + rows.get(i)[1] + "," + rows.get(i)[2] + "," + rows.get(i)[3] + "," + rows.get(i)[4] + "," + rows.get(i)[5] + "," +
						rows.get(i)[6] + "," + rows.get(i)[7] + "," + rows.get(i)[8] + "," + rows.get(i)[9]);
				//System.out.println(i);
			}
			writer.close();
		}
		catch (Exception e)
		{
			System.out.println("Something went wrong writing the stats");
		}
		
		
		System.out.println("CSV written");
		
		
		
		return output;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReadInData reader = new ReadInData();
		
		Controller control = reader.initData();
		
		
		StatisticsEngine stat = new StatisticsEngine();
		
		stat.generateCSV(control);
		
		
		
		control.inventory.toString();
	}

}
