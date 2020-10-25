package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.Stroke;
import java.awt.BasicStroke;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.TracerCrayon;

/**
 * Classe {@code VueEtoile} permettant l'affichage d'un {@code TracerCrayon}, à
 * partir de la classe {@linkplain TracerCrayon}.
 * 
 * @see TRacerCrayon
 * 
 * @author Brinfer
 * 
 * @since 0.4.3.2
 * 
 * @version 0.4.4.2
 */
public class VueTracerCrayon extends VueForme {

    /**
     * Constructeur d'une nouvelle {@code VueTracerCrayon}. L'instance de la classe
     * est initialisé avec le TracerCrayon donnée en paramètre.
     * 
     * @param etoile L'{@code TracerCrayon} que l'on souhaite afficher.
     * 
     * @see VueForme#VueForme(fr.eseo.poo.projet.artiste.modele.formes.Forme)
     * 
     * @since 0.4.3.2
     */
    public VueTracerCrayon(TracerCrayon trace) {
        super(trace);
    }

    /**
	 * {@inheritDoc}
	 * 
	 * @see <a href=
	 *      "https://docs.oracle.com/javase/8/docs/api/java/awt/geom/GeneralPath.html">Oracle
	 *      - GeneralPath</a>
	 * 
	 * @since 0.4.3.2
	 * 
	 * @version 0.4.4.2
	 */
    @Override
    public void affiche(Graphics2D g2d) {
        Color colorOld = g2d.getColor();
        final Stroke strokeOld = g2d.getStroke();
        TracerCrayon trace = (TracerCrayon) super.getForme();
        g2d.setColor(trace.getCouleur());

        g2d.setStroke(new BasicStroke(trace.getEpaisseurTrait()));

        GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD, trace.getListeCoordonnees().size());
        path.moveTo(trace.getListeCoordonnees().get(0).getAbscisse(), trace.getListeCoordonnees().get(0).getOrdonnee());
        for (Coordonnees point : trace.getListeCoordonnees().subList(1, trace.getListeCoordonnees().size())) {
            path.lineTo(point.getAbscisse(), point.getOrdonnee());
        }

        if (trace.estRempli()) {
            g2d.fill(path);
        }

        g2d.draw(path);

        g2d.setColor(colorOld);
        g2d.setStroke(strokeOld);
    }
}