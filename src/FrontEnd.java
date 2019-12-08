import processing.core.*;

public class FrontEnd extends PApplet
{
	
	//Dynamic screen size adjustment variable
	float n = 0;
	//Image Processing files
	PImage table;
	PImage item;
	PImage pay;
	PImage inv;
	PImage close;
	PImage arrow;
	
	PImage zPic1;
	PImage zPic2;
	PImage zPic3;
	PImage zPic4;
	PImage zPic5;
	PImage zPic6;
	PImage zPic7;
	PImage zPic8;
	
	//Fonts for text
	PFont nFont;
	PFont aFont;
	
	//Int to choose random orders
	int randNum;
	int randEnt;
	int randApp;
	int randDes;
	int randBev;
	
	//Int to choose random order ID
	int randNumID;
	int randEntID;
	int randAppID;
	int randDesID;
	int randBevID;
	
	int zImgCount = 1;
	
	//Count how many tables are active
	int tabCount = 1;
	//Int to increment menu WIP
	int incCount = 0;
	
	boolean stats = false;
	//Boolean to check if a the mouse has been through a full click
	boolean fullClick = false;
	
	//Booleans to check which section of the system is in
	boolean tabClicked = false;
	boolean menuClicked = false;
	boolean billClicked = false;
	boolean stockClicked = false;
	
	//Check if the waiter has chosen a specific table
	boolean serverClicked1 = false;
	boolean serverClicked2 = false;
	boolean serverClicked3 = false;
	boolean serverClicked4 = false;
	boolean serverClicked5 = false;
	boolean serverClicked6 = false;
	boolean serverClicked7 = false;
	boolean serverClicked8 = false;
	boolean serverClicked9 = false;
	
	//Objects for each table
	Table table1 = new Table();
	Table table2 = new Table();
	Table table3 = new Table();
	Table table4 = new Table();
	Table table5 = new Table();
	Table table6 = new Table();
	Table table7 = new Table();
	Table table8 = new Table();
	Table table9 = new Table();
	
	//Boolean to activate bills
	boolean bill1 = false;
	boolean bill2 = false;
	boolean bill3 = false;
	boolean bill4 = false;
	boolean bill5 = false;
	boolean bill6 = false;
	boolean bill7 = false;
	boolean bill8 = false;
	boolean bill9 = false;
	
	
	//Booleans for the stock tab
	boolean bevClicked = false;
	boolean appClicked = false;
	boolean entClicked = false;
	boolean desClicked = false;
	
	//Booleans for the menu tab
	boolean bevMClicked = false;
	boolean appMClicked = false;
	boolean entMClicked = false;
	boolean desMClicked = false;
	
	//Booleans to check if stock has been ordered
	boolean bevOrder = false;
	boolean appOrder = false;
	boolean entOrder = false;
	boolean desOrder = false;
	
	//Names and prices for each menu item
	String drinkNames[] = {"Water", "Coke", "Dr. Pepper", "Sprite", "Diet Coke", "Diet Dr. Pepper", "Diet Sprite", "Sweet Tea", "UnSweet Tea", "Beer", "Mixed Drink"};
	String drinkPrices[] = {"0.0","2.50","2.50","2.50","2.50","2.50","2.50","2.50","2.50","5.00","6.00"};
	String appNames[] = {"Chips and Queso", "Chips and Guacamole", "Chips and Salsa", "Fried Pickles", "Mozzarella Sticks", "Soup of the Day", "Salad", "Onion Rings"};
	String appPrices[] = {"4.50","4.75","4.00","2.25","8.50","4.50","5.00","9.00"};
	String entreeNames[] = {"Burger", "Hot Dog", "Pizza", "Pasta", "Quesidilla", "Tacos", "Salad", "Ribs", "Chicken Strips", "Chicken Nuggets", "Chicken Salad", "Sandwiches", 
			"Salmon", "Tuna", "Steak", "Mac & Cheese"};
	String entreePrices[] = {"12.00","9.00","9.50","12.00","6.50","10.75","4.50","15.00","10.00","9.50","4.75","6.50","11.50","12.00","13.00","8.00"};
	String dessertNames[] = {"Ice Cream", "Chocolate Cake", "Vanilla Cake", "Apple Pie", "Cherry Pie", "Brownies", "Cookies"};
	String dessertPrices[] = {"5.00","6.00","7.00","7.00","7.00","7.00","4.00"};
	
	public static void main(String[] args) 
	{	
		//Command to link the processing code to the program
		PApplet.main("FrontEnd");
	}

	//Processing settings, sets window size to 2000x2000 
	@Override
	public void settings() {
		if(displayWidth >= 3840 && displayHeight >= 2160) {size(2000, 2000);}else {size(1000, 1000);}
	}
	
	//Starting point for processing variables
	@Override
	public void setup() {
		
		//Checking for screen size
		if(displayWidth >= 3840 && displayHeight >= 2160) {n=1;} else {n=2;}
		
		//Font for name
		nFont = createFont("Georgia", 60/n);
		//Font for everything else
		aFont = createFont("Georgia", 50/n);
		
		//URLs for every image used
		String tabURL = "http://icons.iconarchive.com/icons/icons8/ios7/256/Household-Table-icon.png";
		String itemURL = "https://image.flaticon.com/icons/png/512/26/26393.png";
		String payURL = "http://simpleicon.com/wp-content/uploads/coin-money-3.png";
		String invURL = "http://cdn.onlinewebfonts.com/svg/img_341721.png";
		String xURL = "https://www.lillytrialguide.com/images/oncology/icons/oc_share_close.png";
		String arURL = "https://icon-library.net/images/arrow-icon-transparent-background/arrow-icon-transparent-background-13.jpg";
		
		//Loading each URL into an image object
		table = loadImage(tabURL, "png");
		item = loadImage(itemURL, "png");
		pay = loadImage(payURL, "png");
		inv = loadImage(invURL, "png");
		close = loadImage(xURL, "png");
		arrow = loadImage(arURL, "png");
		
		zPic1 = loadImage("assets/zPic (1).png");
		zPic2 = loadImage("assets/zPic (2).png");
		zPic3 = loadImage("assets/zPic (3).png");
		zPic4 = loadImage("assets/zPic (4).png");
		zPic5 = loadImage("assets/zPic (5).png");
		zPic6 = loadImage("assets/zPic (6).png");
		zPic7 = loadImage("assets/zPic (7).png");
		zPic8 = loadImage("assets/zPic (8).png");
		
		//Random numbers for stock data
		randNum = (int)random(50,100);
		//Random numbers for choice of orders
		randEnt = (int)random(0, entreeNames.length);
		randDes = (int)random(0, dessertNames.length);
		randApp = (int)random(0, appNames.length);
		randBev = (int)random(0, drinkNames.length);
		
		//Random ID numbers for each order
		randNumID = (int)random(10000,19999);
		randEntID = (int)random(10000,19999);
		randAppID = (int)random(10000,19999);
		randDesID = (int)random(10000,19999);
		randBevID = (int)random(10000,19999);
		
		//Change the background to gray
		fill(125);
	}
	
