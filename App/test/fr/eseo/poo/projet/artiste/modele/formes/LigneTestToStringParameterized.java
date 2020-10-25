package fr.eseo.poo.projet.artiste.modele.formes;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test parametree de {@link Ligne#toString()}
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.5
 * 
 * @version 0.3.5.1
 */
@RunWith(Parameterized.class)
public class LigneTestToStringParameterized {

    /**
     * Attribues représentants la ligne que l'on teste
     */
    private final Ligne ligne;

    /**
     * Attribut représentant comment l'angle doit être afiché.
     */
    private String angleAffichage;

    /**
     * Attribut représentant comment la longueur doit être afiché.
     */
    private String longueurAffichage;

    /**
     * Constructeur pour chaque donnee de test pour Ligne
     * 
     * @param largeur  la largeur de la ligne
     * @param hauteur  la hauteur de la ligne
     * @param abcisse  l'abcisse de la position de la ligne
     * @param ordonnee l'ordonnee de la position de la ligne
     */
    public LigneTestToStringParameterized(final Ligne ligne, final String longueurAffichage,
            final String angleAffichage) {
        this.ligne = ligne;
        this.longueurAffichage = longueurAffichage;
        this.angleAffichage = angleAffichage;
    }

    /**
     * Création du jeu de test.
     * 
     * @return l'ensemble des données de test.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}, {2}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // Test 0: ligne de largeur 0 et de hauteur 0, positionner en (0, 0).
                // La représentation de la longueur de la ligne est 0,0 degrés et celle de
                // l'angle est 0,0 degrés.
                { new Ligne(0, 0), "0,0", "0,0" },
                // Test 0: ligne de largeur 150 et de hauteur 150, positionner en (0, 0).
                // La représentation de la longueur de la ligne est 212,13 degrés et celle de
                // l'angle est 45,0 degrés.
                { new Ligne(150, 150), "212,13", "45,0" },
                // Test 0: ligne de largeur 150 et de hauteur -150, positionner en (0, 0).
                // La représentation de la longueur de la ligne est 212,13 degrés et celle de
                // l'angle est 315,0.degrés
                { new Ligne(150, -150), "212,13", "315,0" },
                // Test 0: ligne de largeur -150 et de hauteur -150, positionner en (0, 0).
                // La représentation de la longueur de la ligne est 212,13 degrés et celle de
                // l'angle est 225,0.degrés
                { new Ligne(-150, -150), "212,13", "225,0" },
                // Test 0: ligne de largeur -150 et de hauteur 150, positionner en (0, 0).
                // La représentation de la longueur de la ligne est 212,13 et celle de l'angle
                // est 135,0 degrés.
                { new Ligne(-150, 150), "212,13", "135,0" } };

        return Arrays.asList(data);
    }

    // Couverture des instruction pour toString : 100%
    // Couverture des branches pour toString : 100%

    /**
     * Test de {@link Ligne#toString()}
     */
    @Test
    public void testToString() {

        // Test locale fr
        String descriptionAttendue = "[Ligne] c1 : " + this.ligne.getC1().toString() + " c2 : " + this.ligne.getC2().toString()
                + " longueur : " + this.longueurAffichage + " angle : " + this.angleAffichage
                + "°" + this.ligne.descriptionCouleur();

        assertEquals("Test de toString()", descriptionAttendue, this.ligne.toString());


    }
}
