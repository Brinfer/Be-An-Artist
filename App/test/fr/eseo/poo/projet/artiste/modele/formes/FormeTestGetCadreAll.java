package fr.eseo.poo.projet.artiste.modele.formes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite de tests permettant de lancer l'ensemble des tests des methodes donnant
 * les coordonnees du rectangle englobant la forme.
 * 
 * @see FormeTestGetCadreMinXParameterized
 * @see FormeTestGetCadreMinYParameterized
 * @see FormeTestGetCadreMaxXParameterized
 * @see FormeTestGetCadreMaxYParameterized
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.3
 * 
 * @version 0.3.2.3
 */
@RunWith(Suite.class)
@SuiteClasses({ FormeTestGetCadreMinYParameterized.class, FormeTestGetCadreMinXParameterized.class,
		FormeTestGetCadreMaxYParameterized.class, FormeTestGetCadreMaxXParameterized.class })
public class FormeTestGetCadreAll {
	// Couverture des instructions pour getCadreMaxX : 100%
	// Couverture des instructions pour getCadreMaxY : 100%
	// Couverture des instructions pour getCadreMinX : 100%
	// Couverture des instructions pour getCadreMinY : 100%
}