package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Classe de test parametree de {@link Forme#deplacerVers(double, double)}.
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.3
 */
@RunWith(Parameterized.class)
public class FormeTestDeplacerVersParameterized {

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
	 * Constructeur pour chaque donne de test pour Coordonnees
	 * 
	 * @param x1 abscisse du premier point
	 * @param y1 ordonnee du premier point
	 * @param x2 nouvelle abscisse attendue
	 * @param y2 nouvelle ordonnee attendue
	 */
	public FormeTestDeplacerVersParameterized(final double x1, final double y1, final double x2, final double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	/**
	 * Création du jeu de test
	 * 
	 * @return l'ensemble des données de test
	 */
	@Parameters(name = "dt[{index}] : {0}, {1}, {2}, {3}")
	public static Collection<Object[]> dt() {
		final Object[][] data = new Object[][] { { 0.0, 0.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0 }, { 0.0, 0.0, 1.0, 0.0 },
				{ 0.0, 0.0, -3.0, -5.0 }, { 0.0, 0.0, 4.0, 6.0 }, };
		return Arrays.asList(data);
	}

	// Couverture instruction pour deplacerVers : 100%

	/**
	 * Test de {@link Forme#deplacerVers(double, double)}
	 */
	@Test
	public void testDeplacerVers() {
		final Coordonnees c2 = new Coordonnees(this.x2, this.y2);

		final FormeConcreteTest forme = new FormeConcreteTest(new Coordonnees(this.x1, this.y1));

		forme.deplacerVers(this.x2, this.y2);

		assertEquals("Test deplacerVers(): ", c2, forme.getPosition());
	}
}
