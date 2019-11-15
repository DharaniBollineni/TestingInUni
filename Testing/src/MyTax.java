
public class MyTax {
	
	private double deduction; 
	private double income; 
	private double tax_Percentage; 
	private double totalTax;
	private String Name;
	
	MyTax(double deduction, double income, double tax_Percentage, double totalTax)
	{
		 deduction =this.deduction;		
				income =this.income; 
				 deduction =this.deduction;
				 totalTax=this.totalTax;
	}
	
	
	public double getDeduction() {
		return deduction;
	}
	public void setDeduction(double deduction) {
		this.deduction = deduction;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getTax_Percentage() {
		return tax_Percentage;
	}
	public void setTax_Percentage(double tax_Percentage) {
		this.tax_Percentage = tax_Percentage;
	}
	public double getTotalTax() {
		return totalTax;
	}
	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

}
