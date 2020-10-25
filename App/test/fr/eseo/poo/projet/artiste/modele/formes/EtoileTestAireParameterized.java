package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test de parametre de {@link Etoile#aire()}.
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.7
 */
@RunWith(Parameterized.class)

public class EtoileTestAireParameterized {

    /**
     * Attribut representant l'Etoile que l'on teste.
     */
    private final Etoile etoile;

    /**
     * Attribut representant l'aire attendue.
     */
    private final double aireAttendue;

    /**
     * Constructeur pour chaque donnee de test.
     * 
     * @param Etoile       l'Etoile dont on veut tester l'aire.
     * @param aireAttendue l'aire attendue de l'Etoile.
     */
    public EtoileTestAireParameterized(final Etoile etoile, final double aireAttendue) {
        this.etoile = etoile;
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
                // Etoile par défaut
                { new Etoile(), 4132.86506 },

                // Modification de la taille de l'étoile
                { new Etoile(377), 26106.66566 }, { new Etoile(536), 52771.35995 }, { new Etoile(73), 978.84613 },
                { new Etoile(13), 31.04241 }, { new Etoile(800), 117557.05046 },

                // Modification de la taille des branches
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
                        Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0), 16531.46022 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
                        Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0.1), 14878.3142 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
                        Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0.18), 13555.79738 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
                        Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0.27), 12067.96596 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
                        Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0.5), 8265.73011 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
                        Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0.73), 4463.49426 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
                        Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0.84), 2645.03364 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
                        Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0.99), 165.3146 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
                        Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 1), 0 },

                // Modification du nombre de branche
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, 3, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
                        Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 3653.54467 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, 4, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
                        Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 3977.47564 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, 7, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
                        Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 4271.04306 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, 10, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
                        Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 4345.55148 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, 12, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
                        Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 4367.57139 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, 15, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
                        Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 4385.63723 },

        };
        return Arrays.asList(data);
    }

    // Couverture instruction pour aire : 100%

    /**
     * Test de la méthode {@link Etoile#aire()}
     */
    @Test
    public void testAireEtoile() {
        assertEquals("Test de aire(): ", this.aireAttendue, this.etoile.aire(), Forme.EPSILON);
    }
}