package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertTrue;

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
public class LigneTestContientTrueParameterized {

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
     */
    public LigneTestContientTrueParameterized(final Ligne ligne, final Coordonnees coordonnees) {
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
                // Le troisième point est possitionné en (0, 0), il est sur la ligne.
                { new Ligne(0, 0), new Coordonnees() },
                // Le troisième est point possitionné en (5.68, 5.33), il est sur la ligne.
                { new Ligne(new Coordonnees(5.68, 5.33), 8.27, 5.17), new Coordonnees(5.68, 5.33) },
                // Le troisième est point possitionné en (10.78, 9.01), il est sur la ligne.
                { new Ligne(new Coordonnees(6.07574, 4.33543), 9.41, 9.35), new Coordonnees(10.78, 9.01) },
                // Le troisième est point possitionné en (9.82, 7.91), le milieu de la ligne,
                // il est sur la ligne.
                { new Ligne(new Coordonnees(5.68, 5.33), 8.27, 5.17), new Coordonnees(9.82, 7.91) },
                // Le troisième est point possitionné en (7.07, 6.19), il est sur la ligne.
                { new Ligne(new Coordonnees(5.68, 5.33), 8.27, 5.17), new Coordonnees(7.07, 6.19) },
                // Le troisième est point possitionné en (9.82469, 7.91106), à moins de 0.001
                // de la ligne, il est sur la ligne.
                { new Ligne(new Coordonnees(5.68, 5.33), 8.27, 5.17), new Coordonnees(9.82469, 7.91106) }, };
        return Arrays.asList(data);
    }

    // Couverture des instruction pour contient : 94%
    // Couverture des branches pour contient : 50%

    /**
     * Test de {@link Ligne#contient()}.
     */
    @Test
    public void testContientTrue() {
        assertTrue("Test de contient() : " + this.coordonnees.toString(), this.ligne.contient(this.coordonnees));
    }
}
