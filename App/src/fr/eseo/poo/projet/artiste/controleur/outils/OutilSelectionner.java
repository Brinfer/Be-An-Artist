package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.CadreSelection;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueCadreSelection;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

/**
 * Classe permettant de sélectionner une forme déjà dessinée.
 * <p>
 * La sélection d'une forme se fait au moment de l'appui d'un bouton de la
 * souris. Dans le cas où une forme se trouvait sous le curseur de la souris,
 * alors celle-ci est sélectionné et est encadré avec un cadre. Dans le cas où
 * plusieurs forme se trouve sous le curseur de la souris, alors la forme la
 * plus résente est concidé comme celle sélectionnée.
 * <p>
 * Un double click de n'importe qu'elle bouton sur une forme déjà dessiner
 * entraine sa sélection et l'apparition d'une fenêtre donnant une description
 * de la forme.
 * <p>
 * Dans le cas où déplace la souris avec le bouton gauche, la forme sélectionner
 * va suivre la souris.
 * <p>
 * Dans le cas où l'on déplace la souris avec le bouton droit enfoncé et après
 * avoir sélectionner un des segments ou coin du cadre de la forme sélectionner,
 * il est possible de redimensionner la forme lié au cadre.
 * 
 * @see JOptionPane#toString()
 * 
 * @author Brinfer
 * 
 * @since 0.3.4.10
 * 
 * @version 0.4.2.2
 */
public class OutilSelectionner extends OutilForme {

    /**
     * Attribue permettant de sauvegarder {@code VueCadreSelection} actuel.
     * 
     * @since 0.4.1.1
     */
    private VueCadreSelection vueCadreSelection = null;

    /**
     * Attribue permettant de sauvegarder le cadre encadrant la forme sélectionner.
     * 
     * @since 0.4.1.2
     */
    private CadreSelection cadreSelection = null;

    /**
     * Attribue permettant de sauvegarder la vue de la forme sélectionner.
     * 
     * @since 0.4.1.2
     */
    private VueForme vueFormeSelectionner = null;

