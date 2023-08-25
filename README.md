# CapriciousFramework
Ce framework fournit un Service CRUD générique capricieux qui n'est utilisable qu'en étant poli.

## Comment l'utiliser
Vous pouvez utiliser les méthodes du service sur n'importe quelle entité. Pour cela il suffit de :
1. Créer une entité héritant de la classe **BaseEntity**.
2. Créer un repository héritant de **GenericRepository**.
3. Créer un service héritant de **CapriciousServiceImpl**.
Un exemple d'utilisation est fourni dans le projet avec une entité **Person**.
