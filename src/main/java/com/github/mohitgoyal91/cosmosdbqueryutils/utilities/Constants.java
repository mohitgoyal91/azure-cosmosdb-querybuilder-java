package com.github.mohitgoyal91.cosmosdbqueryutils.utilities;

/**
 * The type Constants.
 */
public class Constants {

    /**
     * The type General.
     */
    public static final class GENERAL{
        /**
         * The constant SELECT.
         */
        public static final String SELECT = "SELECT";
        /**
         * The constant ID.
         */
        public static final String ID = "id";
        /**
         * The constant _TS.
         */
        public static final String _TS = "_ts";
        /**
         * The constant VALUE_COUNT.
         */
        public static final String VALUE_COUNT = " VALUE COUNT(1) ";
        /**
         * The constant TOP.
         */
        public static final String TOP = " TOP ";
        /**
         * The constant ALL.
         */
        public static final String ALL = " * ";
        /**
         * The constant AS.
         */
        public static final String AS = " AS ";
        /**
         * The constant DOT.
         */
        public static final String DOT = ".";
        /**
         * The constant COMMA.
         */
        public static final String COMMA = ", ";
        /**
         * The constant BRACKET_OPEN.
         */
        public static final String BRACKET_OPEN = " (";
        /**
         * The constant BRACKET_CLOSED.
         */
        public static final String BRACKET_CLOSED = ") ";
        /**
         * The constant QUOTES_OPEN.
         */
        public static final String QUOTES_OPEN = " '";
        /**
         * The constant QUOTES_CLOSED.
         */
        public static final String QUOTES_CLOSED = "' ";
        /**
         * The constant FROM.
         */
        public static final String FROM = " FROM ";
        /**
         * The constant ALIAS.
         */
        public static final String ALIAS = " C";
        /**
         * The constant WHERE.
         */
        public static final String WHERE = " WHERE ";
        /**
         * The constant ORDER_BY.
         */
        public static final String ORDER_BY = " ORDER BY ";
        /**
         * The constant CURLY_BRACKETS_REGEX.
         */
        public static final String CURLY_BRACKETS_REGEX = "\\{\\}";
        /**
         * The constant UDF.
         */
        public static final String UDF = "udf";
        /**
         * The constant OFFSET.
         */
        public static final String OFFSET = " OFFSET ";
        /**
         * The constant LIMIT.
         */
        public static final String LIMIT = " LIMIT ";
    }

    /**
     * The enum Geo spatial types.
     */
    public enum GeoSpatialTypes{
        /**
         * Point geo spatial types.
         */
        POINT("Point"),
        /**
         * Polygon geo spatial types.
         */
        POLYGON("Polygon"),
        /**
         * Linestring geo spatial types.
         */
        LINESTRING("LineString");
        private String name;
        GeoSpatialTypes(String name){
            this.name = name;
        }

        /**
         * Get name string.
         *
         * @return the string
         */
        public String getName(){
            return this.name;
        }
    }

    /**
     * The enum Order.
     */
    public enum Order{
        /**
         * Asc order.
         */
        ASC(" ASC "),
        /**
         * Desc order.
         */
        DESC(" DESC ");
        private String name;
        Order(String name){
            this.name = name;
        }

        /**
         * Get name string.
         *
         * @return the string
         */
        public String getName(){
            return this.name;
        }
    }

    /**
     * The enum Logical.
     */
    public enum Logical{
        /**
         * Or logical.
         */
        OR("OR"),
        /**
         * And logical.
         */
        AND("AND"),
        /**
         * Not logical.
         */
        NOT("NOT");
        private String name;
        Logical(String name){
            this.name = name;
        }
    }

    /**
     * The type Operators.
     */
    public static final class Operators{

        /**
         * The type Arithmetic.
         */
        public static final class Arithmetic{
            /**
             * The constant ADD.
             */
            public static final String ADD = " + ";
            /**
             * The constant SUBTRACT.
             */
            public static final String SUBTRACT = " - ";
            /**
             * The constant MULTIPLY.
             */
            public static final String MULTIPLY = " * ";
            /**
             * The constant DIVISION.
             */
            public static final String DIVISION = " / ";
            /**
             * The constant MODULUS.
             */
            public static final String MODULUS = " % ";
        }

        /**
         * The type Bitwise.
         */
        public static final class Bitwise{
            /**
             * The constant OR.
             */
            public static final String OR = " | ";
            /**
             * The constant AND.
             */
            public static final String AND = " & ";
            /**
             * The constant XOR.
             */
            public static final String XOR = " ^ ";
            /**
             * The constant LEFT_SHIFT.
             */
            public static final String LEFT_SHIFT = " < ";
            /**
             * The constant RIGHT_SHIFT.
             */
            public static final String RIGHT_SHIFT = " >> ";
            /**
             * The constant ZERO_FILL_RIGHT_SHIFT.
             */
            public static final String ZERO_FILL_RIGHT_SHIFT = " >>> ";
        }

