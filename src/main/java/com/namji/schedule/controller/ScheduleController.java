package com.namji.schedule.controller;

import com.namji.schedule.dto.ScheduleRequestDto;
import com.namji.schedule.dto.ScheduleResponseDto;
import com.namji.schedule.entity.Schedule;
import com.namji.schedule.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<Schedule> getSchedules() {
        return scheduleService.getSchedules();
    }

    @GetMapping("/schedule/{id}")
    public Optional<Schedule> selectSchedule (@PathVariable Long id) {
        return scheduleService.selectSchedule(id);
    }

    @PutMapping("/schedule/{id}")
    public ScheduleResponseDto updateSchedule (@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.updateSchedule(id, requestDto);
    }

    @DeleteMapping("/schedule/{id}")
    public String deleteSchedule (@PathVariable Long id) {
        return scheduleService.deleteSchedule(id);
    }
}
