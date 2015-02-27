Fonctionnement du framework :

La class Logger nous permet de gérer des log.

La class Configuration nous permet de gérer le framework, elle contient une liste des cibles et une liste des loggers définis par l'utilisateur.

On utilise une class abstraite qui nous permet d'utiliser une méthode afin de permettre à l'utilisateur d’ajouter une nouvelle cible

Utilisation du framework :

Il y a deux façons d'utiliser le framework :

	•	En configurant en Java
	•	En configurant grâce à un fichier properties


Avec le fichier : On doit écrire dans le fichier  dans les cibles souhaitées c'est à dire l’endroit où l’on souhaite que nos log apparaissent. On peut définir plusieurs cibles possibles. Exemple de définition d'une cible :

on marque la balise cible pour signaler au framework que l'on déclare une nouvelle cible.

	•	name : c'est le nom qu'on donne à notre cible
	•	type : est la fonction qu'on utilisera pour la faire fonctionner
	◦	marquer : "fr.esiea.ConsoleCible" pour écrire dans la console
	◦	: "fr.esiea.FileCible" pour écrire dans un fichier
	•	path : qui est un paramètre supplémentaire dont on se sert pour définir le fichier utiliser par exemple (on pourra aussi s'en servir si un jour on souhaite mettre une base de donnée comme cible en mettant le nom de la base). Il y a aussi la possibilité de définir facilement une nouvelle cible (cf plus bas)
Après les cibles il faut définir les logs : Exemple de définition d'un logger :

On marque la balise logger pour définir au framework qu'on déclare un nouveau logger.

	•	name : c'est la fonction auquel est rattaché le log
	•	level : le niveau souhaité pour ce log ( 3 niveaux possibles : INFO, DEBUG, ERROR)
	•	appendTo: la cible qu'on souhaite utilisé pour ce log.


On peut définir autant de log qu'on souhaite et autant de cible, les logs peuvent être ainsi rattaché à différentes cibles.

Avec le code java : Il suffit de : // déclarer une configuration Configuration conf = Configuration.getInstance(); // ajouter de nouvelles cibles conf.addCible(name, type, path); // ajouter de nouveaux logger conf.addLogger(cl, name, level, appentTo);

Utiliser un log :

Pour utiliser les log après avoir configurer notre framework il suffit d'écrire : Logger log = Configuration.getInstance().getLogger(MaClass.class); log.info("un log d'info");

Définir une nouvelle cible :

Pour définir une nouvelle cible il suffit d'étendre la nouvelle class qui gère la cible par "AbstractCible" De cette facon il y aura une méthode write à implémenter et un nom pour la cible, et le framework pourra s'en servir.
