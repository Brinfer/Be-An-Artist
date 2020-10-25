package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

/**
 * Classe {@code Etoile} représentant une etoile.
 * <p>
 * Une étoile est défini par :
 * <ul>
 * <li>Son nombre de branche.</li>
 * <li>L'angle entre ses branches</li>
 * <li>La lognueur de ses branches</li>
 * <li>Une <i>position</i> correspondant au coin supérieur gauche du carré
 * l'englobant.</li>
 * <li>Une <i>largeur</i> et une <i>hauteur</i> correspondants à celles du carré
 * l'englobant.</li>
 * </ul>
 * Ces attributs sont modifiable.
 * <p>
 * La <i>hauteur</i> et la <i>largeur</i> ne peuvent être inférieur ou égale à
 * 0.
 * <p>
 * Par défaut:
 * <ul>
 * <li>La <i>largeur</i> et la <i>hauteur</i> sont initialisés à
 * {@value Forme#LARGEUR_PAR_DEFAUT}.</li>
 * <li>La <i>position</i> est initialisé à
 * ({@value Coordonnees#ABSCISSE_PAR_DEFAUT} ,
 * {@value Coordonnees#ORDONNEE_PAR_DEFAUT}).</li>
 * </ul>
 * <p>
 * Pour d'information se référer à la classe {@link Forme} et la classe
 * {@link Coordonnees}.
 * <p>
 * Il est possible de:
 * <ul>
 * <li>connaitre l'aire de l'étoile.</li>
 * <li>connaitre le périmètre de l'étoile</li>
 * <li>savoir si un point se trouve sur l'étoile.</li>
 * <li>de changer de couleur l'étoile</li>
 * <li>remplir d'une couleur l'étoile</li>
 * </ul>
 * 
 * @see Forme
 * @see Coordonnees
 * 
 * @author Brinfer
 * 
 * @since 0.3.7.1
 * 
 * @version 0.3.7.1
 */
public class Etoile extends Forme implements Remplissable {

	/**
	 * Constante de la classe {@code Etoile}.
	 * <p>
	 * Il s'agit du nombre de branche pardéfaut pour une étoile, elle est de
	 * {@value}
	 * 
	 * @since 0.3.7.1
	 */
	public static final int NOMBRE_BRANCHES_PAR_DEFAUT = 5;

	/**
	 * Constante de la classe {@code Etoile}.
	 * <p>
	 * Il s'agit de l'angle par défaut de la premiere branche de l'étoile (ne
	 * radian).
	 * <p>
	 * Par défaut la velaur est de {@value} rad soit {@code 242°}.
	 * 
	 * @since 0.3.7.1
	 */
	public static final double ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT = Math.PI / 2;

	/**
	 * Constante de la classe {@code Etoile}.
	 * <p>
	 * Il s'agit du pourcentage la longueur du creux entre les branches et le rayon
	 * du cercle englobant l'étoile par défaut.
	 * <p>
	 * Par défaut le pourcentage est de {@value}.
	 * 
	 * @since 0.3.7.1
	 */
	public static final double LONGUEUR_BRANCHE_PAR_DEFAUT = 0.75;

	/**
	 * Attribue de la classe {@code Etoile}.
	 * <p>
	 * Il s'agit de la liste des sommets des branches de l'étoile.
	 * 
	 * @see #getCoordonnees()
	 * @see #getCoordonneesPolygone()
	 * @see #setNombreBranches(int)
	 * 
	 * @since 0.3.7.1
	 */
	private List<Coordonnees> coordonnees;

	/**
	 * Attribue de la classe {@code Etoile}.
	 * <p>
	 * Il s'agit de la liste des sommets du polynomes de l'étoile.
	 * 
	 * @see #getCoordonneesPolygone()
	 * @see #getCoordonnees()
	 * @see #setNombreBranches(int)
	 * 
	 * @since 0.3.7.1
	 */
	private List<Coordonnees> coordonneesPolygone;

	/**
	 * Attribue de la classe {@code Etoile} correspondant à l'angle entre
	 * l’horizontale et la première branche.
	 * <p>
	 * Cet angle est en <i>radian</i>.
	 * 
	 * @see #getAnglePremiereBranche()
	 * @see #setAnglePremiereBranche(double)
	 * @see #ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT
	 * 
	 * @since 0.3.7.1
	 */
	private double anglePremiereBranche;

