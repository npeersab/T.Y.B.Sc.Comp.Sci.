package setA.que2;

import java.util.Scanner;

public class SavingAccount {
	private int acNo, balance;
	String name;

	public SavingAccount() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter ac no : ");
		setAcNo(scanner.nextInt());
		System.out.print("Enter name : ");
		name = scanner.next();
		balance = 500;
		scanner.close();
	}

	public void withdraw() {
		Scanner scanner = new Scanner(System.in);		

		System.out.print("Enter amount : ");
		int amt = scanner.nextInt();

		try {
			if(balance - amt < 500) {
				scanner.close();
				throw new InsufficientFundsException("Your Balance is : " + balance);
			}
			else {
				balance -= amt;
				System.out.println(amt + " withdrawn from account");
				viewBalance();
			}	
		}
		catch (InsufficientFundsException ife) {
			ife.displayMessage();			
		}
		scanner.close();
	}

	public void deposit() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter amount : ");
		int amt = scanner.nextInt();	
		balance += amt;
		System.out.println(amt + " deposited to account");
		viewBalance();
		scanner.close();
	}	

	public void viewBalance() {
		System.out.println("Your current balance is " + balance);
	}

	public static void main(String args[]) {
		SavingAccount account = new SavingAccount();

		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.print("\n1.Withdraw\n2.Deposit\n3.View Balance\n4.Exit\nEnter Choice : ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1 :
				account.withdraw();
				break;
			case 2 :
				account.deposit();
				break;
			case 3 :
				account.viewBalance();
				break;
			case 4 :
				flag = false;
			}
		}
		scanner.close();
	}

	public int getAcNo() {
		return acNo;
	}
	
	public void setAcNo(int acNo) {
		this.acNo = acNo;
	}
}