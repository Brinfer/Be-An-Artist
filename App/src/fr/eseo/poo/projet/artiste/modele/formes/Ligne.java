package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Classe {@code Ligne} permettant une représentation d'une ligne.
 * <p>
 * Une ligne est caractérisé part:
 * <ul>
 * <li>Une <i>position</i> correspondant à l'une de ses extrémitées.</li>
 * <li>Une <i>hauteur</i> correspondant à celle du rectangle l'englobant.</li>
 * <li>Une <i>largeur</i> correspondant à celle du rectangle l'englobant.</li>
 * </ul>
 * <p>
 * Ces attributs peuvent être modifiés.
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
 * Pour d'information se référer à la classe {@linkplain Forme} et la classe
 * {@linkplain Coordonnees}.
 * <p>
 * Il est possible de:
 * <ul>
 * <li>connaitre la longueur de la ligne.</li>
 * <li>savoir si un point se trouve sur la ligne.</li>
 * <li>changer la couleur de la ligne</li>
 * </ul>
 * <p>
 * 
 * @see Coordonnees
 * @see Forme
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.4
 * 
 * @version 0.4.4.1
 */
public class Ligne extends Forme {

    /**
     * Valeur de type {@code double}, pour la comparaison entre deux lignes.
     * <p>
     * La précision des comparaison est de {@value #EPSILON}.
     * 
     * @since 0.3.2.8
     */
    public static final double EPSILON = 0.1;

    /**
     * Constructeur par defaut de la classe {@linkplain Ligne}, initiamise les
     * attribut de la classe à partir des valeurs par defaut.
     * 
     * @see Forme#Forme()
     * @see #Ligne(Coordonnees)
     * @see #Ligne(double, double)
     * @see #Ligne(Coordonnees, double, double)
     * 
     * @since 0.3.2.4
     */
    public Ligne() {
        super();
    }

    /**
     * Constructeur d'une nouvelle {@code Ligne} a partir d'un point, les autres
     * attributs etant initialises a partir des valeurs par defaut.
     * 
     * @param coordonnees Une {@code Coordonnees} correspondant au coin superieur
     *                    gauche du rectangle englobant la ligne.
     * 
     * @see Forme#Forme(Coordonnees)
     * @see #Ligne()
     * @see #Ligne(double, double)
     * @see #Ligne(Coordonnees, double, double)
     * 
     * @since 0.3.2.4
     */
    public Ligne(final Coordonnees coordonnees) {
        super(coordonnees);
    }

    /**
     * Constructeur d'une nouvelle {@code Ligne} a partir d'un largeur et d'une
     * hauteur, la position etant initialise a partir des valeurs par defaut.
     * 
     * @param largeur Le {@code double} correspondant à la largeur du rectangle
     *                englobant la ligne.
     * @param hauteur Le {@code double} correspondant à la hauteur du rectangle
     *                englobant la ligne.
     * 
     * @see Forme#Forme(double, double)
     * @see #Ligne()
     * @see #Ligne(Coordonnees)
     * @see #Ligne(Coordonnees, double, double)
     * 
     * @since 0.3.2.4
     */
    public Ligne(final double largeur, final double hauteur) {
        super(largeur, hauteur);
    }

    /**
     * Constructeur d'une nouvelle {@code Ligne} a partir d'une position, d'une
     * hauteur et d'une largeur.
     * 
     * @param coordonnees Une {@code Coordonnees} correspondant au coin superieur
     *                    gauche du rectangle englobant la ligne.
     * @param largeur     Le {@code double} correspondant à la largeur du rectangle
     *                    englobant la ligne.
     * @param hauteur     Le {@code double} correspondant à la hauteur du rectangle
     *                    englobant la ligne.
     * 
     * @see Forme#Forme(Coordonnees, double, double)
     * @see #Ligne()
     * @see #Ligne(Coordonnees)
     * @see #Ligne(double, double)
     * 
     * 
     * @since 0.3.2.4
     */
    public Ligne(final Coordonnees coordonnees, final double largeur, final double hauteur) {
        super(coordonnees, largeur, hauteur);
    }

    /**
     * Accesseur de la premiere extremite de la ligne, ce qui correspond a la
     * {@code position} de la ligne.
     * 
     * @return La {@code Coordonnees} correspondant à la premiere extremite de la
     *         ligne.
     * 
     * @see Forme#getPosition()
     * @see #getC2()
     * @see #setC1()
     * 
     * @since 0.3.2.4
     */
    public Coordonnees getC1() {
        return super.getPosition();
    }

