package examples;

import java.util.Scanner;

public class car {
	public static void main(String args[]) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of cars");
		int no=sc.nextInt();
		autonomouscar autonomous[]=new autonomouscar[no];
		int carid;
		String brand;
		int noOfTestsConducted;
		int noOfTestsPassed;
		String environment;
		for(int i=0;i<no;i++) {
			System.out.println("Enter employe carid");
			carid=sc.nextInt();
			System.out.println("Enter employe brand");
			brand=sc.next();
			System.out.println("Enter noOfTestsConducted");
			noOfTestsConducted=sc.nextInt();
			System.out.println("Enter noOfTestsPassed");
			noOfTestsPassed=sc.nextInt();
			System.out.println("Enter environment");
			environment=sc.next();
			
			autonomous[i]=new autonomouscar(carid,brand,noOfTestsConducted,noOfTestsPassed,environment);
			int k=solution.findTestPassedByEnv(autonomous, environment, noOfTestsPassed);
			if(k>0) {
				System.out.println("Test Passed sum is ="+k);
			}
			else {
				System.out.println("There are no tests passed in this particular environment");
			}
	
			
			autonomous=solution.updateCarGrade(brand, autonomous, noOfTestsPassed);
		}
		
	}
	
}
class autonomouscar {
	int carld;
	String brand;
	int noOfTestsCounducted;
	int noOfTestsPassed;
	String environment;
	String grade;
	
	autonomouscar(int carld,String brand,int noOfTestsCounducted,int noOfTestsPassed,String environment){
		this.carld=carld;
		this.brand=brand;
		this.noOfTestsCounducted=noOfTestsCounducted;
		this.noOfTestsPassed=noOfTestsPassed;
		this.environment=environment;
	}
	void updateGrade(String newGrade) {
        this.grade = newGrade; // Update the grade
    }
}

class solution
{
	public static int findTestPassedByEnv(autonomouscar[] autonomous,String environment,int no) {
		int sum=0;
		for(int i=0;i<no;i++) {
			if(autonomous[i].environment.equals(environment)) {
				sum+=autonomous[i].noOfTestsPassed;
			}
		}
		if(sum>0) {
			return sum;
		}
		else {
		return 0;
		}
	}
	
	public static autonomouscar[] updateCarGrade(String brand,autonomouscar[] autonomous,int no) {
		
		Scanner scc=new Scanner(System.in);
		int rating;
		String para=scc.next();
		for(int i=0;i<no;i++) {
			if(para.equals(autonomous[i].brand)) {
				rating=((autonomous[i].noOfTestsPassed*100)/autonomous[i].noOfTestsCounducted);
				if(rating>=80) {
					autonomous[i].updateGrade("A1");
				}
				else {
					autonomous[i].updateGrade("B2");
				}
			}
			else {
				return null;
			}
		}
		return autonomous;
			
		
	}
}
