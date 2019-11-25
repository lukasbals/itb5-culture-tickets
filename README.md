# Culture Tickets

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=BakaBoing_itb5-culture-tickets&metric=alert_status)](https://sonarcloud.io/dashboard?id=BakaBoing_itb5-culture-tickets)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=BakaBoing_itb5-culture-tickets&metric=bugs)](https://sonarcloud.io/dashboard?id=BakaBoing_itb5-culture-tickets)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=BakaBoing_itb5-culture-tickets&metric=code_smells)](https://sonarcloud.io/dashboard?id=BakaBoing_itb5-culture-tickets)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=BakaBoing_itb5-culture-tickets&metric=coverage)](https://sonarcloud.io/dashboard?id=BakaBoing_itb5-culture-tickets)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=BakaBoing_itb5-culture-tickets&metric=security_rating)](https://sonarcloud.io/dashboard?id=BakaBoing_itb5-culture-tickets)

Culture tickets is a software, to help event managers to sell tickets for their events.
This repository represents the backend of the application.

## Story definitions

### Definition of ready

* AC's
* Estimated
* Discussion in the team until anyone understands the topics
* UI mock

### Definition of done

* \> 1 approving code reviews
* Documented
* Tested
* AC's are fulfilled

## Test

Run the unit tests with the following commands:

```shell script
mvn clean test
```

## Build

Build the app with the following commands:

```shell script
mvn clean -U package
```

## Run

Run the app with the following command:
(Note: We recommend to use java version 8)

```shell script
java -jar target/itb5-culture-tickets-1.0-SNAPSHOT.jar
```

If you want to run the jar locally:

```shell script
java -jar target/itb5-culture-tickets-1.0-SNAPSHOT.jar localhost
```