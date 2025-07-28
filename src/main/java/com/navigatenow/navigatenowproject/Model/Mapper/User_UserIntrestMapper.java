package com.navigatenow.navigatenowproject.Model.Mapper;


import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.DeleteUser_UserIntrestDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.User_UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.User_UserIntrestPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.User_UserIntrestUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.User_UserIntrestEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface User_UserIntrestMapper {


    // Convert UserPostDTO to UserEntity
    User_UserIntrestEntity ToEntity(User_UserIntrestPostDTO user_userIntrestPostDTO);
    User_UserIntrestEntity ToEntity(User_UserIntrestUpdateDTO user_userIntrestUpdateDTO);
    User_UserIntrestEntity ToEntity(DeleteUser_UserIntrestDTO deleteUserUserIntrestDTO);

    User_UserIntrestPostDTO ToUser_UserIntrestPostDTO(User_UserIntrestEntity user_userIntrestEntity);
    User_UserIntrestGetDTO ToUser_UserIntrestGetDTO(User_UserIntrestEntity user_userIntrestEntity);
    User_UserIntrestUpdateDTO ToUser_UserIntrestUpdateDTO(User_UserIntrestEntity user_userIntrestEntity);
    DeleteUser_UserIntrestDTO ToDeleteUser_UserIntrestDTO(User_UserIntrestEntity user_userIntrestEntity);
}
