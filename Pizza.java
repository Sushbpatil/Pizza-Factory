package com.pizza.java;

import java.util.*;

public class Pizza {
	String Name = "";
	String Product = "";
	String Quantity = "";
	String Price = "";
	String Description = "";
	static String crust = "";
	static int amount = 0;
	boolean b = false;
	boolean vegie = false;
	Scanner sc = new Scanner(System.in);
	static {
		System.out.println(
				"===========================================================================================================================================================================================================================================");
		System.out.println(
				"                                                               Welcome to Pizza Factory                                                                      ");
		System.out.println(
				"===============================================================================================================================================================================================================================================");

	}

	public static void main(String[] args) {

		Menu m = new Menu();
		m.mainMenu();
		Factory f = new Factory();
		f.pizzaFactory();

	}

}

class Factory extends Pizza {
	void pizzaFactory() {
		Information m = new Information();
		m.OrderDetails();
	}

	void vegToppingsChoice() {
		Information m = new Information();
		boolean m1 = true;
		while (m1) {
			System.out.println("---------------------Do u want any sides or Extra Toppings--------------");
			System.out.println("Press 1 to add Extra Toppings");
			System.out.println("Press 2 to add side ");
			System.out.println("Press 3 to Order");
			System.out.println();
			String c3 = sc.next();
			VegToppings v = new VegToppings("", "");
			switch (c3) {
			case "1":
				v.vegToppings();
				System.out.println(m.cart);
				break;
			case "2":
				Sides sd = new Sides("", "");
				sd.sides();
				break;
			case "3":
				m1 = false;
				break;
			}
		}
	}

	void nonVegToppingsChoice() {
		Information m = new Information();
		boolean m1 = true;
		while (m1) {
			System.out.println("---------------------Do u want any sides or Extra Toppings--------------");
			System.out.println("Press 1 to add Extra Toppings");
			System.out.println("Press 2 to add side ");
			System.out.println("Press 3 to Order");
			System.out.println();
			String c3 = sc.next();
			NonVegToppings nv = new NonVegToppings("", "");
			switch (c3) {
			case "1":
				nv.nonVegToppings();
				System.out.println(m.cart);
				break;
			case "2":
				Sides sd = new Sides("", "");
				sd.sides();
				break;
			case "3":
				m1 = false;
				break;
			}
		}
	}

//	Ø New hand tossed
//	Ø Wheat thin crust
//	Ø Cheese Burst
//	Ø Fresh pan pizza
	public void Crust() {
		System.out.println();
		System.out.println("================================================================================");
		System.out.println("                                 CRUST                                     ");
		System.out.println("================================================================================");
		System.out.println();
		System.out.println("Press 1 for New hand tossed");
		System.out.println("Press 2 for Wheat thin crust ");
		System.out.println("Press 3 for Cheese Burst");
		System.out.println("Press 4 for Fresh pan pizza");
		System.out.println();
		System.out.print("Enter Your Choice ---> ");
		String choice = sc.nextLine();

		switch (choice) {
		case "1":
			crust = "New hand tossed";
			break;

		case "2":
			crust = "Wheat thin crust";
			break;
		case "3":
			crust = "Cheese Burst";
			break;

		case "4":
			crust = "Fresh pan pizza";
			break;

		default:
			System.out.println();
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("                    --------- Enter Valid Input ---------                       ");
			System.out.println("--------------------------------------------------------------------------------");
			Crust(); // Method Recursion
			break;

		}

	}
}

class Information extends Pizza {

	static ArrayList<Object> info = new ArrayList<>();
	static ArrayList<Object> cart = new ArrayList<>();

	Scanner sc = new Scanner(System.in);

	public void LoginPage() {
		System.out.println("Press 1 to Login");
		System.out.println("Press 2 to Creat New Account ");
		System.out.println("Press 3 to Exit ");
		System.out.println();
		System.out.print("Enter Your Choice ---> ");
		String choice = sc.nextLine();

		switch (choice) {
		case "1":
			Login();
			break;

		case "2":
			SignUp();
			break;

		case "3":
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("                    -----Thank You For Visiting Pizza's Factory ! -----");
			System.out.println("                    -----------> Have a Nice Day <-----------");
			System.out.println("---------------------------------------------------------------------------------");
			break;

		default:
			System.out.println();
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("                    --------- Enter Valid Input ---------                       ");
			System.out.println("--------------------------------------------------------------------------------");
			LoginPage(); // Method Recursion
			break;
		}
	}

	public void OrderDetails() {
		LoginPage();
		System.out.println("Press 1 To Continue Shopping");
		System.out.println("Press 2 To View Your Cart Items & Placing Order");
		System.out.println("Press remaining any key Exit");
		System.out.println();
		System.out.print("Enter Your Choice ---> ");
		String ex = sc.nextLine();

		switch (ex) {
		// Press 1 To Continue Shopping
		case "1":
			Menu ref = new Menu();
			ref.mainMenu();
			break;

		// Press 2 To View Your Cart Items & Placing Order
		case "2":
			ViewPlace();
			break;

		default:
			System.out.println();
			System.out.println("================================================================================");
			System.out.println("---------- Thank You " + Information.info.get(0)
					+ " For Shopping From Pizza Factory ! ----------");
			System.out.println("                ----------> Have a Nice Day <-----------");
			System.out.println("================================================================================");
			break;
		}
	}

