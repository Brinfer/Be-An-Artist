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
 * Classe de test parametree de {@link Ligne#getC2()}.
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.5
 */
@RunWith(Parameterized.class)
public class LigneTestGetC2Parameterized {

    /**
     * Attribue representant la ligne que l'on veut tester.
     */
    private final Ligne ligne;

    /**
     * Attribue representant la position attendue de l'autre extremite de la ligne.
     */
    private final Coordonnees coordonnees;

    /**
     * Constructeur pour chaque donnee de test.
     * 
     * @param coordonnees la largeur de la ligne
     * @param ligne       la hauteur de la ligne
     */
    public LigneTestGetC2Parameterized(final Ligne ligne, final Coordonnees coordonnees) {
        this.ligne = ligne;
        this.coordonnees = coordonnees;
    }

    /**
     * Creation du jeu de test.
     * 
     * @return l'ensemble des donnees de test.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // La deuxieme extremite de la ligne est attendue en (1, 1).
                { new Ligne(1, 1), new Coordonnees(1, 1) },
                // La deuxieme extremite de la ligne est attendue en (2, 2).
                { new Ligne(new Coordonnees(1, 1), 1, 1), new Coordonnees(2, 2) },
                // La deuxieme extremite de la ligne est attendue en (2, 1).
                { new Ligne(new Coordonnees(1, 0), 1, 1), new Coordonnees(2, 1) },
                // La deuxieme extremite de la ligne est attendue en (1, 2).
                { new Ligne(new Coordonnees(0, 1), 1, 1), new Coordonnees(1, 2) },
                // La deuxieme extremite de la ligne est attendue en (0, 0).
                { new Ligne(new Coordonnees(-1, -1), 1, 1), new Coordonnees(0, 0) },
                // La deuxieme extremite de la ligne est attendue en (-1, -1).
                { new Ligne(-1, -1), new Coordonnees(-1, -1) },
                // La deuxieme extremite de la ligne est attendue en (0, 0).
                { new Ligne(new Coordonnees(1, 1), -1, -1), new Coordonnees(0, 0) },
                // La deuxieme extremite de la ligne est attendue en (0, 0).
                { new Ligne(new Coordonnees(1, 0), -1, -1), new Coordonnees(0, -1) },
                // La deuxieme extremite de la ligne est attendue en (-1, 0).
                { new Ligne(new Coordonnees(0, 1), -1, -1), new Coordonnees(-1, 0) },
                // La deuxieme extremite de la ligne est attendue en (-2, -2).
                { new Ligne(new Coordonnees(-1, -1), -1, -1), new Coordonnees(-2, -2) },
                // La deuxieme extremite de la ligne est attendue en (-1, 0).
                { new Ligne(-1, 0), new Coordonnees(-1, 0) },
                // La deuxieme extremite de la ligne est attendue en (0, -1).
                { new Ligne(0, -1), new Coordonnees(0, -1) },
                // La deuxieme extremite de la ligne est attendue en (0, 0).
                { new Ligne(0, 0), new Coordonnees() },
                // La deuxieme extremite de la ligne est attendue en (9.87988, 2.78902).
                { new Ligne(new Coordonnees(4.37463, 9.8412), 5.5053, -7.0522), new Coordonnees(9.87988, 2.78902) } };
        return Arrays.asList(data);
    }

    // Couverture des instruction pour getC2 : 100%

    /**
     * Test de {@link Ligne#getC2()}.
     */
    @Test
    public void testGetC2() {
        assertEquals("Test de getC2: ", this.coordonnees, this.ligne.getC2());
    }
}