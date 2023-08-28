# CapriciousFramework
Ce framework fournit un Service CRUD générique capricieux pour Java Spring qui n'est utilisable qu'en étant poli.

## Comment ça marche
C'est un service très susceptible qui est très attaché à la politesse. Il peut être injecté comme n'importe quel @Service.  
Avant la première utilisation il convient de dire bonjour au service en utilisant la méthode
appropriée en fonction de l'heure du jour : **goodMorning()**, **goodAfternoon()** ou **goodEvening()**.  
Un fois le service salué, pour accéder à ses méthodes CRUD, il faudra formuler sa requête poliment grace à la
méthode **couldYou()**. Cette méthode retourne une classe interne contenant l'ensemble des méthodes CRUD.  
Attention cependant, ces méthodes ne retournent pas directement l'objet désiré, mais un wrapper de l'objet.
Il faudra alors utiliser la méthode **please()** pour effectivement obtenir l'objet, du moins si le service est de
bonne humeur.  
Si vous sollicitez trop le service, il peut refuser de vous retourner l'objet, c'est pourquoi il est important de
toujours le remercier avec la méthode **thankYou()**.  
Vous avez également la possibilité de le complimenter si le service a accumulé trop de ressentiment.

Une documentation plus fournie avec consultable dans l'interface CapriciousService.

## Comment l'utiliser
Vous pouvez utiliser les méthodes du service sur n'importe quelle entité. Pour cela il suffit de :
1. Créer une entité héritant de la classe **BaseEntity**.
2. Créer un repository héritant de **GenericRepository**.
3. Créer un service héritant de **CapriciousServiceImpl**.

Un exemple d'utilisation est fourni dans le projet avec une entité **Person**.