        /**
         * The type Logical.
         */
        public static final class Logical{
            /**
             * The constant AND.
             */
            public static final String AND = " AND ";
            /**
             * The constant OR.
             */
            public static final String OR = " OR ";
            /**
             * The constant NOT.
             */
            public static final String NOT = " NOT ";
        }

        /**
         * The type Comparison.
         */
        public static final class Comparison{
            /**
             * The constant EQUAL.
             */
            public static final String EQUAL = " = ";
            /**
             * The constant NOT_EQUAL.
             */
            public static final String NOT_EQUAL = " != ";
            /**
             * The constant LESS_THAN.
             */
            public static final String LESS_THAN = " < ";
            /**
             * The constant LESS_THAN_EQUAL.
             */
            public static final String LESS_THAN_EQUAL = " <= ";
            /**
             * The constant GREATER_THAN.
             */
            public static final String GREATER_THAN = " > ";
            /**
             * The constant GREATER_THAN_EQUAL.
             */
            public static final String GREATER_THAN_EQUAL = " >= ";
            /**
             * The constant NOT_EQUAL_SQL.
             */
            public static final String NOT_EQUAL_SQL = " <> ";
            /**
             * The constant UNKONWN.
             */
            public static final String UNKONWN = " ?? ";
            /**
             * The constant IN.
             */
            public static final String IN = " IN ";
        }

        /**
         * The type Stringtype.
         */
        public static final class STRINGTYPE{
            /**
             * The constant CONCATENATE.
             */
            public static final String CONCATENATE = " || ";
        }

        /**
         * The type Ternary.
         */
        public static final class TERNARY{
            /**
             * The constant IF.
             */
            public static final String IF = " ? ";
        }
    }

    /**
     * The type Function.
     */
    public static final class FUNCTION{

        /**
         * The type Aggregate.
         */
        public static final class AGGREGATE{
            /**
             * The constant COUNT.
             */
            public static final String COUNT = " COUNT ";
            /**
             * The constant MIN.
             */
            public static final String MIN = " MIN ";
            /**
             * The constant MAX.
             */
            public static final String MAX = " MAX ";
            /**
             * The constant SUM.
             */
            public static final String SUM = " SUM ";
            /**
             * The constant AVG.
             */
            public static final String AVG = " AVG ";
        }

        /**
         * The type Mathematical.
         */
        public static final class MATHEMATICAL{
            /**
             * The constant ABSOLUTE.
             */
            public static final String ABSOLUTE = " ABS ";
            /**
             * The constant CEILING.
             */
            public static final String CEILING = " CEILING ";
            /**
             * The constant EXPONENTIAL.
             */
            public static final String EXPONENTIAL = " EXP ";
            /**
             * The constant FLOOR.
             */
            public static final String FLOOR = " FLOOR ";
            /**
             * The constant LOGARITHMIC.
             */
            public static final String LOGARITHMIC = " LOG ";
            /**
             * The constant LOGARITHMIC_10.
             */
            public static final String LOGARITHMIC_10 = " LOG10 ";
            /**
             * The constant POWER.
             */
            public static final String POWER = " POWER ";
            /**
             * The constant ROUND.
             */
            public static final String ROUND = " ROUND ";
            /**
             * The constant SIGN.
             */
            public static final String SIGN = " SIGN ";
            /**
             * The constant SQUARE_ROOT.
             */
            public static final String SQUARE_ROOT = " SQRT ";
            /**
             * The constant SQUARE.
             */
            public static final String SQUARE = " SQUARE ";
            /**
             * The constant TRUNCATE.
             */
            public static final String TRUNCATE = " TRUNC ";
            /**
             * The constant ACOS.
             */
            public static final String ACOS = " ACOS ";
            /**
             * The constant ASIN.
             */
            public static final String ASIN = " ASIN ";
            /**
             * The constant ATAN.
             */
            public static final String ATAN = " ATAN ";
            /**
             * The constant ATAN2.
             */
            public static final String ATAN2 = " ATN2 ";
            /**
             * The constant COS.
             */
            public static final String COS = " COS ";
            /**
             * The constant SIN.
             */
            public static final String SIN = " SIN ";
            /**
             * The constant TAN.
             */
            public static final String TAN = " TAN ";
            /**
             * The constant COT.
             */
            public static final String COT = " COT ";
            /**
             * The constant DEGREES.
             */
            public static final String DEGREES = " DEGREES ";
            /**
             * The constant PI.
             */
            public static final String PI = " PI ";
            /**
             * The constant RADIANS.
             */
            public static final String RADIANS = " RADIANS ";
        }

