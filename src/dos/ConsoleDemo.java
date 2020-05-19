package dos;

import ds.CellStorage;

public class ConsoleDemo {
	static CellStorage world;
	static int length = 20;
	static Boolean[][] orgWorld = new Boolean[length][length];
	public static void main(String[] args) {
		// TODO orgWorld ≥ı ºªØ
		// ...
		world.init(orgWorld);
		while(true) {
			world.calcNeighbors();
			world.nextStatus();
			
		}
	}

}
