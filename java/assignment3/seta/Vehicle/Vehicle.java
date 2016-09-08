import java.util.Scanner;

abstract public class Vehicle {

	private	String company;
	private float price;

	abstract public void accept();
	abstract public void display();

	public void acceptVehicle() {
	
		Scanner ip = new Scanner(System.in);
		
		System.out.print("\nEnter company : ");
		company = ip.next();
		System.out.print("Enter price : ");
		price = ip.nextFloat();
	}

	public void displayVehicle() {

		System.out.println("\nCompany : " + company);
		System.out.println("Price : " + price);
	}

	public static void main(String args[]) {

		System.out.print("How many Vehicles ? : ");
		
		Scanner ip = new Scanner(System.in);
		int n = ip.nextInt();

		Vehicle vehicle[] = new Vehicle[n];

		for(int i = 0; i < n; i++) {
			System.out.print("\n1.Light Motor Vehicle\n2.Heavy Motor Vehicle\nEnter Choice : ");
			int choice = ip.nextInt();

			switch(choice) {

				case 1 :
					vehicle[i] = new LightMotorVehicle();
					break;
				case 2 :
					vehicle[i] = new HeavyMotorVehicle();
			}

			vehicle[i].accept();
		}	

		System.out.println("\nVehicle Details :\n");
		for(int i = 0; i < n; i++)
			vehicle[i].display();  
	}
}

class LightMotorVehicle extends Vehicle {

	private float mileage;

	public void accept() {

		acceptVehicle();
		Scanner ip = new Scanner(System.in);

		System.out.print("Enter mileage : ");
		mileage = ip.nextFloat();		
	}

	public void display() {

		displayVehicle();
		System.out.println("Mileage : " + mileage);
	}
}

class HeavyMotorVehicle extends Vehicle {

	private float capacity;

	public void accept() {
	
		acceptVehicle();
		Scanner ip = new Scanner(System.in);
	
		System.out.print("Enter Capacity (in tons) : ");
		capacity = ip.nextFloat();
	}

	public void display() {
	
		displayVehicle();
		System.out.println("Capacity (in tons) : " + capacity);

	}
}
