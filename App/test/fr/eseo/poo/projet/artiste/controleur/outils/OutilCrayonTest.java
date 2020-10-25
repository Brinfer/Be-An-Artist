package fr.eseo.poo.projet.artiste.controleur.outils;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.modele.formes.TracerCrayon;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Classe {@code OutilCrayonTest} permettant de tester le fonctionnement de
 * {@code OutilCrayon}.
 * <p>
 * Le test n'est pas vraiment valable car on tilise des int pour trace l'ellipse
 * alors que le test de l'exatitude du dessin utilise des doubles
 * 
 * @see OutilCrayon
 * @see <a href=
 *      "https://docs.oracle.com/javase/8/docs/api/java/awt/event/MouseEvent.html">Oracle
 *      - MouseEvent</a>
 * 
 * @author Brinfer
 * 
 * @since 0.4.3.2
 */
public class OutilCrayonTest {
    /**
     * Attribut représentant la frame ou sera dessiner placé la zone de dessin.
     */
    private final JFrame frame;

    /**
     * Attribut représentant la zone de dessin.
     */
    private final PanneauDessin panneau;

    /**
     * Attribut représentant l'outil testé.
     */
    private final OutilCrayon outil;

    private final Ligne ligne = new Ligne(new Coordonnees(10, 10), 200, 200);

    private final Ellipse ellipse = new Ellipse(new Coordonnees(100, 100), 200, 100);

    public OutilCrayonTest() throws Exception {
        this.frame = new JFrame();
        this.panneau = new PanneauDessin(400, 400, PanneauDessin.COULEUR_FOND_PAR_DEFAUT);
        this.outil = new OutilCrayon();

        this.frame.getContentPane().add(panneau);
        this.frame.setTitle("OutilCrayonTest");
        this.frame.setSize(this.panneau.getPreferredSize());
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.testOutilCrayon();
    }

    /**
     * Fonction permettant de tester {@link OutilCrayon#creerVueForme()}.
     * <p>
     * Une épicyclïde doit apparaitre.
     * 
     * @throws Exception Si l'un des tracé déssinée ne correspond pas à celle
     *                   attendue.
     */
    private void testOutilCrayon() throws Exception {
        this.panneau.associerOutil(this.outil);

        double x = this.ligne.getPosition().getAbscisse();
        double y = this.ligne.getPosition().getOrdonnee();
        // Dessin d'une ligne en diagonale
        this.press((int) x, (int) y);
        for (int i = 0; i < this.ligne.getHauteur(); i++) {
            this.dragged((int) x, (int) y);
            x++;
            y++;
        }
        this.released((int) x, (int) y);

        // Test du dessin de la ligne
        for (Coordonnees point : ((TracerCrayon) this.panneau.getVueFormes().get(0).getForme()).getListeCoordonnees()) {
            if (!(this.ligne.contient(point))) {
                throw new Exception("Echec dessin ligne");
            }
        }

        // Dessin d'une ellipse
        final double a = this.ellipse.getLargeur() / 2;
        final double b = this.ellipse.getHauteur() / 2;
        final double u = this.ellipse.getPosition().getAbscisse() + a;
        final double v = this.ellipse.getPosition().getOrdonnee() + b;
        x = (u + a * Math.cos(0));
        y = (v + b * Math.sin(0));
        this.press((int) x, (int) y);
        for (double teta = 0; teta <= 2 * Math.PI + 0.1; teta += 0.1) {
            x = u + a * Math.cos(teta);
            y = v + b * Math.sin(teta);
            this.dragged((int) x, (int) y);
        }
        this.released((int) x, (int) y);

        // Test du dessin de l'ellipse
        for (Coordonnees point : ((TracerCrayon) this.panneau.getVueFormes().get(1).getForme()).getListeCoordonnees()) {
            if (!(this.ellipse.contient(point))) {
                throw new Exception("Echec dessin ellipse");
            }
        }
    }

    /**
     * Fonction permettant de simuler un deplacement de la souris avec un bouton
     * enfoncé vers les coordonnees données.
     * 
     * @param x L'abscisse du point de destination
     * @param y L'ordonné du point de destination
     */
    private void dragged(final int x, final int y) {
        this.outil.mouseDragged(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_DRAGGED, 0,
                MouseEvent.BUTTON1_MASK, x, y, 1, false, MouseEvent.BUTTON1));
    }

    /**
     * Fonction permettant de simuler un appui d'un bouton de la souris enfoncé au
     * les coordonnees données.
     * 
     * @param x L'abscisse du point.
     * @param y L'ordonné du point.
     */
    private void press(final int x, final int y) {
        this.outil.mousePressed(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_PRESSED, 0,
                MouseEvent.BUTTON1_MASK, x, y, 2, false, MouseEvent.BUTTON1));
    }

    /**
     * Fonction permettant de simuler un relachement d'un bouton de la souris
     * enfoncé au les coordonnees données.
     * 
     * @param x L'abscisse du point.
     * @param y L'ordonné du point.
     */
    private void released(final int x, final int y) {
        this.outil.mouseReleased(new MouseEvent(this.frame.getComponent(0), MouseEvent.MOUSE_RELEASED, 0,
                MouseEvent.BUTTON1_MASK, x, y, 2, false, MouseEvent.BUTTON1));
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new OutilCrayonTest().testOutilCrayon();
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}