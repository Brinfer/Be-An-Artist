package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Classe {@code VueEllipseTest} permettant de tester le bon affichage de la
 * représentation des ellipses.
 * <p>
 * Plusieurs ellipses sont dessinées, elles sont placé à différents endroit et
 * on des dimensions variantes. Le dessin d'ellipse hors du cadre ne doit pas
 * entrainer d'erreur.
 * 
 * @see VueEllipse
 * @see PanneauDessin
 * 
 * @author Brinfer
 * 
 * @since 0.3.3.8
 * 
 * @version 0.3.6.2
 */
public class VueEllipseTest {

    /**
     * Attribut représentant la frame ou sera dessiner placé la zone de dessin.
     */
    private final JFrame frame;

    /**
     * Attribut représentant la zone de dessin.
     */
    private final PanneauDessin panneau;

    public VueEllipseTest() {
        this.frame = new JFrame();
        this.panneau = new PanneauDessin(600, 600, PanneauDessin.COULEUR_FOND_PAR_DEFAUT);

        this.frame.getContentPane().add(panneau);
        this.frame.setTitle("VueEllipseTest");
        this.frame.setSize(panneau.getPreferredSize());
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.testDessinEllipse();
    }

    private void testDessinEllipse() {
        // Forme par a la couleur est au remplissage par défaut
        final VueEllipse ellipse1 = new VueEllipse(new Ellipse());
        final VueEllipse ellipse2 = new VueEllipse(new Ellipse(new Coordonnees(150, 0), 200, 170));
        final VueEllipse ellipse3 = new VueEllipse(new Ellipse(new Coordonnees(350, 0), 170, 200));

        this.panneau.ajouterVueForme(ellipse1);
        this.panneau.ajouterVueForme(ellipse2);
        this.panneau.ajouterVueForme(ellipse3);

        // Modification des couleurs
        final VueEllipse ellipse4 = new VueEllipse(new Ellipse(new Coordonnees(0,200)));
        final VueEllipse ellipse5 = new VueEllipse(new Ellipse(new Coordonnees(150, 200), 200, 170));
        final VueEllipse ellipse6 = new VueEllipse(new Ellipse(new Coordonnees(350, 200), 170, 200));

        ellipse4.getForme().setCouleur(Color.RED);
        ellipse5.getForme().setCouleur(Color.BLUE);
        ellipse6.getForme().setCouleur(Color.YELLOW);

        this.panneau.ajouterVueForme(ellipse4);
        this.panneau.ajouterVueForme(ellipse5);
        this.panneau.ajouterVueForme(ellipse6);

        // Remplissage des formes
        Ellipse ellipseForme = new Ellipse(new Coordonnees(0, 400));
        ellipseForme.setRempli(true);
        final VueEllipse ellipse7 = new VueEllipse(ellipseForme);

        ellipseForme = new Ellipse(new Coordonnees(150, 400), 200, 170);
        ellipseForme.setRempli(true);
        ellipseForme.setCouleur(Color.ORANGE);
        final VueEllipse ellipse8 = new VueEllipse(ellipseForme);

        ellipseForme = new Ellipse(new Coordonnees(350, 400), 170, 200);
        ellipseForme.setRempli(true);
        ellipseForme.setCouleur(Color.GREEN);
        final VueEllipse ellipse9 = new VueEllipse(ellipseForme);

        this.panneau.ajouterVueForme(ellipse7);
        this.panneau.ajouterVueForme(ellipse8);
        this.panneau.ajouterVueForme(ellipse9);
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VueEllipseTest();
            }
        });
    }
}