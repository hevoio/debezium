package io.debezium.connector.oracle;

import io.debezium.pipeline.source.spi.HevoJobProgressStats;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;

public class HevoOracleJobProgressStats extends HevoJobProgressStats<OraclePartition>{
    BigInteger currentScn;

    private final Timestamp jobStartTime;

    private final Timestamp observationTime;

    Long lastBatchProcessingDuration;

    Long committedTransactions;

    BigInteger committedScn;

    Long committedDmlCount;

    Long skippedDmlCount;

    public HevoOracleJobProgressStats(OracleStreamingChangeEventSourceMetrics streamingMetrics) {
        super(streamingMetrics);
        this.jobStartTime = streamingMetrics.getJobStartTime();
        this.observationTime = Timestamp.from(Instant.now());
        this.currentScn = streamingMetrics.getCurrentScn();
        this.lastBatchProcessingDuration = streamingMetrics.getLastBatchProcessingTimeInMilliseconds();
        this.committedTransactions = streamingMetrics.getNumberOfCommittedTransactions();
        this.committedScn = streamingMetrics.getCommittedScn();
        this.committedDmlCount = streamingMetrics.getCommitedDmlCount();
        this.skippedDmlCount = streamingMetrics.getSkippedDmlCount();
    }

    public Timestamp getJobStartTime(){
        return jobStartTime;
    }

    public Timestamp getObservationTime(){
        return observationTime;
    }

    public String getSourceCurrentPosition(){
        return String.valueOf(currentScn.toString());
    }

    public Long getIncludedDmlRecordsCount(){
        return committedDmlCount;
    }

    public Long getExcludedDmlRecordsCount(){
        return skippedDmlCount;
    }

    public Long getDBZCommittedTransactionsCount(){
        return committedTransactions;
    }

    public String getLastCommitPosition(){
        return String.valueOf(committedScn);
    }
}
