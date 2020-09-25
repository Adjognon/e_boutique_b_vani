package entite;

public class Produit {
    
    int id;
    String nom;
    String urlImage;
    String description;
    int quantite;
    double prix;

    public Produit(int id, String nom, String urlImage, String description, int quantite, double prix) {
        this.id = id;
        this.nom = nom;
        this.urlImage = urlImage;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
    }
    
    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getUrlImage() {
        return urlImage;
    }

    
    
}
