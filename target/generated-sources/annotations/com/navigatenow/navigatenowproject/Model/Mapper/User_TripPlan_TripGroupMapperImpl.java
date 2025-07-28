package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.User_TripPlan_TripGroupDTOs.User_TripGroupUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_TripPlan_TripGroupDTOs.User_TripPlanUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_TripPlan_TripGroupDTOs.User_TripPlan_TripGroupGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_TripPlan_TripGroupDTOs.User_TripPlan_TripGroupPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_TripPlan_TripGroupDTOs.User_TripPlan_TripGroupUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_TripPlan_TripGroupDTOs.User_TripPlans_TripGroupsGetDTO;
import com.navigatenow.navigatenowproject.Model.Entity.User_TripPlan_TripGroupEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-28T20:10:08+1000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class User_TripPlan_TripGroupMapperImpl implements User_TripPlan_TripGroupMapper {

    @Override
    public User_TripPlan_TripGroupEntity ToEntity(User_TripPlan_TripGroupPostDTO user_tripPlanTripGroupEntityPostDTO) {
        if ( user_tripPlanTripGroupEntityPostDTO == null ) {
            return null;
        }

        User_TripPlan_TripGroupEntity user_TripPlan_TripGroupEntity = new User_TripPlan_TripGroupEntity();

        user_TripPlan_TripGroupEntity.setUser_TripPlan_TripGroupId( user_tripPlanTripGroupEntityPostDTO.getUser_TripPlan_TripGroupId() );
        user_TripPlan_TripGroupEntity.setUserId( user_tripPlanTripGroupEntityPostDTO.getUserId() );
        user_TripPlan_TripGroupEntity.setTripPlanId( user_tripPlanTripGroupEntityPostDTO.getTripPlanId() );
        user_TripPlan_TripGroupEntity.setTripGroupId( user_tripPlanTripGroupEntityPostDTO.getTripGroupId() );
        user_TripPlan_TripGroupEntity.setCreatedAt( user_tripPlanTripGroupEntityPostDTO.getCreatedAt() );

        return user_TripPlan_TripGroupEntity;
    }

    @Override
    public User_TripPlan_TripGroupEntity ToEntity(User_TripPlan_TripGroupUpdateDTO user_tripPlanTripGroupEntityUpdateDTO) {
        if ( user_tripPlanTripGroupEntityUpdateDTO == null ) {
            return null;
        }

        User_TripPlan_TripGroupEntity user_TripPlan_TripGroupEntity = new User_TripPlan_TripGroupEntity();

        user_TripPlan_TripGroupEntity.setUser_TripPlan_TripGroupId( user_tripPlanTripGroupEntityUpdateDTO.getUser_TripPlan_TripGroupId() );
        user_TripPlan_TripGroupEntity.setUserId( user_tripPlanTripGroupEntityUpdateDTO.getUserId() );
        user_TripPlan_TripGroupEntity.setTripPlanId( user_tripPlanTripGroupEntityUpdateDTO.getTripPlanId() );
        user_TripPlan_TripGroupEntity.setTripGroupId( user_tripPlanTripGroupEntityUpdateDTO.getTripGroupId() );
        user_TripPlan_TripGroupEntity.setUpdatedAt( user_tripPlanTripGroupEntityUpdateDTO.getUpdatedAt() );

        return user_TripPlan_TripGroupEntity;
    }

    @Override
    public User_TripPlan_TripGroupEntity ToEntity(User_TripPlanUpdateDTO user_tripPlanUpdateDTO) {
        if ( user_tripPlanUpdateDTO == null ) {
            return null;
        }

        User_TripPlan_TripGroupEntity user_TripPlan_TripGroupEntity = new User_TripPlan_TripGroupEntity();

        user_TripPlan_TripGroupEntity.setUser_TripPlan_TripGroupId( user_tripPlanUpdateDTO.getUser_TripPlan_TripGroupId() );
        user_TripPlan_TripGroupEntity.setTripPlanId( user_tripPlanUpdateDTO.getTripPlanId() );
        user_TripPlan_TripGroupEntity.setUpdatedAt( user_tripPlanUpdateDTO.getUpdatedAt() );

        return user_TripPlan_TripGroupEntity;
    }

    @Override
    public User_TripPlan_TripGroupEntity ToEntity(User_TripGroupUpdateDTO userTripGroupUpdateDTO) {
        if ( userTripGroupUpdateDTO == null ) {
            return null;
        }

        User_TripPlan_TripGroupEntity user_TripPlan_TripGroupEntity = new User_TripPlan_TripGroupEntity();

        user_TripPlan_TripGroupEntity.setUser_TripPlan_TripGroupId( userTripGroupUpdateDTO.getUser_TripPlan_TripGroupId() );
        user_TripPlan_TripGroupEntity.setTripGroupId( userTripGroupUpdateDTO.getTripGroupId() );
        user_TripPlan_TripGroupEntity.setUpdatedAt( userTripGroupUpdateDTO.getUpdatedAt() );

        return user_TripPlan_TripGroupEntity;
    }

    @Override
    public User_TripPlan_TripGroupEntity ToEntity(User_TripPlans_TripGroupsGetDTO userTripPlansTripGroupsGetDTO) {
        if ( userTripPlansTripGroupsGetDTO == null ) {
            return null;
        }

        User_TripPlan_TripGroupEntity user_TripPlan_TripGroupEntity = new User_TripPlan_TripGroupEntity();

        user_TripPlan_TripGroupEntity.setUser_TripPlan_TripGroupId( userTripPlansTripGroupsGetDTO.getUser_TripPlan_TripGroupId() );
        user_TripPlan_TripGroupEntity.setUserId( userTripPlansTripGroupsGetDTO.getUserId() );
        user_TripPlan_TripGroupEntity.setTripPlanId( userTripPlansTripGroupsGetDTO.getTripPlanId() );
        user_TripPlan_TripGroupEntity.setTripGroupId( userTripPlansTripGroupsGetDTO.getTripGroupId() );
        user_TripPlan_TripGroupEntity.setCreatedAt( userTripPlansTripGroupsGetDTO.getCreatedAt() );
        user_TripPlan_TripGroupEntity.setUpdatedAt( userTripPlansTripGroupsGetDTO.getUpdatedAt() );

        return user_TripPlan_TripGroupEntity;
    }

    @Override
    public User_TripPlan_TripGroupPostDTO ToUser_TripPlanPostDTO(User_TripPlan_TripGroupEntity user_tripPlanEntity) {
        if ( user_tripPlanEntity == null ) {
            return null;
        }

        User_TripPlan_TripGroupPostDTO.User_TripPlan_TripGroupPostDTOBuilder user_TripPlan_TripGroupPostDTO = User_TripPlan_TripGroupPostDTO.builder();

        user_TripPlan_TripGroupPostDTO.user_TripPlan_TripGroupId( user_tripPlanEntity.getUser_TripPlan_TripGroupId() );
        user_TripPlan_TripGroupPostDTO.userId( user_tripPlanEntity.getUserId() );
        user_TripPlan_TripGroupPostDTO.tripPlanId( user_tripPlanEntity.getTripPlanId() );
        user_TripPlan_TripGroupPostDTO.tripGroupId( user_tripPlanEntity.getTripGroupId() );
        user_TripPlan_TripGroupPostDTO.createdAt( user_tripPlanEntity.getCreatedAt() );

        return user_TripPlan_TripGroupPostDTO.build();
    }

    @Override
    public User_TripPlan_TripGroupGetDTO ToUser_TripPlanGetDTO(User_TripPlan_TripGroupEntity user_tripPlanEntity) {
        if ( user_tripPlanEntity == null ) {
            return null;
        }

        User_TripPlan_TripGroupGetDTO.User_TripPlan_TripGroupGetDTOBuilder user_TripPlan_TripGroupGetDTO = User_TripPlan_TripGroupGetDTO.builder();

        user_TripPlan_TripGroupGetDTO.user_TripPlan_TripGroupId( user_tripPlanEntity.getUser_TripPlan_TripGroupId() );
        user_TripPlan_TripGroupGetDTO.userId( user_tripPlanEntity.getUserId() );
        user_TripPlan_TripGroupGetDTO.tripPlanId( user_tripPlanEntity.getTripPlanId() );
        user_TripPlan_TripGroupGetDTO.tripGroupId( user_tripPlanEntity.getTripGroupId() );
        user_TripPlan_TripGroupGetDTO.createdAt( user_tripPlanEntity.getCreatedAt() );
        user_TripPlan_TripGroupGetDTO.updatedAt( user_tripPlanEntity.getUpdatedAt() );

        return user_TripPlan_TripGroupGetDTO.build();
    }

    @Override
    public User_TripPlan_TripGroupUpdateDTO ToUser_TripPlan_TripGroupUpdateDTO(User_TripPlan_TripGroupEntity user_tripPlanEntity) {
        if ( user_tripPlanEntity == null ) {
            return null;
        }

        User_TripPlan_TripGroupUpdateDTO.User_TripPlan_TripGroupUpdateDTOBuilder user_TripPlan_TripGroupUpdateDTO = User_TripPlan_TripGroupUpdateDTO.builder();

        user_TripPlan_TripGroupUpdateDTO.user_TripPlan_TripGroupId( user_tripPlanEntity.getUser_TripPlan_TripGroupId() );
        user_TripPlan_TripGroupUpdateDTO.userId( user_tripPlanEntity.getUserId() );
        user_TripPlan_TripGroupUpdateDTO.tripPlanId( user_tripPlanEntity.getTripPlanId() );
        user_TripPlan_TripGroupUpdateDTO.tripGroupId( user_tripPlanEntity.getTripGroupId() );
        user_TripPlan_TripGroupUpdateDTO.updatedAt( user_tripPlanEntity.getUpdatedAt() );

        return user_TripPlan_TripGroupUpdateDTO.build();
    }

    @Override
    public User_TripPlanUpdateDTO ToUser_TripPlanUpdateDTO(User_TripPlan_TripGroupEntity user_tripPlanEntity) {
        if ( user_tripPlanEntity == null ) {
            return null;
        }

        User_TripPlanUpdateDTO.User_TripPlanUpdateDTOBuilder user_TripPlanUpdateDTO = User_TripPlanUpdateDTO.builder();

        user_TripPlanUpdateDTO.user_TripPlan_TripGroupId( user_tripPlanEntity.getUser_TripPlan_TripGroupId() );
        user_TripPlanUpdateDTO.tripPlanId( user_tripPlanEntity.getTripPlanId() );
        user_TripPlanUpdateDTO.updatedAt( user_tripPlanEntity.getUpdatedAt() );

        return user_TripPlanUpdateDTO.build();
    }

    @Override
    public User_TripGroupUpdateDTO ToUser_TripGroupUpdateDTO(User_TripPlan_TripGroupEntity user_tripPlanEntity) {
        if ( user_tripPlanEntity == null ) {
            return null;
        }

        User_TripGroupUpdateDTO.User_TripGroupUpdateDTOBuilder user_TripGroupUpdateDTO = User_TripGroupUpdateDTO.builder();

        user_TripGroupUpdateDTO.user_TripPlan_TripGroupId( user_tripPlanEntity.getUser_TripPlan_TripGroupId() );
        user_TripGroupUpdateDTO.tripGroupId( user_tripPlanEntity.getTripGroupId() );
        user_TripGroupUpdateDTO.updatedAt( user_tripPlanEntity.getUpdatedAt() );

        return user_TripGroupUpdateDTO.build();
    }

    @Override
    public User_TripPlans_TripGroupsGetDTO ToUser_TripPlans_TripGroupsGetDTO(User_TripPlan_TripGroupEntity user_tripPlanEntity) {
        if ( user_tripPlanEntity == null ) {
            return null;
        }

        User_TripPlans_TripGroupsGetDTO.User_TripPlans_TripGroupsGetDTOBuilder user_TripPlans_TripGroupsGetDTO = User_TripPlans_TripGroupsGetDTO.builder();

        user_TripPlans_TripGroupsGetDTO.user_TripPlan_TripGroupId( user_tripPlanEntity.getUser_TripPlan_TripGroupId() );
        user_TripPlans_TripGroupsGetDTO.userId( user_tripPlanEntity.getUserId() );
        user_TripPlans_TripGroupsGetDTO.tripPlanId( user_tripPlanEntity.getTripPlanId() );
        user_TripPlans_TripGroupsGetDTO.tripGroupId( user_tripPlanEntity.getTripGroupId() );
        user_TripPlans_TripGroupsGetDTO.createdAt( user_tripPlanEntity.getCreatedAt() );
        user_TripPlans_TripGroupsGetDTO.updatedAt( user_tripPlanEntity.getUpdatedAt() );

        return user_TripPlans_TripGroupsGetDTO.build();
    }
}
