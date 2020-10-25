package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Classe de test de la classe {@linkplain PanneauDessin}.
 * 
 * @author Brinfer
 * 
 * @since 0.3.3.2 
 * 
 */
public class PanneauDessinTest {
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PanneauDessinTest();
            }
        });
    }

    public PanneauDessinTest() {
        this.testConstructeurParDefaut();
        this.testConstructeur();
    }

    /**
     * Test de {@linkplain PanneauDessin#PanneauDessin()}.
     * <p>
     * On créait une fenêtre principale avec comme titre {@code Etre un Artiste}, on
     * modifie ensuite la taille de la fenêtre et on l'affiche au centre de notre
     * écran.
     * <p>
     * La fermeture de la fenêtre entraine l'arrét de l'application.
     */
    private void testConstructeurParDefaut() {
        final JFrame frame = new JFrame();

        final PanneauDessin panneau = new PanneauDessin();

        frame.getContentPane().add(panneau);
        frame.setTitle("Etre un Artiste");
        frame.setSize(panneau.getPreferredSize());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Test de {@linkplain PanneauDessin#PanneauDessin(int, int, java.awt.Color)}.
     * <p>
     * On créait une fenêtre principale avec comme titre
     * {@code Blues du Businessman}, on modifie ensuite la taille de la fenêtre et
     * on l'affiche au centre de notre écran.
     * <p>
     * La fermeture de la fenêtre entraine l'arrét de l'application.
     */
    private void testConstructeur() {
        final JFrame frame = new JFrame();

        final PanneauDessin panneau = new PanneauDessin(600, 600, Color.CYAN);

        frame.getContentPane().add(panneau);
        frame.setTitle("Blues du Businessman");
        frame.setSize(panneau.getPreferredSize());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}