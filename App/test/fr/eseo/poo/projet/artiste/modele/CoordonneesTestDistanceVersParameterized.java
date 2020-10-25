package fr.eseo.poo.projet.artiste.modele;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test parametree de {@link Coordonnees#distanceVers(Coordonnees)}.
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.2
 */
@RunWith(Parameterized.class)
public class CoordonneesTestDistanceVersParameterized {

	/**
	 * Attribut représentant le premier point.
	 */
	private final Coordonnees c1;

	/**
	 * Attribut représetant le deuxième point.
	 */
	private final Coordonnees c2;

	/**
	 * Attribut representant la distance attendue entre les deux points.
	 */
	private final double distanceAttendu;

	/**
	 * Constructeur pour chaque donne de test.
	 * 
	 * @param c1              le premier point.
	 * @param c2              le deuxième point.
	 * @param distanceAttendu distance attendue entre les deux points.
	 */
	public CoordonneesTestDistanceVersParameterized(final Coordonnees c1, final Coordonnees c2,
			final double distanceAttendu) {
		this.c1 = c1;
		this.c2 = c2;
		this.distanceAttendu = distanceAttendu;
	}

	/**
	 * Creation du jeu de test.
	 * 
	 * @return l'ensemble des donnees de test.
	 */
	@Parameters(name = "dt[{index}] : {0}, {1}, {2}")
	public static Collection<Object[]> dt() {
		final Object[][] data = new Object[][] {
				// Test 0: les deux points sont superosés.
				{ new Coordonnees(), new Coordonnees(), 0.0 },
				// Test 1: le deuxième point est au-dessus du premier.
				{ new Coordonnees(), new Coordonnees(0.0, 1.0), 1.0 },
				// Test 2: le deuxième point est au-dessous du premier.
				{ new Coordonnees(), new Coordonnees(0.0, -1.0), 1.0 },
				// Test 3: le deuxième point est à droite du premier.
				{ new Coordonnees(), new Coordonnees(1.0, 0.0), 1.0 },
				// Test 4: le deuxième point est à gauche du premier.
				{ new Coordonnees(), new Coordonnees(-1.0, 0.0), 1.0 },
				// Test 5: le deuxième point est en bas à gauche du premier point.
				{ new Coordonnees(), new Coordonnees(-3.0, -5.0), 5.830951895 },
				// Test 6: le deuxième point est en bas à droite du premier point.
				{ new Coordonnees(), new Coordonnees(3.0, -5.0), 5.830951895 },
				// Test 7: le deuxième point est en haut à gauche du premier point.
				{ new Coordonnees(), new Coordonnees(3.0, 5.0), 5.830951895 },
				// Test 8: le deuxième point est en haut à droite du premier point.
				{ new Coordonnees(), new Coordonnees(-3.0, 5.0), 5.830951895 }, };
		return Arrays.asList(data);
	}

	// Couverture des instruction pour distanceVers : 100%

	/**
	 * Test de {@link Coordonnees#distanceVers(Coordonnees)}.
	 */
	@Test
	public void testDistanceVers() {
		assertEquals("Test distanceVers(): ", this.distanceAttendu, this.c1.distanceVers(this.c2), Coordonnees.EPSILON);
	}
}