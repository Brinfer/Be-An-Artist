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
 * Classe de test parametree de {@link Forme#getCadreMaxX()}.
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.3
 */
@RunWith(Parameterized.class)
public class FormeTestGetCadreMaxXParameterized {

	/**
	 * Attribue representant la forme que l'on teste.
	 */
	private final FormeConcreteTest forme;

	/**
	 * Attribue representant l'abscisse des coins droit du rectangle englobant la
	 * forme.
	 */
	private final double abcisseAttendue;

	/**
	 * Constructeur pour chaque donnee de test.
	 * 
	 * @param forme           la forme que l'on teste.
	 * @param abcisseAttendue l'abcisse des coins droit du rectangle qui englobe
	 *                        forme.
	 */
	public FormeTestGetCadreMaxXParameterized(final FormeConcreteTest forme, final double abcisseAttendue) {
		this.forme = forme;
		this.abcisseAttendue = abcisseAttendue;
	}

	/**
	 * Cr�ation du jeu de test.
	 * 
	 * @return l'ensemble des donn�es de test.
	 */
	@Parameters(name = "dt[{index}] : {0}, {1}")
	public static Collection<Object[]> dt() {
		final Object[][] data = new Object[][] {
				// Test 0: Forme positionn� en (0, 0), de largeur 1, et de hauteur 1, l'abscisse
				// des coins droits attendu est 1.
				{ new FormeConcreteTest(new Coordonnees(), 1, 1), 1.0 },
				// Test 1: Forme positionn� en (0, 0), de largeur 1, et de hauteur -1,
				// l'abscisse des coins droits attendu est 1.
				{ new FormeConcreteTest(new Coordonnees(), 1, -1), 1.0 },
				// Test 2: Forme positionn� en (0, 0), de largeur -1, et de hauteur -1,
				// l'abscisse des coins droits attendu est 0.
				{ new FormeConcreteTest(new Coordonnees(), -1, -1), 0 },
				// Test 3: Forme positionn� en (0, 0), de largeur -1, et de hauteur 1,
				// l'abscisse des coins droits attendu est 0.
				{ new FormeConcreteTest(new Coordonnees(), -1, 1), 0 },
				// Test 4: Forme positionn� en (0, 0), de largeur 0, et de hauteur 1, l'abscisse
				// des coins droits attendu est 0.
				{ new FormeConcreteTest(new Coordonnees(), 0, 1), 0 },
				// Test 5: Forme positionn� en (0, 0), de largeur 0, et de hauteur -1,
				// l'abscisse des coins droits attendu est 0.
				{ new FormeConcreteTest(new Coordonnees(), 0, -1), 0 },
				// Test 6: Forme positionn� en (0, 0), de largeur 0, et de hauteur 0, l'abscisse
				// des coins droits attendu est 0.
				{ new FormeConcreteTest(new Coordonnees(), 0, 0), 0 },
				// Test 7: Forme positionn� en (0, 0), de largeur 1, et de hauteur 0, l'abscisse
				// des coins droits attendu est 1.
				{ new FormeConcreteTest(new Coordonnees(), 1, 0), 1 },
				// Test 8: Forme positionn� en (0, 0), de largeur -1, et de hauteur 0,
				// l'abscisse des coins droits attendu est 0.
				{ new FormeConcreteTest(new Coordonnees(), -1, 0), 0 } };
		return Arrays.asList(data);
	}

	// Couverture des instruction pour getCadreMaxX : 100%

	/**
	 * Test de {@link Forme#getCadreMaxX()}.
	 */
	@Test
	public void testGetCadreMaxX() {
		assertEquals("Test de getCadreMaxX(): ", this.abcisseAttendue, this.forme.getCadreMaxX(), Forme.EPSILON);
	}
}