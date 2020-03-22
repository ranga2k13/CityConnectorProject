<?xml version='1.0' encoding='utf-8' ?><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	</head>
	<body>
		<p><h2>ConnectedCities</h2>
		<hz/>
			Spring Boot application enabling client to determine if two cities are connected.</p>
		<p>Two cities are considered connected if there’s a series of roads that can be traveled from one city to another. The list of roads is available in the city.txt file in src/main/resources. File contains a list of city pairs (one pair per line, comma separated), which indicates that there’s a road between those cities.</p>
		<p>It will be deployed as a spring-boot app and expose one endpoint: http://localhost:8080/connected?origin=city1&amp;destination=city2. The resonse will be 'yes' if city1 is connected to city2, or 'no' if city1 is not connected to city2. Any unexpected input will result in a 'no' response.</p>
		<p>Example: city.txt content is: Boston, New York Philadelphia, Newark Newark, Boston Trenton, Albany</p>
		<p>http://localhost:8080/connected?origin=Boston&amp;destination=Newark Should return yes</p>
		<p>http://localhost:8080/connected?origin=Boston&amp;destination=Philadelphia Should return yes</p>
		<p>http://localhost:8080/connected?origin=Philadelphia&amp;destination=Albany Should return no</p>			
	</body>
</html>