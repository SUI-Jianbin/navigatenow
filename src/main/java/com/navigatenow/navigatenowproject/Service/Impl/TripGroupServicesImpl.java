package com.navigatenow.navigatenowproject.Service.Impl;

import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs.TripGroupGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs.TripGroupPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs.TripGroupUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.ContactUsEntity;
import com.navigatenow.navigatenowproject.Model.Entity.TripGroupEntity;
import com.navigatenow.navigatenowproject.Model.Entity.TripPlanEntity;
import com.navigatenow.navigatenowproject.Model.Entity.UserEntity;
import com.navigatenow.navigatenowproject.Model.Mapper.TripGroupMapper;
import com.navigatenow.navigatenowproject.Model.Mapper.TripPlanMapper;
import com.navigatenow.navigatenowproject.Repository.TripGroupRepo;
import com.navigatenow.navigatenowproject.Service.TripGroupServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TripGroupServicesImpl implements TripGroupServices {
    private final TripGroupRepo tripGroupRepo;
    private final TripGroupMapper tripGroupMapper;
    private final TripPlanMapper tripPlanMapper;


    @Override
    public TripGroupPostDTO addTripGroup(TripGroupPostDTO TripGroupPostDTO) {
        TripGroupEntity entity = this.tripGroupMapper.ToEntity(TripGroupPostDTO);
        entity.setNumberOfTourists(1);
        TripPlanEntity user = new TripPlanEntity();
        user.setTripPlanId(TripGroupPostDTO.getTripplan_id());
        entity.setTripPlanEntity(user);
        this.tripGroupRepo.save(entity);
        return TripGroupPostDTO;
    }

    @Override
    public TripGroupGetDTO getTripGroupById(Integer id) {
        Optional<TripGroupEntity> entity = this.tripGroupRepo.getTripGroupEntityByTripGroupId(id);
        if (entity.isPresent()){
            return this.tripGroupMapper.ToTripGroupGetDTO(entity.get());
        }else {
            return null;
        }
    }

    @Override
    public TripGroupGetDTO getTripGroupByTripPlanId(Integer id) {
        Optional<TripGroupEntity> entity = this.tripGroupRepo.getTripGroupEntitiesByTripPlanEntity_TripPlanId(id);
        if (entity.isPresent()){
            return this.tripGroupMapper.ToTripGroupGetDTO(entity.get());
        }else {
            return null;
        }
    }



    @Override
    public List<TripGroupGetDTO> getAllTripGroup() {
        List<TripGroupEntity> tripGroupEntities = this.tripGroupRepo.findAll();
        if(tripGroupEntities.isEmpty()){
            return null;
        }
        else {
            List<TripGroupGetDTO> tripGroupGetDTOS = new ArrayList<>();
            for (int i = 0; i< tripGroupEntities.size(); i++ ){
                tripGroupGetDTOS.add(this.tripGroupMapper.ToTripGroupGetDTO(tripGroupEntities.get(i)));
                tripGroupGetDTOS.get(i).setTripPlanGetDTO(this.tripPlanMapper.ToTripPlanGetDTO(tripGroupEntities.get(i).getTripPlanEntity()));
            }

            return tripGroupGetDTOS;
        }
    }

    @Override
    public List<TripGroupGetDTO> getOtherUsersGroupsByUserId(Integer userid) {
        List<TripGroupEntity> tripGroupEntities = this.tripGroupRepo.getOtherUsersGroupsByUserId(userid);
        if(tripGroupEntities.isEmpty()){
            return null;
        }
        else {
            List<TripGroupGetDTO> tripGroupGetDTOS = new ArrayList<>();
            for (int i = 0; i< tripGroupEntities.size(); i++ ){
                tripGroupGetDTOS.add(this.tripGroupMapper.ToTripGroupGetDTO(tripGroupEntities.get(i)));
                tripGroupGetDTOS.get(i).setTripPlanGetDTO(this.tripPlanMapper.ToTripPlanGetDTO(tripGroupEntities.get(i).getTripPlanEntity()));
            }

            return tripGroupGetDTOS;
        }
    }

    @Override
    public List<TripGroupGetDTO> getAllTripGroupsByGroupName(String groupName) {
        List<TripGroupEntity> tripGroupEntities = this.tripGroupRepo.getTripGroupEntitiesByGroupNameContaining(groupName);
        if(tripGroupEntities.isEmpty()){
            return null;
        }
        else {
            List<TripGroupGetDTO> tripGroupGetDTOS = new ArrayList<>();
            for (int i = 0; i< tripGroupEntities.size(); i++ ){
                tripGroupGetDTOS.add(this.tripGroupMapper.ToTripGroupGetDTO(tripGroupEntities.get(i)));
                tripGroupGetDTOS.get(i).setTripPlanGetDTO(this.tripPlanMapper.ToTripPlanGetDTO(tripGroupEntities.get(i).getTripPlanEntity()));
            }

            return tripGroupGetDTOS;
        }
    }

    @Override
    public String deleteTripGroup(Integer id) {
        Optional<TripGroupEntity> tripGroup = this.tripGroupRepo.findByTripGroupIdAndDeletedAtIsNull(id);
        if (tripGroup.isPresent()) {
           /* tripGroup.get().setDeletedAt(LocalDateTime.now());
            this.tripGroupRepo.save(tripGroup.get());*/
            this.tripGroupRepo.delete(tripGroup.get());
            return "Trip Group has deleted Successfully";
        } else {
            return "user not exist";
        }
    }

    @Override
    public TripGroupUpdateDTO updateTripGroup(TripGroupUpdateDTO tripGroupUpdateDTO) {
        TripGroupEntity entity = this.tripGroupMapper.ToEntity(tripGroupUpdateDTO);
        this.tripGroupRepo.updateTripGroupNativeQuery(entity.getTripGroupId(), entity.getGroupName(),
                entity.getGroupDescription(), entity.getGroupNumberLemit(),
                entity.getUpdatedAt());
        return tripGroupUpdateDTO;
    }

    @Override
    public Boolean checkIfUserHasCreatedGroupsByUserId(Integer userid) {
        List<TripGroupEntity> tripGroup = this.tripGroupRepo.checkIfUserHasCreatedGroupsByUserId(userid);
        if (!tripGroup.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
