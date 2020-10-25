package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

/**
 * Classe {@code CadreSelection} servant à encadrer les {@code Forme} quand
 * celle-ci sont sélectionner avec {@code OutilSelectionner}.
 * <p>
 * il est possible d'agrandir la {@code Forme} sélectionner lié au cadre à
 * travers le cadre.
 * <p>
 * Un cadre est représenté par quatre segments: un pour chaque point cardianaux.
 * <p>
 * Le NORD est orienté vers le haut de la fenêtre et l'OUEST vers la gauche de
 * la fenêtre.
 * 
 * @see Forme
 * @see OutilSelectionner
 * 
 * @since 0.4.2
 * 
 * @author Brinfer
 */
public class CadreSelection extends Forme {

    /**
     * Constante permettant d'indiquer que l'on souhaite le segment NORD.
     * 
     * @see #getCadre()
     * @see #SUD
     * @see #EST
     * @see #OUEST
     * 
     * @since 0.4.2.2
     */
    public static final int NORD = 0;

    /**
     * Constante permettant d'indiquer que l'on souhaite le segment EST.
     * 
     * @see #getCadre()
     * @see #SUD
     * @see #NORD
     * @see #OUEST
     * 
     * @since 0.4.2.2
     */
    public static final int EST = 1;

    /**
     * Constante permettant d'indiquer que l'on souhaite le segment SUD.
     * 
     * @see #getCadre()
     * @see #NORD
     * @see #EST
     * @see #OUEST
     * 
     * @since 0.4.2.2
     */
    public static final int SUD = 2;

    /**
     * Constante permettant d'indiquer que l'on souhaite le segment OUEST.
     * 
     * @see #getCadre()
     * @see #SUD
     * @see #EST
     * @see #NORD
     * 
     * @since 0.4.2.2
     */
    public static final int OUEST = 3;

    /**
     * {@code Ligne} représentant le segment NORD du cadre.
     * 
     * @see #segmentEst
     * @see #segmentOuest
     * @see #segmentSud
     * 
     * @since 0.4.2.2
     */
    private final Ligne segmentNord = new Ligne();

    /**
     * {@code Ligne} représentant le segment SUD du cadre.
     * 
     * @see #segmentEst
     * @see #segmentOuest
     * @see #segmentNord
     * 
     * @since 0.4.2.2
     */
    private final Ligne segmentSud = new Ligne();

    /**
     * {@code Ligne} représentant le segment EST du cadre.
     * 
     * @see #segmentNord
     * @see #segmentOuest
     * @see #segmentSud
     * 
     * @since 0.4.2.2
     */
    private final Ligne segmentEst = new Ligne();

    /**
     * {@code Ligne} représentant le segment OUEST du cadre.
     * 
     * @see #segmentEst
     * @see #segmentNord
     * @see #segmentSud
     * 
     * @since 0.4.2.2
     */
    private final Ligne segmentOuest = new Ligne();

    /**
     * {@code Forme} sémectionner lié au cadre.
     * 
     * @since 0.4.2.1
     */
    private final Forme formeSelectionner;

    /**
     * {@code String} permettant de sauvegarder quelle côté du cadre à été
     * selectionné.
     * <p>
     * Ses différentes valeur peuvent être:
     * <ul>
     * <li><i>N</i>,<i>E</i>, <i>O</i>, ou <i>S</i> en fonction de si le segment
     * NORD, EST, OUEST ou SUD à été sélectionner.</li>
     * <li><i>NE</i>, <i>NO</i>, <i>SO</i> ou <i>SE</i> en fonction de si le coin
     * NORD-OUEST, NORD-EST, SUD-OUEST ou SUD-EST du cadre à été sélectionner.</li>
     * </ul>
     * 
     * @see #contient(Coordonnees)
     * 
     * @since 0.4.2.2
     */
    private String idSelection = "";

