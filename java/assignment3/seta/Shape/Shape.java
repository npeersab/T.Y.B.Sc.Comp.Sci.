import java.util.Scanner;

public abstract class Shape {

	abstract public double calcArea();
	abstract public double calcVolume();
	abstract public void accept();

	public static void main(String args[]) {

		System.out.print("1.Sphere 
	}
}

class Sphere extends Shape {

	private double radius;
	
	public double calcArea() {

		return 4 * 3.14 * radius * radius;
	}

	public double calcVolume() {
			
		return (4 * 3.14 * radius * radius * radius) / 3;
	}

	public void accept
}

class Cone extends Shape {


	private double radius, height;

	public double calcArea() {

		return 3.14 * radius * height;
	}

	public double calcVolume() {

		return (3.14 * radius * radius * height) / 3;
	}
}

class Cylinder extends Shape {
		
	private double radius, height;

	public double calcArea() {
			
		return 2 * 3.14 * radius * (radius + height); 
	}

	public double calcVolume() {

		return 3.14 * radius * radius * height;
	}
	
}

class Box extends Shape {

	private double length, breadth, height;

	public double calcArea() {
		
		return 2 * (length * breadth + length * height + breadth * height);
	}	

	public double calcVolume() {

		return length *  breadth * height;
	}
}	
