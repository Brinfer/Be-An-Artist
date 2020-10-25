# Changelog

## 0.4.6

Ajout d'une __Forme__ : __Epicycloide__ permettant de représenter une épicycloïde, cette classe est enfant de __TracerCrayon__. Il est maintenant possible de choisir entre dessiner à main levé ou une épicycloïde avec le crayon.

### Added

- ajout du modèle : Epicycloide
- ajout de la vue : VueEpicycloide
- ajout de l'outil : OutilEpicycloide
- ajout de l'action : ActionChoisirRapport
- ajout de l'action : ActionCrayon

### Changed

- modification de l'ihm : PanneauBarreOutils
- modification de l'ihm : PanneauDessin

## 0.4.5

Ajout d'action à __OutilSelectionner__, maintenant on peut choisir d'effacer ou de changer la couleur d'une __Forme__ sélectionner.

### Added

- ajout de l'outil : OutilEffacer.
- ajout de l'outil : OutilChangerCouleur.

### Changed

- modification de l'action : ActionSelectionner.

## 0.4.4

Ajout de la possibilités de choisir l'épaisseur du trait avec lequel une forme sera dessiner. Modification de la gestion des placements des composants dans l'IHM __PanneauBarreOutils__.

### Addded

- ajout de l'action : ActionChoisirEpaisseurTrait
- ajout de l'action : ActionChoisirLongueurBranches
- ajout de l'action : ActionChoisirNombreDeBranche
- ajout de l'interface pour les modèles : EpaisseurTrait

### Changed

- modification de l'ihm : PanneauBarreOutil
- modification de l'action : ActionChoisirForme
- modification de l'outil : OutilEtoile
- modification de l'outil : OutilLigne
- modification de l'outil : OutilEllipse
- modification de l'outil : OuitlTraceCrayon
- modification du modèle abstrait : Forme
- modification du modèle : Ligne
- modification du modèle : Ellipse
- modification du modèle : TracerCrayon

## 0.4.3

Ajout d'un __Outil__ permettant de dessiner une __Forme__ quelconque avec la souris. La forme dessiner le tracé de la souris.

### Added

- ajout du modèle : TracerCrayon
- ajout de la vue : VueTracerCrayon
- ajout de l'outil : OutilTracerCrayon

## 0.4.2

Ajout d'un cadre autour de la __Forme__ sélectionner avec l'__OutilSelectionner__. Il est possible de changer les dimensions de la __Forme__ sélectionner en redimensionnant celle du cadre à l'aide de la souris.

### Added

- ajout du modèle : CadreSelection.
- ajout de la vue : VueCadreSelection.

### Changed

- modification de l'outil : OutilSelectionner.

## 0.4.1

Ajout d'une extension permettant de déplacer une __Forme__ sélectionner si on maintient le bouton gauche de la souris enfoncé et que l'on déplace celle-ci.

### Changed

- modification de l'outil : OutilSelectionner.

## 0.3.8

Création de l'application.

### Added

- ajout d'une classe permettant de lancer l'application.

## 0.3.7

### Added

- ajout du modèle : Etoile.
- ajout de la vue : VueEtoile.

### Changed

- modification de l'IHM : PanneauBarreOutils, ajout d'un bouton permettant de choisir dessiner des étoiles.

## 0.3.6

Ajout du remplissage des __Forme__ dessiner.

### Added

- ajout du modèle : Remplissable.
- ajout du contrôleur : ActionChoisirRemplissage.

### Changed

Ajout à la description des __Forme__ si elles sont rempli.

</br>

- modification du modèle : Ellipse, permettant de stocker le mode de remplissage de l'ellipse et de retourner l'information sur son mode de remplissage.
- modification du modèle : Cercle, permettant de stocker le mode de remplissage du cercle et de retourner l'information sur son mode de remplissage.
- modification de la vue : VueEllipse, permettant de dessiner une ellipse rempli si celui-ci est plein.
- modification de la vue : VueCercle, permettant de dessiner un cercle rempli si celui-ci est plein.
- modification de l'IHM : PanneauBarreOutils, ajout d'un bouton permettant de choisir de remplir ou non le remplissage des formes.

## 0.3.5

Ajout des couleurs, permettant de colorer les __Forme__.

### Added

- ajout du modèle : Coloriable.
- ajout du contrôleur : ActionChoisirCouleur.

