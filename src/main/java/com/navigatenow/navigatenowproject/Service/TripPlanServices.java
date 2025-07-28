package com.navigatenow.navigatenowproject.Service;

import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TripPlanServices {
    TripPlanPostDTO addTripPlan(TripPlanPostDTO tripPlanPostDTO);
    TripPlanGetDTO getTripPlanById(Integer id);
    List<TripPlanGetDTO> getTripPlanEntitiesByUserId(Integer userid);
    List<TripPlanGetDTO> getAllTripPlans();
    String deleteTripPlan(Integer id);
    TripPlanUpdateDTO updateTripPlan(TripPlanUpdateDTO tripPlanUpdateDTO);
}
