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
 * Classe de test parametree de {@link Etoile#contient()}
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.8
 */
@RunWith(Parameterized.class)
public class EtoileTestContientTrueParameterized {

    /**
     * Attribut representant l'Etoile que l'on souhaite tester.
     */
    private final Etoile etoile;

    /**
     * Parametres representant le point dont on veut savoir s'il est dedans ou non
     * de Etoile.
     */
    private final Coordonnees coordonnees;

    /**
     * Constructeur pour chaque donnee de test.
     * 
     * @param Etoile      l'etoile que l'on souhaite tester.
     * @param coordonnees le point dont on veut savoir s'il est dedans ou non de l'
     *                    etoile.
     */
    public EtoileTestContientTrueParameterized(final Etoile etoile, final Coordonnees coordonnees) {
        this.etoile = etoile;
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
                /* Test etoile par defaut */
                // Point a l'interieur
                { new Etoile(), new Coordonnees(75.9298, 39.4437) },
                { new Etoile(), new Coordonnees(41.0189, 63.8002) },
                { new Etoile(), new Coordonnees(51.5733, 109.2656) },
                { new Etoile(), new Coordonnees(99.4744, 108.4537) },
                { new Etoile(), new Coordonnees(108.4051, 64.6121) },
                { new Etoile(), new Coordonnees(69.4348, 80.8497) },

                // Point sur les sommets du polynome
                { new Etoile(), new Coordonnees(86.021, 59.8309) }, 
                { new Etoile(), new Coordonnees(63.976, 59.8309) },
                { new Etoile(), new Coordonnees(57.1677, 80.7941) },
                { new Etoile(), new Coordonnees(75, 93.75) },
                { new Etoile(), new Coordonnees(92.8323, 80.7941) },

                // Point sur les sommets des branches
                { new Etoile(), new Coordonnees(75, 0) },
                { new Etoile(), new Coordonnees(3.6708, 51.8237) },
                { new Etoile(), new Coordonnees(30.9161, 135.6763) },
                { new Etoile(), new Coordonnees(119.0839, 135.6763) },
                { new Etoile(), new Coordonnees(146.3292, 51.8237) },

                // Point sur segment
                { new Etoile(), new Coordonnees(81.8369, 37.1164) },
                { new Etoile(), new Coordonnees(68.5134, 35.2146) },
                { new Etoile(), new Coordonnees(37.098, 56.2619) },
                { new Etoile(), new Coordonnees(36.8057, 69.7674) },
                { new Etoile(), new Coordonnees(43.6963, 108.9577) },
                { new Etoile(), new Coordonnees(60.8986, 107.1612) },
                { new Etoile(), new Coordonnees(105.9224, 123.1589) },
                { new Etoile(), new Coordonnees(101.6431, 99.2141) },
                { new Etoile(), new Coordonnees(134.4585, 58.2521) },
                { new Etoile(), new Coordonnees(106.7513, 57.0785) }, };
        return Arrays.asList(data);

    }

    // Couverture des instruction pour contient : 100%
    // Couverture des branches pour contient : 100%

    /**
     * Test de {@link Etoile#contient()}
     */
    @Test
    public void testContient() {
        assertTrue("Test de contient() : " + this.coordonnees.toString(), this.etoile.contient(this.coordonnees));
    }
}