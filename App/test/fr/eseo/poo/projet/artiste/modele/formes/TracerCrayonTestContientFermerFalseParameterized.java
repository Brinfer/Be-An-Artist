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
 * Classe de test parametree de {@link TracerCrayon#contient(Coordonnees)}.
 * <p>
 * L'idée est de tracer une ellipse avec la classe et de tester la méthode avec
 * des points connu comme étant dans l'ellipse.
 * <p>
 * Cela est assez imprécie comme méthode car cela va dépendre du pas entre les
 * points.
 * 
 * @author Brinfer
 * 
 * @since 0.4.3.1
 */
@RunWith(Parameterized.class)
public class TracerCrayonTestContientFermerFalseParameterized {

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
     * @param ellipse     l'ellipse que l'on souhaite tester.
     * @param coordonnees le point dont on veut savoir s'il est dedans ou non de
     *                    ellipse.
     */
    public TracerCrayonTestContientFermerFalseParameterized(final Ellipse ellipse, final Coordonnees coordonnees) {
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
                { new Ellipse(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(5.8103, 6.1219) } };
        return Arrays.asList(data);

    }

    /**
     * Test de {@link TracerCrayon#contient(Coordonnees)}.
     */
    @Test
    public void testContientFalse() {
        final TracerCrayon tracer = new TracerCrayon();

        // Dessin d'une ellipse
        final double a = this.ellipse.getLargeur() / 2;
        final double b = this.ellipse.getHauteur() / 2;
        final double u = this.ellipse.getPosition().getAbscisse() + a;
        final double v = this.ellipse.getPosition().getOrdonnee() + b;
        double x = (u + a * Math.cos(0));
        double y = (v + b * Math.sin(0));
        tracer.trace(new Coordonnees(x, y));
        for (double teta = 0; teta <= 2 * Math.PI + 0.1; teta += 0.001) {
            x = u + a * Math.cos(teta);
            y = v + b * Math.sin(teta);
            tracer.trace(new Coordonnees(x, y));
        }

        assertFalse("Test de contient:", tracer.contient(this.coordonnees));
    }
}