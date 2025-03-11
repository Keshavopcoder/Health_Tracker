package com.htps.repository;
import com.htps.entities.HealthStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthStatsRepository extends JpaRepository<HealthStats, Long> {
    HealthStats findByUserId(Long userId);
}
