/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import action.ActProduct;
import action.CategorieAction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kadjogno
 */
@WebServlet(name = "ProduitsControleur", urlPatterns = {"/produitsControleur"})
public class ProduitsControleur extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProduitsControleur</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProduitsControleur at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Enumeration<String> parametersName =  request.getParameterNames();
        String redirection = "";
        String id_ctg = "";
        while (parametersName.hasMoreElements()) {
            String nextElement = parametersName.nextElement();
            if(nextElement.equals("id_pr")){
                id_ctg = request.getParameter(nextElement);
                ActProduct.getProduit(request, response, Integer.parseInt(id_ctg));
                redirection = "WEB-INF/product.jsp";
            }else{
                id_ctg = request.getParameter(nextElement);
                ActProduct.getProduits(request, Integer.parseInt(id_ctg));
                CategorieAction.getByCategorieId(request, Integer.parseInt(id_ctg));
                redirection = "WEB-INF/products.jsp";
            }
            
            request.getRequestDispatcher(redirection).forward(request, response);
            
            
        }
        
       
        
    }



}
