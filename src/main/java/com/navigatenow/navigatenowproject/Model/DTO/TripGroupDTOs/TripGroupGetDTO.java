package com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs;

import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanGetDTO;
import com.navigatenow.navigatenowproject.Model.Entity.TripPlanEntity;
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
public class TripGroupGetDTO {
    private Integer tripGroupId;
    private String groupName;
    private String groupDescription;
    private Integer numberOfTourists;
    private Integer groupNumberLemit;
    private TripPlanGetDTO tripPlanGetDTO;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
