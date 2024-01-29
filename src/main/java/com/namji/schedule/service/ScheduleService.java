package com.namji.schedule.service;

import com.namji.schedule.dto.ScheduleRequestDto;
import com.namji.schedule.dto.ScheduleResponseDto;
import com.namji.schedule.entity.Schedule;
import com.namji.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService (ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        // requestdto -> entity
        Schedule schedule = new Schedule(requestDto);

        // ntity -> repository
        Schedule saveSchedule = scheduleRepository.save(schedule);

        // DB 저장
        ScheduleResponseDto responseDto = new ScheduleResponseDto(saveSchedule);

        return responseDto;
    }

    public List<Schedule> getSchedule() {
        return scheduleRepository.findAll();
    }
}
