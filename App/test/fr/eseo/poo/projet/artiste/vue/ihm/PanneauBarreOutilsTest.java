package fr.eseo.poo.projet.artiste.vue.ihm;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirRemplissage;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.controleur.outils.Outil;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEtoile;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe de test de la classe {@linkplain PanneauBarreOutil}.
 * 
 * @author Brinfer
 * 
 * @since 0.3.4.11
 * 
 * @version 0.3.7.2
 */
public class PanneauBarreOutilsTest {

	/**
	 * Tableau de {@code String} regroupant les noms de tout les {@code Component}
	 * cencé se trouver dans le {@code PanneauBarreOutil}.
	 */
	public static final String[] NOM_BOUTONS = { ActionEffacer.NOM_ACTION, ActionChoisirCouleur.NOM_ACTION,
			ActionSelectionner.NOM_ACTION, ActionChoisirForme.NOM_ACTION_LIGNE, ActionChoisirForme.NOM_ACTION_CERCLE,
			ActionChoisirForme.NOM_ACTION_ELLIPSE, ActionChoisirRemplissage.NOM_ACTION,
			ActionChoisirForme.NOM_ACTION_ETOILE, (PanneauBarreOutils.BRANCHE_SPINNER_NOM + "JLabel"),
			(PanneauBarreOutils.LONGUEUR_SPINNER_NOM + "JLabel"), PanneauBarreOutils.BRANCHE_SPINNER_NOM,
			PanneauBarreOutils.LONGUEUR_SPINNER_NOM };

	/**
	 * Attribut représentant la frame ou sera dessiner placé la zone de dessin.
	 */
	private final JFrame frame;

	/**
	 * Attribut représentant la zone de dessin.
	 */
	private final PanneauDessin panneauDessin;

	/**
	 * Attribut représentant la zone de zone des outils.
	 */
	private final PanneauBarreOutils panneauOutils;

	/**
	 * {@code Map} regroupant tout la {@code Component} qui se trouve dans
	 * {@coe PanneauBarreOutil}, leur clé est leur nom.
	 */
	private final Map<String, Component> components = new HashMap<String, Component>();

	public PanneauBarreOutilsTest() {
		this.frame = new JFrame();
		this.panneauDessin = new PanneauDessin(600, 600, PanneauDessin.COULEUR_FOND_PAR_DEFAUT);

		this.frame.getContentPane().add(this.panneauDessin);
		this.frame.setTitle("PanneauBarreOutilTest");

		this.panneauOutils = new PanneauBarreOutils(this.panneauDessin);
		this.frame.add(this.panneauOutils, BorderLayout.EAST);

		this.frame.setSize(this.panneauDessin.getPreferredSize());
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for (final Component comp : this.panneauOutils.getComponents()) {
			this.components.put(comp.getName(), comp);
		}
	}

	/**
	 * Fonction de test principale de la classe.
	 * 
	 * @since 0.3.4.11
	 * 
	 * @version 0.3.6.3
	 */
	private void panneauBarreTest() {
		// Test de la présence de tout les boutons
		this.testPresenceBouton();

		// Test de la bonne association des outils
		this.testBoutonForme();

		// Test OutilSelectionner
		this.testSelectionner();

		this.panneauDessin.associerOutil(new OutilEtoile(this.panneauOutils));
	}

	/**
	 * Fonction testant la présence de tout les boutons dans
	 * {@code PanneauBarreOutil}.
	 * 
	 * @throws Error Si un bouton est mal nommé ou est n'est pas placé.
	 * 
	 * @since 0.3.4.11
	 * 
	 * @version 0.3.6.3
	 */
	private void testPresenceBouton() {

		final List<String> listBouton = new ArrayList<String>(Arrays.asList(PanneauBarreOutilsTest.NOM_BOUTONS));

		// Test de la présence de tout les boutons
		for (final Component component : this.panneauOutils.getComponents()) {
			if (listBouton.contains(component.getName())) {
				listBouton.remove(component.getName());
			} else {
				throw new Error("Un bouton a été mal nommé : " + component.getName());
			}
		}
		if (listBouton.size() != 0) {
			throw new Error("Un bouton n'a pas été placé : " + listBouton.get(0));
		}
	}

