package session_1;

import java.util.Arrays;
import java.util.Scanner;

public class Task_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		
		System.out.println("Enter the number of students");
		int n=s.nextInt();
		System.out.println("Enter the number of subjects");
		int n1 =s.nextInt();
		int arr[][]=new int[n][n1];
		
		int sum[]=new int[n];
		double avg[]=new double[n];
		int count=1;
		
		for(int i=0;i<n;i++)
		{	
			System.out.println("Enter the marks of student"+count);
			for(int j=0;j<n1;j++)
			{
				arr[i][j]=s.nextInt();
			}
			count++;
		}
		
		for(int i=0;i<n;i++)
		{	int sum1=0;
			for(int j=0;j<n1;j++)
			{
				sum1=sum1+arr[i][j];
			}
			sum[i]=sum1;
			System.out.println("sum of all marks of student"+(i+1)+"-->"+sum[i]);
			
			
			
		}
		System.out.println();
		for(int i=0;i<n;i++)
		{
			avg[i]=(double)sum[i]/n1;
			
			System.out.println("sum of average of student"+(i+1)+"--> "+avg[i]);
		}
		Arrays.sort(sum);
		
		System.out.println("Sorted list of total sum of marks of each student"+" "+Arrays.toString(sum));
		
		Arrays.sort(avg);
		
		System.out.println("Sorted list of average marks of each student"+" "+Arrays.toString(avg));
		
		
		
		
		
	}

}
