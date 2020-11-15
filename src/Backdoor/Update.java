/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backdoor;

import java.sql.SQLException;
/**
 *
 * @author skooter
 */
public interface Update {
    void updateString(String x,String attribute) throws SQLException;
    void updateInt(int x,String attribute) throws SQLException;
}
