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
 * Classe de test parametree de {@link Ellipse#contient()}
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.8
 */
@RunWith(Parameterized.class)
public class EllipseTestContientFalseParameterized {

    /**
     * Attribut representant l'ellipse que l'on souhaite tester.
     */
    private final Ellipse ellipse;

    /**
     * Parametres representant le point dont on veut savoir s'il est dedans ou non
     * de ellipse.
     */
    private final Coordonnees coordonnees;


    /**
     * Constructeur pour chaque donnee de test.
     * 
     * @param ellipse         l'ellipse que l'on souhaite tester.
     * @param coordonnees     le point dont on veut savoir s'il est dedans ou non de
     *                        ellipse.
     */
    public EllipseTestContientFalseParameterized(final Ellipse ellipse, final Coordonnees coordonnees) {
        this.ellipse = ellipse;
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
                // Test dans le cas où largeur > hauteur
                // Le point est dans le cadre mais hors de l'ellipse
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(20, 40) },
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(76.7902, 37.1302) },
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(76.548, 5.3951) },
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(12.3511, 9.5134) },

                // Le point est hors du cadre
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(27.3708, 52.6343) },
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(104.6493, 52.3921) },
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(4.1145, 12.4202) },
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(49.9002, 0.3078) },

                // Test dans le cas où largeur < hauteur
                // Le point est dans le cadre mais hors de l'ellipse
                { new Ellipse(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(46.9932, 47.3048) },
                { new Ellipse(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(15.2583, 48.7583) },
                { new Ellipse(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(12.8356, 8.3021) },
                { new Ellipse(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(46.5087, 4.1838) },

                // Le point est hors du cadre
                { new Ellipse(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(70.9762, 43.1865) },
                { new Ellipse(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(3.8723, 59.6596) },
                { new Ellipse(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(68.7959, 10.7247) },
                { new Ellipse(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(5.8103, 6.1219) }

        };
        return Arrays.asList(data);

    }

    // Couverture des instruction pour contient : 95%
    // Couverture des branches pour contienr : 50%

    /**
     * Test de {@link Ellipse#contient()}
     */
    @Test
    public void testContientFalse() {
        assertFalse("Test de contient() : " + this.coordonnees.toString(), this.ellipse.contient(this.coordonnees));
    }
}
