package setB.que2;

import java.util.Scanner;

public class SilverCardCustomer implements CreditCardInterface {
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
		ip.close();
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
		ip.close();
	}

	public void increaseLimit() {
		System.out.println("These Facility is not Available for Silver Card users");
	}
}