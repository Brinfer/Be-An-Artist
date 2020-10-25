package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Ligne;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Classe {@code VueLigne} permettant l'affichage d'une ligne, à partir de la
 * classe {@linkplain Ligne}.
 * 
 * @see Ligne
 * 
 * @author Brinfer
 * 
 * @since 0.3.3.4
 * 
 * @version 0.3.3.4
 */
public class VueLigne extends VueForme {

	/**
	 * Constructeur d'une nouvelle {@code VueLigne}. L'instance de la classe est
	 * initialisé avec la ligne donnée en paramètre.
	 * 
	 * @param ligne La {@code Ligne} que l'on souhaite afficher.
	 * 
	 * @see VueForme#VueForme(fr.eseo.poo.projet.artiste.modele.formes.Forme)
	 * 
	 * @since 0.3.3.4
	 */
	public VueLigne(final Ligne ligne) {
		super(ligne);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see <a href=
	 *      "https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html#drawLine(int,%20int,%20int,%20int)">Oracle
	 *      - Chraphics - drawLine</a>
	 * 
	 * @since 0.3.3.4
	 */
	@Override
	public void affiche(final Graphics2D g2d) {
		Color colorOld = g2d.getColor();
		g2d.setColor(super.getForme().getCouleur());
		g2d.drawLine((int) super.getForme().getPosition().getAbscisse(),
				(int) super.getForme().getPosition().getOrdonnee(),
				(int) (super.getForme().getPosition().getAbscisse() + super.getForme().getLargeur()),
				(int) (super.getForme().getPosition().getOrdonnee() + super.getForme().getHauteur()));
		g2d.setColor(colorOld);
	}
}