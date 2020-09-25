package manager;

import entite.ImageCategorie;
import entite.Produit;
import entite.PanierContainer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.ConnexionDB;

public class PanierManager {
    
    static HashMap<String, PanierContainer> panier = null;

    static public HashMap<String, PanierContainer> getPanier(Object session) {
      return panier = (HashMap<String, PanierContainer>) session;
    }

    static public int getNbProduitDsPanier(Object session) {
        int nbProduitDsPanier = 0;
        panier = (HashMap<String, PanierContainer>) session;
        
        if(panier != null){
        
        for (HashMap.Entry<String, PanierContainer> panierContainerEntry : panier.entrySet()) {
                PanierContainer  panierContainer = panierContainerEntry.getValue();
                nbProduitDsPanier += panierContainer.getQuantite();
           }
    }
        return nbProduitDsPanier;
    }

    static public void addToPanier(HttpServletRequest request, int produitId, int qt){
        Produit produit = ProduitManager.getProduitByProduitId(produitId);
        boolean productFoundInPanier = false;
        
        if(panier == null){
           panier = new HashMap<>(); 
           panier.put(produit.getNom(), new PanierContainer(produit, qt));
           SessionManager.setSession(request, "panier", panier);
        }else{
            
            HashMap<String, PanierContainer> ancienPanier = (HashMap<String, PanierContainer>) SessionManager.getSession(request, "panier");
            if(ancienPanier.size() == 0){
               ancienPanier.put(produit.getNom(), new PanierContainer(produit, qt));
               SessionManager.setSession(request, "panier", ancienPanier); 
            }else{
            for (HashMap.Entry<String, PanierContainer> entry : ancienPanier.entrySet()) {
                PanierContainer value = entry.getValue();
                if(value.getProduit().getId() == produit.getId()){
                   Produit produitModifier = value.getProduit();
                   int nouvelleQt = value.getQuantite() + qt;
                   PanierContainer nouveauPanierContainer = new PanierContainer(produitModifier, nouvelleQt);
                   ancienPanier.remove(produitModifier.getNom());
                   ancienPanier.put(produitModifier.getNom(), nouveauPanierContainer);
                   SessionManager.setSession(request, "panier", ancienPanier);
                   productFoundInPanier = true;
                }
                
            }
            if(productFoundInPanier == false){
                ancienPanier.put(produit.getNom(), new PanierContainer(produit, qt));
               SessionManager.setSession(request, "panier", ancienPanier); 
            }
            }
        }
        

    }
    
    
    
    static public void updateInPanier(HttpServletRequest request, int produitId, int qt){
        Produit produit = ProduitManager.getProduitByProduitId(produitId);
        
        if(panier == null){
           panier = new HashMap<>(); 
           panier.put(produit.getNom(), new PanierContainer(produit, qt));
           SessionManager.setSession(request, "panier", panier);
        }else{
            HashMap<String, PanierContainer> ancienPanier = (HashMap<String, PanierContainer>) SessionManager.getSession(request, "panier");
            
            for (HashMap.Entry<String, PanierContainer> entry : ancienPanier.entrySet()) {
                PanierContainer value = entry.getValue();
                if(value.getProduit().getId() == produit.getId()){
                   Produit produitModifier = value.getProduit();
                   PanierContainer nouveauPanierContainer = new PanierContainer(produitModifier, qt);
                   ancienPanier.remove(produitModifier.getNom());
                   ancienPanier.put(produitModifier.getNom(), nouveauPanierContainer);
                   SessionManager.setSession(request, "panier", ancienPanier);
                }
                
            }
        }
        

    }
    
    
    static public void removeFromPanier(HttpServletRequest request, int produitId){
        Produit produit = ProduitManager.getProduitByProduitId(produitId);
        HashMap<String, PanierContainer> ancienPanier = (HashMap<String, PanierContainer>) SessionManager.getSession(request, "panier");
        if(ancienPanier != null){
            ancienPanier.remove(produit.getNom());
            SessionManager.setSession(request, "panier", ancienPanier);
        }
    }

}
