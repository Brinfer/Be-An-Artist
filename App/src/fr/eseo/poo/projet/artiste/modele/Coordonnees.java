package fr.eseo.poo.projet.artiste.modele;

import java.text.DecimalFormat;

/**
 * La classe {@code Coordonnees} servant a sauvergarder la position d'un point
 * dans un plan cartésien. Le plan cartésien est définie de la façon suivante :
 * <ul>
 * <li>L'axe des abscisses est orienté vers la droite</li>
 * <li>L'axe des ordonnées est orienté vers la gauche</li>
 * </ul>
 * <p>
 * Ces attributs sont modifiable.
 * <p>
 * Un point est définie par son <i>abscisse</i>, et son <i>ordonnée</i>.
 * L'abscisse et l'ordonnées sont des réels. Celle-ci peuvent être modifiés.
 * <p>
 * Par défaut le point prend pour valeur {@value #ABSCISSE_PAR_DEFAUT} en
 * <i>abscisse</i> et {@value #ORDONNEE_PAR_DEFAUT} en <i>ordonnée</i>.
 * <p>
 * Il est possible de calculer l'angle et la distance entre deux points.
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.1
 * 
 * @version 0.3.2.1
 */
public class Coordonnees {

	/**
	 * La valeur de type {@code double} par défaut pour l'abscisse.
	 * <p>
	 * De valeur {@value #ABSCISSE_PAR_DEFAUT}.
	 * 
	 * @since 0.3.2.1
	 */
	public static final double ABSCISSE_PAR_DEFAUT = 0.0;

	/**
	 * La valeur de type {@code double} par défaut, pour l'ordonnées.
	 * <p>
	 * De valeur {@value #ORDONNEE_PAR_DEFAUT}.
	 * 
	 * @since 0.3.2.1
	 */
	public static final double ORDONNEE_PAR_DEFAUT = 0.0;

	/***
	 * Valeur de type {@code double}, pour la comparaison entre deux points.
	 * <p>
	 * La précision des comparaison est de {@value #EPSILON}.
	 * 
	 * @since 0.3.2.1
	 */
	public static final double EPSILON = 0.01;

	/**
	 * Attribut representant l'abscisse du point.
	 * <p>
	 * Cette abscisse est modifiable.
	 * <p>
	 * Initialisée par défaut à {@value #LARGEUR_PAR_DEFAUT}.
	 * 
	 * @see #getAbscisse()
	 * @see #setAbscisse(double)
	 * @see #ordonee
	 * @see #LARGEUR_PAR_DEFAUT
	 * 
	 * @since 0.3.2.1
	 */
	private double abscisse;

	/**
	 * Attribut representant l'ordonnee du point.
	 * <p>
	 * Cette ordonnée est modifiable.
	 * <p>
	 * Initialisée par défaut à {@value #ORDONNEE_PAR_DEFAUT}.
	 * 
	 * @see #getOrdonnee()
	 * @see #setOrdonnee(double)
	 * @see #abscisse
	 * @see #ORDONNEE_PAR_DEFAUT
	 * 
	 * @since 0.3.2.1
	 */
	private double ordonnee;

	/**
	 * Constructeur d'une nouvelle {@code Coordonnees} à partir d'une abscisse et
	 * d'une ordonnee passés en paramètres.
	 * 
	 * @param abscisse Un {@code double} correspondant à l'abscisse du point.
	 * @param ordonnee Un {@code double} correspondant à l'ordonnee du point.
	 * 
	 * @since 0.3.2.1
	 */
	public Coordonnees(final double abscisse, final double ordonnee) {
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}

	/**
	 * Constructeur d'une nouvelle {@code Coordonnees}, il s'agit du constructeur
	 * par défaut, initialisant les attributs de la classe aux valeurs par defauts.
	 * 
	 * @since 0.3.2.1
	 */
	public Coordonnees() {
		this(Coordonnees.ABSCISSE_PAR_DEFAUT, Coordonnees.ORDONNEE_PAR_DEFAUT);
	}

	/***
	 * Accesseur de l'{@code #abscisse} du point.
	 * 
	 * @return Un {@code double} correspondant à l'abscisse du point.
	 * 
	 * @see #getOrdonnee()
	 * @see #setAbscisse(double)
	 * 
	 * @since 0.3.2.1
	 */
	public double getAbscisse() {
		return this.abscisse;
	}

	/**
	 * Accesseur de l'{@code ordonnee} du point.
	 * 
	 * @return Un {@code double} correspondant à l'ordonnee du point.
	 * 
	 * @see #getAbscisse()
	 * @see #setOrdonnee(double)
	 * 
	 * @since 0.3.2.1
	 */
	public double getOrdonnee() {
		return this.ordonnee;
	}

	/**
	 * Mutateur de l'{@code abscisse} du point.
	 * 
	 * @param abscisse Un {@code double} correspondant à l'abscisse du point.
	 * 
	 * @see #setOrdonnee(double)
	 * @see #getAbscisse()
	 * 
	 * @since 0.3.2.1
	 */
	public void setAbscisse(final double abscisse) {
		this.abscisse = abscisse;
	}

