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
public class UserPickBook extends Member {
    private int i=0;
    private String book_ID;
    private ArrayList bookIDList = new ArrayList<String>();
    //private int limit = 100;
    //private String [] bookIDList = {};
    public UserPickBook(String user_ID) throws SQLException {
        this.user_ID = user_ID;
        statement = connect.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM user_pick_book");

        //ArrayList<String> bookIDList = new ArrayList<String>();

        while (resultSet.next()){
            if (this.user_ID.equals(resultSet.getString("user_ID"))){
                this.book_ID = resultSet.getString("book_ID");
                //bookIDList[i] = this.book_ID;
                bookIDList.add(this.book_ID);
                i++;
                //System.out.println(toString());
            }

        }
    }

    public UserPickBook(String user_ID, String book_ID) throws SQLException{
        this.book_ID = book_ID;
        this.user_ID = user_ID;
        String query = "INSERT INTO user_pick_book(user_ID,book_ID) VALUES (?, ?)";
        PreparedStatement preparedStatement = connect.prepareStatement(query);
        preparedStatement.setString(1,this.user_ID);
        preparedStatement.setString(2,this.book_ID);
        preparedStatement.execute();
    }

    public ArrayList getBookIDList(){
        return bookIDList;
    }

    public int getCount(){
        return i;
    }

    public String toString() {
        return "bookid = " + book_ID;
    }
}
