package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Cercle;

/**
 * Classe {@code VueCercle} permettant l'affichage d'un cercle, à partir de la
 * classe {@linkplain Cercle}.
 * 
 * @see Cercle
 * 
 * @author Brinfer
 * 
 * @since 0.3.3.7
 */
public class VueCercle extends VueEllipse {

	/**
	 * Constructeur d'une nouvelle {@code VueEllipse}. L'instance de la classe est
	 * initialisé avec le cercle donnée en paramètre.
	 * 
	 * @param cercle Le {@code Cercle} que l'on souhaite afficher.
	 * 
	 * @see VueEllipse#VueEllipse(fr.eseo.poo.projet.artiste.modele.formes.Ellipse)
	 * 
	 * @since 0.3.3.7
	 */
	public VueCercle(final Cercle cercle) {
		super(cercle);
	}
}