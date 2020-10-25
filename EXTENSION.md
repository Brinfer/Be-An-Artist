# Les extensions au projet

## 0.4.6 Ajout d'une forme : les épicycloïde

A l'aide de l'__OutilCrayon__, il est possible de dessiner des épicycloïdes. Pour cela, un nouveau modèle a été crée : __Epicycloide__. Le dessin ce fera à l'aide de __OutilEpicycloide__ qui prendra pour rayon du cercle de base la distance entre le point de clic et le point de relâchement. Le point de relâchement sera le centre de ce cercle. Le rayon du cercle roulant sera calculé avec le rayon de ce cercle de base et le rapport *R / r* (où *R* est le rayon du cercle de base et *r* celui du cercle roulant) choisie par l'utilisateur dans une liste proposé.

Il n'est pas possible de redimensionner __Epicycloide__ étant donné qu'elle est enfant de __TracerCrayon__.

## 0.4.5 Ajout d'action avec la sélection

L'utilisateur peut désormais changer la couleur ou effacer les formes qu'il sélectionne grâce à un simple click. Ces actions sont lié à des __Outils__ enfants de l'__OutilSelectionner__ permettant de ré-utiliser les méthodes de sélection du parent. L'__OutilChangerCouleur__ peut contrairement à l'__OutilEffacer__ déplacer les __Formes__ sélectionner.

## 0.4.4 Ajout de l'option : épaisseur du trait

L'utilisateur peut désormais sélectionner l'épaisseur du trait avec laquelle les __Formes__ seront dessiner dans le __PanneauDessin__.

_Amélioration possible_ : Actuellement les fonctions __*contient(Coordonnees)*__ des __Formes__ ne prennent pas en compte l'épaisseur du trait du dessin, il pourrait être intéressant que cela soit le cas. Sauf dans le cas de__TracerCrayon__ dans le cas où le tracé n'est pas rempli, le click doit être à moins de 1.5 fois l'épaisseur du trait.

## 0.4.3 Ajout d'une "forme" : le tracer d'un crayon

L'ajout du __Modèle__ __TracerCrayon__ permet de dessiner des __Formes__ quelconque à l'aide la souris en maintenant un bouton enfoncer. Une fois le bouton relâcher, la forme est considéré comme fini. Il n'est pas possible de redommensionner le tracé par la suite.

Dans le cas où la __JChecbox__ est coché, le __TracerCrayon__ est rempli.

La fonction __*contient(Coordonnonnes)*__ de cette classe va agir différemment en fonction de si le tracé est rempli ou non. Si le tracer est rempli, alors on utilise la méthode du *ray-casting* . Dans le cas ou la figure n'est pas remplie on mesure la distance entre le point du click et les points du tracé.

## 0.4.2 Redimensionnement de la forme sélectionner

La modification de l'__OutilSelectionner__ permet d'encadrer la __Forme__ sélectionner, le cadre va alors suivre la forme dans ses déplacements. Il est possible de modifier les dimensions de la __Forme__ sélectionner en déplaçant les segments du cadre avec la souris en maintenant le bouton droit de la souris enfoncé.

__OutilSelectionner__ est ainsi devenue un enfant de __OutilForme__ afin de pouvoir afficher un cadre autour de la __Forme__ sélectionner.
Le modèle __CadreSelection__ à été ajouté ainsi que la vue __VueCadreSelection__ afin de pouvoir l'afficher dans le __PanneauDessin__.

_Note_ : il est aussi possible de redimensionner la __Forme__ sélectionner en déplaçant les coin du cadre mais il est assez délicat de sélectionner un des coins du cadre.

## 0.4.1 Déplacement des formes

La modification de l'__OutilSelectionner__ rend maintenant possible le déplacement dans la zone de dessin la __Forme__ sélectionner.
Un double clic permet l'ouverture d'une fenêtre renseignant l'utilisateur de la forme sélectionner.
Il est ensuite possible de déplacer la forme en maintenant enfoncé le bouton gauche de la souris.

_Note_ : il n'est pas nécessaire de faire un double clic avant pour déplacer la __Forme__, un simple click sélectionne déjà la __Forme__, mais n'affiche pas les informations.

