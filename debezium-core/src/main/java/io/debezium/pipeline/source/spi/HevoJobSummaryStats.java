package io.debezium.pipeline.source.spi;

import io.debezium.pipeline.metrics.StreamingChangeEventSourceMetrics;
import io.debezium.pipeline.spi.Partition;

import java.sql.Timestamp;

public abstract class HevoJobSummaryStats<P extends Partition> implements HevoJobStats {

    protected StreamingChangeEventSourceMetrics<P> streamingMetrics;
    protected HevoJobSummaryStats(StreamingChangeEventSourceMetrics<P> streamingMetrics){
        this.streamingMetrics = streamingMetrics;
    }

    public abstract Timestamp getJobStartTime();

    public abstract Timestamp getJobEndTime();

    public abstract String getJobStartPosition();

    public abstract String getJobEndPosition();

    public abstract Long getTotalRecords();

    public abstract Long getIncludedRecords();

    public abstract Long getExcludedRecords();

    public abstract Long getCommittedTransactionsCount();

}
