package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Classe de test parametre de {@link Etoile#toString()}
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.7
 * 
 * @version 0.3.6.1
 */
@RunWith(Parameterized.class)
public class EtoileTestToStringParameterized {

    /**
     * Attribues représentants l'Etoile dont on veut tester l'affichage.
     */
    private final Etoile etoile;

    /**
     * Attribue représentant comment les attribues de l'Etoile doivent être
     * afficher.
     */
    private String largeurAfficher;

    private String hauteurAfficher;

    private String perimetreAfficher;

    private String aireAfficher;

    /**
     * Constructeur pour chaque donnee de test.
     * 
     * @param etoile            l'Etoile dont on veut tester l'affichage.
     * @param largeurAfficher   comment la largeur doit etre affichée.
     * @param hauteurAfficher   comment la hauteur doit être affichée.
     * @param perimetreAfficher comment le périmètre doit être afficher.
     * @param aireAfficher      comment l'aire doit être afficher.
     */
    public EtoileTestToStringParameterized(final Etoile etoile, final String largeurAfficher,
            final String hauteurAfficher, final String perimetreAfficher, final String aireAfficher) {
        this.etoile = etoile;
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
                // Test 0: Etoile de hauteur et de largeur 1, position (0, 0). Ce qui suit
                // (dans l'ordre) est la maniére dont doit être la largeur, la hauteur, le
                // périmètre et l'aire de l'Etoile.
                { new Etoile(), "150,0", "150,0", "608,38", "4132,87" },
                // Test 1: Etoile de largeur 1 et de hauteur 1, position (0, 0). Ce qui suit
                // (dans l'ordre) est la maniére dont doit être la largeur, la hauteur, le
                // périmètre et l'aire de l'Etoile.
                { new Etoile(100), "100,0", "100,0", "405,58", "1836,83" },
                // Test 2: Etoile de largeur 2 et de hauteur 1, position (0, 0). Ce qui suit
                // (dans l'ordre) est la maniére dont doit être la largeur, la hauteur, le
                // périmètre et l'aire de l'Etoile.
                { new Etoile(200), "200,0", "200,0", "811,17", "7347,32" },
                // Test 3: Etoile de largeur 15.05 et de hauteur 15.05, position (0, 0). Ce qui
                // suit (dans l'ordre) est la maniére dont doit être la largeur, la hauteur, le
                // périmètre et l'aire de l'Etoile.
                { new Etoile(152.154), "152,15", "152,15", "617,11", "4252,41" } };
        return Arrays.asList(data);
    }

    // Couverture des instructions pour toString : 100%
    // Couverture des branches pour toString : 100%

    /**
     * Test de de {@link Etoile#toString()}.
     */
    @Test
    public void testToString() {

        String descriptionAttendue = "[Etoile] : pos " + this.etoile.getPosition().toString() + " dim "
                + this.largeurAfficher + " x " + this.hauteurAfficher + " périmètre : " + this.perimetreAfficher
                + " aire : " + this.aireAfficher + this.etoile.descriptionCouleur();
        assertEquals("Test de toString()", descriptionAttendue, this.etoile.toString());

        etoile.setRempli(true);
        descriptionAttendue = "[Etoile-Rempli] : pos " + this.etoile.getPosition().toString() + " dim "
                + this.largeurAfficher + " x " + this.hauteurAfficher + " périmètre : " + this.perimetreAfficher
                + " aire : " + this.aireAfficher + this.etoile.descriptionCouleur();
        assertEquals("Test de toString()", descriptionAttendue, this.etoile.toString());
    }
}