package com.navigatenow.navigatenowproject.Controller;

import com.navigatenow.navigatenowproject.Model.DTO.User_TripPlan_TripGroupDTOs.*;
import com.navigatenow.navigatenowproject.Service.Impl.User_TripPlan_TripGroupServicesImpl;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user-tripplans-tripgroups")
@CrossOrigin
@RequiredArgsConstructor
public class User_TripPlan_TripGroupController {

    public final User_TripPlan_TripGroupServicesImpl userTripPlanTripGroupServices;

    // add trip plan and group id to a user. Basically join group.
    @PostMapping(path = "/user-tripplan-tripgroup/add-user-tripplan-tripgroup")
    public User_TripPlan_TripGroupPostDTO addUser_TripPlan_TripGroup(@RequestBody @Valid User_TripPlan_TripGroupPostDTO user_tripPlanTripGroupEntityPostDTO){
        return this.userTripPlanTripGroupServices.addUser_TripPlan_TripGroup(user_tripPlanTripGroupEntityPostDTO);
    }


    //  get Trip Plans and Trip Groups for a user by UserId
    @GetMapping(path = "/user-tripplan-tripgroup/get-user-tripplan-tripgroupbyid")
    public List<User_TripPlans_TripGroupsGetDTO> getUser_TripPlan_TripGroupByUserId(@RequestParam Integer userid){
        return this.userTripPlanTripGroupServices.getUser_TripPlan_TripGroupByUserId(userid);
    }


    // get All other users joined groups
    @GetMapping(path = "/user-tripplan-tripgroup/get-allotheruser-tripplan-tripgroup/{userid}")
    public List<User_TripPlans_TripGroupsGetDTO> getOtherUsersGroupsByUserId(@PathVariable Integer userid){
        return this.userTripPlanTripGroupServices.getOtherUsersGroupsByUserId(userid);
    }


    // Leave joined group
    @DeleteMapping(path = "/user-tripplan-tripgroup/leaveJoinedGroup/{user_TripPlan_TripGroupId}")
    public String deleteUser_TripPlan_TripGroup(@PathVariable Integer user_TripPlan_TripGroupId) {
        return this.userTripPlanTripGroupServices.leaveJoinedGroupByUserId(user_TripPlan_TripGroupId);
    }
}
