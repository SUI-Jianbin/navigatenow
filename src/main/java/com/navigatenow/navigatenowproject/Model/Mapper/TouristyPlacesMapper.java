package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs.TouristyPlacesGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs.TouristyPlacesPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs.TouristyPlacesUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.ContactUsEntity;
import com.navigatenow.navigatenowproject.Model.Entity.TouristyPlacesEntity;
import com.navigatenow.navigatenowproject.Model.Entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TouristyPlacesMapper {
    // Convert TouristyPlacesPostDTO to TouristyPlacesEntity
    TouristyPlacesEntity ToEntity(TouristyPlacesPostDTO touristyPlacesPostDTO);
    TouristyPlacesEntity ToEntity(TouristyPlacesUpdateDTO touristyPlacesUpdateDTO);

    // Convert TouristyPlacesEntity to TouristyPlacesPostDTO
    TouristyPlacesPostDTO ToTouristyPlacesPostDTO(TouristyPlacesEntity touristyPlacesEntity);
    // Convert TouristyPlacesEntity to TouristyPlacesGetDTO
    TouristyPlacesGetDTO ToTouristyPlacesGetDTO(TouristyPlacesEntity touristyPlacesEntity);
    TouristyPlacesUpdateDTO ToTouristyPlacesUpdateDTO(TouristyPlacesEntity touristyPlacesEntity);
}
