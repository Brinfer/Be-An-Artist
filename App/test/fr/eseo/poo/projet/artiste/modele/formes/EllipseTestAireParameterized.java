package fr.eseo.poo.projet.artiste.modele.formes;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test de parametre de {@link Ellipse#aire()}.
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.7
 */
@RunWith(Parameterized.class)
public class EllipseTestAireParameterized {

    /**
     * Attribut representant l'ellipse que l'on teste.
     */
    private final Ellipse ellipse;

    /**
     * Attribut representant l'aire attendue.
     */
    private final double aireAttendue;

    /**
     * Constructeur pour chaque donnee de test.
     * 
     * @param ellipse      l'ellipse dont on veut tester l'aire.
     * @param aireAttendue l'aire attendue de l'ellipse.
     */
    public EllipseTestAireParameterized(final Ellipse ellipse, final double aireAttendue) {
        this.ellipse = ellipse;
        this.aireAttendue = aireAttendue;
    }

    /**
     * Création du jeu de test.
     * 
     * @return l'ensemble des données de test.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // L'aire attendue est de 0.25π.
                { new Ellipse(1, 1), 0.25 * Math.PI },
                // L'aire attendue est de 0.5π.
                { new Ellipse(1, 2), 0.5 * Math.PI },
                // L'aire attendue est de 0.5π.
                { new Ellipse(2, 1), 0.5 * Math.PI },
                // L'aire attendue est d'environs 177.89, au final il s'agit d'un cercle.
                { new Ellipse(15.05, 15.05), 177.894 },
                // L'aire attendue est d'environs 332.14.
                { new Ellipse(28.1, 15.05), 332.148 },
                // L'aire attendue est d'environs 332.14.
                { new Ellipse(15.05, 28.1), 332.148 } };
        return Arrays.asList(data);
    }

    // Couverture instruction pour aire : 100%

    /**
     * Test de la méthode {@link Ellipse#aire()}
     */
    @Test
    public void testAireEllipse() {
        assertEquals("Test de aire(): ", this.aireAttendue, this.ellipse.aire(), Forme.EPSILON);
    }
}
