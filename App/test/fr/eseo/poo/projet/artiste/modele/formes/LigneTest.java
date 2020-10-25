package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test de base (avec asserts et non parametre) de la classe {@link Ligne}
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.5
 */
public class LigneTest {

	// Couverture instruction pour l'ensemble des constructeurs : 100%

	/**
	 * Test de {@link Ligne#Ligne()}.
	 * 
	 * @since 0.3.2.5
	 */
	@Test
	public void testConstructeurVide() {
		final Ligne ligne = new Ligne();

		final Coordonnees origine = new Coordonnees();

		assertEquals("Test de l'origine de la ligne", origine, ligne.getPosition());
		assertEquals("Test de la hauteur de la ligne", Forme.HAUTEUR_PAR_DEFAUT, ligne.getHauteur(), Ligne.EPSILON);
		assertEquals("Test de la largeur de la ligne", Forme.LARGEUR_PAR_DEFAUT, ligne.getLargeur(), Ligne.EPSILON);
	}

	/**
	 * Test de {@link Ligne#Ligne(Coordonnees)}.
	 * 
	 * @since 0.3.2.5
	 */
	@Test
	public void testConstructeurCoordonnees() {
		final Coordonnees origine = new Coordonnees(5.0, 10.0);

		final Ligne ligne = new Ligne(origine);

		assertEquals("Test de l'origine de la ligne", origine, ligne.getPosition());
		assertEquals("Test de la hauteur de la ligne", Forme.HAUTEUR_PAR_DEFAUT, ligne.getHauteur(), Ligne.EPSILON);
		assertEquals("Test de la largeur de la ligne", Forme.LARGEUR_PAR_DEFAUT, ligne.getLargeur(), Ligne.EPSILON);
	}

	/**
	 * Test de {@link Ligne#Ligne(double, double)}.
	 * 
	 * @since 0.3.2.5
	 */
	@Test
	public void testConstructeurHauteurLargeur() {
		final double hauteur = 10.0;
		final double largeur = 15.0;
		final Ligne ligne = new Ligne(largeur, hauteur);
		final Coordonnees origine = new Coordonnees();

		assertEquals("Test de l'origine de la ligne", origine, ligne.getPosition());
		assertEquals("Test de la hauteur de la ligne", hauteur, ligne.getHauteur(), Forme.EPSILON);
		assertEquals("Test de la largeur de la ligne", largeur, ligne.getLargeur(), Forme.EPSILON);
	}

	/**
	 * Test de {@link Ligne#Ligne(Coordonnees, double, double)}.
	 * 
	 * @since 0.3.2.5
	 */
	@Test
	public void testConstructeurPlein() {
		final double hauteur = 10.0;
		final double largeur = 15.0;
		final Coordonnees origine = new Coordonnees();
		final Ligne ligne = new Ligne(origine, largeur, hauteur);

		assertEquals("Test de l'origine de la ligne", origine, ligne.getPosition());
		assertEquals("Test de la hauteur de la ligne", hauteur, ligne.getHauteur(), Forme.EPSILON);
		assertEquals("Test de la largeur de la ligne", largeur, ligne.getLargeur(), Forme.EPSILON);
	}

	// Couverture instruction pour aire : 100%
	/**
	 * Test de {@link Ligne#aire()}, celle-ci doit retourner 0.
	 * 
	 * @deprecated elle est inutile, elle sert juste a avoir 100% de couverture du
	 *             code dans les tests :).
	 * 
	 * @since 0.3.2.5
	 */
	@Test
	public void testAire() {
		final Ligne ligne = new Ligne();

		assertEquals("Test de l'aire de la ligne", 0, ligne.aire(), Forme.EPSILON);
	}
}