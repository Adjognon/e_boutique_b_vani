package manager;

import entite.Categorie;
import entite.Produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import service.ConnexionDB;

public class ProduitManager {
    
    
     static public ArrayList<Produit> getByCategorieId(int categorieId){
        String query = "select * from produit where categorie_id =?";
        ArrayList<Produit> produitList = new ArrayList<>();
        try{
        PreparedStatement pS = ConnexionDB.getPreparedStatement(query);
        pS.setInt(1, categorieId);
        ResultSet resultSet = pS.executeQuery();
        while(resultSet.next()){
            Produit produit = new Produit(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getString("url_image"), resultSet.getString("description"), resultSet.getInt("quantite"), resultSet.getDouble("prix"));
            produitList.add(produit);
        }
        
        }catch(Exception ex){
            ex.getMessage();
        }
        
        return produitList;
    }
     
     
     static public Produit getProduitByProduitId(int produitId){
        String query = "select * from produit where id =?";
        Produit produit = null;
        try{
        PreparedStatement pS = ConnexionDB.getPreparedStatement(query);
        pS.setInt(1, produitId);
        ResultSet resultSet = pS.executeQuery();
        resultSet.next();
        produit = new Produit(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getString("url_image"), resultSet.getString("description"), resultSet.getInt("quantite"), resultSet.getDouble("prix"));
        
        }catch(Exception ex){
            ex.getMessage();
        }
        
        return produit;
    }
    
    
}
