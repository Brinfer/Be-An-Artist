package fr.eseo.poo.projet.artiste.modele.formes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite de test permettant de lancer l'ensemble des tests de Cercle.
 * 
 * @see CercleTest
 * @see CercleTestPerimetreParameterized
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.7
 * 
 * @version 0.3.2.7
 */
@RunWith(Suite.class)
@SuiteClasses({ CercleTest.class, CercleTestPerimetreParameterized.class, })
public class CercleTestAll {
	// Couverture instruction de l'ensemble des constructeur : 100%
	
	// Couverture instruction perimetre : 100%
	
	// Couverture instruction setHauteur: 100%
	
	// Couverture instruction setLargeur : 100%
	
	// Couverture des instructions equals : 0%
	// Couverture des branches equals : 0%

	// Couverture instruction Cercle : 67.9%
	// Couverture des branches Cercle : 0%
}
