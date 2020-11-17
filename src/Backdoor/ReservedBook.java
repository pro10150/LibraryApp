/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backdoor;
        
import java.sql.*;
import java.util.Calendar;
/**
 *
 * @author skooter
 */
       
public class ReservedBook extends Member {
    private String book_ID;
    private int remaining;
    private Date requestDate;
    private Date requestExpiredDate;
    private boolean reservedStatus;
    private boolean isReserve;

    public ReservedBook(String user_ID) throws SQLException{
        this.user_ID = user_ID;
        statement = connect.createStatement();
        resultSet = statement.executeQuery("select * from reserved_book");

        while (resultSet.next()){
            if (this.user_ID.equals(resultSet.getString("user_ID"))){
                this.book_ID = resultSet.getString("book_ID");
                this.requestDate = resultSet.getDate("request_date");
                this.requestExpiredDate = resultSet.getDate("request_expired_date");
                this.reservedStatus = true;
                //System.out.println(toString());
            }
        }
    }

    public ReservedBook(String user_ID, String book_ID) throws SQLException{
        this.user_ID = user_ID;
        this.book_ID = book_ID;
        PhysicalBook book = new PhysicalBook(this.book_ID);
        remaining = book.getRemaining();
        if (remaining == 0) isReserve = false;
        else{
            String query = "INSERT INTO reserved_book(user_ID,book_ID,request_date,request_expired_date) VALUES (?, ?, ?, ?)";
            Calendar calendar = Calendar.getInstance();
            java.sql.Date requestDate = new java.sql.Date(calendar.getTime().getTime());
            this.requestDate = requestDate;

            long date = System.currentTimeMillis() + 7 * 24 * 3600 * 1000;
            Date requestExpiredDate = new Date(date);
            this.requestExpiredDate = requestExpiredDate;

            PreparedStatement preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1,this.user_ID);
            preparedStatement.setString(2,this.book_ID);
            preparedStatement.setDate(3,this.requestDate);
            preparedStatement.setDate(4,this.requestExpiredDate);
            preparedStatement.execute();

            book.reduceRemaining();
            //book.updateRemaining(this.remaining--);
            isReserve = true;
        }
    }

    public void deleteRequest(String user_ID, String book_ID, Date requestDate) throws SQLException{
        //this.requestDate = requestDate;
        String query = "DELETE FROM reserved_book WHERE user_ID = ? AND book_ID = ? AND request_date = ?";
        PreparedStatement preparedStatement = connect.prepareStatement(query);
        preparedStatement.setString(1,user_ID);
        preparedStatement.setString(2,book_ID);
        preparedStatement.setDate(3,requestDate);
        preparedStatement.execute();
        PhysicalBook book = new PhysicalBook(book_ID);
        book.increaseRemaining();
    }
    
    public boolean getReservedStatus(){
        return reservedStatus;
    }
    
    public boolean getIsReserve(){
        return isReserve;
    }

    public Date getRequestDate(){
        return requestDate;
    }

    public Date getRequestExpiredDate(){
        return requestExpiredDate;
    }

    public String toString(){
        return "bookid = " + book_ID + "\nrequestDate = " + requestDate + "\nrequestExpiredDate = " + requestExpiredDate;
    }
}

