package action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import manager.CookieManager;
import manager.DernierProduitVisiteManager;
import manager.ProduitManager;

public class DernierProduitVisite {
 static public void getProduits(HttpServletRequest request, int categorieId){
        request.setAttribute("dernier_produit_visite", DernierProduitVisiteManager.getProduit(CookieManager.getCookie(request)));
    }   
}
