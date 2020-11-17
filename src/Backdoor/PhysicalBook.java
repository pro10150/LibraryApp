package Backdoor;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;



public class PhysicalBook extends Book implements Update{
    private String section;
    private int serial;
    private int remaining;

    public PhysicalBook(String name) throws SQLException{
        statement = connect.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM book b NATURAL JOIN remaining r ORDER BY book_ID " +
                "DESC,last_update DESC");
        this.name = name;
        while (resultSet.next()){
            if (resultSet.getString("b.name").equals(this.name)){
                this.book_ID = resultSet.getString("b.book_ID");
                this.type = resultSet.getString("b.type");
                this.description = resultSet.getString("b.description");
                this.published_location = resultSet.getString("b.published_location");
                this.year = resultSet.getInt("b.year");
                this.author = resultSet.getString("b.author");
                this.section = resultSet.getString("b.section");
                this.serial = resultSet.getInt("b.serial");
                this.remaining = resultSet.getInt("r.remaining");
                break;
            }
        }
        if (this.type == null){
            this.name = null;
            this.book_ID = name;
            resultSet = statement.executeQuery("SELECT * FROM book b NATURAL JOIN remaining r ORDER BY book_ID " +
                    "DESC,last_update DESC");
            while (resultSet.next()){
                if (resultSet.getString("b.book_ID").equals(this.book_ID)){
                    this.name = resultSet.getString("b.name");
                    this.type = resultSet.getString("b.type");
                    this.description = resultSet.getString("b.description");
                    this.published_location = resultSet.getString("b.published_location");
                    this.year = resultSet.getInt("b.year");
                    this.author = resultSet.getString("b.author");
                    this.section = resultSet.getString("b.section");
                    this.serial = resultSet.getInt("b.serial");
                    this.remaining = resultSet.getInt("r.remaining");
                    break;
                }
            }
        }
        if (this.type == null) bookExisting = false;
    }

    public PhysicalBook(String book_ID,String name,String type,String section,int serial,int remaining)
            throws SQLException {
        this.book_ID = book_ID;
        this.name = name;
        this.type = type;
        this.section = section;
        this.serial = serial;
        this.remaining = remaining;

        String query = "insert into book (book_ID, name, type, section, serial) values (?, ?, ?, ?, ?)";

        PreparedStatement preparedStmt = connect.prepareStatement(query);
        preparedStmt.setString(1,this.book_ID);
        preparedStmt.setString(2,this.name);
        preparedStmt.setString(3,this.type);
        preparedStmt.setString(4,this.section);
        preparedStmt.setInt(5,this.serial);
        preparedStmt.execute();

        query = "INSERT INTO remaining (book_ID, remaining, last_update) VALUES (?,?,?)";
        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
        PreparedStatement preparedStmt2 = connect.prepareStatement(query);
        preparedStmt2.setString(1,this.book_ID);
        preparedStmt2.setInt(2,this.remaining);
        preparedStmt2.setDate(3,startDate);
        preparedStmt2.execute();

    }

    @Override
    public String getBookID() {
        return book_ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getDescription() {
        if (description != null) return description;
        else return "This book has no description";
    }

    @Override
    public String getPublished_location() {
        if (published_location != null) return published_location;
        else return "Unknown published location";
    }

    @Override
    public String getAuthor() {
        if (author != null) return author;
        else return "Unknown author";
    }

    public String getSection(){
        return section;
    }

    public int getSerial(){
        return serial;
    }

    public int getRemaining(){
        return remaining;
    }

    public String getLocation(){
        String x = getSection() + getSerial();
        return x;
    }

    @Override
    public int getYear() {
        if (year > 0)
        return year;
        else return 0;
    }

    @Override
    public void setName(String name) throws SQLException {
        this.name = name;
        updateString(this.name,"name");
    }

    @Override
    public void setType(String type) throws SQLException{
        this.type = type;
        updateString(this.type,"type");
    }

    @Override
    public void setDescription(String description) throws SQLException{
        this.description = description;
        updateString(this.description,"description");
    }

    @Override
    public void setPublished_location(String published_location) throws SQLException{
        this.published_location = published_location;
        updateString(this.published_location,"published_location");
    }

    @Override
    public void setAuthor(String author) throws SQLException{
        this.author = author;
        updateString(this.author,"author");
    }

    @Override
    public void setYear(int year) throws SQLException{
        this.year = year;
        updateInt(this.year,"year");
    }

    public void setSection(String section) throws SQLException{
        this.section = section;
        updateString(this.section,"section");
    }

    public void setSerial(int serial) throws SQLException{
        this.serial = serial;
        updateInt(this.serial,"serial");
    }

    public void setRemaining(int remaining) throws SQLException{
        this.remaining = remaining;
        updateRemaining(this.remaining);
    }

    public void updateString(String x,String attribute) throws SQLException {
        String query = "update book set " + attribute + " = ? where book_ID = ?";
        PreparedStatement preparedStmt = connect.prepareStatement(query);
        preparedStmt.setString(1,x);
        preparedStmt.setString(2,this.book_ID);
        preparedStmt.execute();
    }

    public void updateInt(int x,String attribute) throws SQLException {
        String query = "update book set " + attribute + " = ? where book_ID = ?";
        PreparedStatement preparedStmt = connect.prepareStatement(query);
        preparedStmt.setInt(1,x);
        preparedStmt.setString(2,this.book_ID);
        preparedStmt.execute();
    }

    public void updateRemaining(int remaining) throws SQLException{
        this.remaining = remaining;
        String query = "INSERT INTO remaining VALUES(?, ?, ?)";
        Calendar calendar = Calendar.getInstance();
        //java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
        java.sql.Timestamp stampTime = new java.sql.Timestamp(calendar.getTimeInMillis());
        PreparedStatement preparedStmt = connect.prepareStatement(query);
        preparedStmt.setString(1,this.book_ID);
        preparedStmt.setInt(2,this.remaining);
        preparedStmt.setTimestamp(3,stampTime);
        preparedStmt.execute();
    }

    public void reduceRemaining() throws SQLException{
        this.remaining -= 1;
        String query = "INSERT INTO remaining VALUES(?, ?, ?)";
        Calendar calendar = Calendar.getInstance();
        //java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
        java.sql.Timestamp stampTime = new java.sql.Timestamp(calendar.getTimeInMillis());
        PreparedStatement preparedStmt = connect.prepareStatement(query);
        preparedStmt.setString(1,this.book_ID);
        preparedStmt.setInt(2,this.remaining);
        preparedStmt.setTimestamp(3,stampTime);
        preparedStmt.execute();
    }
    
    public void increaseRemaining() throws SQLException{
        this.remaining += 1;
        String query = "INSERT INTO remaining VALUES(?, ?, ?)";
        Calendar calendar = Calendar.getInstance();
        //java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
        java.sql.Timestamp stampTime = new java.sql.Timestamp(calendar.getTimeInMillis());
        PreparedStatement preparedStmt = connect.prepareStatement(query);
        preparedStmt.setString(1,this.book_ID);
        preparedStmt.setInt(2,this.remaining);
        preparedStmt.setTimestamp(3,stampTime);
        preparedStmt.execute();
    }
    
    public void deletePhysicalBook() throws SQLException{
        this.section = null;
        this.serial = 0;
        this.remaining = 0;
        deleteRemaining();
        deleteBorrowedBook();
        deleteReservedBook();
        deleteUserPickBook();
        deleteBook();
        this.book_ID = null;

    }

    public void deleteRemaining() throws SQLException{
        this.remaining = 0;
        String query = "DELETE FROM remaining WHERE book_ID = ?";
        PreparedStatement preparedStatement = connect.prepareStatement(query);
        preparedStatement.setString(1,this.book_ID);
        preparedStatement.execute();
    }
    
    public void deleteBorrowedBook() throws SQLException{
        String query = "DELETE FROM borrowed_book WHERE book_ID = ?";
        PreparedStatement preparedStatement = connect.prepareStatement(query);
        preparedStatement.setString(1, this.book_ID);
        preparedStatement.execute();
    }
    
    public void deleteReservedBook() throws SQLException{
        String query = "DELETE FROM reserved_book WHERE book_ID = ?";
        PreparedStatement preparedStatement = connect.prepareStatement(query);
        preparedStatement.setString(1, this.book_ID);
        preparedStatement.execute();
    }
    
    public void deleteUserPickBook() throws SQLException{
        String query = "DELETE FROM user_pick_book WHERE book_ID = ?";
        PreparedStatement preparedStatement = connect.prepareStatement(query);
        preparedStatement.setString(1, this.book_ID);
        preparedStatement.execute();
    }

    public String toString(){
        if (bookExisting == false){
            return "can't find any book";
        }
        else
            return "Book_ID = " + getBookID() + "\nName = " + getName() + "\nType = " + getType() + "\nDescription = "
                + getDescription() + "\nPublished location = " + getPublished_location() + "\nYear = " + getYear()
                + "\nAuthor = " + getAuthor() + "\nLocation = " + getLocation() + "\nRemaining = " + getRemaining();
    }
}