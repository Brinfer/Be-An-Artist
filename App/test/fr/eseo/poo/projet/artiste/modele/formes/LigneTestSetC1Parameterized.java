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
 * Classe de test parametree de {@link Ligne#setC1(Coordonnees)}
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.5
 */
@RunWith(Parameterized.class)
public class LigneTestSetC1Parameterized {

    /**
     * Attribue representant la ligne que l'on veut tester.
     */
    private final Ligne ligne;

    /**
     * Attribue representant la nouvelle position de la l'extremite 1 de la ligne.
     */
    private final Coordonnees coordonnees;

    /**
     * Attribue représentant les dimension de la ligne aprè modification
     */
    private final double largeur, hauteur;

    /**
     * Constructeur pour chaque donnee de test.
     * 
     * @param coordonnees la nouvelle position de la l'extremite 1 de la ligne.
     * @param ligne       la ligne que l'on veut tester.
     */
    public LigneTestSetC1Parameterized(final Ligne ligne, final Coordonnees coordonnees, double largeur,
            double hauteur) {
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
    @Parameters(name = "dt[{index}] : {0}, {1}, {2}, {3}, {4}, {5}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // Position de c1 pour la mettre en (5, 5).
                { new Ligne(0, 0), new Coordonnees(5, 5), -5, -5 },
                // Position de c1 pour la mettre en (5, 5).
                { new Ligne(1, 1), new Coordonnees(5, 5), -4, -4 },
                // Position de c1 pour la mettre en (5, 5).
                { new Ligne(-1, -1), new Coordonnees(5, 5), -6, -6 },
                // Position de c1 pour la mettre en (5, 5).
                { new Ligne(1, -1), new Coordonnees(5, 5), -4, -6 },
                // Position de c1 pour la mettre en (-5, -5).
                { new Ligne(1, 1), new Coordonnees(-5, -5), 6, 6 },
                // Position de c1 pour la mettre en (5, -5).
                { new Ligne(1, 1), new Coordonnees(5, -5), -4, 6 },
                // Position de c1 pour la mettre en (5, 5).
                { new Ligne(9.8799, 2.789), new Coordonnees(5, 5), 4.8799, -2.211 } };
        return Arrays.asList(data);
    }

    // Couverture des instruction pour setC1 : 100%

    /**
     * Test de {@link Ligne#setC1(Coordonnees)}
     */
    @Test
    public void testSetC1() {
        final Coordonnees c2 = ligne.getC2();

        this.ligne.setC1(this.coordonnees);

        assertEquals("Test de la largeur", this.largeur, this.ligne.getLargeur(), Forme.EPSILON);
        assertEquals("Test de la hauteur", this.hauteur, this.ligne.getHauteur(), Forme.EPSILON);
        assertEquals("Test de madification de c1: ", this.coordonnees, ligne.getC1());
        assertEquals("Verification que c2 n'a pas bouge: ", c2, ligne.getC2());
    }
}