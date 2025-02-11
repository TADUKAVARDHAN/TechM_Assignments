package examples;

import java.util.Scanner;

public class associate_technology {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of employees");
		int no=sc.nextInt();
		Associate associate[]=new Associate[no];
		int id;
		String name;
		String technology;
		int experienceInYears;
		for(int i=0;i<no;i++) {
			System.out.println("Enter employe id");
			id=sc.nextInt();
			System.out.println("Enter employe name");
			name=sc.next();
			System.out.println("Enter employe Technology");
			technology=sc.next();
			System.out.println("Enter employe experience");
			experienceInYears=sc.nextInt();
			
			associate[i]=new Associate(id,name,technology,experienceInYears);
		}
		
		String searchTechnology;
		System.out.println("Enter Technology to be searched");
		searchTechnology=sc.next();
		solution.associatesForGivenTechnology(associate, searchTechnology, no);
		
	}
}

class Associate
{
	int id;
	String name;
	String technology;
	int experienceInYears;
	
	Associate(int id,String name,String technology,int experienceInYears)
	{
		this.id=id;
		this.name=name;
		this.technology=technology;
		this.experienceInYears=experienceInYears;
	}
	
		
}

class solution {
	public static void associatesForGivenTechnology(Associate [] associate,String searchTechnology,int no)
	{
		for(int i=0;i<no;i++)
		{
			if(searchTechnology.equals(associate[i].technology)) {
				if(associate[i].experienceInYears%5==0) {
					System.out.println(associate[i].id);
				}
			}
		}
	}
}


