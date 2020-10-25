package fr.eseo.poo.projet.artiste.modele.formes;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test de parametre de
 * {@link CadreSelection#setHauteur(double, int)}.
 * 
 * @author Brinfer
 * 
 * @since 0.4.2.1
 */
@RunWith(Parameterized.class)
public class CadreSelectionTestSetHauteurDeltaParameterized {

    /**
     * Attribut representant le CadreSelection testé.
     */
    private final CadreSelection cadreSelection;

    /**
     * Parametres representant SetHauteur attendue.
     */
    private final double delta;

    private int cotePositionForme;

    /**
     * Constructeur pour chaque donnee de test.
     * 
     * @param cadreSelection le CadreSelection dont on veut tester le périmètre.
     * @param delta          La variation de la taille.
     */
    public CadreSelectionTestSetHauteurDeltaParameterized(final CadreSelection cadreSelection, final double delta,
            int cotePositionForme) {
        this.cadreSelection = cadreSelection;
        this.delta = delta;
        this.cotePositionForme = cotePositionForme;
    }

    /**
     * Création du jeu de test.
     * 
     * @return l'ensemble des données de test.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}, {2}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // Pas de changment
                { new CadreSelection(new FormeConcreteTest(150, 800)), 0, CadreSelection.NORD },

                // Forme : largeur et hauteur positive, position au NORD-OUEST
                { new CadreSelection(new FormeConcreteTest(150, 800)), 10, CadreSelection.NORD },

                // Forme : largeur et hauteur négative, position au SUD-EST
                { new CadreSelection(new FormeConcreteTest(-450, -761)), 20, CadreSelection.SUD },

                // Forme : largeur positive et hauteur négative, position au SUD-OUEST
                { new CadreSelection(new FormeConcreteTest(578, -761)), 20, CadreSelection.SUD },

                // Forme : largeur négative et hauteur positive , position au NORD-EST
                { new CadreSelection(new FormeConcreteTest(-450, 48)), 20, CadreSelection.NORD }, };
        return Arrays.asList(data);

    }

    // Couverture instruction pour SetHauteur : 100%

    /**
     * Test de la méthode {@link CadreSelection#setHauteur(double, int)}.
     */
    @Test
    public void testSetHauteur() {
        double hauteurInit = this.cadreSelection.getHauteur();
        Coordonnees positionInitForme = this.cadreSelection.getFormeSelectionner().getPosition();
        Coordonnees positionAttendue = new Coordonnees(positionInitForme.getAbscisse(),
                positionInitForme.getOrdonnee() + this.delta);// Position de la forme une fois le changment de la
                                                              // hauteur effectuer

        // Changement coté NORD
        this.cadreSelection.setHauteur(this.delta, CadreSelection.NORD);
        assertEquals("Test de la hauteur NORD 1", hauteurInit - this.delta, this.cadreSelection.getHauteur(),
                Forme.EPSILON);

        if (this.cotePositionForme == CadreSelection.NORD) { // Si la position de la forme était au NORD alors elle
                                                             // doit avoir été bougé
            assertEquals("Test positon deplacement NORD de la forme", positionAttendue,
                    this.cadreSelection.getFormeSelectionner().getPosition());
        } else {
            assertEquals("Test positon immobile NORD de la forme", positionInitForme,
                    this.cadreSelection.getFormeSelectionner().getPosition());
        }

        // Retour à l'etat initial
        this.cadreSelection.setHauteur(-this.delta, CadreSelection.NORD);
        assertEquals("Test de la hauteur NORD 2", hauteurInit, this.cadreSelection.getHauteur(), Forme.EPSILON);
        assertEquals("Test positon retour normale position NORD de la forme", positionInitForme,
                this.cadreSelection.getFormeSelectionner().getPosition());

        // Changement coté SUD
        this.cadreSelection.setHauteur(this.delta, CadreSelection.SUD);
        assertEquals("Test de la hauteur SUD 1", hauteurInit + this.delta, this.cadreSelection.getHauteur(),
                Forme.EPSILON);

        if (this.cotePositionForme == CadreSelection.SUD) { // Si la position de la forme était au SUD alors elle
                                                            // doit avoir été bougé
            assertEquals("Test positon deplacement SUD de la forme", positionAttendue,
                    this.cadreSelection.getFormeSelectionner().getPosition());
        } else {
            assertEquals("Test positon immobile SUD de la forme", positionInitForme,
                    this.cadreSelection.getFormeSelectionner().getPosition());
        }

        // Retour à l'etat initial
        this.cadreSelection.setHauteur(-this.delta, CadreSelection.SUD);
        assertEquals("Test de la hauteur SUD 2", hauteurInit, this.cadreSelection.getHauteur(), Forme.EPSILON);
        assertEquals("Test positon etour normale position SUD de la forme", positionInitForme,
                this.cadreSelection.getFormeSelectionner().getPosition());
    }
}