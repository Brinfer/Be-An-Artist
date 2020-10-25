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
 * Classe de test de parametre de {@link CadreSelection#setLargeur()}.
 * 
 * @author Brinfer
 * 
 * @since 0.4.2.1
 */
@RunWith(Parameterized.class)
public class CadreSelectionTestSetLargeurParameterized {

    /**
     * Attribut representant le CadreSelection testé.
     */
    private final CadreSelection cadreSelection;

    /**
     * Parametres representant la largeur attendue.
     */
    private final double largeurAttendue;

    /**
     * Constructeur pour chaque donnee de test.
     * 
     * @param cadreSelection  le CadreSelection dont on veut tester le périmètre.
     * @param largeurAttendue le Setlargeur attendue du CadreSelection pour la
     *                        taille données.
     */
    public CadreSelectionTestSetLargeurParameterized(final CadreSelection cadreSelection,
            final double largeurAttendue) {
        this.cadreSelection = cadreSelection;
        this.largeurAttendue = largeurAttendue;
    }

    /**
     * Création du jeu de test.
     * 
     * @return l'ensemble des données de test.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // largeur et hauteur positive
                // Réduction de la taille
                { new CadreSelection(new FormeConcreteTest(200, 100)), 50 },
                // augmentation de la taille
                { new CadreSelection(new FormeConcreteTest(100, 200)), 1000 },

                // largeur négative et hauteur positive
                { new CadreSelection(new FormeConcreteTest(200, -100)), 50 },

                // largeur positive et hauteur négative
                // Réduction de la taille
                { new CadreSelection(new FormeConcreteTest(-200, 100)), 50 },
                // augmentation de la taille
                { new CadreSelection(new FormeConcreteTest(-100, 200)), 1000 },

                // Cas d'un cercle : hauteur et largeur egale
                // Réduction de la taille
                { new CadreSelection(new Cercle(100)), 50 },
                // augmentation de la taille
                { new CadreSelection(new Cercle(200)), 1000 } };

        return Arrays.asList(data);
    }

    // Couverture instruction pour Setlargeur : 100%

    /**
     * Test de la méthode {@link CadreSelection#setLargeur()}.
     */
    @Test
    public void testSetLargeur() {
        double largeurPassezForme = this.cadreSelection.getFormeSelectionner().getLargeur();
        this.cadreSelection.setLargeur(this.largeurAttendue);

        assertEquals("Test largeur du cadre : ", this.largeurAttendue, this.cadreSelection.getLargeur(), Forme.EPSILON);

        assertEquals("Test de la largeur de la forme : ", this.largeurAttendue,
                Math.abs(this.cadreSelection.getFormeSelectionner().getLargeur()), Forme.EPSILON);

        assertEquals("Test hauteur cadre/forme", this.cadreSelection.getHauteur(),
                Math.abs(this.cadreSelection.getFormeSelectionner().getHauteur()), Forme.EPSILON);

        assertTrue("Test même signe de la largeur de la forme",
                (this.cadreSelection.getFormeSelectionner().getLargeur() > 0) == (largeurPassezForme > 0));
    }
}
