package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueEtoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

/**
 * Classe {@code OutilEtoile} permettant de créer une représentation d'une
 * {@code Etoile}.
 * 
 * @see Etoile
 * @see VueEtoile
 * 
 * @author Brinfer
 * 
 * @since 0.3.7.3
 * 
 * @version 0.4.4.2
 */
public class OutilEtoile extends OutilForme {

	/**
	 * {@inheritDoc}
	 * 
	 * @since 0.3.7.3
	 * 
	 * @version 0.4.4.2
	 */
	@Override
	protected VueForme creerVueForme() {

		Etoile etoile = new Etoile(super.getDebut());
		etoile.setCouleur(super.getPanneauDessin().getCouleurCourante());
		etoile.setRempli(super.getPanneauDessin().getModeRemplissage());
		etoile.setEpaisseurTrait(super.getPanneauDessin().getEpaisseurCourante());

		if (!super.getDebut().equals(super.getFin())) {
			etoile.setLargeur(super.getDebut().distanceVers(super.getFin()) * 2);

			etoile.setPosition(new Coordonnees(super.getFin().getAbscisse() - etoile.getLargeur() / 2,
					super.getFin().getOrdonnee() - etoile.getHauteur() / 2));

			etoile.setAnglePremiereBranche(-super.getFin().angleVers(super.getDebut()));
			etoile.setLongueurBranche(super.getPanneauDessin().getLongueurDesBranches());
			etoile.setNombreBranches(super.getPanneauDessin().getNombreDeSommets());
		}
		return new VueEtoile(etoile);
	}

}