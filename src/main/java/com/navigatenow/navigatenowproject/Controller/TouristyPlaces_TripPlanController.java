package com.navigatenow.navigatenowproject.Controller;

import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs.TouristyPlacesGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlaces_TripPlanDTOs.TouristyPlaces_TripPlanGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlaces_TripPlanDTOs.TouristyPlaces_TripPlanPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlaces_TripPlanDTOs.TouristyPlaces_TripPlanUpdateDTO;
import com.navigatenow.navigatenowproject.Service.Impl.TouristyPlaces_TripPlanServicesImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/touristyplaces-tripplans")
@CrossOrigin
@RequiredArgsConstructor
public class TouristyPlaces_TripPlanController {
    public final TouristyPlaces_TripPlanServicesImpl touristyPlaces_tripPlanServices;

    @PostMapping(path = "/touristyplaces-tripplan/add-touristyplaces-tripplan")
    public TouristyPlaces_TripPlanPostDTO addTouristyPlaces_TripPlan(@RequestBody @Valid TouristyPlaces_TripPlanPostDTO touristyPlaces_tripPlanPostDTO){
       return this.touristyPlaces_tripPlanServices.addTouristyPlaces_TripPlan(touristyPlaces_tripPlanPostDTO);
    }

    @GetMapping(path = "/touristyplaces-tripplan/get-touristyplaces-tripplanbyid/{id}")
    public TouristyPlaces_TripPlanGetDTO getTouristyPlaces_TripPlanById(@PathVariable Integer id){
        return this.touristyPlaces_tripPlanServices.getTouristyPlaces_TripPlanById(id);
    }

    @GetMapping(path = "/touristyplaces-tripplan/get-touristyplaces-tripplanbytripplanid/{tripplanid}")
    public List<TouristyPlacesGetDTO> getAllTouristyPlacesByTripPlanId(@PathVariable Integer tripplanid){
        return this.touristyPlaces_tripPlanServices.getAllTouristyPlacesByTripPlanId(tripplanid);
    }

    @GetMapping(path = "/touristyplaces-tripplan/get-alltouristyplaces-tripplans")
    public List<TouristyPlaces_TripPlanGetDTO> getAllTouristyPlaces_TripPlans(){
        return this.touristyPlaces_tripPlanServices.getAllTouristyPlaces_TripPlans();
    }

    @PutMapping(path = "/touristyplaces-tripplan/update-touristyplaces-tripplan")
    public TouristyPlaces_TripPlanUpdateDTO updateTouristyPlaces_TripPlan(@RequestBody @Valid TouristyPlaces_TripPlanUpdateDTO touristyPlaces_tripPlanUpdateDTO){
        return this.touristyPlaces_tripPlanServices.updateTouristyPlaces_TripPlan(touristyPlaces_tripPlanUpdateDTO);
    }

    @DeleteMapping(path = "/touristyplaces-tripplan/delete-touristyplaces-tripplanbyid/{id}")
    public String deleteTouristyPlaces_TripPlan(@PathVariable Integer id) {
        return this.touristyPlaces_tripPlanServices.deleteTouristyPlaces_TripPlan(id);
    }
}
