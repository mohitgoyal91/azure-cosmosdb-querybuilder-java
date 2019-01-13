package com.github.mohitgoyal91.cosmosdbqueryutils.utilities;

public class Constants {

    public static final class GENERAL{
        public static final String SELECT = "SELECT";
        public static final String ID = "id";
        public static final String _TS = "_ts";
        public static final String VALUE_COUNT = " VALUE COUNT(1) ";
        public static final String TOP = " TOP ";
        public static final String ALL = " * ";
        public static final String AS = " AS ";
        public static final String DOT = ".";
        public static final String COMMA = ", ";
        public static final String BRACKET_OPEN = " (";
        public static final String BRACKET_CLOSED = ") ";
        public static final String QUOTES_OPEN = " '";
        public static final String QUOTES_CLOSED = "' ";
        public static final String FROM = " FROM ";
        public static final String ALIAS = " C";
        public static final String WHERE = " WHERE ";
        public static final String ORDER_BY = " ORDER BY ";
        public static final String CURLY_BRACKETS_REGEX = "\\{\\}";
    }

    public enum GeoSpatialTypes{
        POINT("Point"), POLYGON("Polygon"), LINESTRING("LineString");
        private String name;
        GeoSpatialTypes(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
    }

    public enum Order{
        ASC(" ASC "), DESC(" DESC ");
        private String name;
        Order(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
    }

    public enum Logical{
        OR("OR"), AND("AND"), NOT("NOT");
        private String name;
        Logical(String name){
            this.name = name;
        }
    }

    public static final class Operators{

        public static final class Arithmetic{
            public static final String ADD = " + ";
            public static final String SUBTRACT = " - ";
            public static final String MULTIPLY = " * ";
            public static final String DIVISION = " / ";
            public static final String MODULUS = " % ";
        }

        public static final class Bitwise{
            public static final String OR = " | ";
            public static final String AND = " & ";
            public static final String XOR = " ^ ";
            public static final String LEFT_SHIFT = " < ";
            public static final String RIGHT_SHIFT = " >> ";
            public static final String ZERO_FILL_RIGHT_SHIFT = " >>> ";
        }

        public static final class Logical{
            public static final String AND = " AND ";
            public static final String OR = " OR ";
            public static final String NOT = " NOT ";
        }

        public static final class Comparison{
            public static final String EQUAL = " = ";
            public static final String NOT_EQUAL = " != ";
            public static final String LESS_THAN = " < ";
            public static final String LESS_THAN_EQUAL = " <= ";
            public static final String GREATER_THAN = " > ";
            public static final String GREATER_THAN_EQUAL = " >= ";
            public static final String NOT_EQUAL_SQL = " <> ";
            public static final String UNKONWN = " ?? ";
            public static final String IN = " IN ";
        }

        public static final class STRINGTYPE{
            public static final String CONCATENATE = " || ";
        }

        public static final class TERNARY{
            public static final String IF = " ? ";
        }
    }

    public static final class FUNCTION{

        public static final class AGGREGATE{
            public static final String COUNT = " COUNT ";
            public static final String MIN = " MIN ";
            public static final String MAX = " MAX ";
            public static final String SUM = " SUM ";
            public static final String AVG = " AVG ";
        }

        public static final class MATHEMATICAL{
            public static final String ABSOLUTE = " ABS ";
            public static final String CEILING = " CEILING ";
            public static final String EXPONENTIAL = " EXP ";
            public static final String FLOOR = " FLOOR ";
            public static final String LOGARITHMIC = " LOG ";
            public static final String LOGARITHMIC_10 = " LOG10 ";
            public static final String POWER = " POWER ";
            public static final String ROUND = " ROUND ";
            public static final String SIGN = " SIGN ";
            public static final String SQUARE_ROOT = " SQRT ";
            public static final String SQUARE = " SQUARE ";
            public static final String TRUNCATE = " TRUNC ";
            public static final String ACOS = " ACOS ";
            public static final String ASIN = " ASIN ";
            public static final String ATAN = " ATAN ";
            public static final String ATAN2 = " ATN2 ";
            public static final String COS = " COS ";
            public static final String SIN = " SIN ";
            public static final String TAN = " TAN ";
            public static final String COT = " COT ";
            public static final String DEGREES = " DEGREES ";
            public static final String PI = " PI ";
            public static final String RADIANS = " RADIANS ";
        }

        public static final class TYPECHECKING{
            public static final String IS_ARRAY = " IS_ARRAY ";
            public static final String IS_BOOL = " IS_BOOL ";
            public static final String IS_NULL = " IS_NULL ";
            public static final String IS_NUMBER = " IS_NUMBER ";
            public static final String IS_OBJECT = " IS_OBJECT ";
            public static final String IS_STRING = " IS_STRING ";
            public static final String IS_DEFINED = " IS_DEFINED ";
            public static final String IS_PRIMITIVE = " IS_PRIMITIVE ";
        }

        public static final class STRINGTYPE{
            public static final String CONCAT = " CONCAT ";
            public static final String CONTAINS = " CONTAINS ";
            public static final String ENDSWITH = " ENDSWITH ";
            public static final String INDEX_OF = " INDEX_OF ";
            public static final String LEFT = " LEFT ";
            public static final String LENGTH = " LENGTH ";
            public static final String LOWER = " LOWER ";
            public static final String LTRIM = " LTRIM ";
            public static final String REPLACE = " REPLACE ";
            public static final String REPLICATE = " REPLICATE ";
            public static final String REVERSE = "REVERSE";
            public static final String RIGHT = " RIGHT ";
            public static final String RTRIM = " RTRIM ";
            public static final String STARTSWITH = " STARTSWITH ";
            public static final String SUBSTRING = " SUBSTRING ";
            public static final String UPPER = " UPPER ";
        }

        public static final class ARRAYTYPE{
            public static final String ARRAY_CONCAT = " ARRAY_CONCAT ";
            public static final String ARRAY_CONTAINS = " ARRAY_CONTAINS ";
            public static final String ARRAY_LENGTH = " ARRAY_LENGTH ";
            public static final String ARRAY_SLICE = " ARRAY_SLICE ";
        }

        public static final class GEOSPATIAL{
            public static final String ST_WITHIN = " ST_WITHIN ";
            public static final String ST_DISTANCE = " ST_DISTANCE ";
            public static final String ST_INTERSECTS = " ST_INTERSECTS ";
            public static final String ST_OVERLAPS = " ST_OVERLAPS ";
            public static final String ST_ISVALID = " ST_ISVALID ";
            public static final String ST_ISVALIDDETAILED = " ST_ISVALIDDETAILED ";
        }

        public static final class METHODNAMES{
            public static final String APPEND_RESTRICTION_EXCEPTION = "appendRestrictionExpression";
        }
    }
}
