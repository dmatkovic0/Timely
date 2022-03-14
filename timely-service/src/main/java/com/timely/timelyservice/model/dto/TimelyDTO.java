package com.timely.timelyservice.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimelyDTO {

    private Long id;

    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters")
    @Id
    @Column(name = "project")
    private String project;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Column(name = "start", nullable = false)
    private Timestamp start;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Column(name = "stop")
    private Timestamp stop;

    @Column(name = "duration")
    private Long duration;
}
