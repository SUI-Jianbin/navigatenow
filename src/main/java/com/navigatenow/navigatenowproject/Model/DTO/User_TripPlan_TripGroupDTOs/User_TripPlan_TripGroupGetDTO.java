package com.navigatenow.navigatenowproject.Model.DTO.User_TripPlan_TripGroupDTOs;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User_TripPlan_TripGroupGetDTO {

    private Integer user_TripPlan_TripGroupId;
    private Integer userId;
    private Integer tripPlanId;
    private Integer tripGroupId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
