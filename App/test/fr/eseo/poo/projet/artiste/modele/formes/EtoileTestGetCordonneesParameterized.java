package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Classe de test parametree de {@link Etoile#getCoordonnees()}
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.8
 */
@RunWith(Parameterized.class)
public class EtoileTestGetCordonneesParameterized {
	/**
	 * Attribut representant l'Etoile que l'on souhaite tester.
	 */
	private final Etoile etoile;

	/**
	 * Parametres representant les coordonnees composant les sommets de l'etoile
	 */
	private final Coordonnees[] sommetsAttendue;

	/**
	 * Constructeur pour chaque donnee de test.
	 * 
	 * @param Etoile          l'etoile que l'on souhaite tester.
	 * @param sommetsAttendue Un {@code Array} de {@code Coordonnees} correspondant
	 *                        aux sommets attendue de l'etoile.
	 */
	public EtoileTestGetCordonneesParameterized(final Etoile etoile, final Coordonnees[] sommetsAttendue) {
		this.etoile = etoile;
		this.sommetsAttendue = sommetsAttendue;
	}

	/**
	 * Création du jeu de test.
	 * 
	 * @return l'ensemble des données de test.
	 */
	@Parameters(name = "dt[{index}] : {0}, {1}")
	public static Collection<Object[]> dt() {
		final Object[][] data = new Object[][] {
				// Etoile par defaut
				{ new Etoile(),
						new Coordonnees[] { new Coordonnees(75, 0), new Coordonnees(146.3292, 51.8237),
								new Coordonnees(119.0839, 135.6763), new Coordonnees(30.9161, 135.6763),
								new Coordonnees(3.6708, 51.8237) } },

				// Changement de la taille
				{ new Etoile(40),
						new Coordonnees[] { new Coordonnees(20, 0), new Coordonnees(39.0211, 13.8197),
								new Coordonnees(31.7557, 36.1803), new Coordonnees(8.2443, 36.1803),
								new Coordonnees(0.9789, 13.8197) } },
				{ new Etoile(65),
						new Coordonnees[] { new Coordonnees(32.5, 0), new Coordonnees(63.4093, 22.4569),
								new Coordonnees(51.603, 58.7931), new Coordonnees(13.397, 58.7931),
								new Coordonnees(1.5907, 22.4569) } },
				{ new Etoile(596.3),
						new Coordonnees[] { new Coordonnees(298.15, 0), new Coordonnees(581.7075, 206.0166),
								new Coordonnees(473.3982, 539.3584), new Coordonnees(122.9018, 539.3584),
								new Coordonnees(14.5925, 206.0166) } },

				// Changement de l'angle
				// Angle de 0°
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 0,
						Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(150, 75), new Coordonnees(98.176, 146.329),
								new Coordonnees(14.323, 119.083), new Coordonnees(14.323, 30.916),
								new Coordonnees(98.176, 3.67) } },
				// Angle de -180°
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, -Math.PI,
						Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(0, 75), new Coordonnees(51.82, 3.67),
								new Coordonnees(135.676, 30.916), new Coordonnees(135.676, 119.083),
								new Coordonnees(51.823, 146.329) } },
				// Angle de -100°
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
						-1.74532925, Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(61.9764, 148.8606), new Coordonnees(0.7299, 85.438),
								new Coordonnees(42.1222, 7.5904), new Coordonnees(128.9505, 22.9006),
								new Coordonnees(141.221, 110.2104) } },
				// Angle de -60°
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
						-1.04719755, Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(112.5, 139.9519), new Coordonnees(24.8152, 130.7359),
								new Coordonnees(6.4841, 44.4948), new Coordonnees(82.8396, 0.4109),
								new Coordonnees(148.3611, 59.4066) } },
				// Angle de 60°
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 1.04719755,
						Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(112.5, 10.048), new Coordonnees(148.361, 90.593),
								new Coordonnees(82.839, 149.589), new Coordonnees(6.484, 105.505),
								new Coordonnees(24.815, 19.264) } },
				// Angle de 100°
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 1.74532925,
						Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(61.976, 1.139), new Coordonnees(141.221, 39.789),
								new Coordonnees(128.95, 127.099), new Coordonnees(42.122, 142.409),
								new Coordonnees(0.729, 64.562) } },
				// Angle de 145°
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 2.53072742,
						Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(13.563, 31.981), new Coordonnees(96.927, 3.277),
								new Coordonnees(149.988, 73.691), new Coordonnees(99.417, 145.913),
								new Coordonnees(15.102, 120.136) } },
				// Angle de 180°
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, Math.PI,
						Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(0, 75), new Coordonnees(51.82, 3.67),
								new Coordonnees(135.676, 30.916), new Coordonnees(135.676, 119.083),
								new Coordonnees(51.823, 146.329) } },

				// Changement de la position
				{ new Etoile(new Coordonnees(79.502, 43.6602)),
						new Coordonnees[] { new Coordonnees(154.502, 43.6602), new Coordonnees(225.8313, 95.4839),
								new Coordonnees(198.5859, 179.3365), new Coordonnees(110.4181, 179.3365),
								new Coordonnees(83.1728, 95.4839) } },
				{ new Etoile(new Coordonnees(239.6901, 68.7877)),
						new Coordonnees[] { new Coordonnees(314.6901, 68.7877), new Coordonnees(386.0194, 120.6115),
								new Coordonnees(358.774, 204.464), new Coordonnees(270.6062, 204.464),
								new Coordonnees(243.3609, 120.6115) } },

				// Changement de la longueur des branches
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
						Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0),
						new Coordonnees[] { new Coordonnees(75, 0), new Coordonnees(146.3292, 51.8237),
								new Coordonnees(119.0839, 135.6763), new Coordonnees(30.9161, 135.6763),
								new Coordonnees(3.6708, 51.8237) } },
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
						Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 1),
						new Coordonnees[] { new Coordonnees(75, 0), new Coordonnees(146.3292, 51.8237),
								new Coordonnees(119.0839, 135.6763), new Coordonnees(30.9161, 135.6763),
								new Coordonnees(3.6708, 51.8237) } },
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
						Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0.486),
						new Coordonnees[] { new Coordonnees(75, 0), new Coordonnees(146.3292, 51.8237),
								new Coordonnees(119.0839, 135.6763), new Coordonnees(30.9161, 135.6763),
								new Coordonnees(3.6708, 51.8237) } },

				// Changement du nombre de branche
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, 10, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
						Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(75, 0), new Coordonnees(119.0839, 14.3237),
								new Coordonnees(146.3292, 51.8237), new Coordonnees(146.3292, 98.1763),
								new Coordonnees(119.0839, 135.6763), new Coordonnees(75, 150),
								new Coordonnees(30.9161, 135.6763), new Coordonnees(3.6708, 98.1763),
								new Coordonnees(3.6708, 51.8237), new Coordonnees(30.9161, 14.3237) } },
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, 3, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
						Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(75, 0), new Coordonnees(139.95, 112.5),
								new Coordonnees(10.05, 112.5) } },
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, 15, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
						Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(75, 0), new Coordonnees(105.5052, 6.4841),
								new Coordonnees(130.7359, 24.8152), new Coordonnees(146.3292, 51.8237),
								new Coordonnees(149.5891, 82.8396), new Coordonnees(139.9519, 112.5),
								new Coordonnees(119.0839, 135.6763), new Coordonnees(90.5934, 148.3611),
								new Coordonnees(59.4066, 148.3611), new Coordonnees(30.9161, 135.6763),
								new Coordonnees(10.0481, 112.5), new Coordonnees(0.4109, 82.8396),
								new Coordonnees(3.6708, 51.8237), new Coordonnees(19.2641, 24.8152),
								new Coordonnees(44.4948, 6.4841) } },

		};
		return Arrays.asList(data);

	}

	// Couverture des instruction pour getCoordonnees() : 100%

	/**
	 * Test de {@link Etoile#getCoordonnees()}.
	 */
	@Test
	public void testGetCoordonnees() {
		assertArrayEquals("Test de getCoordonnees()", this.sommetsAttendue, this.etoile.getCoordonnees().toArray());
	}
}