	public void ViewPlace() {
		System.out.println();
		System.out.println("================================================================================");
		System.out.println("                                 Cart Items                                     ");
		System.out.println("================================================================================");
		System.out.println();
		for (Object obj : Information.cart) // For each loop
		{
			System.out.println(obj);
			System.out.println();
		}

		System.out.println();
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("Press 1 To Edit Cart List");
		System.out.println("Press 2 To Placed Order");
		System.out.println("Press 3 Back to Home Page");
		System.out.println();
		System.out.print("Enter Your Choice here ---> ");
		String rp = sc.nextLine();

		switch (rp) {
		// Press 1 To Edit Cart List
		case "1":
			int cartSize = Information.cart.size();

			if (cartSize == 0) {
				System.out.println();
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("                    --------- Your Cart is Empty ---------                      ");
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("Sending To Home page.......");
				Menu ref = new Menu();
				ref.mainMenu();
			} else {
				RemoveCart();
			}
			break;

		// Press 2 To Placed Order"
		case "2":
			OrderPlace();
			break;

		case "3":
			Menu ref = new Menu();
			ref.mainMenu();
			break;

		default:
			System.out.println();
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("                    --------- Enter Valid Input ---------                       ");
			System.out.println("--------------------------------------------------------------------------------");
			ViewPlace();
			break;
		}

	}
	// -------------------------------------------------------------------------------------------------------------------------------------------------

	public void RemoveCart() {

		System.out.println();
		System.out.println("================================================================================");
		System.out.println("                                Your Cart Items                                 ");
		System.out.println("================================================================================");
		for (Object obj : Information.cart) // For each loop
		{
			System.out.println(obj);
			System.out.println();
		}

		int size = Information.cart.size();
		System.out.println();
		System.out.println("Enter the Serial No of item you want to remove from list");
		System.out.println();
		System.out.print("Enter Your Choice here ---> ");

		try {
			int pk = sc.nextInt();
			int index = pk - 1;
			if (pk > 0 && pk <= size) {
				Information.cart.remove(index);

				System.out.println();
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("                --------- Item Removed SucessFully ---------                    ");
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println();
				ViewPlace();
			} else {
				System.out.println();
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("                    --------- Enter Valid Input ---------                       ");
				System.out.println("--------------------------------------------------------------------------------");
				ViewPlace();
			}
		} catch (InputMismatchException re) {
			System.out.println();
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("                    --------- Enter Valid Input ---------                       ");
			System.out.println("--------------------------------------------------------------------------------");
			ViewPlace();
		}

	}

	// -------------------------------------------------------------------------------------------------------------------------------------------------

	public void OrderPlace() {
		System.out.println();
		System.out.println("================================================================================");
		System.out.println("                         Your Order Placed Successfully                         ");
		System.out.println("================================================================================");

		System.out.println();
		System.out.println("                    ---------- Personal Details ----------");
		System.out.println();
		Information.AllDetails();
		System.out.println();
		System.out.println("Payment Method: COD");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("                        ---------- Order List ----------");
		System.out.println();
		for (Object obj : Information.cart) // For each loop
		{
			System.out.println(obj);
			System.out.println();
		}

		System.out.println();
		System.out.println("Type of Crust: " + crust);
		System.out.println("Total Amount: Rs" + amount);
		System.out.println();
		System.out.println("================================================================================");
		System.out.println();
		System.out.println("Press 1 To Continue Shopping");
		System.out.println("Press remaining any key Exit");
		System.out.print("Enter Your Choice ---> ");
		String ex1 = sc.nextLine();

		switch (ex1) {
		case "1":
			Menu ref = new Menu();
			ref.mainMenu();
			break;

		default:
			System.out.println();
			System.out.println("================================================================================");
			System.out.println("---------- Thank You " + Information.info.get(0)
					+ " For Shopping From Pizza Factory ! ----------");
			System.out.println("                ----------> Have a Nice Day <-----------");
			System.out.println("================================================================================");
			break;
		}

	}

	public void Login() {
		String mobile;
		String password;
		String smobile = "7821044993";
		String spassword = "Sushant@123";
		System.out.println(
				"===========================================================================================================================================================================================================================================");
		System.out.println(
				"                                                                Login Page                                                                       ");
		System.out.println(
				"===============================================================================================================================================================================================================================================");

		System.out.print("Enter Your Mobile Number ---> ");
		mobile = sc.nextLine();
		System.out.print("Enter Your Password --------> ");
		password = sc.nextLine();

		if (mobile.equals(smobile) && password.equals(spassword)) {
			info.add(0, "Sushant");
			info.add(1, "7821044993");
			info.add(2, "sushant123@gmail.com");
			info.add(3, "Thane");
		}

		else {
			System.out.println();
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("!! Invalid Mobile Number Or Password !!");
			System.out.println("---------------------------------------------------------------------------------");
			LoginPage();
		}

	}

	public static void AllDetails() {
		System.out.println("* Name ------------> " + info.get(0));
		System.out.println("* Mobile Number ---> " + info.get(1));
		System.out.println("* Email -----------> " + info.get(2));
		System.out.println("* Address ---------> " + info.get(3));
	}

