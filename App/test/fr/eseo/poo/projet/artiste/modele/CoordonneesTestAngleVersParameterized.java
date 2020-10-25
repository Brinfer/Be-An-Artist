package fr.eseo.poo.projet.artiste.modele;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test parametree de {@link Coordonnees#angleVers(Coordonnees)}.
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.2
 */
@RunWith(Parameterized.class)
public class CoordonneesTestAngleVersParameterized {

    /**
     * Attribut representant le premier point.
     */
    private final Coordonnees c1;

    /**
     * Attribut represetant le deuxieme point.
     */
    private final Coordonnees c2;
    /**
     * Attribut representant l'angle attendue
     */
    private final double angleAttendu;

    /**
     * Constructeur pour chaque donne de test.
     * 
     * @param c1           le premier point.
     * @param c2           le deuxieme point.
     * @param angleAttendu angle attendue entre les deux points.
     */
    public CoordonneesTestAngleVersParameterized(final Coordonnees c1, final Coordonnees c2,
            final double angleAttendu) {
        this.c1 = c1;
        this.c2 = c2;
        this.angleAttendu = angleAttendu;
    }

    /**
     * Creation du jeu de test.
     * 
     * @return l'ensemble des donnees de test.
     */
    @Parameters(name = "dt[{index}] : {0}, {1}, {2}")
    public static Collection<Object[]> dt() {
        final Object[][] data = new Object[][] {
                // Test 0: les deux points sont superoses, angle de 0 degres.
                { new Coordonnees(), new Coordonnees(), 0.0 },

                // Test 1: le deuxieme point est en-dessous à droite du premier, angle de 30
                // degres.
                { new Coordonnees(), new Coordonnees(Math.sqrt(3) / 2, 0.5), Math.PI / 6 },

                // Test 2: le deuxieme point est en-dessous à droite du premier, angle de 45
                // degres.
                { new Coordonnees(), new Coordonnees(Math.sqrt(2) / 2, Math.sqrt(2) / 2), Math.PI / 4 },

                // Test 3: le deuxieme point est en-dessous à droite du premier, angle de 60
                // degres.
                { new Coordonnees(), new Coordonnees(0.5, Math.sqrt(3) / 2), Math.PI / 3 },

                // Test 4: le deuxieme point est en-dessous du premier, angle de 90 degres.
                { new Coordonnees(), new Coordonnees(0.0, 1.0), Math.PI / 2 },

                // Test 5: le deuxieme point est en-dessous à gauche du premier, angle de 120
                // degres.
                { new Coordonnees(), new Coordonnees(-0.5, Math.sqrt(3) / 2), 2 * Math.PI / 3 },

                // Test 6: le deuxieme point est en-dessous à gauche du premier, angle de 135
                // degres.
                { new Coordonnees(), new Coordonnees(-Math.sqrt(2) / 2, Math.sqrt(2) / 2), 3 * Math.PI / 4 },

                // Test 7: le deuxieme point est en-dessous à gauche du premier, angle de 150
                // degres.
                { new Coordonnees(), new Coordonnees(-Math.sqrt(3) / 2, 0.5), 5 * Math.PI / 6 },

                // Test 8: le deuxieme point est à gauche du premier, 180 degrees.
                { new Coordonnees(), new Coordonnees(-1.0, 0.0), Math.PI },

                // Test 9: le deuxieme point est au-dessus à gauche du premier, angle de 210
                // degres.
                { new Coordonnees(), new Coordonnees(-Math.sqrt(3) / 2, -0.5), -5 * Math.PI / 6 },

                // Test 10: le deuxieme point est au-dessus à gauche du premier, angle de 225
                // degres.
                { new Coordonnees(), new Coordonnees(-Math.sqrt(2) / 2, -Math.sqrt(2) / 2), -3 * Math.PI / 4 },

                // Test 11: le deuxieme point est au-dessus à gauche du premier, angle de 240
                // degres.
                { new Coordonnees(), new Coordonnees(-0.5, -Math.sqrt(3) / 2), -2 * Math.PI / 3 },

                // Test 12: le deuxieme point est au-dessus du premier, angle de 270 degres.
                { new Coordonnees(), new Coordonnees(0.0, -1.0), -Math.PI / 2 },

                // Test 13: le deuxieme point est au-dessus à droite du premier, angle de 300
                // degres.
                { new Coordonnees(), new Coordonnees(0.5, -Math.sqrt(3) / 2), -Math.PI / 3 },

                // Test 14: le deuxieme point est au-dessus à droite du premier, angle de 315
                // degres.
                { new Coordonnees(), new Coordonnees(Math.sqrt(2) / 2, -Math.sqrt(2) / 2), -Math.PI / 4 },

                // Test 15: le deuxieme point est au-dessus à droite du premier, angle de 315
                // degres.
                { new Coordonnees(), new Coordonnees(Math.sqrt(3) / 2, -0.5), -Math.PI / 6 } };
        return Arrays.asList(data);

    }

    // Couverture des instructions pour angleVers : 100%

    /**
     * Test de {@link Coordonnees#angleVers(Coordonnees)}.
     */
    @Test
    public void testgetAngleVers() {
        assertEquals("Test d'angleVers()", this.angleAttendu, this.c1.angleVers(this.c2), Coordonnees.EPSILON);
    }
}