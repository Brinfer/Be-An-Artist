package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

/**
 * Classe {@code OutilEllipse} permettant de créer une représentation d'une
 * {@code Ellipse}.
 * 
 * @see Ellipse
 * @see VueEllipse
 * 
 * @author Brinfer
 * 
 * @since 0.3.4.7
 * 
 * @version 0.3.5.3
 */
public class OutilEllipse extends OutilForme {

	/**
	 * {@inheritDoc}
	 * 
	 * @since 0.3.4.7
	 * 
	 * @version 0.3.5.3
	 */
	@Override
	protected VueForme creerVueForme() {
		final Ellipse ellipse = new Ellipse(super.getDebut());
		ellipse.setCouleur(super.getPanneauDessin().getCouleurCourante());
		ellipse.setRempli(super.getPanneauDessin().getModeRemplissage());
		if (!super.getDebut().equals(super.getFin())) {
			double largeur = super.getFin().getAbscisse() - super.getDebut().getAbscisse();
			double hauteur = super.getFin().getOrdonnee() - super.getDebut().getOrdonnee();

			/*
			 * Dans le cas où la largeur ou la hauteur sont négative, alors on déplace la
			 * position du point afin de pouvir dessiner l'ellipse.
			 */
			if (largeur < 0) {
				largeur = Math.abs(largeur);
				super.getDebut().deplacerVers(super.getFin().getAbscisse(), super.getDebut().getOrdonnee());
				super.getFin().deplacerVers(super.getDebut().getAbscisse() + largeur, super.getFin().getOrdonnee());
			} else if (largeur == 0) {
				largeur = 1;
			}
			if (hauteur < 0) {
				hauteur = Math.abs(hauteur);
				super.getDebut().deplacerVers(super.getDebut().getAbscisse(), super.getFin().getOrdonnee());
				super.getFin().deplacerVers(super.getFin().getAbscisse(), super.getDebut().getOrdonnee() + hauteur);
			} else if (hauteur == 0) {
				hauteur = 1;
			}

			ellipse.setPosition(super.getDebut());
			ellipse.setLargeur(largeur);
			ellipse.setHauteur(hauteur);
		}
		return new VueEllipse(ellipse);
	}
}