	public void SignUp() {
		Uname();
	}

	String userName;
	long mobileNumber;
	String email;
	String address;

	public void Uname() {
		System.out.println(
				"===========================================================================================================================================================================================================================================");
		System.out.println(
				"                                                              Sign Up Page                                                                          ");
		System.out.println(
				"===============================================================================================================================================================================================================================================");

		System.out.print("Kindly Enter your Name ---> ");
		String userName = sc.nextLine();
		info.add(0, userName);

		nameSwitch(); // Calling nameSwitch method
	}

	public void nameSwitch() {

		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println();
		System.out.print("Hello... " + info.get(0));
		System.out.println();
		System.out.print("To Continue Press 1, To Edit Name Press 2 ---> ");
		String value0 = sc.nextLine();

		switch (value0) {
		case "1":
			mobileNum();// call phone number method
			break;

		case "2":
			info.clear();
			Uname(); // Calling Uname method to rename
			break;

		default:
			System.out.println();
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("                    --------- Enter Valid Input ---------                       ");
			System.out.println("--------------------------------------------------------------------------------");
			nameSwitch();
			break;
		}
	}

	public void mobileNum() {
		System.out.println();
		System.out.println("================================================================================");
		System.out.println();
		System.out.print("Enter Your 10 digit Mobile Number ---> ");

//===========================================================================================================================
		// Exception Handling
		@SuppressWarnings("resource")
		Scanner ref = new Scanner(System.in);
		try {
			mobileNumber = ref.nextLong();
			info.add(1, mobileNumber);

//===========================================================================================================================		

			if (mobileNumber > 1000000000 && mobileNumber < 9999999999L) {

				mobileSwitch();// call mobileSwitch method
			}

			else {
				System.out.println();
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println("                    --------- Enter Valid Input ---------                       ");
				System.out.println("--------------------------------------------------------------------------------");
				System.out.println();
				mobileNum();
			}
		} catch (InputMismatchException ref1) {
			System.out.println("Mobile Number Should Contains Numbers only");
			mobileNum();
		}
	}

	public void mobileSwitch() {

		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println();
		System.out.print("Your Enter Mobile Number is :- " + info.get(1) + ".");
		System.out.println();
		System.out.print("To continue Press 1 Or to Edit Mobile Number Press 2 ---> ");
		String value1 = sc.nextLine();

		switch (value1) {
		case "1":
			Email();// Main Menu method
			break;

		case "2":
			info.remove(1);
			mobileNum(); // Calling Uname method to rename
			break;

		default:
			System.out.println();
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("                    --------- Enter Valid Input ---------                       ");
			System.out.println("--------------------------------------------------------------------------------");
			mobileSwitch(); // Method Recursion
			break;
		}
	}

	public void Email() {
		System.out.println();
		System.out.println("================================================================================");
		System.out.println();
		System.out.print("Kindly Enter your Email ID --> ");
		String email = sc.nextLine();
		info.add(2, email);

		emailSwitch(); // Calling emailSwitch method
	}

	public void emailSwitch() {

		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println();
		System.out.print("Your Entered Email Id is:- " + info.get(2));
		System.out.println();
		System.out.print("To Continue Press 1, To Edit Email Press 2 ---> ");
		String value2 = sc.nextLine();

		switch (value2) {
		case "1":
			Address();// address method
			break;

		case "2":
			info.remove(2);
			Email(); // Calling Email method to rename
			break;

		default:
			System.out.println();
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("                    --------- Enter Valid Input ---------                       ");
			System.out.println("--------------------------------------------------------------------------------");
			emailSwitch();
			break;
		}
	}

	public void Address() {
		System.out.println();
		System.out.println(
				"===============================================================================================================================================================================================================================================");
		System.out.println();
		System.out.print("Kindly Enter your Address ---> ");
		String address = sc.nextLine();
		info.add(3, address);

		addressSwitch(); // Calling emailSwitch method
	}

	public void addressSwitch() {

		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println();
		System.out.print("Your Entered Address is:- " + info.get(3));
		System.out.println();
		System.out.print("To Continue Press 1, To Edit Address Press 2 ---> ");
		String value3 = sc.nextLine();

		switch (value3) {
		case "1":
			System.out.println();
			System.out.println("================================================================================");
			System.out.println();
			System.out.println("******** Your Account Created Sucessfully ********");
			break;

		case "2":
			info.remove(3);
			Address(); // Calling Email method to rename
			break;

		default:
			System.out.println();
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("                    --------- Enter Valid Input ---------                       ");
			System.out.println("--------------------------------------------------------------------------------");
			addressSwitch();
			break;
		}
	}
}

class Menu extends Pizza {
	public void mainMenu() {
		sc = new Scanner(System.in);
		System.out.println(
				"===========================================================================================================================================================================================================================================");
		System.out.println(
				"                                                              Main Menu                                                                          ");
		System.out.println(
				"===============================================================================================================================================================================================================================================");

		System.out.println("Enter 1 For Veg Pizza");
		System.out.println("Enter 2 for Non-Veg Pizza");
		System.out.println();

		System.out.print("Enter Your Choice ==>");
		String a = sc.next();
		System.out.println("=================================================");

		switch (a) {
		case "1":
			VegPizza v = new VegPizza();
			v.vegPizza();
			break;

		case "2":
			NonVegPizza nv = new NonVegPizza();
			nv.nonVegPizza();
			break;

		default:
			System.out.println();
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			System.out.println("Enter Valid Input");
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			mainMenu();
			break;

		}

	}

