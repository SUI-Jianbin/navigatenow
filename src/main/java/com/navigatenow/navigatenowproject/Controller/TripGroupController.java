package com.navigatenow.navigatenowproject.Controller;

import com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs.TripGroupGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs.TripGroupPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs.TripGroupUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanUpdateDTO;
import com.navigatenow.navigatenowproject.Service.Impl.TripGroupServicesImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tripgroups")
@CrossOrigin
@RequiredArgsConstructor
public class TripGroupController {
    public final TripGroupServicesImpl tripGroupServices;

    @PostMapping(path = "/tripgroup/add-tripgroup")
    public TripGroupPostDTO addTripGroup(@RequestBody @Valid TripGroupPostDTO tripGroupPostDTO){
        return this.tripGroupServices.addTripGroup(tripGroupPostDTO);
    }

    @GetMapping(path = "/tripgroup/get-tripgroupbyid/{id}")
    public TripGroupGetDTO getTripGroupById(@PathVariable Integer id){
        return this.tripGroupServices.getTripGroupById(id);
    }


    @GetMapping(path = "/tripgroup/get-tripgroupbytripplanid/{id}")
    public TripGroupGetDTO getTripGroupByTripPlanId(@PathVariable Integer id){
        return this.tripGroupServices.getTripGroupByTripPlanId(id);
    }

    @GetMapping(path = "/tripgroup/get-alltripgroup")
    public List<TripGroupGetDTO> getAllTripGroup(){
        return this.tripGroupServices.getAllTripGroup();
    }
    @GetMapping(path = "/tripgroup/get-alltripgroupsbyname/{groupName}")
    public List<TripGroupGetDTO> getAllTripGroup(@PathVariable String groupName){
        return this.tripGroupServices.getAllTripGroupsByGroupName(groupName);
    }

    // get others users groups
    @GetMapping(path = "/tripgroup/get-allothersgroupsbyuserid/{userid}")
    public List<TripGroupGetDTO> getOtherUsersGroupsByUserId(@PathVariable Integer userid){
        return this.tripGroupServices.getOtherUsersGroupsByUserId(userid);
    }
    @GetMapping(path = "/tripgroup/checkif-userhas-createdgroups-byuserid/{userid}")
    public Boolean checkIfUserHasCreatedGroupsByUserId(@PathVariable Integer userid){
        return this.tripGroupServices.checkIfUserHasCreatedGroupsByUserId(userid);
    }

    @PutMapping(path = "/tripgroup/update-tripgroup")
    public TripGroupUpdateDTO updateTripGroup(@RequestBody @Valid TripGroupUpdateDTO tripGroupUpdateDTO){
        return this.tripGroupServices.updateTripGroup(tripGroupUpdateDTO);
    }

    @DeleteMapping(path = "/tripgroup/delete-tripgroupbyid/{id}")
    public String deleteTripGroup(@PathVariable Integer id) {
        return this.tripGroupServices.deleteTripGroup(id);
    }
}
