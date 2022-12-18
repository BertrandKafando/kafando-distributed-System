# Activité pratique N° 4 : Sécurité des micro services avec Keycloak

##  Partie 1: Installation et Test de Keycloak

[Go to 👉 ] (../security-doc)

## Partie 2: Creation de l'architecture + keycloak

```
Création d'une config service
Création  d'un discovery Service
Création d'un gateway
Création des microservices Customer-service, Inventoy-service , Billing-service 

```

# Etape 1: Création d'un config service with spring cloud config server
[👉 link] (./config-service)

# Etape 2: Création d'un discovery service with consul
[👉link] (./discovery-service)
```
Ajout de la dependance consul discovery et lancer consul en local
```

# Etape 3: Création d'un gateway
[👉link] (./gateway-service)

# Etape 4: Création du micro-service Customer-service
[👉link] (./customer-service)


# Etape 5: Création du micro-service Inventory-service
[👉link] (./inventory-service)

# Etape 6: Création du micro-service Billing-service
[👉link] (./billing-service)

<br>


## Test 

```
-> run config-service
->run discovery-service
->run gateway-service
->run customer-service
->run inventory-service
->run billing-service
```

