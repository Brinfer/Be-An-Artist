package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import java.awt.event.MouseEvent;

/**
 * Classe de test de la classe {@code ActionEffacer}.
 * 
 * @see ActionEffacer
 * @see <a href=
 *      "https://docs.oracle.com/javase/8/docs/api/java/awt/event/MouseEvent.html">Oracle
 *      - MouseEvent</a>
 * 
 * @author Brinfer
 * 
 * @since 0.3.4.6
 * 
 * @version 0.3.4.6
 */
public class ActionEffacerToutTest {

    /**
     * Attribut représentant la frame ou sera dessiner placé la zone de dessin.
     */
    private final JFrame frame;

    /**
     * Attribut représentant la zone de dessin.
     */
    private final PanneauDessin panneauDessin;

    /**
     * Attribut repésentant l'action testé.
     */
    private final ActionEffacerTout actionEffacer;

    /**
     * Attribut représentant l'outil utiliser.
     */
    private final OutilLigne outilLigne;

    public ActionEffacerToutTest() {
        this.frame = new JFrame();
        this.panneauDessin = new PanneauDessin();

        this.frame.getContentPane().add(this.panneauDessin);
        this.frame.setSize(this.panneauDessin.getPreferredSize());

        this.frame.setVisible(true);
        this.frame.setLayout(null);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.actionEffacer = new ActionEffacerTout(this.panneauDessin);

        this.outilLigne = new OutilLigne();
        this.panneauDessin.associerOutil(this.outilLigne);
    }

    private void testActionEffacer() {
        this.frame.setTitle("ActionEffacerTest - Aucune Forme");
        // Aucune Forme dans la zone de dessin.
        // L'oprérateur doit cliquer sur "Yes".
        // Il ne doit rien se passer
        this.actionEffacer.actionPerformed(null);

        // Dessine une ligne au hasard
        this.dessinFormeClick(1 + (int) (Math.random() * this.panneauDessin.getWidth()),
                1 + (int) (Math.random() * this.panneauDessin.getHeight()));

        // Une Forme dans la zone de dessin.
        // L'oprérateur doit cliquer sur "Yes".
        // La ligne doit disparaitre
        this.frame.setTitle("ActionEffacerTest - Une Forme");
        this.actionEffacer.actionPerformed(null);

        // Dessine 10 lignes au hasard dans le panneau
        for (int i = 0; i < 10; i++) {
            this.dessinFormeClick(1 + (int) (Math.random() * this.panneauDessin.getWidth()),
                    1 + (int) (Math.random() * this.panneauDessin.getHeight()));
        }

        // Plusieurs Forme dans la zone de dessin.
        // L'oprérateur doit cliquer sur "Yes".
        // Aucun probléme ne doit survenir, et toutes les lignes dessiner doivent
        // disparaitre.
        this.frame.setTitle("ActionEffacerTest - Plusieurs Formes");
        this.actionEffacer.actionPerformed(null);

        // Dessine 10 lignes au hasard dans le panneau
        for (int i = 0; i < 10; i++) {
            this.dessinFormeClick(1 + (int) (Math.random() * this.panneauDessin.getWidth()),
                    1 + (int) (Math.random() * this.panneauDessin.getHeight()));
        }

        // Plusieurs Forme dans la zone de dessin.
        // L'oprérateur doit cliquer sur "No".
        // Aucun probléme ne doit survenir, et aucunes lignes dessiner ne doit
        // disparaitre
        this.frame.setTitle("ActionEffacerTest - Ne Pas Effacer");
        this.actionEffacer.actionPerformed(null);

        // Plusieurs Forme dans la zone de dessin.
        // L'oprérateur doit cliquer sur la croix de la boite de dialogue.
        // Aucun probléme ne doit survenir, et aucunes lignes dessiner ne doit
        // disparaitre
        this.frame.setTitle("ActionEffacerTest - Clic croix");
        this.actionEffacer.actionPerformed(null);

        // L'outil "OutilLigne" est associé, il doit donc être possible de dessiner des
        // lignes après.
        this.frame.setTitle("ActionEffacerTest - Fin du Scénario");
    }

    /**
     * Fonction permettant de dessiner une forme par défaut à l'aide d'un double
     * click.
     * 
     * @param x Le {@code int} correspondant à l'abcisse du click.
     * @param y Le {@code int} correspondant à l'orodonnées du click.
     */
    private void dessinFormeClick(final int x, final int y) {
        this.outilLigne.mousePressed(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_PRESSED, 0,
                MouseEvent.BUTTON1_MASK, x, y, 1, false, MouseEvent.BUTTON1));
        this.outilLigne.mouseReleased(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_RELEASED, 0,
                MouseEvent.BUTTON1_MASK, x, y, 1, false, MouseEvent.BUTTON1));
        this.outilLigne.mouseClicked(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_CLICKED, 0,
                MouseEvent.BUTTON1_MASK, x, y, 2, false, MouseEvent.BUTTON1));
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ActionEffacerToutTest().testActionEffacer();
            }
        });
    }

}