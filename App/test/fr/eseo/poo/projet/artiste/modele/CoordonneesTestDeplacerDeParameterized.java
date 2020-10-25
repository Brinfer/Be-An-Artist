package fr.eseo.poo.projet.artiste.modele;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test parametree de {@link Coordonnees#deplacerDe(double, double)}
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.2
 */
@RunWith(Parameterized.class)
public class CoordonneesTestDeplacerDeParameterized {

	/**
	 * Abscisse initiale du point
	 */
	private final double x1;

	/**
	 * Ordonnee initiale du point
	 */
	private final double y1;

	/**
	 * Abscisse finale attendue point
	 */
	private final double x2;

	/**
	 * Ordonnee finale attendue du point
	 */
	private final double y2;

	/**
	 * Constructeur pour chaque donne de test pour Coordonnees.
	 * 
	 * @param x1 abscisse du premier point.
	 * @param y1 ordonnee du premier point.
	 * @param x2 nouvelle abscisse attendue.
	 * @param y2 nouvelle ordonnee attendue.
	 */
	public CoordonneesTestDeplacerDeParameterized(final double x1, final double y1, final double x2, final double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	/**
	 * Creation du jeu de test.
	 * 
	 * @return l'ensemble des donnees de test.
	 */
	@Parameters(name = "dt[{index}] : {0}, {1}, {2}, {3}")
	public static Collection<Object[]> dt() {
		final Object[][] data = new Object[][] {
				// Test 0: aucun deplacement.
				{ 0.0, 0.0, 0.0, 0.0 },
				// Test 1: deplacement de 1 vers la bas.
				{ 0.0, 0.0, 0.0, 1.0 },
				// Test 2: deplacement de 1 vers la gauche.
				{ 0.0, 0.0, 1.0, 0.0 },
				// Test 3: deplacement de 3 vers la gauche et de 5 vers le haut.
				{ 0.0, 0.0, -3.0, -5.0 },
				// Test 4: deplacement de 4 vers la droite et de 6 vers le bas.
				{ 0.0, 0.0, 4.0, 6.0 }, };
		return Arrays.asList(data);
	}

	// Couverture des instructions pour deplacerDe : 100%

	/**
	 * Test de {@link Coordonnees#deplacerDe(double, double)}.
	 */
	@Test
	public void testDeplacerDe() {
		final Coordonnees c1 = new Coordonnees(this.x1, this.y1);
		final Coordonnees c2 = new Coordonnees(this.x1 + this.x2, this.y1 + this.y2);

		c1.deplacerDe(this.x2, this.y2);

		assertEquals("Test deplacerDe(): ", c2, c1);
	}
}