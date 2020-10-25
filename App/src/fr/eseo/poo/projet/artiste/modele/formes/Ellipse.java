package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

/**
 * Classe {@code Ellipse} représentant une ellipse.
 * <p>
 * Une ellipse est caractérisé part:
 * <ul>
 * <li>Une <i>position</i> correspondant au coin supérieur gauche du rectangle
 * l'neglobant.</li>
 * <li>Une <i>hauteur</i> correspondant à celle du rectangle l'englobant.</li>
 * <li>Une <i>largeur</i> correspondant à celle du rectangle l'englobant.</li>
 * </ul>
 * <p>
 * Ces attributs peuvent être modifiés.
 * <p>
 * La <i>hauteur</i> et la <i>largeur</i> ne peuvent être inférieur ou égale à
 * 0.
 * <p>
 * Par défaut:
 * <ul>
 * <li>La <i>largeur</i> est initialisé à
 * {@value Forme#LARGEUR_PAR_DEFAUT}.</li>
 * <li>La <i>hauteur</i> est initialisé à
 * {@value Forme#HAUTEUR_PAR_DEFAUT}.</li>
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
 * <li>connaitre l'aire de l'ellipse.</li>
 * <li>connaitre le périmètre de l'ellipse.</li>
 * <li>savoir si un point se trouve sur la l'ellipse.</li>
 * <li>de changer la couleur l'ellipse</li>
 * <li>remplir d'une couleur l'ellipse</li>
 * </ul>
 * 
 * @see Forme
 * @see Coordonnees
 * @see Remplissable
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.6
 * 
 * @version 0.4.4.1
 */
public class Ellipse extends Forme implements Remplissable {

    /**
     * Attribut permettant de sauvegarder l'état du remplissage de
     * l'{@code Ellipse}.
     * 
     * @since 0.3.6.1
     */
    private boolean estRempli;

    /**
     * Constructeur d'une nouvelle {@code Ellipse}, il s'agit du constructeur par
     * défaut, initialisant les attributs de la classe aux valeurs par defauts.
     * 
     * @see Forme#Forme()
     * @see #Ellipse(Coordonnees)
     * @see #Ellipse(double, double)
     * @see #Ellipse(Coordonnees, double, double)
     * 
     * @since 0.3.2.6
     */
    public Ellipse() {
        this(new Coordonnees());
    }

