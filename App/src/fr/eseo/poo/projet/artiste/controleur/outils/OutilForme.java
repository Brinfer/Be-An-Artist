package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

/**
 * {@code OutilForme} est une classe abstraite, base de tout les outils associé
 * à une {@code Forme}.
 * 
 * @author Brinfer
 * 
 * @since 0.3.4.2
 */
public abstract class OutilForme extends Outil {

	/**
	 * {@inheritDoc}
	 * 
	 * @since 0.3.4.2
	 */
	@Override
	public void mouseReleased(final MouseEvent event) {
		super.mouseReleased(event);
		if (!super.getDebut().equals(super.getFin())) {
			super.getPanneauDessin().ajouterVueForme(this.creerVueForme());
			super.getPanneauDessin().repaint();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Dans le cas où il s'agit d'un double clic, alors une forme avec les
	 * paramètres par défaut est afficher à la position du double clics
	 * 
	 * @param event Le {@code MouseEvent} associé au click de la souris.

	 * 
	 * @since 0.3.4.2
	 */
	@Override
	public void mouseClicked(final MouseEvent event) {
		if (event.getClickCount() == 2) {
			super.getPanneauDessin().ajouterVueForme(this.creerVueForme());
			super.getPanneauDessin().repaint();
		}
	}

	/**
	 * Fonction permettant de tracer une {@code Forme}.
	 * <p>
	 * Les {@code Coordonnees} sont celle de la position de la souris au moment au
	 * moment de l'appuie et celle de la souris au moment du relachement de la
	 * souris.
	 * <p>
	 * Dans le cas où la les deux {@code Coordonnees} sont les même, dessine la
	 * forme avec les paramètres par défauts est tracer à la position du double
	 * clics
	 * 
	 * @see #mouseClicked(MouseEvent)
	 * @see #mousePressed(MouseEvent)
	 * 
	 * @since 0.3.4.2
	 */
	protected abstract VueForme creerVueForme();
}