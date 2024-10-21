package com.example.Develop_Me.dto;

import com.example.Develop_Me.entity.Calendar;
import com.example.Develop_Me.entity.Group;
import com.example.Develop_Me.entity.Recurring;
import com.example.Develop_Me.entity.Users;
import java.time.LocalDate;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
@NoArgsConstructor
public class CalendarDto {
    private Long calendarId;
    private String calendarName;
    private LocalDate calendarDate;
    private Group group;
    private Users usres;
    private Recurring recurring;

    public CalendarDto(Long calendarId, String calendarName, LocalDate calendarDate, Group group, Users usres,
                       Recurring recurring) {
        this.calendarId = calendarId;
        this.calendarName = calendarName;
        this.calendarDate = calendarDate;
        this.group = group;
        this.usres = usres;
        this.recurring = recurring;
    }

    public Calendar toEntity() {
        return Calendar.builder()
                .calendarId(calendarId)
                .calendarName(calendarName)
                .calendarDate(calendarDate)
                .users(usres)
                .build();
    }

}
