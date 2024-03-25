package io.debezium.pipeline.source.spi;

import io.debezium.pipeline.metrics.StreamingChangeEventSourceMetrics;
import io.debezium.pipeline.spi.Partition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HevoStatsPublisher<P extends Partition> implements Runnable {

    private HevoStatsConsumer statsConsumer;

    private Logger log = LoggerFactory.getLogger(HevoStatsPublisher.class);

    private long statsSyncFrequencyInMillis = 30000;

    private StreamingChangeEventSourceMetrics<P> streamingChangeEventSourceMetrics;
    public HevoStatsPublisher(HevoStatsConsumer statsConsumer, long statsSyncFrequencyInMillis, StreamingChangeEventSourceMetrics<P> streamingChangeEventSourceMetrics){
        this.statsConsumer = statsConsumer;
        this.statsSyncFrequencyInMillis = statsSyncFrequencyInMillis;
        this.streamingChangeEventSourceMetrics = streamingChangeEventSourceMetrics;
    }

    @Override
    public void run(){
        try {
            statsConsumer.publishProgressStats(streamingChangeEventSourceMetrics.getCurrentJobProgressStats());
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(statsSyncFrequencyInMillis);
                statsConsumer.publishProgressStats(streamingChangeEventSourceMetrics.getCurrentJobProgressStats());
            }
        }catch (InterruptedException e){
            log.info("Stats publisher thread interrupted");
            Thread.currentThread().interrupt();
        } finally {
            statsConsumer.publishSummaryStats(streamingChangeEventSourceMetrics.getJobSummaryStats());
        }
    }

}
