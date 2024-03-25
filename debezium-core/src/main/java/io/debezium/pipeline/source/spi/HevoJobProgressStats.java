package io.debezium.pipeline.source.spi;

import io.debezium.pipeline.metrics.StreamingChangeEventSourceMetrics;
import io.debezium.pipeline.spi.Partition;

import java.sql.Timestamp;

/**
 * The interface Hevo batch stats.
 */
public abstract class HevoJobProgressStats<P extends Partition> implements HevoJobStats {

    protected StreamingChangeEventSourceMetrics<P> streamingMetrics;

    protected HevoJobProgressStats(StreamingChangeEventSourceMetrics<P> streamingMetrics){
        this.streamingMetrics = streamingMetrics;
    }

    public abstract Timestamp getJobStartTime();

    public abstract Timestamp getObservationTime();

    /**
     * Gets source current position.
     *
     * @return the source current position
     */
    public abstract String getSourceCurrentPosition();

    /**
     * Gets processed dml records count.
     *
     * @return the processed dml records count
     */
    public abstract Long getIncludedDmlRecordsCount();

    /**
     * Gets skipped dml records count.
     *
     * @return the skipped dml records count
     */
    public abstract Long getExcludedDmlRecordsCount();

    /**
     * Gets dbz batch commited transactions count.
     *
     * @return the dbz batch commited transactions count
     */
    public  abstract Long getDBZCommittedTransactionsCount();

    /**
     * Gets last commit position.
     *
     * @return the last commit position
     */
    public abstract String getLastCommitPosition();

}