### Changed

- modification du modèle : Forme, afin de pouvoir stocker sa couleur, et pouvant retourner les informations sur sa couleur.
- modification de la vue : VueLigne, permettant de dessiner les lignes selon leur couleur.
- modification de la vue : VueEllipse, permettant de dessiner les ellipse selon leur couleur.
- modification de la vue : VueCercle, permettant de dessiner les cercles selon leur couleur.
- modification de l'IHM : PanneauBarreOutils, ub boutons de sélection de la couleur à été ajouté.

## 0.3.4.10

Définition d'un outil permettant de sélectionner une __Forme__ déjà dessinée.

### Added

- ajout de l'outil : OutilSelectionner.

### Changed

- modification de l'IHM : PanneauBarreOutils, un boutons de sélectionner les __Formes__ dessiner à été rajouté.

## 0.3.4.9

Ajout à la barre d'outil de boutons permettant de choisir quelle __Forme__ dessiner.

### Added

- ajout du contrôleur : ActionChoisirForme.

### Changed

- modification de l'IHM : PanneauBarreOutils, des boutons permettant de sélectionner la forme à dessiner ont été rajoutés.

## 0.3.4.7

Définitions de OutilEllipse et de OutilCercle afin de pouvoir dessiner une __Ellipse__ et un __Cercle__.

### Added

- ajout de l'outil : OutilEllipse.
- ajout de l'outil : OutilCercle.

## 0.3.4.5

L’utilisateur à un moyen d'effacer. Pour cela, nous ajoutons une barre d’outils dur l’interface.

### Added

- ajout de l'interface Homme Machine : PanneauBarreOutils.
- ajout de l'action : ActionEffacer.

## 0.3.4.3

Définitions de __OutilLigne__ afin de pouvoir dessiner une __Ligne__.

### Added

- ajout de l'outil : OutilLigne.

## 0.3.4.2

Définitions d'un __Outil__ abstrait pour les __Forme__.

### Added

- ajout de l'outil générique à tout les Outils dédié aux modèles : OutilForme.

## 0.3.4.1

Définitions de la classe abstraite __Outil__ implémente l’interface _javax.swing.MouseInputListener_. Une classe qui implémente cette interface peut gérer les interactions de la souris.

### Added

- ajout de l'outil générique à tout les autres Outils : Outil.

## 0.3.3.7

Définitions de la Vue pour les __Forme__, __Ellipse__ et __Cercle__.

### Added

- ajout de la vue : VueEllipse.
- ajout de la vue : VueCercle.

## 0.3.3.4

Définitions de la première __Vue__ pour une __Forme__.

### Added

- ajout de de la vue générique à tout les modèles : VueForme.
- ajout de la vue : VueLigne.

## 0.3.3.1

Création d'un panneau permettant d'afficher les dessins.

## Added

- ajout de l'interface Homme Machine : PanneauDessin.

## 0.3.2.8

Ajout de la méthode contient, permettant de savoir si une __Coordonnees__ donnée se trouve à l’intérieur d’une __Forme__ ou pas.

### Changed

- ajout de la méthode abstraite contient dans Forme.
- ajout de la méthode contient dans Ligne.
- ajout de la méthode contient dans Ellipse.
- ajout de la méthode contient dans Cercle.

## 0.3.2.6

Définition de la __Forme__ : __Ellipse__, définie par la position du coin supérieur à gauche de son rectangle englobant, de sa largeur et de sa hauteur. De ce modèle dérive le __Cercle__, dont la hauteur et la largeur sont égales.

### Added

- ajout du modèle : Ellipse.
- ajout du modèle : Cercle.

## 0.3.2.4

Définition de la première __Forme__ : la __Ligne__. Dans notre modèle, une __Ligne__ est définie par un premier point et par le vecteur entre ce premier point et l’autre extrémité de la __Ligne__.

### Added

- ajout du modèle : Ligne.

## 0.3.2.3

Definitions d'un modèle servant de base pour les autres __Modèles__.

### Added

- ajout du modèle générique à tout les modèles : Forme.

## 0.3.2.1

Définitions d'un premier modèle afin de représenté les __Coordonnées__ des autres __Modèles__.

### Added

- ajout du modèle : Coordonnees.

## 0.3.1

Initialisation du projet.
