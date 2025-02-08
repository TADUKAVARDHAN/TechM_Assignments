package sqlexamples;
import java.sql.*;
import java.util.Scanner;
public class Task2 {
    public static void main(String args[]) {
        Connection con = null;
        PreparedStatement pstmt = null;
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techm?autoReconnect=true&useSSL=false", "root", "root");

            System.out.println("Enter Department ID to update:");
            int deptId = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter new Department Name:");
            String deptName = sc.nextLine();
            System.out.println("Enter new Department Location:");
            String loc = sc.nextLine();

            String query = "UPDATE dept SET deptName = ?, loc = ? WHERE deptId = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, deptName);
            pstmt.setString(2, loc);
            pstmt.setInt(3, deptId);

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Department updated successfully!");
            } else {
                System.out.println("No department found with the given ID.");
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
