package Backdoor;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class Borrowed_book extends Member{

    private String book_ID;
    private int remaining;
    private Date dueDate;
    private Date startDate;
    public static Statement statement = null;
    public static ResultSet resultSet = null;
    public static String url = "jdbc:mysql://localhost:3306/library";
    public static String user = "root",pass = DBVars.DBPassword;
    public Connection connect = DriverManager.getConnection(url,user,pass);

    public Borrowed_book(String user_ID, String book_ID) throws SQLException{
        this.user_ID = user_ID;
        this.book_ID = book_ID;
        PhysicalBook book = new PhysicalBook(book_ID);
        this.remaining = book.getRemaining();
        String query = "INSERT INTO borrowed_book(user_ID,book_ID,start_date,due_date) VALUES (?, ?, ?, ?)";
        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

        long date = System.currentTimeMillis() + 14 * 24 * 3600 * 1000;
        Date dueDate = new Date(date);
        this.dueDate = dueDate;

        PreparedStatement preparedStatement = connect.prepareStatement(query);
        preparedStatement.setString(1,user_ID);
        preparedStatement.setString(2,book_ID);
        preparedStatement.setDate(3,startDate);
        preparedStatement.setDate(4,this.dueDate);
        preparedStatement.execute();

        book.reduceRemaining();
        book.updateRemaining(this.remaining--);
    }
    
    
   

    public void returnBook() throws SQLException {
        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

        boolean late_check = false;

        long todayDate = System.currentTimeMillis() + 0 *24 *3600 * 1000;
        long due = this.dueDate.getTime();

        if (due - todayDate > 0) late_check = false;

        else if (due - todayDate < 0) late_check = true;

        /*String query = "UPDATE borrowed_book SET return_date = " + startDate + ",late_check = " + late_check +
                " WHERE user_ID = " + this.user_ID + " AND book_ID = " + this.book_ID + " AND due_date = " + this.dueDate;
        PreparedStatement preparedStatement = connect.prepareStatement(query);
        preparedStatement.execute();*/
        String query = "UPDATE borrowed_book SET return_date = ?, late_check = ? WHERE user_ID = ? AND book_ID = ? " +
                "AND due_date = ?";
        PreparedStatement preparedStatement = connect.prepareStatement(query);
        preparedStatement.setDate(1,startDate);
        preparedStatement.setBoolean(2,late_check);
        preparedStatement.setString(3,this.user_ID);
        preparedStatement.setString(4,this.book_ID);
        preparedStatement.setDate(5,this.dueDate);
        preparedStatement.execute();
    }
}
