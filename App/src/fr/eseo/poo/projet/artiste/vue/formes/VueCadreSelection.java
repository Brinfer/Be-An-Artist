package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Color;

import fr.eseo.poo.projet.artiste.modele.formes.CadreSelection;

/**
 * Classe {@code VueCadreSelection} permettant l'affichage d'un cadre, à partir
 * de la classe {@linkplain CadreSelection}.
 * 
 * @see CadreSelection
 * 
 * @author Brinfer
 * 
 * @since 0.4.2.1
 * 
 * @version 0.4.2.1
 */
public class VueCadreSelection extends VueForme {

    /**
     * Constructeur d'une nouvelle {@code VueCadreSelection}. L'instance de la
     * classe est initialisé avec le cadre donnée en paramètre.
     * 
     * @param cadre Le {@code CadreSelection} que l'on souhaite afficher.
     * 
     * @since 0.4.1.2
     */
    public VueCadreSelection(CadreSelection cadre) {
        super(cadre);
    }

    /**
     * {@inheritDoc}
     * 
     * @see <a href=
     *      "https://docs.oracle.com/javase/8/docs/api/java/awt/BasicStroke.html#BasicStroke-float-int-int-">Oracle
     *      - BasicStroke</a>
     * @see <a href=
     *      "https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics.html#drawRect-int-int-int-int-">Oracle
     *      - drawRect</a>
     * 
     * @since 0.4.2.1
     */
    @Override
    public void affiche(Graphics2D g2d) {
        final Color colorOld = g2d.getColor();
        g2d.setColor(Color.BLACK);

        final Stroke strokeOld = g2d.getStroke();

        final float dash[] = { 10.0f };
        g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
        g2d.drawRect((int) super.getForme().getCadreMinX(), (int) super.getForme().getCadreMinY(),
                (int) Math.abs(super.getForme().getLargeur()), (int) Math.abs(super.getForme().getHauteur()));

        g2d.setColor(colorOld);
        g2d.setStroke(strokeOld);
    }

}