/*
 * Copyright Debezium Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.debezium.pipeline.metrics;

import io.debezium.pipeline.source.spi.HevoJobProgressStats;
import io.debezium.pipeline.source.spi.HevoJobSummaryStats;
import io.debezium.pipeline.source.spi.StreamingProgressListener;
import io.debezium.pipeline.spi.Partition;

/**
 * Metrics related to the streaming phase of a connector.
 */
public interface StreamingChangeEventSourceMetrics<P extends Partition>
        extends ChangeEventSourceMetrics<P>, StreamingProgressListener {

    public abstract HevoJobProgressStats<P> getCurrentJobProgressStats();

    public abstract HevoJobSummaryStats<P> getJobSummaryStats();
}
