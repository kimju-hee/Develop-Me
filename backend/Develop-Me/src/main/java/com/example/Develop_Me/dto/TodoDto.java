package com.example.Develop_Me.dto;


import com.example.Develop_Me.entity.Group;
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
    private Group group;
    private Users users;

    @Builder
    public TodoDto(Long todoId, String todoText, boolean checked, LocalDate todoDate, Group group, Users users){
        this.todoId = todoId;
        this.todoText = todoText;
        this.checked = checked;
        this.todoDate = todoDate;
        this.group = group;
        this.users = users;
    }

    public Todo toEntity() {
        return Todo.builder()
                .todoId(todoId)
                .todoText(todoText)
                .checked(checked)
                .todoDate(todoDate)
                .group(group)
                .users(users)
                .build();
    }
}
