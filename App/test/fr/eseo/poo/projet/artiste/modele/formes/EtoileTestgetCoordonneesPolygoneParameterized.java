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
 * Classe de test parametree de {@link Etoile#getCoordonneesPolygone()}
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.8
 */
@RunWith(Parameterized.class)
public class EtoileTestgetCoordonneesPolygoneParameterized {
	/**
	 * Attribut representant l'Etoile que l'on souhaite tester.
	 */
	private final Etoile etoile;

	/**
	 * Parametres representant les coordonnees composant les sommets du polynomes de
	 * l'etoile
	 */
	private final Coordonnees[] sommetsAttendue;

	/**
	 * Constructeur pour chaque donnee de test.
	 * 
	 * @param Etoile          l'etoile que l'on souhaite tester.
	 * @param sommetsAttendue Un {@code Array} de {@code Coordonnees} correspondant
	 *                        aux sommets attendue du polynome de l'etoile.
	 */
	public EtoileTestgetCoordonneesPolygoneParameterized(final Etoile etoile, final Coordonnees[] sommetsAttendue) {
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
						new Coordonnees[] { new Coordonnees(63.9779, 59.8309), new Coordonnees(86.021, 59.8309),
								new Coordonnees(92.8323, 80.7941), new Coordonnees(75, 93.75),
								new Coordonnees(57.1677, 80.7941) } },

				// Changement de la taille
				{ new Etoile(40),
						new Coordonnees[] { new Coordonnees(17.0611, 15.9549), new Coordonnees(22.9389, 15.9549),
								new Coordonnees(24.7553, 21.5451), new Coordonnees(20, 25),
								new Coordonnees(15.2447, 21.5451) } },
				{ new Etoile(65),
						new Coordonnees[] { new Coordonnees(27.7242, 25.9267), new Coordonnees(37.2758, 25.9267),
								new Coordonnees(40.2273, 35.0108), new Coordonnees(32.5, 40.625),
								new Coordonnees(24.7727, 35.0108) } },
				{ new Etoile(596.3),
						new Coordonnees[] { new Coordonnees(254.338, 237.8479), new Coordonnees(341.962, 237.8479),
								new Coordonnees(369.0394, 321.1834), new Coordonnees(298.15, 372.6875),
								new Coordonnees(227.2606, 321.1834) } },

				// Changement de l'angle
				// Angle de 0°
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 0,
						Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(90.1691, 63.979), new Coordonnees(90.1691, 86.021),
								new Coordonnees(69.2059, 92.8323), new Coordonnees(56.25, 75),
								new Coordonnees(69.2059, 57.1677) } },
				// Angle de -180°
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, -Math.PI,
						Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(59.8309, 86.021), new Coordonnees(59.8309, 63.979),
								new Coordonnees(80.7941, 57.1677), new Coordonnees(93.75, 75),
								new Coordonnees(80.7941, 92.8323) } },
				// Angle de -100°
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
						-1.74532925, Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(83.2195, 91.8524), new Coordonnees(61.5124, 88.0248),
								new Coordonnees(58.4447, 66.1974), new Coordonnees(78.2559, 56.5349),
								new Coordonnees(93.5675, 72.3905) } },
				// Angle de -60°
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
						-1.04719755, Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(92.129, 82.6263), new Coordonnees(73.0401, 93.6473),
								new Coordonnees(56.6597, 78.8983), new Coordonnees(65.625, 58.762),
								new Coordonnees(87.5462, 61.066) } },
				// Angle de 60°
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 1.04719755,
						Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(73.0401, 56.3527), new Coordonnees(92.129, 67.3737),
								new Coordonnees(87.5462, 88.934), new Coordonnees(65.625, 91.238),
								new Coordonnees(56.6597, 71.1017) } },
				// Angle de 100°
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 1.74532925,
						Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(61.5124, 61.9752), new Coordonnees(83.2195, 58.1476),
								new Coordonnees(93.5675, 77.6095), new Coordonnees(78.2559, 93.4651),
								new Coordonnees(58.4447, 83.8026) } },
				// Angle de 145°
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 2.53072742,
						Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(56.2529, 75.3272), new Coordonnees(68.8956, 57.2715),
								new Coordonnees(89.9744, 63.716), new Coordonnees(90.3591, 85.7546),
								new Coordonnees(69.518, 92.9307) } },
				// Angle de 180°
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, Math.PI,
						Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(59.8309, 86.021), new Coordonnees(59.8309, 63.979),
								new Coordonnees(80.7941, 57.1677), new Coordonnees(93.75, 75),
								new Coordonnees(80.7941, 92.8323) } },

				// Changement de la position
				{ new Etoile(new Coordonnees(79.502, 43.6602)),
						new Coordonnees[] { new Coordonnees(143.481, 103.4911), new Coordonnees(165.523, 103.4911),
								new Coordonnees(172.3343, 124.4543), new Coordonnees(154.502, 137.4102),
								new Coordonnees(136.6697, 124.4543) } },
				{ new Etoile(new Coordonnees(239.6901, 68.7877)),
						new Coordonnees[] { new Coordonnees(303.6691, 128.6186), new Coordonnees(325.7111, 128.6186),
								new Coordonnees(332.5224, 149.5818), new Coordonnees(314.6901, 162.5377),
								new Coordonnees(296.8578, 149.5818) } },

				// Changement de la longueur des branches
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
						Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0),
						new Coordonnees[] { new Coordonnees(30.9161, 14.3237), new Coordonnees(119.0839, 14.3237),
								new Coordonnees(146.3292, 98.1763), new Coordonnees(75, 150),
								new Coordonnees(3.6708, 98.1763) } },
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
						Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 1),
						new Coordonnees[] { new Coordonnees(75, 75), new Coordonnees(75, 75), new Coordonnees(75, 75),
								new Coordonnees(75, 75), new Coordonnees(75, 75) } },
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
						Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0.486),
						new Coordonnees[] { new Coordonnees(52.3409, 43.8124), new Coordonnees(97.6591, 43.8124),
								new Coordonnees(111.6632, 86.9126), new Coordonnees(75, 113.55),
								new Coordonnees(38.3368, 86.9126) } },

				// Changement du nombre de branche
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, 10, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
						Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(69.2059, 57.1677), new Coordonnees(80.7941, 57.1677),
								new Coordonnees(90.1691, 63.979), new Coordonnees(93.75, 75),
								new Coordonnees(90.1691, 86.021), new Coordonnees(80.7941, 92.8323),
								new Coordonnees(69.2059, 92.8323), new Coordonnees(59.8309, 86.021),
								new Coordonnees(56.25, 75), new Coordonnees(59.8309, 63.979) } },
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, 3, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
						Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(58.762, 65.625), new Coordonnees(91.238, 65.625),
								new Coordonnees(75, 93.75) } },
				{ new Etoile(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, 15, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
						Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
						new Coordonnees[] { new Coordonnees(71.1017, 56.6597), new Coordonnees(78.8983, 56.6597),
								new Coordonnees(86.021, 59.8309), new Coordonnees(91.238, 65.625),
								new Coordonnees(93.6473, 73.0401), new Coordonnees(92.8323, 80.7941),
								new Coordonnees(88.934, 87.5462), new Coordonnees(82.6263, 92.129),
								new Coordonnees(75, 93.75), new Coordonnees(67.3737, 92.129),
								new Coordonnees(61.066, 87.5462), new Coordonnees(57.1677, 80.7941),
								new Coordonnees(56.3527, 73.0401), new Coordonnees(58.762, 65.625),
								new Coordonnees(63.979, 59.8309), } },

		};
		return Arrays.asList(data);

	}

	// Couverture des instruction pour getCoordonneesPolygone() : 100%

	/**
	 * Test de {@link Etoile#getCoordonneesPolygone()}
	 */
	@Test
	public void testGetCoordonneesPolygone() {

		assertArrayEquals("Test de getCoordonneesPolygone()", this.sommetsAttendue,
				this.etoile.getCoordonneesPolygone().toArray());
	}
}