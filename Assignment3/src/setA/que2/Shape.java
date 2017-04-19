package setA.que2;

import java.util.Scanner;

public abstract class Shape {
	public final double pi = 3.142;

	abstract void calcArea();
	abstract void calcVolume();

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("\n1.Sphere\n2.Cone\n3.Cylinder\n4.Box\nEnter Shape : ");
		int choice = scanner.nextInt();
		Shape shape = null;
		switch(choice) {
		case 1 :
			shape = new Sphere();
			break;	
		case 2 :
			shape = new Cone();
			break;
		case 3 :
			shape = new Cylinder();
			break;
		case 4 :
			shape = new Box();
			break;
		default :
			System.out.println("Invalid Shape....");
		}

		shape.calcArea();
		shape.calcVolume();
		scanner.close();
	}
}

class Sphere extends Shape {
	private int rad;

	public Sphere() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter radius : ");
		rad = scanner.nextInt();
		scanner.close();
	}

	public void calcArea() {
		System.out.printf("Area : %.4f\n", 4 * pi * rad * rad);
	}

	public void calcVolume() {
		System.out.printf("Volume : %.4f\n", (4 * pi * rad * rad * rad) / 3);
	}
}

class Cone extends Shape {
	private int rad, hei;

	public Cone() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter radius : ");
		rad = scanner.nextInt();
		System.out.print("Enter height : ");
		hei = scanner.nextInt();
		scanner.close();
	}

	public void calcArea() {
		System.out.printf("Area : %.4f\n", pi * rad * hei);
	}

	public void calcVolume() {
		System.out.printf("Volumee : %.4f\n", (pi * rad * rad * hei) / 3);
	}
}

class Cylinder extends Shape {
	private int rad, hei;

	public Cylinder() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter radius : ");
		rad = scanner.nextInt();	
		System.out.print("Enter height : ");
		hei = scanner.nextInt();
		scanner.close();
	}

	public void calcArea() {
		System.out.printf("Area : %.4f\n", 2 * pi * rad * (rad + hei));
	}

	public void calcVolume() {
		System.out.printf("Volume : %.4f\n", pi * rad * rad * hei);
	}
}

class Box extends Shape {
	private int len, bre, hei;

	public Box() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter length : ");
		len = scanner.nextInt();
		System.out.print("Enter breadth : ");
		bre = scanner.nextInt();
		System.out.print("Enter height : ");
		hei = scanner.nextInt();		
		scanner.close();
	}

	public void calcArea() {
		System.out.printf("Suface Area : %.4f\n", 2 * (len * bre + len * hei + bre * hei));
	}

	public void calcVolume() {
		System.out.printf("Volume : %.4f\n", len * bre * hei);
	}
}
