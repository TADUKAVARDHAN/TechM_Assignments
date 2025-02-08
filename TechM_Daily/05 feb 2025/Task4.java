package sqlexamples;
import java.sql.*;
import java.util.Scanner;

public class Task4 {
    public static void main(String args[]) {
        Connection con = null;
        PreparedStatement pstmt = null;
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
                try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techm?autoReconnect=true&useSSL=false", "root", "root");

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Insert a new Row");
                System.out.println("2. Update a Row");
                System.out.println("3. Delete a Row");
                System.out.println("4. Select the Row");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine();  

                switch (choice) {
                    case 1:  
                        System.out.println("Enter Department ID:");
                        int deptId = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Department Name:");
                        String deptName = sc.nextLine();
                        System.out.println("Enter Department Location:");
                        String loc = sc.nextLine();

                        String insertQuery = "INSERT INTO dept (deptId, deptName, loc) VALUES (?, ?, ?)";
                        pstmt = con.prepareStatement(insertQuery);
                        pstmt.setInt(1, deptId);
                        pstmt.setString(2, deptName);
                        pstmt.setString(3, loc);
                        pstmt.executeUpdate();
                        System.out.println("Department inserted successfully!");
                        break;

                    case 2:  
                        System.out.println("Enter Department ID to update:");
                        int updateDeptId = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter new Department Name:");
                        String updateDeptName = sc.nextLine();
                        System.out.println("Enter new Department Location:");
                        String updateLoc = sc.nextLine();

                        String updateQuery = "UPDATE dept SET deptName = ?, loc = ? WHERE deptId = ?";
                        pstmt = con.prepareStatement(updateQuery);
                        pstmt.setString(1, updateDeptName);
                        pstmt.setString(2, updateLoc);
                        pstmt.setInt(3, updateDeptId);
                        int rowsUpdated = pstmt.executeUpdate();
                        if (rowsUpdated > 0) {
                            System.out.println("Department updated successfully!");
                        } else {
                            System.out.println("No department found with the given ID.");
                        }
                        break;

                    case 3:  
                        System.out.println("Enter Department ID to delete:");
                        int deleteDeptId = sc.nextInt();

                        String deleteQuery = "DELETE FROM dept WHERE deptId = ?";
                        pstmt = con.prepareStatement(deleteQuery);
                        pstmt.setInt(1, deleteDeptId);
                        int rowsDeleted = pstmt.executeUpdate();
                        if (rowsDeleted > 0) {
                            System.out.println("Department deleted successfully!");
                        } else {
                            System.out.println("No department found with the given ID.");
                        }
                        break;

                    case 4:  
                        System.out.println("Enter Department ID to select:");
                        int selectDeptId = sc.nextInt();

                        String selectQuery = "SELECT * FROM dept WHERE deptId = ?";
                        pstmt = con.prepareStatement(selectQuery);
                        pstmt.setInt(1, selectDeptId);
                        ResultSet rs = pstmt.executeQuery();
                        if (rs.next()) {
                            System.out.println("Department ID: " + rs.getInt("deptId"));
                            System.out.println("Department Name: " + rs.getString("deptName"));
                            System.out.println("Department Location: " + rs.getString("loc"));
                        } else {
                            System.out.println("No department found with the given ID.");
                        }
                        rs.close();
                        break;

                    case 5:  
                        System.out.println("Exiting the program.");
                        con.close();
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
