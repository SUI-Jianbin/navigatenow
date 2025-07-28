package com.navigatenow.navigatenowproject.Service.Impl;

import com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs.TripGroupGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_TripPlan_TripGroupDTOs.*;
import com.navigatenow.navigatenowproject.Model.Entity.UserEntity;
import com.navigatenow.navigatenowproject.Model.Entity.User_TripPlan_TripGroupEntity;
import com.navigatenow.navigatenowproject.Model.Mapper.TripGroupMapper;
import com.navigatenow.navigatenowproject.Model.Mapper.TripPlanMapper;
import com.navigatenow.navigatenowproject.Model.Mapper.UserMapper;
import com.navigatenow.navigatenowproject.Model.Mapper.User_TripPlan_TripGroupMapper;
import com.navigatenow.navigatenowproject.Repository.TripGroupRepo;
import com.navigatenow.navigatenowproject.Repository.TripPlanRepo;
import com.navigatenow.navigatenowproject.Repository.User_TripPlan_TripGroupRepo;
import com.navigatenow.navigatenowproject.Service.TripGroupServices;
import com.navigatenow.navigatenowproject.Service.TripPlanServices;
import com.navigatenow.navigatenowproject.Service.User_TripPlan_TripGroupServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class User_TripPlan_TripGroupServicesImpl implements User_TripPlan_TripGroupServices {

    private final User_TripPlan_TripGroupRepo user_tripPlanTripGroupRepo;
    private final User_TripPlan_TripGroupMapper userTripPlanTripGroupMapper;

    private final TripPlanRepo tripPlanRepo;
    private final TripPlanMapper tripPlanMapper;
    private final TripPlanServices tripPlanServices;

    private final TripGroupRepo tripGroupRepo;
    private final TripGroupMapper tripGroupMapper;
    private final TripGroupServices tripGroupServices;

    private final UserServicesImpl userServices;
    private final UserMapper userMapper;

    // add trip plan and group id to a user. Basically join group.
    @Override
    public User_TripPlan_TripGroupPostDTO addUser_TripPlan_TripGroup(User_TripPlan_TripGroupPostDTO user_tripPlanTripGroupEntityPostDTO) {
        Optional<User_TripPlan_TripGroupEntity> userTripPlanTripGroupEntities = this.user_tripPlanTripGroupRepo.
                getallByUserIdAndTripPlanIdAndTripGroupId(user_tripPlanTripGroupEntityPostDTO.getUserId(),
                        user_tripPlanTripGroupEntityPostDTO.getTripPlanId(), user_tripPlanTripGroupEntityPostDTO.getTripGroupId());

        if (userTripPlanTripGroupEntities.isEmpty()) {
            User_TripPlan_TripGroupEntity entity = this.userTripPlanTripGroupMapper.ToEntity(user_tripPlanTripGroupEntityPostDTO);

            UserGetDTO userGetDTO = this.userServices.getUserById(user_tripPlanTripGroupEntityPostDTO.getUserId());

            TripPlanGetDTO tripPlanGetDTO = this.tripPlanServices.getTripPlanById(user_tripPlanTripGroupEntityPostDTO.getTripPlanId());

            TripGroupGetDTO tripGroupGetDTO = this.tripGroupServices.getTripGroupById(user_tripPlanTripGroupEntityPostDTO.getTripGroupId());

            entity.setUserEntity(this.userMapper.ToEntity(userGetDTO));
            entity.setTripPlanEntity(this.tripPlanMapper.ToEntity(tripPlanGetDTO));
            entity.setTripGroupEntity(this.tripGroupMapper.ToEntity(tripGroupGetDTO));

            entity.getTripGroupEntity().setNumberOfTourists(entity.getTripGroupEntity().getNumberOfTourists() + 1);
            this.user_tripPlanTripGroupRepo.save(entity);
            this.tripGroupRepo.updateNumberOfTourists(entity.getTripGroupId(), entity.getTripGroupEntity().getNumberOfTourists(), entity.getUpdatedAt());
            return user_tripPlanTripGroupEntityPostDTO;
        } else {
            return null;
        }
    }

    // get All joined groups by user id
    @Override
    public List<User_TripPlans_TripGroupsGetDTO> getUser_TripPlan_TripGroupByUserId(Integer userid) {
        List<User_TripPlan_TripGroupEntity> userTripPlanTripGroupEntities = this.user_tripPlanTripGroupRepo.getUser_TripPlan_TripGroupByUserId(userid);
        List<User_TripPlans_TripGroupsGetDTO> userTripPlansTripGroupsGetDTOS = new ArrayList<>();

        UserGetDTO userGetDTO = new UserGetDTO();
        TripPlanGetDTO tripPlanGetDTO = new TripPlanGetDTO();
        TripGroupGetDTO tripGroupGetDTO = new TripGroupGetDTO();

        if(!userTripPlanTripGroupEntities.isEmpty()) {
            for (int i = 0; i < userTripPlanTripGroupEntities.size(); i++) {

                userGetDTO = this.userServices.getUserById(userTripPlanTripGroupEntities.get(i).getUserId());
                tripPlanGetDTO = this.tripPlanServices.getTripPlanById(userTripPlanTripGroupEntities.get(i).getTripPlanId());
                tripGroupGetDTO = this.tripGroupServices.getTripGroupById(userTripPlanTripGroupEntities.get(i).getTripGroupId());

                userTripPlansTripGroupsGetDTOS.add(this.userTripPlanTripGroupMapper.ToUser_TripPlans_TripGroupsGetDTO(userTripPlanTripGroupEntities.get(i)));
                userTripPlansTripGroupsGetDTOS.get(i).setUserGetDTO(userGetDTO);
                userTripPlansTripGroupsGetDTOS.get(i).setTripPlanGetDTOS(tripPlanGetDTO);
                userTripPlansTripGroupsGetDTOS.get(i).setTripGroupGetDTOS(tripGroupGetDTO);

            }
            return userTripPlansTripGroupsGetDTOS;
        }
        else return null;

    }

    // get all users trip's plans and groups except mine to be joined
    @Override
    public List<User_TripPlans_TripGroupsGetDTO> getOtherUsersGroupsByUserId(Integer userid) {
        List<User_TripPlan_TripGroupEntity> userTripPlanTripGroupEntities = this.user_tripPlanTripGroupRepo.getOtherUsersGroupsByUserId(userid);
        List<User_TripPlans_TripGroupsGetDTO> userTripPlansTripGroupsGetDTOS = new ArrayList<>();

        UserGetDTO userGetDTO = new UserGetDTO();
        TripPlanGetDTO tripPlanGetDTO = new TripPlanGetDTO();
        TripGroupGetDTO tripGroupGetDTO = new TripGroupGetDTO();

        if(!userTripPlanTripGroupEntities.isEmpty()) {
            for (int i = 0; i < userTripPlanTripGroupEntities.size(); i++) {

                userGetDTO = this.userServices.getUserById(userTripPlanTripGroupEntities.get(i).getUserId());
                tripPlanGetDTO = this.tripPlanServices.getTripPlanById(userTripPlanTripGroupEntities.get(i).getTripPlanId());
                tripGroupGetDTO = this.tripGroupServices.getTripGroupById(userTripPlanTripGroupEntities.get(i).getTripGroupId());

                userTripPlansTripGroupsGetDTOS.add(this.userTripPlanTripGroupMapper.ToUser_TripPlans_TripGroupsGetDTO(userTripPlanTripGroupEntities.get(i)));
                userTripPlansTripGroupsGetDTOS.get(i).setUserGetDTO(userGetDTO);
                userTripPlansTripGroupsGetDTOS.get(i).setTripPlanGetDTOS(tripPlanGetDTO);
                userTripPlansTripGroupsGetDTOS.get(i).setTripGroupGetDTOS(tripGroupGetDTO);

            }
            return userTripPlansTripGroupsGetDTOS;
        }
        else return null;
    }

    // leave group
    @Override
    public String leaveJoinedGroupByUserId(Integer user_TripPlan_TripGroupId) {
        Optional<User_TripPlan_TripGroupEntity> userTripPlanTripGroupEntity = this.user_tripPlanTripGroupRepo.findByUserIdAndDeletedAtIsNull(user_TripPlan_TripGroupId);
        if (userTripPlanTripGroupEntity.isPresent()) {
            userTripPlanTripGroupEntity.get().setDeletedAt(LocalDateTime.now());

            TripGroupGetDTO tripGroupGetDTO = this.tripGroupServices.getTripGroupById(userTripPlanTripGroupEntity.get().getTripGroupId());
            
            tripGroupGetDTO.setNumberOfTourists(tripGroupGetDTO.getNumberOfTourists() - 1);

            this.tripGroupRepo.updateNumberOfTourists(tripGroupGetDTO.getTripGroupId(), tripGroupGetDTO.getNumberOfTourists(), tripGroupGetDTO.getCreatedAt());

            this.user_tripPlanTripGroupRepo.save(userTripPlanTripGroupEntity.get());
            return "user tripPlan has deleted Successfully";
        } else {
            return "user tripPlan not exist";
        }
    }


}
