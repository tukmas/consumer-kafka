package com.example.metricsconsumer.api;

import com.example.metricsconsumer.model.db.Metrics;
import com.example.metricsconsumer.service.MetricsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MetricsController {
    private final MetricsService metricsService;

    @GetMapping("/metrics")
    public ResponseEntity<List<Metrics>> getAllMetrics() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(metricsService.getAllMetrics());
        }
        catch (Exception e) {
            log.error("Error while GET /metrics: " + e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<List<Metrics>> getAllMetricsByMetricName(@PathVariable("id") String metricName) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(metricsService.getAllMetricsByName(metricName));
        }
        catch (Exception e) {
            log.error("Error while GET /metrics/{id}: " + e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
