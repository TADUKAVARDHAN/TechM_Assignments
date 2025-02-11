package seesion_2;
import java.util.*;
public class Task_1 {

		int empId;
		String empName;
		double sal;
		Scanner sc= new Scanner(System.in);
		
		void setEmployeeDetails() {
			System.out.println("enter employee details");
			empId= sc.nextInt();
			empName=sc.next();
			sal=sc.nextDouble();
		}
		
		void getEmployeeDetails() {
			System.out.println("The employee is "+empName+" with id "+empId+" and salary is "+sal);
		}
		
		void getLoanEligibility() {
			System.out.println("Enter the employee working duration years");
			int years= sc.nextInt();
			
			if(years>5) {
				if(sal>=6 && sal<10 ) {
					System.out.println("Employee is eligible for a loan of 2 lakhs");
					
				}
				else if(sal>=10 && sal<15) {
					System.out.println("Employee is eligible for a loan of 5 lakhs");
				}
				else {
					System.out.println("Employee is eligible for a loan of 7 lakhs");
				}
			}
			else {
				System.out.println("Employee is not eligible for loan as working experinece is less than 5 years");
			}
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			Task_1 emp= new Task_1();
			emp.setEmployeeDetails();
			
			emp.getEmployeeDetails();
			
			emp.getLoanEligibility();
			
			
			
			
			

		}

	
}
