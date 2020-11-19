package Backdoor;

import java.sql.*;
import java.util.*;

public class AudioBook extends Book{
    private String voice_actor;

    public AudioBook(String name) throws SQLException {
        statement = connect.createStatement();
        this.name = name;

        resultSet = statement.executeQuery("SELECT * FROM audio_book NATURAL JOIN book");
        while (resultSet.next()){
            if (resultSet.getString("name").equals(this.name)){
                    this.voice_actor = resultSet.getString("voice_actor");
                    PhysicalBook book = new PhysicalBook(this.name);
                    this.name = book.getName();
                    this.book_ID = book.getBookID();
                    this.type = book.getType();
                    this.description = book.getDescription();
                    this.published_location = book.getPublished_location();
                    this.year = book.getYear();
                    this.author = book.getAuthor();
            }
        }

        if (book_ID == null) bookExisting = false;
    }

    public AudioBook(String name, String voiceActor) throws SQLException{
        this.name = name;
        this.voice_actor = voiceActor;

        PhysicalBook book = new PhysicalBook(this.name);

        this.book_ID = book.getBookID();
        this.type = book.getType();
        this.description = book.getDescription();
        this.published_location = book.getPublished_location();
        this.year = book.getYear();
        this.author = book.getAuthor();

        String query = "insert into audio_book (book_ID, voice_actor)"
                + " values (?, ?)";

        PreparedStatement preparedStmt = connect.prepareStatement(query);
        preparedStmt.setString(1,this.book_ID);
        preparedStmt.setString(2,this.voice_actor);
        preparedStmt.execute();

    }

    public boolean getBookExisting() {
        return bookExisting;
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
    public void setType(String type) throws SQLException {
        this.type = type;
        updateString(this.type,"type");
    }

    @Override
    public void setDescription(String description) throws SQLException {
        this.description = description;
        updateString(this.description,"description");
    }

    @Override
    public void setPublished_location(String published_location) throws SQLException {
        this.published_location = published_location;
        updateString(this.published_location,"published_location");
    }

    @Override
    public void setAuthor(String author) throws SQLException {
        this.author = author;
        updateString(this.author,"author");
    }

    @Override
    public void setYear(int year) throws SQLException{
        this.year = year;
        updateInt(this.year);
    }

    public void setVoiceActor(String voiceActor) throws SQLException{
        this.voice_actor = voiceActor;
        AudioBook book = new AudioBook(this.name);
        if (book.getVoiceActor() != null) updateStringAudioBook(this.voice_actor,"voice_actor");
        else updateNullVoiceActor(this.voice_actor);
    }


    public String getVoiceActor(){
        return voice_actor;
    }

    public void updateStringAudioBook(String string,String attribute) throws SQLException {
        String query = "update audio_book set " + attribute + " = ? where book_ID = ?";
        PreparedStatement preparedStmt = connect.prepareStatement(query);
        preparedStmt.setString(1,string);
        preparedStmt.setString(2,this.book_ID);
        preparedStmt.execute();
    }

    public void updateString(String string,String attribute) throws SQLException {
        String query = "update book set " + attribute + " = ? where book_ID = ?";
        PreparedStatement preparedStmt = connect.prepareStatement(query);
        preparedStmt.setString(1,string);
        preparedStmt.setString(2,this.book_ID);
        preparedStmt.execute();
    }

    public void updateInt(int x) throws SQLException {
        String query = "update audio_book set " + x + " = ? where book_ID = ?";
        PreparedStatement preparedStmt = connect.prepareStatement(query);
        preparedStmt.setInt(1,x);
        preparedStmt.setString(2,this.book_ID);
        preparedStmt.execute();
    }



    public void updateNullVoiceActor(String x) throws SQLException{
        String query = "INSERT INTO audio_book VALUES (?, ?)";
        PreparedStatement preparedStatement = connect.prepareStatement(query);
        preparedStatement.setString(1,this.book_ID);
        preparedStatement.setString(2,x);
        preparedStatement.execute();
    }

    public String toString(){
        if (bookExisting == false){
            return "can't find any book";
        }
        else
            return "Book_ID = " + getBookID() + "\nName = " + getName() + "\nType = " + getType() + "\nDescription = "
                    + getDescription() + "\nPublished location = " + getPublished_location() + "\nYear = " + getYear()
                    + "\nAuthor = " + getAuthor() + "\nVoice Actor = " + getVoiceActor();
    }
}