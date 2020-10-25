package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

import java.awt.Color;
import java.awt.event.ActionEvent;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Classe {@code ActionChoisirCouleur} donnant à l’utilisateur le moyen de
 * sélectionner la couleur avec laquelle il dessinera les formes.
 * 
 * @author Brinfer
 * 
 * @since 0.3.5.3
 * 
 * @version 0.3.5.3
 */
public class ActionChoisirCouleur extends AbstractAction {

	/**
	 * Constante de la classe {@code ActionChoisirCouleur}, sert à sauvegarder le
	 * nom qui est utilisé comme texte affiché sur le bouton.
	 * 
	 * @since 0.3.5.3
	 */
	public static final String NOM_ACTION = "Choisir une Couleur";

	/**
	 * Attribue repésentant la {@code PanneauDessin} sur laquelle la classe
	 * {@code ActionEffacer} à une action.
	 * 
	 * @since 0.3.5.3
	 */
	private final PanneauDessin panneauDessin;

	/**
	 * Constructeur d'un nouveau {@code ActionChoisirCouleur}.
	 * 
	 * @param panneauDessin le {@code PanneauDessin} sur qui l'action aura de
	 *                      l'effet.
	 * 
	 * @since 0.3.5.3
	 */
	public ActionChoisirCouleur(final PanneauDessin panneauDessin) {
		super(ActionChoisirCouleur.NOM_ACTION);
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
	 *      "https://docs.oracle.com/javase/7/docs/api/javax/swing/JColorChooser.html">Oracle
	 *      - JColorChooser</a>
	 * 
	 * @since 0.3.5.3
	 */
	@Override
	public void actionPerformed(final ActionEvent event) {
		Color newColor = JColorChooser.showDialog(this.panneauDessin, ActionChoisirCouleur.NOM_ACTION,
				this.panneauDessin.getCouleurCourante());
		if (newColor != null) {
			this.panneauDessin.setCouleurCourante(newColor);
		}
	}

}