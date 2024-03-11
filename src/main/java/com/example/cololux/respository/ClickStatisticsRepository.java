package com.example.cololux.respository;


import com.example.cololux.entity.ClickStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;


public interface ClickStatisticsRepository extends JpaRepository<ClickStatistics, Date> {
}
