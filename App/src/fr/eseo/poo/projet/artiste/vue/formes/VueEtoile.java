package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.BasicStroke;

/**
 * Classe {@code VueEtoile} permettant l'affichage d'une etoile, à partir de la
 * classe {@linkplain Etoile}.
 * 
 * @see Etoile
 * 
 * @author Brinfer
 * 
 * @since 0.3.7.2
 * 
 * @version 0.4.4.2
 */
public class VueEtoile extends VueForme {

    /**
     * Constructeur d'une nouvelle {@code VueEtoile}. L'instance de la classe est
     * initialisé avec l'Etoile donnée en paramètre.
     * 
     * @param etoile L'{@code Etoile} que l'on souhaite afficher.
     * 
     * @see VueForme#VueForme(fr.eseo.poo.projet.artiste.modele.formes.Forme)
     * 
     * @since 0.3.3.7
     */
    public VueEtoile(final Etoile etoile) {
        super(etoile);
    }

    /**
     * {@inheritDoc}
     * 
     * @see <a href=
     *      "https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics.html#drawPolygon-int:A-int:A-int-">Oracle
     *      - drawPolygon</a>
     * 
     * @since 0.3.3.7
     * 
     * @version 0.3.6.2
     */
    @Override
    public void affiche(final Graphics2D g2d) {
        final Etoile forme = (Etoile) super.getForme();

        Color colorOld = g2d.getColor();
        final Stroke strokeOld = g2d.getStroke();

        g2d.setColor(forme.getCouleur());
        g2d.setStroke(new BasicStroke(forme.getEpaisseurTrait()));

        final int[] xArray = new int[2 * forme.getNombreBranches()];
        final int[] yArray = new int[2 * forme.getNombreBranches()];

        for (int i = 0; i < 2 * forme.getNombreBranches(); i += 2) {
            xArray[i] = (int) Math.round(forme.getCoordonneesPolygone().get(i / 2).getAbscisse());
            yArray[i] = (int) Math.round(forme.getCoordonneesPolygone().get(i / 2).getOrdonnee());
            xArray[i + 1] = (int) Math.round(forme.getCoordonnees().get(i / 2).getAbscisse());
            yArray[i + 1] = (int) Math.round(forme.getCoordonnees().get(i / 2).getOrdonnee());
        }

        g2d.drawPolygon(xArray, yArray, forme.getNombreBranches() * 2);

        if (forme.estRempli()) {
            g2d.fillPolygon(xArray, yArray, forme.getNombreBranches() * 2);
        }

        g2d.setColor(colorOld);
        g2d.setStroke(strokeOld);
    }
}