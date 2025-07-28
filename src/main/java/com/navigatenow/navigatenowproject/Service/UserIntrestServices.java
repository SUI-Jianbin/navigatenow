package com.navigatenow.navigatenowproject.Service;

import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserIntrestServices {

    UserIntrestPostDTO addUserIntrest(UserIntrestPostDTO userIntrestPostDTO);
    UserIntrestGetDTO getUserIntrestById(Integer id);
    List<UserIntrestGetDTO> getAllUserIntrests();
    String deleteUserIntrest(Integer id);
    UserIntrestUpdateDTO updateUserIntrest(UserIntrestUpdateDTO userIntrestUpdateDTO);
}
