import java.util.Scanner;

interface CreditCardInterface {

	public void viewCreditAmount();
	public void useCard();
	public void payCredit();
	public void increaseLimit();
}

class SilverCardCustomer implements CreditCardInterface {

	String name, cardNumber;
	int creditAmount;
	int creditLimit = 50_000;

	public void viewCreditAmount() {

		System.out.println("Credit Amount : " + creditAmount);

	}

	public void useCard() {

		Scanner ip = new Scanner(System.in);		
		
		System.out.print("Enter amount : ");
		int amt = ip.nextInt();

		if(amt + creditAmount > creditLimit)
			System.out.println("Transaction failed : Credit Limit Exceed");
		else
			creditAmount += amt;

	}

	public void payCredit() {

		viewCreditAmount();
		System.out.print("Enter amount to be paid : ");
		Scanner ip = new Scanner(System.in);
		int amt = ip.nextInt();
		if(creditAmount < amt)
			System.out.println("Amount to be paid should be less than credit amount");
		else
			creditAmount -= amt;
		viewCreditAmount();
		

	}

	public void increaseLimit() {

		System.out.println("These Facility is not Available for Silver Card users");
	}

	public static void main(String args[]) {

		System.out.print("1.Silver Card Customer\n2.Gold Card Customer\nEnter choice : ");
		Scanner ip = new Scanner(System.in);
		int choice = ip.nextInt();
		CreditCardInterface customer = new SilverCardCustomer();
		if(choice == 1)
			customer = new SilverCardCustomer();
		else
			customer = new GoldCardCustomer();

		boolean flag = true;
		while(flag) {
			System.out.print("\n1.Use Card\n2.Pay Credit\n3.View Credit Amount\n4.Increase Credit Limit\n5.Exit\nEnter your choice : ");
			choice = ip.nextInt();
			switch(choice) {
				case 1 :
					customer.useCard();
					break;
				case 2 :
					customer.payCredit();
					break;
				case 3 :
					customer.viewCreditAmount();
					break;
				case 4 :
					customer.increaseLimit();
					break;
				case 5 :
					flag = false;
			}
		}
	}
}

class GoldCardCustomer extends SilverCardCustomer {


	GoldCardCustomer() {

		creditLimit = 1_00_000;
	}
	int incCount;
	
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
		}
		else
			System.out.println("Cannot increase Credit Limit more than 3 Times");
	}	
}
