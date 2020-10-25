package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JSpinner;

import java.awt.event.ActionEvent;
import java.awt.Component;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEtoile;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Classe permettant de créer un nouvel {@code OutilLigne}, {@code OutilEllipse}
 * ou {@code OutilCercle}.
 * 
 * @see OutilCercle
 * @see OutilEllipse
 * @see OutilLigne
 * 
 * @author Brinfer
 * 
 * @since 0.3.4.9
 * 
 * @version 0.3.7.3
 */
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
	 * 
	 * @since 0.3.7.3
	 */
	public static final String NOM_ACTION_ETOILE = "Etoile";

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
	 * @param nom           Le nom utilisé pour définir l’action (une des constantes
	 *                      de la classe).
	 * 
	 * @since 0.3.4.9
	 */
	public ActionChoisirForme(final PanneauDessin panneauDessin, final PanneauBarreOutils panneauOutils,
			final String nom) {
		super(nom);
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
	 * @throws IllegalArgumentException si l'{@code ActionEvent} n'est associé ne
	 *                                  correspond à aucun {@linkplain OutilForme}.
	 * 
	 * @since 0.3.4.9
	 * 
	 * @version 0.3.7.3
	 */
	@Override
	public void actionPerformed(final ActionEvent event) {
		this.masqueCompEtoile();

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
				this.afficheCompEtoile();
				this.panneauDessin.associerOutil(new OutilEtoile(this.panneauOutils));
				break;
			default:
				throw new IllegalArgumentException("Bouton inconnu");
		}
	}

	/**
	 * Fonction permettant de masquer les {@code JSpinner} et les {@code JLabel} lié
	 * à la création d'une {@code Etoile}.
	 */
	private void masqueCompEtoile() {
		if (this.panneauDessin.getOutilCourant() instanceof OutilEtoile) {
			for (Component comp : this.panneauOutils.getComponents()) {
				if (comp instanceof JLabel || comp instanceof JSpinner) {
					comp.setVisible(false);
				}
			}
		}
	}

	/**
	 * Fonction permettant d'afficher les {@code JSpinner} et les {@code JLabel} lié
	 * à la création d'une {@code Etoile}.
	 */
	private void afficheCompEtoile() {
		for (Component comp : this.panneauOutils.getComponents()) {
			if (comp instanceof JLabel || comp instanceof JSpinner) {
				comp.setVisible(true);
			}
		}
	}
}