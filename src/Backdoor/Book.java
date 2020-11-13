package Backdoor;
import java.sql.*;



public abstract class Book {
    protected String book_ID;
    protected String name;
    protected String type;
    protected String description;
    protected String published_location;
    protected int year;
    protected String author;
    protected boolean bookExisting = true;

    protected static Statement statement = null;
    protected static ResultSet resultSet = null;
    protected static String url = "jdbc:mysql://localhost:3306/library";
    protected static String user = "root",pass = DBVars.DBPassword;
    protected Connection connect = DriverManager.getConnection(url,user,pass);

    protected Book() throws SQLException {
    }

    public abstract String getBookID();
    public abstract String getName();
    public abstract String getType();
    public abstract String getDescription();
    public abstract String getPublished_location();
    public abstract String getAuthor();
    public abstract int getYear();
    public abstract void setName(String name) throws SQLException;
    public abstract void setType(String type) throws SQLException;
    public abstract void setDescription(String description) throws SQLException;
    public abstract void setPublished_location(String published_location) throws SQLException;
    public abstract void setAuthor(String author) throws SQLException;
    public abstract void setYear(int year) throws SQLException;

    public void deleteBook() throws SQLException{
        this.name = null;
        this.type = null;
        this.description = null;
        this.published_location = null;
        this.year = 0;
        this.author = null;
        this.bookExisting = false;
        String query = "DELETE FROM book WHERE book_ID = ?" ;
        PreparedStatement preparedStatement = connect.prepareStatement(query);
        preparedStatement.setString(1,this.book_ID);
        preparedStatement.execute();

    }
}