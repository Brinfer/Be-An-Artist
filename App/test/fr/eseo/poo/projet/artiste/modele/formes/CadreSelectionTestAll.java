package fr.eseo.poo.projet.artiste.modele.formes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suite de test permettant de lancer l'ensemble des tests de CadreSelection.
 * 
 * @see CadreSelectionTest
 * @see CadreSelectionTestSetLargeurParameterized
 * @see CadreSelectionTestSetHauteurParameterized
 * @see CadreSelectionTestSetLargeurDeltaParameterized
 * @see CadreSelectionTestSetHauteurDeltaParameterized
 * @see CadreSelectionTestContientTrueParameterized
 * 
 * @author Brinfer
 * 
 * @since 0.4.2.1
 * 
 * @version 0.4.2.1
 */
@RunWith(Suite.class)
@SuiteClasses({ CadreSelectionTest.class, CadreSelectionTestSetLargeurParameterized.class,
        CadreSelectionTestSetHauteurParameterized.class, CadreSelectionTestSetHauteurDeltaParameterized.class,
        CadreSelectionTestSetLargeurDeltaParameterized.class})
public class CadreSelectionTestAll {
}