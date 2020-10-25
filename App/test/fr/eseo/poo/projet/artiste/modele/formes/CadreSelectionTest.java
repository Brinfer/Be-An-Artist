package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Classe de test de base (avec asserts et non parametré) de la classe
 * {@link CadreSelection}.
 * 
 * @author Brinfer
 * 
 * @since 0.4.2.1
 */
public class CadreSelectionTest {

	// Couverture instruction pour le constructeur : 100%

	/**
	 * Test de {@link CadreSelection#CadreSelection(Forme)}
	 * 
	 * @since 0.4.2.1
	 */
	@Test
	public void testConstructeur() {
		final Forme forme = new FormeConcreteTest(new Coordonnees(-50, 75.5), -786, 415);
		final CadreSelection cadreSelection = new CadreSelection(forme);

		assertEquals("Test de l'origine du cadre", new Coordonnees(forme.getCadreMinX(), forme.getCadreMinY()),
				cadreSelection.getPosition());
		assertEquals("Test de la hauteur du cadre", Math.abs(forme.getHauteur()), cadreSelection.getHauteur(),
				Forme.EPSILON);
		assertEquals("Test de la largeur du cadre", Math.abs(forme.getLargeur()), cadreSelection.getLargeur(),
				Forme.EPSILON);
	}

	@Test
	public void testSetLargeurError() {
		final Forme forme = new FormeConcreteTest(new Coordonnees(-50, 75.5), -786, 415);
		final CadreSelection cadreSelection = new CadreSelection(forme);

		assertThrows(IllegalArgumentException.class, () -> cadreSelection.setLargeur(0));
		assertThrows(IllegalArgumentException.class, () -> cadreSelection.setLargeur(-1));
	}

	@Test
	public void testSetHauteurError() {
		final Forme forme = new FormeConcreteTest(new Coordonnees(-50, 75.5), -786, 415);
		final CadreSelection cadreSelection = new CadreSelection(forme);

		assertThrows(IllegalArgumentException.class, () -> cadreSelection.setHauteur(0));
		assertThrows(IllegalArgumentException.class, () -> cadreSelection.setHauteur(-1));
	}
}