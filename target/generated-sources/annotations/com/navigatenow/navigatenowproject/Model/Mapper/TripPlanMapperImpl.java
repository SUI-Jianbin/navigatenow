package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.TripPlanEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-28T20:10:08+1000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class TripPlanMapperImpl implements TripPlanMapper {

    @Override
    public TripPlanEntity ToEntity(TripPlanPostDTO tripPlanPostDTO) {
        if ( tripPlanPostDTO == null ) {
            return null;
        }

        TripPlanEntity.TripPlanEntityBuilder tripPlanEntity = TripPlanEntity.builder();

        tripPlanEntity.tripPlanId( tripPlanPostDTO.getTripPlanId() );
        tripPlanEntity.planName( tripPlanPostDTO.getPlanName() );
        tripPlanEntity.planDescription( tripPlanPostDTO.getPlanDescription() );
        tripPlanEntity.startDate( tripPlanPostDTO.getStartDate() );
        tripPlanEntity.endDate( tripPlanPostDTO.getEndDate() );

        return tripPlanEntity.build();
    }

    @Override
    public TripPlanEntity ToEntity(TripPlanUpdateDTO tripPlanUpdateDTO) {
        if ( tripPlanUpdateDTO == null ) {
            return null;
        }

        TripPlanEntity.TripPlanEntityBuilder tripPlanEntity = TripPlanEntity.builder();

        tripPlanEntity.tripPlanId( tripPlanUpdateDTO.getTripPlanId() );
        tripPlanEntity.planName( tripPlanUpdateDTO.getPlanName() );
        tripPlanEntity.planDescription( tripPlanUpdateDTO.getPlanDescription() );
        tripPlanEntity.startDate( tripPlanUpdateDTO.getStartDate() );
        tripPlanEntity.endDate( tripPlanUpdateDTO.getEndDate() );
        tripPlanEntity.updatedAt( tripPlanUpdateDTO.getUpdatedAt() );

        return tripPlanEntity.build();
    }

    @Override
    public TripPlanEntity ToEntity(TripPlanGetDTO tripPlanGetDTO) {
        if ( tripPlanGetDTO == null ) {
            return null;
        }

        TripPlanEntity.TripPlanEntityBuilder tripPlanEntity = TripPlanEntity.builder();

        tripPlanEntity.tripPlanId( tripPlanGetDTO.getTripPlanId() );
        tripPlanEntity.planName( tripPlanGetDTO.getPlanName() );
        tripPlanEntity.planDescription( tripPlanGetDTO.getPlanDescription() );
        tripPlanEntity.startDate( tripPlanGetDTO.getStartDate() );
        tripPlanEntity.endDate( tripPlanGetDTO.getEndDate() );
        tripPlanEntity.createdAt( tripPlanGetDTO.getCreatedAt() );
        tripPlanEntity.updatedAt( tripPlanGetDTO.getUpdatedAt() );
        tripPlanEntity.userEntity( tripPlanGetDTO.getUserEntity() );

        return tripPlanEntity.build();
    }

    @Override
    public TripPlanPostDTO ToTripPlanPostDTO(TripPlanEntity tripPlanEntity) {
        if ( tripPlanEntity == null ) {
            return null;
        }

        TripPlanPostDTO.TripPlanPostDTOBuilder tripPlanPostDTO = TripPlanPostDTO.builder();

        tripPlanPostDTO.tripPlanId( tripPlanEntity.getTripPlanId() );
        tripPlanPostDTO.planName( tripPlanEntity.getPlanName() );
        tripPlanPostDTO.planDescription( tripPlanEntity.getPlanDescription() );
        tripPlanPostDTO.startDate( tripPlanEntity.getStartDate() );
        tripPlanPostDTO.endDate( tripPlanEntity.getEndDate() );

        return tripPlanPostDTO.build();
    }

    @Override
    public TripPlanGetDTO ToTripPlanGetDTO(TripPlanEntity tripPlanEntity) {
        if ( tripPlanEntity == null ) {
            return null;
        }

        TripPlanGetDTO.TripPlanGetDTOBuilder tripPlanGetDTO = TripPlanGetDTO.builder();

        tripPlanGetDTO.tripPlanId( tripPlanEntity.getTripPlanId() );
        tripPlanGetDTO.planName( tripPlanEntity.getPlanName() );
        tripPlanGetDTO.planDescription( tripPlanEntity.getPlanDescription() );
        tripPlanGetDTO.startDate( tripPlanEntity.getStartDate() );
        tripPlanGetDTO.endDate( tripPlanEntity.getEndDate() );
        tripPlanGetDTO.createdAt( tripPlanEntity.getCreatedAt() );
        tripPlanGetDTO.updatedAt( tripPlanEntity.getUpdatedAt() );
        tripPlanGetDTO.userEntity( tripPlanEntity.getUserEntity() );

        return tripPlanGetDTO.build();
    }

    @Override
    public TripPlanUpdateDTO ToTripPlanUpdateDTO(TripPlanEntity tripPlanEntity) {
        if ( tripPlanEntity == null ) {
            return null;
        }

        TripPlanUpdateDTO.TripPlanUpdateDTOBuilder tripPlanUpdateDTO = TripPlanUpdateDTO.builder();

        tripPlanUpdateDTO.tripPlanId( tripPlanEntity.getTripPlanId() );
        tripPlanUpdateDTO.planName( tripPlanEntity.getPlanName() );
        tripPlanUpdateDTO.planDescription( tripPlanEntity.getPlanDescription() );
        tripPlanUpdateDTO.startDate( tripPlanEntity.getStartDate() );
        tripPlanUpdateDTO.endDate( tripPlanEntity.getEndDate() );
        tripPlanUpdateDTO.updatedAt( tripPlanEntity.getUpdatedAt() );

        return tripPlanUpdateDTO.build();
    }
}
