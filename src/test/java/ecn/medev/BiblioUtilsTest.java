package ecn.medev;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitaires pour la classe BiblioUtils
 * @author Oussama Kazoubi
 */
class BiblioUtilsTest {

    @Test
    @DisplayName("ISBN valide avec 13 chiffres")
    void testISBNValide() {
        assertTrue(BiblioUtils.isValidISBN("9782123456803"));
        assertTrue(BiblioUtils.isValidISBN("978-2-1234-5680-3"));
        assertTrue(BiblioUtils.isValidISBN("978 2 1234 5680 3"));
    }

    @Test
    @DisplayName("ISBN invalide")
    void testISBNInvalide() {
        assertFalse(BiblioUtils.isValidISBN(null));
        assertFalse(BiblioUtils.isValidISBN(""));
        assertFalse(BiblioUtils.isValidISBN("123")); // Trop court
        assertFalse(BiblioUtils.isValidISBN("12345678901234")); // Trop long
        assertFalse(BiblioUtils.isValidISBN("978212345680A")); // Contient une lettre
    }

    @Test
    @DisplayName("Calcul jours de retard - pas de retard")
    void testPasDeRetard() {
        assertEquals(0, BiblioUtils.calculerJoursRetard(10, 14));
        assertEquals(0, BiblioUtils.calculerJoursRetard(14, 14));
    }

    @Test
    @DisplayName("Calcul jours de retard - avec retard")
    void testAvecRetard() {
        assertEquals(3, BiblioUtils.calculerJoursRetard(17, 14));
        assertEquals(10, BiblioUtils.calculerJoursRetard(24, 14));
    }

    @Test
    @DisplayName("Calcul jours de retard - valeurs négatives")
    void testJoursRetardValeursNegatives() {
        assertThrows(IllegalArgumentException.class,
                () -> BiblioUtils.calculerJoursRetard(-5, 14));
        assertThrows(IllegalArgumentException.class,
                () -> BiblioUtils.calculerJoursRetard(10, -14));
    }

    @Test
    @DisplayName("Calcul frais de retard")
    void testCalculFraisRetard() {
        assertEquals(0.0, BiblioUtils.calculerFraisRetard(0, 0.5));
        assertEquals(1.5, BiblioUtils.calculerFraisRetard(3, 0.5));
        assertEquals(5.0, BiblioUtils.calculerFraisRetard(10, 0.5));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10, 20})
    @DisplayName("Test paramétré - frais avec tarif 0.50€")
    void testFraisParametre(int jours) {
        double frais = BiblioUtils.calculerFraisRetard(jours, 0.50);
        assertEquals(jours * 0.50, frais);
        assertTrue(frais >= 0);
    }
}