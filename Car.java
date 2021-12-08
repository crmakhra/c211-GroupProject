// Written by Dylan
package __CarRentalApp;
import java.util.Random;

public class Car {
	String make;
	String model;
	String year;
	String color;
	int miles;
	String accountType;
	String vin;
    Customer cust;
	
    // Constructor
	Car(String make, String model, String year, String color, int miles, String accountType, String vin){
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.miles = miles;
		this.accountType = accountType;
		this.vin = vin;
        this.cust = null;
	}
        // Method for adding customer to car
        public void addCust(Customer addCust){
            this.cust = addCust;
        }
        // Method for removing customer from car
        public void removeCust(Customer removeCust){
            this.cust = null;
        }
        // Method for adding random miles to car after customer returns car
        public int addMiles(){
            int temp;
            Random rand = new Random();
            temp = rand.nextInt((1000 - 100) + 1) + 100;
            miles += temp;
            return temp;
        }
        // Method to display car information
        public String displayCarInfo(){
        	String info = "";
            info += ("* " + "Make: " + this.make + " | " + "Model: " + this.model + " | " + "Year: " + this.year + " | " + 
                                "Color: " + this.color + " | " + "Miles: " + this.miles + " | " + "Account Type: " + this.accountType + 
				" | " + "VIN: " + this.vin + " | " + "Available: ");
            if(this.cust == null){
                info += ("Yes \n");
            }
            else{
                info += ("No | ");
                info += ("Rented By: " + cust.name + "\n");
            }

            
            return info;
        }
}