	/**
	 * Attribue de la classe {@code Etoile} correspondant au rapport entre le rayon
	 * du cercle englobant l'étoile et le creux entre les branches.
	 * 
	 * @see #getLongueurBranche()
	 * @see #setLongueurBranche(double)
	 * @see #LONGUEUR_BRANCHE_PAR_DEFAUT
	 * 
	 * @since 0.3.7.1
	 */
	private double longueurBranche;

	/**
	 * Attribut permettant de sauvegarder l'état du remplissage de l'{@code Etoile}.
	 * 
	 * @since 0.3.7.1
	 */
	private boolean estRempli;

	/**
	 * Constructeur par défaut d'une nouvelle {@code Etoile}.
	 * <p>
	 * L'ensemble des attribut de la classe sont alors initialisé aux valeurs par
	 * défaut.
	 * 
	 * @see #NOMBRE_BRANCHES_PAR_DEFAUT
	 * @see #ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT
	 * @see #LONGUEUR_BRANCHE_PAR_DEFAUT
	 * @see this#LARGEUR_PAR_DEFAUT
	 * @see #Etoile(Coordonnees)
	 * @see #Etoile(Coordonnees, double)
	 * @see #Etoile(Coordonnees, double, int, double, double)
	 * @see #Etoile(double)
	 * @see Coordonnees()
	 * 
	 * @since 0.3.7.1
	 */
	public Etoile() {
		this(Forme.LARGEUR_PAR_DEFAUT);
	}

	/**
	 * Constructeur par d'une nouvelle {@code Etoile}.
	 * <p>
	 * Le diamètre du cercle englobant l'étoile est définie à la valeur donné en
	 * paramètre. L'ensemble des autres attribut de la classe sont alors initialisé
	 * aux valeurs par défaut.
	 * 
	 * @param taille Un {@code double} corresponandant au diamètre du cercle
	 *               englobant l'étoile.
	 * 
	 * @throws IllegalArgumentException Si la taille est inférieurs ou égales à
	 *                                  <i>0<i/>.
	 * 
	 * @see #NOMBRE_BRANCHES_PAR_DEFAUT
	 * @see #ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT
	 * @see #Etoile(Coordonnees)
	 * @see #Etoile(Coordonnees, double)
	 * @see #Etoile(Coordonnees, double, int, double, double)
	 * @see #Etoile()
	 * @see Coordonnees()
	 * 
	 * @since 0.3.7.1
	 */
	public Etoile(final double taille) {
		this(new Coordonnees(), taille);
	}

	/**
	 * Constructeur par d'une nouvelle {@code Etoile}.
	 * <p>
	 * La possiton du sommet de la première branche de l'étoile est définie à la
	 * valeur donné en paramètre. L'ensemble des autres attribut de la classe sont
	 * alors initialisé aux valeurs par défaut.
	 * 
	 * @param coordonnees Une {@code Coordonnees} correspondant à la possiton du
	 *                    sommet de la première branche de l'étoile.
	 * 
	 * @see #NOMBRE_BRANCHES_PAR_DEFAUT
	 * @see #ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT
	 * @see #LONGUEUR_BRANCHE_PAR_DEFAUT
	 * @see this#LARGEUR_PAR_DEFAUT
	 * @see #Etoile(double)
	 * @see #Etoile(Coordonnees, double)
	 * @see #Etoile(Coordonnees, double, int, double, double)
	 * @see #Etoile()
	 * 
	 * @since 0.3.7.1
	 */
	public Etoile(final Coordonnees position) {
		this(position, Forme.LARGEUR_PAR_DEFAUT);
	}

	/**
	 * Constructeur par d'une nouvelle {@code Etoile}.
	 * <p>
	 * La possiton du sommet de la première branche de l'étoile est définie à la
	 * valeur donné en paramètre, de même que Le diamètre du cercle englobant
	 * l'étoile. L'ensemble des autres attribut de la classe sont alors initialisé
	 * aux valeurs par défaut.
	 * 
	 * @param coordonnees Une {@code Coordonnees} correspondant à la possiton du
	 *                    sommet de la première branche de l'étoile.
	 * @param taille      Un {@code double} corresponandant au diamètre du cercle
	 *                    englobant l'étoile.
	 * 
	 * @throws IllegalArgumentException Si la taille est inférieurs ou égales à 0.
	 * 
	 * @see #NOMBRE_BRANCHES_PAR_DEFAUT
	 * @see #ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT
	 * @see #LONGUEUR_BRANCHE_PAR_DEFAUT
	 * @see #Etoile(double)
	 * @see #Etoile(Coordonnees)
	 * @see #Etoile(Coordonnees, double, int, double, double)
	 * @see #Etoile()
	 * 
	 * @since 0.3.7.1
	 */
	public Etoile(final Coordonnees position, final double taille) {
		this(position, taille, Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, Etoile.ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT,
				Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT);
	}

