package Backdoor;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;


public class Phone extends Member{
    private int phone;

    public Phone(int phone) throws SQLException{
        this.phone = phone;
        super.phone_count++;
    }

    public void setPhone(int phone){
        this.phone = phone;
    }

    public int getPhone(){
        return phone;
    }
}