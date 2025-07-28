package com.navigatenow.navigatenowproject.Controller;

import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs.TouristyPlacesGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs.TouristyPlacesPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs.TouristyPlacesUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanUpdateDTO;
import com.navigatenow.navigatenowproject.Service.Impl.TouristyPlacesServicesImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/touristyplacess")
@CrossOrigin
@RequiredArgsConstructor
public class TouristyPlacesController {
    public final TouristyPlacesServicesImpl touristyPlacesServices;

    @PostMapping(path = "/touristyplaces/add-touristyplaces")
    public TouristyPlacesPostDTO addTouristyPlaces(@RequestBody @Valid TouristyPlacesPostDTO touristyPlacesPostDTO){
        return this.touristyPlacesServices.addTouristyPlaces(touristyPlacesPostDTO);
    }

    @GetMapping(path = "/touristyplaces/get-touristyplacesbyid/{id}")
    public TouristyPlacesGetDTO getTouristyPlacesById(@PathVariable Integer id){
        return this.touristyPlacesServices.getTouristyPlacesById(id);
    }

    @GetMapping(path = "/touristyplaces/get-alltouristyplaces")
    public List<TouristyPlacesGetDTO> getAllTouristyPlaces(){
        return this.touristyPlacesServices.getAllTouristyPlaces();
    }

    @PutMapping(path = "/touristyplaces/update-touristyplaces")
    public TouristyPlacesUpdateDTO updateTouristyPlaces(@RequestBody @Valid TouristyPlacesUpdateDTO touristyPlacesUpdateDTO){
        return this.touristyPlacesServices.updateTouristyPlaces(touristyPlacesUpdateDTO);
    }

    @DeleteMapping(path = "/touristyplaces/delete-touristyplacesbyid/{id}")
    public String deleteTouristyPlaces(@PathVariable Integer id) {
        return this.touristyPlacesServices.deleteTouristyPlaces(id);
    }

    @GetMapping(path = "/touristyplaces/get-touristyplacesbyuserintrestid/{id}")
    public List<TouristyPlacesGetDTO> getTouristyPlacesByUserIntrestId(@PathVariable Integer id){
        return this.touristyPlacesServices.getTouristyPlacesByUserIntrestId(id);
    }

    @GetMapping(path = "/touristyplaces/get-touristyplacesbyuserid/{id}")
    public List<TouristyPlacesGetDTO> getTouristyPlacesByUserId(@PathVariable Integer id){
        return this.touristyPlacesServices.getTouristyPlacesByUserId(id);
    }

}
