package exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task_03_03 {
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

	    while (scanner.hasNextLine()) {
	      String line = scanner.nextLine();
	      System.out.println(line);
	    }

	    
	  }
}
