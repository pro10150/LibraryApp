package Backdoor;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class Borrowed_book extends Member{

    private String book_ID;
    private int remaining;
    private Date dueDate;
    private Date startDate;
    private Date returnDate;
    private boolean lateCheck;
    private boolean isBorrow = false;

    public Borrowed_book(String user_ID) throws SQLException{
        this.user_ID = user_ID;
        statement = connect.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM borrowed_book");

        while (resultSet.next()){
            if (this.user_ID.equals(resultSet.getString("user_ID"))){
                this.book_ID = resultSet.getString("book_ID");
                this.startDate = resultSet.getDate("start_date");
                this.dueDate = resultSet.getDate("due_date");
                this.returnDate = resultSet.getDate("start_date");
                this.lateCheck = resultSet.getBoolean("late_check");
                //System.out.println(toString());
            }

        }
    }

    public Borrowed_book(String user_ID, String book_ID) throws SQLException{
        this.user_ID = user_ID;
        this.book_ID = book_ID;
        PhysicalBook book = new PhysicalBook(book_ID);
        this.remaining = book.getRemaining();

        if (this.remaining == 0) isBorrow = false;
        else{
            String query = "INSERT INTO borrowed_book(user_ID,book_ID,start_date,due_date) VALUES (?, ?, ?, ?)";
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
            this.startDate = startDate;

            long date = System.currentTimeMillis() + 14 * 24 * 3600 * 1000;
            Date dueDate = new Date(date);
            this.dueDate = dueDate;

            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1,this.user_ID);
            preparedStatement.setString(2,this.book_ID);
            preparedStatement.setDate(3,this.startDate);
            preparedStatement.setDate(4,this.dueDate);
            preparedStatement.execute();

            book.reduceRemaining();
            book.updateRemaining(this.remaining--);
            isBorrow = true;
        }
    }

    public void returnBook() throws SQLException {
        Calendar calendar = Calendar.getInstance();
        java.sql.Date returnDate = new java.sql.Date(calendar.getTime().getTime());
        this.returnDate = returnDate;

        boolean late_check = false;

        long todayDate = System.currentTimeMillis() + 0 *24 *3600 * 1000;
        long due = this.dueDate.getTime();

        if (due - todayDate > 0) late_check = false;

        else if (due - todayDate < 0) late_check = true;

        this.lateCheck = late_check;

        /*String query = "UPDATE borrowed_book SET return_date = " + startDate + ",late_check = " + late_check +
                " WHERE user_ID = " + this.user_ID + " AND book_ID = " + this.book_ID + " AND due_date = " + this.dueDate;
        PreparedStatement preparedStatement = connect.prepareStatement(query);
        preparedStatement.execute();*/
        String query = "UPDATE borrowed_book SET return_date = ?, late_check = ? WHERE user_ID = ? AND book_ID = ? " +
                "AND due_date = ?";
        PreparedStatement preparedStatement = connect.prepareStatement(query);
        preparedStatement.setDate(1,this.returnDate);
        preparedStatement.setBoolean(2,this.lateCheck);
        preparedStatement.setString(3,this.user_ID);
        preparedStatement.setString(4,this.book_ID);
        preparedStatement.setDate(5,this.dueDate);
        preparedStatement.execute();
    }

    public Date getDueDate(){
        return dueDate;
    }

    public Date getStartDate(){
        return startDate;
    }

    public Date getReturnDate(){
        return returnDate;
    }

    public boolean getLateCheck(){
        return lateCheck;
    }
    
    public boolean getIsBorrow(){
        return isBorrow;
    }

    public String toString(){
        return "bookid = " + book_ID + "\nstartdate = " + startDate + "\nduedate = " + dueDate + "\nreturndate = "
                + returnDate + "\nlatecheck = " + lateCheck;
    }
}
