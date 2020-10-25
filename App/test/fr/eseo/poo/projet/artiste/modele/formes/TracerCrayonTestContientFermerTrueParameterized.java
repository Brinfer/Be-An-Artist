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
 * Classe de test parametree de {@link TracerCrayon#contient(Coordonnees)}.
 * <p>
 * L'idée est de tracer une ellipse avec la classe et de tester la méthode avec
 * des points connu comme étant dans l'ellipse.
 * <p>
 * Cela est assez imprécie comme méthode car cela va dépendre du pas entre les points.
 * 
 * @author Brinfer
 * 
 * @since 0.4.3.1
 */
@RunWith(Parameterized.class)
public class TracerCrayonTestContientFermerTrueParameterized {

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
    public TracerCrayonTestContientFermerTrueParameterized(final Ellipse ellipse, final Coordonnees coordonnees) {
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
                // Le point est dans l'ellipse
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(41.1791, 32.5274)},
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(20, 20)},
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(65.1621, 13.3894)},

                // Le point est sur le contour de l'ellipse
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(71.4193, 37.2789)},
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1), new Coordonnees(72.8407, 7.7525)},

                // Test dans le cas où largeur < hauteur
                // Le point est dans l'ellipse
                { new Ellipse(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(26.4017, 39.7949)},
                { new Ellipse(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(30.08, 26.83)},
                { new Ellipse(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(23.0102, 16.0542)},

                // Le point est sur le contour de l'ellipse
                { new Ellipse(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(42.8468, 46.2993)},
                { new Ellipse(new Coordonnees(10.03, 1.58), 40.1, 50.5), new Coordonnees(50.1290, 27.0618)},

        };
        return Arrays.asList(data);

    }

    /**
     * Test de {@link TracerCrayon#contient(Coordonnees)}.
     */
    @Test
    public void testContientTrue() {
        final TracerCrayon tracer = new TracerCrayon();
        tracer.setRempli(true);

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

        assertTrue("Test de contient:", tracer.contient(this.coordonnees));
    }
}
