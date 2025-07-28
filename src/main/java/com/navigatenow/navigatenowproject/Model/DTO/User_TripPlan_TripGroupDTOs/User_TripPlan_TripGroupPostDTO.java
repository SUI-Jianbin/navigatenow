package com.navigatenow.navigatenowproject.Model.DTO.User_TripPlan_TripGroupDTOs;

import jakarta.validation.constraints.NotNull;
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
public class User_TripPlan_TripGroupPostDTO {
    private Integer user_TripPlan_TripGroupId;
    @NotNull(message = "userId required")
    private Integer userId;
    @NotNull(message = "tripPlanId required")
    private Integer tripPlanId;
    private Integer tripGroupId;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
