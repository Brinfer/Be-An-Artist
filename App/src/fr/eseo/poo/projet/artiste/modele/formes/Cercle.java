package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Classe {@code Cercle}, un cercle est une ellipse dont la largeur et la
 * hauteur sont égale.
 * <p>
 * Pour plus d'information, se référer à la classe {@linkplain Ellipse}.
 * 
 * @see Ellipse
 * 
 * @author Brinfer
 *
 * @since 0.3.2.6
 * 
 * @version 0.3.3.6
 */
public class Cercle extends Ellipse {

	/**
	 * Constructeur d'un nouveau {@code Cercle} par defaut, initialisant les
	 * attribuents avec les valeurs par defaut.
	 * 
	 * @see #Cercle(double)
	 * @see #Cercle(Coordonnees)
	 * @see #Cercle(Coordonnees, double)
	 * 
	 * @since 0.3.2.6
	 */
	public Cercle() {
		this(Forme.LARGEUR_PAR_DEFAUT);
	}

	/**
	 * Constructeur d'un nouveau {@code Cercle} a partir d'un point, les autres
	 * attribut etant initialise a partir des valeurs par defaut.
	 * 
	 * @param coordonnees La {@code Coordonnees} correspondant à la position du coin
	 *                    superieur gauche du rectangle englobant l'ellipse.
	 * 
	 * @see #Cercle(Coordonnees, double)
	 * @see #Cercle(double)
	 * @see #Cercle()
	 * 
	 * @since 0.3.2.6
	 */
	public Cercle(final Coordonnees coordonnees) {
		this(coordonnees, Forme.LARGEUR_PAR_DEFAUT);
	}

	/**
	 * Constructeur de la classe {@linkplain Cercle} a partir d'un diametre, la
	 * position etant initialise a partir des valeurs par defaut.
	 * 
	 * @param taille Un {@code double} correspondant au diamètre du cercle.
	 * 
	 * @see Ellipse#Ellipse(double, double)
	 * @see #Cercle()
	 * @see #Cercle(Coordonnees)
	 * @see #Cercle(Coordonnees, double)
	 * 
	 * @since 0.3.2.6
	 */
	public Cercle(final double taille) {
		super(taille, taille);
	}

	/**
	 * Constructeur de la classe {@linkplain Cercle} a partir d'une position, d'un
	 * diametre.
	 * 
	 * @param coordonnees La {@code Coordonnees} correspondant à la position du coin
	 *                    superieur gauche du rectangle englobant l'ellipse.
	 * @param taille      Un {@code double} correspondant au diamètre du cercle.
	 * 
	 * @see Ellipse#Ellipse(Coordonnees, double, double)
	 * @see #Cercle()
	 * @see #Cercle(Coordonnees)
	 * @see #Cercle(double)
	 * 
	 * @since 0.3.2.6
	 */
	public Cercle(final Coordonnees coordonnees, final double taille) {
		super(coordonnees, taille, taille);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Dans le cas du cercle, la hauteur du rectangle est aussi modifié pour que ses
	 * deux dimensions restent égales.
	 * 
	 * @throws IllegalArgumentException Si la largeur est inférieurs ou égales à 0.
	 * 
	 * @see #setHauteur(double)
	 * @see Forme#getLargeur()
	 * 
	 * @since 0.3.2.6
	 */
	@Override
	public void setLargeur(final double largeur) {
		super.setHauteur(largeur);
		super.setLargeur(largeur);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Dans le cas du cercle, la largeur du rectangle est aussi modifié pour que ces
	 * deux dimensions restent égales.
	 * 
	 * @throws IllegalArgumentException Si la hauteur est inférieurs ou égales à 0.
	 * 
	 * @see #setLargeur(double)
	 * @see Forme#getHauteur()
	 * 
	 * @since 0.3.2.6
	 */
	@Override
	public void setHauteur(final double hauteur) {
		this.setLargeur(hauteur);
	}

	/**
	 * Accesseur du perimetre du cercle.
	 * <p>
	 * La formule étant: {@code D x π}.
	 * <p>
	 * ou <i>D</i> est le diamètre du cercle.
	 * 
	 * @since 0.3.2.6
	 */
	@Override
	public double perimetre() {
		return Math.PI * super.getHauteur();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see Forme#equals(Object)
	 * 
	 * @since 0.3.3.6
	 */
	@Override
	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (!(other instanceof Cercle)) {
			return false;
		}
		Cercle cercle = (Cercle) other;
		return super.equals(cercle);
	}

	/**
	 * Fonction permettant d'obtenir la hashCode d'un {@code Cercle}.
	 * 
	 * @return Un {@code int} correspondan au hashCode du {@code Cerlce}.
	 * 
	 * @see Forme#hashCode()
	 * @see String#hashCode()
	 * 
	 * @since 0.3.3.6
	 */
	@Override
	public int hashCode() {
		return super.hashCode() + super.descriptionCouleur().hashCode() + this.descriptionRemplissage().hashCode();
	}
}
