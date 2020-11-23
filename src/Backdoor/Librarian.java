package Backdoor;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;


public class Librarian extends User {

    public static Statement statement = null;
    public static ResultSet resultSet = null;
    protected static String url = DBVars.DBUrl;
    protected static String user = DBVars.DBUser,pass = DBVars.DBPassword;
    private Connection connect = DriverManager.getConnection(url,user,pass);

    public Librarian() throws SQLException{
    }

    public Librarian(String user_ID) throws SQLException {
        statement = connect.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM user");
        this.user_ID = user_ID;
        while (resultSet.next()) {
            if (resultSet.getString("user_ID").equals(this.user_ID)) {
                this.password = resultSet.getString("password");
                this.first_name = resultSet.getString("first_name");
                this.last_name = resultSet.getString("last_name");
                this.role = resultSet.getString("role");
            }
        }
    }

    public Librarian(String user_ID,String password,String first_name,String last_name)throws SQLException{
        this.user_ID = user_ID;
        this. password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = "librarian";

        String query = "insert into user (user_ID, first_name, last_name, password, role)"
                + " values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = connect.prepareStatement(query);
        preparedStmt.setString(1, this.user_ID);
        preparedStmt.setString(2, this.first_name);
        preparedStmt.setString(3, this.last_name);
        preparedStmt.setString(4, this.password);
        preparedStmt.setString(5, this.role);
        preparedStmt.execute();
    }

    @Override
    public String getFirstName() {
        return first_name;
    }

    @Override
    public String getLastName() {
        return last_name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public String getUserID() {
        return user_ID;
    }

    @Override
    public void setFirstName(String first_name) throws SQLException{
        this.first_name = first_name;
        updateString(this.first_name,"first_name");
    }

    @Override
    public void setLastName(String last_name) throws SQLException{
        this.last_name = last_name;
        updateString(this.last_name,"last_name");
    }

    @Override
    public void setPassword(String password) throws SQLException{
        this.password = password;
        updateString(this.password,"password");
    }

    public  void updateString(String string,String attribute) throws SQLException{
        String query = "UPDATE " + attribute + " = ? where user_ID = ?";
        PreparedStatement preparedStatement = connect.prepareStatement(query);
        preparedStatement.setString(1,string);
        preparedStatement.setString(2,this.user_ID);
        preparedStatement.execute();
    }

    public String toString(){
        return "user_ID = " + getUserID() + "\npassword = " + getPassword() + "\nfirst name = " + getFirstName()
                +"\nlast name = " + getLastName() + "\nrole = " + getRole();
    }
}