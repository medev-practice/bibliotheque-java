package ecn.medev;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests pour la classe Livre
 * @author Imane Laasri
 */
class LivreTest {

    private Livre livre;

    @BeforeEach
    void setUp() {
        livre = new Livre("978-2-1234-5680-3", "Test Book", "Test Author", 2020);
    }

    @Test
    void testCreationLivre() {
        assertEquals("978-2-1234-5680-3", livre.getIsbn());
        assertEquals("Test Book", livre.getTitre());
        assertEquals("Test Author", livre.getAuteur());
        assertEquals(2020, livre.getAnneePublication());
        assertTrue(livre.isDisponible());
    }

    @Test
    void testEmprunter() {
        assertTrue(livre.emprunter());
        assertFalse(livre.isDisponible());
        assertEquals(1, livre.getNombreEmprunts());
    }

    @Test
    void testEmprunterDejaEmprunte() {
        livre.emprunter();
        assertFalse(livre.emprunter());
    }

    @Test
    void testRetourner() {
        livre.emprunter();
        livre.retourner();
        assertTrue(livre.isDisponible());
    }

    @Test
    void testEstPopulaire() {
        assertFalse(livre.estPopulaire());
        for (int i = 0; i < 12; i++) {
            livre.emprunter();
            livre.retourner();
        }
        assertTrue(livre.estPopulaire());
    }
}