	//Processing draw function, runs through the function 60x a second
	@Override
	public void draw() {
		//Main screen, creates a blank canvas
		fill(0);
		rect(300/n,0/n, 2000/n,2000/n);
		
		//Name circle, creates a circle and places the servers name inside
		stroke(0);
		strokeWeight(6);
		textFont(nFont);
		fill(255);
		ellipse(150/n,150/n,200/n,200/n);
		fill(0);
		text("Eve C.", 70/n, 165/n);
		
		//Tables tab////////////////////////////////////////////////////////////////
		
		//Set up a square with the image and name of the tab
		textFont(aFont);
		fill(156,192,231);
		stroke(0);
		strokeWeight(4);
		
		//If the mouse is positioned over the table's box
		if (overTable())
		{
			//Change the color to indicate that it is over the box
			fill(150,0,38);
			//If the mouse is clicked, disable other tabs and enable table tab
			if(mousePressed == true)
			{
				menuClicked = false;
				billClicked = false;
				stockClicked = false;
				tabClicked = true;
			}
		}
		
		//If the table tab is selected (To keep the information displayed all tabs must 
		//								have a bool that keeps the draw function frozen)
		if(tabClicked == true)
		{
			//Int for table choice
			int tChoice = 0;
			
			//Color for the table squares
			fill(190,190,190);
			
			//Creating and positioning each table in the tab
			rect(500/n,500/n,300/n,300/n);//table 1
			rect(500/n,1000/n,300/n,300/n);//table 4
			rect(500/n,1500/n,300/n,300/n);//table 7
			
			rect(1000/n,500/n,300/n,300/n);//table 2
			rect(1000/n,1000/n,300/n,300/n);//table 5
			rect(1000/n,1500/n,300/n,300/n);//table 8
			
			rect(1500/n,500/n,300/n,300/n);//table 3
			rect(1500/n,1000/n,300/n,300/n);//table 6
			rect(1500/n,1500/n,300/n,300/n);//table 9
			
			//White text that identifies each table
			fill(0);
			text("Table 1", 550/n, 550/n);
			text("Table 2", 1050/n, 550/n);
			text("Table 3", 1550/n, 550/n);
			text("Table 4", 550/n, 1050/n);
			text("Table 5", 1050/n, 1050/n);
			text("Table 6", 1550/n, 1050/n);
			text("Table 7", 550/n, 1550/n);
			text("Table 8", 1050/n, 1550/n);
			text("Table 9", 1550/n, 1550/n);
			
			//Instructions for the waiters
			fill(12,138,27);
			text("*Servers, press on the table you are assigned to.*", 500/n, 50/n);
			
			//checking if the mouse cursor is position over any of the squares
			//		If the user clicks activate the table
			if(mouseX >= 500/n && mouseX <= 800/n && mouseY >= 500/n && mouseY <= 800/n){
				if(mousePressed == true) {
					tChoice = 1;
					serverClicked1 = true;
				}					
			}
			if(mouseX >= 1000/n && mouseX <= 1300/n && mouseY >= 500/n && mouseY <= 800/n){
				if(mousePressed == true) {
					tChoice = 2;
					serverClicked2 = true;
				}
			}
			if(mouseX >= 1500/n && mouseX <= 1800/n && mouseY >= 500/n && mouseY <= 800/n){
				if(mousePressed == true) {
					tChoice = 3;
					serverClicked3 = true;
				}
			}
			if(mouseX >= 500/n && mouseX <= 800/n && mouseY >= 1000/n && mouseY <= 1200/n){
				if(mousePressed == true) {
					tChoice = 4;
					serverClicked4 = true;
				}
			}
			if(mouseX >= 1000/n && mouseX <= 1300/n && mouseY >= 1000/n && mouseY <= 1200/n){
				if(mousePressed == true) {
					tChoice = 5;
					serverClicked5 = true;
				}
			}
			if(mouseX >= 1500/n && mouseX <= 1800/n && mouseY >= 1000/n && mouseY <= 1200/n){
				if(mousePressed == true) {
					tChoice = 6;
					serverClicked6 = true;
				}
			}
			if(mouseX >= 500/n && mouseX <= 800/n && mouseY >= 1500/n && mouseY <= 1700/n){
				if(mousePressed == true) {
					tChoice = 7;
					serverClicked7 = true;
				}
			}
			if(mouseX >= 1000/n && mouseX <= 1300/n && mouseY >= 1500/n && mouseY <= 1700/n){
				if(mousePressed == true) {
					tChoice = 8;
					serverClicked8 = true;
				}
			}
			if(mouseX >= 1500/n && mouseX <= 1800/n && mouseY >= 1500/n && mouseY <= 1700/n){
				if(mousePressed == true) {
					tChoice = 9;
					serverClicked9 = true;
				}
			}
			
			
			
			
			
			
			
			//When each table is activated, the table is assigned a number and a random number of people
			switch(tChoice)
			{
				case 1:
				{
					table1.setTableNumber("1");
					table1.setNumPeople(parseInt(random(1,5)));
					break;
				}
				case 2:
				{
					table2.setTableNumber("2");
					table2.setNumPeople(parseInt(random(1,10)));
					break;
				}
				case 3:
				{
					table3.setTableNumber("3");
					table3.setNumPeople(parseInt(random(1,3)));
					break;
				}
				case 4:
				{
					table4.setTableNumber("4");
					table4.setNumPeople(parseInt(random(1,5)));
					break;
				}
				case 5:
				{
					table5.setTableNumber("5");
					table5.setNumPeople(parseInt(random(1,2)));
					break;
				}
				case 6:
				{
					table6.setTableNumber("6");
					table6.setNumPeople(parseInt(random(1,5)));
					break;
				}
				case 7:
				{
					table7.setTableNumber("7");
					table7.setNumPeople(parseInt(random(1,4)));
					break;
				}
				case 8:
				{
					table8.setTableNumber("8");
					table8.setNumPeople(parseInt(random(1,5)));
					break;
				}
				case 9:
				{
					table9.setTableNumber("9");
					table9.setNumPeople(parseInt(random(1,8)));
					break;
				}
			}
			
			//When each table is activated set the server and table information
			//		Set separately from other booleans to allow for them to be disabled later
			if(serverClicked1 == true)
			{
				textFont(aFont);
				fill(255);
				text("Server: Eve C.", 500/n, 500/n);
				fill(0);
				text("Seated:" , 530/n, 620/n);
				text(table1.getNumPeople(), 700/n, 620/n);	
			}
			if(serverClicked2 == true)
			{
				textFont(aFont);
				fill(255);
				text("Server: Eve C.", 1000/n, 500/n);
				fill(0);
				text("Seated:" , 1030/n, 620/n);
				text(table2.getNumPeople(), 1200/n, 620/n);
			}
			if(serverClicked3 == true)
			{
				textFont(aFont);
				fill(255);
				text("Server: Eve C.", 1500/n, 500/n);
				fill(0);
				text("Seated:" , 1530/n, 620/n);
				text(table3.getNumPeople(), 1700/n, 620/n);
			}
			if(serverClicked4 == true)
			{
				textFont(aFont);
				fill(255);
				text("Server: Eve C.", 500/n, 1000/n);
				fill(0);
				text("Seated:" , 530/n, 1120/n);
				text(table4.getNumPeople(), 700/n, 1120/n);
			}
			if(serverClicked5 == true)
			{
				textFont(aFont);
				fill(255);
				text("Server: Eve C.", 1000/n, 1000/n);
				fill(0);
				text("Seated:" , 1030/n, 1120/n);
				text(table5.getNumPeople(), 1200/n, 1120/n);
			}
			if(serverClicked6 == true)
			{
				textFont(aFont);
				fill(255);
				text("Server: Eve C.", 1500/n, 1000/n);
				fill(0);
				text("Seated:" , 1530/n, 1120/n);
				text(table6.getNumPeople(), 1700/n, 1120/n);
			}
			if(serverClicked7 == true)
			{
				textFont(aFont);
				fill(255);
				text("Server: Eve C.", 500/n, 1500/n);
				fill(0);
				text("Seated:" , 530/n, 1620/n);
				text(table7.getNumPeople(), 700/n, 1620/n);
			}
			if(serverClicked8 == true)
			{
				textFont(aFont);
				fill(255);
				text("Server: Eve C.", 1000/n, 1500/n);
				fill(0);
				text("Seated:" , 1030/n, 1620/n);
				text(table8.getNumPeople(), 1200/n, 1620/n);
			}
			if(serverClicked9 == true)
			{
				textFont(aFont);
				fill(255);
				text("Server: Eve C.", 1500/n, 1500/n);
				fill(0);
				text("Seated:" , 1530/n, 1620/n);
				text(table9.getNumPeople(), 1700/n, 1620/n);
			}
			
			
			if(overStats() == true)
			{
				fill(150,0,38);
				if(mousePressed == true)
				{
					stats = true;
				}
			}
			fill(255);
			text("Statistics",1050,250);
			rect(1000/n,150/n,300/n,200/n);
			
			
			if(stats == true)
			{
				fill(54,64,120); 
				rect(300/n,200/n,2000/n, 2000/n);
				fill(255);
				rect(400/n, 300/n, 1500/n, 1600/n);
				fill(156, 192, 231);
				
				fill(0);
				textSize(80/n);
				text(zImgCount, 1150/n, 370/n);
				
				if(zImgCount == 1) {
					image(zPic1, 450/n, 400/n,1400/n ,1400/n);}
				else if(zImgCount == 2){
					image(zPic2, 450/n, 400/n ,1400/n ,1400/n);}
				else if(zImgCount == 3) {
					image(zPic3, 450/n, 400/n ,1400/n ,1400/n);} 
				else if(zImgCount == 4) {
					image(zPic4, 450/n, 400/n ,1400/n ,1400/n);} 
				else if(zImgCount == 5) {
					image(zPic5, 450/n, 400/n ,1400/n ,1400/n);} 
				else if(zImgCount == 6)	{
					image(zPic6, 450/n, 400/n ,1400/n ,1400/n);} 
				else if(zImgCount == 7) {
					image(zPic7, 450/n, 400/n ,1400/n ,1400/n);} 
				else if(zImgCount == 8) {
					image(zPic8, 450/n, 400/n ,1400/n ,1400/n);} 
					
				if(overLeftSt() && !overRightSt())
				{
					//If the button is fully pressed
					if(fullClick == true)
					{
						//If the table is within the bottom bound
						if(zImgCount > 1)
						{	
							//Decrement the table chosen
							zImgCount--;
						}
						//Confirm that the click has ended
						fullClick = false;
					}
					
				}
				
				
				//If the right button is pressed
				if(overRightSt() && !overLeftSt())
				{

					//If the mouse is fully clicked
					if(fullClick == true)
					{
						//If the table is within the top bound
						if(zImgCount < 8)
						{
							//Increase the table chosen
							zImgCount++;
						}
						//Confirm that the click has ended
						fullClick = false;
					}
				}
				
				image(arrow,1700/n,310/n,100/n,100/n);
				//Flip the image back
				scale(-1,1);
				image(arrow,-550/n,310/n,100/n,100/n);
				
				//Change the displayed table
				fill(0);
				scale(-1,1);
				
				//If waiter wants to cancel the bill press the x button 
				image(close, 1900/n, 200/n, 100/n, 100/n);
				if(overX())
				{
					if(mousePressed == true)
					{
						stats = false;
					}
				}
				
				
			}
			//Set a color to mark that the tab is activated
			fill(250,0,38);
		}
		//Created the actual rectangle for the tab
		rect(50/n, 400/n, 200/n, 200/n);
		
		//Setting the picture and text for the table tab
		textSize(60/n);
		fill(0);
		text("Tables", 80/n, 390/n);
		image(table, 65/n, 400/n, 175/n, 175/n);
		
		
		
		//Menu tab/////////////////////////////////////////////////////////////
		
		//Same start as other tabs
		textFont(aFont);
		fill(250,234,203);
		stroke(0);
		strokeWeight(4);
		
		
		//If over the tab
		if(overMenu())
		{
			fill(150,0,38);
			//If tab is clicked 
			if(mousePressed == true)
			{
				menuClicked = true;
				billClicked = false;
				stockClicked = false;
				tabClicked = false;
				fill(250,0,38);
			}
		}
		
		//If tab is enabled
		if(menuClicked == true)
		{
			//Creating the menu interface one rectangle at a time
			fill(54,64,120);
			rect(400/n,200/n,1500/n,1600/n);
			fill(255);
			rect(500/n, 300/n, 1300/n, 200/n);
			fill(247, 219, 215);
			
			//Creating Buttons to change selected table
			//		If over the left button
			if(overLeft() && !overRight())
			{
				fill(150,0,38);
				//If the button is fully pressed
				if(fullClick == true)
				{
					//If the table is within the bottom bound
					if(tabCount > 1)
					{	
						//Decrement the table chosen
						tabCount--;
					}
					//Confirm that the click has ended
					fullClick = false;
				}
				
			}
			//Create the buttons rectangle
			rect(520/n,350/n,100/n,100/n);
			
			//Change the color back to normal
			fill(247,219,215);
			
			//If the right button is pressed
			if(overRight() && !overLeft())
			{
				fill(150,0,38);
				//If the mouse is fully clicked
				if(fullClick == true)
				{
					//If the table is within the top bound
					if(tabCount < 9)
					{
						//Increase the table chosen
						tabCount++;
					}
					//Confirm that the click has ended
					fullClick = false;
				}
			}
			
			
			//Creating the rectangles for the directional arrows 
			rect(1680/n,350/n,100/n,100/n);
			image(arrow,1680/n,350/n,100/n,100/n);
			//Flip the image back
			scale(-1,1);
			image(arrow,-620/n,350/n,100/n,100/n);
			
			//Change the displayed table
			fill(0);
			scale(-1,1);
			textSize(80/n);
			text("Table "+ tabCount, 1000/n, 450/n);
			textFont(aFont);
			
			//Create the submit button
			fill(255);
			rect(500/n, 650/n, 1300/n, 900/n);
			
			fill(156, 192, 231);
			//Check if the mouse if over the submit button WIP
			if(overSubm())
			{
				fill(150,0,38);
				
			}
			rect(1000/n, 1650/n, 300/n, 100/n);
			fill(0);
			text("Submit", 1050/n, 1720/n);
			
			
			//Creating a beverage tab in menu
			fill(255,159,47);
			if(overBevM())
			{
				fill(150,0,38);
				if(mousePressed == true)
				{
					bevMClicked = true;
					appMClicked = false;
					entMClicked = false;
					desMClicked = false;
				}
			}
			rect(500/n, 520/n, 200/n, 100/n);
			fill(255);
			textSize(38/n);
			text("Beverages", 510/n, 570/n);
			
			//Creating an appetizer tab in the menu
			fill(117,168,255);
			if(overAppM())
			{
				fill(150,0,38);
				if(mousePressed == true)
				{
					bevMClicked = false;
					appMClicked = true;
					entMClicked = false;
					desMClicked = false;
				}
			}
			rect(850/n, 520/n, 200/n, 100/n);
			fill(255);
			textSize(38/n);
			text("Appetizers", 860/n, 570/n);
			
			//Creating an entree tab in the menu
			fill(0,103,0);
			if(overEntM())
			{
				fill(150,0,38);
				if(mousePressed == true)
				{
					bevMClicked = false;
					appMClicked = false;
					entMClicked = true;
					desMClicked = false;
				}
			}
			rect(1250/n, 520/n, 200/n, 100/n);
			fill(255);
			textSize(38/n);
			text("Entrees", 1270/n, 570/n);
			
			//Creating a dessert tab in the menu
			fill(211,40,158);
			if(overDesM())
			{
				fill(150,0,38);
				if(mousePressed == true)
				{
					bevMClicked = false;
					appMClicked = false;
					entMClicked = false;
					desMClicked = true;
				}
			}
			rect(1600/n, 520/n, 200/n, 100/n);
			fill(255);
			textSize(38/n);
			text("Desserts", 1620/n, 570/n);
			
			//WIP: Cycle through more menu options
			fill(130, 150, 255);
			if(overUp())
			{
				fill(150,0,38);
				if(fullClick == true)
				{
					if(incCount > 0)
					{	
						incCount--;
					}
					fullClick = false;
				}
				
			}
			
			
			rect(500/n,650/n,1300/n,50/n);
			
			//WIP: Cycle through more menu options
			fill(130, 150, 255);
			if(overDown())
			{
				fill(150,0,38);
				if(fullClick == true)
				{
					if(incCount < drinkNames.length)
					{	
						incCount++;
					}
					fullClick = false;
				}
			}
			rect(500/n,1500/n,1300/n,50/n);
			
			
			fill(250,0,38);
			textFont(aFont);
			
			//Displaying items for each tab of the menu
			if(bevMClicked == true)
			{
				for(int i = 0; i < 6; i++)
				{
					fill(0);
					text(drinkNames[i], 900/n, (110*(i+1)+700)/n);
				}
			}
			if(appMClicked == true)
			{
				for(int i = 0; i < 6; i++)
				{
					fill(0);
					text(appNames[i], 900/n, (110*(i+1)+700)/n);
				}
			}
			if(entMClicked == true)
			{
				for(int i = 0; i < 6; i++)
				{
					fill(0);
					text(entreeNames[i], 900/n, (110*(i+1)+700)/n);
				}
			}
			if(desMClicked == true)
			{
				for(int i = 0; i < 6; i++)
				{
					fill(0);
					text(dessertNames[i], 900/n, (110*(i+1)+700)/n);
				}
			}
			//Returning to the original color
			fill(250,0,38);
		}
		
		//Displaying text and image for the menu tab
		rect(50/n, 800/n, 200/n, 200/n);
		fill(0);
		text("Menu", 80/n, 790/n);
		image(item, 60/n, 800/n, 175/n, 175/n);
		
		//Bill tab////////////////////////////////////////////////////////////////////////////
		//Same start
		textFont(aFont);
		fill(247,219,215);
		stroke(0);
		strokeWeight(4);
		
		//If bill tab is clicked
		if(overBill())
		{
			fill(150,0,38);
			if(mousePressed == true)
			{
				menuClicked = false;
				billClicked = true;
				stockClicked = false;
				tabClicked = false;
				fill(250,0,38);
			}
		}
		
		//If enabled
		if(billClicked == true)
		{
			//Create table layout (similar to table tab)
			fill(190,190,190);
			
			rect(500/n,500/n,300/n,300/n);//table 1
			rect(500/n,1000/n,300/n,300/n);//table 4
			rect(500/n,1500/n,300/n,300/n);//table 7
			
			rect(1000/n,500/n,300/n,300/n);//table 2
			rect(1000/n,1000/n,300/n,300/n);//table 5
			rect(1000/n,1500/n,300/n,300/n);//table 8
			
			rect(1500/n,500/n,300/n,300/n);//table 3
			rect(1500/n,1000/n,300/n,300/n);//table 6
			rect(1500/n,1500/n,300/n,300/n);//table 9
			
			fill(0);
			text("Table 1", 550/n, 550/n);
			text("Table 2", 1050/n, 550/n);
			text("Table 3", 1550/n, 550/n);
			text("Table 4", 550/n, 1050/n);
			text("Table 5", 1050/n, 1050/n);
			text("Table 6", 1550/n, 1050/n);
			text("Table 7", 550/n, 1550/n);
			text("Table 8", 1050/n, 1550/n);
			text("Table 9", 1550/n, 1550/n);
			
			fill(12,138,27);
			text("*Servers, press on the table to calculate their bill*", 500/n, 50/n);
			
			//Check if the server has selected a table (similar to table tab)
			if(mouseX >= 500/n && mouseX <= 800/n && mouseY >= 500/n && mouseY <= 800/n){
				if(mousePressed == true && table1.getNumPeople() != 0) {
					bill1 = true;
				}					
			}
			if(mouseX >= 1000/n && mouseX <= 1300/n && mouseY >= 500/n && mouseY <= 800/n){
				if(mousePressed == true  && table2.getNumPeople() != 0) {
					bill2 = true;
				}
			}
			if(mouseX >= 1500/n && mouseX <= 1800/n && mouseY >= 500/n && mouseY <= 800/n){
				if(mousePressed == true && table3.getNumPeople() != 0) {
					bill3 = true;
				}
			}
			if(mouseX >= 500/n && mouseX <= 800/n && mouseY >= 1000/n && mouseY <= 1200/n){
				if(mousePressed == true && table4.getNumPeople() != 0) {
					bill4 = true;
				}
			}
			if(mouseX >= 1000/n && mouseX <= 1300/n && mouseY >= 1000/n && mouseY <= 1200/n){
				if(mousePressed == true && table5.getNumPeople() != 0) {
					bill5 = true;
				}
			}
			if(mouseX >= 1500/n && mouseX <= 1800/n && mouseY >= 1000/n && mouseY <= 1200/n){
				if(mousePressed == true && table6.getNumPeople() != 0) {
					bill6 = true;
				}
			}
			if(mouseX >= 500/n && mouseX <= 800/n && mouseY >= 1500/n && mouseY <= 1700/n){
				if(mousePressed == true && table7.getNumPeople() != 0) {
					bill7 = true;
				}
			}
			if(mouseX >= 1000/n && mouseX <= 1300/n && mouseY >= 1500/n && mouseY <= 1700/n){
				if(mousePressed == true && table8.getNumPeople() != 0) {
					bill8 = true;
				}
			}
			if(mouseX >= 1500/n && mouseX <= 1800/n && mouseY >= 1500/n && mouseY <= 1700/n){
				if(mousePressed == true && table9.getNumPeople() != 0) {
					bill9 = true;
				}
			}
			
			
			//If the waiter activated the table in the table tab display the same information
			if(serverClicked1 == true)
			{
				textFont(aFont);
				fill(255);
				text("Server: Eve C.", 500/n, 500/n);
				fill(0);
				text("Seated:" , 530/n, 620/n);
				text(table1.getNumPeople(), 700/n, 620/n);	
			}
			if(serverClicked2 == true)
			{
				textFont(aFont);
				fill(255);
				text("Server: Eve C.", 1000/n, 500/n);
				fill(0);
				text("Seated:" , 1030/n, 620/n);
				text(table2.getNumPeople(), 1200/n, 620/n);
			}
			if(serverClicked3 == true)
			{
				textFont(aFont);
				fill(255);
				text("Server: Eve C.", 1500/n, 500/n);
				fill(0);
				text("Seated:" , 1530/n, 620/n);
				text(table3.getNumPeople(), 1700/n, 620/n);
			}
			if(serverClicked4 == true)
			{
				textFont(aFont);
				fill(255);
				text("Server: Eve C.", 500/n, 1000/n);
				fill(0);
				text("Seated:" , 530/n, 1120/n);
				text(table4.getNumPeople(), 700/n, 1120/n);
			}
			if(serverClicked5 == true)
			{
				textFont(aFont);
				fill(255);
				text("Server: Eve C.", 1000/n, 1000/n);
				fill(0);
				text("Seated:" , 1030/n, 1120/n);
				text(table5.getNumPeople(), 1200/n, 1120/n);
			}
			if(serverClicked6 == true)
			{
				textFont(aFont);
				fill(255);
				text("Server: Eve C.", 1500/n, 1000/n);
				fill(0);
				text("Seated:" , 1530/n, 1120/n);
				text(table6.getNumPeople(), 1700/n, 1120/n);
			}
			if(serverClicked7 == true)
			{
				textFont(aFont);
				fill(255);
				text("Server: Eve C.", 500/n, 1500/n);
				fill(0);
				text("Seated:" , 530/n, 1620/n);
				text(table7.getNumPeople(), 700/n, 1620/n);
			}
			if(serverClicked8 == true)
			{
				textFont(aFont);
				fill(255);
				text("Server: Eve C.", 1000/n, 1500/n);
				fill(0);
				text("Seated:" , 1030/n, 1620/n);
				text(table8.getNumPeople(), 1200/n, 1620/n);
			}
			if(serverClicked9 == true)
			{
				textFont(aFont);
				fill(255);
				text("Server: Eve C.", 1500/n, 1500/n);
				fill(0);
				text("Seated:" , 1530/n, 1620/n);
				text(table9.getNumPeople(), 1700/n, 1620/n);
			}		
			
			//If a the table is not empty and the button is pressed
			if(bill1 == true && table1.getNumPeople() != 0)
			{
				//Create bill and menu
				fill(54,64,120); 
				rect(300/n,200/n,2000/n, 2000/n);
				fill(255);
				rect(400/n, 300/n, 1500/n, 1600/n);
				fill(156, 192, 231);
				rect(1600/n,1700/n,200/n,100/n);
				fill(0);
				text("Submit", 1620/n,1750/n);
				
				//If waiter wants to cancel the bill press the x button 
				image(close, 1900/n, 200/n, 100/n, 100/n);
				if(overX())
				{
					if(mousePressed == true)
					{
						bill1 = false;
					}
				}
				//Submit bill button, deactivates the tables
				if(overSubB())
				{
					fill(150,0,38);
					if(mousePressed == true)
					{
						bill1 = false;
						serverClicked1 = false;
					}
				}
				
				//WIP: Display the users bill
				for(int i = 0; i < table1.getNumPeople(); i++)
				{
					fill(0);
					
					text("Name:", 520/n, 400/n);
					text("Price:", 1020/n, 400/n);
					text("Item ID:", 1320/n, 400/n);
					
					text(entreeNames[randEnt], 520/n, (110*(i+1)+450)/n);
					text(appNames[randApp], 520/n, (110*(i+1)+850)/n);
					text(drinkNames[randBev], 520/n, (110*(i+1)+1250)/n);
					
					text(entreePrices[randEnt], 1020/n, (110*(i+1)+450)/n);
					text(appPrices[randApp], 1020/n, (110*(i+1)+850)/n);
					text(drinkPrices[randBev], 1020/n, (110*(i+1)+1250)/n);
					
					text(randEntID, 1320/n, (110*(i+1)+450)/n);
					text(randAppID, 1320/n, (110*(i+1)+850)/n);
					text(randBevID, 1320/n, (110*(i+1)+1250)/n);
					
					
				}
			}
			//Repeat the bill process for each of the tables
			if(bill2 == true && table2.getNumPeople() != 0)
			{
				fill(54,64,120); 
				rect(300/n,200/n,2000/n, 2000/n);
				fill(255);
				rect(400/n, 300/n, 1500/n, 1600/n);
				fill(156, 192, 231);
				rect(1600/n,1700/n,200/n,100/n);
				fill(0);
				text("Submit", 1620/n,1750/n);
				
				image(close, 1900/n, 200/n, 100/n, 100/n);
				if(overX())
				{
					if(mousePressed == true)
					{
						bill2 = false;
					}
				}
				if(overSubB())
				{
					fill(150,0,38);
					if(mousePressed == true)
					{
						bill2 = false;
						serverClicked2 = false;
					}
				}
				for(int i = 0; i < table2.getNumPeople(); i++)
				{
					fill(0);
					
					text("Name:", 520/n, 400/n);
					text("Price:", 1020/n, 400/n);
					text("Item ID:", 1320/n, 400/n);
					
					text(entreeNames[randEnt], 520/n, (110*(i+1)+450)/n);
					text(appNames[randApp], 520/n, (110*(i+1)+850)/n);
					text(drinkNames[randBev], 520/n, (110*(i+1)+1250)/n);
					
					text(entreePrices[randEnt], 1020/n, (110*(i+1)+450)/n);
					text(appPrices[randApp], 1020/n, (110*(i+1)+850)/n);
					text(drinkPrices[randBev], 1020/n, (110*(i+1)+1250)/n);
					
					text(randEntID, 1320/n, (110*(i+1)+450)/n);
					text(randAppID, 1320/n, (110*(i+1)+850)/n);
					text(randBevID, 1320/n, (110*(i+1)+1250)/n);
					
					
				}
			}
			if(bill3 == true && table3.getNumPeople() != 0)
			{
				fill(54,64,120); 
				rect(300/n,200/n,2000/n, 2000/n);
				fill(255);
				rect(400/n, 300/n, 1500/n, 1600/n);
				fill(156, 192, 231);
				rect(1600/n,1700/n,200/n,100/n);
				fill(0);
				text("Submit", 1620/n,1750/n);
				
				image(close, 1900/n, 200/n, 100/n, 100/n);
				if(overX())
				{
					if(mousePressed == true)
					{
						bill3 = false;
					}
				}
				if(overSubB())
				{
					fill(150,0,38);
					if(mousePressed == true)
					{
						bill3 = false;
						serverClicked3 = false;
					}
				}
				for(int i = 0; i < table3.getNumPeople(); i++)
				{
					fill(0);
					
					text("Name:", 520/n, 400/n);
					text("Price:", 1020/n, 400/n);
					text("Item ID:", 1320/n, 400/n);
					
					text(entreeNames[randEnt], 520/n, (110*(i+1)+450)/n);
					text(appNames[randApp], 520/n, (110*(i+1)+850)/n);
					text(drinkNames[randBev], 520/n, (110*(i+1)+1250)/n);
					
					text(entreePrices[randEnt], 1020/n, (110*(i+1)+450)/n);
					text(appPrices[randApp], 1020/n, (110*(i+1)+850)/n);
					text(drinkPrices[randBev], 1020/n, (110*(i+1)+1250)/n);
					
					text(randEntID, 1320/n, (110*(i+1)+450)/n);
					text(randAppID, 1320/n, (110*(i+1)+850)/n);
					text(randBevID, 1320/n, (110*(i+1)+1250)/n);
					
					
				}
			}
			if(bill4 == true && table4.getNumPeople() != 0)
			{
				fill(54,64,120); 
				rect(300/n,200/n,2000/n, 2000/n);
				fill(255);
				rect(400/n, 300/n, 1500/n, 1600/n);
				fill(156, 192, 231);
				rect(1600/n,1700/n,200/n,100/n);
				fill(0);
				text("Submit", 1620/n,1750/n);
				
				image(close, 1900/n, 200/n, 100/n, 100/n);
				if(overX())
				{
					if(mousePressed == true)
					{
						bill4 = false;
					}
				}
				if(overSubB())
				{
					fill(150,0,38);
					if(mousePressed == true)
					{
						bill4 = false;
						serverClicked4 = false;
					}
				}
				for(int i = 0; i < table4.getNumPeople(); i++)
				{
					fill(0);
					
					text("Name:", 520/n, 400/n);
					text("Price:", 1020/n, 400/n);
					text("Item ID:", 1320/n, 400/n);
					
					text(entreeNames[randEnt], 520/n, (110*(i+1)+450)/n);
					text(appNames[randApp], 520/n, (110*(i+1)+850)/n);
					text(drinkNames[randBev], 520/n, (110*(i+1)+1250)/n);
					
					text(entreePrices[randEnt], 1020/n, (110*(i+1)+450)/n);
					text(appPrices[randApp], 1020/n, (110*(i+1)+850)/n);
					text(drinkPrices[randBev], 1020/n, (110*(i+1)+1250)/n);
					
					text(randEntID, 1320/n, (110*(i+1)+450)/n);
					text(randAppID, 1320/n, (110*(i+1)+850)/n);
					text(randBevID, 1320/n, (110*(i+1)+1250)/n);
					
					
				}
			}
			if(bill5 == true && table5.getNumPeople() != 0)
			{
				fill(54,64,120); 
				rect(300/n,200/n,2000/n, 2000/n);
				fill(255);
				rect(400/n, 300/n, 1500/n, 1600/n);
				fill(156, 192, 231);
				rect(1600/n,1700/n,200/n,100/n);
				fill(0);
				text("Submit", 1620/n,1750/n);
				
				image(close, 1900/n, 200/n, 100/n, 100/n);
				if(overX())
				{
					if(mousePressed == true)
					{
						bill5 = false;
					}
				}
				if(overSubB())
				{
					fill(150,0,38);
					if(mousePressed == true)
					{
						bill5 = false;
						serverClicked5 = false;
					}
				}
				for(int i = 0; i < table5.getNumPeople(); i++)
				{
					fill(0);
					
					text("Name:", 520/n, 400/n);
					text("Price:", 1020/n, 400/n);
					text("Item ID:", 1320/n, 400/n);
					
					text(entreeNames[randEnt], 520/n, (110*(i+1)+450)/n);
					text(appNames[randApp], 520/n, (110*(i+1)+850)/n);
					text(drinkNames[randBev], 520/n, (110*(i+1)+1250)/n);
					
					text(entreePrices[randEnt], 1020/n, (110*(i+1)+450)/n);
					text(appPrices[randApp], 1020/n, (110*(i+1)+850)/n);
					text(drinkPrices[randBev], 1020/n, (110*(i+1)+1250)/n);
					
					text(randEntID, 1320/n, (110*(i+1)+450)/n);
					text(randAppID, 1320/n, (110*(i+1)+850)/n);
					text(randBevID, 1320/n, (110*(i+1)+1250)/n);
					
					
				}
			}
			if(bill6 == true && table6.getNumPeople() != 0)
			{
				fill(54,64,120); 
				rect(300/n,200/n,2000/n, 2000/n);
				fill(255);
				rect(400/n, 300/n, 1500/n, 1600/n);
				fill(156, 192, 231);
				rect(1600/n,1700/n,200/n,100/n);
				fill(0);
				text("Submit", 1620/n,1750/n);
				
				image(close, 1900/n, 200/n, 100/n, 100/n);
				if(overX())
				{
					if(mousePressed == true)
					{
						bill6 = false;
					}
				}
				if(overSubB())
				{
					fill(150,0,38);
					if(mousePressed == true)
					{
						bill6 = false;
						serverClicked6 = false;
					}
				}
				for(int i = 0; i < table6.getNumPeople(); i++)
				{
					fill(0);
					
					text("Name:", 520/n, 400/n);
					text("Price:", 1020/n, 400/n);
					text("Item ID:", 1320/n, 400/n);
					
					text(entreeNames[randEnt], 520/n, (110*(i+1)+450)/n);
					text(appNames[randApp], 520/n, (110*(i+1)+850)/n);
					text(drinkNames[randBev], 520/n, (110*(i+1)+1250)/n);
					
					text(entreePrices[randEnt], 1020/n, (110*(i+1)+450)/n);
					text(appPrices[randApp], 1020/n, (110*(i+1)+850)/n);
					text(drinkPrices[randBev], 1020/n, (110*(i+1)+1250)/n);
					
					text(randEntID, 1320/n, (110*(i+1)+450)/n);
					text(randAppID, 1320/n, (110*(i+1)+850)/n);
					text(randBevID, 1320/n, (110*(i+1)+1250)/n);
					
					
				}
			}
			if(bill7 == true && table7.getNumPeople() != 0)
			{
				fill(54,64,120); 
				rect(300/n,200/n,2000/n, 2000/n);
				fill(255);
				rect(400/n, 300/n, 1500/n, 1600/n);
				fill(156, 192, 231);
				rect(1600/n,1700/n,200/n,100/n);
				fill(0);
				text("Submit", 1620/n,1750/n);
				
				image(close, 1900/n, 200/n, 100/n, 100/n);
				if(overX())
				{
					if(mousePressed == true)
					{
						bill7 = false;
					}
				}
				if(overSubB())
				{
					fill(150,0,38);
					if(mousePressed == true)
					{
						bill7 = false;
						serverClicked7 = false;
					}
				}
				for(int i = 0; i < table7.getNumPeople(); i++)
				{
					fill(0);
					
					text("Name:", 520/n, 400/n);
					text("Price:", 1020/n, 400/n);
					text("Item ID:", 1320/n, 400/n);
					
					text(entreeNames[randEnt], 520/n, (110*(i+1)+450)/n);
					text(appNames[randApp], 520/n, (110*(i+1)+850)/n);
					text(drinkNames[randBev], 520/n, (110*(i+1)+1250)/n);
					
					text(entreePrices[randEnt], 1020/n, (110*(i+1)+450)/n);
					text(appPrices[randApp], 1020/n, (110*(i+1)+850)/n);
					text(drinkPrices[randBev], 1020/n, (110*(i+1)+1250)/n);
					
					text(randEntID, 1320/n, (110*(i+1)+450)/n);
					text(randAppID, 1320/n, (110*(i+1)+850)/n);
					text(randBevID, 1320/n, (110*(i+1)+1250)/n);
					
					
				}
			}
			if(bill8 == true && table8.getNumPeople() != 0)
			{
				fill(54,64,120); 
				rect(300/n,200/n,2000/n, 2000/n);
				fill(255);
				rect(400/n, 300/n, 1500/n, 1600/n);
				fill(156, 192, 231);
				rect(1600/n,1700/n,200/n,100/n);
				fill(0);
				text("Submit", 1620/n,1750/n);
				
				image(close, 1900/n, 200/n, 100/n, 100/n);
				if(overX())
				{
					if(mousePressed == true)
					{
						bill8 = false;
					}
				}
				if(overSubB())
				{
					fill(150,0,38);
					if(mousePressed == true)
					{
						bill8 = false;
						serverClicked8 = false;
					}
				}
				for(int i = 0; i < table8.getNumPeople(); i++)
				{
					fill(0);
					
					text("Name:", 520/n, 400/n);
					text("Price:", 1020/n, 400/n);
					text("Item ID:", 1320/n, 400/n);
					
					text(entreeNames[randEnt], 520/n, (110*(i+1)+450)/n);
					text(appNames[randApp], 520/n, (110*(i+1)+850)/n);
					text(drinkNames[randBev], 520/n, (110*(i+1)+1250)/n);
					
					text(entreePrices[randEnt], 1020/n, (110*(i+1)+450)/n);
					text(appPrices[randApp], 1020/n, (110*(i+1)+850)/n);
					text(drinkPrices[randBev], 1020/n, (110*(i+1)+1250)/n);
					
					text(randEntID, 1320/n, (110*(i+1)+450)/n);
					text(randAppID, 1320/n, (110*(i+1)+850)/n);
					text(randBevID, 1320/n, (110*(i+1)+1250)/n);
					
					
				}
			}
			if(bill9 == true && table9.getNumPeople() != 0)
			{
				fill(54,64,120); 
				rect(300,200,2000, 2000);
				fill(255);
				rect(400, 300, 1500, 1600);
				fill(156, 192, 231);
				rect(1600,1700,200,100);
				fill(0);
				text("Submit", 1620,1750);
				
				image(close, 1900/n, 200/n, 100/n, 100/n);
				if(overX())
				{
					if(mousePressed == true)
					{
						bill9 = false;
					}
				}
				if(overSubB())
				{
					fill(150,0,38);
					if(mousePressed == true)
					{
						bill9 = false;
						serverClicked9 = false;
					}
				}
				for(int i = 0; i < table9.getNumPeople(); i++)
				{
					fill(0);
					
					text("Name:", 520/n, 400/n);
					text("Price:", 1020/n, 400/n);
					text("Item ID:", 1320/n, 400/n);
					
					text(entreeNames[randEnt], 520/n, (110*(i+1)+450)/n);
					text(appNames[randApp], 520/n, (110*(i+1)+850)/n);
					text(drinkNames[randBev], 520/n, (110*(i+1)+1250)/n);
					
					text(entreePrices[randEnt], 1020/n, (110*(i+1)+450)/n);
					text(appPrices[randApp], 1020/n, (110*(i+1)+850)/n);
					text(drinkPrices[randBev], 1020/n, (110*(i+1)+1250)/n);
					
					text(randEntID, 1320/n, (110*(i+1)+450)/n);
					text(randAppID, 1320/n, (110*(i+1)+850)/n);
					text(randBevID, 1320/n, (110*(i+1)+1250)/n);
					
					
				}
			}
			fill(250,0,38);
		}
		
		//Create text and image for the bill tab
		rect(50/n, 1200/n, 200/n, 200/n);
		fill(0);
		text("Bill", 110/n, 1190/n);
		image(pay, 60/n, 1210/n, 175/n, 175/n);
		
		
		//Stock tab////////////////////////////////////////////////////////////////////////////
		//Same as table tab
		textFont(aFont);
		fill(182,165,155);
		
		//Enabling the stock tab
		if(overStock())
		{
			fill(150,0,38);
			if(mousePressed == true)
			{
				menuClicked = false;
				billClicked = false;
				stockClicked = true;
				tabClicked = false;
				fill(250,0,38);
			}
		}
	
		//When stock tab is enabled
		if(stockClicked == true)
		{
			//Create blank space
			fill(100);
			rect(400/n,200/n,1500/n,1600/n);
			
			//If selected beverages 
			fill(255,159,47);
			if(overBev())
			{
				fill(150,0,38);
				//Disable other sub-tabs
				if (mousePressed == true)
				{
					bevClicked = true;
					appClicked = false;
					entClicked = false;
					desClicked = false;
				}
			}
			//If beverage sub-tab enabled
			if(bevClicked == true)
			{
				//display graph with all drink names, random data displayed, create jitter effect
				for(int i = 0; i < drinkNames.length; i++)
				{
					fill(255);
					text(drinkNames[i], 420/n, ((140*(i+1))+120)/n);
					fill(255,159,47);
					rect(800/n, ((140*(i+1))+120)/n, (random(1000,1005))/n, 50/n);
				}
			}
			rect(400/n, 50/n, 100/n, 100/n);
			fill(255);
			text("B", 430/n, 110/n);
			
			//If selected appetizers
			fill(117,168,255);
			if(overApp())
			{
				fill(150,0,38);
				//Disable other sub-tabs
				if (mousePressed == true)
				{
					bevClicked = false;
					appClicked = true;
					entClicked = false;
					desClicked = false;
				}
			}
			//Display graph with random numbers sorted least to greatest
			if(appClicked == true)
			{
				for(int i = 0; i < appNames.length; i++)
				{
					fill(255);
					text(appNames[i], 420/n, ((140*(i+1))+120)/n);
					fill(117,168,255);
					rect(800/n, ((140*(i+1))+140)/n, (i+1)*randNum/n, 50/n);
				}
			}
			rect(550/n, 50/n, 100/n, 100/n);
			fill(255);
			text("A", 580/n, 110/n);
			
			
			//If entrees selected
			fill(0,103,0);
			if(overEnt())
			{
				fill(150,0,38);
				//Disable other sub-tabs
				if (mousePressed == true)
				{
					bevClicked = false;
					appClicked = false;
					entClicked = true;
					desClicked = false;
				}
			}
			//If enabled
			if(entClicked == true)
			{
				//Display graph
				for(int i = 0; i < 11; i++)
				{
					fill(255);
					text(entreeNames[i], 420/n, ((140*(i+1))+120)/n);
					fill(0,103,0);
					rect(800/n, ((140*(i+1))+140)/n, ((i+1)*2-randNum*2+400)/n, 50/n);
				}
			}
			rect(700/n, 50/n, 100/n, 100/n);
			fill(255);
			text("E", 730/n, 110/n);
			
			//If desserts selected
			fill(211,40,158);
			if(overDes())
			{
				//Disable other sub-tabs
				fill(150,0,38);
				if (mousePressed == true)
				{
					bevClicked = false;
					appClicked = false;
					entClicked = false;
					desClicked = true;
				}
			}
			//If enabled
			if(desClicked == true)
			{
				//Display graph
				for(int i = 0; i < dessertNames.length; i++)
				{
					fill(255);
					text(dessertNames[i], 420/n, ((140*(i+1))+200)/n);
					fill(211,40,158);
					rect(800/n, ((140*(i+1))+140)/n, ((i+1)*2-randNum*2+550)/n, 50/n);
				}
			}
			rect(850/n, 50/n, 100/n, 100/n);
			fill(255);
			text("D", 880/n, 110/n);
			
			//If stock is ordered enable boolean
			fill(255);
			if(overOrder())
			{
				fill(150,0,38);
				if(mousePressed == true)
				{
					if(bevClicked == true)
					{
						bevOrder = true;
					}
					if(appClicked == true)
					{
						appOrder = true;
					}
					if(entClicked == true)
					{
						entOrder = true;
					}
					if(desClicked == true)
					{
						desOrder = true;
					}
				}
			}
			rect(1500/n, 50/n, 400/n, 100/n);
			fill(0);
			text("Order Stock", 1550/n,120/n);
			
			//If both the sub-tab and the boolean are enabled, display that stock has been ordered.
			if(bevOrder == true && bevClicked == true)
			{
				fill(255);
				text("*Beverages Ordered*", 1000/n, 100/n);
			}
			if(entOrder == true && entClicked == true)
			{
				fill(255);
				text("*Entrees Ordered*", 1000/n, 100/n);
			}
			if(appOrder == true && appClicked == true)
			{
				fill(255);
				text("*Appetizers Ordered*", 1000/n, 100/n);
			}
			if(desOrder == true && desClicked == true)
			{
				fill(255);
				text("*Desserts Ordered*", 1000/n, 100/n);
			}
			fill(250,0,38);
		}
		
		
		//Display text and image for stock tab
		rect(50/n, 1600/n, 200/n, 200/n);
		stroke(0);
		strokeWeight(4);
		fill(0);
		text("Stock", 90/n, 1590/n);
		image(inv, 60/n, 1620/n, 175/n, 175/n);
		
	}
	
