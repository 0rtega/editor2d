package editor2d.Utils;

public class Identifier {

	
	private Identifier() {}
	private static Identifier instance = new Identifier();
	private int number = 0;
	
	public static Identifier getInstance() {
		return instance;
	}
	
	public int getId() {
		number++;
		return number;
	}
}
