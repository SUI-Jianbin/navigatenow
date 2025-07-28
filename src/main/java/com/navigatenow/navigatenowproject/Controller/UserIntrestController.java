package com.navigatenow.navigatenowproject.Controller;

import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestUpdateDTO;
import com.navigatenow.navigatenowproject.Service.Impl.UserIntrestServicesImpl;
import com.navigatenow.navigatenowproject.Service.Impl.UserServicesImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/userintrests")
@CrossOrigin
@RequiredArgsConstructor
public class UserIntrestController {

    public final UserIntrestServicesImpl userIntrestServices;

    // adding new interest
    @PostMapping(path = "/userintrest/add-userintrest")
     public UserIntrestPostDTO addUserInterest(@RequestBody @Valid UserIntrestPostDTO userIntrestPostDTO){
        return this.userIntrestServices.addUserIntrest(userIntrestPostDTO);
    }

    // get interest by userintrestId
    @GetMapping(path = "/userintrest/get-userintrestbyid/{id}")
    public UserIntrestGetDTO getUserInterestByUserInterestId(@PathVariable Integer id){
        return this.userIntrestServices.getUserIntrestById(id);
    }

    // get list of interests
    @GetMapping(path = "/userintrest/get-alluserintrests")
    public List<UserIntrestGetDTO> getAllUserInterests(){
        return this.userIntrestServices.getAllUserIntrests();
    }

    // update interest object By UserInterestId
    @PutMapping(path = "/userintrest/update-userintrest")
    public UserIntrestUpdateDTO updateUserInterestByUserInterestId(@RequestBody @Valid UserIntrestUpdateDTO userIntrestUpdateDTO){
        return this.userIntrestServices.updateUserIntrest(userIntrestUpdateDTO);
    }

    // delete Interest object By UserInterestId
    @DeleteMapping(path = "/userintrest/delete-userintrestbyid/{id}")
    public String deleteUserInterestByUserInterestId(@PathVariable Integer id) {
        return this.userIntrestServices.deleteUserIntrest(id);
    }

}