	public String toString() {
		System.out.println("=================================================");
		System.out.println("Menu :");
		System.out.println("Quantity : ");
		System.out.println("Price : ");
		System.out.println("Description : ");
		System.out.println("=================================================");
		return "";
	}

}

class VegPizza extends Pizza {

//	Ø Deluxe Veggie: (Regular: Rs. 150 Medium: Rs. 200 Large: Rs. 325)
//	Ø Cheese and corn: (Regular: Rs. 175 Medium: Rs. 375 Large: Rs. 475)
//	Ø Paneer Tikka: (Regular: Rs. 160 Medium: Rs. 290 Large: Rs. 340)

	void vegPizza() {
		vegie = true;
		System.out.println("");
		System.out.println("");
		System.out.println(
				"===========================================================================================================================================================================================================================================");
		System.out.println(
				"                                                                       Veg Menu                                                                           ");
		System.out.println(
				"===============================================================================================================================================================================================================================================");
		System.out.println("Press 1 For Deluxe Veggie");
		System.out.println("Press 2 For Cheese and corn");
		System.out.println("Press 3 For Paneer Tikka");
		System.out.println(" ");
		DulexVeg DV = new DulexVeg("", "", "");
		PaneerTikka PT = new PaneerTikka("", "", "");
		Cheese_And_Corn CC = new Cheese_And_Corn("", "", "");

		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter Number : ");
		sc = new Scanner(System.in);

		String c2 = sc.next();
		switch (c2) {
		case "1":
			DV.dulexVegPizza();
			break;
		case "2":
			PT.paneerTikka();
			break;
		case "3":
			CC.cheeseAcorn();
			break;

		default:
			System.out.println("");

			System.out.println("");
			System.out.println(
					"**********************************************************************************************************************************************************************************************************************************");
			System.out.println(
					"                                                !!!!!!Enter Valid Input!!!!!!                                   ");
			System.out.println(
					"**************************************************************************************************************************************************************************************************************************************");

			break;
		}
		Factory f = new Factory();
		f.Crust();
		f.vegToppingsChoice();

	}

}

class DulexVeg extends VegPizza {
	DulexVeg(String Product, String Quantity, String Price) {
		this.Product = Product;
		this.Quantity = Quantity;
		this.Price = Price;
	}

	public void dulexVegPizza() {
		sc = new Scanner(System.in);
		System.out.println("Dulex-VEG PIZZA ");
		System.out.println();
		System.out.println("Enter 1 For Regular");
		DulexVeg DVregular = new DulexVeg("Dulex-VEG PIZZA", "Regular", "Rs 150/-");
		System.out.println(DVregular);
		System.out.println();
		System.out.println("Enter 2 For Medium");
		DulexVeg DVmedium = new DulexVeg("Dulex-VEG PIZZA", "Medium", "Rs 200/-");
		System.out.println(DVmedium);
		System.out.println();
		System.out.println("Enter 3 For Large");
		DulexVeg DVlarge = new DulexVeg("Dulex-VEG PIZZA", "Large", "Rs 325/-");
		System.out.println(DVlarge);
		b = true;
		System.out.println();
		System.out.print("Enter Your Choice ==> ");
		String n = sc.next();

		System.out.println("=================================================");

		switch (n) {

		case "1":
			String g = "Dulex-VEG PIZZA" + " Regular" + " Rs.150/-";
			Information.cart.add(g);
			amount = amount + 150;
			break;

		case "2":
			String f = "Dulex-VEG PIZZA" + " Medium" + " Rs.200/-";
			Information.cart.add(f);
			amount = amount + 200;
			break;
		case "3":
			String e = "Dulex-VEG PIZZA" + " Large" + " Rs 325/-";
			Information.cart.add(e);
			amount = amount + 325;

			break;

		default:
			System.out.println();
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			System.out.println("Enter Valid Input");
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			dulexVegPizza();
			break;

		}

	}

	public String toString() {
		System.out.println("=================================================");
		System.out.println("Name :" + Product);
		System.out.println("Quantity : " + Quantity);
		System.out.println("Price : " + Price);
		System.out.println("=================================================");
		return "";
	}

}

class Cheese_And_Corn extends VegPizza {
	Cheese_And_Corn(String Product, String Quantity, String Price) {
		this.Product = Product;
		this.Quantity = Quantity;
		this.Price = Price;
	}

