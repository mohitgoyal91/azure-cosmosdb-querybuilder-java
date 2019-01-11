package com.github.psyduck.cosmosdbqueryutils;

import com.github.psyduck.cosmosdbqueryutils.models.Columns;
import com.github.psyduck.cosmosdbqueryutils.models.Coordinate;
import com.github.psyduck.cosmosdbqueryutils.models.GeoSpatialObject;
import com.github.psyduck.cosmosdbqueryutils.restriction.ArithmeticRestriction;
import com.github.psyduck.cosmosdbqueryutils.restriction.ComparisonRestriction;
import com.github.psyduck.cosmosdbqueryutils.restriction.GeoSpatialRestriction;
import com.github.psyduck.cosmosdbqueryutils.restriction.INRestriction;
import com.github.psyduck.cosmosdbqueryutils.utilities.Constants;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String args[]) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
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
    }

    private static String getSelectQuery4() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
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
    }

    private static String getSelectQuery3() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<String> columns = new ArrayList<>();
        columns.add("id"); columns.add("name");
        List<String> as = new ArrayList<>();
        as.add("ID");
        return new SelectQuery()
                .addColumns(new Columns(columns).as(as))
                .createQuery();
    }

    private static String getSelectQuery2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return new SelectQuery()
                .addColumns(new Columns("id", "name").as("ID", "NAME"))
                .addOrdering("_ts", Constants.Order.DESC)
                .limitResults(5)
                .createQuery();
    }

    private static String getSelectQuery() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return new SelectQuery().createQuery();
    }
}
