package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import java.awt.CardLayout;
import java.awt.Component;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirEpaisseurTrait;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirLongueurBranches;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirNombreDeBranches;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirRapport;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirRemplissage;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionCrayon;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacerTout;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.formes.Epicycloide;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;

/**
 * Classe {@code PanneauBarreOutils} pour représenter la barre d’outils
 * latérale.
 * <p>
 * Les actions possibles sont:
 * <ul>
 * <li>Effacer tout.</li>
 * <li>Changer la couleur avec laquelle l'on dessine.</li>
 * <li>Choisir de remplir ou non les formes dessiner.</li>
 * <li>Choisir l'épaisseur du trait du dessin.</li>
 * <li>Choisir le nombre de branches à donner à une étoile.</li>
 * <li>Choisir la longueur des branches à donner à une étoile.</li>
 * <li>Choisir l'action associé avec la sélection d'une forme.</li>
 * </ul>
 * 
 * @author Brinfer
 * 
 * @since 0.3.4.5
 * 
 * @version 0.4.6.2
 */
@SuppressWarnings("serial")
public class PanneauBarreOutils extends JPanel {

    /**
     * La valeur de type {@code String} pour désigner le {@code Container} des
     * boutons.
     * 
     * @since 0.4.4.2
     */
    public static final String CONTENEUR_BOUTON_NOM = "Conteneur bouton";

    /**
     * La valeur de type {@code String} pour désigner le {@code Container} des
     * boutons propres à l'etoile.
     * 
     * @since 0.4.4.2
     */
    public static final String CONTENEUR_ETOILE_NOM = "Conteneur etoile";

    /**
     * La valeur de type {@code String} pour désigner le {@code Container} vide.
     * 
     * @since 0.4.4.2
     */
    public static final String CONTENEUR_VIDE_NOM = "Conteneur vide";

    /**
     * La valeur de type {@code String} pour désigner le {@code Container} des
     * {@code Container} pouvant être masqué.
     * 
     * @since 0.4.4.2
     */
    public static final String CONTENEUR_CARD_NOM = "Conteneur card";

    /**
     * La valeur de type {@code String} pour désigner le {@code Container} des
     * boutons associé à la sélection.
     * 
     * @since 0.4.5
     */
    public static final String CONTENEUR_SELECTION_NOM = "Conteneur selection";

    public static final String CONTENEUR_CRAYON_NOM = "Conteneur crayon";

    /**
     * Attribue permettant de suavegarder dans une {@code Map} les différent
     * {@code JPanel} du {@code PanneuBarreOutils}.
     * 
     * @see Map
     * 
     * @since 0.4.4.2
     */
    private final Map<String, JPanel> mapJPanelCache = new HashMap<String, JPanel>();

    /**
     * Attribut de {@code PanneauBarreOutil} permettant de sauvegarder la zone
     * d'action des boutons.
     * 
     * @since 0.3.4.5
     */
    private final PanneauDessin panneauDessin;

    /**
     * Attribue permettant de sauvegarder le gestionnaire de placement du
     * {@code JPanel} contenant les {@code JPanel} amovible.
     * 
     * @since 0.4.4.2
     */
    private CardLayout card;

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
     * Accesseur de la {@code Map} contentant les {@code JPanels}.
     * <p>
     * Les clés sont les noms des {@code JPanels}.
     * 
     * @return Une {@code Map<String, JPanel>} des {@code JPanels} du
     *         {@code PanneauBarreOutils}.
     * 
     * @see #CONTENEUR_BOUTON_NOM
     * @see #CONTENEUR_CARD_NOM
     * @see #CONTENEUR_ETOILE_NOM
     * @see #CONTENEUR_SELECTION_NOM
     * @see #CONTENEUR_VIDE_NOM
     * 
     * @since 0.4.4.2
     */
    public Map<String, JPanel> getMapJPanel() {
        return this.mapJPanelCache;
    }

    /**
     * Fonction permetant d'afficher le {@code Container} du {@code JPanel} ayant le
     * gestionnaire {@code CardLayout} dont le nom est donné en paramètre.
     * 
     * @param nomContainer Le nom du {@code Container} que l'on veut afficher.
     * 
     * @since 0.4.2.2
     */
    public void afficheContainer(final String nomContainer) {
        this.card.show(this.getMapJPanel().get(PanneauBarreOutils.CONTENEUR_CARD_NOM), nomContainer);
    }

