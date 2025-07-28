package com.navigatenow.navigatenowproject.Model.DTO.ChecklistDTOs;

import com.navigatenow.navigatenowproject.Model.Entity.TripPlanEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class ChecklistGetDTO {
    private Integer checklistId;
    @NotNull(message = "itemName required")
    @Size(min = 2,message = "firstName should be more than 2 letters")
    private String itemName;
    private String itemDescription;
    private String itemImportance;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private TripPlanEntity tripPlanEntity;
}
