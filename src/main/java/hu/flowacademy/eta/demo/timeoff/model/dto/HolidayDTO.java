package hu.flowacademy.eta.demo.timeoff.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HolidayDTO {
    private Long userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String type;
}
