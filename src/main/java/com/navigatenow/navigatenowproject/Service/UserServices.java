package com.navigatenow.navigatenowproject.Service;

import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.*;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public interface UserServices {

    UserPostDTO addUser(UserPostDTO userPostDTO);
    UserGetDTO getUserById(Integer id);
    UserGetDTO getUserByUsername(String username);
    List<UserGetDTO> getAllUsers();
    String deleteUser(Integer id);
    UserUpdateDTO updateUser(UserUpdateDTO userUpdateDTO);
    UserUpdateWithoutPasswordDTO updateUserWithoutPassword(UserUpdateWithoutPasswordDTO userUpdateWithoutPasswordDTO);
    String updateUserPassword(UserPasswordUpdateDTO userPasswordUpdateDTO);
    UserLoginDTO UserLogin(String email, String password);

}
