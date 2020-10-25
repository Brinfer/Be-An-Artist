package fr.eseo.poo.projet.artiste.modele;

/**
 * 
 * @author Brinfer
 * 
 * @since 0.3.6.1
 * 
 * @version 0.3.6.1
 */
public interface Remplissable {

	/**
	 * Accesseur du remplissage, permet de savoir si la {@code Forme} est remplie ou
	 * non.
	 * 
	 * @return {@code true} si la forme est remplie, {@code false} sinon.
	 * 
	 * @since 0.3.6.1
	 */
	public boolean estRempli();

	/**
	 * Mutateur de l'indication du remplissage de la {@code Forme}
	 * 
	 * @param modeRemplissage Un {@code boolean}
	 *                        <ul>
	 *                        <li>{@code true} si on veut remplir la
	 *                        {@code Forme}.</li>
	 *                        <li>{@code false} si on ne veut pas remplir la
	 *                        {@code Forme}.</li>
	 *                        </ul>
	 * 
	 * @since 0.3.6.1
	 */
	public void setRempli(boolean modeRemplissage);

	/**
	 * Fonction retournant une chaîne de caractére indiquant si la {@code Forme} est
	 * remplie ou non.
	 * 
	 * @return Une {@code String} indiquant que la {@code Forme} est remplie ou non.
	 * 
	 * @since 0.3.6.1
	 */
	public String descriptionRemplissage();
}