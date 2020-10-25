package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

/**
 * Classe {@code VueEtoile} permettant l'affichage d'une etoile, à partir de la
 * classe {@linkplain Etoile}.
 * 
 * @see Etoile
 * 
 * @author Brinfer
 * 
 * @since 0.3.7.2
 * 
 * @version 0.3.7.2
 */
public class VueEtoile extends VueForme {

	/**
	 * Constructeur d'une nouvelle {@code VueEtoile}. L'instance de la classe est
	 * initialisé avec l'Etoile donnée en paramètre.
	 * 
	 * @param etoile L'{@code Etoile} que l'on souhaite afficher.
	 * 
	 * @see VueForme#VueForme(fr.eseo.poo.projet.artiste.modele.formes.Forme)
	 * 
	 * @since 0.3.3.7
	 */
	public VueEtoile(final Etoile etoile) {
		super(etoile);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see <a href=
	 *      "https://docs.oracle.com/javase/8/docs/api/java/awt/geom/GeneralPath.html">Oracle
	 *      - GeneralPath</a>
	 * 
	 * @since 0.3.3.7
	 * 
	 * @version 0.3.6.2
	 */
	@Override
	public void affiche(final Graphics2D g2d) {
		Color colorOld = g2d.getColor();
		g2d.setColor(super.getForme().getCouleur());
		Etoile forme = (Etoile) super.getForme();

		double[] xArray = new double[2 * forme.getNombreBranches()];
		double[] yArray = new double[2 * forme.getNombreBranches()];

		for (int i = 0; i < 2 * forme.getNombreBranches(); i += 2) {
			xArray[i] = Math.round(forme.getCoordonneesPolygone().get(i / 2).getAbscisse());
			yArray[i] = Math.round(forme.getCoordonneesPolygone().get(i / 2).getOrdonnee());
			xArray[i + 1] = Math.round(forme.getCoordonnees().get(i / 2).getAbscisse());
			yArray[i + 1] = Math.round(forme.getCoordonnees().get(i / 2).getOrdonnee());
		}

		GeneralPath etoile = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xArray.length);
		etoile.moveTo(xArray[0], yArray[0]);
		for (int i = 1; i < xArray.length; i++) {
			etoile.lineTo(xArray[i], yArray[i]);
		}
		etoile.closePath();

		if (forme.estRempli()) {
			g2d.fill(etoile);
		}
		g2d.draw(etoile);

		g2d.setColor(colorOld);
	}
}