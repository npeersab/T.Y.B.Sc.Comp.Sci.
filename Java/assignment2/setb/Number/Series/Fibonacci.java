package Series;

public class Fibonacci {

	// display fibonacci series of n terms
	public static void displayFibonacci(int n) {

		int a = 1, b = 1, c;

		for(int i = 0; i < n; i++) {
			System.out.print(a + " ");
			c = a;
			a = b;
			b = a + c;
		}
	}
}
		
