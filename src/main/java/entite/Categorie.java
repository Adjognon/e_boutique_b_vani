package entite;

public class Categorie {
   
    int id;
    String nom;
    String urlImage;

    public Categorie(int id, String nom, String urlImage) {
        this.id = id;
        this.nom = nom;
        this.urlImage = urlImage;
    }
    
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getUrlImage() {
        return urlImage;
    }
    
    
    
}
