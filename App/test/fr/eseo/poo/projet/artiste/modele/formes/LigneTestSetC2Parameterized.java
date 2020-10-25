package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test parametree de {@link Ligne#setC2(Coordonnees)}
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.5
 */
@RunWith(Parameterized.class)
public class LigneTestSetC2Parameterized {

    /**
     * Attribue representant la ligne que l'on veut tester.
     */
    private final Ligne ligne;

    /**
     * Attribue représentant la nouvelle position de la l'extrémité 2 de la ligne.
     */
    private final Coordonnees coordonnees;

    /**
     * Attribue représentant les dimension de la ligne aprè modification
     */
    private final double largeur, hauteur;

    /**
     * Constructeur pour chaque donnee de test.
     * 
     * @param coordonnees la nouvelle position de la l'extrémité 2 de la ligne.
     * @param ligne       la ligne que l'on veut tester.
     */
    public LigneTestSetC2Parameterized(final Ligne ligne, final Coordonnees coordonnees, final double largeur,
            final double hauteur) {
        this.ligne = ligne;
        this.coordonnees = coordonnees;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    /**
     * Création du jeu de test.
     * 
     * @return l'ensemble des données de test.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // Position de c2 en (5, 5).
                { new Ligne(0, 0), new Coordonnees(5, 5), 5, 5 },
                // Position de c2 en (5, 5).
                { new Ligne(1, 1), new Coordonnees(5, 5), 5, 5 },
                // Position de c2 en (5, 5).
                { new Ligne(-1, -1), new Coordonnees(5, 5), 5, 5 },
                // Position de c2 en (5, 5).
                { new Ligne(1, -1), new Coordonnees(5, 5), 5, 5 },
                // Position de c2 en (-5, -5).
                { new Ligne(1, 1), new Coordonnees(-5, -5), -5, -5 },
                // Position de c2 en (5, -5).
                { new Ligne(1, 1), new Coordonnees(5, -5), 5, -5 },
                // Position de c2 en (11.56331, 6.97483), c1 dn.
                { new Ligne(1, 1), new Coordonnees(11.56331, 6.97483), 11.5633, 6.9748 },
                // Position de c2 en (-2.85954, 6.38336).
                { new Ligne(1, 1), new Coordonnees(-2.85954, 6.38336), -2.8595, 6.3834 } };
        return Arrays.asList(data);
    }

    // Couverture des instruction pour setC2 : 100%

    /**
     * Test de {@link Ligne#setC2(Coordonnees)}
     */
    @Test
    public void testSetC2() {
        final Coordonnees c1 = ligne.getC1();

        this.ligne.setC2(this.coordonnees);

        assertEquals("Test de la largeur", this.largeur, this.ligne.getLargeur(), Forme.EPSILON);
        assertEquals("Test de la hauteur", this.hauteur, this.ligne.getHauteur(), Forme.EPSILON);
        assertEquals("Test de de la modification de c2: ", this.coordonnees, ligne.getC2());
        assertEquals("Vérification de c1: ", c1, ligne.getC1());
    }
}