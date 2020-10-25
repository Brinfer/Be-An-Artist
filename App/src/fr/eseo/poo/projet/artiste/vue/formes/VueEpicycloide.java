package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Epicycloide;

/**
 * Classe {@code VueCercle} permettant l'affichage d'un cercle, à partir de la
 * classe {@linkplain Cercle}.
 * 
 * @see Cercle
 * 
 * @author Brinfer
 * 
 * @since 0.4.6.2
 */
public class VueEpicycloide extends VueTracerCrayon {

    /**
	 * Constructeur d'une nouvelle {@code VueEpicycloide}. L'instance de la classe est
	 * initialisé avec l'épicycloïde donnée en paramètre.
	 * 
	 * @param epicycloide Le {@code Epicycloide} que l'on souhaite afficher.
	 * 
	 * @see VueTracerCrayon#VueTracerCrayon(fr.eseo.poo.projet.artiste.modele.formes.Epicycloide)
	 * 
	 * @since 0.4.6.2
	 */
    public VueEpicycloide(Epicycloide epicycloide) {
        super(epicycloide);
    }
}