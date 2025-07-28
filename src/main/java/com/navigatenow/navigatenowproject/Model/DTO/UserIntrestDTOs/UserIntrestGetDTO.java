package com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs;

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
public class UserIntrestGetDTO {
    private Integer userintrestId;
    private String intrestDescription;
    private String intrestValue;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
