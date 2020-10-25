package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

/**
 * Classe {@code TracerCrayon} permettant de sauvegarder un tracer quelconque.
 * 
 * @author Brinfer
 * 
 * @since 0.4.3.1
 * 
 * @version 0.4.4.1
 */
public class TracerCrayon extends Forme implements Remplissable {

    /**
     * Valeur {@code double} pour la comparaison entre deux autres {@code double}
     * pour la classe.
     * <p>
     * La précision des comparaison est de {@value #EPSILON}.
     * 
     * @since 0.4.3.1
     */
    public static final double EPSILON = 1;

    /**
     * Attribue permettant de sauvegarder dans une {@code List} l'nesemble des
     * points composants le tracé.
     * 
     * @since 0.4.3.1
     */
    private final List<Coordonnees> listPoints = new ArrayList<Coordonnees>();

    /**
     * Attribut permettant de sauvegarder l'état du remplissage du
     * {@code TracerCrayon}.
     * 
     * @since 0.4.3.1
     */
    private boolean estRempli = false;

    /**
     * Fonction permettant de continuer le tracé de la trace en ajoutant le point
     * donné en paramètre.
     * 
     * @param nouveauPoint La {@code Coordonnees} s'ajoutant au tracer.
     * 
     * @since 0.4.3.1
     */
    public void trace(final Coordonnees nouveauPoint) {
        this.listPoints.add(nouveauPoint);
    }

    /**
     * Accesseur permettant de récupérer l'ensemble des points composant le tracer.
     * 
     * @return Une {@code List<Coordonnees>} des points componsant le tracer.
     * 
     * @since 0.4.3.1
     */
    public List<Coordonnees> getListeCoordonnees() {
        return this.listPoints;
    }

