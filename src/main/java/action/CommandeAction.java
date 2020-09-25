/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;
import manager.MailManager;

/**
 *
 * @author kadjogno
 */
public class CommandeAction {
    
    static public void emailConfirmation(String msg, String to, String sujet){
        MailManager.sendEmail(msg, to, sujet);
    }
    
}
