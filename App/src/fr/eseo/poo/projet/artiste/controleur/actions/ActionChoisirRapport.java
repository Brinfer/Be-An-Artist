package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.JSpinner;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Classe {@code ActionChoisirRapport} donnant à l’utilisateur le moyen
 * de choisir la lagueur des branches d'une étoile.
 * 
 * @author Brinfer
 * 
 * @since 0.4.6.2
 */
public class ActionChoisirRapport implements ChangeListener {
    /**
     * Constante de la classe {@code ActionChoisirRapport}, sert à
     * sauvegarder le nom associé au component utilisant cette action.
     * <p>
     * Ici le nom est {@value #NOM_ACTION}.
     * 
     * @since 0.4.6.2
     */
    public static final String NOM_ACTION = "Choisir rapport";

    /**
     * Attribue repésentant la {@code PanneauDessin} sur laquelle la classe
     * {@code ActionChoisirRapport} à une action.
     * 
     * @since 0.4.6.2
     */
    private final PanneauDessin panneauDessin;

    /**
     * Constructeur d'un nouveau {@code ActionChoisirRapport}.
     * 
     * @param panneauDessin le {@code PanneauDessin} sur qui l'action aura de
     *                      l'effet.
     * 
     * @since 0.4.6.2
     */
    public ActionChoisirRapport(final PanneauDessin panneauDessin) {
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
     * @since 0.4.6.2
     */
    @Override
    public void stateChanged(final ChangeEvent event) {
        this.panneauDessin.setRapportQ(((String) ((JSpinner) event.getSource()).getValue()));
    }
}