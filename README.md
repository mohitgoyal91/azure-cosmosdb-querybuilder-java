# Azure Cosmos DB SQL Query Generator

This project provides a client tools or utilities in Java that makes it easy to generate Azure CosmosDB SQL Queries effectively in an organised way. 

## Disclaimer
The implementation in this project is intended for reference purpose only. 

### Dependencies
Dependencies will be added automatically if Maven is used. Otherwise, please download the dependencies from the pom.xml file and add them to your build path. 

###Some Sample Queries

SELECT * FROM C
```java
new SelectQuery().createQuery();
```

SELECT TOP 5 C.id AS ID, C.name AS NAME FROM C ORDER BY C._ts DESC
```java
new SelectQuery()
                .addColumns(new Columns("id", "name").as("ID", "NAME"))
                .addOrdering("_ts", Constants.Order.DESC)
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
        .addColumns(new Columns(columns).as(as))
        .createQuery();
```

SELECT C.id FROM C WHERE ( ( C.name = 'Mohit' OR C.age <= 28) AND ( C.surname IN ( 'Goyal' , 'Sharma' ) ) ) OR ( ( ST_DISTANCE ( C.home.coordinates, {"type":"Point", "coordinates":[[48.858483, 2.294524]]}) <= 2000.0) OR (( C.monthlyIncome * 12 ) + C.savings >= 500.0) )
```java
return new SelectQuery()
                .addColumns(new Columns("id"))
                .addRestrictions(
                        new ComparisonRestriction()
                        .eq("name", "Mohit")
                        .or()
                        .lte("age", 28),
                        new INRestriction()
                        .in("surname", "Goyal", "Sharma")
                )
                .orAddRestrictions(
                        new GeoSpatialRestriction()
                        .distanceLte("home.coordinates",
                                new GeoSpatialObject(Constants.GeoSpatialTypes.POINT,
                                        new Coordinate(48.858483, 2.294524)), 2000.0)
                        .or(),
                        new ArithmeticRestriction()
                        .gte(500.0, "( {} * {} ) + {} ", "monthlyIncome", 12, "savings")
                )
                .createQuery();
```