	/**
	 * Constructeur par d'une nouvelle {@code Etoile}.
	 * <p>
	 * L'ensemble des attributs de l'étoiles sont définit avec les paramètre donnés.
	 * <p>
	 * <ul>
	 * <li>{@code taille} doit être supérieiur à <i>0</i>.</li>
	 * <li>{@code nombreBranches} doit être compris entre <i>3</i> et
	 * <i>15</i>.</li>
	 * <li>{@code anglePremiereBranche} doit être compris entre <i>-π</i> et
	 * <i>π</i>.</li>
	 * <li>{@code longueurBranche} doit être compris entre <i>0</i> et
	 * <i>1</i>.</li>
	 * </ul>
	 * 
	 * @param coordonnees          Une {@code Coordonnees} correspondant à la
	 *                             possiton du sommet de la première branche de
	 *                             l'étoile.
	 * @param taille               Un {@code double} corresponandant au diamètre du
	 *                             cercle englobant l'étoile.
	 * @param nombreBranches       Un {@code int} correspndant au nombre de branche
	 *                             de l'étoile.
	 * @param anglePremiereBranche Un {@code double} correspondant à l'angle en
	 *                             <i>radiant</i> formé par la premièr branche.
	 * @param longueurBranche      Un {@code double} correspondant au rapport de la
	 *                             longeur du creux entre les branches et le rayon
	 *                             du cercle englobant l'étoile.
	 * 
	 * @throws IllegalArgumentException Si les dimensions données ne respectent pas
	 *                                  toutes les conditions.
	 * 
	 * @see #Etoile(double)
	 * @see #Etoile(Coordonnees)
	 * @see #Etoile(Coordonnees, double)
	 * @see #Etoile()
	 * @see this#this(Coordonnees, double, double)
	 * 
	 * @since 0.3.7.1
	 */
	public Etoile(final Coordonnees position, final double taille, final int nombreBranches,
			final double anglePremiereBranche, final double longueurBranche) {
		super(position);
		this.estRempli = false;

		this.coordonnees = new ArrayList<Coordonnees>();
		this.coordonneesPolygone = new ArrayList<Coordonnees>();

		this.setLongueurBranche(longueurBranche);
		this.setHauteur(taille);
		this.setAnglePremiereBranche(anglePremiereBranche);
		this.setNombreBranches(nombreBranches);
	}

	/**
	 * Fonction permettant de calculer la position des sommets des branches de
	 * l'étoile.
	 * <p>
	 * La position des points est calculé à partit d'une rotation suivit d'une
	 * translation depuis le centre du cercle du cercle englobant l'étoile.
	 * <p>
	 * Pour se faire on utilise les formules suivantes:
	 * <ul>
	 * <li>{@code x' = cos(α) * x - sin(α) * y}</li>
	 * <li>{@code y' = sin(α) * x + cos(α) * y}</li>
	 * </ul>
	 * où:
	 * <ul>
	 * <li><i>x</i> et <i>y</i> sont les coordonnées du point.</li>
	 * <li><i>x'</i> et <i>y'</i> sont les coordonnées du point suite à la
	 * rotation.</li>
	 * <li><i>α</i> est l'angle de rotation.</li>
	 * </ul>
	 * On effectue une première rotation <i>α</i> suivant l'angle de la première
	 * branche pour le premier point. On incrémente ensuite <i>α</i> de l'angle
	 * entre les branches
	 * <p>
	 * La valeur de l'angle <i>α</i> est obtenue grâce à la formule:
	 * <li>{@code α = (2π / nombreDeBranche) * numéroDeLaBranche + anglePremièreBranche}.</li>
	 * 
	 * @see #calculPositionPolynome()
	 * @see #getCoordonnees()
	 * 
	 * @since 0.3.7.1
	 */
	private void calculPositionSommet() {
		final int nombreBranches = this.getNombreBranches();
		this.getCoordonnees().clear();

		for (int indice = 0; indice < nombreBranches; indice++) {
			final double alpha = this.getAnglePremiereBranche() - (2 * Math.PI / nombreBranches) * indice;
			final double xPrime = (super.getCadreMaxX() + super.getCadreMinX()) / 2
					+ Math.cos(alpha) * super.getHauteur() / 2;
			final double yPrime = (super.getCadreMaxY() + super.getCadreMinY()) / 2
					- Math.sin(alpha) * super.getHauteur() / 2;
			this.getCoordonnees().add(new Coordonnees(xPrime, yPrime));
		}

		this.calculPositionPolynome();
	}

