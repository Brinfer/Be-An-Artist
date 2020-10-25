package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Classe de test de base (avec asserts et non parametr�s) de la classe
 * {@link Cercle}.
 * 
 * @author gautiepi
 * 
 * @since 0.3.2.7
 */
public class CercleTest {

    // Couverture instruction pour l'ensemble des constructeur : 100%

    /**
     * Test de {@link Cercle#Cercle()}.
     * 
     * @since 0.3.2.7
     */
    @Test
    public void testConstructeurVide() {
        final Cercle cercle = new Cercle();

        final Coordonnees origine = new Coordonnees();

        assertEquals("Test de l'origine du cercle", origine, cercle.getPosition());
        assertEquals("Test de la hauteur du cercle", Forme.LARGEUR_PAR_DEFAUT, cercle.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur du cercle", cercle.getLargeur(), cercle.getLargeur(), Forme.EPSILON);
    }

    /**
     * Test de {@link Cercle#Cercle(Coordonnees)}.
     * 
     * @since 0.3.2.7
     */
    @Test
    public void testConstructeurCoordonnees() {
        final Coordonnees origine = new Coordonnees(5.0, 10.0);

        final Cercle cercle = new Cercle(origine);

        assertEquals("Test de l'origine du cercle", origine, cercle.getPosition());
        assertEquals("Test de la hauteur du cercle", Forme.LARGEUR_PAR_DEFAUT, cercle.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur du cercle", cercle.getLargeur(), cercle.getLargeur(), Forme.EPSILON);
    }

    /**
     * Test de {@link Cercle#Cercle(double)}.
     * 
     * @since 0.3.2.7
     */
    @Test
    public void testConstructeurTaille() {
        final double taille = 10.0;
        final Cercle cercle = new Cercle(taille);
        final Coordonnees origine = new Coordonnees();

        assertEquals("Test de l'origine du cercle", origine, cercle.getPosition());
        assertEquals("Test de la hauteur du cercle", taille, cercle.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur du cercle", taille, cercle.getLargeur(), Forme.EPSILON);
    }

    /**
     * Test de {@link Cercle#Cercle(Coordonnees, double)}.
     * 
     * @since 0.3.2.7
     */
    @Test
    public void testConstructeurPlein() {
        final double taille = 10.0;
        final Coordonnees origine = new Coordonnees();
        final Cercle cercle = new Cercle(origine, taille);

        assertEquals("Test de l'origine de l'Cercle", origine, cercle.getPosition());
        assertEquals("Test de la hauteur de l'Cercle", taille, cercle.getHauteur(), Forme.EPSILON);
        assertEquals("Test de la largeur de l'Cercle", taille, cercle.getLargeur(), Forme.EPSILON);
    }

    // Couverture instruction pour setHauteur() : 100%

    /**
     * Test de {@link Cercle#setHauteur(double)}
     * 
     * @since 0.3.2.7
     */
    @Test
    public void testSetHauteur() {
        final Cercle cercle = new Cercle();

        cercle.setHauteur(10);

        assertEquals("Test de la modification de la largeur", cercle.getLargeur(), cercle.getHauteur(), Forme.EPSILON);
    }

    // Couverture instruction pour setLargeur : 100%
    /**
     * Test de {@link Cercle#setLargeur(double)}
     */
    @Test
    public void testSetLargeur() {
        final Cercle cercle = new Cercle();

        cercle.setLargeur(10);

        assertEquals("Test de la modification de la hauteur", cercle.getLargeur(), cercle.getHauteur(), Forme.EPSILON);
    }

    /**
     * Test de {@link Cercle#setHauteur(double)} avec une hauteur inférieur à 0.
     * L'erreur {@link IllegalArgumentException} est attendue.
     * 
     * @since 0.3.2.7
     */
    public void testSetHauteurError() throws IllegalArgumentException {
        Cercle cercle = new Cercle();
        assertThrows(IllegalArgumentException.class, () -> cercle.setHauteur(-10));
        assertThrows(IllegalArgumentException.class, () -> cercle.setHauteur(0));
    }

    /**
     * Test de {@link Cercle#setLargeur(double)} avec une largeur égale à 0.
     * L'erreur {@link IllegalArgumentException} est attendue.
     * 
     * @since 0.3.2.7
     */
    @Test
    public void testSetLargeurError() throws IllegalArgumentException {
        Cercle cercle = new Cercle();
        assertThrows(IllegalArgumentException.class, () -> cercle.setLargeur(-10));
        assertThrows(IllegalArgumentException.class, () -> cercle.setLargeur(0));
    }

}
