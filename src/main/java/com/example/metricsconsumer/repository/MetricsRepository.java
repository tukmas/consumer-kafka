package com.example.metricsconsumer.repository;

import com.example.metricsconsumer.model.db.Metrics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetricsRepository extends JpaRepository<Metrics, Long> {
    List<Metrics> findAllByMetricsNameEquals(String metricName);

}
