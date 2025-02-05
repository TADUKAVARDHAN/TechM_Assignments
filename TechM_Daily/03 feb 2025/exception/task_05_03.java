package exception;

import java.io.File;
import java.util.Scanner;

public class task_05_03 {

	public static void main(String[] args) {
	    try {
	      readFile("C:\\Users\\bipin\\Desktop\\Eclipse workspace-bipin\\Task_03_02_2025\\src\\exception\\text1.txt");
	    } catch (Exception e) {
	      System.out.println("Error: " + e.getMessage());
	    }
	  }

	  public static void readFile(String fileName) throws Exception {
	    File file = new File(fileName);
	    Scanner scanner = new Scanner(file);

	    
	      String line = scanner.nextLine();
	      if(line.length()==0)
	      {
	    	  
	    	  throw new Exception ("file is empty");
	    	  
	    }
	      else
	      {
	    	  System.out.println("file is not empty");
	      }

	    
	  }

}
