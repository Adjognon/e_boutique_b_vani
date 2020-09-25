package manager;

import entite.Annonce;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import service.ConnexionDB;

public class AnnonceManager {
    
     static public Annonce getAnnonceByCategorieId(int categorieId){
        String query = "select * from annonce where categorie_id =?";
        Annonce annonce = null;
        try{
            PreparedStatement pS = ConnexionDB.getPreparedStatement(query);
        pS.setInt(1, categorieId);
            ResultSet resultSet = pS.executeQuery();
        resultSet.next();
        annonce = new Annonce(resultSet.getString("url_image"));
        
        }catch(Exception ex){
            ex.getMessage();
        }
        
        return annonce;
    }
    
}
