package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

/**
 * Classe {@code Outil} est la classe abstraitre de toute les outils, qui permet
 * de tracer des formes.
 * 
 * @author Brinfer
 * 
 * @since 0.3.4.1
 */
public abstract class Outil implements MouseInputListener {

	/**
	 * Les {@code Coordonnees} du clic de la souris.
	 * <p>
	 * Il s'agira d'un des coins du rectangle englobant notre {@code Forme}.
	 * 
	 * @since 0.3.4.1
	 */
	private Coordonnees debut;

	/**
	 * Les {@code Coordonnees} du relachement d clic de la souris.
	 * <p>
	 * Il s'agira d'un des coins du rectangle englobant notre {@code Forme}.
	 * 
	 * @since 0.3.4.1
	 */
	private Coordonnees fin;

	/**
	 * Le {@code PanneauDessin} correspondant à notre zone de dessin.
	 * 
	 * @since 0.3.4.1
	 */
	private PanneauDessin panneauDessin;

	/**
	 * Accesseur de permettant de connaitre les {@code Coordonnees} du clic au début
	 * du traçage de la {@code Forme}. Il s'agit donc d'un des coins du rectangle
	 * englobant la {@code Forme}.
	 * 
	 * @return Les {@code Coordonnees} du premier coin du rectangle englobant notre
	 *         {@code Forme}.
	 * 
	 * @see #getFin()
	 * @see #setDebut(Coordonnees)
	 * 
	 * @since 0.3.4.1
	 */
	public Coordonnees getDebut() {
		return this.debut;
	}

	/**
	 * Mutateur des {@code Coordonnees} du debut du traçage de la {@code Forme}.
	 * 
	 * @param debut Les {@code Coordonnes} du debut du traçage de la {@code Forme}.
	 * 
	 * @see #getDebut()
	 * @see #setFin(Coordonnees)
	 * 
	 * @since 0.3.4.1
	 */
	public void setDebut(final Coordonnees debut) {
		this.debut = debut;
	}

	/**
	 * Accesseur de permettant de connaitre les {@code Coordonnees} du relachement
	 * du clic du début du traçage de la {@code Forme}. Il s'agit donc d'un des
	 * coins du rectangle englobant la {@code Forme}.
	 * 
	 * @return Les {@code Coordonnees} du dernier coin du rectangle englobant notre
	 *         {@code Forme}.
	 * 
	 * @see #getDebut()
	 * @see #setFin(Coordonnees)
	 * 
	 * @since 0.3.4.1
	 */
	public Coordonnees getFin() {
		return this.fin;
	}

	/**
	 * Mutateur des {@code Coordonnees} du relachement du clic du debut du traçage
	 * de la {@code Forme}.
	 * 
	 * @param fin Les {@code Coordonnes} du relachement du clic du debut du traçage
	 *            de la {@code Forme}.
	 * 
	 * @see #getFin()
	 * @see #setDebut(Coordonnees)
	 * 
	 * @since 0.3.4.1
	 */
	public void setFin(final Coordonnees fin) {
		this.fin = fin;
	}

	/**
	 * Accesseur du {@code panneauDessin}, correspondant à notre zone de dessin.
	 * 
	 * @return le {@code panneauDessin} qui est nôtre zone de dessin.
	 * 
	 * @see #setPanneauDessin(PanneauDessin)
	 * 
	 * @since 0.3.4.1
	 */
	public PanneauDessin getPanneauDessin() {
		return this.panneauDessin;
	}

	/**
	 * Muttateur de {@code panneauDessin}, notre zone de dessin.
	 * 
	 * @param panneau Le {@code PanneauDessin} qui sera notre nouvelle zone de
	 *                dessin.
	 * 
	 * @see #getPanneauDessin()
	 * 
	 * @since 0.3.4.1
	 */
	public void setPanneauDessin(final PanneauDessin panneau) {
		this.panneauDessin = panneau;
	}

	/**
	 * Fonction dedier à la récupération des {@code MouseEvent} lorsqu'un des
	 * boutons de souris est appuyé et ensuite relaché sans déplacement de la
	 * souris.
	 * 
	 * @param event Le {@code MouseEvent} associé au clic.
	 * 
	 * @see <a href =
	 *      "https://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseEvent.html">
	 *      Oracle - MouseEvent</a>
	 * 
	 * @since 0.3.4.1
	 */
	@Override
	public void mouseClicked(final MouseEvent event) {

	}

	/**
	 * Fonction dedier à la récupération des {@code MouseEvent} lorsque la souris
	 * est déplacée avec un de ses boutons appuyé.
	 * 
	 * @param event Le {@code MouseEvent} associé au déplacement.
	 * 
	 * @see <a href =
	 *      "https://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseEvent.html">
	 *      Oracle - MouseEvent</a>
	 * 
	 * @since 0.3.4.1
	 */
	@Override
	public void mouseDragged(final MouseEvent event) {

	}

	/**
	 * Fonction dedier à la récupération des {@code MouseEvent} lorsque la souris
	 * est déplacée de l’extérieur vers l’intérieur d’un composant.
	 * 
	 * @param event Le {@code MouseEvent} associé au déplacement.
	 * 
	 * @see <a href =
	 *      "https://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseEvent.html">
	 *      Oracle - MouseEvent</a>
	 * 
	 * @since 0.3.4.1
	 */
	@Override
	public void mouseEntered(final MouseEvent event) {

	}

	/**
	 * Fonction dedier à la récupération des {@code MouseEvent} lorsque la souris
	 * est déplacée de l’intérieur vers l’extérieur d’un composant
	 * 
	 * @param event Le {@code MouseEvent} associé au déplacement.
	 * 
	 * @see <a href =
	 *      "https://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseEvent.html">
	 *      Oracle - MouseEvent</a>
	 * 
	 * @since 0.3.4.1
	 */
	@Override
	public void mouseExited(final MouseEvent event) {

	}

	/**
	 * Fonction dedier à la récupération des {@code MouseEvent} lorsque la souris
	 * est déplacée sans aucun bouton appuyé
	 * 
	 * @param event Le {@code MouseEvent} associé au déplacement.
	 * 
	 * @see <a href =
	 *      "https://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseEvent.html">
	 *      Oracle - MouseEvent</a>
	 * 
	 * @since 0.3.4.1
	 */
	@Override
	public void mouseMoved(final MouseEvent event) {

	}

	/**
	 * Fonction dedier à la récupération des {@code MouseEvent} lorsque un des
	 * boutons de souris est appuyé
	 * 
	 * @param event Le {@code MouseEvent} associé à la pression du boutons.
	 * 
	 * @see <a href =
	 *      "https://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseEvent.html">
	 *      Oracle - MouseEvent</a>
	 * 
	 * @since 0.3.4.1
	 */
	@Override
	public void mousePressed(final MouseEvent event) {
		this.setDebut(new Coordonnees(event.getX(), event.getY()));
	}

	/**
	 * Fonction dedier à la récupération des {@code MouseEvent} lorsque un des
	 * boutons de souris est relaché
	 * 
	 * @param event Le {@code MouseEvent} associé au relachement du bouton.
	 * 
	 * @see <a href =
	 *      "https://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseEvent.html">
	 *      Oracle - MouseEvent</a>
	 * 
	 * @since 0.3.4.1
	 */
	@Override
	public void mouseReleased(final MouseEvent event) {
		this.setFin(new Coordonnees(event.getX(), event.getY()));
	}
}