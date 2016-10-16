Create an interface “CreditCardInterface” with methods : viewCreditAmount(), useCard(),
payCredit() and increaseLimit(). Create a class SilverCardCustomer (name, cardnumber (16
digits), creditAmount – initialized to 0, creditLimit - set to 50,000 ) which implements the above
interface. Inherit class GoldCardCustomer from SilverCardCustomer having the same methods
but creditLimit of 1,00,000. Create an object of each class and perform operations. Display
appropriate messages for success or failure of transactions. (Use method overriding)
	i. useCard() method increases the creditAmount by a specific amount upto creditLimit
	ii. payCredit() reduces the creditAmount by a specific amount.
	iii. increaseLimit() increases the creditLimit for GoldCardCustomers (only 3 times, not more
		than 5000Rs. each time)
