package com.navigatenow.navigatenowproject.Service.Impl;

import com.navigatenow.navigatenowproject.Model.DTO.ExpencesCalculatorDTOs.ExpencesCalculatorGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ExpencesCalculatorDTOs.ExpencesCalculatorPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ExpencesCalculatorDTOs.ExpencesCalculatorUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.*;
import com.navigatenow.navigatenowproject.Model.Mapper.ExpencesCalculatorMapper;
import com.navigatenow.navigatenowproject.Repository.ExpencesCalculatorRepo;
import com.navigatenow.navigatenowproject.Service.ExpencesCalculatorServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpencesCalculatorServicesImpl implements ExpencesCalculatorServices {
    private final ExpencesCalculatorRepo expencesCalculatorRepo;
    private final ExpencesCalculatorMapper expencesCalculatorMapper;


    @Override
    public ExpencesCalculatorPostDTO addExpencesCalculator(ExpencesCalculatorPostDTO ExpencesCalculatorPostDTO) {
//        ExpencesCalculatorEntity entity = this.expencesCalculatorMapper.ToEntity(ExpencesCalculatorPostDTO);
//        this.expencesCalculatorRepo.save(entity);
//        return ExpencesCalculatorPostDTO;
        ExpencesCalculatorEntity entity = this.expencesCalculatorMapper.ToEntity(ExpencesCalculatorPostDTO);
        TouristyPlacesEntity touristyPlaces = new TouristyPlacesEntity();
        touristyPlaces.setTouristyPlacesId(ExpencesCalculatorPostDTO.getTouristyplaces_id());
        entity.setTouristyPlacesEntity(touristyPlaces);
        this.expencesCalculatorRepo.save(entity);
        return ExpencesCalculatorPostDTO;
    }

    @Override
    public ExpencesCalculatorGetDTO getExpencesCalculatorById(Integer id) {
        Optional<ExpencesCalculatorEntity> entity = this.expencesCalculatorRepo.getExpencesCalculatorEntityByExpencesCalculatorId(id);
        if(entity.isPresent()){
            return this.expencesCalculatorMapper.ToExpencesCalculatorGetDTO(entity.get());
        } else {
            return null;
        }
    }

    @Override
    public List<ExpencesCalculatorGetDTO> getAllExpencesCalculator() {
        List<ExpencesCalculatorEntity> expencesCalculatorEntities = this.expencesCalculatorRepo.findAll();
        if(expencesCalculatorEntities.isEmpty()){
            return null;
        }
        else{
            List<ExpencesCalculatorGetDTO> expencesCalculatorGetDTOS = new ArrayList<>();
            expencesCalculatorEntities.forEach(entity -> {
                expencesCalculatorGetDTOS.add(this.expencesCalculatorMapper.ToExpencesCalculatorGetDTO(entity));
            });
            return expencesCalculatorGetDTOS;
        }
    }

    @Override
    public String deleteExpencesCalculator(Integer id) {
        Optional<ExpencesCalculatorEntity> expencesCalculatorEntity = this.expencesCalculatorRepo.findByExpencesCalculatorIdAndDeletedAtIsNull(id);
        if (expencesCalculatorEntity.isPresent()) {
            expencesCalculatorEntity.get().setDeletedAt(LocalDateTime.now());
            this.expencesCalculatorRepo.save(expencesCalculatorEntity.get());
            return "Expences Calculator has deleted Successfully";
        } else {
            return "user not exist";
        }
    }

    @Override
    public ExpencesCalculatorUpdateDTO updateExpencesCalculator(ExpencesCalculatorUpdateDTO expencesCalculatorUpdateDTO) {
        ExpencesCalculatorEntity entity = this.expencesCalculatorMapper.ToEntity(expencesCalculatorUpdateDTO);
        this.expencesCalculatorRepo.updateExpencesCalculatorNativeQuery(entity.getExpencesCalculatorId(),
                entity.getName(),entity.getDescription(),
                entity.getPeriority(),entity.getPrice(),entity.getTotalCost(), entity.getType(),
                entity.getUpdatedAt());
        return expencesCalculatorUpdateDTO;
    }

    @Override
    public List<ExpencesCalculatorGetDTO> getExpencesCalculatorsByTouristyPlacesId(Integer touristyPlacesId) {
        List<ExpencesCalculatorEntity> expencesCalculatorEntities = this.expencesCalculatorRepo.getExpencesCalculatorEntitiesByTouristyPlacesId(touristyPlacesId);
        if (expencesCalculatorEntities.isEmpty()) {
            return null;
        } else {
            List<ExpencesCalculatorGetDTO> expencesCalculatorGetDTOS = new ArrayList<>();
            expencesCalculatorEntities.forEach(entity -> {
                expencesCalculatorGetDTOS.add(this.expencesCalculatorMapper.ToExpencesCalculatorGetDTO(entity));
            });
            return expencesCalculatorGetDTOS;
        }
    }

    @Override
    public Boolean checkIfTouristyPlaceHasExpencesByTouristyPlaceId(Integer touristyplaceid) {
        List<ExpencesCalculatorEntity> expencesCalculatorEntities = this.expencesCalculatorRepo.getExpencesCalculatorEntitiesByTouristyPlacesId(touristyplaceid);
        if (!expencesCalculatorEntities.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
