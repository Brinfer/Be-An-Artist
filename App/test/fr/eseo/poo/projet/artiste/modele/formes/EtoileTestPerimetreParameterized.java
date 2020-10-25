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
 * Classe de test parametre de {@link Etoile#perimetre()}.
 * 
 * @author Brinfer
 * 
 * @since 0.3.7.1
 */
@RunWith(Parameterized.class)
public class EtoileTestPerimetreParameterized {

    /**
     * Attribut representant l'Etoile que l'on teste.
     */
    private final Etoile etoile;

    /**
     * Attribut representant le perimetre attendue.
     */
    private final double perimetreAttendue;

    /**
     * Constructeur pour chaque donnee de test.
     * 
     * @param etoile            l'Etoile dont on veut tester le périmètre.
     * @param perimetreAttendue le perimetre attendue de l'Etoile.
     */
    public EtoileTestPerimetreParameterized(final Etoile etoile, final double perimetreAttendue) {
        this.etoile = etoile;
        this.perimetreAttendue = perimetreAttendue;
    }

    /**
     * Création du jeu de test.
     * 
     * @return l'ensemble des données de test.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {

                // Test enmodifiant la taille de l'etoile
                { new Etoile(), 608.3751 }, { new Etoile(100), 405.5833 }, { new Etoile(200), 811.1668 },
                { new Etoile(152.154), 617.1111 },

                // Test en modifiant la taille des branches
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
                        Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0.5), 498.0491 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
                        Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0.6), 537.0683 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
                        Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0.25), 443.0555 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
                        Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 1), 750 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
                        Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0.9), 690.7319 },

                // Test en modifiant le nombre de branches
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, 3, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
                        Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 405.6245 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, 4, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
                        Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 505.1938 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, 7, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
                        Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 821.4299 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, 10, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
                        Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 1149.2112 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, 15, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
                        Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 1703.8105 },

                // Test en modifiant l'angle de la premiere branche
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 0.0,
                        Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 608.3751 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, -Math.PI,
                        Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 608.3751 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
                        -0.5 * Math.PI, Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 608.3751 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
                        0.5 * Math.PI, Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 608.3751 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, Math.PI,
                        Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 608.3751 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 2.4589,
                        Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 608.3751 },
                { new Etoile(new Coordonnees(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, -0.5137,
                        Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT), 608.3751 }, };
        return Arrays.asList(data);

    }

    // Couverture des instructions pour perimetre : 100%

    /**
     * Test de la méthode {@link Etoile#perimetre()}
     */
    @Test
    public void testPerimetreEtoile() {
        assertEquals("Test de perimetre(): ", this.perimetreAttendue, this.etoile.perimetre(), Forme.EPSILON);
    }
}
