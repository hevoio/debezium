package io.debezium.pipeline.source.spi;

public interface HevoStatsConsumer {
    public abstract void publishStats(HevoBatchStats hevoBatchStats);
}
