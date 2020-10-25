package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Classe de test de base (avec asserts et non parametré) de la classe
 * {@link Etoile}.
 * 
 * @author Brinfer
 * 
 * @since 0.3.7.1
 */
public class EtoileTest {

	// Couverture des instructions de l'ensemble des constructeurs : 100%
	// Couvertures des branches des constructeurs : 100%

	// Couverture des instructions de setNombreBranches() : 100%
	// Couverture des branches de setNombreBranches() : 100%

	// Couverture des instructions de setAnglePremiereBranche() : 100%
	// Couverture des branches de setAnglePremiereBranche() : 100%

	// Couverture des instructions de setLongueurBranche() : 100%
	// Couverture des branches de setLongueurBranche() : 100%

	// Couverture des instructions de setHauteur() : 100%
	// Couverture des branches de setHauteur() : 100%

	// Couverture des instructions de setLargeur() : 100%
	// Couverture des branches de setLargeur() : 100%

	// Couverture des instructions de equals() : 100%
	// Couverture des branches de equals() : 91.7%

	/**
	 * Test de {@link Etoile#Etoile()}
	 * 
	 * @since 0.3.7.1
	 */
	@Test
	public void testConstructeurVide() {
		final Etoile etoile = new Etoile();

		assertEquals("Test nombre de branche", etoile.getNombreBranches(), Etoile.NOMBRE_BRANCHES_PAR_DEFAUT);
		assertEquals("Test angle premiere branche", etoile.getAnglePremiereBranche(),
				Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, Etoile.EPSILON);
		assertEquals("Test longueur branche", etoile.getLongueurBranche(), Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT,
				Etoile.EPSILON);
		assertEquals("Test position", etoile.getPosition(), new Coordonnees());
		assertEquals("Test hauteur", etoile.getHauteur(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.EPSILON);
		assertEquals("Test largeur", etoile.getLargeur(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.EPSILON);
	}

	/**
	 * Test de {@link Etoile#Etoile(double)}
	 * 
	 * @since 0.3.7.1
	 */
	@Test
	public void testConstructeurTaille() {
		final double taille = 120.0;
		final Etoile etoile = new Etoile(taille);

		assertEquals("Test nombre de branche", etoile.getNombreBranches(), Etoile.NOMBRE_BRANCHES_PAR_DEFAUT);
		assertEquals("Test angle premiere branche", etoile.getAnglePremiereBranche(),
				Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, Etoile.EPSILON);
		assertEquals("Test longueur branche", etoile.getLongueurBranche(), Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT,
				Etoile.EPSILON);
		assertEquals("Test position", etoile.getPosition(), new Coordonnees());
		assertEquals("Test hauteur", etoile.getHauteur(), taille, Etoile.EPSILON);
		assertEquals("Test largeur", etoile.getLargeur(), taille, Etoile.EPSILON);
	}

	/**
	 * Test de {@link Etoile#Etoile(Coordonnees)}
	 * 
	 * @since 0.3.7.1
	 */
	@Test
	public void testConstructeurCoordonnees() {
		final Coordonnees position = new Coordonnees(105.88, 71.60);
		final Etoile etoile = new Etoile(position);

		assertEquals("Test nombre de branche", etoile.getNombreBranches(), Etoile.NOMBRE_BRANCHES_PAR_DEFAUT);
		assertEquals("Test angle premiere branche", etoile.getAnglePremiereBranche(),
				Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, Etoile.EPSILON);
		assertEquals("Test longueur branche", etoile.getLongueurBranche(), Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT,
				Etoile.EPSILON);
		assertEquals("Test position", etoile.getPosition(), position);
		assertEquals("Test hauteur", etoile.getHauteur(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.EPSILON);
		assertEquals("Test largeur", etoile.getLargeur(), Etoile.LARGEUR_PAR_DEFAUT, Etoile.EPSILON);
	}

	/**
	 * Test de {@link Etoile#Etoile(Coordonnees, double)}
	 * 
	 * @since 0.3.7.1
	 */
	@Test
	public void testConstructeurCoordonneesTaille() {
		final double taille = 75.54;
		final Coordonnees position = new Coordonnees(162.92, 86.99);
		final Etoile etoile = new Etoile(position, taille);

		assertEquals("Test nombre de branche", etoile.getNombreBranches(), Etoile.NOMBRE_BRANCHES_PAR_DEFAUT);
		assertEquals("Test angle premiere branche", etoile.getAnglePremiereBranche(),
				Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, Etoile.EPSILON);
		assertEquals("Test longueur branche", etoile.getLongueurBranche(), Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT,
				Etoile.EPSILON);
		assertEquals("Test position", etoile.getPosition(), position);
		assertEquals("Test hauteur", etoile.getHauteur(), taille, Etoile.EPSILON);
		assertEquals("Test largeur", etoile.getLargeur(), taille, Etoile.EPSILON);
	}

	/**
	 * Test de {@link Etoile#Etoile(Coordonnees, double, int, double, double)}
	 * 
	 * @since 0.3.7.1
	 */
	@Test
	public void testConstructeurPlein() {
		final double taille = 201.87;
		final Coordonnees position = new Coordonnees(207.34, 181.73);
		final int nombreBranche = 10;
		final double anglePremiereBranche = 1.30899694; // Angle de 75°
		final double longueurBranche = 0.5;
		final Etoile etoile = new Etoile(position, taille, nombreBranche, anglePremiereBranche, longueurBranche);

		assertEquals("Test nombre de branche", etoile.getNombreBranches(), nombreBranche);
		assertEquals("Test angle premiere branche", etoile.getAnglePremiereBranche(), anglePremiereBranche,
				Etoile.EPSILON);
		assertEquals("Test longueur branche", etoile.getLongueurBranche(), longueurBranche, Etoile.EPSILON);
		assertEquals("Test position", etoile.getPosition(), position);
		assertEquals("Test hauteur", etoile.getHauteur(), taille, Etoile.EPSILON);
		assertEquals("Test largeur", etoile.getLargeur(), taille, Etoile.EPSILON);
	}

	/**
	 * Test de {@link Etoile#setHauteur(double)} avec une hauteur inférieur à 0.
	 * L'erreur {@link IllegalArgumentException} est attendue.
	 * 
	 * @since 0.3.7.1
	 */
	public void testSetHauteurError() throws IllegalArgumentException {
		Etoile etoile = new Etoile();
		assertThrows(IllegalArgumentException.class, () -> etoile.setHauteur(-10));
		assertThrows(IllegalArgumentException.class, () -> etoile.setHauteur(0));
	}

	/**
	 * Test de {@link Etoile#setLargeur(double)} avec une largeur égale à 0.
	 * L'erreur {@link IllegalArgumentException} est attendue.
	 * 
	 * @since 0.3.7.1
	 */
	@Test
	public void testSetLargeurError() throws IllegalArgumentException {
		Etoile etoile = new Etoile();
		assertThrows(IllegalArgumentException.class, () -> etoile.setLargeur(-10));
		assertThrows(IllegalArgumentException.class, () -> etoile.setLargeur(0));
	}

	/**
	 * Test de {@link Etoiles#setLongueurBranche(double)} avec une largeur égale à
	 * 0. L'erreur {@link IllegalArgumentException} est attendue.
	 * 
	 * @since 0.3.7.1
	 */
	@Test
	public void testSetLongueurBranchesError() throws IllegalArgumentException {
		Etoile etoile = new Etoile();
		assertThrows(IllegalArgumentException.class, () -> etoile.setLongueurBranche(-0.1));
		assertThrows(IllegalArgumentException.class, () -> etoile.setLongueurBranche(1.1));
	}

	/**
	 * Test de {@link Etoiles#setAnglePremiereBranche(double)} avec une largeur
	 * égale à 0. L'erreur {@link IllegalArgumentException} est attendue.
	 * 
	 * @since 0.3.7.1
	 */
	@Test
	public void testSetAnglePremiereBrancheError() throws IllegalArgumentException {
		Etoile etoile = new Etoile();
		assertThrows(IllegalArgumentException.class, () -> etoile.setAnglePremiereBranche(-Math.PI - 0.1));
		assertThrows(IllegalArgumentException.class, () -> etoile.setAnglePremiereBranche(Math.PI + 0.1));
	}

	/**
	 * Test de {@link Etoiles#setNombreBranches(int)} avec une largeur égale à 0.
	 * L'erreur {@link IllegalArgumentException} est attendue.
	 * 
	 * @since 0.3.7.1
	 */
	@Test
	public void testSeNombreBrancheError() throws IllegalArgumentException {
		Etoile etoile = new Etoile();
		assertThrows(IllegalArgumentException.class, () -> etoile.setNombreBranches(2));
		assertThrows(IllegalArgumentException.class, () -> etoile.setNombreBranches(16));
	}

	/**
	 * Test de {@link Etoile#equals(Object)}.
	 * 
	 * @since 0.3.7.1
	 */
	@Test
	public void testEquals() {
		final Etoile etoileReference = new Etoile(new Coordonnees(), 135.521, 6, Math.PI / 3, 0.25);
		final Etoile etoileIdentique = new Etoile(new Coordonnees(), 135.521, 6, Math.PI / 3, 0.25);

		final Etoile etoileDifferentNbBranche = new Etoile(new Coordonnees(), 135.521, 7, Math.PI / 3, 0.25);
		final Etoile etoileDifferentLongueur = new Etoile(new Coordonnees(), 135.521, 6, Math.PI / 3, 0.75);
		final Etoile etoileDifferentAngle = new Etoile(new Coordonnees(), 135.521, 6, Math.PI / 4, 0.25);
		final Object object = new Object();

		assertTrue("Test equals(), comparaison même expression", etoileReference.equals(etoileReference));
		assertTrue("Test equals(), comparaison même Etoile", etoileReference.equals(etoileIdentique));

		assertFalse("Test equals(), comparaison Etoile different branches",
				etoileReference.equals(etoileDifferentNbBranche));
		assertFalse("Test equals(), comparaison Etoile different longueur",
				etoileReference.equals(etoileDifferentLongueur));
		assertFalse("Test equals(), comparaison Etoile different angle", etoileReference.equals(etoileDifferentAngle));

		assertFalse("Test equals();, comparaison autre instance", etoileReference.equals(object));
	}
}