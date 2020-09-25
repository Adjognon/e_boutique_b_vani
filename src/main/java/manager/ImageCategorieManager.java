package manager;

import entite.Produit;
import entite.ImageCategorie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import service.ConnexionDB;

public class ImageCategorieManager {
    
    static public ImageCategorie getImageByCategorieId(int categorieId){
        String query = "select * from categorie_image where categorie_id =?";
        ImageCategorie imageCategorie = null;
        try{
        PreparedStatement pS = ConnexionDB.getPreparedStatement(query);
        pS.setInt(1, categorieId);
        ResultSet resultSet = pS.executeQuery();
        resultSet.next();
        imageCategorie = new ImageCategorie(resultSet.getString("url_image"));
        
        }catch(Exception ex){
            ex.getMessage();
        }
        
        return imageCategorie;
    }
    
}
