# Azure Cosmos DB SQL Query Generator

This project provides a client tools or utilities in Java that makes it easy to generate Azure CosmosDB SQL Queries effectively in an organised way. 

## Disclaimer
The implementation in this project is intended for reference purpose only. 

### Dependencies
Dependencies will be added automatically if Maven is used. Otherwise, please download the dependencies from the pom.xml file and add them to your build path. 

For example, using maven, you can add the following dependency to your maven pom file:
```java
<dependency>
  <groupId>com.github.mohitgoyal91</groupId>
  <artifactId>cosmosdbquery-utils</artifactId>
  <version>1.6.0</version>
</dependency>
```

### Some Sample Queries

SELECT * FROM C
```java
new SelectQuery().createQuery();
```

SELECT TOP 5 C.id AS ID, C.name AS NAME FROM C ORDER BY C._ts DESC
```java
return new SelectQuery()
                .columns(new Columns("id", "name").as("ID", "NAME"))
                .orderBy("_ts", DESC)
                .limitResults(5)
                .createQuery();
```

SELECT C.id AS ID, C.name FROM C
```java
List<String> columns = new ArrayList<>();
        columns.add("id"); columns.add("name");
        List<String> as = new ArrayList<>();
        as.add("ID");
        return new SelectQuery()
                .columns(new Columns(columns).as(as))
                .createQuery();
```

SELECT C.id FROM C WHERE ( ( C.name = 'Mohit' OR C.age <= 28) AND ( C.surname IN ( 'Goyal' , 'Sharma' ) ) ) OR ( ( ST_DISTANCE ( C.home.coordinates, {"type":"Point", "coordinates":[[48.858483, 2.294524]]}) <= 2000.0) OR (( C.monthlyIncome * 12 ) + C.savings >= 500.0) )
```java
return new SelectQuery()
                .columns(new Columns("id"))
                .addRestrictions(
                        new RestrictionBuilder().eq("name", "Mohit")
                        .or().lte("age", 28),
                        new RestrictionBuilder().in("surname", "Goyal", "Sharma")
                )
                .orAddRestrictions(
                        new RestrictionBuilder().lte("home.coordinates",
                                new GeoSpatialObject(Constants.GeoSpatialTypes.POINT,
                                        new Coordinate(48.858483, 2.294524)), 2000.0)
                        .or(),
                        new RestrictionBuilder()
                        .gte(500.0, "( {} * {} ) + {} ", "monthlyIncome", 12, "savings")
                )
                .createQuery();
```

SELECT * FROM C WHERE ( C.id = '123' ) OR ( C.name IN (1, 'mohit' ) ) AND ( C.pid = 124) AND ( C.uuid = 123) ORDER BY C._ts DESC
```java
List<Object> list = new ArrayList<>();
        list.add(1); list.add("mohit");
        return new SelectQuery()
                .id("123").or()
                .in("name", list)
                .eq("pid",124)
                .addRestrictions(new RestrictionBuilder().eq("uuid",123))
                .orderByTS(DESC)
                .createQuery();
```

SELECT * FROM C WHERE ( C.pid = 123) OR ( ( C.age >= 15) OR ( C.age < 29) )
```java
return new SelectQuery()
                .eq("pid", 123)
                .or()
                .addRestrictions(
                        new RestrictionBuilder()
                                .gte("age", 15)
                                .or()
                                .lt("age", 29)
                )
                .createQuery();
```

SELECT MAX ( C.age) AS age, SUM ( C.life) AS life, MIN (udf.convertToInt( C.failure) ) AS failure, C.hello FROM C
```java
return new SelectQuery()
                .columns(new Columns("hello"))
                .max("age", "age", null)
                .sum("life")
                .min("failure", "failure", "convertToInt")
                .createQuery();
```
