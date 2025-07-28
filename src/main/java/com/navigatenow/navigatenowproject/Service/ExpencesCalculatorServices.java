package com.navigatenow.navigatenowproject.Service;

import com.navigatenow.navigatenowproject.Model.DTO.ExpencesCalculatorDTOs.ExpencesCalculatorGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ExpencesCalculatorDTOs.ExpencesCalculatorPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ExpencesCalculatorDTOs.ExpencesCalculatorUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserUpdateDTO;

import java.util.List;

public interface ExpencesCalculatorServices {
    ExpencesCalculatorPostDTO addExpencesCalculator(ExpencesCalculatorPostDTO ExpencesCalculatorPostDTO);
    ExpencesCalculatorGetDTO getExpencesCalculatorById(Integer id);
    List<ExpencesCalculatorGetDTO> getAllExpencesCalculator();
    String deleteExpencesCalculator(Integer id);
    ExpencesCalculatorUpdateDTO updateExpencesCalculator(ExpencesCalculatorUpdateDTO expencesCalculatorUpdateDTO);
    List<ExpencesCalculatorGetDTO> getExpencesCalculatorsByTouristyPlacesId(Integer touristyPlacesId);
    Boolean checkIfTouristyPlaceHasExpencesByTouristyPlaceId(Integer touristyplaceid);


}