        /**
         * The type Typechecking.
         */
        public static final class TYPECHECKING{
            /**
             * The constant IS_ARRAY.
             */
            public static final String IS_ARRAY = " IS_ARRAY ";
            /**
             * The constant IS_BOOL.
             */
            public static final String IS_BOOL = " IS_BOOL ";
            /**
             * The constant IS_NULL.
             */
            public static final String IS_NULL = " IS_NULL ";
            /**
             * The constant IS_NUMBER.
             */
            public static final String IS_NUMBER = " IS_NUMBER ";
            /**
             * The constant IS_OBJECT.
             */
            public static final String IS_OBJECT = " IS_OBJECT ";
            /**
             * The constant IS_STRING.
             */
            public static final String IS_STRING = " IS_STRING ";
            /**
             * The constant IS_DEFINED.
             */
            public static final String IS_DEFINED = " IS_DEFINED ";
            /**
             * The constant IS_PRIMITIVE.
             */
            public static final String IS_PRIMITIVE = " IS_PRIMITIVE ";
        }

        /**
         * The type Stringtype.
         */
        public static final class STRINGTYPE{
            /**
             * The constant CONCAT.
             */
            public static final String CONCAT = " CONCAT ";
            /**
             * The constant CONTAINS.
             */
            public static final String CONTAINS = " CONTAINS ";
            /**
             * The constant ENDSWITH.
             */
            public static final String ENDSWITH = " ENDSWITH ";
            /**
             * The constant INDEX_OF.
             */
            public static final String INDEX_OF = " INDEX_OF ";
            /**
             * The constant LEFT.
             */
            public static final String LEFT = " LEFT ";
            /**
             * The constant LENGTH.
             */
            public static final String LENGTH = " LENGTH ";
            /**
             * The constant LOWER.
             */
            public static final String LOWER = " LOWER ";
            /**
             * The constant LTRIM.
             */
            public static final String LTRIM = " LTRIM ";
            /**
             * The constant REPLACE.
             */
            public static final String REPLACE = " REPLACE ";
            /**
             * The constant REPLICATE.
             */
            public static final String REPLICATE = " REPLICATE ";
            /**
             * The constant REVERSE.
             */
            public static final String REVERSE = "REVERSE";
            /**
             * The constant RIGHT.
             */
            public static final String RIGHT = " RIGHT ";
            /**
             * The constant RTRIM.
             */
            public static final String RTRIM = " RTRIM ";
            /**
             * The constant STARTSWITH.
             */
            public static final String STARTSWITH = " STARTSWITH ";
            /**
             * The constant SUBSTRING.
             */
            public static final String SUBSTRING = " SUBSTRING ";
            /**
             * The constant UPPER.
             */
            public static final String UPPER = " UPPER ";
        }

        /**
         * The type Arraytype.
         */
        public static final class ARRAYTYPE{
            /**
             * The constant ARRAY_CONCAT.
             */
            public static final String ARRAY_CONCAT = " ARRAY_CONCAT ";
            /**
             * The constant ARRAY_CONTAINS.
             */
            public static final String ARRAY_CONTAINS = " ARRAY_CONTAINS ";
            /**
             * The constant ARRAY_LENGTH.
             */
            public static final String ARRAY_LENGTH = " ARRAY_LENGTH ";
            /**
             * The constant ARRAY_SLICE.
             */
            public static final String ARRAY_SLICE = " ARRAY_SLICE ";
        }

        /**
         * The type Geospatial.
         */
        public static final class GEOSPATIAL{
            /**
             * The constant ST_WITHIN.
             */
            public static final String ST_WITHIN = " ST_WITHIN ";
            /**
             * The constant ST_DISTANCE.
             */
            public static final String ST_DISTANCE = " ST_DISTANCE ";
            /**
             * The constant ST_INTERSECTS.
             */
            public static final String ST_INTERSECTS = " ST_INTERSECTS ";
            /**
             * The constant ST_OVERLAPS.
             */
            public static final String ST_OVERLAPS = " ST_OVERLAPS ";
            /**
             * The constant ST_ISVALID.
             */
            public static final String ST_ISVALID = " ST_ISVALID ";
            /**
             * The constant ST_ISVALIDDETAILED.
             */
            public static final String ST_ISVALIDDETAILED = " ST_ISVALIDDETAILED ";
        }

        /**
         * The type Methodnames.
         */
        public static final class METHODNAMES{
            /**
             * The constant APPEND_RESTRICTION_EXCEPTION.
             */
            public static final String APPEND_RESTRICTION_EXCEPTION = "appendRestrictionExpression";
        }
    }
}
