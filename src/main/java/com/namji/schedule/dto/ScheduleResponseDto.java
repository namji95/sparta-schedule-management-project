package com.namji.schedule.dto;

import com.namji.schedule.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private final String title;
    private final String content;
    private final String user;
    private final LocalDateTime createdAt;

    public ScheduleResponseDto(Schedule schedule) {
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.user = schedule.getUser();
        this.createdAt = schedule.getCreatedAt();
    }


}