    /**
     * {@inheritDoc}
     * <p>
     * Elle permet d'obtenir les informations lié à la {@code Forme} sur laquelle
     * l'on vient de double cliquer.
     * <p>
     * Si on double clique à un endroit où se trouve plusieurs {@code Forme}, alors
     * on affiche les informations de la forme la plus récente.
     * 
     * @see JOptionPane
     * 
     * @since 0.3.4.10
     * 
     * @version 0.4.1.1
     */
    @Override
    public void mouseClicked(final MouseEvent event) {
        if (event.getClickCount() == 2 && this.vueFormeSelectionner != null
                && !(this.vueFormeSelectionner instanceof VueCadreSelection)) {
            JOptionPane.showMessageDialog(super.getPanneauDessin(), this.vueFormeSelectionner.getForme().toString(),
                    ActionSelectionner.NOM_SELECTIONNER_ACTION, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * {@inheritDoc}
     * <p>
     * L'appuie sur un des boutons de la souris entraine la recherche d'une forme
     * sous le curseur de la souris.
     * 
     * @param event Le {@code MouseEvent} associé à l'appui d'un bouton.
     * 
     * @see #rechercheFormeSelectionner(Coordonnees)
     * 
     * @since 0.4.1.1
     * 
     * @version 0.4.1.2
     */
    @Override
    public void mousePressed(final MouseEvent event) {
        this.setVueFormeSelectionner(this.rechercheFormeSelectionner(new Coordonnees(event.getX(), event.getY())));

        if (this.getVueFormeSelectionner() != null && !(this.getVueFormeSelectionner() instanceof VueCadreSelection)) {
            super.getPanneauDessin().getVueFormes().remove(this.getVueCadreSelection());
            super.getPanneauDessin().ajouterVueForme(this.creerVueForme());
            super.getPanneauDessin().repaint();
        } else if (this.getVueFormeSelectionner() == null){
            super.getPanneauDessin().getVueFormes().remove(this.getVueCadreSelection());
            super.getPanneauDessin().repaint();
        }
        super.mousePressed(event);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dans le cas où déplace la souris avec le bouton gauche, la forme sélectionner
     * va suivre la souris.
     * <p>
     * Dans le cas où l'on déplace la souris avec le bouton droit enfoncé et après
     * avoir sélectionner un des segments ou coin du cadre de la forme sélectionner,
     * il est possible de redimensionner la forme lié au cadre.
     * 
     * @param event Le {@code MouseEvent} associé au déplacement de la souris tandis
     *              qu'un bouton est maintenue appuyé.
     * 
     * @see <a href=
     *      "https://java.developpez.com/faq/gui/?page=La-souris-et-le-clavier#Quel-bouton-de-la-souris-a-ete-utilise">Developpez.com
     *      - FAQ Java GUI</a>
     * @see CadreSelection
     * 
     * @since 0.4.1.1
     * 
     * @version 0.4.2.2
     */
    @Override
    public void mouseDragged(final MouseEvent event) {
        if (this.getVueFormeSelectionner() != null) {
            final double deltaX = event.getX() - super.getDebut().getAbscisse();
            final double deltaY = event.getY() - super.getDebut().getOrdonnee();

            if (SwingUtilities.isLeftMouseButton(event)) {
                /** Bouton GAUCHE */

                this.getCadreSelection().deplacerDe(deltaX, deltaY);
                // Le deplacement du cadre entraine le deplacement de la forme selectionner
                // Deplus, si la forme sélectionner est le cadre (clic sur le cadre) la forme se
                // deplacera aussi

            } else if (SwingUtilities.isRightMouseButton(event)) {
                /* Bouton DROIT */

                if (this.getVueFormeSelectionner() instanceof VueCadreSelection) {
                    this.getCadreSelection().deplacementSegment(deltaX, deltaY);
                    // Le deplacement d'un segment du cadre entraine une modification de ses
                    // dimensions ainsi que de celle de la forme lié au cadre
                }
            }

            super.setDebut(new Coordonnees(event.getX(), event.getY()));
            super.getPanneauDessin().repaint();
        }
    }

    /**
     * {@inheritDoc}
     * <p>
     * Ici elle ne fait rien.
     * 
     * @param event Le {@code MouseEvent} associé au relachement du bouton.
     * 
     * @since 0.4.1.2
     * 
     * @version 0.4.1.2
     */
    public void mouseReleased(final MouseEvent event) {
 
    }

    /**
     * Fonction déterminant si une {@code Forme} se trouve à l'endroit où un click à été
     * effectuer.
     * <p>
     * Dans le où une {@code Forme} se trouve à cet endroit, alors sa {@code VueForme} est retournée.
     * <p>
     * Dans le cas où aucune {@code Forme} ne s'y trouve, la valeur {@code null} est
     * retourné.
     * 
     * @param coordonnees Les {@linkplain Coordonnees} du click.
     * 
     * @see #mousePressed(MouseEvent)
     * 
     * @since 0.4.1.1
     * 
     * @version 0.4.1.1
     */
    private VueForme rechercheFormeSelectionner(final Coordonnees coordonnees) {
        for (int i = super.getPanneauDessin().getVueFormes().size() - 1; i > -1; i--) {
            if (super.getPanneauDessin().getVueFormes().get(i).getForme().contient(coordonnees)) {
                return super.getPanneauDessin().getVueFormes().get(i);
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @return Une {@code VueCadre} encadrant la forme sélectionner.
     * 
     * @since 0.4.1.2
     * 
     * @version 0.4.1.2
     */
    @Override
    protected VueForme creerVueForme() {
        this.cadreSelection = new CadreSelection(this.getVueFormeSelectionner().getForme());
        this.vueCadreSelection = new VueCadreSelection(this.cadreSelection);
        return this.vueCadreSelection;
    }

    /**
     * Accesseur du cadre de la forme sélectionner.
     * 
     * @return Le {@code CadreSelection} de la {@code Forme} sélectionner.
     * 
     * @since 4.2.1
     */
    public CadreSelection getCadreSelection() {
        return this.cadreSelection;
    }

    /**
     * Accesseur de la {@code VueForme} qui est sélectionner.
     * 
     * @return La {@code VueForme} sélectionner.
     * 
     * @since 0.4.1.1
     */
    public VueForme getVueCadreSelection() {
        return this.vueCadreSelection;
    }

    /**
     * Acceseur de la {@code Forme} sélectionner.
     * 
     * @return La {@code Forme} sélectionner.
     * 
     * @see #setVueFormeSelectionner(Forme)
     * 
     * @since 0.4.1.1
     */
    public VueForme getVueFormeSelectionner() {
        return this.vueFormeSelectionner;
    }

    /**
     * Mutateur de la {@code Forme} sémectionner.
     * 
     * @param formeSelectionner La {@code VueForme} sélectionner.
     * 
     * @see #getVueFormeSelectionner()
     * 
     * @since 0.4.1.1
     */
    public void setVueFormeSelectionner(VueForme vueFormeSelectionner) {
        this.vueFormeSelectionner = vueFormeSelectionner;
    }
}