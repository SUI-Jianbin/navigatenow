package com.navigatenow.navigatenowproject.Controller;

import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.*;
import com.navigatenow.navigatenowproject.Model.Entity.UserEntity;
import com.navigatenow.navigatenowproject.Service.FeedBackServices;
import com.navigatenow.navigatenowproject.Service.Impl.UserServicesImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    public final UserServicesImpl userServices;

    @PostMapping(path = "/user/add-user")
    public UserPostDTO addUser(@RequestBody @Valid UserPostDTO userPostDTO) {
        return this.userServices.addUser(userPostDTO);
    }

    @GetMapping(path = "/user/get-userbyid/{id}")
    public UserGetDTO getUserById(@PathVariable Integer id) {
        return this.userServices.getUserById(id);
    }

    @GetMapping(path = "/user/get-userbyusername/{username}")
    public UserGetDTO getUserById(@PathVariable String username) {
        return this.userServices.getUserByUsername(username);
    }

    // Add new user
    @GetMapping(path = "/user/get-allusers")
    public List<UserGetDTO> getAllUsers() {
        return this.userServices.getAllUsers();
    }


    // updating the whole user information
    @PutMapping(path = "/user/update-user")
    UserUpdateDTO updateUser(@RequestBody @Valid UserUpdateDTO userUpdateDTO) {
        return this.userServices.updateUser(userUpdateDTO);
    }

    // updating the whole user information without password
    @PutMapping(path = "/user/update-user-withoutpassword")
    UserUpdateWithoutPasswordDTO updateUserWithoutPassword(@RequestBody @Valid UserUpdateWithoutPasswordDTO userUpdateWithoutPasswordDTO) {
        return this.userServices.updateUserWithoutPassword(userUpdateWithoutPasswordDTO);
    }

    // updating user password
    @PutMapping(path = "/user/update-userpassword")
    String updateUserPassword(@RequestBody @Valid UserPasswordUpdateDTO userPasswordUpdateDTO) {
        return this.userServices.updateUserPassword(userPasswordUpdateDTO);

    }

    // user login
    @GetMapping(path = "/user/userlogin")
    public UserLoginDTO loginUser(@RequestParam String email, @RequestParam String password) {
        return this.userServices.UserLogin(email, password);


    }



}
