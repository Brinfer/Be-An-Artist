package fr.eseo.poo.projet.artiste.modele.formes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite de test permettant de lancer l'ensemble des tests de la classe
 * {@link Forme}
 * 
 * @see FormeTest
 * @see FormeTestDeplacerDeParameterized
 * @see FormeTestDeplacerVersParameterized
 * @see FormeTestGetCadreAll
 * @see FormeTestDescriptionCouleurParameterized
 * 
 * @author gautiepi
 * 
 * @since 0.3.2.3
 * 
 * @version 0.3.6.1
 */
@RunWith(Suite.class)
@SuiteClasses({ FormeTest.class, FormeTestDeplacerDeParameterized.class, FormeTestDeplacerVersParameterized.class,
        FormeTestGetCadreAll.class, FormeTestDescriptionCouleurParameterized.class })
public class FormeTestAll {

    // Couverture des instructions pour l'ensemble des constructeurs: 100%
	
    // Couverture des instructions pour deplacerDe: 100%
	
    // Couverture des instructions pour deplacerVers: 100%
	
    // Couverture des instructions pour l'ensemble des getCadre : 100%
	
    // Couverture des instructions pour descriptionCouleur : 100%
    // Couverture des branches pour descriptionCouleur : 100%
	
	// Couvertures des instructions pour equals : 100%
	// Couvertures des branches pour equals : 90.0%

    // Couverture des instructions pour Forme: 100%
    // Couverture des branches pour Forme : 91.7%

}
