# Connected Cities

Spring Boot application enabling client to determine if two cities are connected.

Two cities are considered connected if there’s a series of roads that can be traveled from one city to another. The list of roads is available in the city.txt file in src/main/resources/data. File contains a list of city pairs (one pair per line, comma separated), which indicates that there’s a road between those cities.

It will be deployed as a spring-boot app and expose one endpoint: http://localhost:8080/connected?origin=city1&amp;destination=city2. The resonse will be 'yes' if city1 is connected to city2, or 'no' if city1 is not connected to city2. Any unexpected input will result in a 'no' response.</p>
<p>Example: city.txt content is: Boston, New York Philadelphia, Newark Newark, Boston Trenton, Albany</p>
<p>http://localhost:8080/connected?origin=Boston&amp;destination=Newark Should return yes</p>
<p>http://localhost:8080/connected?origin=Boston&amp;destination=Philadelphia Should return yes</p>
<p>http://localhost:8080/connected?origin=Philadelphia&amp;destination=Albany Should return no</p>	


## Tools you will need

JDK 1.8+</br>
Maven 3.0+ is your build tool</br>
Your favorite IDE.</br>


## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Unit Test

```
CityConnectorApplicationTests
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built From Source

The wrapper should work with different operating systems such as:

Linux
Windows

We can run our goals like this for the Unix system:

```
1  ./mvnw clean install
```

And the following command for Batch:

```
1  ./mvnw.cmd clean install
```

## Run the application
Using maven Spring Boot plugin

```
mvn spring-boot:run
```
Using Java command line

```
 java -jar target/CityConnectorProject-0.0.1-SNAPSHOT.jar
```

Using Spring-Boot project

```
./mvnw spring-boot:run
```

