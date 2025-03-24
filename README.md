# Gestion des Patients - Spring Boot Application

## Description

Cette application Web JEE permet de gérer les patients à l'aide de **Spring MVC, Thymeleaf et Spring Data JPA**. Elle offre les fonctionnalités suivantes :

- **Afficher la liste des patients** avec pagination
- **Rechercher un patient** par son nom
- **Ajouter un nouveau patient** avec validation des formulaires
- **Supprimer un patient**
- **Utiliser un layout Thymeleaf pour une meilleure réutilisation**

## Technologies utilisées

- **Spring Boot 3** (Spring MVC, Spring Data JPA, Spring Validation)
- **Thymeleaf** pour le rendu des vues
- **Hibernate** pour l'accès à la base de données
- **H2 Database** (ou MySQL/PostgreSQL selon la configuration)
- **Bootstrap 5** pour le design

## Installation et exécution

### 1. Cloner le projet

```sh
git clone https://github.com/Poogast123/Activit-Pratique-N-3.git
cd gestion-patients
```

### 2. Configurer la base de données

Dans `src/main/resources/application.properties`, configure la base de données selon tes besoins :

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

Pour MySQL :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/patients_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

### 3. Lancer l'application

Assure-toi d'avoir **Java 17+** installé, puis exécute :

```sh
mvn spring-boot:run
```

L'application sera accessible à l'adresse : [**http://localhost:8080/patients**](http://localhost:8080/patients)

## Structure du projet

```bash
📂 gestion-patients
├── 📂 src/main/java/com/example/patients
│   ├──  PatientController.java
│   ├──  Patient.java
│   ├──  PatientRepository.java
│   ├──  ActivitePratiqueN3Application.java
├── 📂 src/main/resources/templates
│   ├── layout.html         # Template Thymeleaf
│   ├── patients.html       # Liste des patients
│   ├── form.html           # Formulaire d'ajout
├── 📄 application.properties # Configuration Spring Boot
├── 📄 pom.xml              # Dépendances Maven
└── 📄 README.md            # Documentation du projet
```

## Fonctionnalités

### 1. Afficher et rechercher des patients

📍 Accès : `http://localhost:8080/patients`

- La liste des patients est paginée.
- Un champ de recherche permet de filtrer les patients par nom.

### 2. Ajouter un patient avec validation

📍 Accès : `http://localhost:8080/patients/form`

- Nom obligatoire (3 à 30 caractères)
- Score compris entre 0 et 100
- Indication si le patient est malade ou non

### 3. Supprimer un patient

- Un bouton "Supprimer" permet de supprimer un patient directement depuis la liste.



## Auteurs

- **Ton Nom** - *Développeur*
- **Contributeurs** : Kawtar ZERHOUNI, Hermann Leibniz Klauss Agossou

## Licence

Ce projet est sous licence **MIT**.

