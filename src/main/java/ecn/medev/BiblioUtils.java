package ecn.medev;

/**
 * Classe utilitaire pour la gestion de bibliothèque
 * @author Imane Laasri
 * @version 1.0
 */
public class BiblioUtils {

    /**
     * Constructeur privé pour empêcher l'instanciation
     */
    private BiblioUtils() {
        throw new UnsupportedOperationException("Classe utilitaire");
    }

    /**
     * Vérifie si un ISBN est valide (format simple : 13 chiffres)
     * @param isbn le code ISBN à vérifier
     * @return true si l'ISBN est valide, false sinon
     */
    public static boolean isValidISBN(String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            return false;
        }

        // Enlever les tirets et espaces
        String cleanISBN = isbn.replaceAll("[-\\s]", "");

        // Vérifier que c'est 13 chiffres
        if (cleanISBN.length() != 13) {
            return false;
        }

        // Vérifier que ce sont bien des chiffres
        return cleanISBN.matches("\\d{13}");
    }

    /**
     * Calcule le nombre de jours de retard pour un emprunt
     * @param joursEmpruntes nombre de jours depuis l'emprunt
     * @param dureeMaximale durée maximale autorisée en jours
     * @return le nombre de jours de retard (0 si pas de retard)
     * @throws IllegalArgumentException si les paramètres sont négatifs
     */
    public static int calculerJoursRetard(int joursEmpruntes, int dureeMaximale) {
        if (joursEmpruntes < 0 || dureeMaximale < 0) {
            throw new IllegalArgumentException("Les durées ne peuvent pas être négatives");
        }

        int retard = joursEmpruntes - dureeMaximale;
        return Math.max(0, retard);
    }

    /**
     * Calcule les frais de retard
     * @param joursRetard nombre de jours de retard
     * @param tarifParJour tarif par jour de retard en euros
     * @return le montant des frais en euros
     * @throws IllegalArgumentException si les paramètres sont négatifs
     */
    public static double calculerFraisRetard(int joursRetard, double tarifParJour) {
        if (joursRetard < 0 || tarifParJour < 0) {
            throw new IllegalArgumentException("Les valeurs ne peuvent pas être négatives");
        }

        return joursRetard * tarifParJour;
    }
}