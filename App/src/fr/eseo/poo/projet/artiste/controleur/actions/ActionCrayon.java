package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.AbstractAction;
import javax.swing.JToggleButton;

import java.awt.event.ActionEvent;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilCrayon;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEpicycloide;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Classe {@code ActionCrayon} permettant à l'utilisateur de sélectionner de
 * choisir entre dessiner à la main ou de dessiner une epicycloïde
 * 
 * @author Brinfer
 * 
 * @since 0.4.6.2
 */
@SuppressWarnings("serial")
public class ActionCrayon extends AbstractAction {

    /**
     * Constante de la classe permettant d'identifier {@code actionCommand} du
     * boutton et sera utilié comme une étiquette pour le {@code JButton} associé.
     * <p>
     * Ici il s'agit de l'action {@value}.
     * 
     * @see #NOM_ACTION_EPICYCLOIDE
     * 
     * @since 0.4.6.2
     */
    public static final String NOM_ACTION_CRAYON = "Main levée";
    /**
     * Constante de la classe permettant d'identifier {@code actionCommand} du
     * boutton et sera utilié comme une étiquette pour le {@code JButton} associé.
     * <p>
     * Ici il s'agit de l'action {@value}.
     * 
     * @see #NOM_ACTION_CRAYON
     * 
     * @since 0.4.6.2
     */
    public static final String NOM_ACTION_EPICYCLOIDE = " Dessin d'une épicycloïde";

    /**
     * Attribue de la classe permettant de mémoriser le {@code PanneauDessin} qu’on
     * utilise.
     * 
     * @since 0.4.6.2
     */
    private final PanneauDessin panneauDessin;

    /**
     * Constructeur d'une nouvelle {@code ActionSeletionner}.
     * 
     * @param panneauDessin Le {@code PanneauDessin} qu’on veut utiliser.
     * @param nomAction     Une {@code String} correspondant au nom de l'action,
     *                      permettant de l'identifier.
     * 
     * @since 0.4.6.2
     */
    public ActionCrayon(final PanneauDessin panneauDessin, final String nomAction) {
        super(nomAction);
        this.panneauDessin = panneauDessin;
    }

    /**
     * Fonction exécuté lors de l'appui sur le bouton associé à cette action.
     * 
     * @param event L'{@code ActionEvent} associé au bouton sur lequel on à cliqué.
     * 
     * @since 0.4.6.2
     */
    @Override
    public void actionPerformed(final ActionEvent event) {
        switch (((JToggleButton) event.getSource()).getName()) {
            case ActionCrayon.NOM_ACTION_CRAYON:
                this.panneauDessin.associerOutil(new OutilCrayon());
                break;
            case ActionCrayon.NOM_ACTION_EPICYCLOIDE:
                this.panneauDessin.associerOutil(new OutilEpicycloide());
                break;
            default:
        }
    }
}