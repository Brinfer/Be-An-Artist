package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.AbstractAction;
import javax.swing.JToggleButton;

import java.awt.event.ActionEvent;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilChangerCouleur;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEffacer;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilSelectionner;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Classe {@code ActionSelectionner} permettant à l'utilisateur de sélectionner
 * des {@code Formes} déjà déssiné.
 *
 * @author Brinfer
 *
 * @since 0.3.4.9
 *
 * @version 0.4.5
 */
@SuppressWarnings("serial")
public class ActionSelectionner extends AbstractAction {

    /**
     * Constante de la classe permettant d'identifier {@code actionCommand} du
     * bouton et sera utilisé comme une étiquette pour le {@code JButton} associé.
     * <p>
     * Ici il s'agit de l'action {@value}.
     *
     * @see #NOM_SELECTIONNER_COULEUR
     * @see #NOM_SELECTIONNER_COULEUR
     *
     * @since 0.3.4.9
     */
    public static final String NOM_SELECTIONNER_ACTION = "Sélectionner";

    /**
     * Constante de la classe permettant d'identifier {@code actionCommand} du
     * bouton et sera utilisé comme une étiquette pour le {@code JButton} associé.
     * <p>
     * Ici il s'agit de l'action {@value}.
     *
     * @see #NOM_SELECTIONNER_ACTION
     * @see #NOM_SELECTIONNER_COULEUR
     *
     * @since 0.4.5
     */
    public static final String NOM_SELECTIONNER_EFFACER = "Effacer la sélection";

    /**
     * Constante de la classe permettant d'identifier {@code actionCommand} du
     * bouton et sera utilisé comme une étiquette pour le {@code JButton} associé.
     * <p>
     * Ici il s'agit de l'action {@value}.
     *
     * @see #NOM_SELECTIONNER_ACTION
     * @see #NOM_SELECTIONNER_EFFACER
     *
     * @since 0.4.5
     */
    public static final String NOM_SELECTIONNER_COULEUR = "Changer la couleur de la sélection";

    /**
     * Attribue de la classe permettant de mémoriser le {@code PanneauDessin} qu’on
     * utilise.
     *
     * @since 0.3.4.9
     */
    private final PanneauDessin panneauDessin;

    /**
     * Attribue de la classe permettant de mémoriser le {@code PanneauBarreOutils}
     * qu’on utilise.
     *
     * @since 0.4.5
     */
    private final PanneauBarreOutils panneauOutils;

    /**
     * Constructeur d'une nouvelle {@code ActionSeletionner}.
     *
     * @param panneauDessin Le {@code PanneauDessin} qu’on veut utiliser.
     * @param panneauOutil  Le {@code PanneauBarreOutils} associé.
     * @param nomAction     Une {@code String} correspondant au nom de l'action,
     *                      permettant de l'identifier.
     *
     * @since 0.3.4.9
     *
     * @version 0.4.5
     */
    public ActionSelectionner(final PanneauDessin panneauDessin, final PanneauBarreOutils panneauOutils,
            final String nomAction) {
        super(nomAction);
        this.panneauDessin = panneauDessin;
        this.panneauOutils = panneauOutils;
    }

    /**
     * Fonction exécuté lors de l'appui sur le bouton associé à cette action.
     *
     * @param event L'{@code ActionEvent} associé au bouton sur lequel on à cliqué.
     *
     * @since 0.3.4.9
     *
     * @version 0.4.5
     */
    @Override
    public void actionPerformed(final ActionEvent event) {
        this.effacerCadreSelection();

        switch (((JToggleButton) event.getSource()).getName()) {
            case ActionSelectionner.NOM_SELECTIONNER_ACTION:
                this.panneauDessin.associerOutil(new OutilSelectionner());

                // Affichage du JPanel contenant les autres boutons
                this.panneauOutils.afficheContainer(PanneauBarreOutils.CONTENEUR_SELECTION_NOM);
                break;
            case ActionSelectionner.NOM_SELECTIONNER_EFFACER:
                this.panneauDessin.associerOutil(new OutilEffacer());
                break;
            case ActionSelectionner.NOM_SELECTIONNER_COULEUR:
                this.panneauDessin.associerOutil(new OutilChangerCouleur());
                break;
            default:
        }
    }

    /**
     * Fonction permettant de supprimer le cadre de la dernière selection si
     * l'{@code Outil} précédent été {@code OutilSelectionner}.
     *
     * @since 0.4.1.2
     */
    private void effacerCadreSelection() {
        try {
            final OutilSelectionner outilSelect = (OutilSelectionner) this.panneauDessin.getOutilCourant();
            this.panneauDessin.getVueFormes().remove(outilSelect.getVueCadreSelection());
        } catch (ClassCastException | NullPointerException e) {

        }
    }

}