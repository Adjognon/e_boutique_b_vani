package controleur;

import action.CategorieAction;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CategorieControleur", urlPatterns = {"/categorieControleur"})
public class CategorieControleur extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            CategorieAction.getCategorie(request);
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
          
    }
   

   

}
