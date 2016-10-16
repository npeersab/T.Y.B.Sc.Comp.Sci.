import java.util.Scanner;

class InsufficientFundsException extends Exception {

        String message;
	
	public InsufficientFundsException(String msg) {
	
		System.out.println("Insufficient Funds :");
		message = msg;
        }

	public void displayMessage() {

		System.out.println(message);
	}
}

public class SavingAccount {

	private int acNo, balance;
	String name;

	public SavingAccount() {

		Scanner ip = new Scanner(System.in);

                System.out.print("Enter ac no : ");
                int acNo = ip.nextInt();
                System.out.print("Enter name : ");
                String name = ip.next();
		balance = 500;
	}

	public void withdraw() {

		Scanner ip = new Scanner(System.in);		
		
		System.out.print("Enter amount : ");
		int amt = ip.nextInt();

		try {
			if(balance - amt < 500)
					throw new InsufficientFundsException("Your Balance is : " + balance);
			else {
				balance -= amt;
		                System.out.println(amt + " withdrawn from account");
	               		viewBalance();
			}	
		}
			catch(InsufficientFundsException ife) {

				ife.displayMessage();			
			}
	}
	
	public void deposit() {
	
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Enter amount : ");
		int amt = ip.nextInt();	
		balance += amt;
		System.out.println(amt + " deposited to account");
		viewBalance();
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
			
			switch(choice) {
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
	}
}

