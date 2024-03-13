package io.debezium.pipeline.source.spi;

import org.apache.kafka.common.protocol.types.Field;

/**
 * The interface Hevo batch stats.
 */
public interface HevoBatchStats {

    /**
     * Gets source current position.
     *
     * @return the source current position
     */
    public abstract String getSourceCurrentPosition();

    /**
     * Gets dmls captured count in dbz batch.
     *
     * @return the dmls captured count in dbz batch
     */
    public abstract Integer getDmlsCapturedCountInDBZBatch();

    /**
     * Gets dbz batch processing duration.
     *
     * @return the dbz batch processing duration
     */
    public abstract Long getDBZBatchProcessingDuration();

    /**
     * Gets processed dml records count.
     *
     * @return the processed dml records count
     */
    public abstract Long getProcessedDmlRecordsCount();

    /**
     * Gets skipped dml records count.
     *
     * @return the skipped dml records count
     */
    public abstract Long getSkippedDmlRecordsCount();

    /**
     * Gets dbz batch start position.
     *
     * @return the dbz batch start position
     */
    public abstract String getDBZBatchStartPosition();

    /**
     * Gets dbz batch end position.
     *
     * @return the dbz batch end position
     */
    public abstract String getDBZBatchEndPosition();

    /**
     * Gets dbz batch commited transactions count.
     *
     * @return the dbz batch commited transactions count
     */
    public  abstract Long getDBZBatchCommitedTransactionsCount();

    /**
     * Gets last commit position.
     *
     * @return the last commit position
     */
    public abstract String getLastCommitPosition();

}
