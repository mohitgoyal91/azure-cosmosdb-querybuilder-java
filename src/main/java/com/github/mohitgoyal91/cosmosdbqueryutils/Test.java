package com.github.mohitgoyal91.cosmosdbqueryutils;

import com.github.mohitgoyal91.cosmosdbqueryutils.restriction.ComparisonRestriction;
import com.github.mohitgoyal91.cosmosdbqueryutils.restriction.GeoSpatialRestriction;
import com.github.mohitgoyal91.cosmosdbqueryutils.restriction.INRestriction;
import com.github.mohitgoyal91.cosmosdbqueryutils.models.Columns;
import com.github.mohitgoyal91.cosmosdbqueryutils.models.Coordinate;
import com.github.mohitgoyal91.cosmosdbqueryutils.models.GeoSpatialObject;
import com.github.mohitgoyal91.cosmosdbqueryutils.restriction.ArithmeticRestriction;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;

import java.util.ArrayList;
import java.util.List;

import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.Order.DESC;

public class Test {

    public static void main(String args[]){
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
        *  OR  ((  C.monthlyIncome * 12 ) +  C.savings  >= 500.0) )*/
        System.out.println("Test Query 4: " + getSelectQuery4());
        
        /*
        * SELECT * FROM C WHERE ( C.id = '123' )
        * OR ( C.name IN (1, 'mohit' ) )
        * AND ( C.uuid = 124) AND ( C.uuid = 123)
        * ORDER BY C._ts DESC*/
        System.out.println("Test Query 5: " + getSelectQuery5());

        /*
        * SELECT * FROM C WHERE ( C.pid = 123) OR ( ( C.age >= 15) OR ( C.age < 29) )*/
        System.out.println("Test Query 6: " + getSelectQuery6());

        System.out.println("Test Query 7: " + getSelectQuery7());
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
