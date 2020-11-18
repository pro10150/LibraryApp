/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backdoor;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
/**
 *
 * @author skooter
 */
public class Review extends Member implements Update{
    private String book_ID;
    private int rate;
    private int IDListCount = 0;
    private String description;
    private boolean isReview = false;
    private ArrayList userIDList = new ArrayList<String>();
    private ArrayList bookIDList = new ArrayList<String>();
    private ArrayList bookRateList = new ArrayList<Integer>();
    private ArrayList bookDescriptionList = new ArrayList<String>();

    public Review(String ID) throws SQLException {
        statement = connect.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM review");
        //this.user_ID = ID;
        while (resultSet.next()){
            if (ID.equals(resultSet.getString("user_ID"))){
                this.user_ID = ID;
                this.book_ID = resultSet.getString("book_ID");
                this.rate = resultSet.getInt("rate");
                this.description = resultSet.getString("description");
                bookIDList.add(this.book_ID);
                bookRateList.add(this.rate);
                bookDescriptionList.add(this.description);
                IDListCount++;
                isReview = true;
            }
            else if (ID.equals(resultSet.getString("book_ID"))){
                this.book_ID = ID;
                this.user_ID = resultSet.getString("user_ID");
                this.rate = resultSet.getInt("rate");
                this.description = resultSet.getString("description");
                userIDList.add(this.user_ID);
                bookRateList.add(this.rate);
                bookDescriptionList.add(this.description);
                IDListCount++;
                isReview = true;
            }
        }
    }

    //to select the certain book review for deletion or shown a specific review
    public Review(String user_ID, String book_ID) throws SQLException{
        statement = connect.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM review");
        this.book_ID = book_ID;
        this.user_ID = user_ID;
        //System.out.println("hi");
        while (resultSet.next()){
            if (user_ID.equals(resultSet.getString("user_ID")) &&
                    book_ID.equals(resultSet.getString("book_ID"))){
                this.rate = resultSet.getInt("rate");
                this.description = resultSet.getString("description");
                //System.out.println("Hi");
                //System.out.println(toString());
                break;
            }
        }
    }

    public Review(String user_ID, String book_ID, int rate) throws SQLException{
        this.user_ID = user_ID;
        this.book_ID = book_ID;
        this.rate = rate;

        String query = "INSERT INTO review(user_ID, book_ID, rate) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connect.prepareStatement(query);
        preparedStatement.setString(1,this.user_ID);
        preparedStatement.setString(2,this.book_ID);
        preparedStatement.setInt(3,this.rate);
        preparedStatement.execute();
        PhysicalBook book = new PhysicalBook(this.book_ID);
        double overallRate = book.getOverallRate();
        overallRate += rate;
        if (book.getOverallRate() != 0){
            overallRate /= 2;
        }
        book.setOverallRate(overallRate);
    }

    public void deleteReview() throws SQLException{
        String query = "DELETE FROM review WHERE user_ID = ? AND book_ID = ?";
        PreparedStatement preparedStatement = connect.prepareStatement(query);
        preparedStatement.setString(1,user_ID);
        preparedStatement.setString(2,book_ID);
        preparedStatement.execute();
        PhysicalBook book = new PhysicalBook(this.book_ID);
        double overallRate = book.getOverallRate();
        if (book.getOverallRate() != 0){
            overallRate *= 2;
        }
        overallRate -= rate;
        book.setOverallRate(overallRate);
    }

    public ArrayList getUserIDList(){
        return userIDList;
    }

    public ArrayList getBookIDList(){
        return bookIDList;
    }

    public ArrayList getBookRateList(){
        return bookRateList;
    }

    public ArrayList getBookDescriptionList(){
        return bookDescriptionList;
    }

    public int getIDListCount(){
        return IDListCount;
    }

    public int getRate(){
        return rate;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description) throws SQLException{
        this.description = description;
        updateString(this.description, "description");
    }

    public void setRate(int rate) throws SQLException{
        PhysicalBook book = new PhysicalBook(this.book_ID);
        double overallRate = book.getOverallRate();
        // Revert
        if (book.getOverallRate() != 0){
            overallRate *= 2;
        }
        overallRate -= this.rate;
        // Add new rate
        overallRate += rate;
        if (book.getOverallRate() != 0){
            overallRate /= 2;
        }
        book.setOverallRate(overallRate);
        this.rate = rate;
        updateInt(this.rate, "rate");
    }

    public void updateString(String x,String attribute) throws SQLException {
        String query = "update review set " + attribute + " = ? where user_ID = ? AND book_ID = ?";
        PreparedStatement preparedStmt = connect.prepareStatement(query);
        preparedStmt.setString(1,x);
        preparedStmt.setString(2,this.user_ID);
        preparedStmt.setString(3,this.book_ID);
        preparedStmt.execute();
    }

    public void updateInt(int x,String attribute) throws SQLException {
        String query = "update review set " + attribute + " = ? where user_ID = ? AND book_ID = ?";
        PreparedStatement preparedStmt = connect.prepareStatement(query);
        preparedStmt.setInt(1,x);
        preparedStmt.setString(2,this.user_ID);
        preparedStmt.setString(3,this.book_ID);
        preparedStmt.execute();
    }

    public String toString(){
        return "user_ID = " + user_ID + "\nbook_ID = " + book_ID + "\nrate = " + rate + "\ndescription = " +
                description;
    }
}
