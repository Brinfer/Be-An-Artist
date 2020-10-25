package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Epicycloide;
import fr.eseo.poo.projet.artiste.vue.formes.VueEpicycloide;
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
 * @since 0.4.6.2
 * 
 * @version 0.4.6.2
 */
public class OutilEpicycloide extends OutilForme {

    /**
     * {@inheritDoc}
     * <p>
     * Le centre du cercle de base de l'épicycloïde est le point de relachement, le
     * cercle à pour rayon la distance entre le point de relachement et d'appui.
     * <p>
     * Dans le cas d'un double click, une epicycloïde par défaut est dessiner.
     * 
     * @since 0.4.6.2
     */
    @Override
    protected VueForme creerVueForme() {
        final Epicycloide epicycloide = new Epicycloide(super.getDebut());
        epicycloide.setCouleur(super.getPanneauDessin().getCouleurCourante());
        epicycloide.setRempli(super.getPanneauDessin().getModeRemplissage());
        epicycloide.setEpaisseurTrait(super.getPanneauDessin().getEpaisseurCourante());

        if (!super.getDebut().equals(super.getFin())) {
            epicycloide.setRapportQ(super.getPanneauDessin().getRapportQ());
            epicycloide.setLargeur(super.getDebut().distanceVers(super.getFin()));

            epicycloide.setPosition(new Coordonnees(super.getFin().getAbscisse() - epicycloide.getLargeur() / 2,
                    super.getFin().getOrdonnee() - epicycloide.getHauteur() / 2));
        }
        epicycloide.trace(super.getFin());
        return new VueEpicycloide(epicycloide);
    }

}