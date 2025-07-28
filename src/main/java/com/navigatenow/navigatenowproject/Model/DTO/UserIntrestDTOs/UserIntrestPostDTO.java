package com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserIntrestPostDTO {

    private Integer userintrestId;
    @NotNull(message = "intrestDescription required")
    @Size(min = 2,message = "interest description should be more than 2 letters")
    private String intrestDescription;
    @NotNull(message = "intrestValue required")
    @Size(min = 2,message = "interest value should be more than 2 letters")
    private String intrestValue;
    @CreationTimestamp
    private LocalDateTime createdAt;

}
