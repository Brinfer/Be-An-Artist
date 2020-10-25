package fr.eseo.poo.projet.artiste.modele.formes;

import java.awt.Color;
import java.util.Locale;

import javax.swing.UIManager;

import fr.eseo.poo.projet.artiste.modele.Coloriable;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Classe {@code Forme} est la classe abstraitre de toute les formes, qui permet
 * de dimensioner et placer une forme.
 * <p>
 * Une forme est caractérisée par:
 * <ul>
 * <li>La <i>largeur</i> du rectangle englobant la forme.</li>
 * <li>La <i>hauteur</i> du rectangle englobant la forme.</li>
 * <li>La <i>position</i> du coin supérieur gauche du rectangle englobant la
 * forme (voir {@linkplain Coordonnees}).</li>
 * </ul>
 * <p>
 * L'ensemble de ces attributs sont modifiables.
 * <p>
 * Par défaut:
 * <ul>
 * <li>La largeur est initialisé à {@value #LARGEUR_PAR_DEFAUT}.</li>
 * <li>La hauteur est initialisé à {@value #HAUTEUR_PAR_DEFAUT}.</li>
 * <li>La position est initialisé à ({@value Coordonnees#ABSCISSE_PAR_DEFAUT} ,
 * {@value Coordonnees#ORDONNEE_PAR_DEFAUT}).</li>
 * </ul>
 * Il est possible de déterminer les coordonnées des autres coins du rectangles.
 * <p>
 * Une {@code Forme} peut être coloré.
 * 
 * @see Coordonnees
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.3
 * 
 * @version 0.3.5.1
 */
public abstract class Forme implements Coloriable {

	/**
	 * La valeur de type {@code double} par défaut de la largeur du rectangle
	 * englobant la forme.
	 * <p>
	 * De valeur {@value #LARGEUR_PAR_DEFAUT}.
	 * 
	 * @since 0.3.2.3
	 */
	public static final double LARGEUR_PAR_DEFAUT = 150;

	/**
	 * La valeur de type {@code double} par défaut de la hauteur du rectangle
	 * englobant la forme.
	 * <p>
	 * De valeur {@value #HAUTEUR_PAR_DEFAUT}.
	 * 
	 * @since 0.3.2.3
	 */
	public static final double HAUTEUR_PAR_DEFAUT = 100;

	/**
	 * Valeur {@code double} pour la comparaison entre deux autres {@code double}
	 * forme
	 * <p>
	 * La précision des comparaison est de {@value #EPSILON}.
	 * 
	 * @since 0.3.2.3
	 */
	public static final double EPSILON = 0.001;

	/**
	 * Valeur {@code Color} par défaut de la couleur de la forme.
	 * 
	 * @since 0.3.5.1
	 */
	public static final Color COULEUR_PAR_DEFAUT = UIManager.getColor("Panel.foreground");

	/**
	 * Attribut représentant la largeur du rectangle englobant la forme.
	 * <p>
	 * Cette largeur est modifiable.
	 * <p>
	 * Initialisé par défaut à {@value #LARGEUR_PAR_DEFAUT}.
	 * 
	 * @see #getLargeur()
	 * @see #setLargeur(double)
	 * @see #hauteur
	 * @see #LARGEUR_PAR_DEFAUT
	 * 
	 * @since 0.3.2.3
	 */
	private double largeur;

	/**
	 * Attribut représentant la hauteur du rectangle englobant la forme.
	 * <p>
	 * Cette hauteur est modifiable.
	 * <p>
	 * Initialisé par défaut à {@value #HAUTEUR_PAR_DEFAUT}.
	 * 
	 * @see #getHauteur()
	 * @see #setHauteur(double)
	 * @see #largeur
	 * @see #HAUTEUR_PAR_DEFAUT
	 * 
	 * @since 0.3.2.3
	 */
	private double hauteur;

	/**
	 * Attribut representant la position du coin superieur gauche du rectangle
	 * englobant la forme.
	 * <p>
	 * Cette possition est modifiable.
	 * <p>
	 * Initialisé par défaut à ({@value Coordonnees#ABSCISSE_PAR_DEFAUT} ,
	 * {@value Coordonnees#ORDONNEE_PAR_DEFAUT}), pour plus de détail se référer à
	 * la classe {@link Coordonnees}.
	 * 
	 * @see #getPosition()
	 * @see #setPosition(Coordonnees)
	 * @see Coordonnees
	 * 
	 * @since 0.3.2.3
	 */
	private Coordonnees position;

	/**
	 * Attribut représentant la couleur de la forme.
	 * <p>
	 * Cette couleur est modifiable.
	 * <p>
	 * Initialisé par défaut à {@valeu #COULEUR_PAR_DEFAUT}.
	 * 
	 * @see #COULEUR_PAR_DEFAUT
	 * @see Coloriable#getCouleur()
	 * @see Coloriable#setCouleur(Color)
	 * 
	 * @since 0.3.5.1
	 */
	private Color couleur;

	/**
	 * Constructeur d'une nouvellle {@code Forme}. Ce constructeur est le
	 * constructeur par défaut.
	 * <p>
	 * Les instance seront initialisee aux valeurs par defauts.
	 * 
	 * @see #hauteur
	 * @see #largeur
	 * @see #position
	 * @see #Forme(double, double)
	 * @see #Forme(Coordonnees)
	 * @see #Forme(Coordonnees, double, double)
	 * 
	 * @since 0.3.2.3
	 */
	public Forme() {
		this(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
	}

	/**
	 * Constructeur d'une nouvellle {@code Forme} a partir d'un point, d'une hauteur
	 * et d'une largeur.
	 * 
	 * @param position Une {@code Coordonnees} correspondant à la position du coin
	 *                 superieur gauche du rectangle englobant la forme.
	 * @param largeur  Un {@code double} correspondant à la largeur du rectangle
	 *                 englobant la forme.
	 * @param hauteur  Un {@code double} correspondant à la hauteur du rectangle
	 *                 englobant la forme.
	 * 
	 * @see #Forme()
	 * @see #Forme(Coordonnees)
	 * @see #Forme(double, double)
	 * 
	 * @since 0.3.2.3
	 * 
	 * @version 0.3.5.1
	 */
	public Forme(final Coordonnees position, final double largeur, final double hauteur) {
		this.position = position;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.couleur = COULEUR_PAR_DEFAUT;
	}

	/**
	 * Constructeur d'une nouvellle {@code Forme} a partir d'une largeur et d'une
	 * hauteur, la position etant initialise a partir des valeurs par defaut.
	 * 
	 * @param largeur Un {@code double} correspondant à la largeur du rectangle
	 *                englobant la forme.
	 * @param hauteur Un {@code double} correspondant à la hauteur du rectangle
	 *                englobant la forme.
	 * 
	 * @see #Forme()
	 * @see #Forme(Coordonnees)
	 * @see #Forme(Coordonnees, double, double)
	 * 
	 * @since 0.3.2.3
	 */
	public Forme(final double largeur, final double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
	}

	/**
	 * Constructeur d'une nouvellle {@code Forme} a partir d'un point, les autres
	 * attribut etant initialise a partir des valeurs par defauts.
	 * 
	 * @param position La {@code Coordonnees} correspondant à la position du coin
	 *                 superieur gauche du rectangle englobant la forme.
	 * 
	 * @see #Forme()
	 * @see #Forme(double, double)
	 * @see #Forme(Coordonnees, double, double)
	 * 
	 * @since 0.3.2.3
	 */
	public Forme(final Coordonnees position) {
		this(position, Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
	}

	/**
	 * Accesseur de la {@code position} du coin superieur gauche du rectangle
	 * englobant la forme.
	 * 
	 * @return Une {@code Coordonnees} correspondant à la position du coin superieur
	 *         gauche du rectangle englobant la forme.
	 * 
	 * @see #getCadreMaxX()
	 * @see #getCadreMaxY()
	 * @see #getCadreMinX()
	 * @see #getCadreMinY()
	 * @see #setPosition(Coordonnees)
	 * 
	 * @since 0.3.2.3
	 */
	public Coordonnees getPosition() {
		return this.position;
	}

	/**
	 * Mutateur de la {@code position} de la forme.
	 * 
	 * @param position Une {@code Coordonnees} correspondant à la nouvelle position
	 *                 de la forme.
	 * 
	 * @since 0.3.2.3
	 */
	public void setPosition(final Coordonnees position) {
		this.position = position;
	}

	/**
	 * Accesseur de la {@code largeur} du rectangle englobant la forme.
	 * 
	 * @return Le {@code double} correspondant à la largeur de la forme.
	 * 
	 * @see #getHauteur()
	 * @see #setLargeur(double)
	 * 
	 * @since 0.3.2.3
	 */
	public double getLargeur() {
		return this.largeur;
	}

	/**
	 * Mutateur de la {@code largeur} du rectangle englobant la forme.
	 * 
	 * @param largeur Un {@code double} correspondant à la nouvelle largeur de la
	 *                forme.
	 * 
	 * @see #setHauteur(double)
	 * @see #getLargeur()
	 * 
	 * @since 0.3.2.3
	 */
	public void setLargeur(final double largeur) {
		this.largeur = largeur;
	}

	/**
	 * Accesseur de la {@code hauteur} du rectangle englobant la forme.
	 * 
	 * @return Le {@code double} correspondant à la hauteur du rectangle englobant
	 *         la forme.
	 * 
	 * @see #getLargeur()
	 * @see #setLargeur(double)
	 * 
	 * @since 0.3.2.3
	 */
	public double getHauteur() {
		return this.hauteur;
	}

	/**
	 * Mutateur de la {@code hauteur} du rectangle englobant la forme.
	 * 
	 * @param hauteur Un {@code double} correspondant à la hauteur du rectangle
	 *                englobant la forme.
	 * 
	 * @see #setLargeur(double)
	 * @see #getHauteur()
	 * 
	 * @since 0.3.2.3
	 */
	public void setHauteur(final double hauteur) {
		this.hauteur = hauteur;
	}

	/**
	 * Mutateurs de l'abscisse et de l'ordonnée la {@code position}, a partir d'un
	 * vecteur de deplacement.
	 * 
	 * @param deltaX Un {@code double} correspondant à l'abscisse du vecteur, soit
	 *               la valeur du décallage pour l'abscisse.
	 * @param deltaY Un {@code double} correspondant à l'ordonnee du vecteur, soit
	 *               la valeur de décallage pour l'ordonnée.
	 * 
	 * @see Coordonnees#deplacerDe(double, double)
	 * @see #deplaceVers(double, double)
	 * 
	 * @since 0.3.2.3
	 */
	public void deplacerDe(final double deltaX, final double deltaY) {
		this.getPosition().deplacerDe(deltaX, deltaY);
	}

	/**
	 * Mutateur de l'abscisse et de l'ordonnée de la {@code position}, a partir de
	 * deux nouvelles coordonnees.
	 * 
	 * @param nouvelleAbscisse Un {@code double} correspondant à la nouvelle
	 *                         abscisse du point.
	 * @param nouvelleOrdonnee Un {@code double} correspondant à la nouvelle
	 *                         ordonnees du point.
	 * 
	 * @see Coordonnees#deplacerVers(double, double)
	 * @see #deplacerDe(double, double)
	 * 
	 * @since 0.3.2.3
	 */
	public void deplacerVers(final double nouvelleAbscisse, final double nouvelleOrdonnee) {
		this.getPosition().deplacerVers(nouvelleAbscisse, nouvelleOrdonnee);
	}

	/**
	 * Accesseur de l'abcisse du coin superieur gauche du rectangle qui englobe la
	 * forme.
	 * 
	 * @return Un {@code double} correspondant à l'abcisse du coin superieur gauche
	 *         du rectangle qui englobe la forme.
	 * 
	 * @see #getCadreMinY()
	 * @see #getCadreMaxX()
	 * @see #getCadreMaxY()
	 * @see #getPosition()
	 * 
	 * @since 0.3.2.3
	 */
	public double getCadreMinX() {
		return Math.min(this.getPosition().getAbscisse(), this.getPosition().getAbscisse() + this.getLargeur());
	}

	/**
	 * Accesseur de l'ordonnee du coin superieur gauche du rectangle qui englobe la
	 * forme.
	 * 
	 * @return Un {@code double} correspondant à l'ordonnee du coin superieur gauche
	 *         du rectangle qui englobe la forme.
	 * 
	 * @see #getCadreMinX()
	 * @see #getCadreMaxX()
	 * @see #getCadreMaxY()
	 * @see #getPosition()
	 * 
	 * @since 0.3.2.3
	 */
	public double getCadreMinY() {
		return Math.min(this.getPosition().getOrdonnee(), this.getPosition().getOrdonnee() + this.getHauteur());
	}

	/**
	 * Accesseur de l'abcisse du coin inferieur droit du rectangle qui englobe la
	 * forme.
	 * 
	 * @return Un {@code double} correspondant à l'abcisse du coin inferieur droit
	 *         du rectangle qui englobe la forme
	 * 
	 * @see #getCadreMinX()
	 * @see #getCadreMinY()
	 * @see #getCadreMaxY()
	 * @see #getPosition()
	 * 
	 * @since 0.3.2.3
	 */
	public double getCadreMaxX() {
		return Math.max(this.getPosition().getAbscisse(), this.getPosition().getAbscisse() + this.getLargeur());
	}

	/**
	 * Acccesseur de l'ordonnee du coin inferieur droit du rectangle qui englobe la
	 * forme.
	 * 
	 * @return Un {@code double} correspondant à l'ordonnee du coin inferieur droit
	 *         du rectangle qui englobe la forme.
	 * 
	 * @see #getCadreMinX()
	 * @see #getCadreMinY()
	 * @see #getCadreMaxX()
	 * @see #getPosition()
	 * 
	 * @since 0.3.2.3
	 */
	public double getCadreMaxY() {
		return Math.max(this.getPosition().getOrdonnee(), this.getPosition().getOrdonnee() + this.getHauteur());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @since 0.3.5.1
	 */
	@Override
	public Color getCouleur() {
		return this.couleur;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @since 0.3.5.1
	 */
	@Override
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * La description est de la forme:
	 * {@code  couleur = R<code couleur rouge>,G<code couleur vert>,B<code couleur bleu>}
	 * <p>
	 * Dans le cas où la {@code Locale} de l'ordinateur est française, alors le
	 * {@code G} sera remplacer par {@code V}.
	 * 
	 * @since 0.3.5.1
	 */
	@Override
	public String descriptionCouleur() {
		char lettreColorGreen = 'G';
		if (Locale.getDefault().getLanguage().equals("fr")) {
			lettreColorGreen = 'V';
		}
		return " couleur = R" + this.getCouleur().getRed() + ',' + lettreColorGreen + this.getCouleur().getGreen()
				+ ",B" + this.getCouleur().getBlue();
	}

	/**
	 * Fonction permettant de comparer si deux {@code Formes} sont identiques, à
	 * {@value #EPSILON} prêt.
	 * <p>
	 * <ul>
	 * <li>Les deux {@code Formes} sont identiques:</li>
	 * <ul>
	 * <li>si elles onts la même position, la même largeur et la même hauteur.</li>
	 * <li>si la deuxieme instance testé est la testé est la également
	 * premiere.</li>
	 * </ul>
	 * <li>Les deux {@code Formes} sont différentes:</li>
	 * <ul>
	 * <li>si la deuxieme instance testé n'est pas de la même instance que la
	 * première.</li>
	 * <li>si deux {@code Formes} n'ont pas la même position, largeur ou
	 * hauteur.</li>
	 * </ul>
	 * </ul>
	 * 
	 * @param other L'instance avec laquelle l'on compare la forme.
	 * 
	 * @return {@code true} si deux {@code Formes} sont identiques, {@code false}
	 *         sinon.
	 * 
	 * 
	 * @since 0.3.3.6
	 */
	@Override
	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (!(other instanceof Forme)) {
			return false;
		}
		Forme forme = (Forme) other;
		return Math.abs(this.getLargeur() - forme.getLargeur()) <= Forme.EPSILON
				&& Math.abs(this.getHauteur() - forme.getHauteur()) <= Forme.EPSILON
				&& this.getPosition().equals(forme.getPosition());
	}

	/**
	 * Fonction permettant d'obtenir la hashCode d'une {@code Forme}.
	 * 
	 * @return Un {@code int} correspondan au hashCode de la {@code Forme}.
	 * 
	 * @see Double#hashCode(double)
	 * @see Coordonnees#hashCode()
	 * 
	 * @since 0.3.3.6
	 */
	@Override
	public int hashCode() {
		return this.getPosition().hashCode() + Double.hashCode(this.getLargeur()) + Double.hashCode(this.getHauteur());
	}

	/**
	 * Accesseur de la surface de la forme.
	 * 
	 * @return Un {@code double} correspondant à la surface de la forme.
	 * 
	 * @see #perimetre()
	 * 
	 * @since 0.3.2.3
	 */
	public abstract double aire();

	/**
	 * Accesseur du périmètre de la forme.
	 * 
	 * @return Un {@code double} correspondant à le périmètre de la forme.
	 * 
	 * @see #aire()
	 * 
	 * @since 0.3.2.3
	 */
	public abstract double perimetre();

	/**
	 * Fonction permettant de savoir si un point se trouve à l'intérieur de la
	 * forme.
	 *
	 * @param coordonnees Un {@code Coordonnees} correspondant au point dont on veut
	 *                    savoir s'il se trouve dans la forme.
	 * 
	 * @return {@code true} si le point est dans la forme, {@code false} sinon.
	 * 
	 * @since 0.3.2.8
	 */
	public abstract boolean contient(Coordonnees coordonnees);
}