## Connected Cities

#### Introduction
This Spring Boot application enabling client to determine if two cities are connected.

The two cities are considered connected if there’s a series of roads that can be traveled from one city to another. The list of roads is available in the city.txt file in src/main/resources/data.
The file contains a list of city pairs (one pair per line, comma separated), which indicates that there’s a road between those cities.

It will be deployed as a spring-boot app and expose one endpoint: http://localhost:8080/connected?origin=city1&amp;destination=city2. 
The response will be 'yes' if city1 is connected to city2, or 'no' if city1 is not connected to city2. Any unexpected city name input will 
result in 'no' response.</p>
<p>Example: city.txt content is: Boston, New York Philadelphia, Newark Newark, Boston Trenton, Albany</p>
<p>http://localhost:8080/connected?origin=Boston&amp;destination=Newark Should return yes</p>
<p>http://localhost:8080/connected?origin=Boston&amp;destination=Philadelphia Should return yes</p>
<p>http://localhost:8080/connected?origin=Philadelphia&amp;destination=Albany Should return no</p>	


#### Tool & Technologies Used

JDK 1.8</br>
Spring Boot v2.2.5</br>
Maven 3.0+ </br>
Eclipse IDE.</br>

#### Built From Source
The below are the various option to build this application

#####Maven commandline to build source
```
mvn clean install
```

#####Maven Wrapper to build source
The maven wrapper files are automatically created when the spring-boot-starter-web project created from eclipse.  This will help us to leverage to build this application.

The wrapper should work with different operating systems such as:
<ul>
<li>Linux<br></li>
<li>Windows</li>
</ul>

The below command can be run in Linux/Unix system:

```
./mvnw clean install
```

And the following command for windows Batch:

```
mvnw.cmd clean install
```

#### Run the application
######Using maven Spring Boot plugin

```
mvn spring-boot:run
```
#####Using Java command line

```
 java -jar target/CityConnectorProject-0.0.1-SNAPSHOT.jar
```

#####Using Maven Wrapper Spring-Boot project

In Linux/Unix environment

```
./mvnw spring-boot:run
```

In Windows

```
mvnw.cmd spring-boot:run
```

#### Unit Tests
The below are the unit test cases

```
CityConnectorApplicationTests
CityConnectorApplicationRestTests
```
<ul>
<li><u>CityConnectorApplicationTests</u></li>
</ul>
<p style="margin-left: 40px">This unit test is to check the connected city for CityServiceImpl component.
	
<ul>
<li><u>CityConnectorApplicationRestTests</u></li>
</ul>
<p style="margin-left: 40px">This test is to check the query parameter input that are passed to the rest end point.

##### Run Unit Tests

<p style="margin-left: 40px"> The above units test can be run with the below maven command

```
mvn test
```
To run a specific test,

```
mvn -Dtest=<test-class> test

For Instance,
     mvn -Dtest=CityConnectorApplicationTests test
```




