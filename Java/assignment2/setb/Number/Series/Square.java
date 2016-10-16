package Series;

public class Square {

	// display n terms of series of square e.g. 1, 4, 9, 16 ...
	public static void displaySquare(int n) {

		for (int i = 1; i <= n; i++)
			System.out.print((i * i) + " ");
	}
}
