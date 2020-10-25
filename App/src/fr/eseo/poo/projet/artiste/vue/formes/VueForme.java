package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import java.awt.Graphics2D;

/**
 * Classe abstriate {@code VueForme}, cette classe est la base de l'affichage de
 * toute les formes.
 * 
 * @author Brinfer
 * 
 * @since 0.3.3.3
 */
public abstract class VueForme {

	/**
	 * Constante de la classe {@code VueForme}, représentant la forme affiché.
	 * 
	 * @since 0.3.3.3
	 */
	protected final Forme forme;

	/**
	 * Constructeur d'une nouvelle {@code VueForme}. L'instance de la classe est
	 * initialisé avec la forme donnée en paramètre.
	 * 
	 * @param forme La {@code Forme} que l'on souhaite afficher.
	 * 
	 * @since 0.3.3.3
	 */
	public VueForme(final Forme forme) {
		this.forme = forme;
	}

	/**
	 * Accesseur de la {@code forme}.
	 * 
	 * @return La {@code Forme} qui est lié à la {@code VueForme}.
	 * 
	 * @since 0.3.3.3
	 */
	public Forme getForme() {
		return this.forme;
	}

	/**
	 * Fonction permettant d'afficher la {@code Forme} que l'on souhaite afficher.
	 * 
	 * @param g2d Le contexte graphique dans lequel on souhaite que la vue
	 *            s’affiche.
	 * 
	 * @see <a href=
	 *      "https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html">Oracle
	 *      - Chraphics2D</a>
	 * @see <a href=
	 *      "https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics.html">Oracle
	 *      - Chraphics</a>
	 * 
	 * @since 0.3.3.3
	 */
	public abstract void affiche(Graphics2D g2d);
}