package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

/**
 * Classe {@code OutilCercle} permettant de créer une représentation d'une
 * {@code Cercle}.
 * 
 * @see Cercle
 * @see VueCercle
 * 
 * @author Brinfer
 * 
 * @since 0.3.4.7
 * 
 * @version 0.3.5.3
 */
public class OutilCercle extends OutilForme {

	/**
	 * {@inheritDoc}
	 * 
	 * @since 0.3.4.7
	 * 
	 * @version 0.3.5.3
	 */
	@Override
	protected VueForme creerVueForme() {
		final Cercle cercle = new Cercle(super.getDebut());
		cercle.setCouleur(super.getPanneauDessin().getCouleurCourante());
		cercle.setRempli(super.getPanneauDessin().getModeRemplissage());
		if (!super.getDebut().equals(super.getFin())) {
			cercle.setLargeur(Math.max(Math.abs(super.getFin().getAbscisse() - super.getDebut().getAbscisse()),
					Math.abs(super.getFin().getOrdonnee() - super.getDebut().getOrdonnee())));

			/*
			 * Dans le cas où la largeur ou la hauteur sont négative, alors on déplace la
			 * position du point afin de pouvoir dessiner le cercle.
			 */
			if (super.getDebut().getAbscisse() > super.getFin().getAbscisse()) {
				super.getDebut().deplacerDe(-cercle.getHauteur(), 0);
			}
			if (super.getDebut().getOrdonnee() > super.getFin().getOrdonnee()) {
				super.getDebut().deplacerDe(0, -cercle.getHauteur());
			}
		}
		return new VueCercle(cercle);
	}

	/**
	 * Surchage inutile de {@linkplain OutilForme#mouseClicked(MouseEvent)} mais
	 * nécessaire à la validation des tests.
	 * 
	 */
	@Override
	public void mouseClicked(final MouseEvent event) {
		super.mouseClicked(event);
	}
}