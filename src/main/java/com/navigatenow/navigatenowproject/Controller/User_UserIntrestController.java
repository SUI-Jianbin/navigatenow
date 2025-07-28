package com.navigatenow.navigatenowproject.Controller;

import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.DeleteUser_UserIntrestDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.User_UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.User_UserIntrestPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.User_UserIntrestUpdateDTO;
import com.navigatenow.navigatenowproject.Service.Impl.User_UserIntrestServicesImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user-userintrests")
@CrossOrigin
@RequiredArgsConstructor
public class User_UserIntrestController {

    public final User_UserIntrestServicesImpl user_userIntrestServices;


    // Adding interests to a user
    @PostMapping(path = "/user-userintrest/add-user-userintrest")
    public List<User_UserIntrestPostDTO> addUser_UserIntrest(@RequestBody @Valid List<User_UserIntrestPostDTO> user_userIntrestPostDTO){
      return this.user_userIntrestServices.addUser_UserIntrest(user_userIntrestPostDTO);
    }

    // get All user's interests By UserId
    @GetMapping(path = "/user-userintrest/get-user-userintrestbyid/{id}")
    public List<User_UserIntrestGetDTO> getUser_UserIntrestByUserId(@PathVariable Integer id){
        return this.user_userIntrestServices.getUser_UserIntrestEntitiesByUserId(id);
    }

    // get All users interests
    @GetMapping(path = "/user-userintrest/get-alluser-userintrests")
    public  List<User_UserIntrestGetDTO> getAllUser_UserIntrests(){
        return this.user_userIntrestServices.getAllUser_UserIntrests();
    }

    // update user's interests By UserId And UserInterestId
    @PutMapping(path = "/user-userintrest/update-user-userintrest")
    public List<User_UserIntrestUpdateDTO> updateUser_UserInterestByUserIdAndUserInterestId(@RequestBody @Valid List<User_UserIntrestUpdateDTO> user_userIntrestUpdateDTO){
        return this.user_userIntrestServices.updateUser_UserIntrest(user_userIntrestUpdateDTO);
    }

    // delete user's interests By UserId And UserInterestId
    @DeleteMapping(path = "/user-userintrest/delete-user-userintrestbyid")
    public String deleteUser_UserInterest(@RequestBody @Valid List<DeleteUser_UserIntrestDTO> deleteUserUserIntrestDTOS) {
        return this.user_userIntrestServices.deleteUser_UserIntrest(deleteUserUserIntrestDTOS);
    }

}