	public void cheeseAcorn() {
		sc = new Scanner(System.in);
		System.out.println("Cheese and corn");
		System.out.println();
		System.out.println("Enter 1 For Regular");
		Cheese_And_Corn CCregular = new Cheese_And_Corn("Cheese and corn", "Regular", "Rs 175/-");
		System.out.println(CCregular);
		System.out.println();
		System.out.println("Enter 2 For Medium");
		Cheese_And_Corn CCmedium = new Cheese_And_Corn("Cheese and corn", "Medium", "Rs 375/-");
		System.out.println(CCmedium);
		System.out.println();
		System.out.println("Enter 3 For Large");
		Cheese_And_Corn CClarge = new Cheese_And_Corn("Cheese and corn", "Large", "Rs 475/-");
		System.out.println(CClarge);
		b = true;
		System.out.println();
		System.out.print("Enter Your Choice ==> ");
		String n = sc.next();

		System.out.println("=================================================");

		switch (n) {

		case "1":
			String g = "Cheese and corn" + " Regular" + " Rs.175/-";
			Information.cart.add(g);
			amount = amount + 175;
			break;

		case "2":
			String f = "Cheese and corn" + " Medium" + " Rs.275/-";
			Information.cart.add(f);
			amount = amount + 275;
			break;
		case "3":
			String e = "Cheese and corn" + " Large" + " Rs 375/-";
			Information.cart.add(e);
			amount = amount + 375;

			break;

		default:
			System.out.println();
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			System.out.println("Enter Valid Input");
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			cheeseAcorn();
			break;

		}

	}

	public String toString() {
		System.out.println("=================================================");
		System.out.println("Name :" + Product);
		System.out.println("Quantity : " + Quantity);
		System.out.println("Price : " + Price);
		System.out.println("=================================================");
		return "";
	}

}
//Ø Paneer Tikka: (Regular: Rs. 160 Medium: Rs. 290 Large: Rs. 340)

class PaneerTikka extends VegPizza {
	PaneerTikka(String Product, String Quantity, String Price) {
		this.Product = Product;
		this.Quantity = Quantity;
		this.Price = Price;
	}

	public void paneerTikka() {
		sc = new Scanner(System.in);
		System.out.println("Paneer Tikka");
		System.out.println();
		System.out.println("Enter 1 For Regular");
		PaneerTikka PTregular = new PaneerTikka("Paneer Tikka", "Regular", "Rs 160/-");
		System.out.println(PTregular);
		System.out.println();
		System.out.println("Enter 2 For Medium");
		PaneerTikka PTmedium = new PaneerTikka("Paneer Tikka", "Medium", "Rs 290/-");
		System.out.println(PTmedium);
		System.out.println();
		System.out.println("Enter 3 For Large");
		PaneerTikka PTlarge = new PaneerTikka("Paneer Tikka", "Large", "Rs 340/-");
		System.out.println(PTlarge);
		b = true;
		System.out.println();
		System.out.print("Enter Your Choice ==> ");
		String n = sc.next();

		System.out.println("=================================================");

		switch (n) {

		case "1":
			String g = "Paneer Tikka" + " Regular" + " Rs.160/-";
			Information.cart.add(g);
			amount = amount + 160;
			break;

		case "2":
			String f = "Paneer Tikka" + " Medium" + " Rs.290/-";
			Information.cart.add(f);
			amount = amount + 290;
			break;
		case "3":
			String e = "Paneer Tikka" + " Large" + " Rs 340/-";
			Information.cart.add(e);
			amount = amount + 340;

			break;

		default:
			System.out.println();
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			System.out.println("Enter Valid Input");
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			paneerTikka();
			break;
		}
	}

	public String toString() {
		System.out.println("=================================================");
		System.out.println("Name :" + Product);
		System.out.println("Quantity : " + Quantity);
		System.out.println("Price : " + Price);
		System.out.println("=================================================");
		return "";
	}

}

class NonVegPizza extends Pizza {

//	Ø Non-Veg Supreme: (Regular: Rs 190 Medium: Rs 325 Large: Rs 425)
//	Ø Chicken Tikka: (Regular: Rs 210 Medium: Rs 370 Large: Rs 500)
//	Ø Pepper Barbecue Chicken (Regular: Rs 220 Medium: Rs 380 Large: Rs 525)

	public void nonVegPizza() {
		System.out.println("");
		System.out.println("");
		System.out.println(
				"===========================================================================================================================================================================================================================================");
		System.out.println(
				"                                                                    Non-Veg Menu                                                                        ");
		System.out.println(
				"===============================================================================================================================================================================================================================================");
		System.out.println("Press 1 For Non-Veg Supreme");
		System.out.println("Press 2 For Chicken Tikka");
		System.out.println("Press 3 For Pepper Barbecue Chicken");
		System.out.println(" ");
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.print("Enter Number : ");
		// Scanner class
		sc = new Scanner(System.in);
		NonVegSupreme nv = new NonVegSupreme("", "", "");
		ChickenTikka ct = new ChickenTikka("", "", "");
		PepperBarbecueChicken pbc = new PepperBarbecueChicken("", "", "");
		String c2 = sc.next();
		switch (c2) {
		case "1":
			nv.nonVegSupreme();
			break;
		case "2":
			ct.chickenTikka();
			break;
		case "3":
			pbc.pepperBarbecueChicken();
			break;

		default:
			System.out.println("");

			System.out.println("");
			System.out.println(
					"**********************************************************************************************************************************************************************************************************************************");
			System.out.println(
					"                                                !!!!!!Enter Valid Input!!!!!!                                   ");
			System.out.println(
					"**************************************************************************************************************************************************************************************************************************************");
			nonVegPizza();
			break;

		}
		Factory f = new Factory();
		f.Crust();
		f.nonVegToppingsChoice();

	}

}

