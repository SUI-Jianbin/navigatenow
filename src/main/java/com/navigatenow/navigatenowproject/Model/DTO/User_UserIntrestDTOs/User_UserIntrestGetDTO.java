package com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs;

import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.Entity.UserIntrestEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User_UserIntrestGetDTO {

    private Integer userUserintrestId;
    private Integer userId;
    private Integer userintrestId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserIntrestGetDTO userIntrestEntity;

}
