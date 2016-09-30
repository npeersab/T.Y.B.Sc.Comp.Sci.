class Mynumber {

	public static void main(String args[]) {

		if(args.length > 0) {

			Mynumber num1 = new Mynumber(Integer.parseInt(args[0]));

			System.out.println(Integer.parseInt(args[0]));

			if(num1.isNegative())
				System.out.println("Number is negative");
			if(num1.isPositive())
				System.out.println("Number is positive");
			if(num1.isZero())
				System.out.println("Number is zero");
			if(num1.isEven())
				System.out.println("Number is even");
			if(num1.isOdd())
				System.out.println("Number is odd");
		}
		else 
			System.out.println("Insufficient arguments");
		

	}

	private int number;
	
	//default constructor
	Mynumber() { 

		number = 0;
	}

	//parameterized constructor
	Mynumber(int num) {

		this.number = num;
	}

	public boolean isNegative() {
		
		return number < 0;
	}

	public boolean isPositive() {

		return number > 0;
	}

	public boolean isZero() {

		return number == 0;
	}

	public boolean isOdd() {

		return number % 2 != 0;
	}

	public boolean isEven() {
	
		return number % 2 == 0;
	}

}
