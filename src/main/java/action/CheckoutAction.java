/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import javax.servlet.http.HttpServletRequest;
import manager.CheckoutManager;

/**
 *
 * @author kadjogno
 */
public class CheckoutAction {
    static public void checkoutCommande(int id_utilisateur){
        CheckoutManager.newCommande(id_utilisateur);
    }
    
}
