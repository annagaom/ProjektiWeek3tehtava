# Monikielinen Tietokantasovellus

Tämä projekti on JavaFX-pohjainen sovellus, joka mahdollistaa monikielisen käyttöliittymän avulla tietojen syöttämisen ja tallentamisen MySQL-tietokantaan. Sovellus tukee useita kieliä ja tallentaa käyttäjän syöttämät tiedot tietokantaan SQL-kyselyjen avulla.

## Ominaisuudet

- **Monikielinen käyttöliittymä**: Tukee eri kielivaihtoehtoja käyttöliittymässä.
- **Tietojen syöttö**: Käyttäjä voi syöttää tietoja lomakkeelle.
- **Tietokantatallennus**: Tiedot tallennetaan tietokantaan SQL-kyselyjen avulla.
- **JavaFX-käyttöliittymä**: Graafinen käyttöliittymä JavaFX:n avulla.

## Teknologiat

- Java (JDK 21.0.2)
- JavaFX (JavaFX SDK 21.0.4)
- MySQL
- Hibernate (ORM-tietokannan käsittelyyn)
- Maven (riippuvuuksien hallintaan)

## Asennus

### 1. Esivaatimukset

Varmista, että seuraavat työkalut ovat asennettuna:

- **Java Development Kit (JDK)** version 21 tai uudempi
- **JavaFX SDK** 21.0.4
- **MySQL-palvelin** tietokannan hallintaan
- **IntelliJ IDEA** tai muu Java-IDE (suositus)

### 2. Tietokannan asettaminen

1. Luo MySQL-tietokanta, esimerkiksi `projekti_db`:
    ```sql
    CREATE DATABASE projekti_db;
    ```

2. Luo taulu, johon tietoja tallennetaan:
    ```sql
    CREATE TABLE employees (
        id INT AUTO_INCREMENT PRIMARY KEY,
        firstName VARCHAR(50),
        lastName VARCHAR(50)
    );
    ```

3. Varmista, että sovelluksen tietokantayhteys on asetettu oikein. Tämä voi olla joko `application.properties` -tiedostossa tai suoraan koodissa, esimerkiksi:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/projekti_db
    spring.datasource.username=käyttäjänimi
    spring.datasource.password=salasana
    ```

### 3. Riippuvuuksien asennus

Maven-projektissa tarvittavat riippuvuudet ovat `pom.xml`-tiedostossa. Lisää seuraavat:

```xml
<dependencies>
    <!-- JavaFX -->
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>21</version>
    </dependency>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-fxml</artifactId>
        <version>21</version>
    </dependency>
    <!-- MySQL Connector -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.31</version>
    </dependency>
    <!-- Hibernate ORM -->
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>6.0.0.Final</version>
    </dependency>
</dependencies>
