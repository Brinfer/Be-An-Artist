package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Classe de test parametre de {@link Ellipse#toString()}
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.7
 * 
 * @version 0.4.4.1
 */
@RunWith(Parameterized.class)
public class EllipseTestToStringParameterized {

    /**
     * Attribues représentants l'ellipse dont on veut tester l'affichage.
     */
    private final Ellipse ellipse;

    /**
     * Attribue représentant comment les attribues de l'ellipse doivent être
     * afficher.
     */
    private String largeurAfficher;

    private String hauteurAfficher;

    private String perimetreAfficher;

    private String aireAfficher;

    /**
     * Constructeur pour chaque donnee de test.
     * 
     * @param ellipse           l'ellipse dont on veut tester l'affichage.
     * @param largeurAfficher   comment la largeur doit etre affichée.
     * @param hauteurAfficher   comment la hauteur doit être affichée.
     * @param perimetreAfficher comment le périmètre doit être afficher.
     * @param aireAfficher      comment l'aire doit être afficher.
     */
    public EllipseTestToStringParameterized(final Ellipse ellipse, final String largeurAfficher,
            final String hauteurAfficher, final String perimetreAfficher, final String aireAfficher) {
        this.ellipse = ellipse;
        this.largeurAfficher = largeurAfficher;
        this.hauteurAfficher = hauteurAfficher;
        this.perimetreAfficher = perimetreAfficher;
        this.aireAfficher = aireAfficher;
    }

    /**
     * Création du jeu de test.
     * 
     * @return l'ensemble des données de test.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}, {2}, {3}, {4}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // Test 0: Ellipse de hauteur et de largeur 1, position (0, 0). Ce qui suit
                // (dans l'ordre) est la maniére dont doit être la largeur, la hauteur, le
                // périmètre et l'aire de l'ellipse.
                { new Ellipse(1, 1), "1,0", "1,0", "3,14", "0,79" },
                // Test 1: Ellipse de largeur 1 et de hauteur 1, position (0, 0). Ce qui suit
                // (dans l'ordre) est la maniére dont doit être la largeur, la hauteur, le
                // périmètre et l'aire de l'ellipse.
                { new Ellipse(1, 2), "1,0", "2,0", "4,84", "1,57" },
                // Test 2: Ellipse de largeur 2 et de hauteur 1, position (0, 0). Ce qui suit
                // (dans l'ordre) est la maniére dont doit être la largeur, la hauteur, le
                // périmètre et l'aire de l'ellipse.
                { new Ellipse(2, 1), "2,0", "1,0", "4,84", "1,57" },
                // Test 3: Ellipse de largeur 15.05 et de hauteur 15.05, position (0, 0). Ce qui
                // suit (dans l'ordre) est la maniére dont doit être la largeur, la hauteur, le
                // périmètre et l'aire de l'ellipse.
                { new Ellipse(15.05, 15.05), "15,05", "15,05", "47,28", "177,89" },
                // Test 4: Ellipse de largeur 28.8 et de hauteur 15.05, position (0, 0). Ce qui
                // suit (dans l'ordre) est la maniére dont doit être la largeur, la hauteur, le
                // périmètre et l'aire de l'ellipse.
                { new Ellipse(28.1, 15.05), "28,1", "15,05", "69,34", "332,15" },
                // Test 4: Ellipse de largeur 15.05 et de hauteur 28.8, position (0, 0). Ce qui
                // suit (dans l'ordre) est la maniére dont doit être la largeur, la hauteur, le
                // périmètre et l'aire de l'ellipse.
                { new Ellipse(15.05, 28.1), "15,05", "28,1", "69,34", "332,15" } };
        return Arrays.asList(data);
    }

    // Couverture des instructions pour toString : 100%
    // Couverture des branches pour toString : 100%

    /**
     * Test de de {@link Ellipse#toString()}.
     */
    @Test
    public void testToString() {

        String descriptionAttendue = "[Ellipse] : pos " + this.ellipse.getPosition().toString() + " dim "
                + this.largeurAfficher + " x " + this.hauteurAfficher + " périmètre : " + this.perimetreAfficher
                + " aire : " + this.aireAfficher + this.ellipse.descriptionCouleur()
                + this.ellipse.descriptionEpaisseurTrait();
        assertEquals("Test de toString()", descriptionAttendue, this.ellipse.toString());

        ellipse.setRempli(true);
        descriptionAttendue = "[Ellipse-Rempli] : pos " + this.ellipse.getPosition().toString() + " dim "
                + this.largeurAfficher + " x " + this.hauteurAfficher + " périmètre : " + this.perimetreAfficher
                + " aire : " + this.aireAfficher + this.ellipse.descriptionCouleur()
                + this.ellipse.descriptionEpaisseurTrait();
        assertEquals("Test de toString()", descriptionAttendue, this.ellipse.toString());
    }
}
