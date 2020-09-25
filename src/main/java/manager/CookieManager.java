package manager;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {
    
    static public void setCookie(HttpServletResponse response, String nomCookie, String valeur){
        Cookie cookie = new Cookie(nomCookie, valeur);
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
    }
    
    static public Cookie[] getCookie(HttpServletRequest request){
        return request.getCookies();
    }
    
    
    
}
