package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Classe {@code VueCerlceTest} permettant de tester le bon affichage de la
 * représentation des cercles.
 * <p>
 * Plusieurs cercles sont dessinées, ils sont placé à différents endroit et on
 * des dimensions variantes. Le dessin de cercles hors du cadre ne doit pas
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
public class VueCercleTest {

    /**
     * Attribut représentant la frame ou sera dessiner placé la zone de dessin.
     */
    private final JFrame frame;

    /**
     * Attribut représentant la zone de dessin.
     */
    private final PanneauDessin panneau;

    public VueCercleTest() {
        this.frame = new JFrame();
        this.panneau = new PanneauDessin(600, 600, PanneauDessin.COULEUR_FOND_PAR_DEFAUT);

        this.frame.getContentPane().add(panneau);
        this.frame.setTitle("VueCercleTest");
        this.frame.setSize(panneau.getPreferredSize());
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.testDessincercle();
    }

    private void testDessincercle() {
        // Forme par a la couleur est au remplissage par défaut
        final VueCercle cercle1 = new VueCercle(new Cercle());
        final VueCercle cercle2 = new VueCercle(new Cercle(new Coordonnees(150, 0), 200));
        final VueCercle cercle3 = new VueCercle(new Cercle(new Coordonnees(350, 0), 170));

        this.panneau.ajouterVueForme(cercle1);
        this.panneau.ajouterVueForme(cercle2);
        this.panneau.ajouterVueForme(cercle3);

        // Modification des couleurs
        final VueCercle cercle4 = new VueCercle(new Cercle(new Coordonnees(0,200)));
        final VueCercle cercle5 = new VueCercle(new Cercle(new Coordonnees(150, 200), 200));
        final VueCercle cercle6 = new VueCercle(new Cercle(new Coordonnees(350, 200), 170));

        cercle4.getForme().setCouleur(Color.RED);
        cercle5.getForme().setCouleur(Color.BLUE);
        cercle6.getForme().setCouleur(Color.YELLOW);

        this.panneau.ajouterVueForme(cercle4);
        this.panneau.ajouterVueForme(cercle5);
        this.panneau.ajouterVueForme(cercle6);

        // Remplissage des formes
        Cercle cercleForme = new Cercle(new Coordonnees(0, 400));
        cercleForme.setRempli(true);
        final VueCercle cercle7 = new VueCercle(cercleForme);

        cercleForme = new Cercle(new Coordonnees(150, 400), 200);
        cercleForme.setRempli(true);
        cercleForme.setCouleur(Color.ORANGE);
        final VueCercle cercle8 = new VueCercle(cercleForme);

        cercleForme = new Cercle(new Coordonnees(350, 400), 170);
        cercleForme.setRempli(true);
        cercleForme.setCouleur(Color.GREEN);
        final VueCercle cercle9 = new VueCercle(cercleForme);

        this.panneau.ajouterVueForme(cercle7);
        this.panneau.ajouterVueForme(cercle8);
        this.panneau.ajouterVueForme(cercle9);
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VueCercleTest();
            }
        });
    }
}