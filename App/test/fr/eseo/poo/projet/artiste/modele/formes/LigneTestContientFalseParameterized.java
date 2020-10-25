package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Classe de test parametree de {@link Ligne#contient()}.
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.8
 */
@RunWith(Parameterized.class)
public class LigneTestContientFalseParameterized {

    /**
     * Attribut representant la ligne testée.
     */
    private final Ligne ligne;

    /**
     * Attribut representant le point à testé.
     */
    private final Coordonnees coordonnees;

    /**
     * Constructeur pour chaque donnee de test.
     * 
     * @param ligne       la ligne testée.
     * @param estContenue le point testé.
     * @param estContenue si le point testé est sur la ligne testée.
     */
    public LigneTestContientFalseParameterized(final Ligne ligne, final Coordonnees coordonnees) {
        this.ligne = ligne;
        this.coordonnees = coordonnees;
    }

    /**
     * Création du jeu de test.
     * 
     * @return l'ensemble des données de test.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // Le troisième est point possitionné en (8.19, 9.42), il n'est pas sur la
                // ligne.
                { new Ligne(new Coordonnees(5.68, 5.33), 8.27, 5.17), new Coordonnees(8.19, 9.42) },
                // Le troisième est point possitionné en (10.94, 6.25), il n'est pas sur la
                // ligne.
                { new Ligne(new Coordonnees(5.68, 5.33), 8.27, 5.17), new Coordonnees(10.94, 6.25) },
                // Le troisième est point possitionné en (2.57, 3.38), sur la droite confondue
                // avec la ligne, il n'est pas sur la ligne.
                { new Ligne(new Coordonnees(5.68, 5.33), 8.27, 5.17), new Coordonnees(2.57, 3.38) },
                // Le troisième est point possitionné en (15.07, 11.19), sur la droite
                // confondue avec la ligne, il n'est pas sur la ligne.
                { new Ligne(new Coordonnees(5.68, 5.33), 8.27, 5.17), new Coordonnees(15.07, 11.19) } };
        return Arrays.asList(data);
    }

    // Couverture des instruction pour contient : 89%
    // Couverture des branches pour contient : 50%

    /**
     * Test de {@link Ligne#contient()}.
     */
    @Test
    public void testContientFalse() {
        assertFalse("Test de contient() : " + this.coordonnees.toString(), this.ligne.contient(this.coordonnees));
    }
}
