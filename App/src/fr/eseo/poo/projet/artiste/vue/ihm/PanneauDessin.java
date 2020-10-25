package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.JPanel;

import fr.eseo.poo.projet.artiste.controleur.outils.Outil;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe {@code PanneauDessin} permettant d'afficher les représentations des
 * figures ajouter à sa liste de figure.
 * 
 * @author Brinfer
 * 
 * @since 0.3.3.1
 * 
 * @version 0.3.6.2
 */
public class PanneauDessin extends JPanel {

	/**
	 * La valeur de type {@code double} par défaut de la largeur de la zone de
	 * dessin.
	 * 
	 * @since 0.3.3.1
	 */
	public static final int LARGEUR_PAR_DEFAUT = 400;

	/**
	 * La valeur de type {@code double} par défaut de la hauteur de la zone de
	 * dessin.
	 * 
	 * @since 0.3.3.1
	 */
	public static final int HAUTEUR_PAR_DEFAUT = 240;

	/**
	 * La valeur de type {@code Code} par défaut de la couleur de fond de la zone de
	 * dessin, par défaut de valeur : {@code (255, 228, 245)}.
	 * <p>
	 * Cette couleur est définie comme différente de la couleur de premier plan pour
	 * un {@code JPanel} : {@code (0, 0, 0)}.
	 * 
	 * @see <a href=
	 *      "https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/_nimbusDefaults.html">Oracle
	 *      Nimbus Default</a>
	 * @see Color
	 */
	public static final Color COULEUR_FOND_PAR_DEFAUT = new Color(233, 234, 234);

	/**
	 * {@code List} des {@code VueForme} afficher dans le panneau.
	 * <p>
	 * On peut en ajouter.
	 * 
	 * @since 0.3.3.5
	 */
	private final List<VueForme> vueFormes;

	/**
	 * L'{@code Outil} associé comme étant l'actuel outil courant.
	 * 
	 * @since 0.3.4.1
	 */
	private Outil outilCourant;

	/**
	 * La {@code Color} permettant de stocker la couleur qui sera utilisée pour
	 * dessiner les formes.
	 * 
	 * @since 0.3.5.2
	 */
	private Color couleurCourante;

	/**
	 * Le {@code boolean} permettant de sauvegarder si l'utilisateur veut ou non
	 * remplir les formes qu'il desssine.
	 * 
	 * @since 0.3.6.2
	 */
	private boolean estRempli;

	/**
	 * Constructeur d'un nouveau {@code PanneauDessin} par défaut. Les instance
	 * seront initialisee aux valeurs par defauts.
	 * 
	 * @see #vueFormes
	 * @see #PanneauDessin(int, int, Color)
	 * 
	 * @since 0.3.3.1
	 */
	public PanneauDessin() {
		this(PanneauDessin.LARGEUR_PAR_DEFAUT, PanneauDessin.HAUTEUR_PAR_DEFAUT, PanneauDessin.COULEUR_FOND_PAR_DEFAUT);
	}

	/**
	 * Constructeur d'un nouveau {@code PanneauDessin} a partir d'une largeur, d'une
	 * hauteur, et une couleur de fond.
	 * 
	 * @param largeur Un {@code double} correspondant à la largeur de la zone de
	 *                dessin.
	 * @param hauteur Un {@code double} correspondant à la hauteur de la zone de
	 *                dessin.
	 * @param fond    Un{@code Color} correspondant à la couleur de fond de la de la
	 *                zonde de dessin.
	 * 
	 * @see #vueFormes
	 * @see #PanneauDessin()
	 * 
	 * @since 0.3.3.1
	 * 
	 * @version 0.3.3.5
	 */
	public PanneauDessin(final int largeur, final int hauteur, final Color fond) {
		super.setBackground(fond);
		super.setPreferredSize(new Dimension(largeur, hauteur));
		this.vueFormes = new ArrayList<VueForme>();
		this.couleurCourante = Forme.COULEUR_PAR_DEFAUT;
		this.estRempli = false;
	}

	/**
	 * Accesseur des {@code vueFormes}.
	 * 
	 * @return Une {@code ist<Forme>} des représentation des formes affichées.
	 * 
	 * @since 0.3.3.5
	 */
	public List<VueForme> getVueFormes() {
		return this.vueFormes;
	}

