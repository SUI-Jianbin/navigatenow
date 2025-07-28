package com.navigatenow.navigatenowproject.Model.DTO.User_TripPlan_TripGroupDTOs;


import com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs.TripGroupGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserGetDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User_TripPlans_TripGroupsGetDTO {

    private Integer user_TripPlan_TripGroupId;
    private Integer userId;
    private Integer tripPlanId;
    private Integer tripGroupId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    UserGetDTO userGetDTO;
    TripPlanGetDTO tripPlanGetDTOS;
    TripGroupGetDTO tripGroupGetDTOS;
}