	/**
	 * Mutateur de l'{@code ordonnee} du point.
	 * 
	 * @param ordonnee Un {@code double} correspondant à la nouvelle ordonnee du
	 *                 point.
	 * 
	 * @see #setAbscisse(double)
	 * @see #getOrdonnee()
	 * 
	 * @since 0.3.2.1
	 */
	public void setOrdonnee(final double ordonnee) {
		this.ordonnee = ordonnee;
	}

	/**
	 * Methode permettant de connaitre la distance entre deux point.
	 * 
	 * @param coordonnees Une {@code Coordonnees} correspondant à l'autre point avec
	 *                    lequel on veut connaitre la distance.
	 * 
	 * @return Un {@code double} correspondant à la distance entre les deux points.
	 * 
	 * @since 0.3.2.1
	 */
	public double distanceVers(final Coordonnees coordonnees) {
		return Math.sqrt(Math.pow(coordonnees.getAbscisse() - this.getAbscisse(), 2)
				+ Math.pow(coordonnees.getOrdonnee() - this.getOrdonnee(), 2));
	}

	/**
	 * Methode permettant de connaitre l'angle <i>teta</i> forme entre deux points.
	 * <p>
	 * La valeur retourné est en <i>radian</i>.
	 * 
	 * @param coordonnees Une {@code Coordonnees} correspondant à l'autre point avec
	 *                    lequel on veut connaitre l'angle.
	 * 
	 * @return Un {@code double} correspondant à l'angle entre les deux points (en
	 *         <i>radian</i>).
	 * 
	 * @see Math#atan2(double, double)
	 * 
	 * @since 0.3.2.1
	 */
	public double angleVers(final Coordonnees coordonnees) {
		return Math.atan2(coordonnees.getOrdonnee() - this.getOrdonnee(),
				coordonnees.getAbscisse() - this.getAbscisse());

	}

	/**
	 * Mutateur des 2 coordonnees du point a partir d'une nouvelle abscisse et d'une
	 * nouvelle ordonnee.
	 * 
	 * @param x Un {@code double} correspondant à la nouvelle abscisse du point.
	 * @param y Un {@code double} correspondant à la nouvelle ordonnees du point.
	 * 
	 * @see #deplacerDe(double, double)
	 * 
	 * @since 0.3.2.1
	 */
	public void deplacerVers(final double x, final double y) {
		this.setAbscisse(x);
		this.setOrdonnee(y);
	}

	/**
	 * Mutateurs des 2 coordonnees du point a partir d'un vecteur de deplacement. Un
	 * décalage du point est effectuer.
	 * 
	 * @param deltaX Un {@code double} correspondant à l'abscisse du vecteur.
	 * @param deltaY Un {@code double} correspondant à l'ordonnee du vecteur.
	 * 
	 * @see #deplacerVers(double, double)
	 * 
	 * @since 0.3.2.1
	 */
	public void deplacerDe(final double deltaX, final double deltaY) {
		this.setAbscisse(this.getAbscisse() + deltaX);
		this.setOrdonnee(this.getOrdonnee() + deltaY);
	}

	/**
	 * Fonction renvoyant une description du point sous la forme :
	 * <p>
	 * {@code (<abscisse> , <ordonnée>)}.
	 * 
	 * @return Une {@code String}, correspondant à la description de la
	 *         {@code Coordonnees}.
	 * 
	 * @since 0.3.2.1
	 */
	@Override
	public String toString() {
		final DecimalFormat formater = new DecimalFormat("0.0#");
		return '(' + formater.format(this.getAbscisse()) + " , " + formater.format(this.getOrdonnee()) + ')';
	}

	/**
	 * Fonction permettant de comparer si deux {@code Coordonnees} sont identiques,
	 * à {@value #EPSILON} prêt.
	 * <p>
	 * <ul>
	 * <li>Les deux {@code Coordonnees} sont identiques:</li>
	 * <ul>
	 * <li>si les deux points ont la même {@code abscisse} et la même
	 * {@code ordonnee}.
	 * <li>si la deuxieme instance testé est la testé est la également
	 * premiere.</li>
	 * </ul>
	 * <li>Les deux points sont différents:</li>
	 * <ul>
	 * <li>si la deuxieme instance testé n'est pas de une instance de
	 * {@code Coordonnees}.</li>
	 * <li>si les deux points n'ont pas la même {@code ordonnee} ou la même
	 * {@code abscisse}.</li>
	 * </ul>
	 * </ul>
	 * 
	 * @param other L'instance avec laquelle l'on compare le point
	 * 
	 * @return {@code true} si deux points sont égaux, {@code false} sinon.
	 * 
	 * @since 0.3.2.1
	 */
	@Override
	public boolean equals(final Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof Coordonnees)) {
			return false;
		}
		final Coordonnees coordonnees = (Coordonnees) other;
		return Math.abs(this.getAbscisse() - coordonnees.getAbscisse()) <= Coordonnees.EPSILON
				&& Math.abs(this.getOrdonnee() - coordonnees.getOrdonnee()) <= Coordonnees.EPSILON;
	}

	/**
	 * Fonction permettant d'obtenir la hashCode d'une {@code Coordonnees}.
	 * 
	 * @return Un {@code int} correspondan au hashCode de la {@code Coordonnees}.
	 * 
	 * @see Double#hashCode(double)
	 * 
	 * @since 0.3.2.1
	 */
	@Override
	public int hashCode() {
		return Double.hashCode(this.getAbscisse()) + Double.hashCode(this.getOrdonnee());
	}
}