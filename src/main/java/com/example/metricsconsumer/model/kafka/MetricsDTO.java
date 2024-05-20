package com.example.metricsconsumer.model.kafka;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MetricsDTO {

    private String metricsId;
    private List<MetricDTO> metrics;
}