	//Processing function to check for full mouse click
	@Override
	public void mouseClicked()
	{
		if(menuClicked == true)
		{
			fullClick=true;
		}
		if(tabClicked == true)
		{
			fullClick=true;
		}
	}
	
	//Functions of type boolean that return if the mouse is over a certain position
	
	//For tabs, selecting each general tab
	boolean overTable(){if(mouseX >= 50/n && mouseX <= 250/n && mouseY >= 400/n && mouseY <= 600/n){return true;}else{return false;}}
	boolean overMenu(){if(mouseX >= 50/n && mouseX <= 250/n && mouseY >= 800/n && mouseY <= 1000/n) {return true;}else {return false;}}
	boolean overBill(){if(mouseX >= 50/n && mouseX <= 250/n && mouseY >= 1200/n && mouseY <= 1400/n) {return true;}else {return false;}}
	boolean overStock(){if(mouseX >= 50/n && mouseX <= 250/n && mouseY >= 1600/n && mouseY <= 1800/n) {return true;}else {return false;}}
	
	//For stock tabs, display sub-tabs and order button
	boolean overOrder(){if(mouseX >= 1500/n && mouseX <= 1900/n && mouseY >= 50/n && mouseY <= 150/n) {return true;}else {return false;}}
	boolean overBev() {if(mouseX >= 400/n && mouseX <= 500/n && mouseY >= 50/n && mouseY <= 150/n){return true;} else{return false;}}
	boolean overApp() {if(mouseX >= 550/n && mouseX <= 650/n && mouseY >= 50/n && mouseY <= 150/n){return true;} else{return false;}}
	boolean overEnt() {if(mouseX >= 700/n && mouseX <= 800/n && mouseY >= 50/n && mouseY <= 150/n){return true;} else{return false;}}
	boolean overDes() {if(mouseX >= 850/n && mouseX <= 950/n && mouseY >= 50/n && mouseY <= 150/n){return true;} else{return false;}}
	