    /**
     * Fonction se chargant d’initialiser et d’ajouter les différentes composants
     * présents dans le {@code PanneauBarreOutils}.
     *
     * @see <a href=
     *      "https://docs.oracle.com/javase/8/docs/api/javax/swing/JButton.html">
     *      Oracle - JButton</a>
     * @see <a href=
     *      "https://docs.oracle.com/javase/8/docs/api/javax/swing/JToggleButton.html">
     *      Oracle - JToglleButton</a>
     * @see <a href=
     *      "https://docs.oracle.com/javase/8/docs/api/javax/swing/ButtonGroup.html">
     *      Oracle - ButtonGroup</a>
     * @see <a href=
     *      "https://docs.oracle.com/javase/8/docs/api/javax/swing/SpinnerNumberModel.html">
     *      Oracle - SpinnerNumberModel</a>
     * 
     * @see ActionEffacerTout
     * @see ActionChoisirCouleur
     * @see ActionChoisirForme
     * @see ActionChoisirRemplissage
     * @see ActionSelectionner
     * @see ActionChoisirEpaisseurTrait
     * @see ActionChoisirNombreDeBranches
     * @see ActionChoisirLongueurDesBranches
     * @see ActionSelectionner
     * 
     * @since 0.3.4.5
     * 
     * @version 0.4.5
     */
    public void initComponents() {
        super.setLayout(new GridLayout(2, 1));

        // Ajout des boutons
        this.ajoutBoutons(this);

        final JPanel conteneurCard = new JPanel();
        this.card = new CardLayout();
        conteneurCard.setLayout(card);
        conteneurCard.setName(PanneauBarreOutils.CONTENEUR_CARD_NOM);
        super.add(conteneurCard, PanneauBarreOutils.CONTENEUR_CARD_NOM);

        // Ajout des components lié à l'etoile
        this.ajoutComponentEtoile(conteneurCard);

        // Ajout d'un conteneur vide
        this.ajoutConteneurVide(conteneurCard);

        // Ajout d'un conteneur pour les boutons de selectionner
        this.ajoutConteneurSelection(conteneurCard);

        // Ajout d'un conteneur pour les boutons de crayon
        this.ajoutConteneurCrayon(conteneurCard);

        this.card.show(conteneurCard, PanneauBarreOutils.CONTENEUR_VIDE_NOM);

        for (final Component comp : conteneurCard.getComponents()) {
            this.mapJPanelCache.put(comp.getName(), (JPanel) comp);
        }
        this.mapJPanelCache.put(conteneurCard.getName(), conteneurCard);
    }

    /**
     * Fonction créant dans le JPanel donné en paramètre un JPanel vide.
     * 
     * @param conteneurMaster Le {@code JPanel} contenant celui qui va être créer.
     * 
     * @since 0.4.3.2
     */
    private void ajoutConteneurVide(final JPanel conteneurMaster) {
        final JPanel conteneurVide = new JPanel();
        conteneurVide.setName(PanneauBarreOutils.CONTENEUR_VIDE_NOM);
        conteneurMaster.add(conteneurVide, PanneauBarreOutils.CONTENEUR_VIDE_NOM);
    }

    /**
     * Fonction créant dans le JPanel donné en paramètre un JPanel contenant les
     * {@code Components} dédié à l'{@code Etoile}.
     * 
     * @param conteneurMaster Le {@code JPanel} contenant celui qui va être créer.
     * 
     * @since 0.4.3.2
     */
    private void ajoutComponentEtoile(final JPanel conteneurMaster) {
        final JPanel conteneurEtoile = new JPanel();
        conteneurEtoile.setLayout(new GridLayout(4, 1));
        conteneurEtoile.setName(PanneauBarreOutils.CONTENEUR_ETOILE_NOM);
        conteneurMaster.add(conteneurEtoile, PanneauBarreOutils.CONTENEUR_ETOILE_NOM);

        // Création du label et du spinner nombre de branche
        final JSpinner nombreBranchesEtoile = new JSpinner(
                new SpinnerNumberModel(Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 3, 15, 1));
        final JLabel labelNombre = new JLabel(ActionChoisirNombreDeBranches.NOM_ACTION);
        nombreBranchesEtoile.setName(ActionChoisirNombreDeBranches.NOM_ACTION);
        labelNombre.setName(ActionChoisirNombreDeBranches.NOM_ACTION + "JLabel");
        nombreBranchesEtoile.addChangeListener(new ActionChoisirNombreDeBranches(this.panneauDessin));

        // Création du label et du spinner longueur de branche
        final JSpinner longueurBrancheEtoile = new JSpinner(
                new SpinnerNumberModel(Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, 0, 1, 0.01));
        final JLabel labelLongueur = new JLabel(ActionChoisirLongueurBranches.NOM_ACTION);
        longueurBrancheEtoile.setName(ActionChoisirLongueurBranches.NOM_ACTION);
        labelLongueur.setName(ActionChoisirLongueurBranches.NOM_ACTION + "JLabel");
        longueurBrancheEtoile.addChangeListener(new ActionChoisirLongueurBranches(this.panneauDessin));

        // Ajout des components
        conteneurEtoile.add(labelLongueur);
        conteneurEtoile.add(longueurBrancheEtoile);
        conteneurEtoile.add(labelNombre);
        conteneurEtoile.add(nombreBranchesEtoile);
    }

