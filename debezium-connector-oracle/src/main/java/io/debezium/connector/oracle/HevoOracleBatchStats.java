package io.debezium.connector.oracle;

import io.debezium.pipeline.source.spi.HevoBatchStats;

import java.math.BigInteger;

public class HevoOracleBatchStats implements HevoBatchStats {
    BigInteger currentScn;

    Integer lastCapturedDmlCount;

    Long lastBatchProcessingDuration;

    Long commitedTransactions;

    BigInteger commitedScn;

    Long commitedDmlCount;

    Long skippedDmlCount;

    BigInteger startSCN;

    BigInteger batchEndScn;

    public HevoOracleBatchStats(BigInteger currentScn, Integer lastCapturedDmlCount, Long lastBatchProcessingDuration, Long commitedTransactions, BigInteger commitedScn, Long commitedDmlCount, Long skippedDmlCount, BigInteger startSCN, BigInteger batchEndScn) {
        this.currentScn = currentScn;
        this.lastCapturedDmlCount = lastCapturedDmlCount;
        this.lastBatchProcessingDuration = lastBatchProcessingDuration;
        this.commitedTransactions = commitedTransactions;
        this.commitedScn = commitedScn;
        this.commitedDmlCount = commitedDmlCount;
        this.skippedDmlCount = skippedDmlCount;
        this.startSCN = startSCN;
        this.batchEndScn = batchEndScn;
    }

    public String getSourceCurrentPosition(){
        return currentScn.toString();
    }

    public Integer getDmlsCapturedCountInDBZBatch(){
        return lastCapturedDmlCount;
    }

    public Long getDBZBatchProcessingDuration(){
        return lastBatchProcessingDuration;
    }


    public Long getProcessedDmlRecordsCount(){
        return commitedDmlCount;
    }

    public Long getSkippedDmlRecordsCount(){
        return skippedDmlCount;
    }

    public String getDBZBatchStartPosition(){
        return startSCN.toString();
    }

    public String getDBZBatchEndPosition(){
        return batchEndScn.toString();
    }

    public Long getDBZBatchCommitedTransactionsCount(){
        return commitedTransactions;
    }

    public String getLastCommitPosition(){
        return commitedScn.toString();
    }

}