	//For menu tab, order buttons and WIP scrolling function
	boolean overUp() {if(mouseX >= 500/n && mouseX <= 1800/n && mouseY >= 650/n && mouseY <= 700/n){return true;} else{return false;}}
	boolean overDown() {if(mouseX >= 500/n && mouseX <= 1800/n && mouseY >= 1500/n && mouseY <= 1550/n){return true;} else{return false;}}
	boolean overSubm() {if(mouseX >= 1000/n && mouseX <= 1300/n && mouseY >= 1650/n && mouseY <= 1750/n){return true;} else{return false;}}
	boolean overBevM() {if(mouseX >= 500/n && mouseX <= 700/n && mouseY >= 520/n && mouseY <= 620/n){return true;} else{return false;}}
	boolean overAppM() {if(mouseX >= 850/n && mouseX <= 1050/n && mouseY >= 520/n && mouseY <= 620/n){return true;} else{return false;}}
	boolean overEntM() {if(mouseX >= 1250/n && mouseX <= 1450/n && mouseY >= 520/n && mouseY <= 620/n){return true;} else{return false;}}
	boolean overDesM() {if(mouseX >= 1600/n && mouseX <= 1800/n && mouseY >= 520/n && mouseY <= 620/n){return true;} else{return false;}}
	
	//For bill tab, close and submit buttons
	boolean overX() {if(mouseX >= 1900/n && mouseX <= 2000/n && mouseY >= 200/n && mouseY <= 300/n){return true;} else{return false;}}
	boolean overSubB() {if(mouseX >= 1600/n && mouseX <= 1800/n && mouseY >= 1700/n && mouseY <= 1800/n){return true;} else{return false;}}
	
	//For menu tab, left and right selection arrows
	boolean overRight() {if(mouseX >= 1680/n && mouseX <= 1780/n && mouseY >= 350/n && mouseY <= 450/n){return true;} else{return false;}}
	boolean overLeft() {if(mouseX >= 520/n && mouseX <= 620/n && mouseY >= 350/n && mouseY <= 450/n){return true;} else{return false;}}
	
	boolean overRightSt() {if(mouseX >= 1700/n && mouseX <= 1800/n && mouseY >= 310/n && mouseY <= 410/n){return true;} else{return false;}}
	boolean overLeftSt() {if(mouseX >= 500/n && mouseX <= 650/n && mouseY >= 310/n && mouseY <= 410/n){return true;} else{return false;}}
	
	boolean overStats() {if(mouseX >= 1000/n && mouseX <= 1300/n && mouseY >= 150/n && mouseY <= 350/n){return true;} else{return false;}}
}