	/**
	 * Fonction testant la bonne association des boutons à leur {@code Outil}. Un
	 * poisson doit être dessiné dans le coin supérieur gauche de
	 * {@code PanneauDessin}.
	 */
	private void testBoutonForme() {
		this.panneauDessin.setCouleurCourante(Color.BLUE);
		JToggleButton boutonT = (JToggleButton) this.components.get(ActionChoisirRemplissage.NOM_ACTION);
		boutonT.doClick();
		boutonT = (JToggleButton) this.components.get(ActionChoisirForme.NOM_ACTION_CERCLE);
		boutonT.doClick();
		this.simpleClick(12, 6, 121, 115);

		boutonT = (JToggleButton) this.components.get(ActionChoisirForme.NOM_ACTION_LIGNE);
		boutonT.doClick();
		this.simpleClick(95, 107, 226, 6);
		this.simpleClick(95, 14, 226, 115);
		this.simpleClick(226, 6, 226, 115);

		this.panneauDessin.setCouleurCourante(Color.RED);
		boutonT = (JToggleButton) this.components.get(ActionChoisirForme.NOM_ACTION_ELLIPSE);
		boutonT.doClick();
		this.simpleClick(31, 76, 74, 90);

		this.panneauDessin.setCouleurCourante(Color.WHITE);
		boutonT = (JToggleButton) this.components.get(ActionChoisirForme.NOM_ACTION_CERCLE);
		boutonT.doClick();
		this.simpleClick(29, 28, 52, 52);
		this.simpleClick(59, 28, 82, 52);

		this.panneauDessin.setCouleurCourante(Color.YELLOW);
		boutonT = (JToggleButton) this.components.get(ActionChoisirForme.NOM_ACTION_ETOILE);
		((JSpinner) this.components.get(PanneauBarreOutils.BRANCHE_SPINNER_NOM)).setValue(10);
		((JSpinner) this.components.get(PanneauBarreOutils.LONGUEUR_SPINNER_NOM)).setValue(0.5);
		boutonT.doClick();
		this.simpleClick(31, 30, 40, 40);
		this.simpleClick(61, 30, 70, 40);
	}

	/**
	 * Fonction testant {@code OutilSelectionner}.
	 * <p>
	 * Le premier message doit être:
	 * {@code [Ligne] c1 : (10,0 , 300,) c2 : (110,0 , 400,0) longueur : 141,42 angle : 45,0° couleur = R255,V0,B0}
	 * <p>
	 * Le deuxième message doit être:
	 * {@code [Cercle-Rempli]: pos : (10,0 , 300,0) dim 100,0 x 100,0 périmètre : 314,16 aire : 7853,98 couleur = R255,V255,B255}
	 * <p>
	 * Le troisième message doit être:
	 * {@code [Ellipse-Rempli]: pos : (10,0 , 300,0) dim 140,0 x 110,0 périmètre : 394,11 aire : 12095,13 couleur = R0,V0,B0}
	 * <p>
	 * Le dernier message doit être:
	 * {@code [Cercle-Rempli]: pos : (12,0 , 6,0) dim 109,0 x 109,0 périmètre : 342,43 aire : 9331,32 couleur = R0,V0,B255}
	 */
	private void testSelectionner() {
		this.panneauDessin.setCouleurCourante(Color.BLACK);
		JToggleButton boutonT = (JToggleButton) this.components.get(ActionChoisirForme.NOM_ACTION_ELLIPSE);
		boutonT.doClick();
		this.simpleClick(10, 300, 150, 410);

		this.panneauDessin.setCouleurCourante(Color.WHITE);
		boutonT = (JToggleButton) this.components.get(ActionChoisirForme.NOM_ACTION_CERCLE);
		boutonT.doClick();
		this.simpleClick(10, 300, 110, 400);

		this.panneauDessin.setCouleurCourante(Color.RED);
		boutonT = (JToggleButton) this.components.get(ActionChoisirForme.NOM_ACTION_LIGNE);
		boutonT.doClick();
		this.simpleClick(10, 300, 110, 400);
		// this.doubleClick(35, 31);

		boutonT = (JToggleButton) this.components.get(ActionSelectionner.NOM_ACTION);
		boutonT.doClick();

		// Le message s'affichant doit faire reférence à la ligne.
		this.doubleClick(58, 350);

		// Le message doit faire référence au cercle
		this.doubleClick(40, 320);

		// Le message doit faire référence a l'ellipse
		this.doubleClick(125, 350);

		// Le message doit faire référence à un cercle plein de couleur bleu
		this.doubleClick(90, 90);
	}

