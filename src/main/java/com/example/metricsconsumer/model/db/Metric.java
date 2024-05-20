package com.example.metricsconsumer.model.db;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "metric")
public class Metric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "used_time_ms")
    private Long usedTimeMs;

    @Column(name = "used_memory_db")
    private Long usedMemoryMb;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "was_error")
    private Boolean wasError;
}
