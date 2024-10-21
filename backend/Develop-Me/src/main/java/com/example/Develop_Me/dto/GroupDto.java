package com.example.Develop_Me.dto;

import com.example.Develop_Me.entity.Group;
import com.example.Develop_Me.entity.Users;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
@NoArgsConstructor
public class GroupDto {
    private Long groupId;
    private String groupName;
    private Users users;

    @Builder
    public GroupDto(Long groupId, String groupName,Users users){
        this.groupId = groupId;
        this.groupName = groupName;
        this.users = users;
    }

    public Group toEntity(){
        return Group.builder()
                .groupId(groupId)
                .groupName(groupName)
                .users(users)
                .build();
    }
}