    /**
     * Fonction permettant de calculer les dimensions du rectangle englobant le
     * tracer.
     * 
     * @since 0.4.3.1
     */
    public void calculeDim() {
        Coordonnees coordonneesMaxX = new Coordonnees(Double.MIN_VALUE, 0);
        Coordonnees coordonneesMinX = new Coordonnees(Double.MAX_VALUE, 0);
        Coordonnees coordonneesMaxY = new Coordonnees(0, Double.MIN_VALUE);
        Coordonnees coordonneesMinY = new Coordonnees(0, Double.MAX_VALUE);

        for (final Coordonnees point : this.getListeCoordonnees()) {
            if (point.getAbscisse() > coordonneesMaxX.getAbscisse()) {
                coordonneesMaxX = point;
            } else if (point.getAbscisse() < coordonneesMinX.getAbscisse()) {
                coordonneesMinX = point;
            }
            if (point.getOrdonnee() > coordonneesMaxY.getOrdonnee()) {
                coordonneesMaxY = point;
            } else if (point.getOrdonnee() < coordonneesMinY.getOrdonnee()) {
                coordonneesMinY = point;
            }
        }

        super.setPosition(new Coordonnees(coordonneesMinX.getAbscisse(), coordonneesMinY.getOrdonnee()));
        super.setLargeur(coordonneesMaxX.getAbscisse() - coordonneesMinX.getAbscisse());
        super.setHauteur(coordonneesMaxY.getOrdonnee() - coordonneesMinY.getOrdonnee());
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dans le cas d'un tracer, il n'est pas possible de le redimensionner, cette
     * fonction est donc deprecié, mais elle changera tout de même la largeur afin
     * de ne pas pénaliser les enfant de la classe.
     * 
     * @param largeur Un {@code double} correspondant à la nouvelle largeur de la
     *                forme.
     * 
     * @since 0.4.3.1
     */
    @Override
    @Deprecated
    public void setLargeur(final double largeur) {
        super.setLargeur(largeur);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dans le cas d'un tracer, il n'est pas possible de le redimensionner, cette
     * fonction est donc deprecié, mais elle changera tout de même la hauteur afin
     * de ne pas pénaliser les enfant de la classe. Une des solutions serait
     * d'augmenter l'écart entre les points.
     * 
     * @param hauteur Un {@code double} correspondant à la nouvelle hauteur de la
     *                forme.
     * 
     * @since 0.4.3.1
     */
    @Override
    @Deprecated
    public void setHauteur(final double hauteur) {
        super.setHauteur(hauteur);
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dans le cas d'une forme quelconque, le seul moyen d'estimer sa surface serait
     * de compter le nombre de pixel que celle-ci englobe. A voir à le faire plus
     * tard.
     * <p>
     * Pour le moment elle ne sert à rien.
     * 
     * @return {@code 0}.
     * 
     * @since 0.4.3.1
     */
    @Override
    @Deprecated
    public double aire() {
        return 0;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dans le cas d'un tracé, le périmetre est la distance entre les points de
     * proche en proche. Cette fonction n'est pas encore au point.
     * 
     * @return Un {@code double} correspondant à la longuer du tracer
     * 
     * @see Coordonnees#distanceVers(Coordonnees)
     * 
     * @since 0.4.3.1
     */
    @Override
    @Deprecated
    public double perimetre() {
        double perimetre = 0;
        for (int i = 1; i < this.getListeCoordonnees().size(); i += 1) {
            perimetre += this.getListeCoordonnees().get(i - 1).distanceVers(this.getListeCoordonnees().get(i));
        }
        return perimetre;
    }

    /**
     * {@inheritDoc}
     * 
     * @param deltaX Un {@code double} correspondant à l'abscisse du vecteur, soit
     *               la valeur du décallage pour l'abscisse.
     * @param deltaY Un {@code double} correspondant à l'ordonnee du vecteur, soit
     *               la valeur de décallage pour l'ordonnée.
     * 
     * @see #deplacerVers(double, double)
     * @see #setPosition(Coordonnees)
     * 
     * @since 0.4.3.1
     */
    @Override
    public void deplacerDe(final double deltaX, final double deltaY) {
        for (final Coordonnees point : this.getListeCoordonnees()) {
            point.deplacerDe(deltaX, deltaY);
        }
        super.getPosition().deplacerDe(deltaX, deltaY);
    }

    /**
     * {@inheritDoc}
     * 
     * @param nouvelleAbscisse Un {@code double} correspondant à la nouvelle
     *                         abscisse du point.
     * @param nouvelleOrdonnee Un {@code double} correspondant à la nouvelle
     *                         ordonnees du point.
     * 
     * @see #deplacerDe(double, double)
     * @see #setPosition(Coordonnees)
     * 
     * @since 0.4.3.1
     */
    @Override
    public void deplacerVers(final double nouvelleAbscisse, final double nouvelleOrdonnee) {
        this.deplacerDe(nouvelleAbscisse - super.getPosition().getAbscisse(),
                nouvelleOrdonnee - super.getPosition().getOrdonnee());
    }

    /**
     * {@inheritDoc}
     * 
     * @param position La {@code Coordonnees} qui sera la nouvelle position.
     * 
     * @see #deplacerDe(double, double)
     * @see #deplacerVers(double, double)
     * 
     * @since 0.4.3.1
     */
    @Override
    public void setPosition(final Coordonnees position) {
        this.deplacerVers(position.getAbscisse(), position.getOrdonnee());
    }

    /**
     * {@inheritDoc}
     * <p>
     * Dans le cas où le tracé est rempli, alors on utilise la méthode du
     * ray-casting, sinon on compare la distance entre les points du tracé et celui
     * donné en paramètre, cette distance doit être inférieur à {@value #EPSILON}.
     * 
     * @param coordonnees La {@code Coordonnees} dont in veut savoi si elle compose
     *                    le tracé.
     * 
     * @return {@code true} si le point compose le tracé, {@code false} sinon.
     * 
     * @see #EPSILON
     * 
     * @since 0.4.3.1
     */
    @Override
    public boolean contient(final Coordonnees coordonnees) {
        boolean dedans = false;

        if (this.estRempli()) {
            // Cas où le tracé est fermé
            // Permet de virtuellement fermer la figure pour les tets
            Coordonnees pointPrecedent = this.getListeCoordonnees().get(this.getListeCoordonnees().size() - 1);

            // On trace les segment intermédiare entre les points et on determine si le
            // rayon le coupe, on fait que un point sur trois afin d'avoir un segment plus
            // grand et augmenter les chances que cela coupe. En effet lors du trassage, les
            // points sont collé.
            for (int i = 0; i < this.getListeCoordonnees().size(); i += 3) {
                final Coordonnees pointCourant = this.getListeCoordonnees().get(i);

                if ((pointPrecedent.getOrdonnee() > coordonnees.getOrdonnee()) != (pointCourant
                        .getOrdonnee() > coordonnees.getOrdonnee())) {

                    // Determination de l'équation de la droite sous la forme y = ax + b.
                    final double a = (pointCourant.getOrdonnee() - pointPrecedent.getOrdonnee())
                            / (pointCourant.getAbscisse() - pointPrecedent.getAbscisse());
                    final double b = pointCourant.getOrdonnee() - a * pointCourant.getAbscisse();

                    // Determination du point d'intersection des droites, si la pente est nul,
                    // alors xC = infinty, aucune exception de soulevé.
                    final double xC = -(b - coordonnees.getOrdonnee()) / a;

                    // Le rayon est une demie droite dans le sens positif de l'abscisse donc les
                    // points d'intersection à gauche du point tester ne sont pas à prendre en
                    // compte.
                    if (xC >= coordonnees.getAbscisse() - Coordonnees.EPSILON) {
                        dedans = !dedans;
                    }
                }
                pointPrecedent = pointCourant;
            }
        } else {
            // Cas où le tracé n'est pas rempli
            for (final Coordonnees point : this.getListeCoordonnees()) {
                if (point.distanceVers(coordonnees) <= super.getEpaisseurTrait() * 1.5) {
                    return true;
                }
            }
        }
        return dedans;
    }

    /**
     * {@inheritDoc}
     * 
     * @return {@code true} si la forme est remplie, {@code false} sinon.
     * 
     * @since 0.4.3.1
     */
    @Override
    public boolean estRempli() {
        return this.estRempli;
    }

    /**
     * {@inheritDoc}
     * 
     * @param modeRemplissage Un {@code boolean}
     *                        <ul>
     *                        <li>{@code true} si on veut remplir la
     *                        {@code Forme}.</li>
     *                        <li>{@code false} si on ne veut pas remplir la
     *                        {@code Forme}.</li>
     *                        </ul>
     * 
     * @since 0.4.3.1
     */
    @Override
    public void setRempli(final boolean modeRemplissage) {
        this.estRempli = modeRemplissage;
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
     * Fonction renvoyant une description de la ligne sous la forme :
     * <p>
     * {@code [TracerCrayon] longueur : <longeur> couleur <code couleur RGB> epaisseur du trait : <epaisseurDuTrait>}.
     * 
     * @return Une {@code String}, correspondant à la description du
     *         {@code TracerCrayon}.
     * 
     * @see #descriptionRemplissage()
     * @see Forme#descriptionCouleur()
     * @see Forme#descriptionEpaisseurTrait()
     * 
     * @since 0.4.3.1
     * 
     * @version 0.4.4.1
     */
    @Override
    public String toString() {
        final DecimalFormat formater = new DecimalFormat("0.0#");
        return '[' + getClass().getSimpleName() + this.descriptionRemplissage() + "] " + "longueur : "
                + formater.format(this.perimetre()) + super.descriptionCouleur() + super.descriptionEpaisseurTrait();
    }

    /**
     * {@inheritDoc}
     * <p>
     * Pour que deux tracés soit égaux, il doivent avoir la même liste de points.
     * 
     * @param other L'autre instance avec laquelle on veut comparer le
     *              {@code TracerCrayon}.
     * 
     * @return {@code true} si les deux instance sont les même, {@code false} sinon.
     * 
     * @see Forme#equals(Object)
     * @see ArrayList#equals(Object)
     * 
     * @since 0.4.3.1
     */
    @Override
    public boolean equals(final Object other) {
        if (other == this)
            return true;
        if (!(other instanceof TracerCrayon)) {
            return false;
        }
        final TracerCrayon tracer = (TracerCrayon) other;

        return super.equals(tracer) && tracer.getListeCoordonnees().equals(this.getListeCoordonnees());
    }

    /**
     * Fonction permettant d'obtenir la hashCode d'un {@code TracerCrayon}.
     * 
     * @return Un {@code int} correspondan au hashCode du {@code TracerCrayon}.
     * 
     * @see Forme#hashCode()
     * @see Coordonnees#hashCode()
     * 
     * @since 0.4.3.1
     */
    @Override
    public int hashCode() {
        int hash = 0;
        for (final Coordonnees point : this.getListeCoordonnees()) {
            hash += point.hashCode();
        }
        return super.hashCode() + hash;
    }
}