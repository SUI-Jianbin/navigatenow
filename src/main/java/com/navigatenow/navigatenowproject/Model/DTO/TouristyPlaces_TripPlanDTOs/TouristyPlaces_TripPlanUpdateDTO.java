package com.navigatenow.navigatenowproject.Model.DTO.TouristyPlaces_TripPlanDTOs;

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
public class TouristyPlaces_TripPlanUpdateDTO {
    @NotNull(message = "touristyPlaces_tripPlanId required")
    private Integer touristyPlaces_tripPlanId;
    @NotNull(message = "tripPlanId required")
    private Integer tripPlanId;
    @NotNull(message = "touristyPlacesId required")
    private Integer touristyPlacesId;
    @UpdateTimestamp
    private LocalDateTime updatedAt = LocalDateTime.now();
}
