package manager;
import entite.Categorie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import service.ConnexionDB;

public class CategorieManager {
    
    static public ArrayList<Categorie> getAll(){
        String query = "select * from categorie";
        ArrayList<Categorie> categorieList = new ArrayList<>();
        try{
        PreparedStatement pS = ConnexionDB.getPreparedStatement(query);
        ResultSet resultSet = pS.executeQuery();
        while(resultSet.next()){
            Categorie categorie = new Categorie(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getString("url_image"));
            categorieList.add(categorie);
        }
        
        }catch(Exception ex){
            ex.getMessage();
        }
        
        return categorieList;
    }
    
    
    
     static public Categorie getByCategorieId(int categorieId){
        String query = "select * from categorie where id = ?";
        Categorie categorie = null;
        try{
        PreparedStatement pS = ConnexionDB.getPreparedStatement(query);
        pS.setInt(1, categorieId);
        ResultSet resultSet = pS.executeQuery();
        while(resultSet.next()){
            categorie = new Categorie(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getString("url_image"));
        }
        
        }catch(Exception ex){
            ex.getMessage();
        }
        
        return categorie;
    }
    
}
