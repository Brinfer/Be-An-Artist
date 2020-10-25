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
 * Classe de test parametree de {@link Forme#getCadreMinY()}.
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.3
 */
@RunWith(Parameterized.class)
public class FormeTestGetCadreMinYParameterized {

	/**
	 * Attribue representant la forme que l'on teste.
	 */
	private final FormeConcreteTest forme;

	/**
	 * Attribue representant l'abscisse des coins du haut du rectangle englobant la
	 * forme.
	 */
	private final double ordonneeAttendue;

	/**
	 * Constructeur pour chaque donnee de test.
	 * 
	 * @param forme            la forme que l'on teste.
	 * @param ordonneeAttendue l'abcisse des coins du haut du rectangle qui englobe
	 *                         forme.
	 */
	public FormeTestGetCadreMinYParameterized(final FormeConcreteTest forme, final double ordonneeAttendue) {
		this.forme = forme;
		this.ordonneeAttendue = ordonneeAttendue;
	}

	/**
	 * Creation du jeu de test.
	 * 
	 * @return l'ensemble des donnees de test.
	 */
	@Parameters(name = "dt[{index}] : {0}, {1}, {2}, {3}, {4}")
	public static Collection<Object[]> dt() {
		final Object[][] data = new Object[][] {
			// Test 0: Forme positionne en (0, 0), de largeur 1, et de hauteur 1, l'ordonnee
				// des coins du haut attendu est 0.
				{ new FormeConcreteTest(new Coordonnees(), 1, 1), 0 },
				// Test 1: Forme positionne en (0, 0), de largeur 1, et de hauteur -1,
				// l'ordonnee des coins du haut attendu est -1.
				{ new FormeConcreteTest(new Coordonnees(), 1, -1), -1 },
				// Test 2: Forme positionne en (0, 0), de largeur -1, et de hauteur -1,
				// l'ordonnee des coins du haut attendu est -1.
				{ new FormeConcreteTest(new Coordonnees(), -1, -1), -1 },
				// Test 3: Forme positionne en (0, 0), de largeur -1, et de hauteur 1,
				// l'ordonnee des coins du haut attendu est 0.
				{ new FormeConcreteTest(new Coordonnees(), -1, 1), 0 },
				// Test 4: Forme positionne en (0, 0), de largeur 0, et de hauteur 1, l'ordonnee
				// des coins du haut attendu est 0.
				{ new FormeConcreteTest(new Coordonnees(), 0, 1), 0 },
				// Test 5: Forme positionne en (0, 0), de largeur 0, et de hauteur -1,
				// l'ordonnee des coins du haut attendu est -1.
				{ new FormeConcreteTest(new Coordonnees(), 0, -1), -1 },
				// Test 6: Forme positionne en (0, 0), de largeur 0, et de hauteur 0, l'ordonnee
				// des coins du haut attendu est 0.
				{ new FormeConcreteTest(new Coordonnees(), 0, 0), 0 },
				// Test 7: Forme positionne en (0, 0), de largeur 1, et de hauteur 0, l'ordonnee
				// des coins du haut attendu est 0.
				{ new FormeConcreteTest(new Coordonnees(), 1, 0), 0 },
				// Test 8: Forme positionne en (0, 0), de largeur -1, et de hauteur 0,
				// l'ordonnee des coins du haut attendu est 0.
				{ new FormeConcreteTest(new Coordonnees(), -1, 0), 0 } };
		return Arrays.asList(data);
	}

	// Couverture des instruction pour getCadreMinY : 100%

	/**
	 * Test de {@link Forme#getCadreMinY()}
	 */
	@Test
	public void testGetCadreMinY() {
		assertEquals("Test de getCadreMinY(): ", this.ordonneeAttendue, this.forme.getCadreMinY(), Forme.EPSILON);
	}
}