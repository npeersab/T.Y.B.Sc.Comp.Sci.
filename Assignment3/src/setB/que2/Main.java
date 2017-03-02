package setB.que2;

import java.util.Scanner;

public class Main {
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
		ip.close();
	}
}
