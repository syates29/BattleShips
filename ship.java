
public class ship {
	
	//Establishes a string for the ship's name
	String name;
	
	//Establishes a permanent int for the ship's size
	int size;
	
	//Establishes an int that shows how much health the ship has left
	int health;

	//Ship constructor
	public ship(String shipName) {
		
		//Set name of ship
		this.name = shipName;
		
		//Set stats for patrol boat
		if (shipName.equals("patrol boat")) {
			
			this.size = 2;
			this.health = 2;
			
		}
		
		//Set stats for destroyer and submarine
		else if (shipName.equals("destroyer") || shipName.equals("submarine")) {
			
			this.size = 3;
			this.health = 3;
			
		}
		
		//Set stats for battleship
		else if (shipName.equals("battleship")) {
			
			this.size = 4;
			this.health = 4;
			
		}
			
		//Set stats for aircraft carrier
		else if (shipName.equals("aircraft carrier")) {
			
			this.size = 5;
			this.health = 5;
			
		}
			
	}
	
	
	//Getter for the ship's name
	public String getName() {
		
		return this.name;
		
	}

	//Getter for ship's size
	public int getSize() {
		
		return this.size;
		
	}
	
	//Getter for ship's current health
	public int getHealth() {
		
		return this.health;
		
	}
	
	
	//Method for ship taking a hit
	public void hit() {
		
		this.health = (this.health - 1);
		
	}

	
	
	
	
	public static void main(String[] args) {
		
//		for (String ship : battleship.ships) {
//			
//			ship test = new ship(ship);
//			System.out.println(test.getName() + ": " + test.getHealth() + " / " + test.getSize());
//			
//		}
		
		
	}
	
}
