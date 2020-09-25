package controleur;

import action.CategorieAction;
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
import javax.servlet.http.HttpSession;
import manager.SessionManager;

@WebServlet(name = "LogControleur", urlPatterns = {"/logControleur"})
public class LogControleur extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rdr = request.getParameter("rdr");
        String redirection = "";

        switch (Integer.parseInt(rdr)) {

            case 0:
                redirection = "WEB-INF/login.jsp";
                break;

            case 1:
                redirection = "WEB-INF/signup.jsp";
                break;

            case 2:
                CategorieAction.getCategorie(request);
                redirection = "WEB-INF/index.jsp";
                break;

            case 3:
                SessionManager.destroySession(request, "utilisateur");
                CategorieAction.getCategorie(request);
                redirection = "WEB-INF/index.jsp";
                break;
            default:

                break;

        }

        request.getRequestDispatcher(redirection).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String redirection = "";
        Enumeration<String> type_of_log = request.getParameterNames();

        while (type_of_log.hasMoreElements()) {
            String nextElement = type_of_log.nextElement();

            if (nextElement.equals("login")) {

                User utilisateur = LogAction.recuperationUtilisateur(request, email, password);

                if (utilisateur != null) {
                    CategorieAction.getCategorie(request);
                    redirection = "WEB-INF/index.jsp";
                } else {
                    redirection = "WEB-INF/error.jsp";
                }

            } else if (nextElement.equals("signup")) {
                String password_2 = request.getParameter("password_2");

                if (password.equals(password_2)) {

                    User utilisateur = LogAction.addUtilisateur(request, email, password);
                    if (utilisateur != null) {
                        String msg = "<!DOCTYPE html>\n"
                                + "<html>\n"
                                + "    <head>\n"
                                + "        <title>B-Vani</title>\n"
                                + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                                + "    </head>\n"
                                + "    <body style=\"border:2px #333 solid;\">\n"
                                + "   <div style=\"background-color:#333; color:white; width:100%;padding:10px;\"><h2>B-Vani</h2> <h3></h3></div><br />\n"
                                + "<div style=\"width:35%; margin:auto;\">\n"
                                + "<div style=\"background-color:#ccc; padding:10px; text-align:center; width:100%; border-radius:2px #ccc solid;\">Confirmation d'inscription</div>\n"
                                + "	<h4>Juste pour vous confirmer que vous êtes abonné à la bijouterie en ligne B-Vani et nous vous remercions pour votre confiance. </h4>\n"
                                + "	<h4 style=\"text-decoration:underline; color:#333;\">Information sur le login </h4>\n"
                                + "<ul>\n"
                                + "\n"
                                + "	<li>Email: " + utilisateur.getEmail() + "</li>\n"
                                + "	<li>Mot de passe: " + utilisateur.getMot_de_passe() + "</li>\n"
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
                        CommandeAction.emailConfirmation(msg, "etudiant.isi.java2@gmail.com", "B-Vani Courriel de confirmation d'inscription");
                        CategorieAction.getCategorie(request);
                        redirection = "WEB-INF/index.jsp";
                    } else {
                        redirection = "WEB-INF/error.jsp";
                    }

                } else {
                    redirection = "WEB-INF/error.jsp";
                }

            }

        }

        request.getRequestDispatcher(redirection).forward(request, response);

    }
}
