
package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Classe de test de base (avec asserts et non parametre) de la classe
 * {@link Forme}
 * 
 * @see FormeConcreteTest
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.3
 */
public class FormeTest {

	// Couverture des instruction pour l'ensemble des constructeurs : 100%

	/**
	 * Test de {@link Forme#Forme()}.
	 */
	@Test
	public void testConstructeurVide() {
		final FormeConcreteTest forme = new FormeConcreteTest();

		final Coordonnees origine = new Coordonnees();

		assertEquals("Test de l'origine de la ligne", origine, forme.getPosition());
		assertEquals("Test de la hauteur de la ligne", Forme.HAUTEUR_PAR_DEFAUT, forme.getHauteur(), Forme.EPSILON);
		assertEquals("Test de la largeur de la ligne", Forme.LARGEUR_PAR_DEFAUT, forme.getLargeur(), Forme.EPSILON);
	}

	/**
	 * Test de {@link Forme#Forme(Coordonnees)}.
	 * 
	 * @since 0.3.2.3
	 */
	@Test
	public void testConstructeurCoordonnees() {
		final Coordonnees origine = new Coordonnees(5.0, 10.0);

		final FormeConcreteTest forme = new FormeConcreteTest(origine);

		assertEquals("Test de l'origine de la ligne", origine, forme.getPosition());
		assertEquals("Test de la hauteur de la ligne", Forme.HAUTEUR_PAR_DEFAUT, forme.getHauteur(), Forme.EPSILON);
		assertEquals("Test de la largeur de la ligne", Forme.LARGEUR_PAR_DEFAUT, forme.getLargeur(), Forme.EPSILON);
	}

	/**
	 * Test de {@link Forme#Forme(double, double)}.
	 * 
	 * @since 0.3.2.3
	 */
	@Test
	public void testConstructeurHauteurLargeur() {
		final double hauteur = 10.0;
		final double largeur = 15.0;
		final FormeConcreteTest forme = new FormeConcreteTest(largeur, hauteur);
		final Coordonnees origine = new Coordonnees();

		assertEquals("Test de l'origine de la ligne", origine, forme.getPosition());
		assertEquals("Test de la hauteur de la ligne", hauteur, forme.getHauteur(), Forme.EPSILON);
		assertEquals("Test de la largeur de la ligne", largeur, forme.getLargeur(), Forme.EPSILON);
	}

	/**
	 * Test de {@link Forme#Forme(Coordonnees, double, double)}.
	 * 
	 * @since 0.3.2.3
	 */
	@Test
	public void testConstructeurPlein() {
		final double hauteur = 10.0;
		final double largeur = 15.0;
		final Coordonnees origine = new Coordonnees();
		final FormeConcreteTest forme = new FormeConcreteTest(origine, largeur, hauteur);

		assertEquals("Test de l'origine de la ligne", origine, forme.getPosition());
		assertEquals("Test de la hauteur de la ligne", hauteur, forme.getHauteur(), Forme.EPSILON);
		assertEquals("Test de la largeur de la ligne", largeur, forme.getLargeur(), Forme.EPSILON);
    }
    
    /**
	 * Test de {@link Forme#equals(Object)}.
	 * 
	 * @since 0.3.2.3
	 */
	@Test
	public void testEquals() {
		final FormeConcreteTest formeReference = new FormeConcreteTest(25.50, 35.50);
		final FormeConcreteTest formeIdentique = new FormeConcreteTest(25.50, 35.50);
		final FormeConcreteTest formeDifferent1 = new FormeConcreteTest(30.00, 40.00);
		final FormeConcreteTest formeDifferent2 = new FormeConcreteTest(25.50, 25.50);
		final FormeConcreteTest formeDifferent3 = new FormeConcreteTest(35.50, 25.50);
		final FormeConcreteTest formeIdentiqueEpsilon = new FormeConcreteTest(25.5001, 35.5001);
		final FormeConcreteTest formeDifferentEpsilon = new FormeConcreteTest(25.502, 35.502);
		final Object object = new Object();

		assertTrue("Test equals(), comparaison même expression", formeReference.equals(formeReference));
		assertTrue("Test equals(), comparaison même forme", formeReference.equals(formeIdentique));
		assertTrue("Test equals(), comparaison forme identique a epsilon pret",
				formeReference.equals(formeIdentiqueEpsilon));
		assertFalse("Test equals(), comparaison forme different", formeReference.equals(formeDifferent1));
		assertFalse("Test equals(), comparaison forme different abscisse", formeReference.equals(formeDifferent2));
		assertFalse("Test equals(), comparaison forme different ordonnee", formeReference.equals(formeDifferent3));
		assertFalse("Test equals(), comparaison forme different a epsilon pret",
				formeReference.equals(formeDifferentEpsilon));
		assertFalse("Test equals();, comparaison autre instance", formeReference.equals(object));
	}
}
