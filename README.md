
![Java 21](https://img.shields.io/badge/Java-21-orange)

# MonCheminement - Plateforme Personnalisée de Planification des Études 


Application web pour la planification des études d'un étudiant.

## Description

Mon cheminement est une plateforme personnalisée qui planifie les études. En effet, il place l'étudiant au centre, et rassemble la composition d'un parcours, c'est-à-dire des cours, des projets, des postes en laboratoire, des stages, des séminaires, des concours, des équipes de recherche et des organisations partenaires. 

### Points clés

* Organiser le choix des cours pour chaque session de l'étudiant.
* Mettre en avant les tâches à accomplir.
* Participer à des séminaires, des concours et des organisations partenaires.
* Postuler dans des laboratoires et des stages.

---

## Technologies utilisées


### Backend

* Spring Boot
* Quarkus
* Micronaut


### Frontend

* React
* Next.js avec TypeScript
* Vue.js avec TypeScript

---

## Installation


---

## Utilisation d'API

Cette section présente les principaux endpoints prévus pour l'API du projet Mon cheminement. Les données échangées avec l'API sont représentées notamment en format JSON.

### Compte et authentification (Pour se connecter au compte de l'étudiant)

| Méthode | Endpoint              | Description                              |
| ------- | --------------------- | ---------------------------------------- |
| `POST`  | `/api/auth/login`     | Authentifier une personne étudiante      |
| `POST`  | `/api/auth/logout`    | Fermer la session                        |
| `GET`   | `/api/etudiants/{id}` | Consulter les informations d'un étudiant |

### Cours et cheminement (Parcours de l'étudiant)

| Méthode | Endpoint                          | Description                            |
| ------- | --------------------------------- | -------------------------------------- |
| `GET`   | `/api/cours`                      | Consulter les cours disponibles de la session |
| `GET`   | `/api/cours/{code}`               | Consulter les informations d'un cours  |
| `GET`   | `/api/cours/{code}/prerequis`     | Consulter les prérequis d'un cours     |
| `GET`   | `/api/etudiants/{id}/cheminement` | Consulter le cheminement de l'étudiant |
| `PUT`   | `/api/etudiants/{id}/cheminement` | Modifier le cheminement                |

### Planification

| Méthode  | Endpoint                                   | Description                     |
| -------- | ------------------------------------------ | ------------------------------- |
| `GET`    | `/api/etudiants/{id}/horaire`              | Consulter l'horaire             |
| `POST`   | `/api/etudiants/{id}/horaire/cours`        | Ajouter un cours à l'horaire    |
| `DELETE` | `/api/etudiants/{id}/horaire/cours/{code}` | Retirer un cours de l'horaire   |
| `GET`    | `/api/etudiants/{id}/conflits`             | Vérifier les conflits d'horaire |

### Activités (Stages, séminaires, concours, etc)

| Méthode | Endpoint              | Description                          |
| ------- | --------------------- | ------------------------------------ |
| `GET`   | `/api/activites`      | Consulter les activités disponibles  |
| `GET`   | `/api/activites/{id}` | Consulter les détails d'une activité |

### Notifications par courriel

| Méthode | Endpoint                     | Description                                      |
| ------- | ---------------------------- | ------------------------------------------------ |
| `POST`  | `/api/notifications/rappel`  | Envoyer un rappel concernant une date importante |

Les courriels seront envoyés avec l'utilisation de la bibliothèque **Nodemailer**.

### Format des données

Les données échangées avec l'API utilisent le format JSON.

Exemple :

```json
{
  "code": "IFT2255",
  "nom": "Génie logiciel",
  "credits": 3,
  "prerequis": ["IFT1025"]
}
```

---

## État d'avancement

Présentement, il n'y a aucun codage. 


---

## Structure du projet

```text
MonCheminement/
│
├── figures/       # Figures générées
├── code/          # 
├── rapport/       # Rapport final
└── 
```

---

## Auteurs

* Jimmy Pham ()
* Noromihanta Raharinivo Raharison ()
* Bing Shi ()
* Kevin Wang (20292635)

---

## Répartition des tâches



---

## Licence

Projet développé dans le cadre du cours de IFT2255 (Génie logiciel) à l'Université de Montréal (UdeM).

---


