package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Classe permettant de sélectionner une forme déjà dessinée, afin d'afficher sa
 * description.
 * 
 * @see JOptionPane#toString()
 * 
 * @author Brinfer
 * 
 * @since 0.3.4.10
 * 
 * @version 0.3.4.10
 */
public class OutilSelectionner extends Outil {

	/**
	 * {@inheritDoc}
	 * <p>
	 * Elle permet d'obtenir les informations lié à la {@code Forme} sur laquelle
	 * l'on vient de cliquer.
	 * <p>
	 * Si on clique à un endroit où se trouve plusieurs {@code Forme}, alors on
	 * affiche les informations de la forme la plus récente.
	 * 
	 * @see JOptionPane
	 * 
	 * @since 0.3.4.10
	 */
	@Override
	public void mouseClicked(final MouseEvent event) {
		final Coordonnees click = new Coordonnees(event.getX(), event.getY());
		for (int i = super.getPanneauDessin().getVueFormes().size() - 1; i > -1; i--) {
			if (super.getPanneauDessin().getVueFormes().get(i).getForme().contient(click)) {
				JOptionPane.showMessageDialog(super.getPanneauDessin(),
						super.getPanneauDessin().getVueFormes().get(i).getForme().toString(),
						ActionSelectionner.NOM_ACTION, JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}
	}
}