    /**
     * Fonction ajoutant dans le JPanel donné en paramètre différent boutons.
     * 
     * @param conteneurMaster Le {@code JPanel} contenant les boutons qui seront
     *                        crée.
     * 
     * @since 0.4.3.2
     */
    private void ajoutBoutons(final JPanel conteneurMaster) {
        final JPanel conteneurBouton = new JPanel();
        conteneurBouton.setLayout(new GridLayout(11, 1));
        conteneurBouton.setName(PanneauBarreOutils.CONTENEUR_BOUTON_NOM);
        conteneurMaster.add(conteneurBouton, PanneauBarreOutils.CONTENEUR_BOUTON_NOM);

        // Création du bouton effacer.
        final JButton effacer = new JButton(new ActionEffacerTout(this.panneauDessin));
        effacer.setName(ActionEffacerTout.NOM_ACTION);

        // Création du bouton de sélection de la couleur.
        final JButton couleur = new JButton(new ActionChoisirCouleur(this.panneauDessin));
        couleur.setName(ActionChoisirCouleur.NOM_ACTION);

        // Création du bouton toggle selectionner
        final JToggleButton selectionner = new JToggleButton(
                new ActionSelectionner(this.panneauDessin, this, ActionSelectionner.NOM_SELECTIONNER_ACTION));
        selectionner.setName(ActionSelectionner.NOM_SELECTIONNER_ACTION);
        conteneurBouton.add(selectionner);

        // Création du bouton toggle ligne.
        final JToggleButton ligne = new JToggleButton(
                new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_LIGNE));
        ligne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);

        // Création du bouton toggle cercle.
        final JToggleButton cercle = new JToggleButton(
                new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_CERCLE));
        cercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);

        // Création du bouton toggle ellipse.
        final JToggleButton ellipse = new JToggleButton(
                new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_ELLIPSE));
        ellipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);

        // Création du bouton toggle etoile.
        final JToggleButton etoile = new JToggleButton(
                new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_ETOILE));
        etoile.setName(ActionChoisirForme.NOM_ACTION_ETOILE);

        // Création du bouton toggle crayon.
        final JToggleButton crayon = new JToggleButton(
                new ActionChoisirForme(this.panneauDessin, this, ActionChoisirForme.NOM_ACTION_CRAYON));
        crayon.setName(ActionChoisirForme.NOM_ACTION_CRAYON);

        final JSpinner epaisseurTrait = new JSpinner(new SpinnerNumberModel(1, Forme.EPAISSEUR_TRAIT_DEFAUT, 10, 1));
        final JLabel labelTrait = new JLabel(ActionChoisirEpaisseurTrait.NOM_ACTION);
        epaisseurTrait.setName(ActionChoisirEpaisseurTrait.NOM_ACTION);
        labelTrait.setName(ActionChoisirEpaisseurTrait.NOM_ACTION + "JLabel");
        epaisseurTrait.addChangeListener(new ActionChoisirEpaisseurTrait(this.panneauDessin));

        // Création de la checkBox pour le choix du remplissage des formes
        final JCheckBox checkBox = new JCheckBox(new ActionChoisirRemplissage(this.panneauDessin));
        checkBox.setName(ActionChoisirRemplissage.NOM_ACTION);
        checkBox.setSelected(false);

        // Ajout des boutons
        conteneurBouton.add(effacer);
        conteneurBouton.add(couleur);
        conteneurBouton.add(ligne);
        conteneurBouton.add(cercle);
        conteneurBouton.add(ellipse);
        conteneurBouton.add(etoile);
        conteneurBouton.add(crayon);
        conteneurBouton.add(labelTrait);
        conteneurBouton.add(epaisseurTrait);
        conteneurBouton.add(checkBox);

        // Création du groupe de bouton des outils.
        final ButtonGroup groupe = new ButtonGroup();
        groupe.add(selectionner);
        groupe.add(ligne);
        groupe.add(cercle);
        groupe.add(ellipse);
        groupe.add(etoile);
        groupe.add(crayon);
    }

    /**
     * Fonction ajoutant dans le JPanel donné en paramètre différents boutons liés à
     * la sélection.
     * 
     * @param conteneurMaster Le {@code JPanel} contenant les boutons qui seront
     *                        crée.
     * 
     * @since 0.4.5
     */
    private void ajoutConteneurSelection(JPanel conteneurMaster) {
        final JPanel conteneurSelection = new JPanel();
        conteneurSelection.setLayout(new GridLayout(4, 1));
        conteneurSelection.setName(PanneauBarreOutils.CONTENEUR_SELECTION_NOM);
        conteneurMaster.add(conteneurSelection, PanneauBarreOutils.CONTENEUR_SELECTION_NOM);

        // Création du bouton Effacer
        JToggleButton effacerSelectionner = new JToggleButton(
                new ActionSelectionner(this.panneauDessin, this, ActionSelectionner.NOM_SELECTIONNER_EFFACER));
        effacerSelectionner.setName(ActionSelectionner.NOM_SELECTIONNER_EFFACER);

        // Création du bouton changement couleur
        JToggleButton changerCouleurSelectionner = new JToggleButton(
                new ActionSelectionner(this.panneauDessin, this, ActionSelectionner.NOM_SELECTIONNER_COULEUR));
        changerCouleurSelectionner.setName(ActionSelectionner.NOM_SELECTIONNER_COULEUR);

        // Ajout des boutons
        conteneurSelection.add(effacerSelectionner);
        conteneurSelection.add(changerCouleurSelectionner);

        // Création du groupe de boutton.
        final ButtonGroup groupe = new ButtonGroup();
        groupe.add(changerCouleurSelectionner);
        groupe.add(effacerSelectionner);
    }

    /**
     * Creation du conteneur contenant les bouton dédié à l'{@code OutilCrayon} et
     * {@code OutilEpicycloide}.
     * 
     * @param conteneurMasterLe {@code JPanel} contenant les boutons qui seront
     *                          crée.
     * 
     * @see <a href=
     *      "https://docs.oracle.com/javase/8/docs/api/javax/swing/SpinnerListModel.html">Oracle
     *      - SpinnerListModel</a>
     * 
     * @since 0.4.6.2
     */
    private void ajoutConteneurCrayon(JPanel conteneurMaster) {
        final JPanel conteneurCrayon = new JPanel();
        conteneurCrayon.setLayout(new GridLayout(4, 1));
        conteneurCrayon.setName(PanneauBarreOutils.CONTENEUR_CRAYON_NOM);
        conteneurMaster.add(conteneurCrayon, PanneauBarreOutils.CONTENEUR_CRAYON_NOM);

        // Création du bouton Effacer
        JToggleButton tracerALaMain = new JToggleButton(
                new ActionCrayon(this.panneauDessin, ActionCrayon.NOM_ACTION_CRAYON));
        tracerALaMain.setName(ActionCrayon.NOM_ACTION_CRAYON);

        // Création du bouton changement couleur
        JToggleButton epicycloide = new JToggleButton(
                new ActionCrayon(this.panneauDessin, ActionCrayon.NOM_ACTION_EPICYCLOIDE));
        epicycloide.setName(ActionCrayon.NOM_ACTION_EPICYCLOIDE);

        JSpinner rapportQ = new JSpinner(new SpinnerListModel(Epicycloide.RAPPORT_POSSIBLE));
        rapportQ.setName(ActionChoisirRapport.NOM_ACTION);
        rapportQ.addChangeListener(new ActionChoisirRapport(this.panneauDessin));
        rapportQ.setValue(Epicycloide.RAPPORT_RAYON_Q_DEFAUT);
        JLabel labelRapport = new JLabel(ActionChoisirRapport.NOM_ACTION);
        labelRapport.setName(ActionChoisirRapport.NOM_ACTION);

        // Ajout des boutons
        conteneurCrayon.add(tracerALaMain);
        conteneurCrayon.add(epicycloide);
        conteneurCrayon.add(labelRapport);
        conteneurCrayon.add(rapportQ);

        // Création du groupe de boutton.
        final ButtonGroup groupe = new ButtonGroup();
        groupe.add(epicycloide);
        groupe.add(tracerALaMain);
    }
}