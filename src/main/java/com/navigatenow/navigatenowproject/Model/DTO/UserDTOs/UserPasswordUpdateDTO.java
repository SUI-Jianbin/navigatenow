package com.navigatenow.navigatenowproject.Model.DTO.UserDTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPasswordUpdateDTO {

    private String userName;
    @NotNull(message = "password required")
    @Size(min = 8, max = 20, message = "password should be more than 7 and less than 20")
    private String password;
    @UpdateTimestamp
    private LocalDateTime updatedAt = LocalDateTime.now();
}
