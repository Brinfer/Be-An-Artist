package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.AbstractAction;
import javax.swing.JCheckBox;

import java.awt.event.ActionEvent;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Classe {@code ActionChoisirRemplissage} permettant à l'utilisateur de chisir
 * de remplir ou non les formes qu'il dessinera.
 * 
 * @author Brinfer
 * 
 * @since 0.3.6.3
 * 
 * @version 0.3.6.3
 */
public class ActionChoisirRemplissage extends AbstractAction {

	/**
	 * Constante de la classe {@code ActionChoisirRemplissage}, sert à sauvegarder
	 * le nom qui est utilisé comme texte affiché sur le bouton.
	 * 
	 * @since 0.3.6.3
	 */
	public static final String NOM_ACTION = "Remplissage de la Forme";

	/**
	 * Attribue repésentant la {@code PanneauDessin} sur laquelle la classe
	 * {@code ActionChoisirRemplissage} à une action.
	 * 
	 * @since 0.3.6.3
	 */
	private final PanneauDessin panneauDessin;

	/**
	 * Constructeur d'un nouveau {@code ActionChoisirRemplissage}.
	 * 
	 * @param panneauDessin le {@code PanneauDessin} sur qui l'action aura de
	 *                      l'effet.
	 * 
	 * @since 0.3.6.3
	 */
	public ActionChoisirRemplissage(final PanneauDessin panneauDessin) {
		super(ActionChoisirRemplissage.NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	/**
	 * Méthode qui est appelée chaque fois qu’un événement à lieux est sur le bouton
	 * associé.
	 * 
	 * @param event Un {@code ActionEvent} correspondant à l'évenement associé au
	 *              bouton.
	 * 
	 * @see <a href=
	 *      "https://docs.oracle.com/javase/7/docs/api/javax/swing/JCheckBox.html">Oracle
	 *      - JCheckBox</a>
	 * 
	 * @since 0.3.6.3
	 */
	@Override
	public void actionPerformed(final ActionEvent event) {
		this.panneauDessin.setModeRemplissage(((JCheckBox) event.getSource()).isSelected());
	}

}