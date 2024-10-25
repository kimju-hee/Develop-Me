package com.example.Develop_Me.dto;


import com.example.Develop_Me.entity.Type;
import com.example.Develop_Me.entity.Todo;
import com.example.Develop_Me.entity.Users;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TodoDto {
    private Long todoId;
    private String todoText;
    private boolean checked;
    private LocalDate todoDate;
    private Type type;
    private Users users;

    @Builder
    public TodoDto(Long todoId, String todoText, boolean checked, LocalDate todoDate, Type type, Users users){
        this.todoId = todoId;
        this.todoText = todoText;
        this.checked = checked;
        this.todoDate = todoDate;
        this.type = type;
        this.users = users;
    }

    public Todo toEntity() {
        return Todo.builder()
                .todoId(todoId)
                .todoText(todoText)
                .checked(checked)
                .todoDate(todoDate)
                .type(type)
                .users(users)
                .build();
    }
}
