import java.util.regex.Pattern;

public class board {
	
	final int rows = 10;
	final int columns = 10;
	
	public int[][] board;
	
	public static final Pattern pValidInput = Pattern.compile("[a-j][1-9]|[a-j][1][0]|q");
	
	
	public board() {
		
		this.board = new int[rows][columns];		
		
	}
	
	
	public void printBoard() {
		
		//Establish outer-board markings
		String outerLine = "     a   b   c   d   e   f   g   h   i   j\n";
		
		//Establish inner-board lines
		String boardLine = "   +---+---+---+---+---+---+---+---+---+---+\n";

		//Initialise inner-board as string
		String innerBoard = "";

		//Iterate through chessBoard string rows (array of pieces)
		for (int i = 0; i < board.length; i++) {

			//Print board lines above start of each new line
			innerBoard += boardLine;

			//Print board line number
			if (i == 9) {
				
				innerBoard += (1 + i) + " |";
			}
			
			else {
				
				innerBoard += (1 + i) + "  |";
				
			}
			
			
			//Iterate through every value in current row
			for (int j = 0; j < board[i].length; j++) {

				//Add each piece and end of square marking
				innerBoard += " " + board[i][j] + " |";

			}

			//Move to next line
			innerBoard += "\n";
		}

		//Add boardline at end of pieces array
		innerBoard += boardLine;

		//Create full board object of innerBoard surrounded by outer markings
		String board = outerLine + innerBoard;

		//Return complete board
		//return board;
		
		System.out.println(board);

	}
	
	
	public void placeShip(String coordinates, String orientation, int size){
		
		int column;
		int row;
		
		char[] coords = coordinates.toCharArray();
		
		switch(coords[0]) {
		
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
				
		
		
		if (coords.length == 3) {
			
			row = 10;
			
		}
		
		else if (coords.length == 2) {
			
			row = coords[1] - 49;
			
		}
		
		else {
			
			return;
			
		}
		
		
		if(!(isValidLocation(column, row, size, orientation))) {
			
			System.out.println("Invalid Location!");
			return;
			
		}

		
		if(orientation == "vertical"){

			for(int i = 0; i < size; i++) {

				this.board[row + i][column] = 1;

			}
		}

		else if(orientation == "horizontal"){

			for(int i = 0; i < size; i++) {

				this.board[row][column + i] = 1;

			}
		}

		else {

			System.out.println("Invalid Location!");

		}

	}
	
	
	public boolean isValidLocation(int column, int row, int size, String orientation) {
		
		if(size == 0) {
			
			return false;
			
		}
		
		try {
			
			if(orientation == "vertical"){

				for(int i = 0; i < size; i++) {
					
					if (!(this.board[row + i][column] == 0)) {
						
						return false;
						
					}

				}
				
				return true;
			}

			else if(orientation == "horizontal"){

				for(int i = 0; i < size; i++) {
					
					if (!(this.board[row][column + i] == 0)) {
						
						return false;
						
					}

				}
				
				return true;
			}
			
			else {
				
				return false;
				
			}
			
		}
		
		catch(ArrayIndexOutOfBoundsException error) {
			
			return false;
			
		}
		

		
	}
	
	
	
	public static void main(String[] args) {
		
		board test = new board();
		
		test.printBoard();
		
		System.out.println(test.isValidLocation(0, 2, 2, "vertical"));
		
		test.placeShip("a2", "vertical", 2);
		
		test.printBoard();

	}
	
}
