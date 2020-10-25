package fr.eseo.poo.projet.artiste.modele;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.eseo.poo.projet.artiste.modele.formes.CadreSelectionTestAll;
import fr.eseo.poo.projet.artiste.modele.formes.CercleTestAll;
import fr.eseo.poo.projet.artiste.modele.formes.EllipseTestAll;
import fr.eseo.poo.projet.artiste.modele.formes.EtoileTestAll;
import fr.eseo.poo.projet.artiste.modele.formes.FormeTestAll;
import fr.eseo.poo.projet.artiste.modele.formes.LigneTestAll;
import fr.eseo.poo.projet.artiste.modele.formes.TracerContourTestAll;

/**
 * Suite de test permettant de lancer l'ensemble des tests du package modele.
 * 
 * @see CoordonneesTestAll
 * @see CercleTestAll
 * @see EllipseTestAll
 * @see LigneTestAll
 * @see EtoileTestAll
 * @see CadreSelectionTestAll
 * @see TracerContourTestAll
 * 
 * @author Brinfer
 * 
 * @since 0.3.2.5
 * 
 * @version 0.4.3.1
 */
@RunWith(Suite.class)
@SuiteClasses({ CoordonneesTestAll.class, FormeTestAll.class, CercleTestAll.class, EllipseTestAll.class,
		LigneTestAll.class, EtoileTestAll.class, CadreSelectionTestAll.class, TracerContourTestAll.class })
public class ModeleTests {
	// Couverture des instruction Coordonnees : 100%

	// Couverture des instruction Etoile : 98.1%
	// Couverture des branches Etoile : 98.2%

	// Couverture des instruction Cercle : 67.9%
	// Couverture des branches Cercle : 0%

	// Couverture des instruction Ellipse : 92.8%
	// Couverture des branches Ellipse : 66.7%

	// Couverture des instruction Forme : 100%
	// Couverture des branches Forme : 91.7%

	// Couverture des instruction Ligne : 90.5%
	// Couverture des branches Ligne : 50%

	// Couverture des instructions package modele : 95.60%
	// Couverture des branches pour package modele : 86%
}
