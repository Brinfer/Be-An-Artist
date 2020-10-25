package fr.eseo.poo.projet.artiste.controleur.actions;

import fr.eseo.poo.projet.artiste.controleur.outils.Outil;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Lors du l'éxecution des tests il est recommandé de ne pas bouger la souris !!
 * <p>
 * Cette fonction permet d'exécuter des tests sur le bon changement des couleurs
 * de chaque forme en fonction de celle sélectionner par l'opérateur.
 * <p>
 * Il y a 5 étapes:
 * <ul>
 * <li>Des formes au couleurs par defaut se dessinnent.</li>
 * <li>L'utilisateur choisie une première couleur différente de celle mise par
 * défaut, les formes qui se dessinnent sont alors de cette couleur.</li>
 * <li>L'utilisateur choisie d'annuller l'action, la couleur des nouvelles
 * formes doit être la même que précédemment.</li>
 * <li>L'utilisateur choisie de fermer sans valider la boite de dialogue, la
 * couleur des nouvelles formes doit être la même que précédemment.</li>
 * <li>L'utilisateur choisie une nouvelle couleur, les formes qui se dessinnent
 * sont alors de cette couleur.</li>
 * </ul>
 * 
 * @see <a href=
 *      "https://docs.oracle.com/javase/8/docs/api/java/awt/event/MouseEvent.html">Oracle
 *      - MouseEvent</a>
 * 
 * @author Brinfer
 * 
 * @since 0.3.5.3
 */
public class ActionChoisirCouleurTest {

    /**
     * Attribut représentant la frame ou sera dessiner placé la zone de dessin.
     */
    private final JFrame frame;

    /**
     * Attribut représentant la zone de dessin.
     */
    private final PanneauDessin panneau;

    private final ActionChoisirCouleur action;

    public ActionChoisirCouleurTest() {
        this.frame = new JFrame();
        this.panneau = new PanneauDessin(400, 400, PanneauDessin.COULEUR_FOND_PAR_DEFAUT);
        this.action = new ActionChoisirCouleur(panneau);

        this.frame.getContentPane().add(panneau);
        this.frame.setSize(this.panneau.getPreferredSize());
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void testChoisirCouleur() {
        // Dessin des formes par défaut.
        this.panneau.associerOutil(new OutilLigne());
        this.dessinFormeClick(10, 10);
        this.panneau.associerOutil(new OutilEllipse());
        this.dessinFormeClick(10, 10);
        this.panneau.associerOutil(new OutilCercle());
        this.dessinFormeClick(10, 10);

        // L'opérateur doit sélectioner une nouvelle couleur
        this.frame.setTitle("ActionChoisirCouleurTest - Choisir couleur");
        this.action.actionPerformed(null);

        this.panneau.associerOutil(new OutilLigne());
        this.dessinFormeClick(200, 10);
        this.panneau.associerOutil(new OutilEllipse());
        this.dessinFormeClick(200, 10);
        this.panneau.associerOutil(new OutilCercle());
        this.dessinFormeClick(200, 10);

        // L'opérateur doit clicker sur annuler
        this.frame.setTitle("ActionChoisirCouleurTest - Choisir Annuler");
        this.action.actionPerformed(null);

        this.panneau.associerOutil(new OutilLigne());
        this.dessinFormeClick(10, 200);
        this.panneau.associerOutil(new OutilEllipse());
        this.dessinFormeClick(10, 200);
        this.panneau.associerOutil(new OutilCercle());
        this.dessinFormeClick(10, 200);

        // L'opérateur doit clicker sur la croix
        this.frame.setTitle("ActionChoisirCouleurTest - Quitter fenêtre");
        this.action.actionPerformed(null);

        this.panneau.associerOutil(new OutilLigne());
        this.dessinFormeClick(200, 200);
        this.panneau.associerOutil(new OutilEllipse());
        this.dessinFormeClick(200, 200);
        this.panneau.associerOutil(new OutilCercle());
        this.dessinFormeClick(200, 200);

        // L'opérateur doit sélectioner une nouvelle couleur
        this.frame.setTitle("ActionChoisirCouleurTest - Choisir couleur");
        this.action.actionPerformed(null);

        this.panneau.associerOutil(new OutilLigne());
        this.dessinFormeClick(100, 100);
        this.panneau.associerOutil(new OutilEllipse());
        this.dessinFormeClick(100, 100);
        this.panneau.associerOutil(new OutilCercle());
        this.dessinFormeClick(100, 100);

        this.frame.setTitle("ActionChoisirCouleurTest - Fin du scénario");
    }

    /**
     * Fonction permettant de dessiner une forme par défaut à l'aide d'un double
     * click.
     * 
     * @param x Le {@code int} correspondant à l'abcisse du click.
     * @param y Le {@code int} correspondant à l'orodonnées du click.
     */
    private void dessinFormeClick(final int x, final int y) {
        final Outil outil = this.panneau.getOutilCourant();
        outil.mousePressed(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_PRESSED, 0,
                MouseEvent.BUTTON1_MASK, x, y, 1, false, MouseEvent.BUTTON1));
        outil.mouseReleased(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_RELEASED, 0,
                MouseEvent.BUTTON1_MASK, x, y, 1, false, MouseEvent.BUTTON1));
        outil.mouseClicked(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_CLICKED, 0,
                MouseEvent.BUTTON1_MASK, x, y, 2, false, MouseEvent.BUTTON1));
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ActionChoisirCouleurTest().testChoisirCouleur();
            }
        });
    }
}