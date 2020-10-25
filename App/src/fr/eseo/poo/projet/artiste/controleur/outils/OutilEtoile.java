package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueEtoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

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
 * @version 0.3.7.3
 */
public class OutilEtoile extends OutilForme {

	private Etoile etoile;

	private final PanneauBarreOutils panneauOutil;

	public OutilEtoile(final PanneauBarreOutils panneauOutil) {
		this.panneauOutil = panneauOutil;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @since 0.3.7.3
	 */
	@Override
	protected VueForme creerVueForme() {

		etoile = new Etoile(super.getDebut());
		etoile.setCouleur(super.getPanneauDessin().getCouleurCourante());
		etoile.setRempli(super.getPanneauDessin().getModeRemplissage());

		if (!super.getDebut().equals(super.getFin())) {
			etoile.setLargeur(super.getDebut().distanceVers(super.getFin()) * 2);

			etoile.setPosition(new Coordonnees(super.getFin().getAbscisse() - etoile.getLargeur() / 2,
					super.getFin().getOrdonnee() - etoile.getHauteur() / 2));

			etoile.setAnglePremiereBranche(-super.getFin().angleVers(super.getDebut()));
			etoile.setLongueurBranche(this.panneauOutil.getLongueurBranche());
			etoile.setNombreBranches(this.panneauOutil.getNbBranches());
		}
		return new VueEtoile(etoile);
	}

}