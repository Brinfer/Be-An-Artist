package fr.eseo.poo.projet.artiste.modele;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Classe de test parametree de {@link Coordonnees#toString()}
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.2
 */
@RunWith(Parameterized.class)
public class CoordonneesTestToStringParameterized {

	private final Coordonnees coordonnees;

	/**
	 * La description attendue.
	 */
	private final String descriptionAttendue;

	/**
	 * Constructeur pour chaque donne de test.
	 * 
	 * @param coordonnees         le point dont on veut tester la description.
	 * @param descriptionAttendue la description attendue.
	 */
	public CoordonneesTestToStringParameterized(final Coordonnees coordonnees, final String descriptionAttendue) {
		this.coordonnees = coordonnees;
		this.descriptionAttendue = descriptionAttendue;
	}

	/**
	 * Creation du jeu de test.
	 * 
	 * @return l'ensemble des donnees de test.
	 */
	@Parameters(name = "dt[{index}] : {0}, {1}")
	public static Collection<Object[]> dt() {
		final Object[][] data = new Object[][] {
				// Test 0: présentation attendue : (0,0 , 0,0).
				{ new Coordonnees(), "(0,0 , 0,0)" },
				// Test 1: présentation attendue : (1,0 , 1,0).
				{ new Coordonnees(1, 1), "(1,0 , 1,0)" },
				// Test 2: présentation attendue : (1,05 , 1,05).
				{ new Coordonnees(1.05, 1.05), "(1,05 , 1,05)" },
				// Test 3: présentation attendue : (1,05 , 1,05).
				{ new Coordonnees(1.055, 1.055), "(1,05 , 1,05)" },
				// Test 4: présentation attendue : (10;0 , 10,0).
				{ new Coordonnees(10, 10), "(10,0 , 10,0)" },
				// Test 5: présentation attendue : (99999,0 , 99999,0).
				{ new Coordonnees(99999, 99999), "(99999,0 , 99999,0)" },
				// Test 6: présentation attendue : (-1,0 , -1,0).
				{ new Coordonnees(-1, -1), "(-1,0 , -1,0)" },
				// Test 7: présentation attendue : (-1,0 , 1,0).
				{ new Coordonnees(-1, 1), "(-1,0 , 1,0)" },
				// Test 8: présentation attendue : (1,0 , -1,0).
				{ new Coordonnees(1, -1), "(1,0 , -1,0)" } };
		return Arrays.asList(data);
	}

	// Couverture des instruction pour toString : 100%

	/**
	 * Test de {@link Coordonnees#toString()}
	 */
	@Test
	public void testToString() {
		final String description = this.coordonnees.toString();

		assertEquals("Test de la fonction toString()", this.descriptionAttendue, description);
	}
}
