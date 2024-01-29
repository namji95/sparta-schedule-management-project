package com.namji.schedule.controller;

import com.namji.schedule.dto.ScheduleRequestDto;
import com.namji.schedule.dto.ScheduleResponseDto;
import com.namji.schedule.entity.Schedule;
import com.namji.schedule.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/schedule")
    public ScheduleResponseDto createSchedule (@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.createSchedule(requestDto);
    }

    @GetMapping("/schedule")
    public List<Schedule> getSchedule() {
        return scheduleService.getSchedule();
    }

}
