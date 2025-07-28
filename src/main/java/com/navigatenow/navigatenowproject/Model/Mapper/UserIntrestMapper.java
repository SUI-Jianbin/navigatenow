package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.UserIntrestEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserIntrestMapper {

    // Convert UserPostDTO to UserEntity
    UserIntrestEntity ToEntity(UserIntrestPostDTO userIntrestPostDTO);
    UserIntrestEntity ToEntity(UserIntrestUpdateDTO userIntrestUpdateDTO);

    UserIntrestPostDTO ToUserIntrestPostDTO(UserIntrestEntity userIntrestEntity);
    UserIntrestGetDTO ToUserIntrestGetDTO(UserIntrestEntity userIntrestEntity);
    UserIntrestUpdateDTO ToUserIntrestUpdateDTO(UserIntrestEntity userIntrestEntity);

}