	/**
	 * Fonction permettant de calculer la position des sommets du polynôme composant
	 * le coeur de l'étoile.
	 * <p>
	 * Le calcul est très similaire à celui permettant d'obtenir la position des
	 * sommets des branches.
	 * 
	 * @see #calculPositionSommet()
	 * @see #getCoordonneesPolygone()
	 * 
	 * @since 0.3.7.1
	 */
	private void calculPositionPolynome() {
		this.getCoordonneesPolygone().clear();

		for (int indice = 0; indice < this.getNombreBranches(); indice++) {
			final double alpha = this.getAnglePremiereBranche()
					- (Math.PI / this.getNombreBranches()) * (2 * indice - 1);
			final double xPrime = (super.getCadreMaxX() + super.getCadreMinX()) / 2
					+ Math.cos(alpha) * super.getHauteur() * (1 - this.getLongueurBranche()) / 2;
			final double yPrime = (super.getCadreMaxY() + super.getCadreMinY()) / 2
					- Math.sin(alpha) * super.getHauteur() * (1 - this.getLongueurBranche()) / 2;
			this.getCoordonneesPolygone().add(new Coordonnees(xPrime, yPrime));
		}
	}

	/**
	 * Fonction permettant de savoir si un point donné est un des points formant
	 * l'étoile.
	 * 
	 * @param point L& {@code Coordonnees} que l'on veut tester.
	 * 
	 * @return {@code true} si le point est l'un de ceux formant l'étoile.
	 * 
	 * @since 0.3.7.1
	 */
	private boolean estPointDeEtoile(Coordonnees point) {
		return this.getCoordonnees().contains(point) || this.getCoordonneesPolygone().contains(point);
	}

