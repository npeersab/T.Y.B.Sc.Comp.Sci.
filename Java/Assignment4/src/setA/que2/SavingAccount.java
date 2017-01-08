package setA.que2;

import java.util.Scanner;

public class SavingAccount {
	private int acNo, balance;
	String name;

	public SavingAccount() {
		Scanner ip = new Scanner(System.in);

		System.out.print("Enter ac no : ");
		setAcNo(ip.nextInt());
		System.out.print("Enter name : ");
		name = ip.next();
		balance = 500;
		ip.close();
	}

	public void withdraw() {
		Scanner ip = new Scanner(System.in);		

		System.out.print("Enter amount : ");
		int amt = ip.nextInt();

		try {
			if(balance - amt < 500) {
				ip.close();
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
		ip.close();
	}

	public void deposit() {
		Scanner ip = new Scanner(System.in);

		System.out.print("Enter amount : ");
		int amt = ip.nextInt();	
		balance += amt;
		System.out.println(amt + " deposited to account");
		viewBalance();
		ip.close();
	}	

	public void viewBalance() {
		System.out.println("Your current balance is " + balance);
	}

	public static void main(String args[]) {
		SavingAccount account = new SavingAccount();

		Scanner ip = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.print("\n1.Withdraw\n2.Deposit\n3.View Balance\n4.Exit\nEnter Choice : ");
			int choice = ip.nextInt();

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
		ip.close();
	}

	public int getAcNo() {
		return acNo;
	}
	
	public void setAcNo(int acNo) {
		this.acNo = acNo;
	}
}