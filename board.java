import java.util.regex.Pattern;

public class board {
	
	//Sets no. of columns and rows
	final int rows = 10;
	final int columns = 10;
	
	//Establishes the board as an empty array of int arrays
	public int[][] board;
	
	//Sets some valid inputs
	public static final Pattern pValidInput = Pattern.compile("[a-j][1-9]|[a-j][1][0]|q");
	
	
	//Creates the board given the set rows and columns
	public board() {
		
		this.board = new int[rows][columns];		
		
	}
	
	
	//Method for printing out the board
	public void printBoard() {
		
		//Establish upper-board markings
		String outerLine = "     a   b   c   d   e   f   g   h   i   j\n";
		
		//Establish inner-board lines
		String boardLine = "   +---+---+---+---+---+---+---+---+---+---+\n";

		//Initialise inner-board
		String innerBoard = "";

		//Iterate through board columns/rows
		for (int i = 0; i < board.length; i++) {

			//Add inner board lines at start of new line
			innerBoard += boardLine;

			//Print board row number
			if (i == 9) {
				
				//Row 9 is special case as row number '10' is two digits wide - spacing is reduced to compensate
				innerBoard += (1 + i) + " |";
			}
			
			else {
				
				//Every other row number is only 1 digit - spacing does not need to be adjusted
				innerBoard += (1 + i) + "  |";
				
			}
			
			
			//Iterate through every value in current row
			for (int j = 0; j < board[i].length; j++) {

				//Add spacing, value, and marking to innerBoard string
				innerBoard += " " + board[i][j] + " |";

			}

			//Move to next line
			innerBoard += "\n";
		}

		//Add boardLine at end of pieces array
		innerBoard += boardLine;

		//Create full board object of innerBoard surrounded by outer markings
		String board = outerLine + innerBoard;

		//Return complete board - not currently in use
		//return board;
		
		//Prints out the board
		System.out.println(board);

	}
	
	
	//Places a ship given the coordinates, orientation and size
	public void placeShip(String coordinates, String orientation, int size){
		
		//Establishes empty ints for column & row
		int column;
		int row;
		
		//Converts inputter coordinates into a charArray
		char[] coords = coordinates.toCharArray();
		
		//Switch statement on first char of coordinates (should be a letter)
		switch(coords[0]) {
		
			//If the coordinate given begins with a, must be in column 0
			case 'a':	column = 0;
						break;
					
			case 'b':	column = 1;
						break;
		
			case 'c':	column = 2;
						break;
		
			case 'd':	column = 3;
						break;
		
			case 'e':	column = 4;
						break;
		
			case 'f':	column = 5;
						break;
		
			case 'g':	column = 6;
						break;
		
			case 'h':	column = 7;
						break;
		
			case 'i':	column = 8;
						break;
		
			case 'j':	column = 9;
						break;
					
			default:	return;
		
		}
				
		
		//If length of coordinates was 3, the row must be 10 (i.e. b10)
		if (coords.length == 3) {
			
			row = 10;
			
		}
		
		//Otherwise, only 2 digits in the coordinate
		else if (coords.length == 2) {
			
			//Minus the 2nd char by 49 to get actual int value
			row = coords[1] - 49;
			
		}
		
		else {
			
			return;
			
		}
		
		
		//If given inputs are not valid, print message
		if(!(isValidLocation(column, row, size, orientation))) {
			
			System.out.println("Error Message 1");
			return;
			
		}

		
		//If reached this stage, inputs must have been valid
		//If the orientation was set as vertical
		if(orientation == "vertical"){

			//Iterate for size of ship (i.e. 3 places)
			for(int i = 0; i < size; i++) {

				//Increase value of row by 1 each iteration
				//Set value at that location to 1
				this.board[row + i][column] = 1;

			}
		}

		//If the orientation was set as vertical
		else if(orientation == "horizontal"){

			//Iterate for size of ship (i.e. 3 places)
			for(int i = 0; i < size; i++) {

				//Increase value of column by 1 each iteration
				//Set value at that location to 1
				this.board[row][column + i] = 1;

			}
		}

		//Otherwise, 
		else {

			System.out.println("Invalid Location!");

		}

	}
	
	
	//Method to check to see if a location is a valid input
	public boolean isValidLocation(int column, int row, int size, String orientation) {
		
		//If the size of the ship if zero - return false
		if(size == 0) {
			
			return false;
			
		}
		
		try {
			
			//If the orientation is vertical
			if(orientation == "vertical"){

				//Iterate over size of ship no. of places
				for(int i = 0; i < size; i++) {
					
					//If any value at those locations is not equal to zero (i.e. already a ship there or otherwise non-zero)
					if (!(this.board[row + i][column] == 0)) {
						
						//Return false
						return false;
						
					}

				}
				
				//If passed, return true
				return true;
			}

			//If the orientation is horizontal
			else if(orientation == "horizontal"){

				//Iterate over size of ship no. of places
				for(int i = 0; i < size; i++) {
					
					//If any value at those locations is not equal to zero (i.e. already a ship there or otherwise non-zero)					
					if (!(this.board[row][column + i] == 0)) {
						
						//Return false
						return false;
						
					}

				}
				
				//If passed, return true
				return true;
			}
			
			//For any other input, return false
			else {
				
				return false;
				
			}
			
		}
		
		//If OutOfBounds exception triggers, return false
		catch(ArrayIndexOutOfBoundsException error) {
			
			return false;
			
		}
		

		
	}
	
	
	
	public static void main(String[] args) {
		
//		board test = new board();
//		
//		test.printBoard();
//		
//		System.out.println(test.isValidLocation(0, 2, 2, "vertical"));
//		
//		test.placeShip("a2", "vertical", 2);
//		
//		test.printBoard();

	}
	
}
