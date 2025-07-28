package com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User_UserIntrestPostDTO {
    private Integer userUserintrestId;
    @NotNull(message = "userId required")
    private Integer userId;
    @NotNull(message = "userintrestId required")
    private Integer userintrestId;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
