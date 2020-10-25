package fr.eseo.poo.projet.artiste.modele.formes;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;

/**
 * Classe de test parametre de {@link Ellipse#perimetre()}.
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.7
 */
@RunWith(Parameterized.class)
public class EllipseTestPerimetreParameterized {

	/**
	 * Attribut representant l'ellipse que l'on teste.
	 */
	private final Ellipse ellipse;

	/**
	 * Attribut representant le perimetre attendue.
	 */
	private final double perimetreAttendue;

	/**
	 * Constructeur pour chaque donnee de test.
	 * 
	 * @param ellipse           l'ellipse dont on veut tester le périmètre.
	 * @param perimetreAttendue le perimetre attendue de l'ellipse.
	 */
	public EllipseTestPerimetreParameterized(final Ellipse ellipse, final double perimetreAttendue) {
		this.ellipse = ellipse;
		this.perimetreAttendue = perimetreAttendue;
	}

	/**
	 * Création du jeu de test.
	 * 
	 * @return l'ensemble des données de test.
	 */
	@Parameters(name = "dt[{index}] : {0}, {1}, {2}")
	public static Collection<Object[]> dt() {
		final Object[][] data = new Object[][] {
				// Le périmètre attendue est de π.
				{ new Ellipse(1, 1), Math.PI },
				// Le périmètre attendue est d'environ 4.844.
				{ new Ellipse(1, 2), 4.844 },
				// Le périmètre attendue est d'environ 4.844.
				{ new Ellipse(2, 1), 4.844 },
				// Le périmètre attendue est d'environs 47.280, au final il s'agit d'un cercle.
				{ new Ellipse(15.05, 15.05), 47.280 },
				// Le périmètre attendue est d'environs 69.338.
				{ new Ellipse(28.1, 15.05), 69.338 },
				// Le périmètre attendue est d'environs 69.338.
				{ new Ellipse(15.05, 28.1), 69.338 } };
		return Arrays.asList(data);

	}

	// Couverture des instructions pour perimetre : 100%

	/**
	 * Test de la méthode {@link Ellipse#perimetre()}
	 */
	@Test
	public void testPerimetreEllipse() {
		assertEquals("Test de perimetre(): ", this.perimetreAttendue, this.ellipse.perimetre(), Forme.EPSILON);
	}
}
