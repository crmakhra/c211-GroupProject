package __CarRentalApp;

public class Customer {
	String name;
	String accountType; // "Bronze", "Silver", or "Gold"
	String phoneNumber;
	String address;
	String accountNum;
	
	// Constructor
	Customer(String name, String accountType, String phoneNumber, String address, String accountNumber){
		this.name = name;
		this.accountType = accountType;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.accountNum = accountNumber;
	}
	
}