//Ø Non-Veg Supreme: (Regular: Rs 190 Medium: Rs 325 Large: Rs 425)
class NonVegSupreme extends NonVegPizza {
	NonVegSupreme(String Product, String Quantity, String Price) {
		this.Product = Product;
		this.Quantity = Quantity;
		this.Price = Price;
	}

	public void nonVegSupreme() {
		sc = new Scanner(System.in);
		System.out.println("Non-Veg Supreme");
		System.out.println();
		System.out.println("Enter 1 For Regular");
		NonVegSupreme NVregular = new NonVegSupreme("Non-Veg Supreme", "Regular", "Rs 190/-");
		System.out.println(NVregular);
		System.out.println();
		System.out.println("Enter 2 For Medium");
		NonVegSupreme NVmedium = new NonVegSupreme("Non-Veg Supreme", "Medium", "Rs 325/-");
		System.out.println(NVmedium);
		System.out.println();
		System.out.println("Enter 3 For Large");
		NonVegSupreme NVlarge = new NonVegSupreme("Non-Veg Supreme", "Large", "Rs 425/-");
		System.out.println(NVlarge);
		b = true;
		System.out.println();
		System.out.print("Enter Your Choice ==> ");
		String n = sc.next();

		System.out.println("=================================================");

		switch (n) {

		case "1":
			String g = "Non-Veg Supreme" + " Regular" + " Rs.160/-";
			Information.cart.add(g);
			amount = amount + 160;
			break;

		case "2":
			String f = "Non-Veg Supreme" + " Medium" + " Rs.290/-";
			Information.cart.add(f);
			amount = amount + 290;
			break;
		case "3":
			String e = "Non-Veg Supreme" + " Large" + " Rs 340/-";
			Information.cart.add(e);
			amount = amount + 340;

			break;

		default:
			System.out.println();
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			System.out.println("Enter Valid Input");
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			nonVegSupreme();
			break;
		}
	}

	public String toString() {
		System.out.println("=================================================");
		System.out.println("Name :" + Product);
		System.out.println("Quantity : " + Quantity);
		System.out.println("Price : " + Price);
		System.out.println("=================================================");
		return "";
	}

}
//Ø Chicken Tikka: (Regular: Rs 210 Medium: Rs 370 Large: Rs 500)

class ChickenTikka extends NonVegPizza {
	ChickenTikka(String Product, String Quantity, String Price) {
		this.Product = Product;
		this.Quantity = Quantity;
		this.Price = Price;
	}

	public void chickenTikka() {
		sc = new Scanner(System.in);
		System.out.println("Chicken Tikka");
		System.out.println();
		System.out.println("Enter 1 For Regular");
		ChickenTikka CTregular = new ChickenTikka("Chicken Tikka", "Regular", "Rs 210/-");
		System.out.println(CTregular);
		System.out.println();
		System.out.println("Enter 2 For Medium");
		ChickenTikka CTmedium = new ChickenTikka("Chicken Tikka", "Medium", "Rs 370/-");
		System.out.println(CTmedium);
		System.out.println();
		System.out.println("Enter 3 For Large");
		ChickenTikka CTlarge = new ChickenTikka("Chicken Tikka", "Large", "Rs 500/-");
		System.out.println(CTlarge);
		b = true;
		System.out.println();
		System.out.print("Enter Your Choice ==> ");
		String n = sc.next();

		System.out.println("=================================================");

		switch (n) {

		case "1":
			String g = "Chicken Tikka" + " Regular" + " Rs.210/-";
			Information.cart.add(g);
			amount = amount + 210;
			break;

		case "2":
			String f = "Chicken Tikka" + " Medium" + " Rs.370/-";
			Information.cart.add(f);
			amount = amount + 370;
			break;
		case "3":
			String e = "Chicken Tikka" + " Large" + " Rs 500/-";
			Information.cart.add(e);
			amount = amount + 500;

			break;

		default:
			System.out.println();
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			System.out.println("Enter Valid Input");
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			chickenTikka();
			break;
		}
	}

	public String toString() {
		System.out.println("=================================================");
		System.out.println("Name :" + Product);
		System.out.println("Quantity : " + Quantity);
		System.out.println("Price : " + Price);
		System.out.println("=================================================");
		return "";
	}

}

//Ø Pepper Barbecue Chicken (Regular: Rs 220 Medium: Rs 380 Large: Rs 525)
class PepperBarbecueChicken extends NonVegPizza {
	PepperBarbecueChicken(String Product, String Quantity, String Price) {
		this.Product = Product;
		this.Quantity = Quantity;
		this.Price = Price;
	}

