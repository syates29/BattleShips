import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class battleship {
	
	boolean gameState;
	
	board playerBoard;
	board opponentBoard;
	
	public static final Pattern pValidInput = Pattern.compile("[a-j][1-9]|[a-j][1][0]|q");
	public static final Pattern pValidInput2 = Pattern.compile("horizontal|vertical|q");
	
	
	public battleship() {
		
		this.gameState = true;
		
		this.playerBoard = new board();
		this.opponentBoard = new board();
		
		System.out.println("Welcome to BattleShips!\n");
	
		playerBoard.printBoard();	
		
		this.setUp();
	
	}
	
	
	
	public void setUp() {
		
		//Create string variable for storing user input
		String userPlacement;
		String orientation;

		//Establish new scanner to attain user input
		Scanner scanner = new Scanner(System.in);
		
		while (gameState != false){
			
			try {
				
				for (String ship : ship.ships) {
					
					System.out.println("Place your " + ship + ":");
					
					ship test = new ship(ship);
					
					//Prompt the user for their move
					userPlacement =	scanner.next(pValidInput);
					
					System.out.println("Orientation (horizontal or vertical):");
					
					orientation = scanner.next(pValidInput2);
					
//					System.out.println(userPlacement);
//					System.out.println(orientation);
//					System.out.println(test.size);
					
					playerBoard.placeShip(userPlacement, orientation, test.size);
								
					playerBoard.printBoard();

				}
				
			}
			
			//If input is invalid: trigger catch
			catch (InputMismatchException e) {
				System.out.println("Unexpected input");
				scanner = new Scanner(System.in);
			}
	
		}
		
		scanner.close();
		
	}
	
	
	
	
	public void gameStart() {
		
		//Create string variable for storing user input
		String userMove;

		//Establish new scanner to attain user input
		Scanner scanner = new Scanner(System.in);

		try {

			System.out.println("Enter your move:");
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
