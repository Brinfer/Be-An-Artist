package fr.eseo.poo.projet.artiste.modele.formes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite de test permettant de lancer l'ensemble des tests de TracerContour.
 * 
 * @see TracerCrayonTestContientFermerTrueParameterized
 * @see TracerCrayonTestContientFermerFalseParameterized
 * @see TracerContourTestPerimetreParameterized
 * @see TracerCrayonTestContientFalseParameterized
 * @see TracerCayonTestContientTrueParameterized
 * 
 * @author Brinfer
 * 
 * @since 0.4.3.1
 * 
 * @version 0.4.3.1
 */
@RunWith(Suite.class)
@SuiteClasses({ TracerCrayonTestContientFermerTrueParameterized.class,
        TracerCrayonTestContientFermerFalseParameterized.class, TracerContourTestPerimetreParameterized.class,
        TracerCayonTestContientTrueParameterized.class, TracerCrayonTestContientFalseParameterized.class })
public class TracerContourTestAll {

}