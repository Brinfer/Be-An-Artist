package fr.eseo.poo.projet.artiste.modele;

/**
 * Inteface permettant d'indiquer les fonctions pour gérer l'épaisseur du trait d'une
 * {@code Forme}.
 * 
 * @see Forme
 * 
 * @author Brinfer
 * 
 * @since 0.4.4.1
 */
public interface EpaisseurTrait {

	/**
	 * Mutateur de l'épaisseur du trait.
	 * 
	 * @param epaisseur Un {@code float} correspondant à la nouvelle épaisseur du trait.
	 * 
	 * @since 0.4.4.1
	 */
	public void setEpaisseurTrait(float epaisseur);

	/**
	 * Accesseur de l'épaisseur du trait de type {@code float} permetttant de
	 * sauvegarder l'épaisseur du trait.
	 * <p>
	 * Cet attribue est directement utilisable pour la classe
	 * {@linkplain java.awt.Stroke}
	 * 
	 * @return Un {@code float} correspondant à l'épaisseur courante du trait.
	 * 
	 * @since 0.4.4.1
	 */
	public float getEpaisseurTrait();

	/**
	 * Fonction retournant une chaîne de caractére décrivant l'épaisseur du trait.
	 * 
	 * @return Une {@code String} décrivant l'épaisseur du trait.
	 * 
	 * @since 0.4.4.1
	 */
	public String descriptionEpaisseurTrait();
}