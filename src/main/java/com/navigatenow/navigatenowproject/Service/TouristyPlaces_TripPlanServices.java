package com.navigatenow.navigatenowproject.Service;

import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs.TouristyPlacesGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlaces_TripPlanDTOs.TouristyPlaces_TripPlanGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlaces_TripPlanDTOs.TouristyPlaces_TripPlanPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlaces_TripPlanDTOs.TouristyPlaces_TripPlanUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TouristyPlaces_TripPlanServices {
    TouristyPlaces_TripPlanPostDTO addTouristyPlaces_TripPlan(TouristyPlaces_TripPlanPostDTO touristyPlaces_tripPlanPostDTO);
    TouristyPlaces_TripPlanGetDTO getTouristyPlaces_TripPlanById(Integer id);
    List<TouristyPlaces_TripPlanGetDTO> getAllTouristyPlaces_TripPlans();
    List<TouristyPlacesGetDTO> getAllTouristyPlacesByTripPlanId(Integer tripplanid);
    String deleteTouristyPlaces_TripPlan(Integer id);
    TouristyPlaces_TripPlanUpdateDTO updateTouristyPlaces_TripPlan(TouristyPlaces_TripPlanUpdateDTO touristyPlaces_tripPlanUpdateDTO);

}