    /**
     * Mutateur de la premiere extremite de la ligne, entrainant une modification
     * des dimensions de la ligne.
     * 
     * @param coordonnees Une {@code Coordonnees} correspondant à la nouvelle
     *                    première extremitté de la ligne.
     * 
     * @see #getC1()
     * @see #setC2(Coordonnees)
     * @see Forme#setHauteur(double)
     * @see Forme#setLargeur(double)
     * 
     * @since 0.3.2.4
     */
    public void setC1(final Coordonnees coordonnees) {
        super.setLargeur(this.getC2().getAbscisse() - coordonnees.getAbscisse());
        super.setHauteur(this.getC2().getOrdonnee() - coordonnees.getOrdonnee());
        super.setPosition(coordonnees);
    }

    /**
     * Accesseur de la deuxième extremite de la ligne.
     * 
     * @return La {@code Coordonnees} correspondant à la deuxième extremite de la
     *         ligne.
     * 
     * @see #getC1()
     * @see #setC2(Coordonnees)
     * 
     * @since 0.3.2.4
     */
    public Coordonnees getC2() {
        return new Coordonnees(this.getC1().getAbscisse() + this.getLargeur(),
                this.getC1().getOrdonnee() + this.getHauteur());
    }

    /**
     * Mutateur de la deuxieme extremite de la ligne, entrainant une modification
     * des dimensions de la ligne.
     * 
     * @param coordonnees Une {@code Coordonnees} correspondant à la nouvelle
     *                    deuxième extremitté de la ligne.
     * 
     * @see #getC2()
     * @see #setC1(Coordonnees)
     * @see Forme#setHauteur(double)
     * @see Forme#setLargeur(double)
     * 
     * @since 0.3.2.4
     */
    public void setC2(final Coordonnees coordonnees) {
        super.setLargeur(coordonnees.getAbscisse() - this.getC1().getAbscisse());
        super.setHauteur(coordonnees.getOrdonnee() - this.getC1().getOrdonnee());
    }

    /**
     * {@inheritDoc}
     * <p>
     * Comme il s'agit d'une ligne, l'aire est égale a 0.0.
     * 
     * @since 0.3.2.4
     */
    @Override
    @Deprecated
    public double aire() {
        return 0.0;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dans le cas d'une ligne, cela correspond à sa longueur, ou la distance entre
     * ses deux extremitées.
     * 
     * @see Coordonnees#distanceVers(Coordonnees)
     * 
     * @since 0.3.2.4
     */
    @Override
    public double perimetre() {
        return this.getC1().distanceVers(this.getC2());
    }

    /**
     * {@inheritDoc}
     * <p>
     * On concidére qu'un point est sur la ligne si elle se situe à une distance
     * inférieur à {@value Ligne#EPSILON}.
     * 
     * @since 0.3.2.8
     */
    @Override
    public boolean contient(final Coordonnees coordonnees) {
        return (coordonnees.distanceVers(this.getC1()) + coordonnees.distanceVers(this.getC2()))
                - (this.perimetre()) <= Ligne.EPSILON;
    }

    /**
     * Fonction renvoyant une description de la ligne sous la forme :
     * <p>
     * {@code [Ligne] c1 : (<abscisse>) , <ordonnée>) c2 : (<abscisse>) , 
     * <ordonnée>) longueur : <longeur> angle : <angle>, couleur <code couleur RGB> epaisseur du trait :<epaisseurDuTrait>}.
     * 
     * @return Une {@code String}, correspondant à la description de la
     *         {@code Ligne}.
     * 
     * @see Coordonnees#toString()
     * @see #descriptionRemplissage()
     * @see Forme#descriptionCouleur()
     * @see Forme#descriptionEpaisseurTrait()
     * 
     * @since 0.3.2.4
     * 
     * @version 0.4.4.1
     */
    @Override
    public String toString() {
        final DecimalFormat formater = new DecimalFormat("0.0#");
        double angle = Math.toDegrees(this.getC1().angleVers(this.getC2()));
        if (angle < 0) {
            angle = 360 + angle;
        }
        return '[' + getClass().getSimpleName() + "] c1 : " + this.getC1().toString() + " c2 : "
                + this.getC2().toString() + " longueur : " + formater.format(this.perimetre()) + " angle : "
                + formater.format(angle) + '°' + super.descriptionCouleur() + super.descriptionEpaisseurTrait();
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
        if (!(other instanceof Ligne)) {
            return false;
        }
        final Ligne ligne = (Ligne) other;
        return super.equals(ligne);
    }

    /**
     * Fonction permettant d'obtenir la hashCode d'une {@code Ligne}.
     * 
     * @return Un {@code int} correspondan au hashCode de la {@code Ligne}.
     * 
     * @see Forme#hashCode()
     * @see String#hashCode()
     * 
     * @since 0.3.3.6
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}