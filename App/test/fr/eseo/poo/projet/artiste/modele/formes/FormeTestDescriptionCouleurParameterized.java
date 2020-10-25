package fr.eseo.poo.projet.artiste.modele.formes;

import java.awt.Color;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Classe de test parametre de {@link Forme#descriptionCouleur()}
 * 
 * @author Brinfer
 * 
 * @since 0.3.6.1
 * 
 * @version 0.3.6.1
 */
@RunWith(Parameterized.class)
public class FormeTestDescriptionCouleurParameterized {

    /**
     * Attribues représentants la forme dont on veut tester l'affichage.
     */
    private final Forme forme;

    /**
     * Attribue représentant comment les attribues de la forme doivent être
     * afficher.
     */
    private final String descriptionAttendueFr, descriptionAttendueEn;

    /**
     * Constructeur pour chaque donnee de test.
     * 
     * @param Forme                 La forme dont on veut tester l'affichage.
     * @param descriptionAttendueFr La manière dont doit etre afficher la couleur en
     *                              français
     * @param descriptionAttendueEn La manière dont être afficher la couleur en
     *                              anglais
     */
    public FormeTestDescriptionCouleurParameterized(final Forme forme, final String descriptionAttendueFr,
            final String descriptionAttendueEn, final Color couleur) {
        this.descriptionAttendueFr = descriptionAttendueFr;
        this.descriptionAttendueEn = descriptionAttendueEn;
        this.forme = forme;
        this.forme.setCouleur(couleur);
    }

    /**
     * Création du jeu de test.
     * 
     * @return l'ensemble des données de test.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}, {2}, {3}, {4}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                { new FormeConcreteTest(), " couleur = R51,V51,B51", " couleur = R51,G51,B51",
                        Forme.COULEUR_PAR_DEFAUT },
                { new FormeConcreteTest(), " couleur = R255,V0,B0", " couleur = R255,G0,B0", Color.RED },
                { new FormeConcreteTest(), " couleur = R0,V0,B255", " couleur = R0,G0,B255", Color.BLUE },
                { new FormeConcreteTest(), " couleur = R0,V255,B0", " couleur = R0,G255,B0", Color.GREEN },
                { new FormeConcreteTest(), " couleur = R0,V0,B0", " couleur = R0,G0,B0", Color.BLACK },
                { new FormeConcreteTest(), " couleur = R255,V255,B255", " couleur = R255,G255,B255", Color.WHITE } };
        return Arrays.asList(data);
    }

    // Couverture des instructions pour descriptionCouleur : 100%
    // Couverture des branches pour descriptionCouleur : 100%

    /**
     * Test de de {@link Forme#descriptionCouleur()}.
     */
    @Test
    public void testToString() {

        // Test Locale fr
        String description = this.forme.descriptionCouleur();
        assertEquals("Test de descriptionCouleur fr", this.descriptionAttendueFr, description);

        Locale.setDefault(Locale.ENGLISH);
        // Test Locale en
        description = this.forme.descriptionCouleur();
        assertEquals("Test de descriptionCouleur en", this.descriptionAttendueEn, description);
        Locale.setDefault(Locale.FRANCE);
    }
}