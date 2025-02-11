package sqlexamples;

import java.sql.*;
import java.util.Scanner;

public class PreparedStatementInsert {
    public static void main(String args[]) {
        Connection con = null;
        PreparedStatement pstmt = null;
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techm?autoReconnect=true&useSSL=false", "root", "root");

            while (true) {
                System.out.println("Enter Department ID:");
                int deptId = sc.nextInt();
                sc.nextLine();  
                System.out.println("Enter Department Name:");
                String deptName = sc.nextLine();
                System.out.println("Enter Department Location:");
                String loc = sc.nextLine();
                
                String query = "INSERT INTO dept (deptId, deptName, loc) VALUES (?, ?, ?)";
                pstmt = con.prepareStatement(query);
                pstmt.setInt(1, deptId);
                pstmt.setString(2, deptName);
                pstmt.setString(3, loc);
                
                pstmt.executeUpdate();
                System.out.println("Department inserted successfully!");

                System.out.println("Do you want to insert another department? (yes/no):");
                String response = sc.nextLine();

                if (response.equalsIgnoreCase("no")) {
                    System.out.println("Exiting the program.");
                    break; 
                } else if (!response.equalsIgnoreCase("yes")) {
                    System.out.println("Invalid input! Exiting program.");
                    break;    }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
                sc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Program has ended.");
    }
}
