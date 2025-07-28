package com.navigatenow.navigatenowproject.Model.Mapper;


import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.*;
import com.navigatenow.navigatenowproject.Model.Entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Convert UserPostDTO to UserEntity
    UserEntity ToEntity(UserPostDTO userPostDTO);
    UserEntity ToEntity(UserUpdateDTO userUpdateDTO);
    UserEntity ToEntity(UserGetDTO userGetDTO);
    UserEntity ToEntity(UserUpdateWithoutPasswordDTO userUpdateWithoutPasswordDTO);
    UserPostDTO ToUserPostDTO(UserEntity userEntity);
    UserGetDTO ToUserGetDTO(UserEntity userEntity);
    UserUpdateDTO ToUserUpdateDTO(UserEntity userEntity);
    UserUpdateWithoutPasswordDTO ToUserUpdateWithoutPasswordDTODTO(UserEntity userEntity);
    UserLoginDTO ToUserLoginDTO(UserEntity userEntity);
}
