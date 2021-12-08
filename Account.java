package __CarRentalApp;

abstract class Account {
	String accountNumber;
	Customer customer;
	// Constructor
	public Account(String accountNumber, Customer customer) { 
		this.accountNumber = accountNumber;
		this.customer = customer;
	}
            // Method for displaying information
            public String displayCustomerInfo(){ 
            String info = "";
            info += (" * " + "Customer Name: " + this.customer.name + " | " + "Account Type: " + this.customer.accountType + " | " +  
				"Phone: " + this.customer.phoneNumber + " | " + "Address: " + this.customer.address + " | " 
				+ "Account Number: " + this.customer.accountNum + "\n");
            return info;
            }
	
}
