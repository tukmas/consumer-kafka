package com.example.metricsconsumer.listener;

import com.example.metricsconsumer.model.kafka.MetricsDTO;
import com.example.metricsconsumer.service.MetricsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaTopicsListener {

    private final MetricsService metricsService;
    @KafkaListener(topics = "metrics-topic",
            groupId = "group_json",
            containerFactory = "metricsKafkaListenerFactory")
    public void consume(MetricsDTO metrics) {
        try {
            log.info("try to save metrics: {}", metrics);
            metricsService.saveMetrics(metrics);
            log.info("metrics were saved successfully");
        }
        catch (Exception e) {
            log.error("Error while save metrics: {} {}", metrics, e);
        }

    }
}
