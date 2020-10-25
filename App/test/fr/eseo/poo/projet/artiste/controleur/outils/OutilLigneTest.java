package fr.eseo.poo.projet.artiste.controleur.outils;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Classe {@code OutilLigneTest} permettant de tester {@code OutilLigne}.
 * 
 * @see OutilLigne
 * @see <a href=
 *      "https://docs.oracle.com/javase/8/docs/api/java/awt/event/MouseEvent.html">Oracle
 *      - MouseEvent</a>
 * 
 * @author Brinfer
 * 
 * @since 0.3.4.4
 * 
 * @version 0.3.4.4
 */
public class OutilLigneTest {

	/**
	 * Liste des {@code Ligne} attendue durant le tests.
	 */
	private final Ligne[] ligneArray = { new Ligne(new Coordonnees(0, 30)), new Ligne(new Coordonnees(30, 30)),
			new Ligne(new Coordonnees(60, 30)), new Ligne(new Coordonnees(90, 30)), new Ligne(new Coordonnees(120, 30)),
			new Ligne(new Coordonnees(250, 250), 100, 0), new Ligne(new Coordonnees(250, 240), 71, 81),
			new Ligne(new Coordonnees(250, 230), 0, 120), new Ligne(new Coordonnees(250, 220), -71, 101),
			new Ligne(new Coordonnees(250, 210), -100, 40), new Ligne(new Coordonnees(250, 200), -71, -21),
			new Ligne(new Coordonnees(250, 190), 0, -40), new Ligne(new Coordonnees(250, 180), 71, -1),
			new Ligne(new Coordonnees(250, 170), 100, 80), new Ligne(new Coordonnees(250, 210), -50, -87) };

	/**
	 * Attribut représentant la frame ou sera dessiner placé la zone de dessin.
	 */
	private final JFrame frame;

	/**
	 * Attribut représentant la zone de dessin.
	 */
	private final PanneauDessin panneau;

	/**
	 * Attribut représentant l'outil testé.
	 */
	private final OutilLigne outil;

	public OutilLigneTest() throws Exception {
		this.frame = new JFrame();
		this.panneau = new PanneauDessin(400, 400, PanneauDessin.COULEUR_FOND_PAR_DEFAUT);
		this.outil = new OutilLigne();

		this.frame.getContentPane().add(panneau);
		this.frame.setTitle("OutilLigneTest");
		this.frame.setSize(this.panneau.getPreferredSize());
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.testOutilLigne();
	}

	/**
	 * Fonction permettant de tester {@link OutilLigne#creerVueForme()}
	 * 
	 * @throws Exception Si l'une des lignes déssiné ne correspond pas à celle
	 *                   attendue.
	 */
	private void testOutilLigne() throws Exception {
		this.panneau.associerOutil(this.outil);

		// Test du double clic
		for (int i = 0; i < 5; i++) {
			this.dessinFormeClick(i * 30, 30);

			this.testGraphic(this.ligneArray[i], (Ligne) this.panneau.getVueFormes().get(i).getForme());
		}

		// Test de la souris glissé, plusieurs lignes doivent apparaitre et tenir dans
		// un cercle, leur orientation est décalé de 45° à chaque fois permettant de
		// tester l'ensemble des cas possible pour la valeurs de la hauteur et de la
		// largeur
		for (int i = 0; i < 10; i++) {
			final int largeur = (int) Math.round((100 * Math.cos(i * Math.PI / 4)));
			final int hauteur = (int) Math.round((100 * Math.sin(i * Math.PI / 4)));
			this.dessinFormeClick(250, 250 - 10 * i, 250 + largeur, 250 + hauteur);

			this.testGraphic(this.ligneArray[4 + i], (Ligne) this.panneau.getVueFormes().get(4 + i).getForme());
		}
	}

	/**
	 * Fonction permettant de comparer de {@code Ligne}, si elles sont différentes,
	 * une exception est levé.
	 * <p>
	 * Il aurais été possible d'utilisé aussi {@code Arrays.equals(Object, Object)},
	 * mais dans ce cas la on perd l'affichage de la description des deux
	 * {@code Lignes} différentes.
	 * 
	 * @param ligneExpected La {@code Ligne} attendue.
	 * @param ligneActual   La {@code Ligne} que l'on à obtenue
	 * 
	 * @throws Exception Si la ligne {@code ligneActual} est différente de
	 *                   {@code ligneExcepted}.
	 * 
	 */
	private void testGraphic(final Ligne ligneExpected, final Ligne ligneActual) throws Exception {
		if (!(ligneActual.equals(ligneExpected))) {
			throw new Exception(
					"Echec, demandé :\n\t" + ligneExpected.toString() + "\nobtenue:\n\t" + ligneActual.toString());
		}
	}

	/**
	 * Fonction permettant de dessiner une forme.
	 * 
	 * @param debutX Le {@code int} correspondant à l'abcisse de début.
	 * @param debutY Le {@code int} correspondant à l'orodonnées de début.
	 * @param finX   Le {@code int} correspondant à l'abcisse de fin.
	 * @param finY   Le {@code int} correspondant à l'orodonnées de fin.
	 * 
	 * @see #dessinFormeClick(int, int)
	 */
	private void dessinFormeClick(final int debutX, final int debutY, final int finX, final int finY) {
		this.outil.mousePressed(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_PRESSED, 0,
				MouseEvent.BUTTON1_MASK, debutX, debutY, 1, false, MouseEvent.BUTTON1));
		this.outil.mouseReleased(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_RELEASED, 0,
				MouseEvent.BUTTON1_MASK, finX, finY, 1, false, MouseEvent.BUTTON1));
	}

	/**
	 * Fonction permettant de dessiner une forme par défaut à l'aide d'un double
	 * click.
	 * 
	 * @param x Le {@code int} correspondant à l'abcisse du click.
	 * @param y Le {@code int} correspondant à l'orodonnées du click.
	 * 
	 * @see #dessinFormeClick(int, int, int , int)
	 */
	private void dessinFormeClick(final int x, final int y) {
		this.dessinFormeClick(x, y, x, y); // Nécessaire pour bien donner des valeurs à début et fin de Outil.
		this.outil.mouseClicked(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_CLICKED, 0,
				MouseEvent.BUTTON1_MASK, x, y, 2, false, MouseEvent.BUTTON1));
	}

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new OutilLigneTest().testOutilLigne();
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}