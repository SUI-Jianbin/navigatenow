package com.navigatenow.navigatenowproject.Service.Impl;

import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs.TouristyPlacesGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs.TouristyPlacesPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs.TouristyPlacesUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.User_UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.Entity.*;
import com.navigatenow.navigatenowproject.Model.Mapper.TouristyPlacesMapper;
import com.navigatenow.navigatenowproject.Repository.TouristyPlacesRepo;
import com.navigatenow.navigatenowproject.Service.TouristyPlacesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TouristyPlacesServicesImpl implements TouristyPlacesServices {
    private final TouristyPlacesRepo touristyPlacesRepo;
    private final TouristyPlacesMapper touristyPlacesMapper;

    @Override
    public TouristyPlacesPostDTO addTouristyPlaces(TouristyPlacesPostDTO touristyPlacesPostDTO) {
        TouristyPlacesEntity entity = this.touristyPlacesMapper.ToEntity(touristyPlacesPostDTO);
        UserIntrestEntity userIntrestEntity = new UserIntrestEntity();
        userIntrestEntity.setUserintrestId(touristyPlacesPostDTO.getUserintrest_id());
        entity.setUserIntrestEntity(userIntrestEntity);
        this.touristyPlacesRepo.save(entity);
        return touristyPlacesPostDTO;
    }

    @Override
    public TouristyPlacesGetDTO getTouristyPlacesById(Integer id) {
        Optional<TouristyPlacesEntity> entity = this.touristyPlacesRepo.getTouristyPlacesEntityByTouristyPlacesId(id);
        if (entity.isPresent()){
            return this.touristyPlacesMapper.ToTouristyPlacesGetDTO(entity.get());
        }else {
            return null;
        }
    }

    @Override
    public List<TouristyPlacesGetDTO> getAllTouristyPlaces() {
        List<TouristyPlacesEntity> touristyPlacesEntities = this.touristyPlacesRepo.findAll();
        if(touristyPlacesEntities.isEmpty()){
            return null;
        }
        else {
            List<TouristyPlacesGetDTO> touristyPlacesGetDTOS = new ArrayList<>();
            touristyPlacesEntities.forEach(entity -> {
                touristyPlacesGetDTOS.add(this.touristyPlacesMapper.ToTouristyPlacesGetDTO(entity));
            });
            return touristyPlacesGetDTOS;
        }
    }

    @Override
    public String deleteTouristyPlaces(Integer id) {
        Optional<TouristyPlacesEntity> touristyPlaces = this.touristyPlacesRepo.findByTouristyPlacesIdAndDeletedAtIsNull(id);
        if (touristyPlaces.isPresent()) {
            touristyPlaces.get().setDeletedAt(LocalDateTime.now());
            this.touristyPlacesRepo.save(touristyPlaces.get());
            return "Touristy Places has deleted Successfully";
        } else {
            return "user not exist";
        }
    }

    @Override
    public TouristyPlacesUpdateDTO updateTouristyPlaces(TouristyPlacesUpdateDTO touristyPlacesUpdateDTO) {
        TouristyPlacesEntity entity = this.touristyPlacesMapper.ToEntity(touristyPlacesUpdateDTO);
        this.touristyPlacesRepo.updateTouristyPlacesNativeQuery(entity.getTouristyPlacesId(), entity.getPlaceLocation()
                ,entity.getPlaceOpeningDays(), entity.getPlaceOpeningTimes(),
                entity.getPlaceClosingTime(), entity.getPlaceRate(), entity.getPlacePicture(),
                entity.getUserIntrestEntity().getUserintrestId(), entity.getUpdatedAt());
        return touristyPlacesUpdateDTO;
    }

    @Override
    public List<TouristyPlacesGetDTO> getTouristyPlacesByUserIntrestId(Integer id) {

        List<TouristyPlacesEntity> touristyPlacesEntities = touristyPlacesRepo.getTouristyPlacesEntityByUserIntrestEntity_UserintrestId(id);
        if (touristyPlacesEntities.isEmpty()) {
            return null;
        } else {
            List<TouristyPlacesGetDTO> touristyPlacesGetDTOS = new ArrayList<>();
            touristyPlacesEntities.forEach(entity -> {
                touristyPlacesGetDTOS.add(this.touristyPlacesMapper.ToTouristyPlacesGetDTO(entity));
            });
            //log.info("Getting all products " + productDTOS);
            return touristyPlacesGetDTOS;
        }


    }

    @Override
    public List<TouristyPlacesGetDTO> getTouristyPlacesByUserId(Integer userId) {
        List<TouristyPlacesEntity> touristyPlacesEntities = touristyPlacesRepo.findTouristyPlacesByUserId(userId);
        if (touristyPlacesEntities.isEmpty()) {
            return null;
        } else {
            List<TouristyPlacesGetDTO> touristyPlacesGetDTOS = new ArrayList<>();
            touristyPlacesEntities.forEach(entity -> {
                touristyPlacesGetDTOS.add(this.touristyPlacesMapper.ToTouristyPlacesGetDTO(entity));
            });
            //log.info("Getting all products " + productDTOS);
            return touristyPlacesGetDTOS;
        }
    }
}
