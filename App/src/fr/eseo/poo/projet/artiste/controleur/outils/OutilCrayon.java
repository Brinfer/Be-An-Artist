package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.TracerCrayon;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.formes.VueTracerCrayon;

/**
 * Classe {@code OutilCrayon} permettant de créer une représentation d'une
 * {@code TracerCrayon}.
 * 
 * @see TracerCrayon
 * @see VueTracerCrayon
 * 
 * @author Brinfer
 * 
 * @since 0.4.4.2
 */
public class OutilCrayon extends OutilForme {

	/**
	 * Attribue sauvegardant le dessin qui est actuellement fait par l'utilisateur.
     * 
     * @since 0.4.4.2
	 */
	private TracerCrayon tracerCrayon;

	/**
	 * {@inheritDoc}
	 * <p>
	 * L'appuie sur un des boutons de la souris entraine le debut du tracer d'une
	 * nouvelle {@code TracerCrayon}.
	 * 
	 * @param event Le {@code MouseEvent} associé à l'appui d'un bouton.
	 * 
	 * @since 0.4.4.2
	 */
	@Override
	public void mousePressed(MouseEvent event) {
        super.mousePressed(event);
        
		this.tracerCrayon = new TracerCrayon();
		this.tracerCrayon.trace(super.getDebut());
		this.tracerCrayon.setCouleur(super.getPanneauDessin().getCouleurCourante());
        this.tracerCrayon.setEpaisseurTrait(super.getPanneauDessin().getEpaisseurCourante());
        this.tracerCrayon.setRempli(super.getPanneauDessin().getModeRemplissage());

		super.getPanneauDessin().ajouterVueForme(this.creerVueForme());
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Le déplacement de la souris en maintenant un bouton appuyé fait continuer le
	 * trassage du {@code TracerCrayon} courant.
	 * 
	 * @param event Le {@code MouseEvent} associé au déplacement de la souris tandis
	 *              qu'un bouton est maintenue appuyé.
	 * 
	 * @since 0.4.4.2
	 */
	@Override
	public void mouseDragged(MouseEvent event) {
		super.setFin(new Coordonnees(event.getX(), event.getY()));
		this.tracerCrayon.trace(super.getFin());
		super.getPanneauDessin().repaint();
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Le relachement d'un bouton de la souris entraine la fin du trassade du du
	 * {@code TracerCrayon} courant. Une nouvelle instance sera créer si l'on
	 * réappuie sur un bouton.
	 * 
	 * @param event Le {@code MouseEvent} associé au relachement du bouton.
	 * 
	 * @since 0.4.4.2
	 */
	@Override
	public void mouseReleased(MouseEvent event) {
		this.tracerCrayon.calculeDim(); // Calcule des dimensions du rectangle englobant le tracé
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @since 0.4.4.2
	 */
	@Override
	protected VueForme creerVueForme() {
		return new VueTracerCrayon(this.tracerCrayon);
	}
}