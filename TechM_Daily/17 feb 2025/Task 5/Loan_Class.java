package Task2;

//7) Create a Loan Bean application that will explain about getter setters. 
//It should compraise of Housing loan, Vehicle loan etc..
public class Loan_Class {
	
	private String loanType;
    private double loanAmount;
    private double interestRate;

    // Getter and Setter methods
    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    
   

	public void display() {
		// TODO Auto-generated method stub
		System.out.println("the loanType is "+loanType +" the amount "+ loanAmount +"  intrest rates  "+interestRate);
	}
 
}
