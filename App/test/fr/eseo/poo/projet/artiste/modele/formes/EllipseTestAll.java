package fr.eseo.poo.projet.artiste.modele.formes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite de test permettant de lancer l'ensemble des tests de Ellipse.
 * 
 * @see EllipseTest
 * @see EllipseTestAireParameterized
 * @see EllipseTestPerimetreParameterized
 * @see EllipseTestToStringParameterized
 * @see EllipseTestContientFalseParameterized
 * @see EllipseTestContientTrueParameterized
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.7
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ EllipseTest.class, EllipseTestAireParameterized.class, EllipseTestPerimetreParameterized.class,
		EllipseTestToStringParameterized.class, EllipseTestContientFalseParameterized.class,
		EllipseTestContientTrueParameterized.class })
public class EllipseTestAll {

	// Couverture des instruction pour l'ensemble des constructeur : 100%

	// Couverture des instructions pour aire : 100%

	// Couverture des instruction pour contient : 100%

	// Couverture des instruction pour perimetre : 100%

	// Couverture des instruction pour setLargeur : 100%
	// Couverture des branches pour setLargeur : 100%

	// Couverture des instruction pour setHauteur : 100%
	// Couverture des branches pour setHauteur : 100%

	// Couverture des instruction pour toString : 100%
	// Couverture des branches pour toString : 100%

	// Couverture des instruction pour equals : 0%
	// Couverture des branches pour equals : 0%
	
	// Couverture des instructions pour descriptionRemplissage : 100%
	// Couverture des branches pour descriptionRemplissage : 100%
	
	//Couverture des instructions pour estRempli : 0%
	
	// Couverture des instructions pour setRempli : 100%
	
	// Couvertures des instructions pour Ellipse: 92.8%
	// Couverture des branches pour Ellipse : 66.7%

}
