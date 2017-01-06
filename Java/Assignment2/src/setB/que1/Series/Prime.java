package setB.que1.Series;
	
public class Prime {
	// display n prime numbers
	public static void displayPrime(int n) {
		for (int i = 0, j = 2; i < n; j++) {
			int k;
			for (k = 2; k < j; k++)
				if (j % k == 0)
					break;
			if (k == j) {
				System.out.print(j + " ");
				i++;
			}
		}
	}
}
