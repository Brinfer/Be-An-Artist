package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilCrayon;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEtoile;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilSelectionner;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Classe permettant de créer un nouvel {@code OutilLigne}, {@code OutilEllipse}
 * ou {@code OutilCercle}.
 * 
 * @see OutilCercle
 * @see OutilEllipse
 * @see OutilLigne
 * @see OutilSelectionner
 * 
 * @author Brinfer
 * 
 * @since 0.3.4.9
 * 
 * @version 0.4.3.2
 */
@SuppressWarnings("serial")
public class ActionChoisirForme extends AbstractAction {
    /**
     * Constante de la classe permettant d'identifier {@code actionCommand} de
     * chaque forme et sera utilié comme une étiquette pour le {@code JButton}
     * associé.
     * <p>
     * Ici il s'agit de l'action {@value}.
     * 
     * @see PanneauBarreOutils#initComponents()
     * @see #NOM_ACTION_ELLIPSE
     * @see #NOM_ACTION_CERCLE
     * @see #NOM_ACTION_ETOILE
     * @see #NOM_ACTION_CRAYON
     * 
     * @since 0.3.4.9
     */
    public static final String NOM_ACTION_LIGNE = "Ligne";

    /**
     * Constante de la classe permettant d'identifier {@code actionCommand} de
     * chaque forme et sera utilié comme une étiquette pour le {@code JButton}
     * associé.
     * <p>
     * Ici il s'agit de l'action {@value}.
     * 
     * @see PanneauBarreOutils#initComponents()
     * @see #NOM_ACTION_LIGNE
     * @see #NOM_ACTION_CERCLE
     * @see #NOM_ACTION_ETOILE
     * @see #NOM_ACTION_CRAYON
     * 
     * @since 0.3.4.9
     */
    public static final String NOM_ACTION_ELLIPSE = "Ellipse";

    /**
     * Constante de la classe permettant d'identifier {@code actionCommand} de
     * chaque forme et sera utilié comme une étiquette pour le {@code JButton}
     * associé.
     * <p>
     * Ici il s'agit de l'action {@value}.
     * 
     * @see PanneauBarreOutils#initComponents()
     * @see #NOM_ACTION_ELLIPSE
     * @see #NOM_ACTION_LIGNE
     * @see #NOM_ACTION_ETOILE
     * @see #NOM_ACTION_CRAYON
     * 
     * @since 0.3.4.9
     */
    public static final String NOM_ACTION_CERCLE = "Cercle";

    /**
     * Constante de la classe permettant d'identifier {@code actionCommand} de
     * chaque forme et sera utilié comme une étiquette pour le {@code JButton}
     * associé.
     * <p>
     * Ici il s'agit de l'action {@value}.
     * 
     * @see PanneauBarreOutils#initComponents()
     * @see #NOM_ACTION_ELLIPSE
     * @see #NOM_ACTION_LIGNE
     * @see #NOM_ACTION_CERCLE
     * @see #NOM_ACTION_CRAYON
     * 
     * @since 0.3.7.3
     */
    public static final String NOM_ACTION_ETOILE = "Etoile";

    /**
     * Constante de la classe permettant d'identifier {@code actionCommand} du
     * boutton et sera utilié comme une étiquette pour le {@code JButton} associé.
     * <p>
     * Ici il s'agit de l'action {@value}.
     * 
     * @see PanneauBarreOutils#initComponents()
     * @see #NOM_ACTION_ELLIPSE
     * @see #NOM_ACTION_LIGNE
     * @see #NOM_ACTION_CERCLE
     * @see #NOM_ACTION_ETOILE
     * 
     * @since 0.4.3.2
     */
    public static final String NOM_ACTION_CRAYON = "Crayon";

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
     * @since 0.3.4.9
     */
    private final PanneauBarreOutils panneauOutils;

    /**
     * Constructeur d'une nouvelle {@code ActionChoisirForme}.
     * 
     * @param panneauDessin Le {@code PanneauDessin} qu’on veut utiliser.
     * @param panneauOutils Le {@code PanneauBarreOutils} qu'on veut utiliser.
     * @param nomAction     Le nom utilisé pour identifier l’action.
     * 
     * @since 0.3.4.9
     */
    public ActionChoisirForme(final PanneauDessin panneauDessin, final PanneauBarreOutils panneauOutils,
            final String nomAction) {
        super(nomAction);
        this.panneauDessin = panneauDessin;
        this.panneauOutils = panneauOutils;
    }

    /**
     * En comparant l’{@code actionCommand} récupérée dans
     * l’{@linkplain ActionEvent} avec les différentes constantes de classe, on
     * appelle le constructeur permettant de créer le bon {@linkplain OutilForme}.
     * 
     * @param event L'{@code ActionEvent} associer au click sur le bouton.
     * 
     * @since 0.3.4.9
     * 
     * @version 0.4.3.2
     */
    @Override
    public void actionPerformed(final ActionEvent event) {
        this.panneauOutils.afficheContainer(PanneauBarreOutils.CONTENEUR_VIDE_NOM);
        this.effacerCadreSelection();

        switch (event.getActionCommand()) {
            case ActionChoisirForme.NOM_ACTION_CERCLE:
                this.panneauDessin.associerOutil(new OutilCercle());
                break;
            case ActionChoisirForme.NOM_ACTION_ELLIPSE:
                this.panneauDessin.associerOutil(new OutilEllipse());
                break;
            case ActionChoisirForme.NOM_ACTION_LIGNE:
                this.panneauDessin.associerOutil(new OutilLigne());
                break;
            case ActionChoisirForme.NOM_ACTION_ETOILE:
                this.panneauOutils.afficheContainer(PanneauBarreOutils.CONTENEUR_ETOILE_NOM);
                this.panneauDessin.associerOutil(new OutilEtoile());
                break;
            case ActionChoisirForme.NOM_ACTION_CRAYON:
                this.panneauOutils.afficheContainer(PanneauBarreOutils.CONTENEUR_CRAYON_NOM);
                this.panneauDessin.associerOutil(new OutilCrayon());
                break;
            default:
        }
    }

    /**
     * Fonction permettant de supprimer le cadre de la derniere selection si
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