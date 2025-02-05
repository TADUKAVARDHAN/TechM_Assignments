package exception;

public class Task_1_03 {
	public static void main(String[] args)
	{
		try 
		{
			int a[]= {1,2,3,4};
			System.out.println(a[6]);
			int b=100/0;
			System.out.println(b);
			}
		catch (Exception a)
		{
			System.out.println("Exception occured"+a);
		}
	}

}
