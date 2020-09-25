/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import action.PanierAction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.SessionManager;

@WebServlet(name = "PanierControleur", urlPatterns = {"/panierControleur"})
public class PanierControleur extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionManager.setSession(req, "lastPageVisited", "cart.jsp");
        req.getRequestDispatcher("WEB-INF/cart.jsp").forward(req, resp);
    }


    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String redirection = "";
        Enumeration<String> parametersName = request.getParameterNames();
        
        while (parametersName.hasMoreElements()) {
            String nextElement = parametersName.nextElement();
            if(nextElement.equals("add_prd")){
             
                String pr_id = request.getParameter("add_prd");
                String prd_qt_selected = request.getParameter("prd_qt_selected");

                PanierAction.addProduitToPanier(request, Integer.parseInt(pr_id), Integer.parseInt(prd_qt_selected));
   
            }else if(nextElement.equals("upt_prd")){
             String pr_id = request.getParameter("upt_prd");
             String prd_qt_selected = request.getParameter("prd_qt_selected");
             PanierAction.updateProduitToPanier(request, Integer.parseInt(pr_id), Integer.parseInt(prd_qt_selected));
            }else if(nextElement.equals("rmv")){
                
             String pr_id = request.getParameter("rmv");
             PanierAction.removeProduitFromPanier(request, Integer.parseInt(pr_id));
            }
                
                
            }
        
            response.sendRedirect("panierControleur");
            
           
      
            
        }
        
        
    }



