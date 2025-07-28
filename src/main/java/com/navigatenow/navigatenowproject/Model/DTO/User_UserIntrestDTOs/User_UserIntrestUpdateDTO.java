package com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User_UserIntrestUpdateDTO {
    @NotNull(message = "userUserintrestId required")
    private Integer userUserintrestId;
    @NotNull(message = "userId required")
    private Integer userId;
    @NotNull(message = "userintrestId required")
    private Integer userintrestId;
    @UpdateTimestamp
    private LocalDateTime updatedAt = LocalDateTime.now();
}
