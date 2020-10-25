package fr.eseo.poo.projet.artiste.modele.formes;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test de parametre de {@link Cercle#perimetre()}.
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.7
 */
@RunWith(Parameterized.class)
public class CercleTestPerimetreParameterized {

	/**
	 * Attribut representant le cercle testé.
	 */
	private final Cercle cercle;

	/**
	 * Parametres representant perimetre attendue.
	 */
	private final double perimetreAttendue;

	/**
	 * Constructeur pour chaque donnee de test.
	 * 
	 * @param cercle            le cercle dont on veut tester le périmètre.
	 * @param perimetreAttendue le perimetre attendue du cercle pour la taille
	 *                          données.
	 */
	public CercleTestPerimetreParameterized(final Cercle cercle, final double perimetreAttendue) {
		this.cercle = cercle;
		this.perimetreAttendue = perimetreAttendue;
	}

	/**
	 * Création du jeu de test.
	 * 
	 * @return l'ensemble des données de test.
	 */
	@Parameters(name = "dt[{index}] : {0}, {1}")
	public static Collection<Object[]> dt() {
		final Object[][] data = new Object[][] {
				// Test 1: cercle de diamètre 150, périmètre égale à 150π.
				{ new Cercle(), 150 * Math.PI },
				// Test 1: cercle de diamètre 1, périmètre égale à π.
				{ new Cercle(1), Math.PI },
				// Test 2: cercle de diamètre 2, périmètre égale à 2π.
				{ new Cercle(2), 2 * Math.PI },
				// Test 3: cercle de diamètre 750.1543, périmètre égale à 750.1543π.
				{ new Cercle(750.1543), 750.1543 * Math.PI } };
		return Arrays.asList(data);
	}

	// Couverture instruction pour perimetre : 100%

	/**
	 * Test de la méthode {@link Cercle#perimetre()}.
	 */
	@Test
	public void testPerimetre() {

		assertEquals("Test de perimetre: ", this.perimetreAttendue, this.cercle.perimetre(), Forme.EPSILON);
	}
}
