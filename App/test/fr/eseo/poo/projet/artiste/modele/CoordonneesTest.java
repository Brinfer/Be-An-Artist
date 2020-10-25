package fr.eseo.poo.projet.artiste.modele;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Classe de test de base (avec asserts et non paramétrée) de la classe
 * {@link Coordonnees}
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.2
 */
public class CoordonneesTest {

	// Couverture pour les constructeurs de Coordonnees : 100%

	/**
	 * Test de {@link Coordonnees#Coordonnees()}.
	 * 
	 * @since 0.3.2.2
	 */
	@Test
	public void testConstructeurVide() {
		final Coordonnees point = new Coordonnees();

		assertEquals(Coordonnees.ABSCISSE_PAR_DEFAUT, point.getAbscisse(), Coordonnees.EPSILON);
		assertEquals(Coordonnees.ORDONNEE_PAR_DEFAUT, point.getOrdonnee(), 1);
	}

	/**
	 * {@link Coordonnees#Coordonnees(double, double)}.
	 * 
	 * @since 0.3.2.2
	 */
	@Test
	public void testConstructeur() {
		final Coordonnees point = new Coordonnees(7.0, 5.0);

		assertEquals(7.0, point.getAbscisse(), Coordonnees.EPSILON);
		assertEquals(5.0, point.getOrdonnee(), Coordonnees.EPSILON);
	}

	// Couverture instruction pour equals : 100%
	// Couverture branche pour equals : 100%

	/**
	 * Test de {@link Coordonnees#equals(Object)}.
	 * 
	 * @since 0.3.2.2
	 */
	@Test
	public void testEquals() {
		final Coordonnees pointReference = new Coordonnees(25.50, 25.50);
		final Coordonnees pointIdentique = new Coordonnees(25.50, 25.50);
		final Coordonnees pointDifferent1 = new Coordonnees(30.00, 30.00);
		final Coordonnees pointDifferent2 = new Coordonnees(25.50, 30.00);
		final Coordonnees pointDifferent3 = new Coordonnees(30.00, 25.50);
		final Coordonnees pointIdentiqueEpsilon = new Coordonnees(25.502, 25.502);
		final Coordonnees pointDifferentEpsilon = new Coordonnees(25.51, 25.51);
		final Object object = new Object();

		assertTrue("Test equals(), comparaison même expression", pointReference.equals(pointReference));
		assertTrue("Test equals(), comparaison même point", pointReference.equals(pointIdentique));
		assertTrue("Test equals(), comparaison point identique a epsilon pret",
				pointReference.equals(pointIdentiqueEpsilon));
		assertFalse("Test equals(), comparaison point different", pointReference.equals(pointDifferent1));
		assertFalse("Test equals(), comparaison point different abscisse", pointReference.equals(pointDifferent2));
		assertFalse("Test equals(), comparaison point different ordonnee", pointReference.equals(pointDifferent3));
		assertFalse("Test equals(), comparaison point different a epsilon pret",
				pointReference.equals(pointDifferentEpsilon));
		assertFalse("Test equals();, comparaison autre instance", pointReference.equals(object));
	}

}
