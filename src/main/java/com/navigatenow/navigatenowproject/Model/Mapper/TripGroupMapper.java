package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs.TripGroupGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs.TripGroupPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs.TripGroupUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.ContactUsEntity;
import com.navigatenow.navigatenowproject.Model.Entity.TripGroupEntity;
import com.navigatenow.navigatenowproject.Model.Entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TripGroupMapper {
    // Convert TripGroupPostDTO to TripGroupEntity
    TripGroupEntity ToEntity(TripGroupPostDTO tripGroupPostDTO);
    TripGroupEntity ToEntity(TripGroupUpdateDTO tripGroupUpdateDTO);
    TripGroupEntity ToEntity(TripGroupGetDTO tripGroupGetDTO);

    // Convert TripGroupEntity to TripGroupPostDTO
    TripGroupPostDTO ToTripGroupPostDTO(TripGroupEntity tripGroupEntity);
    // Convert TripGroupEntity to TripGroupPostDTO
    TripGroupGetDTO ToTripGroupGetDTO(TripGroupEntity tripGroupEntity);
    TripGroupUpdateDTO ToTripGroupUpdateDTO(TripGroupEntity tripGroupEntity);
}
