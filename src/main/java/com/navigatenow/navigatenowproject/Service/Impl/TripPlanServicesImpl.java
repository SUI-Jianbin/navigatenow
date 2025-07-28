package com.navigatenow.navigatenowproject.Service.Impl;

import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlaces_TripPlanDTOs.TouristyPlaces_TripPlanGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlaces_TripPlanDTOs.TouristyPlaces_TripPlanPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.User_UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.Entity.TripPlanEntity;
import com.navigatenow.navigatenowproject.Model.Entity.UserEntity;
import com.navigatenow.navigatenowproject.Model.Entity.UserIntrestEntity;
import com.navigatenow.navigatenowproject.Model.Entity.User_UserIntrestEntity;
import com.navigatenow.navigatenowproject.Model.Mapper.TripPlanMapper;
import com.navigatenow.navigatenowproject.Model.Mapper.UserIntrestMapper;
import com.navigatenow.navigatenowproject.Repository.TripPlanRepo;
import com.navigatenow.navigatenowproject.Repository.UserIntrestRepo;
import com.navigatenow.navigatenowproject.Service.TripPlanServices;
import com.navigatenow.navigatenowproject.Service.User_UserIntrestServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TripPlanServicesImpl implements TripPlanServices {

    private final TripPlanRepo tripPlanRepo;
    private final TripPlanMapper tripPlanMapper;
    private final User_UserIntrestServicesImpl user_userIntrestServices;
    private final TouristyPlaces_TripPlanServicesImpl touristyPlacesTripPlanServices;
    @Override
    public TripPlanPostDTO addTripPlan(TripPlanPostDTO tripPlanPostDTO) {
        TripPlanEntity entity = this.tripPlanMapper.ToEntity(tripPlanPostDTO);
        UserEntity user = new UserEntity();
        user.setUserId(tripPlanPostDTO.getUser_id());
        entity.setUserEntity(user);
        this.tripPlanRepo.save(entity);
        TripPlanGetDTO tripPlanGetDTO = this.getTripPlanById(entity.getTripPlanId());

        if(!tripPlanPostDTO.getTouristyPlacesTripPlanPostDTOS().isEmpty()){
            for(int i = 0; i< tripPlanPostDTO.getTouristyPlacesTripPlanPostDTOS().size(); i++){
                tripPlanPostDTO.getTouristyPlacesTripPlanPostDTOS().get(i).setTripPlanId(tripPlanGetDTO.getTripPlanId());
                this.touristyPlacesTripPlanServices.addTouristyPlaces_TripPlan(tripPlanPostDTO.getTouristyPlacesTripPlanPostDTOS().get(i));
            }
        }
        else {
            return null;
        }


        return tripPlanPostDTO;
    }

    @Override
    public TripPlanGetDTO getTripPlanById(Integer id) {
        Optional<TripPlanEntity> entity = this.tripPlanRepo.getTripPlanEntityByTripPlanId(id);
        if (entity.isPresent()){
            return this.tripPlanMapper.ToTripPlanGetDTO(entity.get());
        }else {
            return null;
        }
    }

    @Override
    public List<TripPlanGetDTO> getTripPlanEntitiesByUserId(Integer userid) {
        List<TripPlanEntity> tripPlanEntities = this.tripPlanRepo.getTripPlanEntitiesByUserId(userid);
        if (tripPlanEntities.isEmpty()) {
            return null;
        } else {
            List<TripPlanGetDTO> tripPlanGetDTOS = new ArrayList<>();
            tripPlanEntities.forEach(entity -> {
                tripPlanGetDTOS.add(this.tripPlanMapper.ToTripPlanGetDTO(entity));
            });
            return tripPlanGetDTOS;
        }
    }

    @Override
    public List<TripPlanGetDTO> getAllTripPlans() {
        List<TripPlanEntity> tripPlanEntities = this.tripPlanRepo.findAll();
        if (tripPlanEntities.isEmpty()) {
            return null;
        } else {
            List<TripPlanGetDTO> tripPlanGetDTOS = new ArrayList<>();
            tripPlanEntities.forEach(entity -> {
                tripPlanGetDTOS.add(this.tripPlanMapper.ToTripPlanGetDTO(entity));
            });
            return tripPlanGetDTOS;
        }
    }

    @Override
    public String deleteTripPlan(Integer id) {
        Optional<TripPlanEntity> tripPlanEntity = this.tripPlanRepo.findByTripPlanIdAndDeletedAtIsNull(id);
        if (tripPlanEntity.isPresent()) {
            tripPlanEntity.get().setDeletedAt(LocalDateTime.now());
            this.tripPlanRepo.save(tripPlanEntity.get());
            return "tirp plan has deleted Successfully";
        } else {
            return "user not exist";
        }    }

    @Override
    public TripPlanUpdateDTO updateTripPlan(TripPlanUpdateDTO tripPlanUpdateDTO) {
        TripPlanEntity entity = this.tripPlanMapper.ToEntity(tripPlanUpdateDTO);
        this.tripPlanRepo.updateTripPlanNativeQuery(entity.getTripPlanId(),entity.getPlanName(),entity.getPlanDescription(),entity.getStartDate(),entity.getEndDate(),entity.getUpdatedAt());
        return tripPlanUpdateDTO;
    }
}