	public void pepperBarbecueChicken() {
		sc = new Scanner(System.in);
		System.out.println("Chicken Tikka");
		System.out.println();
		System.out.println("Enter 1 For Regular");
		PepperBarbecueChicken PBCregular = new PepperBarbecueChicken("Pepper Barbecue Chicken", "Regular", "Rs 220/-");
		System.out.println(PBCregular);
		System.out.println();
		System.out.println("Enter 2 For Medium");
		PepperBarbecueChicken PBCmedium = new PepperBarbecueChicken("Pepper Barbecue Chicken", "Medium", "Rs 380/-");
		System.out.println(PBCmedium);
		System.out.println();
		System.out.println("Enter 3 For Large");
		PepperBarbecueChicken PBClarge = new PepperBarbecueChicken("Pepper Barbecue Chicken", "Large", "Rs 525/-");
		System.out.println(PBClarge);
		b = true;
		System.out.println();
		System.out.print("Enter Your Choice ==> ");
		String n = sc.next();

		System.out.println("=================================================");

		switch (n) {

		case "1":
			String g = "Pepper Barbecue Chicken" + " Regular" + " Rs.220/-";
			Information.cart.add(g);
			amount = amount + 220;
			break;

		case "2":
			String f = "Pepper Barbecue Chicken" + " Medium" + " Rs.380/-";
			Information.cart.add(f);
			amount = amount + 380;
			break;
		case "3":
			String e = "Pepper Barbecue Chicken" + " Large" + " Rs 525/-";
			Information.cart.add(e);
			amount = amount + 525;

			break;

		default:
			System.out.println();
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			System.out.println("Enter Valid Input");
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			pepperBarbecueChicken();
			break;
		}
	}

	public String toString() {
		System.out.println("=================================================");
		System.out.println("Name :" + Product);
		System.out.println("Quantity : " + Quantity);
		System.out.println("Price : " + Price);
		System.out.println("=================================================");
		return "";
	}
}
//
//Extra toppings:
//Veg toppings:
//Ø Black olive (Rs 20)
//Ø Capsicum (Rs 25)
//Ø Paneer (Rs 35)
//Ø Mushroom (Rs 30)
//Ø Fresh tomato (Rs 10)
//Non-Veg toppings:
//Ø Chicken tikka (Rs 35)
//Ø Barbeque chicken (Rs 45)
//Ø Grilled chicken (Rs 40)
//Extra cheese: (Rs 35)
//Sides:
//Ø Cold drink (Rs 55)
//Ø Mousse cake (Rs. 90)

class Toppings extends Pizza {
	public void toppings() {
		sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("");
		System.out.println(
				"===========================================================================================================================================================================================================================================");
		System.out.println(
				"                                                               Extra Toppings                                                                       ");
		System.out.println(
				"===============================================================================================================================================================================================================================================");
		System.out.println("Enter 1 For Veg toppings");
		System.out.println("Enter 2 For Non-Veg toppings");
		System.out.print("Enter Your Choice ==> ");
		String n = sc.next();
		System.out.println("=================================================");

		switch (n) {

		case "1":

			break;

		case "2":

			break;

		default:
			System.out.println();
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			System.out.println("Enter Valid Input");
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			toppings();
			break;
		}
	}
}

//Veg toppings:
//Ø Black olive (Rs 20)
//Ø Capsicum (Rs 25)
//Ø Paneer (Rs 35)
//Ø Mushroom (Rs 30)
//Ø Fresh tomato (Rs 10)
class VegToppings extends Toppings {
	public VegToppings(String Name, String Price) {
		this.Name = Name;
		this.Price = Price;
	}

	public void vegToppings() {
		sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("");
		System.out.println(
				"===========================================================================================================================================================================================================================================");
		System.out.println(
				"                                                                  SIDES                                                                       ");
		System.out.println(
				"===============================================================================================================================================================================================================================================");
		System.out.println("Enter 1 For Black olive ");
		VegToppings BO = new VegToppings("Black olive ", "Rs 20/-");
		System.out.println(BO);
		System.out.println();
		System.out.println("Enter 2 For Capsicum");
		VegToppings Cap = new VegToppings("Capsicum", "Rs 25/-");
		System.out.println(Cap);
		System.out.println("Enter 3 For Paneer");
		VegToppings pa = new VegToppings("Paneer", "Rs 35/-");
		System.out.println(pa);
		System.out.println();
		System.out.println("Enter 4 For Mushroom");
		VegToppings MC = new VegToppings("Mushroom", "Rs 30/-");
		System.out.println(MC);
		System.out.println("Enter 5 For Fresh Tomato");
		VegToppings T = new VegToppings("Fresh Tomato", "Rs 10/-");
		System.out.println(T);
		System.out.println();
		System.out.println();
		System.out.print("Enter Your Choice ==> ");
		String n = sc.next();

		System.out.println(
				"===============================================================================================================================================================================================================================================");

		switch (n) {

		case "1":
			String g = "Black olive" + " Rs.20/-";
			Information.cart.add(g);
			amount = amount + 20;
			break;

		case "2":
			String f = "Capsicum" + " Rs.25/-";
			Information.cart.add(f);
			amount = amount + 25;
			break;
		case "3":
			String h = "Paneer" + " Rs.35/-";
			Information.cart.add(h);
			amount = amount + 35;
			break;

		case "4":
			String s = "Mushroom" + " Rs.30/-";
			Information.cart.add(s);
			amount = amount + 30;
			break;
		case "5":
			String o = "Fresh Tomato" + " Rs.10/-";
			Information.cart.add(o);
			amount = amount + 10;
			break;

		default:
			System.out.println();
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			System.out.println("Enter Valid Input");
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			vegToppings();
			break;
		}
	}

