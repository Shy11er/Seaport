package com.example.Seaport.repository;

import com.example.Seaport.model.Schedule;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
//    @Query("SELECT s FROM Schedule s LEFT JOIN FETCH s.requests WHERE s.id = :scheduleId")
//    Optional<Schedule> findByIdWithRequests(@Param("scheduleId") Integer scheduleId);

//    @EntityGraph(attributePaths = {"request", "request.ship"})
//    Schedule findAllRel();

    @EntityGraph(attributePaths = {"requests", "requests.ship"})
    Schedule findWithRequestsById(Integer id);

    @Query("SELECT s FROM Schedule s JOIN FETCH s.requests r " +
            "ORDER BY " +
            "CASE WHEN :sortBy IS NOT NULL AND :sortBy = 'arrival' THEN r.arrival " +
            "ELSE r.departure END, " +  // Add a comma here
            ":dir")
    Schedule findSchedule(@Param("sortBy") String sortBy, @Param("dir") String dir);
}

