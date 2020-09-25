package action;

import javax.servlet.http.HttpServletRequest;
import manager.CategorieManager;

public class CategorieAction {
    
    static public void getCategorie(HttpServletRequest request){
        request.setAttribute("categorie", CategorieManager.getAll());
    }
    
    static public void getByCategorieId(HttpServletRequest request, int categorieI){
        request.setAttribute("unique_categorie", CategorieManager.getByCategorieId(categorieI));
    }
    
 

}
