package io.debezium.connector.oracle;

import io.debezium.pipeline.source.spi.HevoJobProgressStats;
import io.debezium.pipeline.source.spi.HevoJobSummaryStats;

import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;

public class HevoOracleJobSummaryStats extends HevoJobSummaryStats<OraclePartition> {

    private final Timestamp jobStartTime;

    private final Timestamp jobEndTime;

    private final BigInteger jobStartScn;

    private final BigInteger jobEndScn;

    private final Long totalRecords;

    private final Long includedRecords;

    private final Long excludedRecords;

    private final Long committedTransactionsCount;

    public HevoOracleJobSummaryStats(OracleStreamingChangeEventSourceMetrics streamingMetrics){
        super(streamingMetrics);
        this.jobStartTime = streamingMetrics.getJobStartTime();
        this.jobEndTime = streamingMetrics.getJobEndTime();
        this.jobStartScn = streamingMetrics.getJobStartScn();
        this.jobEndScn = streamingMetrics.getOffsetScn();
        this.totalRecords = streamingMetrics.getTotalProcessedRows();
        this.includedRecords = streamingMetrics.getCommitedDmlCount();
        this.excludedRecords = streamingMetrics.getSkippedDmlCount();
        this.committedTransactionsCount = streamingMetrics.getNumberOfCommittedTransactions();
    }

    public Timestamp getJobStartTime(){
        return jobStartTime;
    }

    public Timestamp getJobEndTime(){
        return jobEndTime;
    }

    public String getJobStartPosition() { return String.valueOf(jobStartScn);}

    public String getJobEndPosition() { return String.valueOf(jobEndScn);}

    public Long getTotalRecords(){return this.totalRecords;}

    public Long getIncludedRecords(){return this.includedRecords;}

    public Long getExcludedRecords(){return this.excludedRecords;}

    public Long getCommittedTransactionsCount(){return this.committedTransactionsCount;}
}
