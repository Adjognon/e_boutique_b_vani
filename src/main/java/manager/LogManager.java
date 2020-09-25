package manager;

import entite.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ConnexionDB;

public class LogManager {

    static public User getUtilisateur(String email, String motDePasse) {
        User utilisateur = null;
        String query = "select * from utilisateur where email like ? and mot_de_passe like ?";
        PreparedStatement preparestatement;
        try {
            preparestatement = ConnexionDB.getPreparedStatement(query);
            preparestatement.setString(1, email);
            preparestatement.setString(2, motDePasse);
            ResultSet rs = preparestatement.executeQuery();
            while (rs.next()) {
                utilisateur = new User(rs.getString("email"), rs.getString("mot_de_passe"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(LogManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return utilisateur;

    }

    static public boolean addUtilisateur(String email, String motDePasse) {
        String query = "insert into utilisateur(email,mot_de_passe) values(?,?)";
        PreparedStatement preparestatement;
        int nbModification = 0;
        try {
            preparestatement = ConnexionDB.getPreparedStatement(query);
            preparestatement.setString(1, email);
            preparestatement.setString(2, motDePasse);
            nbModification = preparestatement.executeUpdate();
            

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return nbModification > 0;

    }
    
    
    
    
    
    
    static public int getUtilisateurByEmailAndByMotDePass(String email, String motDePasse) {
        String query = "select id from utilisateur where email like ? and mot_de_passe like ?";
        PreparedStatement preparestatement;
        int idUtilisateur = 0;
        try {
            preparestatement = ConnexionDB.getPreparedStatement(query);
            preparestatement.setString(1, email);
            preparestatement.setString(2, motDePasse);
            ResultSet rs = preparestatement.executeQuery();
             while (rs.next()) {
                idUtilisateur = rs.getInt("id");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return idUtilisateur;

    }

}
