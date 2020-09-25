package entite;

public class PanierContainer {
    
        Produit produit;
    int quantite;

    public PanierContainer(Produit produit, int quantite) {
        this.produit = produit;
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
    
    
}