	/**
	 * Fonction permettant d'utiliser le click de l'outil courant associer au
	 * panneau de dessin.
	 * 
	 * @param debutX L'abscisse de l'endroit ou le bouton gauche de la souris est
	 *               pressé.
	 * @param debutY L'ordonnée de l'endroit ou le bouton gauche de la souris est
	 *               pressé.
	 * @param finX   L'abscisse de l'endroit ou le bouton gauche de la souris est
	 *               relaché.
	 * @param finY   L'ordonnée de l'endroit ou le bouton gauche de la souris est
	 *               relaché.
	 *
	 * @see #doubleClick(int, int)
	 * 
	 * @since 0.3.4.11
	 */
	private void simpleClick(final int debutX, final int debutY, final int finX, final int finY) {
		this.panneauDessin.getOutilCourant().mousePressed(new MouseEvent(this.frame.getComponent(0),
				MouseEvent.MOUSE_PRESSED, 0, MouseEvent.BUTTON1_MASK, debutX, debutY, 1, false, MouseEvent.BUTTON1));
		this.panneauDessin.getOutilCourant().mouseReleased(new MouseEvent(this.frame.getComponent(0),
				MouseEvent.MOUSE_RELEASED, 0, MouseEvent.BUTTON1_MASK, finX, finY, 1, false, MouseEvent.BUTTON1));
	}

	/**
	 * Fonction permettant d'utiliser le double click de l'outil courant associer au
	 * panneau de dessin. Des crois de couleur {@value Color#MAGENTA} sont déssiné à
	 * l'nedroit du double clicks.
	 * 
	 * @param x Le {@code int} correspondant à l'abcisse du click.
	 * @param y Le {@code int} correspondant à l'orodonnées du click.
	 * 
	 * @see #dessinFormeClick(int, int, int , int)
	 * 
	 * @since 0.3.4.11
	 */
	public void doubleClick(final int x, final int y) {
		this.simpleClick(x, y, x, y);
		this.panneauDessin.getOutilCourant().mouseClicked(new MouseEvent(this.frame.getComponent(0),
				MouseEvent.MOUSE_CLICKED, 0, MouseEvent.BUTTON1_MASK, x, y, 2, false, MouseEvent.BUTTON1));

		for (double i = Math.PI / 4; i < 2 * Math.PI; i += Math.PI / 2) {
			final Outil outilCourant = this.panneauDessin.getOutilCourant();
			final Color couleurCourante = this.panneauDessin.getCouleurCourante();

			this.panneauDessin.associerOutil(new OutilLigne());
			this.panneauDessin.setCouleurCourante(Color.MAGENTA);
			simpleClick(x, y, x + (int) (10 * Math.cos(i)), y + (int) (10 * Math.sin(i)));

			this.panneauDessin.associerOutil(outilCourant);
			this.panneauDessin.setCouleurCourante(couleurCourante);
		}
	}

	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PanneauBarreOutilsTest().panneauBarreTest();
			}
		});
	}
}