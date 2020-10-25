package fr.eseo.poo.projet.artiste.controleur.outils;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;

import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Component;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirNombreDeBranches;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilEtoileTest {

	/**
	 * Liste des {@code Etoile} attendue durant le tests.
	 */
	private final Etoile[] etoileArray = { new Etoile(new Coordonnees(0, 30)), new Etoile(new Coordonnees(30, 30)),
			new Etoile(new Coordonnees(60, 30)), new Etoile(new Coordonnees(90, 30)),
			new Etoile(new Coordonnees(120, 30)),

			new Etoile(new Coordonnees(250, 200), 100, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, -Math.PI,
					Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
			new Etoile(new Coordonnees(227.9912, 277.9912), 114.0175, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 2.2318,
					Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
			new Etoile(new Coordonnees(180, 230), 140, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, Math.PI / 2,
					Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
			new Etoile(new Coordonnees(141.1759, 211.1759), 147.6482, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 1.0769,
					Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
			new Etoile(new Coordonnees(135.9688, 185.9688), 128.0625, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 0.6747,
					Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
			new Etoile(new Coordonnees(176.9211, 176.9211), 76.1577, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 0.4050,
					Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
			new Etoile(new Coordonnees(240, 190), 20, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, Math.PI / 2,
					Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
			new Etoile(new Coordonnees(235.5025, 165.5025), 98.9949, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
					-3 * Math.PI / 4, Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
			new Etoile(new Coordonnees(205.6602, 155.6602), 188.6796, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT,
					3 * Math.PI / 4, Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),
			new Etoile(new Coordonnees(235.5025, 145.5025), 98.9949, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 3 * Math.PI / 4,
					Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT),

			new Etoile(new Coordonnees(50, 250), 100, 5, Math.PI / 2, 0),
			new Etoile(new Coordonnees(50, 250), 100, 6, Math.PI / 2, 0.1),
			new Etoile(new Coordonnees(50, 250), 100, 7, Math.PI / 2, 0.2),
			new Etoile(new Coordonnees(50, 250), 100, 8, Math.PI / 2, 0.3),
			new Etoile(new Coordonnees(50, 250), 100, 9, Math.PI / 2, 0.4), };

	/**
	 * Attribut représentant la frame ou sera dessiner placé la zone de dessin.
	 */
	private final JFrame frame;

	/**
	 * Attribut représentant la zone de dessin.
	 */
	private final PanneauDessin panneauDessin;

	/**
	 * Attribut représentant l'outil testé.
	 */
	private final OutilEtoile outil;

	private final PanneauBarreOutils panneauOutils;

	private JSpinner nbBranche;

	private JSpinner longueurBranche;

	public OutilEtoileTest() throws Exception {
		this.frame = new JFrame();
		this.panneauDessin = new PanneauDessin(600, 600, PanneauDessin.COULEUR_FOND_PAR_DEFAUT);

		this.frame.getContentPane().add(this.panneauDessin);
		this.frame.setTitle("OutilEtoileTest");

		this.panneauOutils = new PanneauBarreOutils(this.panneauDessin);
		this.frame.add(this.panneauOutils, BorderLayout.EAST);

		this.frame.setSize(this.panneauDessin.getPreferredSize());
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.outil = new OutilEtoile();

		for (final Component comp : this.panneauOutils.getComponents()) {
			if (comp.getName().equals(PanneauBarreOutils.CONTENEUR_CARD_NOM)) {
				JPanel jPanel = (JPanel) comp;
				for (final Component subComp : jPanel.getComponents()) {
					if (comp.getName().equals(ActionChoisirNombreDeBranches.NOM_ACTION)) {
						this.nbBranche = (JSpinner) subComp;
					} else if (comp.getName().equals(ActionChoisirNombreDeBranches.NOM_ACTION)) {
						this.longueurBranche = (JSpinner) subComp;
					}
				}
				break;
			}
		}

		this.testOutilEtoile();
	}

	/**
	 * Fonction permettant de tester {@link OutilEtoile#creerVueForme()}
	 * 
	 * @throws Exception Si l'une des Etoiles déssinée ne correspond pas à celle
	 *                   attendue.
	 */
	private void testOutilEtoile() throws Exception {
		this.panneauDessin.associerOutil(this.outil);

		// Test du double clic
		for (int i = 0; i < 5; i++) {
			this.dessinFormeClick(i * 30, 30);

			this.testGraphic(this.etoileArray[i], (Etoile) this.panneauDessin.getVueFormes().get(i).getForme());
		}

		// Test de la souris glissé, plusieurs cerle doivent apparaitre et tenir dans
		// un Etoile, leur orientation est décalé de 45° à chaque fois permettant de
		// tester l'ensemble des cas possible pour la valeurs de la hauteur et de la
		// largeur
		for (int i = 0; i < 10; i++) {
			final int largeur = (int) Math.round((50 * Math.cos(i * Math.PI / 4)));
			final int hauteur = (int) Math.round((50 * Math.sin(i * Math.PI / 4)));
			this.dessinFormeClick(250, 250 - 10 * i, 250 + largeur, 250 + hauteur);

			this.testGraphic(this.etoileArray[4 + i], (Etoile) this.panneauDessin.getVueFormes().get(4 + i).getForme());
		}

		// Test de la modification des longueurs et du nombre de branche.
		for (int i = 0; i < 5; i++) {
			this.longueurBranche.setValue(i * 0.1);
			this.nbBranche.setValue(5 + i);
			this.dessinFormeClick(100, 250, 100, 300);
			this.testGraphic(this.etoileArray[15 + i],
					(Etoile) this.panneauDessin.getVueFormes().get(15 + i).getForme());
		}
	}

	/**
	 * Fonction permettant de comparer de {@code Etoile}, si elles sont différentes,
	 * une exception est levé.
	 * 
	 * @param etoileExpected La {@code Etoile} attendue.
	 * @param etoileActual   La {@code Etoile} que l'on à obtenue
	 * 
	 * @throws Exception Si l'Etoile {@code etoileActual} est différente de
	 *                   {@code EtoileExcepted}.
	 */
	private void testGraphic(final Etoile etoileExpected, final Etoile etoileActual) throws Exception {
		if (!(etoileExpected.equals(etoileActual))) {
			throw new Error("Echec, demandé :\n\t" + etoileExpected.toString() + " angle : "
					+ etoileExpected.getAnglePremiereBranche() + " longueur des branches "
					+ etoileExpected.getLongueurBranche() + " nombre de branches " + etoileExpected.getNombreBranches()
					+ "\nobtenue:\n\t" + etoileActual.toString() + etoileActual.toString() + " angle : "
					+ etoileActual.getAnglePremiereBranche() + " longueur des branches "
					+ etoileActual.getLongueurBranche() + " nombre de branches " + etoileActual.getNombreBranches());
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
		SwingUtilities.invokeLater(() -> {
			try {
				new OutilEtoileTest().testOutilEtoile();
			} catch (final Exception e) {
				e.printStackTrace();
			}
		});
	}
}