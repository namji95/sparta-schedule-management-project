package com.namji.schedule.service;

import com.namji.schedule.dto.ScheduleRequestDto;
import com.namji.schedule.dto.ScheduleResponseDto;
import com.namji.schedule.entity.Schedule;
import com.namji.schedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Schedule> getSchedules() {
        return scheduleRepository.findAll();
    }

    public Optional<Schedule> selectSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("해당 아이디는 존재하지 않습니다 : " + id);
        });

        return scheduleRepository.findById(schedule.getId());
    }

    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto) {
        // 해당 아이디가 존재하는지 확인
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() ->{
            // IllegalArgumentException 예외 처리
            throw new IllegalArgumentException("해당 아이디는 존재하지 않습니다 : " + id);
        });

        // 존재한다면 가져온 값 Entity에 저장
        schedule.setTitle(requestDto.getTitle());
        schedule.setContent(requestDto.getContent());
        schedule.setUser(requestDto.getUser());
        schedule.setPassword(requestDto.getPassword());

        // 수정 값 DB 저장
        Schedule updateSchedule = scheduleRepository.save(schedule);

        ScheduleResponseDto responseDto = new ScheduleResponseDto(updateSchedule);

        return responseDto;
    }

    public String deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("해당 아이디는 존재하지 않습니다 : " + id);
        });

        scheduleRepository.delete(schedule);

        return "해당 아이디를 삭제했습니다.";
    }
}
