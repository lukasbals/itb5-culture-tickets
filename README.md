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

Run the app by downloading [payara](https://www.payara.fish/software/downloads/)
and running the following commands inside the payara5 directory:

```shell script
# Start the server
./bin/asadmin start-domain

# Deploy the .war file
./bin/asadmin deploy path-to-war/itb5-culture-tickets-backend-1.0-SNAPSHOT.war

# Undeploy the .war file
./bin/asadmin undeploy path-to-war/itb5-culture-tickets-backend-1.0-SNAPSHOT

# List deployments
./bin/asadmin list-applications

# Stop the server
./bin/asadmin stop-domain
```

You can access the payara admin console on `http://localhost:4848/`.
You can access the app app on `http://localhost:8080/itb5-culture-tickets-backend-1.0-SNAPSHOT/`.

## RESTful Test Client
You can access the Python Script
[here](https://gist.github.com/Pia-Maria/28dc4feaa5d44c0f6fb25e61613a9023)

```shell script
# Help from script
python getSearchEventScript.py -h
```
