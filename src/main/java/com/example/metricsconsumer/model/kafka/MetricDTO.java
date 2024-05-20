package com.example.metricsconsumer.model.kafka;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MetricDTO {
    private Long usedTimeMs;
    private Long usedMemoryMb;
    private String serviceName;
    private Boolean wasError;
}
