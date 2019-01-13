package com.github.mohitgoyal91.cosmosdbqueryutils;

import com.github.mohitgoyal91.cosmosdbqueryutils.restriction.*;
import com.github.mohitgoyal91.cosmosdbqueryutils.models.Columns;
import com.github.mohitgoyal91.cosmosdbqueryutils.models.Coordinate;
import com.github.mohitgoyal91.cosmosdbqueryutils.models.GeoSpatialObject;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.Order.DESC;

public class Test {

    public static void main(String[] args)  {
        //Bumps Queries
        System.out.println("Get Bump Query: "+getBumpQuery());
        System.out.println("Get Bumps Query: "+getBumpsQuery());

        //completedtrips daoimpl queries
        System.out.println("deleteCompletedTrip Query: "+getDeleteCompletedTripQuery());

        //drivinganalyticsdaoimpl latest
        System.out.println("getRecenttripDatafromDA Query: "+getRecenttripDatafromDAQuery());
        System.out.println("getTripsDataFromDA Query: "+getTripsDataFromDAQuery());

        //maintenanceDaoImpl getRecords Count
        System.out.println("getRecordsCount Query: "+getRecordsQuery());

        //notificationDaoImpl query with Optional
        System.out.println("notificationDaoImpl Query: "+getNotificationDaoImplQuery());
        System.out.println("notificationDaoImpl Query2: "+getNotificationDaoImplQuery2());
        System.out.println("notificationDaoImpl Query3: "+getNotificationDaoImplQuery3());
        System.out.println("notificationDaoImpl Query4: "+getNotificationDaoImplQuery4());

        //vehicleshare queries
        System.out.println("Get Active Vehicle Share Query: "+getActiveVehicleShareQuery());
        System.out.println("Get Active Vehicle Share Query2: "+getActiveVehicleShareQuery2());

        //Geospatial queries
        System.out.println("GeoSpatial Query: "+getGeoSpatialQuery());

        //Restrictions with Arithmetic Operations
        System.out.println("Arithmetic Operatios: "+getArithmeticOperationQuery());
        System.out.println(getNewQuery());

        //SELECT *  FROM  C
        System.out.println("Test Query 1: " + getSelectQuery());

        //SELECT TOP 5 C.id AS ID,  C.name AS NAME FROM  C ORDER BY  C._ts DESC
        System.out.println("Test Query 2: " + getSelectQuery2());

        //SELECT C.id AS ID,  C.name FROM  C
        System.out.println("Test Query 3: " + getSelectQuery3());

        /*SELECT C.id FROM  C
         * WHERE
         * ( ( C.name =  'Mohit'  OR  C.age <= 28)  AND  ( C.surname IN  ( 'Goyal' ,  'Sharma' ) ) )
         *  OR
         * ( ( ST_DISTANCE  ( C.home.coordinates, {"type":"Point", "coordinates":[[48.858483, 2.294524]]})  <= 2000.0)
         *  OR  ((  C.monthlyIncome * 12 ) +  C.savings  >= 500.0) )*//*
        System.out.println("Test Query 4: " + getSelectQuery4());

        /*
         * SELECT * FROM C WHERE ( C.id = '123' )
         * OR ( C.name IN (1, 'mohit' ) )
         * AND ( C.uuid = 124) AND ( C.uuid = 123)
         * ORDER BY C._ts DESC*//*
        System.out.println("Test Query 5: " + getSelectQuery5());

        /*
         * SELECT * FROM C WHERE ( C.pid = 123) OR ( ( C.age >= 15) OR ( C.age < 29) )*//*
        System.out.println("Test Query 6: " + getSelectQuery6());

        System.out.println("Test Query 7: " + getSelectQuery7());*/

        System.out.println("In Query with Optional List: "+ getInWithOptionalList());
        System.out.println("In Query with Optional List: "+ getInWithOptionalList2());
        System.out.println("Array Contains: "+ getArrayContains());
    }

    private static String getArrayContains() {
        String obj = "{'firstName':'Mohit', 'surname':'Goyal'}";
        JSONObject obj2 = new JSONObject(obj);
        //obj2.put("A", 1);obj2.put("B","C");
        return new SelectQuery()
                .eq("name", "Mohit")
                .id("1")
                .arrayContains("type", obj)
                .arrayContains("type", obj2)
                .arrayContains("type", Optional.empty())
                .createQuery();
    }

