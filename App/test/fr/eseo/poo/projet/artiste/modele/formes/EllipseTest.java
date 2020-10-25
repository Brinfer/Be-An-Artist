package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Classe de test de base (avec asserts et non parametré) de la classe
 * {@link Ellipse}.
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.7
 */
public class EllipseTest {

    // Couverture instruction pour l'ensemble des constructeurs : 100%

    /**
     * Test de {@link Ellipse#Ellipse()}
     * 
     * @since 0.3.2.7
     */
    @Test
    public void testConstructeurVide() {
        final Ellipse ellipse = new Ellipse();

        final Coordonnees origine = new Coordonnees();

        assertEquals("Test de l'origine de l'ellipse", origine, ellipse.getPosition());
        assertEquals("Test de la hauteur de la ellipse", Forme.HAUTEUR_PAR_DEFAUT, ellipse.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur de la ellipse", Forme.LARGEUR_PAR_DEFAUT, ellipse.getLargeur(), Forme.EPSILON);
    }

    /**
     * Test de {@link Ellipse#Ellipse(Coordonnees)}
     * 
     * @since 0.3.2.7
     */
    @Test
    public void testConstructeurCoordonnees() {
        final Coordonnees origine = new Coordonnees(5.0, 10.0);

        final Ellipse ellipse = new Ellipse(origine);

        assertEquals("Test de l'origine de l'ellipse", origine, ellipse.getPosition());
        assertEquals("Test de la hauteur de l'ellipse", Forme.HAUTEUR_PAR_DEFAUT, ellipse.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur de l'ellipse", Forme.LARGEUR_PAR_DEFAUT, ellipse.getLargeur(), Forme.EPSILON);
    }

    /**
     * Test de {@link Ellipse#Ellipse(double, double)}
     * 
     * @since 0.3.2.7
     */
    @Test
    public void testConstructeurHauteurLargeur() {
        final double hauteur = 10.0;
        final double largeur = 15.0;
        final Ellipse ellipse = new Ellipse(largeur, hauteur);
        final Coordonnees origine = new Coordonnees();

        assertEquals("Test de l'origine de l'ellipse", origine, ellipse.getPosition());
        assertEquals("Test de la hauteur de l'ellipse", hauteur, ellipse.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur de l'ellipse", largeur, ellipse.getLargeur(), Forme.EPSILON);
    }

    /**
     * Test de {@link Ellipse#Ellipse(Coordonnees, double, double)}
     * 
     * @since 0.3.2.7
     */
    @Test
    public void testConstructeurPlein() {
        final double hauteur = 10.0;
        final double largeur = 15.0;
        final Coordonnees origine = new Coordonnees();
        final Ellipse ellipse = new Ellipse(origine, largeur, hauteur);

        assertEquals("Test de l'origine de l'ellipse", origine, ellipse.getPosition());
        assertEquals("Test de la hauteur de l'ellipse", hauteur, ellipse.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur de l'ellipse", largeur, ellipse.getLargeur(), Forme.EPSILON);
    }

    // Couverture instruction pour setHauteur : 100%
    // Couverture branches pour setHauteur : 100%

    /**
	 * Test de {@link Ellipse#setHauteur(double)} avec une hauteur inférieur à 0.
	 * L'erreur {@link IllegalArgumentException} est attendue.
	 * 
	 * @since 0.3.2.7
	 */
	@Test
	public void testSetHauteurError() throws IllegalArgumentException {
        Ellipse ellipse = new Ellipse();
        assertThrows(IllegalArgumentException.class, () -> ellipse.setHauteur(-10));
        assertThrows(IllegalArgumentException.class, () -> ellipse.setHauteur(0));
	}

    // Couverture instruction pour setLargeur : 100%
    // Couverture branches pour setLargeur : 100%

    /**
     * Test de {@link Ellipse#setLargeur(double)} avec une largeur égale à 0.
     * L'erreur {@link IllegalArgumentException} est attendue.
     * 
     * @since 0.3.2.7
     */
    @Test
    public void testSetLargeurError() throws IllegalArgumentException {
        Ellipse ellipse = new Ellipse();
        assertThrows(IllegalArgumentException.class, () -> ellipse.setLargeur(-10));
        assertThrows(IllegalArgumentException.class, () -> ellipse.setLargeur(0));
    }
}