    /**
     * Constructeur d'une nouvelle instance {@code CadreSelection}.
     * 
     * @param formeSelectionner La {@code Forme} sélectionner, à encadré.
     * 
     * @since 0.4.2.1
     */
    public CadreSelection(final Forme formeSelectionner) {
        super();
        this.formeSelectionner = formeSelectionner;
        this.setHauteur(Math.abs(formeSelectionner.getHauteur()));
        this.setPosition(formeSelectionner.getPosition());

    }

    /**
     * {@inheritDoc}
     * <p>
     * Le redimensionnement du cadre entraine automatiquement celui de la forme lié
     * au cadre.
     * 
     * @param largeur Un {@code double} correspondant à la nouvelle largeur du
     *                cadre.
     * 
     * @throws IllegalArgumentException Si la largeur est inférieur ou égale à 0.
     * 
     * @see #setLargeur(double, int)
     * @see #setHauteur(double)
     * 
     * @since 0.4.2.1
     */
    @Override
    public void setLargeur(final double largeur) {
        if (largeur <= 0) {
            throw new IllegalArgumentException("La largeur du cadre doit être positive");
        } else {
            if (this.getFormeSelectionner().getLargeur() < 0) {
                // Dans le cas d'une ligne, la largeur peut être négative, ainsi on change les
                // dimensions de la forme sans changer sa position
                this.getFormeSelectionner().setLargeur(-largeur);
            } else {
                this.getFormeSelectionner().setLargeur(largeur);
            }
            // Permet que dans le cas où la forme à une largeur et une hauteur égale, que le
            // cadre suivent se redimensionnement de la hauteur
            super.setLargeur(Math.abs(this.getFormeSelectionner().getLargeur()));
            super.setHauteur(Math.abs(this.getFormeSelectionner().getHauteur()));
        }

    }

    /**
     * {@inheritDoc}
     * <p>
     * Le redimensionnement du cadre entraine automatiquement celui de la forme lié
     * au cadre.
     * 
     * @param hauteur Un {@code double} correspondant à la nouvelle largeur du
     *                cadre.
     * 
     * @throws IllegalArgumentException Si la hauteur est inférieur ou égale à 0.
     * 
     * @see #setLargeur(double)
     * @see #setHauteur(double, int)
     * 
     * @since 0.4.2.1
     */
    @Override
    public void setHauteur(final double hauteur) {
        if (hauteur <= 0) {
            throw new IllegalArgumentException("La hauteur du cadre doit être positive");
        } else {
            if (this.getFormeSelectionner().getHauteur() < 0) {
                // Dans le cas d'une ligne, la largeur peut être négative, ainsi on change les
                // dimensions de la forme sans changer sa position
                this.getFormeSelectionner().setHauteur(-hauteur);
            } else {
                this.getFormeSelectionner().setHauteur(hauteur);
            }
            // Permet que dans le cas où la forme à une largeur et une hauteur égale, que le
            // cadre suivent se redimensionnement de la largeur
            super.setLargeur(Math.abs(this.getFormeSelectionner().getLargeur()));
            super.setHauteur(Math.abs(this.getFormeSelectionner().getHauteur()));
        }
    }

