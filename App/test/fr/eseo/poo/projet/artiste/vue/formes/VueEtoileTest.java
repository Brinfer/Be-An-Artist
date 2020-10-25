package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Classe {@code VueEtoileTest} permettant de tester le bon affichage de la
 * représentation des Etoiles.
 * <p>
 * Plusieurs Etoiles sont dessinées, elles sont placé à différents endroit et on
 * des dimensions variantes. Le dessin d'Etoile hors du cadre ne doit pas
 * entrainer d'erreur.
 * 
 * @see VueEtoile
 * @see PanneauDessin
 * 
 * @author Brinfer
 * 
 * @since 0.3.7.2
 * 
 * @version 0.3.7.2
 */
public class VueEtoileTest {

    /**
     * Attribut représentant la frame ou sera dessiner placé la zone de dessin.
     */
    private final JFrame frame;

    /**
     * Attribut représentant la zone de dessin.
     */
    private final PanneauDessin panneau;

    public VueEtoileTest() {
        this.frame = new JFrame();
        this.panneau = new PanneauDessin(600, 600, PanneauDessin.COULEUR_FOND_PAR_DEFAUT);

        this.frame.getContentPane().add(panneau);
        this.frame.setTitle("VueEtoileTest");
        this.frame.setSize(panneau.getPreferredSize());
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.testDessinEtoile();
    }

    private void testDessinEtoile() {
        // Forme par a la couleur est au remplissage par défaut
        final VueEtoile etoile1 = new VueEtoile(new Etoile(new Coordonnees(0, 0), 170));
        final VueEtoile etoile2 = new VueEtoile(new Etoile(new Coordonnees(170, 0), 170, 10,
                Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT));
        final VueEtoile etoile3 = new VueEtoile(new Etoile(new Coordonnees(340, 0), 170,
                Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, Math.PI / 3, Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT));
        final VueEtoile etoile4 = new VueEtoile(new Etoile(new Coordonnees(510, 0), 170,
                Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0.25));

        this.panneau.ajouterVueForme(etoile1);
        this.panneau.ajouterVueForme(etoile2);
        this.panneau.ajouterVueForme(etoile3);
        this.panneau.ajouterVueForme(etoile4);

        // Modification des couleurs
        final VueEtoile etoile5 = new VueEtoile(new Etoile(new Coordonnees(0, 170), 170));
        final VueEtoile etoile6 = new VueEtoile(new Etoile(new Coordonnees(170, 170), 170, 10,
                Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT));
        final VueEtoile etoile7 = new VueEtoile(new Etoile(new Coordonnees(340, 170), 170,
                Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, Math.PI / 3, Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT));
        final VueEtoile etoile8 = new VueEtoile(new Etoile(new Coordonnees(510, 170), 170,
                Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0.25));

        etoile5.getForme().setCouleur(Color.YELLOW);
        etoile6.getForme().setCouleur(Color.ORANGE);
        etoile7.getForme().setCouleur(Color.RED);
        etoile8.getForme().setCouleur(Color.BLUE);

        this.panneau.ajouterVueForme(etoile5);
        this.panneau.ajouterVueForme(etoile6);
        this.panneau.ajouterVueForme(etoile7);
        this.panneau.ajouterVueForme(etoile8);


        // Remplissage des formes
        Etoile etoileForme = new Etoile(new Coordonnees(0, 340), 170);
        etoileForme.setRempli(true);
        etoileForme.setCouleur(Color.GREEN);
        final VueEtoile etoile9 = new VueEtoile(etoileForme);

        etoileForme = new Etoile(new Coordonnees(170, 340), 170, 10,
        Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT);
        etoileForme.setRempli(true);
        etoileForme.setCouleur(Color.BLACK);
        final VueEtoile etoile10 = new VueEtoile(etoileForme);

        etoileForme = new Etoile(new Coordonnees(340, 340), 170,
        Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, Math.PI / 3, Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT);
        etoileForme.setRempli(true);
        etoileForme.setCouleur(Color.WHITE);
        final VueEtoile etoile11 = new VueEtoile(etoileForme);

        etoileForme = new Etoile(new Coordonnees(510, 340), 170,
        Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, 0.25);
        etoileForme.setRempli(true);
        etoileForme.setCouleur(Color.PINK);
        final VueEtoile etoile12 = new VueEtoile(etoileForme);

        this.panneau.ajouterVueForme(etoile9);
        this.panneau.ajouterVueForme(etoile10);
        this.panneau.ajouterVueForme(etoile11);
        this.panneau.ajouterVueForme(etoile12);
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VueEtoileTest();
            }
        });
    }
}