# Changelog

## 0.3.8

Création de l'application.

### Added

- ajout d'une classe permettant de lancer l'application.

## 0.3.7

### Added

- ajout du modèle : Etoile.
- ajout de la vue : VueEtoile.

### Changed

Ajout d'un bouton permettant de choisir dessiner des étoiles.

</br>

- modification de l'IHM : PanneauBarreOutils.

## 0.3.6

Ajout du remplissage des formes dessiner.

### Added

- ajout du modèle : Remplissable.
- ajout du contrôleur : ActionChoisirRemplissage.

### Changed

Ajout à la description des formes si elles sont rempli.

</br>

- modification du modèle : Ellipse.
- modification du modèle : Cercle.

Une nouvelle forme dessiné sera maintenant pleine en fonction du choix de l'utilisateur.

</br>

- modification de la vue : VueEllipse.
- modification de la vue : VueCercle.

Ajout d'un bouton permettant de choisir de remplir ou non le remplissage des formes.

</br>

- modification de l'IHM : PanneauBarreOutils.

## 0.3.5

Ajout des couleurs, permettant de colorer les formes.

### Added

- ajout du modèle : Coloriable.
- ajout du contrôleur : ActionChoisirCouleur.

### Changed

Ajout à la description de la forme le détail de sa couleur au format RVB.

</br>

- modification du modèle : Forme.

Une nouvelle forme dessiné aura maintenant la couleur courante choisie par l'utilisateur.

</br>

- modification de la vue : VueLigne.
- modification de la vue : VueEllipse.
- modification de la vue : VueCercle.

Ajout d'un bouton permettant de choisir la couleur des formes.

</br>

- modification de l'IHM : PanneauBarreOutils.

## 0.3.4

Ajout de la partie contrôleur de l’application chargée de gérer les interactions entre l’application et l’utilisateur.

### Added

- ajout de l'interface Homme Machine : PanneauBarreOutils.
- ajout de l'outil générique à tout les autres Outils : Outil.
- ajout de l'outil générique à tout les Outils dédié aux modèles : OutilForme.
- ajout de l'outil : OutilLigne.
- ajout du contrôleur : ActionEffacer.
- ajout du contrôleur : ActionChoisirForme.
- ajout ddu contrôleur : OutilSelectionner.

## 0.3.3

Définitions des Vues des Modèles définie auparavant.

### Added

- ajout de l'interface Homme Machine : PanneauDessin.
- ajout de de la vue générique à tout les modèles : VueForme.
- ajout de la vue : VueLigne.
- ajout de la vue : VueEllipse.
- ajout de la vue : VueCercle.

## 0.3.2

Définitions de différent Modèle formant la base des futures formes pour l'affichage de celle-ci.

### Added

- ajout du modèle : Coordonnees.
- ajout du modèle générique à tout les modèles : Forme.
- ajout du modèle : Ligne.
- ajout du modèle : Ellipse.
- ajout du modèle : Cercle.

## 0.3.1

Initialisation du projet.
