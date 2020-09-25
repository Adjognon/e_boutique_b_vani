package action;

import entite.User;
import javax.servlet.http.HttpServletRequest;
import manager.LogManager;
import manager.LogManager;
import manager.SessionManager;

public class LogAction {

    static public User recuperationUtilisateur(HttpServletRequest request, String email, String motDePasse) {
        User utilisateur = LogManager.getUtilisateur(email, motDePasse);
        SessionManager.setSession(request, "utilisateur", utilisateur);
    return utilisateur;
    }
    
    static public User addUtilisateur(HttpServletRequest request, String email, String motDePasse) {
        
        User utilisateur = null;
        
        if(LogManager.addUtilisateur(email, motDePasse) == true){
            
            utilisateur = new User(email, motDePasse);
            
        }
       
        SessionManager.setSession(request, "utilisateur", utilisateur);
    return utilisateur;
    }
    
    static public int getUtilisateurByEmaulAndByMotDePass(String email, String motDePasse){
        
        return LogManager.getUtilisateurByEmailAndByMotDePass(email, motDePasse);
        
    }

}   