	public String toString() {
		System.out.println("=================================================");
		System.out.println("Name :" + Product);
		System.out.println("Price : " + Price);
		System.out.println("=================================================");
		return "";
	}
}

//Non-Veg toppings:
//Ø Chicken tikka (Rs 35)
//Ø Barbeque chicken (Rs 45)
//Ø Grilled chicken (Rs 40)
class NonVegToppings extends Toppings {
	public NonVegToppings(String Name, String Price) {
		this.Name = Name;
		this.Price = Price;
	}

	public void nonVegToppings() {
		vegie = false;
		sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("");
		System.out.println(
				"===========================================================================================================================================================================================================================================");
		System.out.println(
				"                                                                  SIDES                                                                       ");
		System.out.println(
				"===============================================================================================================================================================================================================================================");
		System.out.println("Enter 1 For Chicken tikka ");
		NonVegToppings CT = new NonVegToppings("Chicken tikka", "Rs 35/-");
		System.out.println(CT);
		System.out.println();
		System.out.println("Enter 2 For Barbeque chicken");
		NonVegToppings Cap = new NonVegToppings("Barbeque chicken", "Rs 45/-");
		System.out.println(Cap);
		System.out.println("Enter 3 For Grilled chicken");
		NonVegToppings pa = new NonVegToppings("Grilled chicken", "Rs 40/-");
		System.out.println(pa);
		System.out.println("Enter  4 For Black olive ");
		VegToppings BO = new VegToppings("Black olive ", "Rs 20/-");
		System.out.println(BO);
		System.out.println();
		System.out.println("Enter 5 For Capsicum");
		VegToppings Ca = new VegToppings("Capsicum", "Rs 25/-");
		System.out.println(Ca);
		System.out.println();
		System.out.println("Enter 6 For Mushroom");
		VegToppings MC = new VegToppings("Mushroom", "Rs 30/-");
		System.out.println(MC);
		System.out.println("Enter 7 For Fresh Tomato");
		VegToppings T = new VegToppings("Fresh Tomato", "Rs 10/-");
		System.out.println(T);
		System.out.println();
		System.out.println();
		System.out.print("Enter Your Choice ==> ");
		String n = sc.next();

		System.out.println(
				"===============================================================================================================================================================================================================================================");

		switch (n) {

		case "1":
			String g = "Chicken tikka" + " Rs.35/-";
			Information.cart.add(g);
			amount = amount + 35;
			break;

		case "2":
			String f = "Barbeque chicken" + " Rs.45/-";
			Information.cart.add(f);
			amount = amount + 45;
			break;
		case "3":
			String h = "Grilled chicken" + " Rs.40/-";
			Information.cart.add(h);
			amount = amount + 40;
			break;

		case "4":
			String q = "Black olive" + " Rs.20/-";
			Information.cart.add(q);
			amount = amount + 20;
			break;

		case "5":
			String i = "Capsicum" + " Rs.25/-";
			Information.cart.add(i);
			amount = amount + 25;
			break;
		case "6":
			String s = "Mushroom" + " Rs.30/-";
			Information.cart.add(s);
			amount = amount + 30;
			break;
		case "7":
			String o = "Fresh Tomato" + " Rs.10/-";
			Information.cart.add(o);
			amount = amount + 10;
			break;
		default:
			System.out.println();
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			System.out.println("Enter Valid Input");
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			nonVegToppings();
			break;
		}
	}

	public String toString() {
		System.out.println("=================================================");
		System.out.println("Name :" + Product);
		System.out.println("Price : " + Price);
		System.out.println("=================================================");
		return "";
	}
}

//Ø Cold drink (Rs 55)
//Ø Mousse cake (Rs. 90)
class Sides extends Pizza {
	public Sides(String Name, String Price) {
		this.Name = Name;
		this.Price = Price;
	}

	public void sides() {
		sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("");
		System.out.println(
				"===========================================================================================================================================================================================================================================");
		System.out.println(
				"                                                                  SIDES                                                                       ");
		System.out.println(
				"===============================================================================================================================================================================================================================================");
		System.out.println("Enter 1 For Cold drink");
		Sides CD = new Sides("Cold drink", "Rs 55/-");
		System.out.println(CD);
		System.out.println();
		System.out.println("Enter 2 For Mousse cake");
		Sides MC = new Sides("Mousse cake", "Rs 90/-");
		System.out.println(MC);
		System.out.println();
		System.out.println();
		System.out.print("Enter Your Choice ==> ");
		String n = sc.next();

		System.out.println(
				"===============================================================================================================================================================================================================================================");

		switch (n) {

		case "1":
			String g = "Cold drink" + " Rs.55/-";
			Information.cart.add(g);
			amount = amount + 55;
			break;

		case "2":
			String f = "Mousse cake" + " Rs.90/-";
			Information.cart.add(f);
			amount = amount + 90;
			break;

		default:
			System.out.println();
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			System.out.println("Enter Valid Input");
			System.out.println(
					"===============================================================================================================================================================================================================================================");
			sides();
			break;
		}
	}

	public String toString() {
		System.out.println("=================================================");
		System.out.println("Name :" + Product);
		System.out.println("Price : " + Price);
		System.out.println("=================================================");
		return "";
	}

}
