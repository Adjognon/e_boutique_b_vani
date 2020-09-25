package action;

import javax.servlet.http.HttpServletRequest;
import manager.AnnonceManager;

public class AnnonceAction {
    
    static public void getAnnonce(HttpServletRequest request, int categorieId){
        
        request.setAttribute("annonce", AnnonceManager.getAnnonceByCategorieId(categorieId));
        
    }
    
}
