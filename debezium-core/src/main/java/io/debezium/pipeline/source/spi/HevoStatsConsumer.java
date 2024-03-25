package io.debezium.pipeline.source.spi;

import io.debezium.pipeline.spi.Partition;

public interface HevoStatsConsumer<P extends Partition> {
    public abstract void publishProgressStats(HevoJobProgressStats<P> hevoBatchStats);

    public abstract void publishSummaryStats(HevoJobSummaryStats<P> hevoBatchStats);
}
