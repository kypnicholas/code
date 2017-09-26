import java.util.*;

public class battleship2 {

	
	
	public static void main(String[] args)
	{
		
		int row =0,col=0;
		Scanner in = new Scanner (System.in);
		
		//// game board
		String [][] boardArray = new String [10][10];	
		String [][] targetsArray = new String [10][10];
		String [][] shootingArray = new String [10][10]; 
		
		boolean playAgain=false;
		//char aChar= Character.UNASSIGNED;
		//char aChar=' ';
		// PROBABLY THROWS EXCEPTION because aChar is given a value the first time so position [0] is full so it moves to the next position 
		
		//System.out.println(aChar);
		
		while (playAgain==false)
		{
			System.out.println("Start a new game of battleship?");
			System.out.println("Y/N");
			String yesNo = in.nextLine();
			char aChar = yesNo.charAt(0);
			aChar = Character.toUpperCase(aChar);
		
			if (aChar == 'Y')
			{
				playAgain=true;
			}	
			else if (aChar == 'N')
			{
				playAgain=false;
				System.out.print("We are sorry to see you leaving!\n");
				System.exit(0);
			}
			else
			{
				System.out.print("\nPlease choose an option between 'Y' or 'N' \n");
				//playAgain=false;
			}	
			
			
			while (playAgain==true)
			{	
				System.out.print("\nPlay battleship\n");
				System.out.print("---------------\n");
						
				System.out.print("  0  1  2  3  4  5  6  7  8  9\n");
				for (col=0; col < 10; col++) 
				{      
					
					System.out.print(col);
					for (row = 0; row < 10; row++) 
					{        
						boardArray[col][row] = " | ";
						shootingArray[col][row] = " | ";
						targetsArray[col][row]= " | ";
						System.out.print(boardArray[col][row]); 
					}
					System.out.println();
				}    
				
			
				//// set ships randomly on the board
				/*
				int counter = 0;
				int shipsPlaced =17;
				
				int index = new Random().nextInt(100);
				int [] randomsArray = targetsArray.get(index);
				
				Random random;
				random = new Random();
				
				while (counter < shipsPlaced)
				{
					int randomRow = random.nextInt(col-1);
					int randomCol = random.nextInt(row-1);
					targetsArray[randomRow][randomCol] = "W";
					counter++;
				}	
				*/
				
				
				//////// user sets the ships on the board manually
				String shipPos = " W ";
				int shipElements = 0;
				String horizontalVertical;
				int shipCol=0,shipRow=0;
				char setSubmarine[] = "WWWW".toCharArray();
				char setDestroyer[] = "WWW".toCharArray();
				char setPatrol[] = "WW".toCharArray();
				
				while (shipElements != 4) // total ship elements on the board
				{	
					
					while (shipElements<4) // ship elements for aircraft on the board
					{
						System.out.println("\n-------------------------------------------------------------------");
						System.out.println("Please enter coordinates for the Submarine (4 positions on the board)");
						System.out.println("-------------------------------------------------------------------");
						//System.out.println("Do you want to place the Submarine Horizontally or Vertically? (H/V)");
						//horizontalVertical = in.nextLine();  
						//char anotherChar = horizontalVerical.charAt(0);
						//anotherChar = Character.toUpperCase(anotherChar);
						System.out.println("Enter a number (0-9) for Y-coordinate: ");
						shipCol = in.nextInt();		
						System.out.println("Enter a number (0-9) for X-coordinate: ");
						shipRow = in.nextInt();
						
						
						/*switch (shipCol) {
							case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
						    default:
					    	System.out.println("Please enter a number within the range.\n");
						}*/
						
						//// Make sure the user doesn't add a number greater than 9
						if (shipCol>9 || shipRow>9)
						{
							System.out.println("Please enter a number within the right range");
							System.out.println("Enter a number (0-9) for Y-coordinate: ");
							shipCol = in.nextInt();		
							System.out.println("Enter a number (0-9) for X-coordinate: ");
							shipRow = in.nextInt();
						}
						
						
						//// Attempt to write a string in the 2D array
						//for (int i=0; i<=setSubmarine.length; i++)
						/*{
							targetsArray[shipCol][shipRow] = shipPos;
							System.out.print("  0  1  2  3  4  5  6  7  8  9\n");
							for (col = 0; col < 10; col++) 
							{      
								System.out.print(col);
								for (row = 0; row < 10; row++) 
								{        
										System.out.print(targetsArray[col+1][row]);  
								}
								System.out.println();
							}    
							System.out.println("\nYou placed the Submarine on the board starting in the position: " + shipCol + "," + shipRow);
							shipElements++;
							System.out.println("\nSo far you have placed:" + shipElements + " elements");
						}*/
						
							
		 				targetsArray[shipCol][shipRow] = shipPos;
						System.out.print("  0  1  2  3  4  5  6  7  8  9\n");
						for (col = 0; col < 10; col++) 
						{      
							System.out.print(col);
							for (row = 0; row < 10; row++) 
							{        
								System.out.print(targetsArray[col][row]);  
							}
							System.out.println();
						}    
						System.out.println("\nYou placed the aircraft on the board starting in the position: " + shipCol + "," + shipRow);
						shipElements++;
						System.out.println("So far you have placed:" + shipElements + " elements"); 
						
					}
					
					
					/* working but commented out to avoid looping so many times													
					while ((shipElements<7))
					{
						System.out.println("\n-------------------------------------------------------------------");
						System.out.println("Please enter coordinates for the DESTROYER (3 positions on the board)");
						System.out.println("-------------------------------------------------------------------");
						System.out.println("Enter a number (0-9) for Y-coordinate: ");
						shipCol = in.nextInt();		
						switch (UIcol) {
						case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
							break;
					    default:
					    	System.out.println("Please enter a number within the range");
						}
						
						System.out.println("Enter a number (0-9) for X-coordinate: ");
						shipRow = in.nextInt();
						
									
						targetsArray[shipCol][shipRow] = shipPos;
						System.out.print("  0  1  2  3  4  5  6  7  8  9\n");
						for (col = 0; col < 10; col++) 
						{      
							System.out.print(col);
							for (row = 0; row < 9; row++) 
							{        
								System.out.print(targetsArray[col][row]);  
							}
							System.out.println();
						}    
						System.out.println("\nYou placed the DESTROYER on the board starting in the position: " + shipCol + "," + shipRow);
						shipElements++;
						System.out.println("\nSo far you have placed:" + shipElements + " elements"); 
					}
					
					while ((shipElements<9))
					{
						System.out.println("\n-------------------------------------------------------------------");
						System.out.println("Please enter coordinates for the PATROL (2 positions on the board)");
						System.out.println("-------------------------------------------------------------------");
						System.out.println("Enter a number (0-9) for Y-coordinate: ");
						shipCol = in.nextInt();		
						switch (UIcol) {
						case 0: case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
							break;
					    default:
					    	System.out.println("Please enter a number within the range");
						}
						
						System.out.println("Enter a number (0-9) for X-coordinate: ");
						shipRow = in.nextInt();
						
									
						targetsArray[shipCol][shipRow] = shipPos;
						System.out.print("  0  1  2  3  4  5  6  7  8  9\n");
						for (col = 0; col < 10; col++) 
						{      
							System.out.print(col);
							for (row = 0; row < 9; row++) 
							{        
								System.out.print(targetsArray[col][row]);  
							}
							System.out.println();
						}    
						System.out.println("\nYou placed the PATROL on the board starting in the position: " + shipCol + "," + shipRow);
						shipElements++;
						System.out.println("\nSo far you have placed:" + shipElements + " elements");
						System.out.println("\nGreat you have played all the ships on the board. \nNow you can start your attacks!");
					}*/
					
					
					
				}
			
				////////// user attacks
				String hitPoint = " X ";
				String missPoint = " O ";
				boolean goodUI = false;
				boolean targetHit = false;
				int totalHits = 0;
				
				
				while (totalHits != 4)
				{	
					int UIcol=0,UIrow=0;
					System.out.println("\n-------------------------------------------------------------");
					System.out.println("ATTACK - Please enter coordinates of the ship you want to attack");
					System.out.println("----------------------------------------------------------------");
					System.out.println("Enter a number (0-9) for Y-coordinate: ");
					UIcol = in.nextInt();							
					System.out.println("Enter a number (0-9) for X-coordinate: ");
					UIrow = in.nextInt();
					
					
					//// Make sure the user doesn't add a number greater than 9
					if (UIcol>9 || UIrow>9)
					{
						System.out.println("Please enter a number within the right range");
						System.out.println("Enter a number (0-9) for Y-coordinate: ");
						UIcol = in.nextInt();	
						System.out.println("Enter a number (0-9) for X-coordinate: ");
						UIrow = in.nextInt();
					}
					
					//// print "X" is user finds the target or "O" if he misses
					if (targetsArray[UIcol][UIrow]== " W ")
					{
						targetsArray[UIcol][UIrow] = hitPoint;
						totalHits++;	
					}
					else if (targetsArray[UIcol][UIrow]== hitPoint)
					{
						System.out.println("\n---Stop shooting this guy. He is already dead!---\n");
					}
					else
					{
						targetsArray[UIcol][UIrow] = missPoint;
					}
					
					//// Prints the shots of the user into the shootingArray which is empty so the user cannot see the positions of the ships
					if (targetsArray[UIcol][UIrow] == hitPoint)
					{
						shootingArray[UIcol][UIrow] = hitPoint;
					}
					else if (targetsArray[UIcol][UIrow] == missPoint)
					{
						shootingArray[UIcol][UIrow] = missPoint;
					}
					
					
					System.out.print("  0  1  2  3  4  5  6  7  8  9\n");
					for (col = 0; col < 10; col++) 
					{      
						System.out.print(col);
						for (row = 0; row < 10; row++) 
						{        
							System.out.print(shootingArray[col][row]);  
						}
						System.out.println();
					}
						
					
					/*  CORRECT. COME BACK HERE IF OTHERS DON'T WORK
					System.out.print("  0  1  2  3  4  5  6  7  8  9\n");
					for (col = 0; col < 10; col++) 
					{      
						System.out.print(col);
						for (row = 0; row < 9; row++) 
						{        
							System.out.print(targetsArray[col][row]);  
						}
						System.out.println();
					}  */  
					
					
					
					if (targetHit == true)
					{	
						totalHits++;
						System.out.println("You have hit: " + totalHits + " so far. ");
					}
					
				}
				//playAgain=false;
				System.out.println("\n\n        CONGRATULATIONS  !!!!!  \nYou have successfully killed all the bad guys.\nThank you!\n");
			}
		}
		//playAgain=false;	
	}
}
