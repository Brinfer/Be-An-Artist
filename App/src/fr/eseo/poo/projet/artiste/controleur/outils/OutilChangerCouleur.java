package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.vue.formes.VueCadreSelection;

/**
 * Classe {@code OutilChangerCouleur} permettant à l'aide d'un simple click de
 * changer la couleur de la {@code Forme} sur laquelle on vient de clicker. Il
 * reste possible de déplacer et redimmensionner la {@code Forme} comme pour
 * {@code OutilSelectionner}.
 * <p>
 * Celle classe est enfant de {@linkplain OutilSelectionner}.
 * 
 * @see OutilSelectionner
 * 
 * @author Brinfer
 * 
 * @since 0.4.5
 */
public class OutilChangerCouleur extends OutilSelectionner {

    /**
     * Fonction {@code mouseClicked(MouseEvent)} surchargent
     * {@linkplain OutilSelectionner#mouseClicked(MouseEvent)}.
     * <p>
     * Elle permet avec un click simple de changer la couleur de la {@code Forme} se
     * trouvant sous le curseur de la souris. Dans le cas où aucune {@code Forme} ne
     * s'y trouve, rien ne se passe.
     * 
     * @since 0.4.5
     */
    @Override
    public void mouseClicked(MouseEvent event) {
        if (event.getClickCount() == 1 && super.getVueFormeSelectionner() != null
                && !(super.getVueFormeSelectionner() instanceof VueCadreSelection)) {
            super.getVueFormeSelectionner().getForme().setCouleur(super.getPanneauDessin().getCouleurCourante());
            super.mousePressed(event);
            super.getPanneauDessin().repaint();
        }
    }
}