    private static String getInWithOptionalList2() {
        return new SelectQuery()
                .eq("A", "test")
                .addRestrictions(getComparisonRestriction())
                .createQuery();
    }

    private static INRestriction getComparisonRestriction() {
        List<Object> list = new ArrayList<>();
        list.add(1);list.add(true);list.add("Mohit"); list.add(Optional.empty());
        INRestriction inRestriction = new INRestriction().in("A", list.toArray());
        return new INRestriction();
    }

    private static String getInWithOptionalList() {
        List<String> list = new ArrayList<>();
        list.add("Mohit"); list.add("Rahul");
        return new SelectQuery()
                .in("name", list)
                .createQuery();
    }

    private static String getNewQuery()  {
        return new SelectQuery()
                .columns(new Columns("test").as("t"))
                .count()
                .limitResults(5)
                .orderBy("_ts", Constants.Order.DESC)
                .addRestrictions(
                        new ComparisonRestriction()
                                .eq("device_id", "0004994549100")
                                .or(),
                        new INRestriction()
                                .in("provider", "AVMAP")
                )
                .orAddRestrictions(
                        new GeoSpatialRestriction()
                                .eq("location",
                                        new GeoSpatialObject(Constants.GeoSpatialTypes.POINT,
                                                new Coordinate(1.4, 1.6)), 10.0),
                        new GeoSpatialRestriction()
                                .within("location",
                                        new GeoSpatialObject(Constants.GeoSpatialTypes.POINT,
                                                new Coordinate(1.4, 1.6), new Coordinate(1.6,1.7))),
                        new ArithmeticRestriction()
                                .eq(0.0, "({} - {}) % {}", 1546214400000L, "var1", "var2")
                                .or(),
                        new GeoSpatialRestriction()
                                .within("location",
                                        new GeoSpatialObject(Constants.GeoSpatialTypes.POINT,
                                                new Coordinate(1.4, 1.6), new Coordinate(1.6,1.7))),
                        new ArithmeticRestriction()
                                .eq(0.0, "({} - {}) % {}", 1546214400000L, "var1", "var2")
                )
                .andAddRestrictions(
                        new ArithmeticRestriction()
                                .eq(0.0, "({} - {}) % {}", 1546214400000L, "var1", "var2")
                )
                .addRestrictions(
                        new ArithmeticRestriction()
                                .eq(0.0, "({} - {}) % {}", 1546214400000L, "var1", "var2"),
                        new ComparisonRestriction()
                                .eq("device_id", "0004994549100")
                                .or(),
                        new INRestriction()
                                .in("provider", "AVMAP")
                )
                .createQuery();
    }

    private static String getArithmeticOperationQuery()  {
        return new SelectQuery()
                .addRestrictions(
                        new ComparisonRestriction()
                                .eq("uuid", "5c4001c7-a8f7-4824-81e7-f472b684d532"),
                        new ComparisonRestriction()
                                .eq("vin", "JTDKB3FUX03500146"),
                        new INRestriction()
                                .in("status", "'Active","Not_Started"),
                        new ComparisonRestriction()
                                .lte("start_timestamp_hhmm", 200),
                        new ComparisonRestriction()
                                .gt("end_timestamp_hhmm", 200),
                        new ComparisonRestriction()
                                .gt("recurring_end_timestamp", 1546221652168L)
                )
                .createQuery();
    }

    private static String getGeoSpatialQuery()  {
        double lat = 31.9;
        double lng = -4.8;
        String deviceId = "0004746355552552100";

        return new SelectQuery()
                .columns(
                        new Columns("location.coordinates[0]", "location.coordinates[1]", "uuid", "device_id")
                                .as("lat", "lng", "distance")
                )
                .limitResults(1)
                .orderBy("_ts", Constants.Order.DESC)
                .addRestrictions(
                        new ComparisonRestriction()
                                .eq("device_id", deviceId)
                                .build(),
                        new INRestriction()
                                .in("testProperty", "hello", 123,95.0)
                                .build(),
                        new GeoSpatialRestriction()
                                .lt("location",
                                        new GeoSpatialObject(Constants.GeoSpatialTypes.POINT,
                                                new Coordinate(2.45, 2.45)), 100.0)
                )
                .orAddRestrictions(
                        new GeoSpatialRestriction()
                                .within("location",
                                        new GeoSpatialObject(Constants.GeoSpatialTypes.POLYGON,
                                                new Coordinate(2.45, 2.45), new Coordinate(46.5,364.4)))
                                .or(),
                        new GeoSpatialRestriction()
                                .eq("location",
                                        new GeoSpatialObject(Constants.GeoSpatialTypes.POINT,
                                                new Coordinate(1.2,1.4), new Coordinate(1.6,1.5)), 43.0)
                )
                .createQuery();

    }

