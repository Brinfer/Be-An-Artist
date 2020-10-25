package fr.eseo.poo.projet.artiste.modele;

import java.awt.Color;

/**
 * L'{@code interface Coloriable} spéciefie les méthodes à utiliser pour changer
 * et récupérer la couleur d'une {@code Forme}.
 * 
 * @see Forme
 * 
 * @author Brinfer
 * 
 * @since 0.3.5.1
 * 
 * @version 0.3.5.1
 */
public interface Coloriable {

	/**
	 * Accesseur de la couleur de la {@code Forme}.
	 * 
	 * @return Une {@code Color} correspondant à la couleur de la {@code Forme}.
	 * 
	 * @since 0.3.5.1
	 */
	public abstract Color getCouleur();

	/**
	 * Muttateur de la couleur de la {@code Forme}.
	 * 
	 * @param couleur Une {@code Color} correspondant à la couleur la nouvelle
	 *                couleure de la {@code Forme}.
	 * 
	 * @since 0.3.5.1
	 */
	public abstract void setCouleur(Color couleur);

	/**
	 * Fonction donnant une description de la couleur.
	 * 
	 * @return Une {@code String} décrivant la couleur de la forme.
	 * 
	 * @since 0.3.5.1
	 */
	public String descriptionCouleur();
}