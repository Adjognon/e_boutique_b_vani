/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import action.CategorieAction;
import action.CheckoutAction;
import action.CommandeAction;
import action.LogAction;
import entite.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manager.MailManager;
import manager.SessionManager;

@WebServlet(name = "CheckoutControleur", urlPatterns = {"/checkoutControleur"})
public class CheckoutControleur extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Enumeration<String> parametersNames = request.getParameterNames();
        String redirection = "";
        String prix = "";
        String quantiteSelectione = "";
        double prix_total = 0;

        while (parametersNames.hasMoreElements()) {
            String nextElement = parametersNames.nextElement();
            if (nextElement.equals("prixProduit")) {
                prix = request.getParameter("prixProduit");
                quantiteSelectione = request.getParameter("prd_qt_selected");
                prix_total = Double.parseDouble(prix) * Integer.parseInt(quantiteSelectione);
                request.setAttribute("prixTotalProduit", prix_total);
                redirection = "WEB-INF/checkout.jsp";
                User utilisateur = (User) SessionManager.getSession(request, "utilisateur");
                if (utilisateur != null) {
                    redirection = "WEB-INF/checkout.jsp";
                } else {
                    redirection = "WEB-INF/login.jsp";

                }

            } else if (nextElement.equals("prixPanier")) {

                prix = request.getParameter("prixPanier");
                request.setAttribute("prixTotalProduit", Double.parseDouble(prix));
                User utilisateur = (User) SessionManager.getSession(request, "utilisateur");
                if (utilisateur != null) {
                    redirection = "WEB-INF/checkout.jsp";
                } else {
                    redirection = "WEB-INF/login.jsp";

                }

            } else if (nextElement.equals("commande")) {
                prix = request.getParameter("prixTotalAPaye");
                User utilisateur = (User) SessionManager.getSession(request, "utilisateur");
                
                int idUtilisateur = LogAction.getUtilisateurByEmaulAndByMotDePass(utilisateur.getEmail(), utilisateur.getMot_de_passe());
                CheckoutAction.checkoutCommande(idUtilisateur);
                String msg = "<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "    <head>\n"
                        + "        <title>B-Vani</title>\n"
                        + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                        + "    </head>\n"
                        + "    <body style=\"border:2px #333 solid;\">\n"
                        + "   <div style=\"background-color:#333; color:white; width:100%;padding:10px;\"><h2>B-Vani</h2> <h3></h3></div><br />\n"
                        + "<div style=\"width:35%; margin:auto;\">\n"
                        + "<div style=\"background-color:#ccc; padding:10px; text-align:center; width:100%; border-radius:2px #ccc solid;\">Confirmation de commande</div>\n"
                        + "<ul>\n"
                        + "\n"
                        + "	<li>Email: "+utilisateur.getEmail()+"</li>\n"
                        + "	<li>Prix total a payé: "+prix+" $ CAD</li>\n"
                        + "	\n"
                        + "	<h4>Adresse</h4>\n"
                        + "  <li>Pays: Canada</li>\n"
                        + "	<li>Ville: Montreal</li>\n"
                        + "	\n"
                        + "  \n"
                        + "</ul>\n"
                        + "\n"
                        + "</div>"
                        + "    </body>\n"
                        + "</html>";
                CommandeAction.emailConfirmation(msg, "etudiant.isi.java2@gmail.com", "B-Vani Courriel de confirmation de commande d'articles");
                CategorieAction.getCategorie(request);
                redirection = "WEB-INF/index.jsp";

            }
        }

        request.getRequestDispatcher(redirection).forward(request, response);

    }

}
