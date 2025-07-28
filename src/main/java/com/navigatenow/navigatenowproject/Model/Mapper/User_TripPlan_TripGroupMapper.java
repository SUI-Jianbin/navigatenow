package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.User_TripPlan_TripGroupDTOs.*;
import com.navigatenow.navigatenowproject.Model.Entity.User_TripPlan_TripGroupEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface User_TripPlan_TripGroupMapper {

    // Convert UserPostDTO to UserEntity
    User_TripPlan_TripGroupEntity ToEntity(User_TripPlan_TripGroupPostDTO user_tripPlanTripGroupEntityPostDTO);
    User_TripPlan_TripGroupEntity ToEntity(User_TripPlan_TripGroupUpdateDTO user_tripPlanTripGroupEntityUpdateDTO);
    User_TripPlan_TripGroupEntity ToEntity(User_TripPlanUpdateDTO user_tripPlanUpdateDTO);
    User_TripPlan_TripGroupEntity ToEntity(User_TripGroupUpdateDTO userTripGroupUpdateDTO);
    User_TripPlan_TripGroupEntity ToEntity(User_TripPlans_TripGroupsGetDTO userTripPlansTripGroupsGetDTO);

    User_TripPlan_TripGroupPostDTO ToUser_TripPlanPostDTO(User_TripPlan_TripGroupEntity user_tripPlanEntity);
    User_TripPlan_TripGroupGetDTO ToUser_TripPlanGetDTO(User_TripPlan_TripGroupEntity user_tripPlanEntity);
    User_TripPlan_TripGroupUpdateDTO ToUser_TripPlan_TripGroupUpdateDTO(User_TripPlan_TripGroupEntity user_tripPlanEntity);
    User_TripPlanUpdateDTO ToUser_TripPlanUpdateDTO(User_TripPlan_TripGroupEntity user_tripPlanEntity);
    User_TripGroupUpdateDTO ToUser_TripGroupUpdateDTO(User_TripPlan_TripGroupEntity user_tripPlanEntity);
    User_TripPlans_TripGroupsGetDTO ToUser_TripPlans_TripGroupsGetDTO(User_TripPlan_TripGroupEntity user_tripPlanEntity);
}
