
public class ship {

	public static String[] ships = new String[]{"patrol boat", "destroyer", "submarine", "battleship", "aircraft carrier"};
	
	String name;
	int size;
	int health;

			
	public ship(String shipName) {
		
		this.name = shipName;
		
		if (shipName.equals("patrol boat")) {
			
			this.size = 2;
			this.health = 2;
			
		}
		
		else if (shipName.equals("destroyer") || shipName.equals("submarine")) {
			
			this.size = 3;
			this.health = 3;
			
		}
			
		else if (shipName.equals("battleship")) {
			
			this.size = 4;
			this.health = 4;
			
		}
			
		else if (shipName.equals("aircraft carrier")) {
			
			this.size = 5;
			this.health = 5;
			
		}
			
	}
	
	
	
	public String getName() {
		
		return this.name;
		
	}


	public int getSize() {
		
		return this.size;
		
	}
	
	public int getHealth() {
		
		return this.health;
		
	}
	
	
	public void hit() {
		
		this.health = (this.health - 1);
		
	}

	
	
	
	
	public static void main(String[] args) {
		
		for (String ship : ships) {
			
			ship test = new ship(ship);
			System.out.println(test.getName() + ": " + test.getHealth() + " / " + test.getSize());
			
		}
		
		
	}
	
}
