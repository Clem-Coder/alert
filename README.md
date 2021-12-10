# SafetyNet alerts

An Application Programing Interface, designed for rescue services.
The application return datas in Json from URLs
This app uses Java to run and stores the data in H2 database.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

- Java 1.8
- Maven 3.6.2
- Postman 9.4.0

### Installing

A step by step series of examples that tell you how to get a development env running:

1.Install Java:

https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html

2.Install Maven:

https://maven.apache.org/install.html

### Running App

Post installation of Java and Maven, you will be ready to lauch the application, for this open your cmd.exe, go to the alert-0.0.1-SNAPSHOT.jar (In the target folder of the application)
In the terminal, use the command "cd", type the filepath to the the alert-0.0.1-SNAPSHOT.jar. And use the commande "java -jar the alert-0.0.1-SNAPSHOT.jar". Safety Alert will be stated

After that, you can run Postman.

### Use SafetyNet Alerts

Once in Postman, create a new request and watch if this one return the datas in Json format, you asked (You'll find all queries and what return in URL.pdf file).
For this, click on new -> HTTP request ->  use the verb http GET -> for example, use this URL "http://localhost:8080/firestation?stationNumber=<station_number>"

replace the "<station_number>" in the query by the station number of you choise (between 1 and 4) and the API will return a list of all people covered by this firestation.

You can also add, modify and replace people in DB with endpoints in the file Endpoints.pdf
