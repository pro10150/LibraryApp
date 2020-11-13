package Backdoor;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class main {
    public static void main(String[] args) throws SQLException{
        
        int pageCap = (int)Math.ceil(10 / 3.0);
        System.out.println(pageCap);

        Book book1 = new PhysicalBook("0000000011");
     //   System.out.println(book1.toString());
        
        Book book2 = new PhysicalBook("Test X");
        System.out.println(book2.getName());
    
        Search sc = new Search();
        sc.searchBook("te");
        System.out.println(sc.getnthID(9));
        

        //    System.out.println(sc.getnthID(0));
    
        String password = "123456";
        
       User member = new Member("1234");
       String role = member.getRole(); 
       String password2 = member.getPassword(); 
       System.out.println(password.equals(password2));
       
       Book book3 = new AudioBook("Test 5");
        System.out.println(book3.toString());
        
       /* User mem2 = new Member("1235");
        System.out.println(mem2.toString());
        
        User mem3 = new Librarian("1236");
        System.out.println(mem3.toString());
        */
        
    }
}