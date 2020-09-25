package action;

import javax.servlet.http.HttpServletRequest;
import manager.PanierManager;
import entite.Produit;
import manager.SessionManager;

public class PanierAction {
    static public void getPanier(HttpServletRequest request){
        PanierManager.getPanier(SessionManager.getSession(request, "panier"));
    }
    static public void getNbProduitDsPanier(HttpServletRequest request){
        request.setAttribute("nbProduitDansPanier", PanierManager.getNbProduitDsPanier(SessionManager.getSession(request, "panier")));
    }
     
    static public void addProduitToPanier(HttpServletRequest request, int produitId, int qt){
        PanierManager.addToPanier(request, produitId, qt);
    }
    
    static public void removeProduitFromPanier(HttpServletRequest request, int produitId){
        PanierManager.removeFromPanier(request, produitId);
    }
    
    static public void updateProduitToPanier(HttpServletRequest request, int produitId, int qt){
        PanierManager.updateInPanier(request, produitId, qt);
    }
    
    

}
