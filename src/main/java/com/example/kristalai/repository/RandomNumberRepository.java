package com.example.kristalai.repository;

import com.example.kristalai.model.RandomNumberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface RandomNumberRepository extends JpaRepository<RandomNumberModel, Long> {

    @Query(nativeQuery = true, value = "SELECT random_number FROM random_data_repository WHERE created_at > :date")
    List<Long> getHistoricalData(@Param("date") Date historicalTime);
}
