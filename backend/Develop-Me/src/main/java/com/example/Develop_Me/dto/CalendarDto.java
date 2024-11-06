package com.example.Develop_Me.dto;

import com.example.Develop_Me.entity.Calendar;
import com.example.Develop_Me.entity.Type;
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
    private Type type;
    private Users usres;
    private Recurring recurring;

    public CalendarDto(Long calendarId, String calendarName, LocalDate calendarDate, Type type, Users usres,
                       Recurring recurring) {
        this.calendarId = calendarId;
        this.calendarName = calendarName;
        this.calendarDate = calendarDate;
        this.type = type;
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
