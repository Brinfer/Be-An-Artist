package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.JSpinner;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Classe {@code ActionChoisirEpaisseurTrait} donnant à l’utilisateur le moyen
 * de choisir l'épaisseur du trait de ses futurs dessins.
 * 
 * @author Brinfer
 * 
 * @since 0.4.4.2
 */
public class ActionChoisirEpaisseurTrait implements ChangeListener {
    /**
     * Constante de la classe {@code ActionChoisirEpaisseurTrait}, sert à
     * sauvegarder le nom associé au component utilisant cette action.
     * <p>
     * Ici le nom est {@value #NOM_ACTION}.
     * 
     * @since 0.4.4.2
     */
    public static final String NOM_ACTION = "Epaisseur du trait";

    /**
     * Attribue repésentant la {@code PanneauDessin} sur laquelle la classe
     * {@code ActionChoisirEpaisseurTrait} à une action.
     * 
     * @since 0.4.4.2
     */
    private final PanneauDessin panneauDessin;

    /**
     * Constructeur d'un nouveau {@code ActionChoisirEpaisseurTrait}.
     * 
     * @param panneauDessin le {@code PanneauDessin} sur qui l'action aura de
     *                      l'effet.
     * 
     * @since 0.4.4.2
     */
    public ActionChoisirEpaisseurTrait(final PanneauDessin panneauDessin) {
        this.panneauDessin = panneauDessin;
    }

    /**
     * Méthode qui est appelée chaque fois qu’un événement à lieux est sur le
     * JSinner associé.
     * 
     * @param event Un {@code ChangeEvent} correspondant à l'évenement associé au
     *              JSpinner.
     * 
     * @see <a href=
     *      "https://docs.oracle.com/javase/8/docs/api/javax/swing/event/ChangeEvent.html">Oracle
     *      - ChangeEvent</a>
     * 
     * @since 0.4.4.2
     */
    @Override
    public void stateChanged(final ChangeEvent event) {
        // Le JSpinner renvoie un double mais on n'a besoin d'un float, on passe par la
        // classe Number pour convertir le Double en float.
        this.panneauDessin.setEpaisseurCourante(((Double) ((JSpinner) event.getSource()).getValue()).floatValue());
    }
}