package com.navigatenow.navigatenowproject.Service;

import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs.TouristyPlacesGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs.TouristyPlacesPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs.TouristyPlacesUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TouristyPlacesServices {
    TouristyPlacesPostDTO addTouristyPlaces(TouristyPlacesPostDTO TouristyPlacesPostDTO);
    TouristyPlacesGetDTO getTouristyPlacesById(Integer id);
    List<TouristyPlacesGetDTO> getAllTouristyPlaces();
    String deleteTouristyPlaces(Integer id);
    TouristyPlacesUpdateDTO updateTouristyPlaces(TouristyPlacesUpdateDTO touristyPlacesUpdateDTO);
    List<TouristyPlacesGetDTO> getTouristyPlacesByUserIntrestId(Integer userintrestid);
    List<TouristyPlacesGetDTO> getTouristyPlacesByUserId(Integer userId);
}
