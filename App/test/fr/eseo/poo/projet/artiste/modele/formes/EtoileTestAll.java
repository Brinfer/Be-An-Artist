package fr.eseo.poo.projet.artiste.modele.formes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite de test permettant de lancer l'ensemble des tests de Etoile.
 * 
 * @see EtoileTest
 * @see EtoileTestPerimetreParameterized
 * @see EtoileTestAireParameterized
 * @see EtoileTestToStringParameterized
 * @see EtoileTestContientTrueParameterized
 * @see EtoileTestContientFalseParameterized
 * @see EtoileTestGetCordonneesParameterized
 * @see EtoileTestgetCoordonneesPolygoneParameterized
 * 
 * @author Brinfer
 * 
 * @since 0.3.7.1
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ EtoileTest.class, EtoileTestPerimetreParameterized.class, EtoileTestAireParameterized.class,
        EtoileTestToStringParameterized.class, EtoileTestContientTrueParameterized.class,
        EtoileTestContientFalseParameterized.class, EtoileTestGetCordonneesParameterized.class,
        EtoileTestgetCoordonneesPolygoneParameterized.class })
public class EtoileTestAll {

    // Couverture de l'ensemble des constructeurs : 100%
    // Couverture des branches des constructeurs : 100%

    // Couverture des instructions de setHauteur() : 100%
    // Couverture des branches de setHauteur() : 100%

    // Couverture des instructions de setLongueurBranche() : 100%
    // Couverture des branches de setLongueurBranche() : 100%

    // Couverture des instructions de setAnglePremiereBranche() : 100%
    // Couverture des branches de setAnglePremiereBranche() : 100%

    // Couverture des instructions de setPosition() : 0%

    // Couverture des instructions de setLargeur() : 100%

    // Couverture des instruction de contient() : 100%
    // Couverture des branches de contient() : 100%

    // Couverture des instructions pour calculPositionPolynome() : 100%
    // Couverture des branches pour calculPositionPolynome() : 100%

    // Couverture des instructions pour calculPositionSommet() : 100%
    // Couverture des branches pour calculPositionSommet() : 100%

    // Couverture des instructions de setNombreBranches() : 100%
    // Couverture des branches de setNombreBranches() : 100%

    // Couverture instruction pour aire : 100%

    // Couverture des instructions pour toString : 100%
    // Couverture des branches pour toString : 100%

    // Couverture des instructions pour perimetre : 100%
	
	// Couverture des instructions de equals() : 100%
    // Couverture des branches de equals() : 91.7%

    // Couverture des instructions de Etoile : 98.1%
    // Couverture des branches de Etoile : 98.2%
}