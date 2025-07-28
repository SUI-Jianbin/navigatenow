package com.navigatenow.navigatenowproject.Model.DTO.ExpencesCalculatorDTOs;

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
public class ExpencesCalculatorUpdateDTO {
    private Integer expencesCalculatorId;
    private String name;
    private String description;
    private String periority;
    private String price;
    private String totalCost;
    private String type;
    @UpdateTimestamp
    private LocalDateTime updatedAt = LocalDateTime.now();
}
