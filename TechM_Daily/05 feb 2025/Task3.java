package sqlexamples;
import java.sql.*;
import java.util.Scanner;
public class Task3{
    public static void main(String args[]) {
        Connection con = null;
        PreparedStatement pstmt = null;
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techm?autoReconnect=true&useSSL=false", "root", "root");

            System.out.println("Enter Department ID to delete:");
            int deptId = sc.nextInt();
            
            String query = "DELETE FROM dept WHERE deptId = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, deptId);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Department deleted successfully!");
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
