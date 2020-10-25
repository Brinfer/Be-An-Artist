package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Classe {@code Epicycloide} permettant de représenté une épicycloïde.
 * 
 * @see <a href="https://fr.wikipedia.org/wiki/Épicycloïde">Wikipédia -
 *      Epicycloïde</a>
 * 
 * @author Brinfer
 * 
 * @since 0.4.6.1
 */
public class Epicycloide extends TracerCrayon {

    /**
     * Constante de la classe {@code Epicycloide}.
     * <p>
     * Il s'agit du nombre de branche pardéfaut pour une étoile, elle est de
     * {@value}
     * 
     * @since 0.4.6.1
     */
    public static final String RAPPORT_RAYON_Q_DEFAUT = "9 / 2";

    /**
     * Constante de la classe {@code Epicycloide} correspondant aux rapport entre le
     * rayon du cercle de base et celui du cercle roulant. Le dénominateur
     * correspond au rayon du cercle roulant, le numérateur à celui du cercle de
     * base.
     * 
     * @since 0.4.6.1
     */
    public static final String[] RAPPORT_POSSIBLE = { "1 / 1", "2 / 1", "3 / 1", "4 / 1", "5 / 1", "1 / 2", "3 / 2",
            "3 / 2", "7 / 2", "9 / 2", "1 / 3", "2 / 3", "4 / 3", "5 / 3", "7 / 3", "1 / 4", "3 / 4", "5 / 4", "7 / 4",
            "9 / 4", "1 / 5", "2 / 5", "3 / 5", "4 / 5", "6 / 5" };

    /**
     * Attribue permettant de sauvegarder le rapport entre le rayon du cerlce de
     * base et le rayon roulant.
     * 
     * @since 0.4.6.1
     */
    private double rapportQ;

    /**
     * Attribut sauvegardant le du nombre de tour nécessaire pour dessine
     * l'épicycloïde, ce qu corresond au dénominateur du rapport <i>q</i>
     * 
     * @since 0.4.6.1
     */
    private double nombreTour;

    /**
     * Contructeur par défaut d'une nouvelle instance {@code Epicycloide}.
     * <p>
     * Les attribue sont initialisé aux valeurs par défauts.
     * 
     * @see Forme#Forme()
     * @see #Epicycloide(Coordonnees)
     * @see #Epicycloide(Coordonnees, double, double)
     * @see #Epicycloide(double, double)
     * 
     * @since 0.4.6.1
     */
    public Epicycloide() {
        super();
    }

    /**
     * Contructeur par défaut d'une nouvelle instance {@code Epicycloide}.
     * <p>
     * Les attribue sont initialisé aux valeurs par défauts, sauf pour la position
     * qui devient celle donnée en paramètre.
     * 
     * @param position Une {@code Coordonnees} correspondant à la position que l'on
     *                 souhaite donner à l'{@code Epicycloïde}.
     * 
     * @see #Epicycloide()
     * @see #Epicycloide(double, double)
     * @see #Epicycloide(Coordonnees, double, double)
     * 
     * @since 0.4.6.1
     */
    public Epicycloide(final Coordonnees position) {
        this(position, Forme.LARGEUR_PAR_DEFAUT, Epicycloide.RAPPORT_RAYON_Q_DEFAUT);
    }

    /**
     * Contructeur par défaut d'une nouvelle instance {@code Epicycloide}.
     * <p>
     * Les attribue sont initialisé aux valeurs données en paramètre, sauf pour la
     * position qui est celle par défaut.
     * 
     * @param taille   Un {@code double} correspondant à la taille que l'on souhaite
     *                 donné à l'{@code Epicycloïde}.
     * @param rapportQ Un {@code double} correspondant au rapport entre le rayon du
     *                 cercle de base et celui du cercle roulant.
     * 
     * @see #Epicycloide()
     * @see #Epicycloide(Coordonnees, double, double)
     * @see #Epicycloide(Coordonnees)
     * @see Coordonnees#Coordonnees()
     * 
     * @since 0.4.6.1
     */
    public Epicycloide(final double taille, final String rapportQ) {
        this(new Coordonnees(), taille, rapportQ);
    }

    /**
     * Contructeur par défaut d'une nouvelle instance {@code Epicycloide}.
     * <p>
     * Les attribue sont initialisé aux valeurs données en paramètre.
     * 
     * @param position Une {@code Coordonnees} correspondant à la position que l'on
     *                 souhaite donner à l'{@code Epicycloïde}.
     * @param taille   Un {@code double} correspondant à la taille que l'on souhaite
     *                 donné à l'{@code Epicycloïde}.
     * @param rapportQ Un {@code double} correspondant au rapport entre le rayon du
     *                 cercle de base et celui du cercle roulant.
     * 
     * @see #Epicycloide()
     * @see #Epicycloide(double, double)
     * @see #Epicycloide(Coordonnees)
     * 
     * @since 0.4.6.1
     */
    public Epicycloide(final Coordonnees position, final double taille, final String rapportQ) {
        this.setHauteur(taille);
        super.setPosition(position);
        this.setRapportQ(rapportQ);
    }

    /**
     * Accesseur du rapport <i>q</i> entre le rayon du cercle de base et le rayon du
     * cercle roulant.
     * 
     * @return Un {@code double} correspondant au rapport entre le rayon du cercle
     *         de base et le rayon du cercle roulant.
     * 
     * @since 0.4.6.1
     */
    public double getRapportQ() {
        return this.rapportQ;
    }

