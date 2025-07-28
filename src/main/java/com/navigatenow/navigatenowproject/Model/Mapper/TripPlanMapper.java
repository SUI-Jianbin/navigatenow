package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.TripPlanEntity;
import com.navigatenow.navigatenowproject.Model.Entity.UserIntrestEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TripPlanMapper {
    // Convert UserPostDTO to UserEntity
    TripPlanEntity ToEntity(TripPlanPostDTO tripPlanPostDTO);
    TripPlanEntity ToEntity(TripPlanUpdateDTO tripPlanUpdateDTO);
    TripPlanEntity ToEntity(TripPlanGetDTO tripPlanGetDTO);

    TripPlanPostDTO ToTripPlanPostDTO(TripPlanEntity tripPlanEntity);
    TripPlanGetDTO ToTripPlanGetDTO(TripPlanEntity tripPlanEntity);
    TripPlanUpdateDTO ToTripPlanUpdateDTO(TripPlanEntity tripPlanEntity);
}
