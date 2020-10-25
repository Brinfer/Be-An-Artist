package fr.eseo.poo.projet.artiste.modele.formes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite de test permettant de lancer l'ensemble des tests de Ligne.
 * 
 * @see LigneTest
 * @see LigneTestSetC2Parameterized
 * @see LigneTestGetC2Parameterized
 * @see LigneTestSetC1Parameterized
 * @see LigneTesttoStringParameterized
 * @see LigneTestContientFalseParameterized
 * @see LigneTestContientTrueParameterized
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.5
 * 
 * @version 0.3.2.8
 */
@RunWith(Suite.class)
@SuiteClasses({ LigneTestSetC2Parameterized.class, LigneTestGetC2Parameterized.class, LigneTest.class,
		LigneTestSetC1Parameterized.class, LigneTestToStringParameterized.class,
		LigneTestContientFalseParameterized.class, LigneTestContientTrueParameterized.class })
public class LigneTestAll {
	// Couverture des instructions pour l'ensemble des constructeurs : 100%

	// Couverture des instructions pour aire : 100%

	// Couverture des instructions pour perimetre : 100%

	// Couverture des instructions pour setC1 : 100%

	// Couverture des instructions pour setC2 : 100%

	// Couverture des instructions pour getC2 : 100%

	// Couverture des instructions pour toString : 100%
	// Couverture des branches pour toString: 100%

	// Couverture des instructions pour contient : 100%
	// Couverture des branches pour contient: 100%

	// Couverture des instruction pour equals : 0%
	// Couverture des branches pour equals : 0%


	// Couverture des instructions pour Ligne : 90.5%
	// Couverture des branches pour Ligne: 50%
}