	/**
	 * Mutateur des {@code vueFormes}.
	 * <p>
	 * Permet d'ajouter dans le panneau la représentation de la forme passé en
	 * paramètre.
	 * 
	 * @param vueForme La {@code vueForme} correspondant à la représentation de la
	 *                 forme que l'on souhaite afficher.
	 * 
	 * @since 0.3.3.5
	 */
	public void ajouterVueForme(final VueForme vueForme) {
		this.vueFormes.add(vueForme);
	}

	/**
	 * Fonction permettant d'afficher dans le contexte graphiques les
	 * représentations des formes de la liste du panneau.
	 * 
	 * @param g Le contexte {@code Graphics} où l'on souhaite l'affichage.
	 * 
	 * @since 0.3.3.5
	 */
	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);

		final Graphics2D g2D = (Graphics2D) g.create();

		for (final VueForme vueForme : this.getVueFormes()) {
			vueForme.affiche(g2D);
		}

		g2D.dispose();
	}

	/**
	 * Méthode se chargant d’associer l'{@code Outil} donné en paramètre en tant que
	 * le seul {@code Outil} courant.
	 * <p>
	 * Un seul outil peut être associé à la fois. L'association d'un {@code Outil}
	 * entraine donc la dissociation du {@code PanneauDessin} de l'ancien
	 * {@code Outil}
	 * 
	 * @param outil L'{@code Outil} que l'on veut mettre en outil courant.
	 * 
	 * @since 0.3.4.1
	 */
	public void associerOutil(final Outil outil) {
		if (outil != null) {
			this.dissocierOutil();
			this.setOutilCourant(outil);
			addMouseListener(this.getOutilCourant());
			addMouseMotionListener(this.getOutilCourant());
			this.getOutilCourant().setPanneauDessin(this);
		}
	}

	/**
	 * Méthode se chargant de supprimer l'{@code Outil} déjà associé en tant que
	 * outil courant.
	 * 
	 * @since 0.3.4.1
	 */
	private void dissocierOutil() {
		if (this.getOutilCourant() != null) {
			removeMouseListener(this.getOutilCourant());
			removeMouseMotionListener(this.getOutilCourant());
			this.getOutilCourant().setPanneauDessin(null);
			this.setOutilCourant(null);
		}
	}

	/**
	 * Accesseur de l'outil courant associé.
	 * 
	 * @return L'{@code Outil} qui est actuellement l'outil courant.
	 * 
	 * @see #setOutilCourant(Outil)
	 * 
	 * @since 0.3.4.1
	 */
	public Outil getOutilCourant() {
		return this.outilCourant;
	}

	/**
	 * Mutateur de {@code outilCourant}.
	 * 
	 * @param outil Le nouvel {@code Outil} que l'on vet associer comme outil
	 *              courant.
	 * 
	 * @see #getOutilCourant()
	 * 
	 * @since 0.3.4.1
	 */
	private void setOutilCourant(final Outil outil) {
		this.outilCourant = outil;
	}

	/**
	 * Accesseur de la {@code Color} courante utilisé pour dessiner les formes.
	 * 
	 * @return La {@code Color} utilié pour dessiner les formes.
	 * 
	 * @see #setCouleurCourante(Color)
	 * 
	 * @since 0.3.5.2
	 */
	public Color getCouleurCourante() {
		return this.couleurCourante;
	}

	/**
	 * Mutateur de la couleur courante utilisé pour dessiner les formes.
	 * 
	 * @param couleurCourante La nouvelle {@code Color} utilisé pour dessiner les
	 *                        formes.
	 * 
	 * @see #getCouleurCourante()
	 * 
	 * @since 0.3.5.2
	 */
	public void setCouleurCourante(final Color couleurCourante) {
		this.couleurCourante = couleurCourante;
	}

	/**
	 * Accesseur permettant de savoir si l'utilisateur veut remplir ou non les
	 * formes qu'il dessine.
	 * 
	 * @return {@code true} si l'utilisateur souhaite remplir les formes,
	 *         {@code false} sinon.
	 * 
	 * @since 0.3.6.2
	 */
	public boolean getModeRemplissage() {
		return this.estRempli;
	}

	/**
	 * Mutateur du choix de l'utilisateur vis à vis du remplissage ou non les formes
	 * qu'il dessine.
	 * 
	 * @param modeRemplissage Un {@code boolean} indiquant s'il l'on souhaite ou non
	 *                        remplir les formes que l'on dessine.
	 * 
	 * @since 0.3.6.2
	 */
	public void setModeRemplissage(final boolean modeRemplissage) {
		this.estRempli = modeRemplissage;
	}
}