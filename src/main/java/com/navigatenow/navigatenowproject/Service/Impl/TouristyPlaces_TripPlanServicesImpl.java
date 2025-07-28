package com.navigatenow.navigatenowproject.Service.Impl;

import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs.TouristyPlacesGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlaces_TripPlanDTOs.TouristyPlaces_TripPlanGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlaces_TripPlanDTOs.TouristyPlaces_TripPlanPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlaces_TripPlanDTOs.TouristyPlaces_TripPlanUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.TouristyPlaces_TripPlanEntity;
import com.navigatenow.navigatenowproject.Model.Mapper.TouristyPlaces_TripPlanMapper;
import com.navigatenow.navigatenowproject.Repository.TouristyPlaces_TripPlanRepo;
import com.navigatenow.navigatenowproject.Service.TouristyPlaces_TripPlanServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TouristyPlaces_TripPlanServicesImpl implements TouristyPlaces_TripPlanServices {
    private final TouristyPlaces_TripPlanRepo touristyPlaces_tripPlanRepo;
    private final TouristyPlaces_TripPlanMapper touristyPlaces_tripPlanMapper;
    private  final TouristyPlacesServicesImpl touristyPlacesServices;


    @Override
    public TouristyPlaces_TripPlanPostDTO addTouristyPlaces_TripPlan(TouristyPlaces_TripPlanPostDTO touristyPlaces_tripPlanPostDTO) {

        List<TouristyPlaces_TripPlanEntity> touristyPlaces_tripPlanEntities = this.touristyPlaces_tripPlanRepo.findAllTouristyPlaces_TripPlanEntitiesByTouristyPlacesId(touristyPlaces_tripPlanPostDTO.getTouristyPlacesId());
        for (TouristyPlaces_TripPlanEntity touristyPlaces_tripPlanEntity : touristyPlaces_tripPlanEntities) {
            if (touristyPlaces_tripPlanEntity.getTripPlanId().intValue() == touristyPlaces_tripPlanPostDTO.getTripPlanId().intValue()) {
                return null;
            }
        }

        TouristyPlaces_TripPlanEntity entity = this.touristyPlaces_tripPlanMapper.ToEntity(touristyPlaces_tripPlanPostDTO);
        this.touristyPlaces_tripPlanRepo.save(entity);
        return touristyPlaces_tripPlanPostDTO;
    }

    @Override
    public TouristyPlaces_TripPlanGetDTO getTouristyPlaces_TripPlanById(Integer id) {
        Optional<TouristyPlaces_TripPlanEntity> entity = this.touristyPlaces_tripPlanRepo.getTouristyPlaces_TripPlanEntityByTouristyPlaces_TripPlanId(id);
        if (entity.isPresent()){
            return this.touristyPlaces_tripPlanMapper.ToTouristyPlaces_TripPlanGetDTO(entity.get());
        }else {
            return null;
        }
    }

    @Override
    public List<TouristyPlaces_TripPlanGetDTO> getAllTouristyPlaces_TripPlans() {
        List<TouristyPlaces_TripPlanEntity> touristyPlaces_tripPlanEntities = this.touristyPlaces_tripPlanRepo.findAll();
        if (touristyPlaces_tripPlanEntities.isEmpty()) {
            return null;
        } else {
            List<TouristyPlaces_TripPlanGetDTO> touristyPlaces_tripPlanGetDTOS = new ArrayList<>();
            touristyPlaces_tripPlanEntities.forEach(entity -> {
                touristyPlaces_tripPlanGetDTOS.add(this.touristyPlaces_tripPlanMapper.ToTouristyPlaces_TripPlanGetDTO(entity));
            });
            //log.info("Getting all products " + productDTOS);
            return touristyPlaces_tripPlanGetDTOS;
        }
    }

    @Override
    public List<TouristyPlacesGetDTO> getAllTouristyPlacesByTripPlanId(Integer tripplanid) {
        List<TouristyPlaces_TripPlanEntity> touristyPlaces_tripPlanEntities = this.touristyPlaces_tripPlanRepo.getAllTouristyPlacesByTripPlanId(tripplanid);


        if (touristyPlaces_tripPlanEntities.isEmpty()) {
            return null;
        } else {
            List<TouristyPlacesGetDTO> touristyPlacesGetDTOS = new ArrayList<>();
            for(int i = 0; i < touristyPlaces_tripPlanEntities.size(); i++){

                touristyPlacesGetDTOS.add(this.touristyPlacesServices.getTouristyPlacesById(touristyPlaces_tripPlanEntities.get(i).getTouristyPlacesId()));
            }

            return touristyPlacesGetDTOS;
        }
    }

    @Override
    public String deleteTouristyPlaces_TripPlan(Integer id) {
        Optional<TouristyPlaces_TripPlanEntity> touristyPlaces_tripPlanEntity = this.touristyPlaces_tripPlanRepo.findByTouristyPlaces_TripPlanIdAndDeletedAtIsNull(id);
        if (touristyPlaces_tripPlanEntity.isPresent()) {
            touristyPlaces_tripPlanEntity.get().setDeletedAt(LocalDateTime.now());
            this.touristyPlaces_tripPlanRepo.save(touristyPlaces_tripPlanEntity.get());
            return "touristyPlaces tripPlan has deleted Successfully";
        } else {
            return "touristyPlaces tripPlan not exist";
        }
    }

    @Override
    public TouristyPlaces_TripPlanUpdateDTO updateTouristyPlaces_TripPlan(TouristyPlaces_TripPlanUpdateDTO touristyPlaces_tripPlanUpdateDTO) {
        TouristyPlaces_TripPlanEntity entity = this.touristyPlaces_tripPlanMapper.ToEntity(touristyPlaces_tripPlanUpdateDTO);
        this.touristyPlaces_tripPlanRepo.updateTouristyPlaces_TripPlanNativeQuery(entity.getTouristyPlaces_tripPlanId(),entity.getTouristyPlacesId(),entity.getTripPlanId(),entity.getUpdatedAt());
        return touristyPlaces_tripPlanUpdateDTO;
    }
}
