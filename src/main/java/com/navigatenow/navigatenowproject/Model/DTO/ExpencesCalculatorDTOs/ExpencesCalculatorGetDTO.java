package com.navigatenow.navigatenowproject.Model.DTO.ExpencesCalculatorDTOs;

import com.navigatenow.navigatenowproject.Model.Entity.TouristyPlacesEntity;
import jakarta.persistence.Column;
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
public class ExpencesCalculatorGetDTO {
    private Integer expencesCalculatorId;
    private String name;
    private String description;
    private String periority;
    private String price;
    private String totalCost;
    private String type;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private TouristyPlacesEntity touristyPlacesEntity;
}
