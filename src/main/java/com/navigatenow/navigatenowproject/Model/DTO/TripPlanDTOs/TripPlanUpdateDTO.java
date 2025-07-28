package com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripPlanUpdateDTO {
    private Integer tripPlanId;
    @NotNull(message = "plan name required")
    @Size(min = 2,message = "plan name should be more than 2 letters")
    private String planName;
    @NotNull(message = "planDescription required")
    @Size(min = 2,message = "plan description should be more than 2 letters")
    private String planDescription;
    @NotNull(message = "startDate required")
    private Date startDate;
    @NotNull(message = "endDate required")
    private Date endDate;
    private LocalDateTime updatedAt = LocalDateTime.now();
}
