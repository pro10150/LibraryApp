package Backdoor;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;


public class Search{

    private int limit = 100;

    private String[] resultID = new String[limit];
    private int IDCount = 0;


    public static Statement statement = null;
    public static ResultSet resultSet = null;
    private static String url = "jdbc:mysql://localhost:3306/library";
    private static String user = "root",pass = DBVars.DBPassword;
    private Connection connect ;

    public Search() throws SQLException{
        this.connect = DriverManager.getConnection(url,user,pass);
    }

    public void searchBook(String searchQuery) throws SQLException{

        statement = connect.createStatement();
        String query = "select book_ID from book where name like ? order by name";
        // name query will be replaced with author.

        PreparedStatement preparedStmt = connect.prepareStatement(query);
        preparedStmt.setString(1,"%"+searchQuery+"%");
        resultSet = preparedStmt.executeQuery();

        while (resultSet.next() && IDCount < limit){
            resultID[IDCount] = resultSet.getString("book_ID");
            IDCount++;
            System.out.println(IDCount);
        }
    }

    public int getIDCount() {
        return this.IDCount;
    }

    public String getnthID(int n) {
        return resultID[n];
    }

}