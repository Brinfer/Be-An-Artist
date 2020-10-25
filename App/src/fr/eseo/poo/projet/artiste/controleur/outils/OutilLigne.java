package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.formes.VueLigne;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;

/**
 * Classe {@code OutilLigne} permettant de créer une représentation d'une
 * {@code Ligne}.
 * 
 * @see Ligne
 * @see VueLigne
 * 
 * @author Brinfer
 * 
 * @since 0.3.4.3
 * 
 * @version 0.3.5.3
 */
public class OutilLigne extends OutilForme {

	/**
	 * {@inheritDoc}
	 * 
	 * @since 0.3.4.3
	 * 
	 * @version 0.3.5.3
	 */
	@Override
	protected VueForme creerVueForme() {
		final Ligne ligne = new Ligne(super.getDebut());
		ligne.setCouleur(super.getPanneauDessin().getCouleurCourante());
		if (!super.getDebut().equals(super.getFin())) {
			ligne.setC2(super.getFin());
		}
		return new VueLigne(ligne);
	}
}