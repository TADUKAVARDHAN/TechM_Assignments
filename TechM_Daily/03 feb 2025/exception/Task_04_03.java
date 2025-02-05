package exception;

import java.io.File;
import java.util.Scanner;

public class Task_04_03 {

	public static void readNumbers(String fileName) throws Exception {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            if (num > 0) {
                throw new Exception("Positive number found: " + num);
            }
            System.out.println("Number: " + num);
        }
        scanner.close();
    }
    
    public static void main(String[] args) {
        try {
            readNumbers("C:\\Users\\bipin\\Desktop\\Eclipse workspace-bipin\\Task_03_02_2025\\src\\exception\\text1.txt"); 
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

}
