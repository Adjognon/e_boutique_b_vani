package manager;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionManager {
    
    static public void setSession(HttpServletRequest request, String nomSession, Object valeur){
        HttpSession session = request.getSession();
        session.setAttribute(nomSession, valeur);
    }
    
    static public Object getSession(HttpServletRequest request, String nomSession){
       HttpSession session = request.getSession();
       return session.getAttribute(nomSession);
    }
    
    static public void destroySession(HttpServletRequest request, String nomSession){
       HttpSession session = request.getSession();
       session.invalidate();
    }
    
    
}
