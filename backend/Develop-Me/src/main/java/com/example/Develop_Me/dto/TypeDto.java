package com.example.Develop_Me.dto;

import com.example.Develop_Me.entity.Type;
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
public class TypeDto {
    private Long typeId;
    private String typeName;
    private String typeGroup;
    private Users users;

    @Builder
    public TypeDto(Long groupId, String typeName, String typeGroup, Users users){
        this.typeId = groupId;
        this.typeName = typeName;
        this.typeGroup = typeGroup;
        this.users = users;
    }

    public Type toEntity(){
        return Type.builder()
                .typeId(typeId)
                .typeName(typeName)
                .typeGroup(typeGroup)
                .users(users)
                .build();
    }
}
