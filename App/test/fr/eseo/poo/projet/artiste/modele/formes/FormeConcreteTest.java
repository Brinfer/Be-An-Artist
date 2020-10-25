package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Classe concrete de Forme permettant de tester la classe abstraite
 * {@link Forme}.
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.3
 */
public class FormeConcreteTest extends Forme {

	/**
	 * @see Forme#Forme().
	 */
	public FormeConcreteTest() {
		super();
	}

	/**
	 * @see Forme#Forme(Coordonnees).
	 */
	public FormeConcreteTest(final Coordonnees coordonnees) {
		super(coordonnees);
	}

	/**
	 * @see Forme#Forme(double, double).
	 * 
	 * @since 0.3.2.3
	 */
	public FormeConcreteTest(final double largeur, final double hauteur) {
		super(largeur, hauteur);
	}

	/**
	 * @see Forme#Forme(Coordonnees, double, double).
	 * 
	 * @since 0.3.2.3
	 */
	public FormeConcreteTest(final Coordonnees position, final double largeur, final double hauteur) {
		super(position, largeur, hauteur);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @since 0.3.2.3
	 */
	public double perimetre() {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @since 0.3.2.3
	 */
	public double aire() {
		return 0;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @since 0.3.2.8
	 */
	public boolean contient(final Coordonnees coordonnees) {
		return false;
	}
}
