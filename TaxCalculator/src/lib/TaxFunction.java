package lib;

public class TaxFunction {

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int monthWorkingInYear, int annualDeductible, boolean hasNoSpouse, int numOfChildren) {
		double annualIncome = ((monthlySalary + otherMonthlyIncome) * monthWorkingInYear) - annualDeductible;
		double tax = 0;
		double taxRate = 0;
		
		if (annualIncome <= 50000000) {
			taxRate = 0.05;
		} else if (annualIncome <= 250000000) {
			taxRate = 0.15;
		} else if (annualIncome <= 500000000) {
			taxRate = 0.25;
		} else {
			taxRate = 0.3;
		}
		
		if (!hasNoSpouse) {
			taxRate -= 0.02;
		}
		
		tax = annualIncome * taxRate;
		tax -= (numOfChildren * 0.03 * tax);
		
		return (int) tax;
	}
}
