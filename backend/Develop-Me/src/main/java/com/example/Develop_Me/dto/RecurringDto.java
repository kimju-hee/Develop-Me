package com.example.Develop_Me.dto;


import com.example.Develop_Me.entity.Recurring;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
@NoArgsConstructor
public class RecurringDto {
    private Long recurringId;
    private String recurringType;
    private  String recurringInformation;

    public RecurringDto(Long recurringId, String recurringType, String recurringInformation){
        this.recurringId = recurringId;
        this.recurringType = recurringType;
        this.recurringInformation = recurringInformation;
    }

    public Recurring toEntity(){
        return Recurring.builder()
                .recurringId(recurringId)
                .recurringType(recurringType)
                .recurringInformation(recurringInformation)
                .build();
    }
}
