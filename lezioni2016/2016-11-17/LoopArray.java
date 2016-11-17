
public class LoopArray {
	public static void main(String[] args) {
		printJava(1, 2, 3, 4, 5);
		printJava(10, 13, -3);
		printJava(-2);
		printJava();
	}

	public static void printC(int[] vs) {
		for (int v: vs)
			System.out.println(v);
	}
	
	public static void printJava(int... vs) {
		for (int v: vs)
			System.out.println(v);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
