/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.CookieManager;
import manager.DernierProduitVisiteManager;
import manager.ProduitManager;

/**
 *
 * @author kadjogno
 */
public class ActProduct {
    
     static public void getProduits(HttpServletRequest request, int categorieId){
        request.setAttribute("produits", ProduitManager.getByCategorieId(categorieId));
    }
    
     static public void getProduit(HttpServletRequest request, HttpServletResponse response, int produitId){
        request.setAttribute("produit", ProduitManager.getProduitByProduitId(produitId));
         DernierProduitVisiteManager.addToDernierProduitVisite(response, CookieManager.getCookie(request), produitId);
    }
}
