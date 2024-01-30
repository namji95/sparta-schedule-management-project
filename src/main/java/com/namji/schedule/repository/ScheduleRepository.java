package com.namji.schedule.repository;

import com.namji.schedule.dto.ScheduleRequestDto;
import com.namji.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
