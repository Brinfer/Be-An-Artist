package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Classe de test parametree de {@link TracerCrayon#perimetre()}.
 * <p>
 * L'idée est de tracer une ellipse avec la classe et de comparer le périmètre
 * renvoyer.
 * <p>
 * Cela est assez imprécie comme méthode car cela va dépendre du pas entre les
 * points.
 * 
 * @author Brinfer
 * 
 * @since 0.4.3.1
 */
@RunWith(Parameterized.class)
public class TracerContourTestPerimetreParameterized {

    /**
     * Attribut representant l'ellipse que l'on souhaite tester.
     */
    private final Ellipse ellipse;

    /**
     * Constructeur pour chaque donnee de test.
     * 
     * @param ellipse l'ellipse que l'on souhaite tester.
     */
    public TracerContourTestPerimetreParameterized(final Ellipse ellipse) {
        this.ellipse = ellipse;
    }

    /**
     * Création du jeu de test.
     * 
     * @return l'ensemble des données de test.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
				{ new Ellipse(1, 1)},
				{ new Ellipse(1, 2)},
				{ new Ellipse(2, 1)},
				{ new Ellipse(15.05, 15.05)},
				{ new Ellipse(28.1, 15.05)},
                { new Ellipse(15.05, 28.1)},
                { new Ellipse(new Coordonnees(10.03, 1.58), 73.27, 41.1)},
                { new Ellipse(new Coordonnees(10.03, 1.58), 40.1, 50.5) },
        };
        return Arrays.asList(data);

    }

    /**
     * Test de {@link TracerCrayon#perimetre()}.
     */
    @Test
    @SuppressWarnings("deprecation")
    public void testPerimetre() {
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

        assertEquals("Test de perimetre:", this.ellipse.perimetre(), tracer.perimetre(), TracerCrayon.EPSILON);
    }
}