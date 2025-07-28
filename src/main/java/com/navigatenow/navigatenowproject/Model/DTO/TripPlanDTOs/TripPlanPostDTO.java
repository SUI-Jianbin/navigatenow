package com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs;

import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlaces_TripPlanDTOs.TouristyPlaces_TripPlanPostDTO;
import com.navigatenow.navigatenowproject.Model.Entity.TouristyPlaces_TripPlanEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripPlanPostDTO {
    private Integer tripPlanId;
    @NotNull(message = "planName required")
    @Size(min = 2,message = "plan name should be more than 2 letters")
    private String planName;
    @NotNull(message = "planDescription required")
    @Size(min = 2,message = "plan description should be more than 2 letters")
    private String planDescription;
    @NotNull(message = "startDate required")
    private Date startDate;
    @NotNull(message = "endDate required")
    private Date endDate;
    @NotNull(message = "user_id required")
    private Integer user_id;

    List<TouristyPlaces_TripPlanPostDTO> touristyPlacesTripPlanPostDTOS;

}
