package exception;

public class Task_2_03 {
	public static void main(String[] args) {
		try 
		{
			checkeven(51);
		}
		catch (Exception a)
		{
			System.out.println(a);
		}

	}
	private static void checkeven(int i)throws Exception{
		if(i%2!=0)
		{
			throw new Exception("odd nmuber");
			
		}
		System.out.println("even");
		
	}

	

	

}
