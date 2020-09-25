/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entite.Produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import service.ConnexionDB;

/**
 *
 * @author kadjogno
 */
public class CheckoutManager {
  
    static public void newCommande(int id_utilisateur){
  
        String query = "insert into commande(id_utilisateur) values(?)";
 
        try{
        PreparedStatement pS = ConnexionDB.getPreparedStatement(query);
        pS.setInt(1, id_utilisateur);
        pS.executeUpdate();
        }catch(Exception ex){
            
           ex.getMessage();
        }
        
     }

    }
        
