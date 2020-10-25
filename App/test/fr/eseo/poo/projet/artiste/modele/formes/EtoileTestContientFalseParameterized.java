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
 * Classe de test parametree de {@link Etoile#contient()}
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.8
 */
@RunWith(Parameterized.class)
public class EtoileTestContientFalseParameterized {

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
    public EtoileTestContientFalseParameterized(final Etoile etoile, final Coordonnees coordonnees) {
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
                // Point à l'extérieur
                // Entre les branches
                { new Etoile(), new Coordonnees(122.2071, 90.5923) },
                { new Etoile(), new Coordonnees(101.9101, 34.5724) },
                { new Etoile(), new Coordonnees(22.3456, 32.1368) },
                { new Etoile(), new Coordonnees(45.0783, 84.0973) },
                { new Etoile(), new Coordonnees(101.9101, 125.5033) },

                // Dans le cadre
                { new Etoile(), new Coordonnees(138.4448, 134.434) },
                { new Etoile(), new Coordonnees(131.9497, 9.4041) }, { new Etoile(), new Coordonnees(8.5436, 21.5823) },
                { new Etoile(), new Coordonnees(16.6624, 137.6815) },

                // Hors du cadre
                { new Etoile(), new Coordonnees(72.6823, 167) }, { new Etoile(), new Coordonnees(235.8707, 79.226) },
                { new Etoile(), new Coordonnees(113.2764, -35.2495) },
                { new Etoile(), new Coordonnees(-71.0209, 67.0477) },

        };
        return Arrays.asList(data);

    }

    // Couverture des instruction pour contient : 96.3%
    // Couverture des branches pour contient : 88.9%

    /**
     * Test de {@link Etoile#contient()}
     */
    @Test
    public void testContientFalse() {
        assertFalse("Test de contient() : " + this.coordonnees.toString(), this.etoile.contient(this.coordonnees));
    }
}