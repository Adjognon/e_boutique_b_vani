/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author kadjogno
 */
public class ConnexionDB {
    
     private static String url = "jdbc:mysql://localhost:3310/bd_projet_final?serverTimezone=UTC";
    private static String login = "root";
    private static String pwd = "abc123...";
    static private Connection connection;
    
    static public PreparedStatement getPreparedStatement(String query){
        PreparedStatement pS = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, pwd);
            pS = connection.prepareStatement(query);
            }catch(Exception ex){
            ex.getMessage();
        }
        
        
    return pS;
}
        }
    
