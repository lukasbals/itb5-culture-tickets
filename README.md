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

## Local setup

### Setup the app

The app is a maven project (IntelliJ). You can use IntelliJ to open and
run the maven project, or just run the following commands in the project
dir:

```bash
mvn -e clean install
java -jar target/itb5-culture-tickets.jar
```
