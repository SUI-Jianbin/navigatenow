package com.navigatenow.navigatenowproject.Service;

import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.DeleteUser_UserIntrestDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.User_UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.User_UserIntrestPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.User_UserIntrestUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface User_UserIntrestServices {


    List<User_UserIntrestPostDTO> addUser_UserIntrest(List<User_UserIntrestPostDTO> user_userIntrestPostDTO);
    List<User_UserIntrestGetDTO> getUser_UserIntrestEntitiesByUserId(Integer id);
    List<User_UserIntrestGetDTO> getAllUser_UserIntrests();
    String deleteUser_UserIntrest(List<DeleteUser_UserIntrestDTO> deleteUserUserIntrestDTOS);
    List<User_UserIntrestUpdateDTO> updateUser_UserIntrest(List<User_UserIntrestUpdateDTO> user_userIntrestUpdateDTO);
}
