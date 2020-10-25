package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Classe {@code VueLigneTest} permettant de tester le bon affichage de la
 * représentation des lignes.
 * <p>
 * Plusieurs lignes sont dessinées, elles sont placé à différents endroit et on
 * des dimensions variantes. Le dessin de lignes hors du cadre ne doit pas
 * entrainer d'erreur.
 * 
 * @see VueLigne
 * @see PanneauDessin
 * 
 * @author Brinfer
 * 
 * @since 0.3.3.6
 * 
 * @version 0.3.5.3
 */
public class VueLigneTest {

    /**
     * Attribut représentant la frame ou sera dessiner placé la zone de dessin.
     */
    private final JFrame frame;

    /**
     * Attribut représentant la zone de dessin.
     */
    private final PanneauDessin panneau;

    public VueLigneTest() {
        this.frame = new JFrame();
        this.panneau = new PanneauDessin(600, 600, PanneauDessin.COULEUR_FOND_PAR_DEFAUT);

        this.frame.getContentPane().add(panneau);
        this.frame.setTitle("VueLigneTest");
        this.frame.setSize(panneau.getPreferredSize());
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.testDessinLigne();
    }

    private void testDessinLigne() {
        // Forme par a la couleur est au remplissage par défaut
        final VueLigne ligne1 = new VueLigne(new Ligne());
        final VueLigne ligne2 = new VueLigne(new Ligne(new Coordonnees(150, 0), 200, 170));
        final VueLigne ligne3 = new VueLigne(new Ligne(new Coordonnees(350, 0), 170, 200));

        this.panneau.ajouterVueForme(ligne1);
        this.panneau.ajouterVueForme(ligne2);
        this.panneau.ajouterVueForme(ligne3);

        // Modification des couleurs
        final VueLigne ligne4 = new VueLigne(new Ligne(new Coordonnees(0, 200)));
        final VueLigne ligne5 = new VueLigne(new Ligne(new Coordonnees(150, 200), 200, 170));
        final VueLigne ligne6 = new VueLigne(new Ligne(new Coordonnees(350, 200), 170, 200));

        ligne4.getForme().setCouleur(Color.RED);
        ligne5.getForme().setCouleur(Color.BLUE);
        ligne6.getForme().setCouleur(Color.YELLOW);

        this.panneau.ajouterVueForme(ligne4);
        this.panneau.ajouterVueForme(ligne5);
        this.panneau.ajouterVueForme(ligne6);
    }
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VueLigneTest();
            }
        });
    }
}