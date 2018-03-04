import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class battleship {
	
	//Creates a boolean to indicate if game is still on (true = on)
	boolean gameState;
	
	//Establishes the player's board. Where their ships will be stored
	board playerBoard;
	
	//Establishes the opponent's board. Where the opponent's ships will be stored.
	board opponentBoard;
	
	//Establishes two input patterns (input of q would mean 'quit')
	public static final Pattern pValidInput = Pattern.compile("[a-j][1-9]|[a-j][1][0]|q");
	public static final Pattern pValidInput2 = Pattern.compile("horizontal|vertical|q");
	
	//List of the ships
	public static String[] ships = new String[]{"patrol boat", "destroyer", "submarine", "battleship", "aircraft carrier"};
	
	
	//Constructor for game
	public battleship() {
		
		//Sets gameState to true (i.e. game is not over)
		this.gameState = true;
		
		//Establishes empty boards for each player
		this.playerBoard = new board();
		this.opponentBoard = new board();
		
		//Print welcome text
		System.out.println("Welcome to BattleShips!\n");
	
		//Print empty board
		playerBoard.printBoard();	
		
		//Runs setUp on this game
		this.setUp();
	
	}
	
	
	//Set up phase where players place their ships
	public void setUp() {

		//Create string variable for storing user input
		String userPlacement;
		String orientation;

		//Establish new scanner to attain user input
		Scanner scanner = new Scanner(System.in);

		try {

			//Iterate through ships in ship list
			for (String ship : ships) {

				//Prompt user to place the current ship
				System.out.println("Place your " + ship + ":");

				//Create a new ship object
				ship test = new ship(ship);

				//Scan for valid coordinates
				userPlacement =	scanner.next(pValidInput);

				//Prompt user to declare orientation
				System.out.println("Orientation (horizontal or vertical):");

				//Scan for valid orientation
				orientation = scanner.next(pValidInput2);

//				System.out.println(userPlacement);
//				System.out.println(orientation);
//				System.out.println(test.size);

				//Take user's input and call placeShip on the playerBoard
				playerBoard.placeShip(userPlacement, orientation, test.size);

				//Print the playerBoard (should now include a new ship)
				playerBoard.printBoard();

			}

		}

		//If input is invalid: trigger catch
		catch (InputMismatchException e) {
			//Inform user that input was wrong
			System.out.println("Unexpected input");
			
			//Should prompt user for new input
		}

		//Close the scanner
		scanner.close();

	}
	
	
	
	//Actual start of game
	//Should cycle between player shots until no ships remain
	public void gameStart() {
		
		//Create string variable for storing user input
		String userMove;

		//Establish new scanner to attain user input
		Scanner scanner = new Scanner(System.in);

		try {

			System.out.println("Enter your attack:");
			userMove =	scanner.next(pValidInput);

		}

		//If input is invalid: trigger catch
		catch (InputMismatchException e) {
			System.out.println("Unexpected input");
		}
		
		scanner.close();
					
	}
	

	
	
	
	
	
	
	

	public static void main(String[] args) {
		
		battleship testGame = new battleship();
	
//		for (String ship : ship.ships) {
//			
//			ship test = new ship(ship);
//			System.out.println(test.name + ": " + test.size);
//			
//		}
//		
//		board test = new board();
//		
//		System.out.println(test.printBoard());
	

	}

}
