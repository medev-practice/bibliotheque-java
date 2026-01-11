package ecn.medev;

/**
 * Représente un livre dans la bibliothèque
 * @author Imane Laasri
 * @version 1.0
 */
public class Livre {

    private String isbn;
    private String titre;
    private String auteur;
    private int anneePublication;
    private boolean disponible;
    private int nombreEmprunts;

    public Livre(String isbn, String titre, String auteur, int anneePublication) {
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.disponible = true;
        this.nombreEmprunts = 0;
    }

    // Getters
    public String getIsbn() { return isbn; }
    public String getTitre() { return titre; }
    public String getAuteur() { return auteur; }
    public int getAnneePublication() { return anneePublication; }
    public boolean isDisponible() { return disponible; }
    public int getNombreEmprunts() { return nombreEmprunts; }

    // Setters
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Emprunte le livre
     * @return true si l'emprunt a réussi
     */
    public boolean emprunter() {
        if (disponible) {
            disponible = false;
            nombreEmprunts++;
            return true;
        }
        return false;
    }

    /**
     * Retourne le livre
     */
    public void retourner() {
        disponible = true;
    }

    /**
     * Vérifie si le livre est populaire (plus de 10 emprunts)
     */
    public boolean estPopulaire() {
        if (nombreEmprunts > 10) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return titre + " par " + auteur + " (" + anneePublication + ") - ISBN: " + isbn;
    }
}