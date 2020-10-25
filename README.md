# Be-An-Artist

<p align="center">

<img  src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Logo_ESEO_GROUPE.jpg/1280px-Logo_ESEO_GROUPE.jpg" width="200" height="">

</p>

Projet réalisé dans le cadre du Grand Projet Informatique 1 en première année de cycle ingénieure de l'École d'Électronique de L'Ouest 2020.

## Préambule

Développer un éditeur graphique offrant des fonctionnalités similaires à celles fournies par des logiciels bien connus de tous (eg Dia, Inkscape ou MSPaint).

L’éditeur que conçu dans le cadre de ce travail permettra de dessiner les formes géométriques telles que les lignes, les ellipses, les cercles et les étoiles.

Pour programmer cette application, nous suivrons le patron d’architecture logicielle (software architectural pattern) Modèle-Vue-Contrôleur (MVC). Cette architecture spécifie une méthodologie permettant de faciliter le développement d’une application graphique interactive.

## Les objets "Modèle"

Les objets Modèle représentent les connaissances et expertises spécifiques à l’application. Ils contiennent les données d’une application et définissent la logique de manipulation de ces données.

## Les objets "Vue"

Un objet Vue sait comment afficher et éventuellement modifier les données du modèle d’application. En revanche, il n’est pas responsable du stockage des données qu’il affiche.
Un objet Vue peut être chargé d’afficher une partie d’un objet Modèle ou un objet Modèle entier ou bien encore plusieurs objets Modèle différents. Les objets Vue sont de différentes sortes. Par ailleurs, un objet Modèle peut être présenté de diverses manières par différents objet Vue.
Un objet Vue assure que l’objet Modèle est affiché correctement. En conséquence, il a besoin de connaître les changements que l’objet Modèle subit. Les objets Modèle n’étant pas liés directement aux objets Vue, ils ont besoin d’une voie générique pour leur signaler des changements dans leur état. Ainsi, ils peuvent envoyer des notifications à leur Vue pour signaler des changements dans leur état qui impliquent une modification de leur présentation par la Vue. Ce mécanisme de communication est généralement fait via la couche Contrôleur de l’application.

## Les Objets "Contrôleur"

Un objet Contrôleur agit comme un intermédiaire entre les objets Vue et Modèle de l’application. Lorsque l’utilisateur agit sur la Vue, avec sa souris, son clavier, en appuyant sur des boutons ou en sélectionnant des éléments dans des menus, il agit sur des objets Vue et ses actions doivent avoir pour conséquence de modifier les objets Modèle, qui à leur tour peuvent modifier la Vue de l’objet Modèle associé. La mise en oeuvre de ce processus est assurée par les objets Contrôleur. Les objets Contrôleur représentent ainsi le canal par lequel les objets Vue et Modèle communiquent.

## Lancement

Pour lancer l'application, il suffit d'exécuter la commande `java -jar Be-An-Artist.jar` à la racine du projet.
