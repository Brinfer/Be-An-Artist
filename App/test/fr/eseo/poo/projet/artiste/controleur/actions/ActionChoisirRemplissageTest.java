package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.controleur.outils.Outil;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

/**
 * Classe de test de la class {@code ActionChoisirRemplissage}.
 * 
 * Lors du l'éxecution des tests il est recommandé de ne pas bouger la souris !!
 * <p>
 * Cette fonction permet d'exécuter des tests sur le bon remplissage ou non des
 * formes avec la couleurs sélectionner par l'opérateur.
 * <p>
 * Il y a 2 étapes:
 * <ul>
 * <li>1ere étape:</li>
 * <ul>
 * <li>Des formes à la couleur par défaut se déssinnent, la première ligne est
 * vide, la seconde est pleine.</li>
 * </ul>
 * <li>2éme étape</li>
 * <ul>
 * <li>L'opérateur choisie une couleur</li>
 * <li>Le remplissage est sélectionner, des formes se dessinnent avec la couleur
 * sélectionner, elles sont rempli</li>
 * <li>Le remplissage est déselectioner, des formes se dessinent avec la couleur
 * sélectionner, elles sont vide.</li>
 * </ul>
 * </ul>
 *
 * @see ActionChoisirRemplissage
 * @see <a href=
 *      "https://docs.oracle.com/javase/8/docs/api/javax/swing/JCheckBox.html">Oracle
 *      - JChecBox</a>
 * @see <a href=
 *      "https://docs.oracle.com/javase/8/docs/api/java/awt/event/MouseEvent.html">Oracle
 *      - MouseEvent</a>
 * 
 * @author Brinfer
 * 
 * @since 0.3.6.3
 * 
 * @version 0.3.6.3
 */
public class ActionChoisirRemplissageTest {
    /**
     * Attribut représentant la frame ou sera dessiner placé la zone de dessin.
     */
    private final JFrame frame;

    /**
     * Attribut représentant la zone de dessin.
     */
    private final PanneauDessin panneau;

    private final ActionChoisirCouleur actionCouleur;

    private final JCheckBox checkBox;

    public ActionChoisirRemplissageTest() {
        this.frame = new JFrame();
        this.panneau = new PanneauDessin(600, 600, PanneauDessin.COULEUR_FOND_PAR_DEFAUT);
        this.actionCouleur = new ActionChoisirCouleur(panneau);

        this.checkBox = new JCheckBox(new ActionChoisirRemplissage(panneau)) {
            /**
             *
             */
            private static final long serialVersionUID = 2507970303834278658L;

            @Override
            public void setSelected(boolean b) {
                super.setSelected(b);
                this.getAction().actionPerformed(new ActionEvent(checkBox, ActionEvent.ACTION_PERFORMED, ""));
            }
        };
        this.checkBox.setSelected(false);

        this.frame.getContentPane().add(panneau);
        this.frame.setSize(this.panneau.getPreferredSize());
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void testChoisirRemplissage() {
        // Dessin des formes par défaut.
        this.panneau.associerOutil(new OutilLigne());
        this.dessinFormeClick(10, 10);
        this.panneau.associerOutil(new OutilEllipse());
        this.dessinFormeClick(200, 10);
        this.panneau.associerOutil(new OutilCercle());
        this.dessinFormeClick(400, 10);

        this.checkBox.setSelected(true);

        // Dessin des formes par défaut pleine.
        this.panneau.associerOutil(new OutilLigne());
        this.dessinFormeClick(10, 150);
        this.panneau.associerOutil(new OutilEllipse());
        this.dessinFormeClick(200, 150);
        this.panneau.associerOutil(new OutilCercle());
        this.dessinFormeClick(400, 150);

        // L'opérateur sélectionne une nouvelle couleur.
        this.frame.setTitle("ActionChoisirRemplissage - Choisir couleur");
        this.actionCouleur.actionPerformed(null);

        // Dessin des formes pleine au couleur de celle sélectionner
        this.panneau.associerOutil(new OutilLigne());
        this.dessinFormeClick(10, 300);
        this.panneau.associerOutil(new OutilEllipse());
        this.dessinFormeClick(200, 300);
        this.panneau.associerOutil(new OutilCercle());
        this.dessinFormeClick(400, 300);

        this.checkBox.setSelected(false);

        // Dessin des formes vide au couleur de celle sélectionner
        this.panneau.associerOutil(new OutilLigne());
        this.dessinFormeClick(10, 450);
        this.panneau.associerOutil(new OutilEllipse());
        this.dessinFormeClick(200, 450);
        this.panneau.associerOutil(new OutilCercle());
        this.dessinFormeClick(400, 450);

        this.frame.setTitle("ActionChoisirRemplissage - Scénario terminer");
    }

    /**
     * Fonction permettant de dessiner une forme par défaut à l'aide d'un double
     * click.
     * 
     * @param x Le {@code int} correspondant à l'abcisse du click.
     * @param y Le {@code int} correspondant à l'orodonnées du click.
     */
    private void dessinFormeClick(final int x, final int y) {
        Outil outil = this.panneau.getOutilCourant();
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
                new ActionChoisirRemplissageTest().testChoisirRemplissage();
            }
        });
    }
}