## Autres Changements

Auparavant, l'__OutilEtoile__ prenait en paramètre pour son constructeur un __PanneauBarreOutils__ afin de pouvoir récupérer les valeurs des __JSpinner__ dédié à son nombre et à la longueur de ses branches. Dorénavant, il passe par le __PanneauDessin__ pour avoir ces valeurs, sur le même principe que pour connaître la couleur courante des dessins. Cela est possible grâce au classes __ActionChoisirLongueurBranches__ et __ActionChoisirNombreDeBranches__ qui fonctionnent exactement comme __ActionChoisirEpaisseurTrait__ : elles _implémente_ l'_interface_ __ChangeListener__ et surchargent la fonction __*stateChanged(ChangeEvent)*__ des __JSpinners__ lié aux __Actions__.

__ActionEffacer__ à été renomé en __ActionEffacerTout__ afin d'être cohérent avec la création de __OutilEffacer__.

__PanneauBarreOutils__ est un __Jpanel__ contenant 1 autres __JPanel__. IL contient l'ensembles des boutons et autres composant généraux (remplissage, épaisseur du trait...) et un autre __JPanel__ dont le gestionnaire de placement est un __CardLayout__. Ainsi on fait apparaitres les __JSpinner__ pour l'__Etoile__ que lorsqu'on utilise __OutilEtoile__ car ceux-ci sont dans un __JPanel__ dédié. Dans les autres cas, un __JPanel__ vide est visible.
Au final on a :
```
                PanneauBarreOutils : Contient 2 JPanels
                         ______________
                        |   _________   |
                        | |          -|-|--> Contient les boutons
                        | |           | |
                        | | _________ | |
                        |   _________   |
                        | |          -|-|--> Contient deux JPanels, utilise le gestionnaire CardLayout :
                        | |           | |               - L'un contient les boutons propre à l'étoile.
                        | | _________ | |               - L'un contient les boutons propre à la sélection.
                        | _____________ |               - L'un contient les boutons propres au crayon.
                                                        - L'un est vide pour quand il y en a besoin.
                                                        - Il est possible d'en rajouter pour d'autres outils.
```

## Localisation des changements

```
.
|
+-- src\fr\eseo\poo\projet\artiste
                                +-- controleur
                                |   +-- action
                                |       |   +-- ActionChoisirForme
                                |       |   +-- ActionChoisirEpaisseurTrait     -> Ajout
                                |       |   +-- ActionChoisirNombreDeBranches   -> Ajout
                                |       |   +-- ActionChoisirLongueurBranches   -> Ajout
                                |       |   +-- ActionSelectionner
                                |       |   +-- ActionEffacer  renomé en ActionEffacerTout
                                |       |   +-- ActionChoisirRapport            -> Ajout
                                |       |   +-- ActionCrayon                    -> Ajout
                                |       |
                                |       +-- outils
                                |           +-- OutilSelectionner
                                |           +-- OutilTracerCrayon               -> Ajout
                                |           +-- OutilLigne
                                |           +-- OutilEtoile
                                |           +-- OutilEllipse
                                |           +-- OutilEffacer                    -> Ajout
                                |           +-- OutilChangerCouleur             -> Ajout
                                |           +-- OutilEpicycloide                -> Ajout
                                |
                                +-- modele\forme
                                |           +-- CadreSelection                  -> Ajout
                                |           +-- TracerCrayon                    -> Ajout
                                |           +-- EpaisseurTrait                  -> Ajout
                                |           +-- Epicycloide                     -> Ajout
                                |           +-- Ligne
                                |           +-- Etoile
                                |           +-- Ellipse
                                |
                                |
                                +-- vue
                                        +-- forme
                                        |   +-- VueCadreSelection               -> Ajout
                                        |   +-- VueTracerCrayon                 -> Ajout
                                        |   +-- VueEpicycloide                  -> Ajout
                                        |   +-- VueLigne
                                        |   +-- VueEllipse
                                        |   +-- VueEtoile
                                        |
                                        +-- ihm
                                            +-- PanneauBarreOutil
                                            +-- PanneauDessin
```
