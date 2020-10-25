package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Classe {@code ActionEffacer} donnant à l’utilisateur le moyen de tout
 * effacer.
 *
 * @author Brinfer
 *
 * @since 0.3.4.5
 *
 * @version 0.3.4.5
 */
@SuppressWarnings("serial")
public class ActionEffacer extends AbstractAction {

	/**
	 * Constante de la classe {@code ActionEffacer}, sert à sauvegarder le nom qui
	 * est utilisé comme texte affiché sur le bouton.
	 *
	 * @since 0.3.4.5
	 */
	public static final String NOM_ACTION = "Effacer Tout";

	/**
	 * Attribue représentant la {@code PanneauDessin} sur laquelle la classe
	 * {@code ActionEffacer} à une action.
	 *
	 * @since 0.3.4.5
	 */
	private final PanneauDessin panneauDessin;

	/**
	 * Constructeur d'un nouveau {@code ActionEffacer}.
	 *
	 * @param panneauDessin le {@code PanneauDessin} sur qui l'action aura de
	 *                      l'effet.
	 *
	 * @since 0.3.4.5
	 */
	public ActionEffacer(final PanneauDessin panneauDessin) {
		super(ActionEffacer.NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	/**
	 * Méthode qui est appelée chaque fois qu’un événement à lieux est sur le bouton
	 * associé.
	 *
	 * @param event Un {@code ActionEvent} correspondant à l'événement associé au
	 *              bouton.
	 *
	 * @see <a href=
	 *      "https://docs.oracle.com/javase/8/docs/api/javax/swing/JOptionPane.html#showConfirmDialog-java.awt.Component-java.lang.Object-">Oracle
	 *      - JOptionPanel - showConfirmDialog </a>
	 *
	 * @since 0.3.4.5
	 */
	@Override
	public void actionPerformed(final ActionEvent event) {
		final int choix = JOptionPane.showConfirmDialog(this.panneauDessin, "Voulez-vous supprimer le dessin?",
				ActionEffacer.NOM_ACTION, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (choix == JOptionPane.OK_OPTION) {
			this.panneauDessin.getVueFormes().clear();
			this.panneauDessin.repaint();
		}
	}
}