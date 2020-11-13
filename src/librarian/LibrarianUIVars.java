// Not Necessary!
package librarian;
// Annop Boonlieng
// Change your database user and password here
import Member.*;
public class LibrarianUIVars {
    public static String conName = "jdbc:mysql://localhost:3306/library";
    public static String dbUsername = "root";
    public String dbPassword = "@Pro3083711"; // Not needed.
    
    public static String userID;
    
    //this.userID = LibrarianUIVars.userID;

    
    
}

/* class MysqlCon{  
    
    static String conName = "jdbc:mysql://localhost:3306/library";
    static String username = "root";
    static String password = "!KdHwE@WRUAU#uon$2";
    
    public static void main(String args[]){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection con=DriverManager.getConnection(conName,username,password);  
            
           //Statement stmt=con.createStatement();  
           //ResultSet rs=stmt.executeQuery("select * from user");  
           // while(rs.next())  
           //     System.out.println(rs.getString(2));  // get name
           //con.close();  
        }catch(Exception e){ System.err.println(e);}  
    }  
    
    public static void LoginAttempt(String ID, char[] password) {
    //    Statement stmt=con.createStatement();  
    //    ResultSet rs=stmt.executeQuery("select * from user");  
    //    while(rs.next())  
    //    System.out.println(rs.getString(2));  // get name
    //    con.close();  
    }
}  */

