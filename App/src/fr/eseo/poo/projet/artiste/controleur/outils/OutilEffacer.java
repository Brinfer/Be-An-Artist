package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.vue.formes.VueCadreSelection;

/**
 * Classe {@code OutilEffacer} permettant à l'aide d'un simple click d'effacer
 * la {@code Forme} sur laquelle on vient de clicker.
 * <p>
 * Celle classe est enfant de {@linkplain OutilSelectionner}.
 * 
 * @see OutilSelectionner
 * 
 * @author Brinfer
 * 
 * @since 0.4.5
 */
public class OutilEffacer extends OutilSelectionner {

    /**
     * Fonction {@code mouseClicked(MouseEvent)} surchargent
     * {@linkplain OutilSelectionner#mouseClicked(MouseEvent)}.
     * <p>
     * Elle permet avec un click simple d'effacer la {@code Forme} se trouvant sous
     * le curseur de la souris. Dans le cas où aucune {@code Forme} ne s'y trouve,
     * rien ne se passe.
     * 
     * @since 0.4.5
     */
    @Override
    public void mouseClicked(MouseEvent event) {
        if (event.getClickCount() == 1 && super.getVueFormeSelectionner() != null
                && !(super.getVueFormeSelectionner() instanceof VueCadreSelection)) {
            super.getPanneauDessin().getVueFormes().remove(super.getVueCadreSelection());
            super.getPanneauDessin().getVueFormes().remove(super.getVueFormeSelectionner());
            super.getPanneauDessin().repaint();
        }
    }

    /**
     * Fonction {@code mouseDragged(MouseEvent)} surchargent
     * {@linkplain OutilSelectionner#mouseDragged(MouseEvent)}.
     * <p>
     * Elle permet de ne pas déplacer ou redimmensionner de {@code Forme} avec cet
     * {@code Outil}.
     * 
     * @since 0.4.5
     */
    @Override
    public void mouseDragged(MouseEvent event) {

    }
}