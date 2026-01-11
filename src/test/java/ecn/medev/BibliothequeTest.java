package ecn.medev;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour la classe Bibliotheque
 * @author Oussama Kazoubi
 */
class BibliothequeTest {

    private Bibliotheque biblio;

    @BeforeEach
    void setUp() {
        biblio = new Bibliotheque("Test Library");
        biblio.ajouterLivre(new Livre("123", "Book1", "Author1", 2020));
        biblio.ajouterLivre(new Livre("456", "Book2", "Author2", 2021));
    }

    @Test
    void testAjouterLivre() {
        assertEquals(2, biblio.getLivres().size());
    }

    @Test
    void testRechercherParISBN() {
        Livre livre = biblio.rechercherParISBN("123");
        assertNotNull(livre);
        assertEquals("Book1", livre.getTitre());
    }

    @Test
    void testRechercherParISBNInexistant() {
        Livre livre = biblio.rechercherParISBN("999");
        assertNull(livre);
    }

    @Test
    void testCompterLivresDisponibles() {
        assertEquals(2, biblio.compterLivresDisponibles());
        biblio.rechercherParISBN("123").emprunter();
        assertEquals(1, biblio.compterLivresDisponibles());
    }
}