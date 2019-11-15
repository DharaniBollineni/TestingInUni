import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdatedTaxCalculation {

	private static ArrayList<MyTax> myTaxList = new ArrayList<>();
	private Scanner reader = new Scanner(System.in);
	private String line = "";
	
	public UpdatedTaxCalculation()
	{
		while(true) {
			
			System.out.println("1 for Add  2 for Display)");
			line = reader.nextLine();
			
			if(line.equalsIgnoreCase("1")) {
				addDetails();
			}
			
			else if(line.equalsIgnoreCase("2")) {
				display();
			}
			
		}
	}
	
	public static void addDetails()
	{
		Scanner reader = new Scanner(System.in); // Scanner object for keyboard input
		String status;
		double income = 0;
		double tax1;
		double tax2;
		double tax3;
		double tax4;
		double tax5;
		double tax6;
		final double tax_one = .10;
		final double tax_two = .15;
		final double tax_three = .25;
		final double tax_four = .15;
		final double tax_five = .25;
		double deduction;

		while (true) {
			System.out.print("Enter your filing status (1 for Single, 2 for Jointly)\n>");
			status = reader.nextLine();

			// Check the valid status

			if (status.equals("1") || status.equals("2")) {
				break;
			} else {
				System.out.println("Invalid input. Please try again.");
				System.out.println("DEBUG: status = " + status);
			}
		}

//		boolean error=true;
//
//		do {
//			try {
//				System.out.print("Enter your yearly income without comma or $ sign\n>");
//				income=reader.nextDouble();
//				reader.nextLine(); // skip the enter
//				error= false;
//				
//				
//			}catch(InputMismatchException e)
//			{
//				// accept integer only.
//				System.out.println("Invalid Input..Pls Input double value Only..");
//				error=true;
//			}
//		}
//		while(error);		
		
//		error=true;
//		while (true) {
		System.out.print("Enter your yearly income without comma or $ sign\n>");
//		try {
			income = reader.nextInt();
			reader.nextLine(); // skip the enter
//			break;
//		} catch (Exception e) {
//			System.out.print("Please enter valied input ");
//			break;
//		}
//	}
		
		
//		while (true) {
			System.out.print("Enter double deduction without comma or $ sign\n>");
//			try {
				deduction = reader.nextInt();
				reader.nextLine(); // skip the enter
//				break;
//			} catch (Exception e) {
//				System.out.print("Please enter valied input ");
//			}
//
//		}

		double TaxIncome = income - deduction;
		System.out.println("Your taxable income is $" + income + " - $" + deduction + " = $" + TaxIncome);

		// if this is single
		if (status.equals("1")) {
			tax4 = (tax_one * income);
			tax5 = (tax_four * income) + 1600;
			tax6 = (tax_five * income) + 8800;
			if (income >= 0 && income < 16000) {
				System.out.println("The amount of taxes you must pay is " + tax4);
				addToList(deduction, income, tax_one, tax4);
			} else if (income >= 16000 && income < 64000) {
				System.out.println("The amount of taxes you must pay is " + tax5);
				addToList(deduction, income, tax_four, tax5);
			} else if (income >= 64000) {
				System.out.println("The amount of taxes you must pay is " + tax6);
				addToList(deduction, income, tax_five, tax6);
			}

		}
		// if this is Jointly
		else if (status.equals("2")) {
			tax4 = (tax_one * income);
			tax5 = (tax_four * income) + 2600;
			tax6 = (tax_five * income) + 9999;
			if (income >= 0 && income < 16000) {
				System.out.println("The amount of taxes you must pay is " + tax4);
				addToList(deduction, income, tax_one, tax4);
			} else if (income >= 16000 && income < 94000) {
				System.out.println("The amount of taxes you must pay is " + tax5);
				addToList(deduction, income, tax_four, tax5);
			} else if (income >= 94000) {
				System.out.println("The amount of taxes you must pay is " + tax6);
				addToList(deduction, income, tax_five, tax6);
			}

		}

	}
	
	public static void addToList(double deduction, double income, double tax_Percentage, double totalTax)
	{
		MyTax detail = new MyTax(deduction, income, tax_Percentage, totalTax);
		myTaxList.add(detail);
	}
	
	public static void display()
	{
		System.out.println("Tax recods");
		
		for(MyTax record : myTaxList) {
			System.out.println(record.getDeduction()+" "+record.getIncome()+" "+record.getTax_Percentage()+" "+record.getTotalTax());
			
		}
		
	}
	
}