    /**
     * Constructeur d'une nouvelle {@code Ellipse} a partir d'un point, les autres
     * attribut etant initialise a partir des valeurs par defaut.
     * 
     * @param coordonnees La {@code Coordonnees} correspondant à la position du coin
     *                    superieur gauche du rectangle englobant l'ellipse.
     * 
     * @see Forme#Forme(Coordonnees)
     * @see #Ellipse()
     * @see #Ellipse(double, double)
     * @see #Ellipse(Coordonnees, double, double)
     * 
     * @since 0.3.2.6
     */
    public Ellipse(final Coordonnees coordonnees) {
        this(coordonnees, Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
    }

    /**
     * Constructeur d'une nouvelle {@code Ellipse} a partir d'un largeur et d'une
     * hauteur, la position etant initialise a partir des valeurs par defaut.
     * <p>
     * La hauteur et la largeur doivent être supérieur à 0.
     * 
     * @param largeur Un {@code double} correspondant à la largeur du rectangle
     *                englobant l'ellipse.
     * @param hauteur Un {@code double} correspondant à la hauteur du rectangle
     *                englobant l'ellipse.
     * 
     * @throws IllegalArgumentException Si la largeur ou la hauteur sont inférieurs
     *                                  ou égales à 0.
     * 
     * @see #Ellipse()
     * @see #Ellipse(Coordonnees)
     * @see #Ellipse(Coordonnees, double, double)
     * 
     * @since 0.3.2.6
     */
    public Ellipse(final double largeur, final double hauteur) {
        this(new Coordonnees(), largeur, hauteur);
    }

    /**
     * Constructeur de la classe {@linkplain Ellipse} a partir d'une position, d'une
     * hauteur et d'une largeur.
     * <p>
     * La hauteur et la largeur doivent être supérieur à 0.
     * 
     * @param coordonnees La {@code Coordonnees} correspondant à la position du coin
     *                    superieur gauche du rectangle englobant la l'ellipse.
     * @param largeur     Un {@code double} correspondant à la largeur du rectangle
     *                    englobant l'ellipse.
     * @param hauteur     Un {@code double} correspondant à la hauteur du rectangle
     *                    englobant l'ellipse.
     * 
     * 
     * 
     * @throws IllegalArgumentException Si la largeur ou la hauteur sont inférieurs
     *                                  ou égales à 0.
     * 
     * @see Forme#Forme(Coordonnees, double, double)
     * @see #Ellipse()
     * @see #Ellipse(Coordonnees)
     * @see #Ellipse(double, double)
     * 
     * @since 0.3.2.6
     */
    public Ellipse(final Coordonnees coordonnees, final double largeur, final double hauteur) {
        super(coordonnees);
        this.setHauteur(hauteur);
        this.setLargeur(largeur);
        this.estRempli = false;
    }

    /**
     * {@inheritDoc}
     * <p>
     * La largeur doit être supérieur à 0.
     * 
     * @throws IllegalArgumentException Si la largeur est inférieur ou égale à 0.
     * 
     * @see #setHauteur(double)
     * @see Forme#getLargeur()
     * 
     * @since 0.3.2.6
     */
    @Override
    public void setLargeur(final double largeur) {
        if (largeur > 0) {
            super.setLargeur(largeur);
        } else {
            throw new IllegalArgumentException("La largeur de " + getClass().getSimpleName() + " doit être positive");
        }
    }

    /**
     * {@inheritDoc}
     * <p>
     * La hauteur doit être supérieur à 0.
     * 
     * @throws IllegalArgumentException Si la hauteur est inférieur ou égale à 0.
     * 
     * @see #setLargeur(double)
     * @see Forme#getHauteur()
     * 
     * @since 0.3.2.6
     */
    @Override
    public void setHauteur(final double hauteur) {
        if (hauteur > 0) {
            super.setHauteur(hauteur);
        } else {
            throw new IllegalArgumentException("La hauteur de " + getClass().getSimpleName() + " doit être positive");
        }
    }

    /**
     * {@inheritDoc}
     * <p>
     * Le calul se fait d'après la formule de Srinivasa Ramanujan:
     * <p>
     * {@code π(a + b)(1 + 3h / (10+ sqrt(4-3h) ) )}.
     * <p>
     * Où:
     * <ul>
     * <li><i>a</i> est le petit rayon de l'ellipse</li>
     * <li><i>b</i> est le grand rayon de l'ellipse</li>
     * <li><i>h</i> est égale à {@code(a-b)² / (a+b)²}</li>
     * </ul>
     * <p>
     * 
     * @see #aire()
     * 
     * @since 0.3.2.6
     */
    @Override
    public double perimetre() {
        final double a = Math.min(super.getHauteur() / 2, super.getLargeur() / 2);
        final double b = Math.max(super.getHauteur() / 2, super.getLargeur() / 2);
        final double h = Math.pow((a - b) / (a + b), 2);
        return Math.PI * (a + b) * (1 + (3 * h / (10 + Math.sqrt(4 - 3 * h))));
    }

    /**
     * {@inheritDoc}
     * <p>
     * Le calcul se fait d'après la formule : {@code π x a x b}.
     * <p>
     * Où:
     * <ul>
     * <li><i>a</i> est le petit rayon de l'ellipse</li>
     * <li><i>b</i> est le grand rayon de l'ellipse</li>
     * <ul>
     * <p>
     * 
     * @see #perimetre()
     * 
     * @since 0.3.2.6
     */
    @Override
    public double aire() {
        return Math.PI * (this.getHauteur() / 2) * (this.getLargeur() / 2);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dans le cas d’une ellipse, on considère que la forme contient le point si le
     * point se trouve à l’interieur ou sur le contour de la forme.
     * <p>
     * Si l'ellipse est définie par les coordonnées des deux points A et B du
     * rectangle englobant l'ellipse, sachant que:
     * <ul>
     * <li><i>a</i> est le rayon de l'ellipse paralléle à la hauteur.</li>
     * <li><i>b</i> est le rayon de l'ellipse paralléle à la largeur.</li>
     * <li><i>(X, Y)<i> est le centre de l'ellipse.</li>
     * </ul>
     * <p>
     * le point (x, y) doit vérifier l'inéquation:
     * <p>
     * {@code ( (x - X)/a )² + ( (x - X)/b )² <= 1}
     * <p>
     * Si:
     * <ul>
     * <li>le résultat est inférieur à 1, alors le point est dans l'ellipse.</li>
     * <li>le résultat est égale à 1, alors le point se trouve sur le contour de
     * l'ellipse.</li>
     * <li>le réultat est supérieur à 1, alors le point est en dehors de
     * l'ellipse.</li>
     * </ul>
     * 
     * @see <a href=
     *      "https://fr.wikipedia.org/wiki/Ellipse_(math%C3%A9matiques)#%C3%89quation_cart%C3%A9sienne">Wikipédia
     *      les Ellipses - Équation cartésienne</a>
     * 
     * @since 0.3.2.8
     */
    @Override
    public boolean contient(final Coordonnees coordonnees) {
        final double b = super.getLargeur() / 2;
        final double a = super.getHauteur() / 2;
        final double x = super.getPosition().getAbscisse() + b;
        final double y = super.getPosition().getOrdonnee() + a;
        return Math.pow(((coordonnees.getAbscisse() - x)) / b, 2)
                + Math.pow(((coordonnees.getOrdonnee() - y)) / a, 2) <= 1;
    }

    /**
     * {@inheritDoc}
     * 
     * @since 0.3.6.1
     */
    @Override
    public boolean estRempli() {
        return this.estRempli;
    }

    /**
     * {@inheritDoc}
     * 
     * @since 0.3.6.1
     */
    @Override
    public void setRempli(final boolean modeRemplissage) {
        this.estRempli = modeRemplissage;
    }

    /**
     * Fonction renvoyant une descripsion de l'ellipse sous la forme :
     * <p>
     * {@code [Ellipse<-Rempli] pos : (<abscisse>), <ordonnée>) dim <largeur> x <hauteur> 
     * périmètre : <perimetre> aire : <aire>, couleur = <code couleurRGB> epaisseur du trait : <epaisseurDuTrait>}.
     * 
     * @return Une {@code String}, correspondant à la description de l'
     *         {@code Ellipse}.
     * 
     * @see Coordonnees#toString()
     * @see Forme#descriptionCouleur()
     * @see Forme#descriptionEpaisseurTrait()
     * @see #descriptionRemplissage()
     * 
     * @since 0.3.2.5
     * 
     * @version 0.4.4.1
     */
    @Override
    public String toString() {
        final DecimalFormat formater = new DecimalFormat("0.0#");
        return '[' + getClass().getSimpleName() + this.descriptionRemplissage() + "] : pos "
                + this.getPosition().toString() + " dim " + formater.format(this.getLargeur()) + " x "
                + formater.format(this.getHauteur()) + " périmètre : " + formater.format(this.perimetre()) + " aire : "
                + formater.format(this.aire()) + super.descriptionCouleur() + super.descriptionEpaisseurTrait();
    }

    /**
     * {@inheritDoc}
     * 
     * @return {@code "-Rempli"} si l'ellipse est rempli , "" sinon.
     * 
     * @since 0.3.6.1
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
     * 
     * @see Forme#equals(Object)
     * 
     * @since 0.3.3.6
     */
    @Override
    public boolean equals(final Object other) {
        if (other == this)
            return true;
        if (!(other instanceof Ellipse)) {
            return false;
        }
        final Ellipse ellipse = (Ellipse) other;
        return super.equals(ellipse);
    }

    /**
     * Fonction permettant d'obtenir la hashCode d'une {@code Ellipse}.
     * 
     * @return Un {@code int} correspondan au hashCode de la {@code Ellipse}.
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
