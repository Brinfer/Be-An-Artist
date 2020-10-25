package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.BasicStroke;

/**
 * Classe {@code VueEllipse} permettant l'affichage d'une ellipse, à partir de
 * la classe {@linkplain Ellipse}.
 * 
 * @see Ellipse
 * 
 * @author Brinfer
 * 
 * @since 0.3.3.7
 * 
 * @version  0.4.4.2
 */
public class VueEllipse extends VueForme {

	/**
	 * Constructeur d'une nouvelle {@code VueEllipse}. L'instance de la classe est
	 * initialisé avec l'ellipse donnée en paramètre.
	 * 
	 * @param ellipse L'{@code Ellipse} que l'on souhaite afficher.
	 * 
	 * @see VueForme#VueForme(fr.eseo.poo.projet.artiste.modele.formes.Forme)
	 * 
	 * @since 0.3.3.7
	 */
	public VueEllipse(final Ellipse ellipse) {
		super(ellipse);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see <a href=
	 *      "https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics.html#drawOval(int,%20int,%20int,%20int)">Oracle
	 *      - Chraphics - drawOval</a>
	 * 
	 * @since 0.3.3.7
	 * 
	 * @version  0.4.4.2
	 */
	@Override
	public void affiche(final Graphics2D g2d) {
		final Ellipse forme = (Ellipse) super.getForme();
		Color colorOld = g2d.getColor();
		final Stroke strokeOld = g2d.getStroke();

		g2d.setColor(forme.getCouleur());
		g2d.setStroke(new BasicStroke(forme.getEpaisseurTrait()));
		
		if (forme.estRempli()) {
			g2d.fillOval((int) forme.getCadreMinX(), (int) forme.getCadreMinY(), (int) forme.getLargeur(),
					(int) forme.getHauteur());
		}
		g2d.drawOval((int) forme.getCadreMinX(), (int) forme.getCadreMinY(), (int) forme.getLargeur(),
				(int) forme.getHauteur());

		g2d.setColor(colorOld);
		g2d.setStroke(strokeOld);
	}

}