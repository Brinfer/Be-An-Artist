package fr.eseo.poo.projet.artiste.modele.formes;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Classe de test de parametre de {@link CadreSelection#setHauteur(double)}.
 * 
 * @author Brinfer
 * 
 * @since 0.4.2.1
 */
@RunWith(Parameterized.class)
public class CadreSelectionTestSetHauteurParameterized {

    /**
     * Attribut representant le CadreSelection testé.
     */
    private final CadreSelection cadreSelection;

    /**
     * Parametres representant SetHauteur attendue.
     */
    private final double hauteurAttendue;

    /**
     * Constructeur pour chaque donnee de test.
     * 
     * @param cadreSelection  le CadreSelection dont on veut tester le périmètre.
     * @param hauteurAttendue le SetHauteur attendue du CadreSelection pour la
     *                        taille données.
     */
    public CadreSelectionTestSetHauteurParameterized(final CadreSelection cadreSelection,
            final double hauteurAttendue) {
        this.cadreSelection = cadreSelection;
        this.hauteurAttendue = hauteurAttendue;
    }

    /**
     * Création du jeu de test.
     * 
     * @return l'ensemble des données de test.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // hauteur et largeur positive
                // Réduction de la taille
                { new CadreSelection(new FormeConcreteTest(200, 100)), 50 },
                // augmentation de la taille
                { new CadreSelection(new FormeConcreteTest(100, 200)), 1000 },

                // hauteur négative et largeur positive
                { new CadreSelection(new FormeConcreteTest(200, -100)), 50 },

                // hauteur positive et largeur négative
                // Réduction de la taille
                { new CadreSelection(new FormeConcreteTest(-200, 100)), 50 },
                // augmentation de la taille
                { new CadreSelection(new FormeConcreteTest(-100, 200)), 1000 },
            
                // Cas d'un cercle : hauteur et largeur egale
                // Réduction de la taille
                { new CadreSelection(new Cercle(100)), 50 },
                // augmentation de la taille
                { new CadreSelection(new Cercle(200)), 1000 }
            };

                
        return Arrays.asList(data);
    }

    // Couverture instruction pour SetHauteur : 100%

    /**
     * Test de la méthode {@link CadreSelection#setHauteur(double)}.
     */
    @Test
    public void testSetHauteur() {
        double hauteurPassezForme = this.cadreSelection.getFormeSelectionner().getHauteur();
        this.cadreSelection.setHauteur(this.hauteurAttendue);

        assertEquals("Test hauteur du cadre : ", this.hauteurAttendue, this.cadreSelection.getHauteur(), Forme.EPSILON);

        assertEquals("Test de la hauteur de la forme : ", this.hauteurAttendue,
                Math.abs(this.cadreSelection.getFormeSelectionner().getHauteur()), Forme.EPSILON);

        assertEquals("Test largeur cadre/forme", this.cadreSelection.getLargeur(),
                Math.abs(this.cadreSelection.getFormeSelectionner().getLargeur()), Forme.EPSILON);

        assertTrue("Test même signe de la hauteur de la forme",
                (this.cadreSelection.getFormeSelectionner().getHauteur() > 0) == (hauteurPassezForme > 0));
    }
}