	/**
	 * Fonction permettant de récupper les trois coordonnées du triangle composants
	 * une branche de l'étoile.
	 * 
	 * @param indiceBranche Un {@code int} correspondant à l'indice de la branche
	 *                      dont on veut le triangle.
	 * @return Un tableau de {@linkplain Coordonnees} du triangle composant la
	 *         branche.
	 * 
	 * @since 0.3.7.1
	 */
	public Coordonnees[] getCoordonneesTriangleBranche(int indiceBranche) {
		Coordonnees[] tab = new Coordonnees[3];
		tab[1] = this.getCoordonnees().get(indiceBranche);
		tab[0] = this.getCoordonneesPolygone().get(indiceBranche);
		if (indiceBranche + 1 > this.getNombreBranches() - 1) {
			tab[2] = this.getCoordonneesPolygone().get(0);
		} else {
			tab[2] = this.getCoordonneesPolygone().get(indiceBranche + 1);
		}
		return tab;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Cette modificatin entraine un recalcul des positions des sommets des branches
	 * de l'étoile.
	 * 
	 * @throws IllegalArgumentException Si la hauteur est inférieurs ou égales à 0.
	 * 
	 * @see #setLargeur(double)
	 * 
	 * @since 0.3.7.1
	 */
	@Override
	public void setHauteur(final double hauteur) {
		if (hauteur > 0) {
			super.setHauteur(hauteur);
			super.setLargeur(hauteur);
			this.calculPositionSommet();
		} else {
			throw new IllegalArgumentException("La hauteur et la hauteur de l'Etoile doivent être positive");
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws IllegalArgumentException Si la largeur est inférieurs ou égales à 0.
	 * 
	 * @see #setHauteur(double)
	 * 
	 * @since 0.3.7.1
	 */
	@Override
	public void setLargeur(final double largeur) {
		this.setHauteur(largeur);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @since 0.3.7.1
	 */
	@Override
	public void setPosition(final Coordonnees position) {
		super.setPosition(position);
		this.calculPositionSommet();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @since 0.3.7.1
	 */
	@Override
	public void deplacerDe(final double deltaX, final double deltaY) {
		this.setPosition(new Coordonnees(super.getPosition().getAbscisse() + deltaX,
				super.getPosition().getOrdonnee() + deltaY));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @since 0.3.7.1
	 */
	@Override
	public void deplacerVers(final double nouvelleAbscisse, final double nouvelleOrdonnee) {
		this.setPosition(new Coordonnees(nouvelleAbscisse, nouvelleOrdonnee));
	}

	/**
	 * Mutateur du nombre de branches d'une étoile.
	 * 
	 * @param nombreBranches Un {@code int} correspondant au nouveau nombre de
	 *                       branche de l'étoile.
	 * 
	 * @throws IllegalArgumentException Si le nombre de branches est supérieur à 15
	 *                                  ou inférieur à 3.
	 * 
	 * @see #getAnglePremiereBranche()
	 * 
	 * @since 0.3.7.1
	 */
	public void setNombreBranches(final int nombreBranches) {
		if (nombreBranches >= 3 && nombreBranches <= 15) {
			this.coordonnees = new ArrayList<Coordonnees>(Arrays.asList(new Coordonnees[nombreBranches]));
			this.coordonneesPolygone = new ArrayList<Coordonnees>(Arrays.asList(new Coordonnees[nombreBranches]));
			this.calculPositionSommet();
		} else {
			throw new IllegalArgumentException("Le nombre de branche doit être compris entre 3 et 15");
		}
	}

	/**
	 * Mutatueur du rapport entre le rayon du cercle englobant l'étoile et de la
	 * longueur du creux entre les branches. La position des sommets des branches ne
	 * doit pas varier.
	 * 
	 * @param longueur Un {@code double} correspondant au nouveau rapport entre le
	 *                 rayon du cercle englobant l'étoile et de la longueur du creux
	 *                 entre les branches.7
	 * 
	 * @throws IllegalArgumentException Si la longueur est inférieur à <i>0</i> ou
	 *                                  supérieur à <i>1</i>.
	 * 
	 * @see #getLongueurBranche()
	 * 
	 * @since 0.3.7.1
	 */
	public void setLongueurBranche(final double longueur) {
		if (longueur >= 0 && longueur <= 1) {
			this.longueurBranche = longueur;
			this.calculPositionPolynome();
		} else {
			throw new IllegalArgumentException("La longueur des branches doivent être comprise entre 0 et 1.");
		}
	}

	/**
	 * Mutateur de l'angle formé entre l'horizontale et la première branche de
	 * l'étoile.
	 * <p>
	 * La valeur donné est en radiant
	 * 
	 * @return Un {@code double} correspondant au nouvel angle formé entre
	 *         l'horizontale et la première branche de l'étoile.
	 * 
	 * @throws IllegalArgumentException Si l'angle est inférieur à <i>-π</i> ou
	 *                                  supérieur à <i>π</i>.
	 * 
	 * @see #getAnglePremiereBranche()
	 * 
	 * @since 0.3.7.1
	 */
	public void setAnglePremiereBranche(final double angle) {
		if (angle >= -Math.PI && angle <= Math.PI) {
			this.anglePremiereBranche = angle;
			this.calculPositionSommet();
		} else {
			throw new IllegalArgumentException("L'angle de la première branche doit être compris entre -π et π");
		}

	}

	/**
	 * Accesseur de la liste des sommets de l'étoile.
	 * 
	 * @return Une {@code List<Coordonnees} correspondant aux sommets de l'étoile.
	 * 
	 * @since 0.3.7.1
	 */
	public List<Coordonnees> getCoordonnees() {
		return this.coordonnees;
	}

	/**
	 * Accesseur de la liste des sommets du polynome de l'étoile.
	 * 
	 * @return Une {@code List<Coordonnees} correspondant aux sommets du polynome de
	 *         l'étoile.
	 * 
	 * @since 0.3.7.1
	 */
	public List<Coordonnees> getCoordonneesPolygone() {
		return this.coordonneesPolygone;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @since 0.3.7.1
	 */
	@Override
	public void setRempli(final boolean modeRemplissage) {
		this.estRempli = modeRemplissage;
	}

	/**
	 * Fonction permettant de connaitre le nombre de branche d'une étoile.
	 * <p>
	 * Le nombre de branche d'une étoile correspond aussi au nombre de sommet.
	 * 
	 * @see #getCoordonnees()
	 * 
	 * @since 0.3.7.1
	 */
	public int getNombreBranches() {
		return this.getCoordonnees().size();
	}

	/**
	 * Accesseurs de la longueur des branches de l'étoile.
	 * 
	 * @return Un {@code double} compris entre <i>0</i> et <i>1</i> correspondant à
	 *         à la longueur des branches de l'étoile par rapport au raoyon du
	 *         cercle englobant l'étoile.
	 * 
	 * @see #setLongueurBranche(double)
	 * 
	 * @since 0.3.7.1
	 */
	public double getLongueurBranche() {
		return this.longueurBranche;
	}

	/**
	 * Accesseur de l'angle formé entre l'horizontale et la première branche de
	 * l'étoile.
	 * <p>
	 * La valeur retourné est en radiant
	 * 
	 * @return Un {@code double} correspondant à l'angle formé entre l'horizontale
	 *         et la première branche de l'étoile.
	 * 
	 * @see #setAnglePremiereBranche(double)
	 * 
	 * @since 0.3.7.1
	 */
	public double getAnglePremiereBranche() {
		return this.anglePremiereBranche;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @since 0.3.7.1
	 */
	@Override
	public boolean estRempli() {
		return this.estRempli;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Le calcul de l'aire d'une étoile se fait en deux étapes:
	 * <ul>
	 * <li>On calcule l'aire du polynôme régulier composant le coeur de l'étoile
	 * (sont nombre de coté correspont au nombre de branche).</li>
	 * <li>On calcule l'aire d'une branche qui est un triangle isocéle.</li>
	 * </ul>
	 * <p>
	 * Le calcul de l'aire d'un polynôme régulier se fait avec la formule
	 * {@code Aire = a*p / 2} où:
	 * <ul>
	 * <li><i>a</i> est l'apothène du polynôme</li>
	 * <li><i>p</i> est le périmètre du polynôme</li>
	 * </ul>
	 * <p>
	 * L'aire de l'étoile est la somme de l'aire du polynôme et du produit de l'aire
	 * du triangle, faisant une branche, par le nombre de branche.
	 * 
	 * @since 0.3.7.1
	 */
	@Override
	public double aire() {
		final double cotePoly = this.getCoordonneesPolygone().get(0).distanceVers(this.getCoordonneesPolygone().get(1));
		// Theoreme de Pythagore
		final double apothene = Math.sqrt(
				Math.pow((1 - this.getLongueurBranche()) * super.getHauteur() / 2, 2) - Math.pow(cotePoly / 2, 2));
		final double airePoly = apothene * cotePoly * 0.5 * this.getNombreBranches();
		final double hauteur = super.getHauteur() * 0.5 - apothene;
		final double aireBranche = hauteur * cotePoly * 0.5;

		return airePoly + this.getNombreBranches() * aireBranche;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @since 0.3.7.1
	 */
	@Override
	public double perimetre() {
		return 2 * this.getNombreBranches()
				* this.getCoordonnees().get(0).distanceVers(this.getCoordonneesPolygone().get(0));
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Méthode utilisé ici est celle du ray-casting. Le principe est de compter
	 * combien un rayon (une demie-droite d'origine le point mis en paramètre) coupe
	 * une forme fermer.
	 * <p>
	 * Une autre méthode est de calculer le nombre d'enroulement de la forme autour
	 * du point. Bien que plus précise cette méthode, la Nonzero-rule, demande
	 * beaucoup plus de ressource car demande des calculs trigonométrique et est
	 * plus compliqué à mettre en place.
	 * 
	 * @param point La{@code Coordonnees} dont on veut savoir s'il est ou non dans
	 *              l'étoile.
	 * 
	 * @return {@code true} si le point est dans l'étoile
	 * 
	 * @see <a href=
	 *      "https://fr.qwe.wiki/wiki/Point_in_polygon#Ray_casting_algorithm">Wiki -
	 *      Point dans le Polygone</a>
	 * @see <a href=
	 *      "https://www.tutorialspoint.com/computer_graphics/polygon_filling_algorithm.htm">TutorialsPoint
	 *      - Polygon Filling Algorithm</a>
	 * 
	 * 
	 * @since 0.3.7.1
	 */
	@Override
	public boolean contient(final Coordonnees point) {

		// Si le point tester est l'un des sommets de l'etoile alors il est dedans.
		if (this.estPointDeEtoile(point)) {
			return true;
		}

		// Si "dedans" est inversé un nombre impair de fois alors le rayon coupe un
		// nombre impair de fois l'etoile, donc le point est à l'intérieur
		boolean dedans = false;

		for (int i = 0; i < this.getNombreBranches(); i++) {
			final Coordonnees[] coordonneesTriangle = this.getCoordonneesTriangleBranche(i);
			final Coordonnees sommetBranche = coordonneesTriangle[1];
			for (int j = 0; j < 3; j += 2) {
				Coordonnees sommetPoly = coordonneesTriangle[j];

				// Le point tester doit être dans le domaine des ordonnées du segment.
				// Cela permet de ne pas faire les calculs qui suivent pour determiner un point
				// qui ne sera pas au final sur le segment.
				if ((sommetBranche.getOrdonnee() > point.getOrdonnee()) != (sommetPoly.getOrdonnee() > point
						.getOrdonnee())) {

					// Determination de l'équation de la droite sous la forme y = ax + b.
					final double a = (sommetPoly.getOrdonnee() - sommetBranche.getOrdonnee())
							/ (sommetPoly.getAbscisse() - sommetBranche.getAbscisse());
					final double b = sommetPoly.getOrdonnee() - a * sommetPoly.getAbscisse();

					// Determination du point d'intersection des droites, si la pente est nul, alors
					// xC = infinty, aucune exception de soulevé.
					final double xC = -(b - point.getOrdonnee()) / a;

					// Le rayon est une demie droite dans le sens positif de l'abscisse donc les
					// points d'intersection à gauche du point tester ne sont pas à prendre en
					// compte.
					if (xC >= point.getAbscisse() - Forme.EPSILON) {
						// Si le point d'intersection est le point tester alors il est dedans.
						if (new Coordonnees(xC, point.getOrdonnee()).equals(point)) {
							return true;
						}
						dedans = !dedans;
					}
				}
			}
		}
		return dedans;
	}

	/**
	 * Fonction renvoyant une descripsion de l'étoile sous la this :
	 * <p>
	 * {@code [Etoile<-Rempli>] pos : (<abscisse>), <ordonnée>) dim <largeur> x <hauteur> 
	 * périmètre : <perimetre> aire : <aire>, couleur = <couleur RGB>}.
	 * 
	 * @return Une {@code String}, correspondant à la description de l'
	 *         {@code Etoile}.
	 * 
	 * @see Coordonnees#toString()
	 * 
	 * @since 0.3.2.5
	 * 
	 * @version 0.3.7.1
	 */
	@Override
	public String toString() {
		final DecimalFormat formater = new DecimalFormat("0.0#");
		return '[' + getClass().getSimpleName() + this.descriptionRemplissage() + "] : pos "
				+ this.getPosition().toString() + " dim " + formater.format(this.getLargeur()) + " x "
				+ formater.format(this.getHauteur()) + " périmètre : " + formater.format(this.perimetre()) + " aire : "
				+ formater.format(this.aire()) + super.descriptionCouleur();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return {@code "-Rempli"} si l'étoile est rempli , rien sinon.
	 * 
	 * @since 0.3.7.1
	 */
	@Override
	public String descriptionRemplissage() {
		if (this.estRempli) {
			return "-Rempli";
		} else {
			return "";
		}
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * A cela il faut comparer en plus :
	 * <ul>
	 * <li>L'anle de la première branche modulo 2π.</li>
	 * <li>Le nombre de branches.</li>
	 * <li>La longueur des branches.</li>
	 * </ul>
	 * 
	 * @see Forme#equals(Object)
	 * 
	 * @since 0.3.7.1
	 */
	@Override
	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (!(other instanceof Etoile)) {
			return false;
		}
		Etoile etoile = (Etoile) other;
		return super.equals(etoile)
				&& Math.abs(etoile.getAnglePremiereBranche() - this.getAnglePremiereBranche()) <= Forme.EPSILON
				&& etoile.getNombreBranches() == this.getNombreBranches()
				&& Math.abs(etoile.getLongueurBranche() - this.getLongueurBranche()) <= Forme.EPSILON;
	}
}