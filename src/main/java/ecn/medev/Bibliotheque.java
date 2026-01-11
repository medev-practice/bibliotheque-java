package ecn.medev;

import java.util.ArrayList;
import java.util.List;

/**
 * Gère une collection de livres
 * @author Oussama Kazoubi
 */
public class Bibliotheque {

    private List<Livre> livres;
    private String nom;

    public Bibliotheque(String nom) {
        this.nom = nom;
        this.livres = new ArrayList<>();
    }

    public void ajouterLivre(Livre livre) {
        livres.add(livre);
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public String getNom() {
        return nom;
    }

    /**
     * Recherche un livre par ISBN
     */
    public Livre rechercherParISBN(String isbn) {
        for (int i = 0; i < livres.size(); i++) {
            if (livres.get(i).getIsbn().equals(isbn)) {
                return livres.get(i);
            }
        }
        return null;
    }

    /**
     * Recherche des livres par auteur
     */
    public List<Livre> rechercherParAuteur(String auteur) {
        List<Livre> resultats = new ArrayList<>();
        for (Livre livre : livres) {
            if (livre.getAuteur().toLowerCase().contains(auteur.toLowerCase())) {
                resultats.add(livre);
            }
        }
        return resultats;
    }

    /**
     * Compte les livres disponibles
     */
    public int compterLivresDisponibles() {
        int count = 0;
        for (Livre livre : livres) {
            if (livre.isDisponible()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Affiche les statistiques de la bibliothèque
     */
    public void afficherStatistiques() {
        System.out.println("=== Statistiques de " + nom + " ===");
        System.out.println("Nombre total de livres: " + livres.size());
        System.out.println("Livres disponibles: " + compterLivresDisponibles());
        System.out.println("Livres empruntés: " + (livres.size() - compterLivresDisponibles()));
    }
}