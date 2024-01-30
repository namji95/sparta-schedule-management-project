package com.namji.schedule.entity;

import com.namji.schedule.dto.ScheduleRequestDto;
import com.namji.schedule.dto.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Schedule extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String title;

    @Column (nullable = false)
    private String content;

    @Column (nullable = false)
    private String user;

    @Column (nullable = false)
    private String password;

    public Schedule (ScheduleRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.user = requestDto.getUser();
        this.password = requestDto.getPassword();
    }

    public Schedule(Long id) {
        super();
    }

    public void update (ScheduleRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.user = requestDto.getUser();
        this.password = requestDto.getPassword();
    }
}
