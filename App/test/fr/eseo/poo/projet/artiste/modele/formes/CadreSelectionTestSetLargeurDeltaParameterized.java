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
 * {@link CadreSelection#setLargeur(double, int)}.
 * 
 * @author Brinfer
 * 
 * @since 0.4.2.1
 */
@RunWith(Parameterized.class)
public class CadreSelectionTestSetLargeurDeltaParameterized {

    /**
     * Attribut representant le CadreSelection testé.
     */
    private final CadreSelection cadreSelection;

    /**
     * Parametres representant setLargeur attendue.
     */
    private final double delta;

    private int cotePositionForme;

    /**
     * Constructeur pour chaque donnee de test.
     * 
     * @param cadreSelection le CadreSelection dont on veut tester le périmètre.
     * @param delta          La variation de la taille.
     */
    public CadreSelectionTestSetLargeurDeltaParameterized(final CadreSelection cadreSelection, final double delta,
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
                { new CadreSelection(new FormeConcreteTest(150, 800)), 0, CadreSelection.OUEST },

                // Forme : largeur et largeur positive, position au NORD-OUEST
                { new CadreSelection(new FormeConcreteTest(150, 800)), 10, CadreSelection.OUEST },

                // Forme : largeur et largeur négative, position au SUD-EST
                { new CadreSelection(new FormeConcreteTest(-450, -761)), 20, CadreSelection.EST },

                // Forme : largeur positive et largeur négative, position au SUD-OUEST
                { new CadreSelection(new FormeConcreteTest(578, -761)), 20, CadreSelection.OUEST },

                // Forme : largeur négative et largeur positive , position au NORD-EST
                { new CadreSelection(new FormeConcreteTest(-450, 48)), 20, CadreSelection.EST }, };
        return Arrays.asList(data);

    }

    // Couverture instruction pour setLargeur : 100%

    /**
     * Test de la méthode {@link CadreSelection#setLargeur(double, int)}.
     */
    @Test
    public void testsetLargeur() {
        double largeurInit = this.cadreSelection.getLargeur();
        Coordonnees positionInitForme = this.cadreSelection.getFormeSelectionner().getPosition();
        Coordonnees positionAttendue = new Coordonnees(positionInitForme.getAbscisse() + this.delta,
                positionInitForme.getOrdonnee()); // Position de la forme une fois le changement de la largeur effectuer

        // Changement coté OUEST
        this.cadreSelection.setLargeur(this.delta, CadreSelection.OUEST);
        assertEquals("Test de la largeur OUEST 1", largeurInit - this.delta, this.cadreSelection.getLargeur(),
                Forme.EPSILON); // Test changement de la largeur

        if (this.cotePositionForme == CadreSelection.OUEST) { // Si la position de la forme était à l'ouest alors elle
                                                              // doit avoir été bougé
            assertEquals("Test positon deplacement OUEST de la forme", positionAttendue,
                    this.cadreSelection.getFormeSelectionner().getPosition());
        } else {
            assertEquals("Test positon immobile OUEST de la forme", positionInitForme,
                    this.cadreSelection.getFormeSelectionner().getPosition());
        }

        // Retour à l'etat intitial
        this.cadreSelection.setLargeur(-this.delta, CadreSelection.OUEST);
        assertEquals("Test de la largeur OUEST 2", largeurInit, this.cadreSelection.getLargeur(), Forme.EPSILON);
        assertEquals("Test positon retour normale position OUEST de la forme", positionInitForme,
                this.cadreSelection.getFormeSelectionner().getPosition());

        // Changemement coté EST
        this.cadreSelection.setLargeur(this.delta, CadreSelection.EST);
        assertEquals("Test de la largeur EST 1", largeurInit + this.delta, this.cadreSelection.getLargeur(),
                Forme.EPSILON); // Test changement de la largeur

        if (this.cotePositionForme == CadreSelection.EST) {// Si la position de la forme était à l'est alors elle
                                                           // doit avoir été bougé
            assertEquals("Test positon deplacement EST de la forme", positionAttendue,
                    this.cadreSelection.getFormeSelectionner().getPosition());
        } else {
            assertEquals("Test positon immobile EST de la forme", positionInitForme,
                    this.cadreSelection.getFormeSelectionner().getPosition());
        }

        // Retour à l'etat initial
        this.cadreSelection.setLargeur(-this.delta, CadreSelection.EST);
        assertEquals("Test de la largeur EST 2", largeurInit, this.cadreSelection.getLargeur(), Forme.EPSILON);
        assertEquals("Test positon retour normale position EST de la forme", positionInitForme,
                this.cadreSelection.getFormeSelectionner().getPosition());
    }
}