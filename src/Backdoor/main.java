package Backdoor;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.Timestamp;
import java.util.*;
import javax.swing.JOptionPane;

public class main {
    public static void main(String[] args) throws SQLException{
        
        Search s1 = new Search("rating");
        String searchQuery = "est 3";
        s1.searchBook(null);
        
        Calendar calendar = Calendar.getInstance();
        //long calendar = System.currentTimeMillis();
        //Timestamp timestamp = new Timestamp(calendar);
        //System.out.println(timestamp);
        int sec = calendar.get(calendar.SECOND);
        //System.out.println(sec);
        
        
        
        UserPickBook fav = new UserPickBook("1234");
        ArrayList bookList = fav.getBookIDList();
        System.out.println(bookList.get(1));
        
        Object X = bookList.get(1);
        String Y = X.toString();
        System.out.println(Y);
        
        //int input = JOptionPane.showConfirmDialog(null, "Do you want to remove the book?", "Confirmation",
        //        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        //    System.out.println("X = " + input);
        
        int pageCap = (int)Math.ceil(10 / 3.0);
        System.out.println(pageCap);

        Book book1 = new PhysicalBook("0000000011");
     //   System.out.println(book1.toString());
        
        Book book2 = new PhysicalBook("Test X");
        System.out.println(book2.getName());

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