    private static String getActiveVehicleShareQuery2()  {
        List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2);
        return new SelectQuery()
                .addRestrictions(
                        new ComparisonRestriction()
                                .eq("uuid", 7777)
                                .or()
                                .eq("vin", "888575")
                                .build()
                                .or(),
                        new INRestriction()
                                .in("dummy", "dummy")
                                .or()
                                .in("temp", list)
                                .build()
                )
                .orAddRestrictions(
                        new INRestriction()
                                .in("test", "hola")
                                .build(),
                        new ComparisonRestriction()
                                .eq("uuid", "7777")
                                .or()
                                .eq("vin", "888575")
                                .build()
                )
                .addRestrictions(
                        new INRestriction()
                                .in("pp", "A", 123)
                                .or()
                                .in("testtt", Optional.empty(), "hello")
                                .and()
                                .in("kkri", 1133, "jjfh", Optional.empty())
                                .build()
                )
                .addRestrictions(
                        new INRestriction()
                                .in("qq", Optional.empty(), 1234)
                                .build()
                )
                .createQuery();
    }

    private static String getActiveVehicleShareQuery()  {
        return new SelectQuery()
                .addRestrictions(
                        new ComparisonRestriction()
                                .eq("uuid", "7777")
                                .or()
                                .eq("vin", "888575")
                                .build(),
                        new INRestriction()
                                .in("dummy", "dummy")
                                .build()
                )
                .orAddRestrictions(
                        new INRestriction()
                                .in("test", "hola")
                                .build(),
                        new ComparisonRestriction()
                                .eq("uuid", "7777")
                                .or()
                                .eq("vin", "888575")
                                .build()
                )
                .addRestrictions(
                        new INRestriction()
                                .in("pp", "A", 123)
                                .or()
                                .in("testtt", Optional.empty(), "hello")
                                .and()
                                .in("kkri", 1133, "jjfh", Optional.empty())
                                .build()
                )
                .addRestrictions(
                        new INRestriction()
                                .in("qq", Optional.empty(), 1234)
                                .build()
                )
                .createQuery();
    }

    private static String getNotificationDaoImplQuery3()  {
        return new SelectQuery()
                .addRestrictions(
                        new ComparisonRestriction()
                                .eq("A", Optional.empty())
                                .eq("B", Optional.ofNullable("Tata"))
                                .build()
                )
                .createQuery();
    }

    private static String getNotificationDaoImplQuery2()  {
        return new SelectQuery()
                .addRestrictions(
                        new ComparisonRestriction()
                                .eq("A", Optional.empty())
                                .eq("B", Optional.empty())
                                .build()
                )
                .addRestrictions(
                        new ComparisonRestriction()
                                .eq("A", Optional.empty())
                                .eq("B", Optional.empty())
                                .eq("B", Optional.ofNullable("Tata"))
                                .build()
                )
                .addRestrictions(
                        new ComparisonRestriction()
                                .eq("A", Optional.ofNullable("HELLO"))
                                .eq("B", Optional.empty())
                                .eq("B", Optional.ofNullable("Tata"))
                                .build()
                )
                .createQuery();
    }

    private static String getNotificationDaoImplQuery4()  {
        return new SelectQuery()
                .addRestrictions(
                        new ComparisonRestriction()
                                .eq("A", Optional.empty())
                                .eq("B", Optional.empty())
                                .build()
                )
                .addRestrictions(
                        new ComparisonRestriction()
                                .eq("A", Optional.empty())
                                .eq("B", Optional.empty())
                                .eq("B", Optional.empty())
                                .build()
                )
                .addRestrictions(
                        new ComparisonRestriction()
                                .eq("A", Optional.empty())
                                .eq("B", Optional.empty())
                                .eq("B", Optional.empty())
                                .build()
                )
                .createQuery();
    }

    private static String getNotificationDaoImplQuery()  {
        return new SelectQuery()
                .addRestrictions(
                        new ComparisonRestriction()
                                .eq("A", Optional.ofNullable("Hello"))
                                .eq("B", Optional.ofNullable("Tata"))
                                .build()
                )
                .createQuery();
    }

    private static String getRecordsQuery()  {
        return new SelectQuery()
                .addRestrictions(
                        new ComparisonRestriction()
                                .eq("UUID","32434432dfds")
                                .eq("VIN", "88hgfgfgf")
                                .build()
                )
                .count()
                .createQuery();
    }

    private static String getTripsDataFromDAQuery()  {
        return new SelectQuery()
                .addRestrictions(
                        new ComparisonRestriction().eq("A","1")
                                .eq("B","2")
                                .build()
                )
                .orAddRestrictions(
                        new ComparisonRestriction().eq("C", "3")
                                .eq("D", "4")
                                .build()
                )
                .andAddRestrictions(
                        new ComparisonRestriction().eq("E", 5)
                                .eq("F", 43434)
                                .build()
                )
                .createQuery();
    }

    private static String getRecenttripDatafromDAQuery()  {
        return new SelectQuery()
                .limitResults(1)
                .addRestrictions(
                        new ComparisonRestriction().eq("device_id", "865942030011032100")
                                .eq("uuid", "1234-xxxx-5678")
                                .or()
                                .lte("start_time_gmt", "1234-xxxx-5678")
                                .gte("end_time_gmt", "1234-xxxx-5678")
                                .build()
                )
                .orderBy("start_time_gmt", Constants.Order.DESC)
                .createQuery();
    }

    private static String getDeleteCompletedTripQuery()  {
        return new SelectQuery()
                .columns(new Columns("_self"))
                .addRestrictions(
                        new ComparisonRestriction().eq("uuid", "1234-xxxx-5678")
                                .eq("device_id", "865942030011032100")
                                .build()
                )
                .createQuery();
    }

    private static String getBumpsQuery()  {
        return new SelectQuery()
                .addRestrictions(
                        new ComparisonRestriction().eq("uuid", "1234-xxxx-5678")
                                .or()
                                .eq("vin", "AHTCR12G908600474")
                                .build()
                )
                .orderBy("timestamp", Constants.Order.DESC)
                .createQuery();
    }

    private static String getBumpQuery()  {
        return new SelectQuery()
                .addRestrictions(
                        new ComparisonRestriction().eq("uuid", "1234-xxxx-5678")
                                .and()
                                .eq("id", "865942030011032100-290-1536923247000-888601404")
                                .build()
                )
                .orderBy("_ts", Constants.Order.DESC)
                .createQuery();
    }

    private static String getSelectQuery7() {
        return new SelectQuery()
                .columns(new Columns("hello"))
                .max("age", "age")
                .count("id", "id")
                .sum("life")
                .min("failure", "failure", "convertToInt")
                .createQuery();
    }

    private static String getSelectQuery6() {
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
    }

    private static String getSelectQuery5() {
        List<Object> list = new ArrayList<>();
        list.add(1); list.add("mohit");
        return new SelectQuery()
                .id("123").or()
                .in("name", list)
                .eq("pid",124)
                .addRestrictions(new RestrictionBuilder().eq("uuid",123))
                .orderByTS(DESC)
                .createQuery();
    }

    private static String getSelectQuery4(){
        return new SelectQuery()
                .columns(new Columns("id"))
                .addRestrictions(
                        new RestrictionBuilder()
                                .eq("name", "Mohit")
                                .or()
                                .lte("age", 28),
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
    }

    private static String getSelectQuery3(){
        List<String> columns = new ArrayList<>();
        columns.add("id"); columns.add("name");
        List<String> as = new ArrayList<>();
        as.add("ID");
        return new SelectQuery()
                .columns(new Columns(columns).as(as))
                .createQuery();
    }

    private static String getSelectQuery2(){
        return new SelectQuery()
                .columns(new Columns("id", "name").as("ID", "NAME"))
                .orderBy("_ts", DESC)
                .limitResults(5)
                .createQuery();
    }

    private static String getSelectQuery(){
        return new SelectQuery().createQuery();
    }
}
