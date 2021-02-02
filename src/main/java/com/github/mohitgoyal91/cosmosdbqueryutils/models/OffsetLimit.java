package com.github.mohitgoyal91.cosmosdbqueryutils.models;

/**
 * The type OffsetLimit.
 * This represents a OFFSET LIMIT clause.
 */
public class OffsetLimit {
    private int offset;
    private int limit;

    public OffsetLimit(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    /**
     * Gets the offset
     * @return Number of results to skip
     */
    public int getOffset() {
        return offset;
    }

    /**
     * Gets the limit
     * @return Maximum number of results
     */
    public int getLimit() {
        return limit;
    }
}
