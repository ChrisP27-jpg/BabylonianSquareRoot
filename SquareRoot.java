package hw04;

public class SquareRoot {
	private static double epsilon = 1E-6;
	
	private double n;
	private int depth;
	private Tree guesses;
	
	public SquareRoot(double n) {
		this.n=n;
		depth = 0;
		guesses = null;
	}
	
	public static void setEpsilon(double param) {
		epsilon = param;
	}
	
	public Tree getGuesses() {return guesses;}
	
	public int getDepth() {return depth;}
	
	public double sqrt() {
		if (n<0) {
			return Double.NaN;
		}
		
		return sqrt(n/2);
		
	}
	
	public double sqrt(double y) {
		if (guesses==null) {
			guesses = new Tree(y);
		}
		else {
			guesses.insert(y);
		}
		double err = n - (y*y);
		if (Math.abs(err)<epsilon) {
			return y;
		}
		else {
			depth++;
			if (depth > 300) {
				System.out.println("===> Maximum depth exceeded");
				return y;
			}
			y=0.5*(y+(n/y));
			return sqrt(y);
		}
	}

	public static void main(String[] args) {
		System.out.println("Calculating square root of command line arguments");
		for(String arg : args) {
			double n = Double.parseDouble(arg);
			SquareRoot sr = new SquareRoot(n);
			double g = sr.sqrt();
			double mg = Math.sqrt(n);
			System.out.println("sqrt(" + n + ")=" + g + " Math.sqrt(" + n + ")=" + mg +
					" Difference=" + (Math.abs(g-mg))+ " depth=" + sr.getDepth());
			System.out.println("  Guesses: " + sr.getGuesses());
		}
		System.out.println("\nTry again with a smaller epsilon.");
		setEpsilon(1E-14);
		for(String arg : args) {
			double n = Double.parseDouble(arg);
			SquareRoot sr = new SquareRoot(n);
			double g = sr.sqrt();
			double mg = Math.sqrt(n);
			System.out.println("sqrt(" + n + ")=" + g + " Math.sqrt(" + n + ")=" + mg +
					" Difference=" + (Math.abs(g-mg))+ " depth=" + sr.getDepth());
			System.out.println("  Guesses: " + sr.getGuesses());
		}

	}

}
