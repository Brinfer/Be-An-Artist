package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilSelectionner;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Classe {@code ActionSelectionner} permettant à l'utilisateur de sélectionner
 * des {@code Formes} déjà déssiné.
 * 
 * @author Brinfer
 * 
 * @since 0.3.4.9
 * 
 * @version 0.3.4.9
 */
public class ActionSelectionner extends AbstractAction {

	/**
	 * Constante de la classe permettant d'identifier {@code actionCommand} du
	 * boutton et sera utilié comme une étiquette pour le {@code JButton} associé.
	 * <p>
	 * Ici il s'agit de l'action {@value}.
	 * 
	 * @since 0.3.4.9
	 */
	public static final String NOM_ACTION = "Sélectionner";

	/**
	 * Attribue de la classe permettant de mémoriser le {@code PanneauDessin} qu’on
	 * utilise.
	 * 
	 * @since 0.3.4.9
	 */
	private final PanneauDessin panneauDessin;

	/**
	 * Constructeur d'une nouvelle {@code ActionSeletionner}.
	 * 
	 * @param panneauDessin Le {@code PanneauDessin} qu’on veut utiliser.
	 * 
	 * @since 0.3.4.9
	 */
	public ActionSelectionner(final PanneauDessin panneauDessin) {
		super(ActionSelectionner.NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	/**
	 * Fonction exécuté lors de l'appui sur le bouton associé à cette action.
	 * 
	 * @param event L'{@code ActionEvent} associé au bouton sur lequel on à cliqué.
	 * 
	 * @since 0.3.4.9
	 */
	@Override
	public void actionPerformed(final ActionEvent event) {
		this.panneauDessin.associerOutil(new OutilSelectionner());
	}
}