package Backdoor;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public abstract class User {
    protected String user_ID;
    protected String password;
    protected String role;
    protected String first_name;
    protected String last_name;

    public abstract String getFirstName();
    public abstract String getLastName();
    public abstract String getPassword();
    public abstract String getRole();
    public abstract String getUserID();
    public abstract void setFirstName(String first_name) throws SQLException;
    public abstract void setLastName(String last_name) throws SQLException;
    public abstract void setPassword(String password) throws SQLException;
}