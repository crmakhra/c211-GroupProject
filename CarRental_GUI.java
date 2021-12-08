package __CarRentalApp;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CarRental_GUI extends Application {
	
Stage window;
// ArrayLists for Accounts, Cars, and Account Numbers
static ArrayList<Account> listOfAccounts = new ArrayList<Account>();
static ArrayList<Car> listOfCars = new ArrayList<Car>();
static ArrayList<String> listOfAccountNumbers = new ArrayList<String>();

// Create inventory of car objects
static Car car1 = new Car("Chevrolet", "Impala", "2018", "Blue", 55000, "Bronze", "1234");
static Car car2 = new Car("Ford", "Fiesta", "2018", "Silver", 60000, "Bronze", "3456");
static Car car3 = new Car("Kia", "Forte", "2019", "Gray", 65000, "Bronze", "5678");
static Car car4 = new Car("Honda", "Civic", "2019", "Yellow", 25000, "Silver","2233");
static Car car5 = new Car("Toyota", "Camry", "2020", "Green", 30000, "Silver", "3344");
static Car car6 = new Car("Nissan", "Altima", "2020", "Blue", 35000, "Silver", "4455");
static Car car7 = new Car("Hyundai", "Sonata", "2020", "Purple", 40000, "Silver", "5566");
static Car car8 = new Car("BMW", "M5", "2021", "Black", 10000, "Gold", "1212");
static Car car9 = new Car("Mercedes-Benz", "A-Class", "2021", "Silver", 12000, "Gold", "2323");
static Car car10 = new Car("Porche", "Cayenne", "2021", "Red", 15000, "Gold", "3434");

// Method to add cars to listOfCars ArrayList (occurs only once in the main method)
static void addCars() {
	listOfCars.add(car1);
	listOfCars.add(car2);
	listOfCars.add(car3);
	listOfCars.add(car4);
	listOfCars.add(car5);
	listOfCars.add(car6);
	listOfCars.add(car7);
	listOfCars.add(car8);
	listOfCars.add(car9);
	listOfCars.add(car10);
}
// Method to display which cars are rented out
static String displayRented() {
    int numberRented = 0;
    String info = "";
    info += ("List of Cars Currently Rented");
	info += ("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	for (int i = 0; i < listOfCars.size() ; i++) {
		if(listOfCars.get(i).cust != null){
                        info += listOfCars.get(i).displayCarInfo();
                        numberRented++;
                    }
	}
            if(numberRented == 0){
                info += ("(empty)");
            }
	//info += ("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	
	return info;
}
// Method to display available cars
static String displayCarInformation() {
	String info = "";
	info += ("Vehicle Inventory");
	info += ("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n"
			+ "");
	for (int i = 0; i < listOfCars.size(); i++){
                info += listOfCars.get(i).displayCarInfo();
	}
	//info += ("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	return info;
}
// Method to display customer information
static String displayCustomerInformation() {
	String info = "";
	info += ("Customer Information");
	info += ("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
	for (int i = 0; i < listOfAccounts.size();i++) {
		info += listOfAccounts.get(i).displayCustomerInfo();
	}
	if (listOfAccounts.isEmpty()) info += ("(empty)");
	return info;
}
	// Main Method
	public static void main(String[] args) {
		addCars();
		launch(args);
	}
	
	// Primary Stage size 800 by 610
	@Override
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		window.setTitle("Car Rental Application");
		Scene mainScene = new Scene(mainPane(), 800, 610);
		window.setScene(mainScene);	
		window.show();
	} 
		 
	protected BorderPane mainPane() {

		  // Declare all Labels needed for GUI
		  Label lblCreateAccount = new Label("Create an Account");
		  Label lblName = new Label("Enter Customer Name");
		  Label lblCustomerPhone = new Label("Enter Phone Number");
		  Label lblCustomerAddress = new Label("Enter Address");
		  Label lblAccountNum = new Label("Enter Account Number");
		  Label lblRentACar = new Label("      Rent a Car");
		  Label lblRentACarAccountNum = new Label("Enter Account Number");
		  Label lblRentACarVIN = new Label("Enter Car VIN Number");
		  Label lblReturnACar = new Label("     Return a Car");
		  Label lblReturnACarAccountNum = new Label("Enter Account Number");
		  Label lblReturnACarVIN = new Label("Enter Car VIN Number");
		  Label lblOutput = new Label("OUTPUT");
		  lblCreateAccount.setStyle("-fx-font: 20 arial; -fx-base: #ff2222;");
		  lblRentACar.setStyle("-fx-font: 20 arial; -fx-base: #ff2222;");
		  lblReturnACar.setStyle("-fx-font: 20 arial; -fx-base: #ff2222;");
		  lblOutput.setStyle("-fx-font: 20 arial; -fx-base: #ff2222;");
		  
		  // Declare all Buttons needed for GUI
		  Button bronzeButton = new Button("Create Bronze Account");
		  Button silverButton = new Button("Create Silver Account");
		  Button goldButton = new Button("Create Gold Account");
		  Button rentACarButton = new Button("Rent Car");
		  Button returnACarButton = new Button("Return Car");
		  Button customerInfoButton = new Button("View Customer Information");		  
		  Button inventoryButton = new Button("View Inventory");
		  Button rentedCarsButton = new Button("View Rented Cars");
		  Button exitButton = new Button("Exit");
		  exitButton.setStyle("-fx-font: 20 arial; -fx-base: #ff2222;");
		  
		  // Declare TextArea for Output
		  TextArea displayOutput = new TextArea();
		  displayOutput.setPrefRowCount(10); 
		  displayOutput.setStyle("-fx-font: 11 arial; -fx-base: gray");


		  // Format buttons at the top of application horizontally
		  HBox topPane = new HBox(4);
		  topPane.getChildren().addAll(customerInfoButton, inventoryButton, rentedCarsButton, exitButton);
		  topPane.setAlignment(Pos.CENTER);
		  
		  
		  // Formatting for everything in between top buttons and bottom output display
		  GridPane centerPane = new GridPane();
		  centerPane.setPadding(new Insets(20));
		  centerPane.setHgap(10);
		  centerPane.setVgap(10);
		  
		  // Positioning for Labels and Buttons in centerPane
		  GridPane.setConstraints(lblCreateAccount, 1,0);
		  GridPane.setConstraints(lblName, 0,1);
		  GridPane.setConstraints(lblCustomerPhone, 0,2);
		  GridPane.setConstraints(lblCustomerAddress, 0,3);
		  GridPane.setConstraints(lblAccountNum, 0,4);
		  GridPane.setConstraints(bronzeButton, 2, 1);
		  GridPane.setConstraints(silverButton, 2, 2);
		  GridPane.setConstraints(goldButton, 2, 3);
		  GridPane.setConstraints(rentACarButton, 2, 6);
		  GridPane.setConstraints(returnACarButton, 2, 9);

		  
		  // Set position of TextFields under Create an Account
		  TextField nameInput = new TextField();
		  nameInput.setPromptText("Name");
		  GridPane.setConstraints(nameInput,1,1);
	
		  TextField customerPhoneInput = new TextField();
		  customerPhoneInput.setPromptText("Phone Number");
		  GridPane.setConstraints(customerPhoneInput,1,2);
		  
		  TextField customerAddressInput = new TextField();
		  customerAddressInput.setPromptText("Address");
		  GridPane.setConstraints(customerAddressInput,1,3);
			
		  TextField accountInput = new TextField();
		  accountInput.setPromptText("Account Number");
		  GridPane.setConstraints(accountInput,1,4);
		  
		  // Set position of Labels and TextFields under Rent a Car
		  GridPane.setConstraints(lblRentACar,1,5);
		  GridPane.setConstraints(lblRentACarAccountNum, 0,6);
		  GridPane.setConstraints(lblRentACarVIN, 0, 7);
		  TextField txtRentACarAccountNum = new TextField();
		  TextField txtRentACarVIN = new TextField();
		  txtRentACarAccountNum.setPromptText("Account Number");
		  txtRentACarVIN.setPromptText("Car VIN");
		  GridPane.setConstraints(txtRentACarAccountNum, 1,6);
		  GridPane.setConstraints(txtRentACarVIN, 1,7);
		  
		  // Set position of Labels and TextFields under Return a Car
		  GridPane.setConstraints(lblReturnACar,1,8);
		  GridPane.setConstraints(lblReturnACarAccountNum, 0,9);
		  GridPane.setConstraints(lblReturnACarVIN,0,10);
		  TextField txtReturnACarAccountNum = new TextField();
		  TextField txtReturnACarVIN = new TextField();
		  txtReturnACarAccountNum.setPromptText("Account Number");
		  txtReturnACarVIN.setPromptText("Car VIN");
		  GridPane.setConstraints(txtReturnACarAccountNum, 1,9);
		  GridPane.setConstraints(txtReturnACarVIN, 1,10); 
	
		  
		  // Add all Labels, TextFields, and Buttons to centerPane
		  centerPane.getChildren().addAll(lblCreateAccount,lblName, nameInput, 
				  						  lblCustomerPhone, lblCustomerAddress, customerPhoneInput, customerAddressInput, lblAccountNum, accountInput, 
				  						  bronzeButton, silverButton, goldButton,rentACarButton, returnACarButton,
				  						  lblRentACar, lblRentACarAccountNum, lblRentACarVIN, lblReturnACar, lblReturnACarAccountNum,
				  						  lblReturnACarVIN, lblOutput, txtRentACarAccountNum, txtRentACarVIN, txtReturnACarAccountNum, 
				  						  txtReturnACarVIN);
		  // Set alignment to center
		  centerPane.setAlignment(Pos.CENTER);
		  

		  // Positioning for output display at bottom of application
		  VBox bottomPane = new VBox();
		  bottomPane.getChildren().addAll(lblOutput,displayOutput);
		  bottomPane.setAlignment(Pos.CENTER);
		  
		  // Set Top, Center, and Bottom Panes structured as BorderPane
		  BorderPane mainPane = new BorderPane();
		  mainPane.setTop(topPane);
		  mainPane.setCenter(centerPane);
		  mainPane.setBottom(bottomPane);
		  // Add color border
		  mainPane.setStyle("-fx-border-color: blue");

          // Exit Button action handling 
		  exitButton.setOnAction(e -> {
			  boolean result = ConfirmBox.display("Confirm", "Are you sure?");
			  if (result) {
				  window.close();
			  }
		  });
		
		  // View Rented Cars Button action handling
		  rentedCarsButton.setOnAction(e -> {
			  displayOutput.setText(displayRented());
		  });
		  
		  // View Inventory Button action handling
		  inventoryButton.setOnAction(e -> {
			  displayOutput.setText(displayCarInformation());
		  });
		  
		  // View Customer Information Button action handling
		  customerInfoButton.setOnAction(e -> {
			  displayOutput.setText(displayCustomerInformation());
		  });
		  
		  // Create Bronze Account Button action handling
		  bronzeButton.setOnAction(e -> {
			  String name = nameInput.getText();
			  String phone = customerPhoneInput.getText();
			  String address = customerAddressInput.getText();
			  String accountNum = accountInput.getText();
			  String accountType = "Bronze";
			  
			    if (nameInput.getText() == null || nameInput.getText().trim().isEmpty() || 
		  			customerPhoneInput.getText() == null || customerPhoneInput.getText().trim().isEmpty() ||
		  			customerAddressInput.getText() == null || customerAddressInput.getText().trim().isEmpty() ||
		  			accountInput.getText() == null || accountInput.getText().trim().isEmpty())  {
			  			displayOutput.setText("Please enter valid information.");
			  			}
			  		
			  		 
			  		else if (listOfAccounts.isEmpty()) {
			  			displayOutput.setText("Congratulations, a Bronze account for " + name + " has been made!");
			  			BronzeAccount newCustomer = new BronzeAccount(accountNum, new Customer(name,accountType, phone, address, accountNum));
			  			listOfAccounts.add(newCustomer);
			  			listOfAccountNumbers.add(accountNum);
			  			nameInput.clear();
			  			customerPhoneInput.clear(); 
			  			customerAddressInput.clear();
			  			accountInput.clear();
			  			}
				  
			  		else if(listOfAccountNumbers.contains(accountNum)) {
			  			displayOutput.setText("Sorry, please enter a unique customer ID.");
			  			}
				  
			  		else {
			  			displayOutput.setText("Congratulations, a Bronze account for " + name + " has been made!");
			  			BronzeAccount newCustomer = new BronzeAccount(accountNum, new Customer(name,accountType, phone, address, accountNum));
			  			listOfAccounts.add(newCustomer);
			  			listOfAccountNumbers.add(accountNum);
			  			nameInput.clear();
			  			customerPhoneInput.clear(); 
			  			customerAddressInput.clear();
			  			accountInput.clear();
						}
		  });
		  
		  // Create Silver Account Button action handling
		  silverButton.setOnAction(e -> {
			  String name = nameInput.getText();
			  String phone = customerPhoneInput.getText();
			  String address = customerAddressInput.getText();
			  String accountNum = accountInput.getText();
			  String accountType = "Silver";
			  
			    if (nameInput.getText() == null || nameInput.getText().trim().isEmpty() || 
		  			customerPhoneInput.getText() == null || customerPhoneInput.getText().trim().isEmpty() ||
		  			customerAddressInput.getText() == null || customerAddressInput.getText().trim().isEmpty() ||
		  			accountInput.getText() == null || accountInput.getText().trim().isEmpty())  {
			  			displayOutput.setText("Please enter valid information.");
			  			}
			  		
			  		 
			  		else if (listOfAccounts.isEmpty()) {
			  			displayOutput.setText("Congratulations, a Silver account for " + name + " has been made!");
			  			SilverAccount newCustomer = new SilverAccount(accountNum, new Customer(name,accountType, phone, address, accountNum));
			  			listOfAccounts.add(newCustomer);
			  			listOfAccountNumbers.add(accountNum);
			  			nameInput.clear();
			  			customerPhoneInput.clear(); 
			  			customerAddressInput.clear();
			  			accountInput.clear();
			  			}
				  
			  		else if(listOfAccountNumbers.contains(accountNum)) {
			  			displayOutput.setText("Sorry, please enter a unique customer ID.");
			  			}
				  
			  		else {
			  			displayOutput.setText("Congratulations, a Silver account for " + name + " has been made!");
			  			SilverAccount newCustomer = new SilverAccount(accountNum, new Customer(name,accountType, phone, address, accountNum));
			  			listOfAccounts.add(newCustomer);
			  			listOfAccountNumbers.add(accountNum);
			  			nameInput.clear();
			  			customerPhoneInput.clear(); 
			  			customerAddressInput.clear();
			  			accountInput.clear();
						}
		  });
		  
		  // Create Gold Account Button action handling
		  goldButton.setOnAction(e -> {
			  String name = nameInput.getText();
			  String phone = customerPhoneInput.getText();
			  String address = customerAddressInput.getText();
			  String accountNum = accountInput.getText();
			  String accountType = "Gold";
			  
			    if (nameInput.getText() == null || nameInput.getText().trim().isEmpty() || 
		  			customerPhoneInput.getText() == null || customerPhoneInput.getText().trim().isEmpty() ||
		  			customerAddressInput.getText() == null || customerAddressInput.getText().trim().isEmpty() ||
		  			accountInput.getText() == null || accountInput.getText().trim().isEmpty())  {
			  			displayOutput.setText("Please enter valid information.");
			  			}
			  		
			  		 
			  		else if (listOfAccounts.isEmpty()) {
			  			displayOutput.setText("Congratulations, a Gold account for " + name + " has been made!");
			  			GoldAccount newCustomer = new GoldAccount(accountNum, new Customer(name,accountType, phone, address, accountNum));
			  			listOfAccounts.add(newCustomer);
			  			listOfAccountNumbers.add(accountNum);
			  			nameInput.clear();
			  			customerPhoneInput.clear(); 
			  			customerAddressInput.clear();
			  			accountInput.clear();
			  			}
				  
			  		else if(listOfAccountNumbers.contains(accountNum)) {
			  			displayOutput.setText("Sorry, please enter a unique customer ID.");
			  			}
				  
			  		else {
			  			displayOutput.setText("Congratulations, a Gold account for " + name + " has been made!");
			  			GoldAccount newCustomer = new GoldAccount(accountNum, new Customer(name,accountType, phone, address, accountNum));
			  			listOfAccounts.add(newCustomer);
			  			listOfAccountNumbers.add(accountNum);
			  			nameInput.clear();
			  			customerPhoneInput.clear(); 
			  			customerAddressInput.clear();
			  			accountInput.clear();
						}
		  });
		  
		  // Rent Car Button action handling
		  rentACarButton.setOnAction (e -> {
			  String accountNum = txtRentACarAccountNum.getText();
			  String vinNum = txtRentACarVIN.getText();
			  boolean custFound = false;
			  boolean vinFound = false;
			  boolean carAvailable = false;
			  Customer tempCust = null;
			  Car tempCar = null;
			  
			  
			  if (txtRentACarAccountNum.getText() == null || txtRentACarAccountNum.getText().trim().isEmpty() || 
					  txtRentACarVIN.getText() == null || txtRentACarVIN.getText().trim().isEmpty())
				  			displayOutput.setText("Please enter valid information.");
				  			
			  else {
				  for (Account account : listOfAccounts) {
					  if (account.accountNumber.equals(accountNum)){
						  custFound = true;
						  tempCust = account.customer;
						  break;
					  }
				  }
				  
				  for (Car car : listOfCars) {
					  if (car.vin.equals(vinNum)) {
						  vinFound = true;
						  tempCar = car;
						  if (car.cust == null) {
							  carAvailable = true;
							  break;
						  }
					  }
				  }
				  
				  if (!custFound || !vinFound) {
					  displayOutput.setText("Either the customer or the vin information is incorrect.");
				  }
				  
				  if (custFound && vinFound && !carAvailable) {
					  displayOutput.setText("That car is currently being rented.");
				  }
				  
				  if (custFound && vinFound && carAvailable) {
					  if (tempCust.accountType.equals("Gold")) {
						  for (Car car : listOfCars) {
							  if (tempCar.vin.equals(car.vin)) {
								  car.addCust(tempCust);
								 
							  }
						  }
						  txtRentACarAccountNum.clear();
						  txtRentACarVIN.clear();
						  displayOutput.setText("Customer " + tempCust.name + " successfully rented the " + tempCar.make + " " + tempCar.model + ".");
					  }
					  
					  else if (tempCust.accountType.equals("Silver") && (tempCar.accountType.equals("Silver") || tempCar.accountType.equals("Bronze"))) {
						  for (Car car : listOfCars) {
							  if (tempCar.vin.equals(car.vin)) {
								  car.addCust(tempCust);
							  }
						  }
						  txtRentACarAccountNum.clear();
						  txtRentACarVIN.clear();
						  displayOutput.setText("Customer " + tempCust.name + " successfully rented the " + tempCar.make + " " + tempCar.model + ".");
					  }
					  
					  else if (tempCust.accountType.equals(tempCar.accountType)) {
						  for (Car car : listOfCars) {
							  if (tempCar.vin.equals(car.vin)) {
								  car.addCust(tempCust);
							  }
						  }
						  txtRentACarAccountNum.clear();
						  txtRentACarVIN.clear();
						  displayOutput.setText("Customer " + tempCust.name + " successfully rented the " + tempCar.make + " " + tempCar.model + ".");
					  }
					  
					  else {
						  displayOutput.setText("Customer is not eligible to rent that car.");
					  }
				  }
			  }
			  
	    });
		  
		  // Return Car Button action handling
		  returnACarButton.setOnAction (e -> {
			  String accountNum = txtReturnACarAccountNum.getText();
			  String vinNum = txtReturnACarVIN.getText();
			  boolean valid = false;
			  Customer tempCust = null;
			  Car tempCar = null;
			  int drivenMiles = 0;

			  
			  
			  if (txtReturnACarAccountNum.getText() == null || txtReturnACarAccountNum.getText().trim().isEmpty() || 
					  txtReturnACarVIN.getText() == null || txtReturnACarVIN.getText().trim().isEmpty())
				  			displayOutput.setText("Please enter valid information.");
				  			
			  else {				  
				  for (Car car : listOfCars) {
					  if (car.vin.equals(vinNum) && car.cust != null) {
						  if (car.cust.accountNum.equals(accountNum)){
							  valid = true;
							  tempCust = car.cust;
							  tempCar = car;
							  car.cust = null;
							  drivenMiles = car.addMiles();
							  break;
							  }
						  
					  }
				  }
				  
				  if (valid) {
					  txtReturnACarAccountNum.clear();
					  txtReturnACarVIN.clear();
					  displayOutput.setText(tempCust.name + " has successfully returned a " + tempCar.make + " " + tempCar.model + " after driving it " + drivenMiles + " miles.");
				  }
				  
				  if (!valid) {
					  displayOutput.setText("Either the customer or the vin was entered incorrectly.");
				  }
			  }
				  
	    });
		  
		  
		  
	return mainPane;
	} // end of mainPain()


} // end of Application