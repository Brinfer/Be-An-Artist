package fr.eseo.poo.projet.artiste.modele;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite de test permettant de lancer l'ensemble des tests de
 * {@linkplain Coordonnees}.
 * 
 * @see EllipseTest
 * @see CoordonneesTestAngleVersParameterized
 * @see CoordonneesTestDeplacerDeParameterized
 * @see CoordonneesTestDeplacerVersParameterized
 * @see CoordonneesTestDistanceVersParameterized
 * @see CoordonneesTestToStringParameterized
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.2
 *
 * @version 0.3.2.2
 */
@RunWith(Suite.class)
@SuiteClasses({ CoordonneesTest.class, CoordonneesTestAngleVersParameterized.class,
		CoordonneesTestDeplacerDeParameterized.class, CoordonneesTestDeplacerVersParameterized.class,
		CoordonneesTestDistanceVersParameterized.class, CoordonneesTestToStringParameterized.class })
public class CoordonneesTestAll {

	// Couverture des instruction pour l'ensemble des constructeurs : 100%
	
	// Couverture des instruction pour angleVers : 100%
	
	// Couverture des instruction pour deplacerDe : 100%
	
	// Couverture des instruction pour deplacerVers : 100%
	
	// Couverture des instruction pour distanceVers : 100%
	
	// Cpuverture des instructions equals : 100%
	// Couverture des branches pour equals : 100%

	// Couverture des instruction pour toString : 100%

	// Couverture instruction pour Coordonnees : 100%
	// Couverture des branches pour Coordonnees : 100%
}
