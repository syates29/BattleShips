
public class boardString {

	private String[][] board =	   {{"        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        "},
									{"        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        "},
									{"        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        "},
									{"        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        "},
									{"        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        "},
									{"        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        "},
									{"        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        "},
									{"        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        "},
									{"        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        "},
									{"        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        ", "        "}};

	

	
	
	public String printBoard() {

		//Establish outer-board markings
		String outerLine = "        a        b        c        d        e        f        g        h        i        j\n";
		
		//Establish inner-board lines
		String boardLine = "   +--------+--------+--------+--------+--------+--------+--------+--------+--------+--------+\n";

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
				innerBoard += board[i][j] + "|";

			}

			//Move to next line
			innerBoard += "\n";
		}

		//Add boardline at end of pieces array
		innerBoard += boardLine;

		//Create full board object of innerBoard surrounded by outer markings
		String board = outerLine + innerBoard;

		//Return complete board
		return board;

	}
	
	
	
	public static void main(String[] args) {
		
		boardString test = new boardString();
		
		System.out.println(test.printBoard());

	}
	

}