    /**
     * Mutateur du rapport <i>q</i> entre le rayon du cercle de base et le rayon du
     * cercle roulant.
     * 
     * @param rapportQ Un {@code double} correspondant au rapport entre le rayon du
     *                 cercle de base et le rayon du cercle roulant.
     * 
     * @since 0.4.6.1
     */
    public void setRapportQ(final String rapportQ) {
        final double num = Double.valueOf(rapportQ.split(" / ")[0]);
        final double den = Double.valueOf(rapportQ.split(" / ")[1]);
        this.nombreTour = den;
        this.rapportQ = num / den;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dans le cas de l'épicycloïde, la hauteur du rectangle est aussi modifié pour
     * que ses deux dimensions restent égales.
     * 
     * @throws IllegalArgumentException Si la largeur est inférieurs ou égales à 0.
     * 
     * @see #setHauteur(double)
     * @see Forme#getLargeur()
     * 
     * @since 0.4.6.1
     */
    @Override
    @SuppressWarnings("deprecation")
    public void setLargeur(final double largeur) {
        if (largeur > 0) {
            super.setLargeur(largeur);
            super.setHauteur(largeur);
        } else {
            throw new IllegalArgumentException("La largeur de " + getClass().getSimpleName() + " doit être positive");
        }
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dans le cas de l'épicycloïde, la largeur du rectangle est aussi modifié pour
     * que ces deux dimensions restent égales.
     * 
     * @throws IllegalArgumentException Si la hauteur est inférieurs ou égales à 0.
     * 
     * @see #setLargeur(double)
     * @see Forme#getHauteur()
     * 
     * @since 0.4.6.1
     */
    @Override
    public void setHauteur(final double hauteur) {
        this.setLargeur(hauteur);
    }

    /**
     * Fonction permettant de tracé une épicycloïde à partir des attribue de la
     * classe et du point donné en paramètre comme étant le centre du cercle
     * englobant la figure.
     * 
     * @param centreDuCercle Une {@code Coordonnees} correspondant au centre du
     *                       cercle englobant l'épycycloïde.
     * 
     * @see #valX(double)
     * @see #valY(double)
     * @see <a href=
     *      "https://fr.wikipedia.org/wiki/%C3%89picyclo%C3%AFde#Propri%C3%A9t%C3%A9s">Wikipédia
     *      - Epicycloïde - Propriétés</a>
     * 
     * @since 0.4.6.1
     */
    @Override
    public void trace(final Coordonnees centreDuCercle) {
        super.getListeCoordonnees().clear();
        final double xC = centreDuCercle.getAbscisse();
        final double yC = centreDuCercle.getOrdonnee();
        double x = 0;
        double y = 0;
        double teta = 0;
        while (teta <= this.getNombreDeTour() * 2 * Math.PI) {
            x = xC + this.valX(teta);
            y = yC + this.valY(teta);
            teta += 0.1;
            super.trace(new Coordonnees(x, y));
        }
        super.calculeDim();
    }

    /**
     * Accesseur du nombre de tour nécessaire pour dessiner l'épicycloïde, ce qui
     * corresond au dénominateur du rapport <i>q</i>
     * 
     * @return Un {@code double} correspondant au nombre de tour nécessaire au
     *         dessin de la figure.
     * 
     * @since 0.4.6.1
     */
    public double getNombreDeTour() {
        return this.nombreTour;
    }

    /**
     * Fonction permettant de calculer l'abscisse d'un point apartenenant à
     * l'épicycloïde à partir de l'angle <i>teta</i>.
     * 
     * @param teta Un {@code double} correspondant à la valeur de l'angle.
     * 
     * @return Un {@code double} correspondant à l'abscisse du point appartenant à
     *         l'épicycloïde pour l'angle <i>teta</i> donné.
     * 
     * @see #valY(double)
     * 
     * @since 0.4.6.1
     */
    private double valX(final double teta) {
        final double r = (this.getHauteur() / 2) / this.getRapportQ();
        return (r * ((this.getRapportQ() + 1) * Math.cos(teta) - Math.cos((this.getRapportQ() + 1) * teta)));
    }

    /**
     * Fonction permettant de calculer l'ordonnée d'un point apartenenant à
     * l'épicycloïde à partir de l'angle <i>teta</i>.
     * 
     * @param teta Un {@code double} correspondant à la valeur de l'angle.
     * 
     * @return Un {@code double} correspondant à l'ordonnée du point appartenant à
     *         l'épicycloïde pour l'angle <i>teta</i> donné.
     * 
     * @see #valX(double)
     * 
     * @since 0.4.6.1
     */
    private double valY(final double teta) {
        final double r = (this.getHauteur() / 2) / this.getRapportQ();
        return (r * ((this.getRapportQ() + 1) * Math.sin(teta) - Math.sin((this.getRapportQ() + 1) * teta)));
    }

    /**
     * {@inheritDoc}
     * 
     * @param coordonnees La {@code Coordonnees} dont on vaut savoir si elle est
     *                    dans l'épicycloïde ou non.
     * 
     * @return {@code true} si le point est dedans, {@code false} sinon.
     * 
     * @since 0.4.6.1
     */
    @Override
    public boolean contient(final Coordonnees coordonnees) {
        /*
         * Surcharge de la fonction contient de la classe mère. En effet, dans le cas
         * d'une épicycloïde, celle figure est fermé or la fonction contient de la
         * classe mère agit différemment si la figure est fermé ou non. Elle détermine
         * cela en testant la valeur de rempli. Si cette valeur est true alors la figure
         * est rempli, sinon elle ne l'est pas. Ici on mets a vrai cette variable et on
         * utilise la fonction contient de TracerCrayon qui concidérera bien la figure
         * comme fermé. On remet ensuite a sa valeur originale la variable.
         */
        final boolean rempli = super.estRempli();
        super.setRempli(true);
        final boolean dedans = super.contient(coordonnees);
        super.setRempli(rempli);
        return dedans;
    }
}