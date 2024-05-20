package com.example.metricsconsumer.service;

import com.example.metricsconsumer.model.db.Metric;
import com.example.metricsconsumer.model.db.Metrics;
import com.example.metricsconsumer.model.kafka.MetricDTO;
import com.example.metricsconsumer.model.kafka.MetricsDTO;
import com.example.metricsconsumer.repository.MetricsRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MetricsService {
    private final MetricsRepository metricsRepository;

    @Transactional(rollbackFor = { SQLException.class })
    public void saveMetrics(MetricsDTO metricsDTO) {
        Metrics metrics = new Metrics();
        mapping(metrics, metricsDTO);
        System.out.println(metrics);
        metricsRepository.save(metrics);
    }

    public List<Metrics> getAllMetrics() {
        return metricsRepository.findAll();
    }

    public List<Metrics> getAllMetricsByName(String metricName) {
        return metricsRepository.findAllByMetricsNameEquals(metricName);
    }

    private void mapping(Metrics out, MetricsDTO in) {
        out.setMetricsName(in.getMetricsId());
        for (MetricDTO metricDTO : in.getMetrics()) {
            Metric metric = new Metric();
            metric.setServiceName(metricDTO.getServiceName());
            metric.setWasError(metricDTO.getWasError());
            metric.setUsedMemoryMb(metricDTO.getUsedMemoryMb());
            metric.setUsedTimeMs(metricDTO.getUsedTimeMs());
            out.getMetrics().add(metric);
        }
    }
}
