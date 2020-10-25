package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;

import java.awt.GridLayout;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirRemplissage;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

/**
 * Classe {@code PanneauBarreOutils} pour représenter la barre d’outils
 * latérale.
 * <p>
 * Les actions possibles sont:
 * <ul>
 * <li>Effacer tout (voir {@linkplain ActionEffacer})</il>
 * </ul>
 * 
 * @see ActionEffacer
 * 
 * @author Brinfer
 * 
 * @since 0.3.4.5
 * 
 * @version 0.3.7.3
 */
public class PanneauBarreOutils extends JPanel {

	public static final String BRANCHE_SPINNER_NOM = "Nombre de branches";

	public static final String LONGUEUR_SPINNER_NOM = "Longueur des branches";

	/**
	 * Attribut de {@code PanneauBarreOutil} permettant de sauvegarder la zone
	 * d'action des boutons.
	 * 
	 * @since 0.3.4.5
	 */
	private PanneauDessin panneauDessin;

	/**
	 * Constructeur d'un nouveau {@code PanneauBarreOutils}.
	 * <p>
	 * La zone d'action des boutons est celle donné en paramètre.
	 * 
	 * @param panneauDessin le {@code PanneauDessin} sur laquelle les boutons auront
	 *                      une action.
	 * 
	 * @see PanneauDessin
	 * @see #initComponents
	 * 
	 * @since 0.3.4.5
	 */
	public PanneauBarreOutils(final PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
		this.initComponents();
	}

	/**
	 * Fonction permettant de retourner la valeur actuellement sélectionner dans le
	 * {@code JSpinner} dédier au nombre de branche de l'etoile.
	 * 
	 * @return {@code int} le nombre de branche pour l'étoile.
	 * 
	 * @since 0.3.7.3
	 */
	public int getNbBranches() {
		return (int) ((JSpinner) super.getComponent(super.getComponentCount() - 3)).getValue();
	}

	/**
	 * Fonction permettant de retourner la valeur actuellement sélectionner dans le
	 * {@code JSpinner} dédier à la longueur des branches de l'étoile.
	 * 
	 * @return {@code double} la longueur des branches pour l'étoile.
	 * 
	 * @since 0.3.7.3
	 */
	public double getLongueurBranche() {
		return (double) ((JSpinner) super.getComponent(super.getComponentCount() - 1)).getValue();
	}

	/**
	 * Fonction se chargant d’initialiser et d’ajouter les différentes composants
	 * présents dans le {@code PanneauBarreOutils}.
	 *
	 * @see <a href=
	 *      "https://docs.oracle.com/javase/7/docs/api/javax/swing/JButton.html">
	 *      Oracle - JButton</a>
	 * @see <a href=
	 *      "https://docs.oracle.com/javase/7/docs/api/javax/swing/JToggleButton.html">
	 *      Oracle - JToglleButton</a>
	 * @see <a href=
	 *      "https://docs.oracle.com/javase/7/docs/api/javax/swing/ButtonGroup.html">
	 *      Oracle - ButtonGroup</a>
	 * @see <a href=
	 *      "https://docs.oracle.com/javase/8/docs/api/javax/swing/SpinnerNumberModel.html">
	 *      Oracle - SpinnerNumberModel</a>
	 * 
	 * @see ActionEffacer
	 * @see ActionChoisirCouleur
	 * @see ActionChoisirForme
	 * @see ActionChoisirRemplissage
	 * @see ActionSelectionner
	 * 
	 * @since 0.3.4.5
	 * 
	 * @version 0.3.7.3
	 */
	public void initComponents() {

		super.setLayout(new GridLayout(13, 1));

		// Création du bouton effacer.
		final JButton effacer = new JButton(new ActionEffacer(this.panneauDessin));
		effacer.setName(ActionEffacer.NOM_ACTION);
		super.add(effacer);

		// Création du bouton de sélection de la couleur.
		final JButton couleur = new JButton(new ActionChoisirCouleur(this.panneauDessin));
		couleur.setName(ActionChoisirCouleur.NOM_ACTION);
		super.add(couleur);

		// Création du bouton toggle selectionner
		final JToggleButton selectionner = new JToggleButton(new ActionSelectionner(this.panneauDessin));
		selectionner.setName(ActionSelectionner.NOM_ACTION);
		super.add(selectionner);

		// Création du bouton toggle ligne.
		final JToggleButton ligne = new JToggleButton(
				new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_LIGNE));
		ligne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
		super.add(ligne);

		// Création du bouton toggle cercle.
		final JToggleButton cercle = new JToggleButton(
				new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_CERCLE));
		cercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
		super.add(cercle);

		// Création du bouton toggle ellipse.
		final JToggleButton ellipse = new JToggleButton(
				new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_ELLIPSE));
		ellipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
		super.add(ellipse);

		// Création du bouton toggle etoile.
		final JToggleButton etoile = new JToggleButton(
				new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_ETOILE));
		etoile.setName(ActionChoisirForme.NOM_ACTION_ETOILE);
		super.add(etoile);

		// Création de la checkBox pour le choix du remplissage des formes
		JCheckBox checkBox = new JCheckBox(new ActionChoisirRemplissage(this.panneauDessin));
		checkBox.setName(ActionChoisirRemplissage.NOM_ACTION);
		checkBox.setSelected(false);
		super.add(checkBox);

		// Ajout nombre de branche
		JSpinner nbBranche = new JSpinner(new SpinnerNumberModel(Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 3, 15, 1));
		JLabel labelNombre = new JLabel(PanneauBarreOutils.BRANCHE_SPINNER_NOM);
		nbBranche.setName(PanneauBarreOutils.BRANCHE_SPINNER_NOM);
		labelNombre.setName(PanneauBarreOutils.BRANCHE_SPINNER_NOM + "JLabel");
		super.add(labelNombre);
		super.add(nbBranche);
		// nbBranche.setVisible(false);
		// labelNombre.setVisible(false);

		// Ajout longueur de branche
		JSpinner longueurBranche = new JSpinner(new SpinnerNumberModel(Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, 0, 1, 0.01));
		JLabel labelLongueur = new JLabel(PanneauBarreOutils.LONGUEUR_SPINNER_NOM);
		longueurBranche.setName(PanneauBarreOutils.LONGUEUR_SPINNER_NOM);
		labelLongueur.setName(PanneauBarreOutils.LONGUEUR_SPINNER_NOM + "JLabel");
		super.add(labelLongueur);
		super.add(longueurBranche);
		// longueurBranche.setVisible(false);
		// labelLongueur.setVisible(false);

		// Création du groupe de bouton des outils.
		final ButtonGroup groupe = new ButtonGroup();
		groupe.add(selectionner);
		groupe.add(ligne);
		groupe.add(cercle);
		groupe.add(ellipse);
		groupe.add(etoile);
	}
}