    /**
     * {@inheritDoc}
     * <p>
     * Le déplacement du cadre implique le déplacement des segments du cadre ainsi
     * que de la forme sélectionner.
     * <p>
     * La position du cadre est celle du coin supérieur gauche du rectangle
     * englobant la {@code Forme} lié au cadre.
     * 
     * @see Forme#getCadreMaxX()
     * @see Forme#getCadreMaxY()
     * @see Forme#getCadreMinX()
     * @see Forme#getCadreMinY()
     * 
     * @since 0.4.2.1
     */
    @Override
    public void setPosition(final Coordonnees position) {
        this.getFormeSelectionner().setPosition(position);
        super.setPosition(new Coordonnees(this.getFormeSelectionner().getCadreMinX(),
                this.getFormeSelectionner().getCadreMinY()));

        this.segmentNord.setC1(new Coordonnees(super.getCadreMinX(), super.getCadreMinY()));
        this.segmentSud.setC1(new Coordonnees(super.getCadreMinX(), super.getCadreMaxY()));
        this.segmentOuest.setC1(new Coordonnees(super.getCadreMinX(), super.getCadreMinY()));
        this.segmentEst.setC1(new Coordonnees(super.getCadreMaxX(), super.getCadreMinY()));

        this.segmentNord.setC2(new Coordonnees(super.getCadreMaxX(), super.getCadreMinY()));
        this.segmentSud.setC2(new Coordonnees(super.getCadreMaxX(), super.getCadreMaxY()));
        this.segmentOuest.setC2(new Coordonnees(super.getCadreMinX(), super.getCadreMaxY()));
        this.segmentEst.setC2(new Coordonnees(super.getCadreMaxX(), super.getCadreMaxY()));
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
     * @since 0.4.2.1
     */
    @Override
    public void deplacerDe(final double deltaX, final double deltaY) {
        this.setPosition(new Coordonnees(this.getFormeSelectionner().getPosition().getAbscisse() + deltaX,
                this.getFormeSelectionner().getPosition().getOrdonnee() + deltaY));
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
     * @since 0.4.2.1
     */
    @Override
    public void deplacerVers(final double nouvelleAbscisse, final double nouvelleOrdonnee) {
        this.setPosition(new Coordonnees(nouvelleAbscisse, nouvelleOrdonnee));
    }

    /**
     * Fonction permettant de modifié la largeur du {@code CadreSelection} vers
     * l'EST ou l'OUEST du cadre.
     * <p>
     * Dans le cas où l'on change la largeur du coté OUEST, le segment OUEST est
     * déplacé, et une seule des extrémités des segment SUD et NORD sont aussi
     * déplacées (celle du côté OUEST).
     * <p>
     * Dans le cas où l'on change la largeur du coté EST, le segment EST est
     * déplacé, et une seule des extrémités des segment SUD et NORD sont aussi
     * déplacées (celle du côté EST).
     * 
     * @param delta   Un {@code double} qui correspond à la valeur du décalage du
     *                segment dans le sens de l'axe des abscisse.
     * @param segment Un {@code int} qui correspond au coté vers lequel la
     *                modification prend effet.
     * 
     * @throws IllegalArgumentException Si le côté indiqué n'est pas valide.
     * 
     * @see #OUEST
     * @see #EST
     * @see #setLargeur(double)
     * @see #setHauteur(double, int)
     * 
     * @since 0.4.2.2
     */
    public void setLargeur(final double delta, final int segment) {
        switch (segment) {
            case CadreSelection.OUEST:
                try {
                    this.setLargeur(super.getLargeur() - delta);
                } catch (final IllegalArgumentException i) {
                    break;
                }
                this.segmentOuest.deplacerDe(delta, 0);
                this.segmentNord.setC1(this.segmentOuest.getC1());
                this.segmentSud.setC1(this.segmentOuest.getC2());
                super.setPosition(this.segmentOuest.getC1());

                if (this.getFormeSelectionner().getLargeur() > 0) {
                    // Dans le cas ou la largeur est négative, la position de la forme est du côté
                    // EST
                    this.getFormeSelectionner().deplacerDe(delta, 0);
                }
                break;

            case CadreSelection.EST:
                try {
                    this.setLargeur(super.getLargeur() + delta);
                } catch (final IllegalArgumentException i) {
                    break;
                }

                this.segmentEst.deplacerDe(delta, 0);
                this.segmentNord.setC2(this.segmentEst.getC1());
                this.segmentSud.setC2(this.segmentEst.getC2());

                if (this.getFormeSelectionner().getLargeur() < 0) {
                    // Dans le cas ou la largeur est positive, la position de la forme est du côté
                    // OUEST
                    this.getFormeSelectionner().deplacerDe(delta, 0);
                }

                break;
            default:
                throw new IllegalArgumentException("Le côté donné n'est pas valide");
        }
    }

    /**
     * Fonction permettant de modifié la hauteur du {@code CadreSelection} vers le
     * SUD ou le NORD du cadre.
     * <p>
     * Dans le cas où l'on change la hauteur du coté NORD, le segment NORD est
     * déplacé, et une seule des extrémités des segment OUEST et EST sont aussi
     * déplacée (celle du côté NORD).
     * <p>
     * Dans le cas où l'on change la hauteur du coté SUD, le segment SUD est
     * déplacé, et une seule des extrémités des segment OUEST et EST sont aussi
     * déplacée (celle du côté SUD).
     * 
     * @param delta   Un {@code double} qui correspond à la valeur du décalage du
     *                segment dans le sens de l'axe des ordonnées.
     * @param segment Un {@code int} qui correspond au coté vers lequel la
     *                modification prend effet.
     * 
     * @throws IllegalArgumentException Si le côté indiqué n'est pas valide.
     * 
     * @see #NORD
     * @see #SUD
     * @see #setHauteur(double)
     * @see #setLargeur(double, int)
     * 
     * @since 0.4.2.2
     */
    public void setHauteur(final double delta, final int segment) {
        switch (segment) {
            case CadreSelection.NORD:
                try {
                    this.setHauteur(super.getHauteur() - delta);
                } catch (final IllegalArgumentException i) {
                    break;
                }

                this.segmentNord.deplacerDe(0, delta);
                this.segmentOuest.setC1(this.segmentNord.getC1());
                this.segmentEst.setC1(this.segmentNord.getC2());
                super.setPosition(this.segmentNord.getC1());

                if (this.getFormeSelectionner().getHauteur() > 0) {
                    // Dans le cas ou la hauteur est négative, la position de la forme est du côté
                    // SUD
                    this.getFormeSelectionner().deplacerDe(0, delta);
                }
                break;

            case CadreSelection.SUD:
                try {
                    this.setHauteur(super.getHauteur() + delta);
                } catch (final IllegalArgumentException i) {
                    break;
                }
                this.segmentSud.deplacerDe(0, delta);
                this.segmentOuest.setC2(this.segmentSud.getC1());
                this.segmentEst.setC2(this.segmentSud.getC2());

                if (this.getFormeSelectionner().getHauteur() < 0) {
                    // Dans le cas ou la hauteur est positive, la position de la forme est du côté
                    // NORD
                    this.getFormeSelectionner().deplacerDe(0, delta);
                }
                break;
            default:
                throw new IllegalArgumentException("Le côté donné n'est pas valide");
        }
    }

    /**
     * Accesseur des différent segments composant le cadre.
     * 
     * @return Un tableau de {@code Ligne} rangé dans l'ordre NORD, EST, SUD et
     *         OUEST.
     * 
     * @see #NORD
     * @see #EST
     * @see #SUD
     * @see #OUEST
     * 
     * @since 0.4.2.1
     */
    public Ligne[] getCadre() {
        final Ligne[] tab = new Ligne[4];
        tab[CadreSelection.NORD] = this.segmentNord;
        tab[CadreSelection.EST] = this.segmentEst;
        tab[CadreSelection.OUEST] = this.segmentOuest;
        tab[CadreSelection.SUD] = this.segmentSud;
        return tab;
    }

    /**
     * Accesseur de la {@code Forme} lié au cadre.
     * 
     * @return La {@code Forme} lié au cadre.
     * 
     * @since 0.4.2.1
     */
    public Forme getFormeSelectionner() {
        return this.formeSelectionner;
    }

    /**
     * Fonction déterminant de déterminer qu'elle segment doit être déplacé en
     * fonction de celui sélectionner.
     * <p>
     * Dans le cas où seul le segment NORD ou SUD sont sélectionner, alors seulement
     * le décalage dans le sens de l'axe des ordonnées est prit en compte. Dans le
     * cas où seul le segment OUEST ou EST sont sélectionner, alors seulement le
     * décalage dans le sens de l'axe des abscisses est prit en compte.
     * 
     * @param deltaLargeur Un {@code double} représentant le décalage selon l'axe
     *                     des abscisse.
     * @param deltaHauteur Un {@code double} représentant le décalage selon l'axe
     *                     des ordonnées.
     * 
     * @see #contient(Coordonnees)
     * @see #setLargeur(double, int)
     * @see #setHauteur(double, int)
     * 
     * @since 0.4.2.2
     */
    public void deplacementSegment(final double deltaLargeur, final double deltaHauteur) {
        // Dans le cas d'un tracé il n'est pas possible de redimensioner, mais la forme
        // serait déplacé malgré tout
        if (!(this.getFormeSelectionner() instanceof TracerCrayon)) {
            if (this.idSelection.contains("N")) {
                this.setHauteur(deltaHauteur, CadreSelection.NORD);
            } else if (this.idSelection.contains("S")) {
                this.setHauteur(deltaHauteur, CadreSelection.SUD);
            }

            if (this.idSelection.contains("O")) {
                this.setLargeur(deltaLargeur, CadreSelection.OUEST);
            } else if (this.idSelection.contains("E")) {
                this.setLargeur(deltaLargeur, CadreSelection.EST);
            }
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @return Un {@code double} correspondant à l'aire du cadre.
     * 
     * @see Ligne#perimetre()
     * 
     * @since 0.4.2.1
     */
    @Override
    public double aire() {
        return this.segmentEst.perimetre() * this.segmentNord.perimetre();
    }

    /**
     * {@inheritDoc}
     * 
     * @return Un {@code double} correspondant au périmètre du cadre.
     * 
     * @see Ligne#perimetre()
     * 
     * @since 0.4.2.1
     */
    @Override
    public double perimetre() {
        return 2 * this.segmentEst.perimetre() + 2 * this.segmentNord.perimetre();
    }

    /**
     * {@inheritDoc}
     * <p>
     * On concidére un point appartenant au cadre si celui si se trouve sur le
     * cadre, l'intérieur du cadre n'est pas prise en compte.
     * 
     * @return {@code true} si le point appartient au cadre, {@code false} sinon.
     * 
     * @see Ligne#contient(Coordonnees)
     * 
     * @since 0.4.2.1
     */
    @Override
    public boolean contient(final Coordonnees coordonnees) {
        this.idSelection = "";

        if (this.segmentNord.contient(coordonnees)) {
            this.idSelection += "N";
        } else if (this.segmentSud.contient(coordonnees)) {
            this.idSelection += "S";
        }

        if (this.segmentOuest.contient(coordonnees)) {
            this.idSelection += "O";
        } else if (this.segmentEst.contient(coordonnees)) {
            this.idSelection += "E";
        }
        return !(this.idSelection.equals(""));
    }

    /**
     * Accesseur de l'identifiant du coté sélectionner.
     * <p>
     * Ses différentes valeur peuvent être:
     * <ul>
     * <li><i>N</i>,<i>E</i>, <i>O</i>, ou <i>S</i> en fonction de si le segment
     * NORD, EST, OUEST ou SUD à été sélectionner.</li>
     * <li><i>NE</i>, <i>NO</i>, <i>SO</i> ou <i>SE</i> en fonction de si le coin
     * NORD-OUEST, NORD-EST, SUD-OUEST ou SUD-EST du cadre à été sélectionner.</li>
     * </ul>
     * 
     * @return Une {@code String} permettant d'identifier qu'elle coté à été
     *         sélectionner.
     * 
     * @see #contient(Coordonnees)
     * 
     * @since 0.4.2.1
     */
    public String getCoteSelectionner() {
        return this.idSelection;
    }

    /**
     * Fonction retournant une description du cadre.
     * <p>
     * Les quatres première lignes sont une description des segments composant le
     * cadre, la cinquième est une description de la {@code Forme} sélectionner liée
     * au cadre.
     * 
     * @see Ligne#toString()
     * 
     * @since 0.4.2.1
     */
    @Override
    public String toString() {
        return "Segment NORD : " + this.segmentNord.toString() + "\nSegment EST : " + this.segmentEst.toString()
                + "\nSegment SUD : " + this.segmentSud.toString() + "\n Segment OUEST : " + this.segmentOuest.toString()
                + "\nForme Sélectionner " + this.formeSelectionner.toString();
    }
}