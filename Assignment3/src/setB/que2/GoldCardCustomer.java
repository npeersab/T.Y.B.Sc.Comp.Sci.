package setB.que2;

import java.util.Scanner;

public class GoldCardCustomer extends SilverCardCustomer {
	int incCount;
	
	public GoldCardCustomer() {
		creditLimit = 1_00_000;
	}

	public void increaseLimit() {
		if(incCount < 3) {
			System.out.print("Enter amount : ");
			Scanner ip = new Scanner(System.in);
			int amount = ip.nextInt();
			if(amount <= 5_000) {
				System.out.println("Credit Limit Increased by " + amount);
				System.out.println("New Limit : " + (creditLimit += amount));
				incCount++;
			}
			else
				System.out.println("Credit Limit cannot be increased by more 5,000");
			
			ip.close();
		}
		else
			System.out.println("Cannot increase Credit Limit more than 3 Times");
	}	
}
