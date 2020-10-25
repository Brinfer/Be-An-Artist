package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.JSpinner;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Classe {@code ActionChoisirLongueurBranches} donnant à l’utilisateur le moyen
 * de choisir la largeur des branches d'une étoile.
 *
 * @author Brinfer
 *
 * @since 0.4.4.2
 */
public class ActionChoisirLongueurBranches implements ChangeListener {
    /**
     * Constante de la classe {@code ActionChoisirLongueurBranches}, sert à
     * sauvegarder le nom associé au component utilisant cette action.
     * <p>
     * Ici le nom est {@value #NOM_ACTION}.
     *
     * @since 0.4.4.2
     */
    public static final String NOM_ACTION = "Longueur des branches";

    /**
     * Attribue représentant la {@code PanneauDessin} sur laquelle la classe
     * {@code ActionChoisirLongueurBranches} à une action.
     *
     * @since 0.4.4.2
     */
    private final PanneauDessin panneauDessin;

    /**
     * Constructeur d'un nouveau {@code ActionChoisirLongueurBranches}.
     *
     * @param panneauDessin le {@code PanneauDessin} sur qui l'action aura de
     *                      l'effet.
     *
     * @since 0.4.4.2
     */
    public ActionChoisirLongueurBranches(final PanneauDessin panneauDessin) {
        this.panneauDessin = panneauDessin;
    }

    /**
     * Méthode qui est appelée chaque fois qu’un événement à lieux est sur le
     * JSinner associé.
     *
     * @param event Un {@code ChangeEvent} correspondant à l'événement associé au
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
        this.panneauDessin.setLongueurDesBranches(((double) ((JSpinner) event.getSource()).getValue()));
    }
}