package Backdoor;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class Member extends User {
    protected int fee;
    protected int phone_count;

    public static Statement statement = null;
    public static ResultSet resultSet = null;
    private static String url = "jdbc:mysql://localhost:3306/library";
    private static String user = "root",pass = DBVars.DBPassword;
    protected Connection connect = DriverManager.getConnection(url,user,pass);



    public Member() throws SQLException {
    }

    public Member(String user_ID) throws SQLException {
        statement = connect.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM user"); // Edited here.
        this.user_ID = user_ID;
        while (resultSet.next()) {
            if (resultSet.getString("user_ID").equals(this.user_ID)) {
                this.password = resultSet.getString("password");
                this.first_name = resultSet.getString("first_name");
                this.last_name = resultSet.getString("last_name");
                this.role = resultSet.getString("role");
            }
        }
        resultSet = statement.executeQuery("SELECT * FROM fee ORDER BY last_update DESC");
        while(resultSet.next()){
            if (resultSet.getString("user_ID").equals(this.user_ID))
            this.fee = resultSet.getInt("fee");
            break;
        }
        this.phone_count = 0;
    }

    public Member(String user_ID,String first_name,String last_name,String password) throws SQLException {
        this.user_ID = user_ID;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = "member";
        this.fee = 0;
        this.phone_count = 0;

        String query = "insert into user (user_ID, first_name, last_name, password, role)"
                + " values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = connect.prepareStatement(query);
        preparedStmt.setString(1, this.user_ID);
        preparedStmt.setString(2, this.first_name);
        preparedStmt.setString(3, this.last_name);
        preparedStmt.setString(4, this.password);
        preparedStmt.setString(5, this.role);
        preparedStmt.execute();

        query = "INSERT INTO fee (user_ID, fee, last_update)" + "VALUES (?,?,?)";
        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());


        PreparedStatement preparedStmt2 = connect.prepareStatement(query);
        preparedStmt2.setString(1, this.user_ID);
        preparedStmt2.setInt(2, 0);
        preparedStmt2.setDate(3, startDate);
        preparedStmt2.execute();

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

    public int getFee(){
        return fee;
    }

    public int getPhone_count(){
        return phone_count;
    }
    //for the event that fee is incorrect
    public void setFee(int fee) throws SQLException {
        this.fee = fee;
        insertFee(this.fee);
    }

    //for the event that fee went up
    public void addFee(int fee) throws SQLException {
        this.fee += fee;
        insertFee(this.fee);
    }

    //for the event that fee is reduced but not all of them
    public void reduceFee(int fee) throws SQLException{
        this.fee -= fee;
        insertFee(this.fee);
    }

    //for the event that fee has been cleared completely
    public void clearFee() throws SQLException{
        this.fee = 0;
        insertFee(this.fee);
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
    public void setPassword(String password) throws SQLException {
        this.password = password;
        updateString(this.password,"password");
    }

    public void insertFee(int fee) throws SQLException {
        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
        String query = "INSERT INTO fee VALUES(?, ?, ?)";
        PreparedStatement preparedStatement = connect.prepareStatement(query);
        preparedStatement.setString(1,this.user_ID);
        preparedStatement.setInt(2,fee);
        preparedStatement.setDate(3,startDate);
        preparedStatement.execute();
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
                +"\nlast name = " + getLastName() + "\nrole = " + getRole() + "\nfee = " + getFee() + "\nphone count = "
                + getPhone_count();
    }
}
