package com.navigatenow.navigatenowproject.Controller;

import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestUpdateDTO;
import com.navigatenow.navigatenowproject.Service.Impl.TripPlanServicesImpl;
import com.navigatenow.navigatenowproject.Service.Impl.UserIntrestServicesImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tripplans")
@CrossOrigin
@RequiredArgsConstructor
public class TripPlanController {

    public final TripPlanServicesImpl tripPlanServices;


    @PostMapping(path = "/tripplan/add-tripplan")
    public TripPlanPostDTO addTripPlan(@RequestBody @Valid TripPlanPostDTO tripPlanPostDTO){
        return this.tripPlanServices.addTripPlan(tripPlanPostDTO);
    }

    @GetMapping(path = "/tripplan/get-tripplanbyid/{id}")
    public TripPlanGetDTO getTripPlanById(@PathVariable Integer id){
        return this.tripPlanServices.getTripPlanById(id);
    }

    // Get All trip plans by user Id
    @GetMapping(path = "/tripplan/get-tripplansbyuserid/{userid}")
    public List<TripPlanGetDTO> getTripPlansByUserId(@PathVariable Integer userid){
        return this.tripPlanServices.getTripPlanEntitiesByUserId(userid);
    }

    @GetMapping(path = "/tripplan/get-alltripplans")
    public List<TripPlanGetDTO> getAllTripPlans(){
        return this.tripPlanServices.getAllTripPlans();
    }

    @PutMapping(path = "/tripplan/update-tripplan")
    public TripPlanUpdateDTO updateTripPlan(@RequestBody @Valid TripPlanUpdateDTO tripPlanUpdateDTO){
        return this.tripPlanServices.updateTripPlan(tripPlanUpdateDTO);
    }

    @DeleteMapping(path = "/tripplan/delete-tripplanbyid/{id}")
    public String deleteTripPlan(@PathVariable Integer id) {
        return this.tripPlanServices.deleteTripPlan(id);
    }

}
