package manager;

import entite.Produit;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class DernierProduitVisiteManager {
    
     static public ArrayList<Produit> getProduit(Cookie[] cookies) {
        ArrayList<Produit> produitList = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("dernier_produit_visite")) {
                String idProduitTemp = cookie.getValue();
                // nb Produit dans le cookie Panier
                String[] tabNbIdProduit = idProduitTemp.split("/");
                // Recuperation de chaque produit id dans le cookie Panier
                for (String IdProduit : tabNbIdProduit) {
                    produitList.add(ProduitManager.getProduitByProduitId(Integer.parseInt(IdProduit)));
                }

            }
        }

        return produitList;
    }
     
     static public void addToDernierProduitVisite(HttpServletResponse response, Cookie[] cookies, int IdProduit) {
        String IdProduitEnChaineDeCharactere = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("dernier_produit_visite")) {
                String idProduitTemp = cookie.getValue();
                // nb Produit dans le cookie Panier
                String[] tabNbIdProduit = idProduitTemp.split("/");
                for (String string : tabNbIdProduit) {
                    IdProduitEnChaineDeCharactere += string;
                }
                IdProduitEnChaineDeCharactere += String.valueOf(IdProduit) + "/";
                CookieManager.setCookie(response, "dernier_produit_visite", IdProduitEnChaineDeCharactere);
            }
        }

    }
}
