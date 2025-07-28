package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs.TripGroupGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs.TripGroupPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs.TripGroupUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.TripGroupEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-28T20:10:08+1000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class TripGroupMapperImpl implements TripGroupMapper {

    @Override
    public TripGroupEntity ToEntity(TripGroupPostDTO tripGroupPostDTO) {
        if ( tripGroupPostDTO == null ) {
            return null;
        }

        TripGroupEntity.TripGroupEntityBuilder tripGroupEntity = TripGroupEntity.builder();

        tripGroupEntity.tripGroupId( tripGroupPostDTO.getTripGroupId() );
        tripGroupEntity.groupName( tripGroupPostDTO.getGroupName() );
        tripGroupEntity.groupDescription( tripGroupPostDTO.getGroupDescription() );
        tripGroupEntity.numberOfTourists( tripGroupPostDTO.getNumberOfTourists() );
        tripGroupEntity.groupNumberLemit( tripGroupPostDTO.getGroupNumberLemit() );
        tripGroupEntity.createdAt( tripGroupPostDTO.getCreatedAt() );

        return tripGroupEntity.build();
    }

    @Override
    public TripGroupEntity ToEntity(TripGroupUpdateDTO tripGroupUpdateDTO) {
        if ( tripGroupUpdateDTO == null ) {
            return null;
        }

        TripGroupEntity.TripGroupEntityBuilder tripGroupEntity = TripGroupEntity.builder();

        tripGroupEntity.tripGroupId( tripGroupUpdateDTO.getTripGroupId() );
        tripGroupEntity.groupName( tripGroupUpdateDTO.getGroupName() );
        tripGroupEntity.groupDescription( tripGroupUpdateDTO.getGroupDescription() );
        tripGroupEntity.numberOfTourists( tripGroupUpdateDTO.getNumberOfTourists() );
        tripGroupEntity.groupNumberLemit( tripGroupUpdateDTO.getGroupNumberLemit() );
        tripGroupEntity.updatedAt( tripGroupUpdateDTO.getUpdatedAt() );

        return tripGroupEntity.build();
    }

    @Override
    public TripGroupEntity ToEntity(TripGroupGetDTO tripGroupGetDTO) {
        if ( tripGroupGetDTO == null ) {
            return null;
        }

        TripGroupEntity.TripGroupEntityBuilder tripGroupEntity = TripGroupEntity.builder();

        tripGroupEntity.tripGroupId( tripGroupGetDTO.getTripGroupId() );
        tripGroupEntity.groupName( tripGroupGetDTO.getGroupName() );
        tripGroupEntity.groupDescription( tripGroupGetDTO.getGroupDescription() );
        tripGroupEntity.numberOfTourists( tripGroupGetDTO.getNumberOfTourists() );
        tripGroupEntity.groupNumberLemit( tripGroupGetDTO.getGroupNumberLemit() );
        tripGroupEntity.createdAt( tripGroupGetDTO.getCreatedAt() );

        return tripGroupEntity.build();
    }

    @Override
    public TripGroupPostDTO ToTripGroupPostDTO(TripGroupEntity tripGroupEntity) {
        if ( tripGroupEntity == null ) {
            return null;
        }

        TripGroupPostDTO.TripGroupPostDTOBuilder tripGroupPostDTO = TripGroupPostDTO.builder();

        tripGroupPostDTO.tripGroupId( tripGroupEntity.getTripGroupId() );
        tripGroupPostDTO.groupName( tripGroupEntity.getGroupName() );
        tripGroupPostDTO.groupDescription( tripGroupEntity.getGroupDescription() );
        tripGroupPostDTO.numberOfTourists( tripGroupEntity.getNumberOfTourists() );
        tripGroupPostDTO.groupNumberLemit( tripGroupEntity.getGroupNumberLemit() );
        tripGroupPostDTO.createdAt( tripGroupEntity.getCreatedAt() );

        return tripGroupPostDTO.build();
    }

    @Override
    public TripGroupGetDTO ToTripGroupGetDTO(TripGroupEntity tripGroupEntity) {
        if ( tripGroupEntity == null ) {
            return null;
        }

        TripGroupGetDTO.TripGroupGetDTOBuilder tripGroupGetDTO = TripGroupGetDTO.builder();

        tripGroupGetDTO.tripGroupId( tripGroupEntity.getTripGroupId() );
        tripGroupGetDTO.groupName( tripGroupEntity.getGroupName() );
        tripGroupGetDTO.groupDescription( tripGroupEntity.getGroupDescription() );
        tripGroupGetDTO.numberOfTourists( tripGroupEntity.getNumberOfTourists() );
        tripGroupGetDTO.groupNumberLemit( tripGroupEntity.getGroupNumberLemit() );
        tripGroupGetDTO.createdAt( tripGroupEntity.getCreatedAt() );

        return tripGroupGetDTO.build();
    }

    @Override
    public TripGroupUpdateDTO ToTripGroupUpdateDTO(TripGroupEntity tripGroupEntity) {
        if ( tripGroupEntity == null ) {
            return null;
        }

        TripGroupUpdateDTO.TripGroupUpdateDTOBuilder tripGroupUpdateDTO = TripGroupUpdateDTO.builder();

        tripGroupUpdateDTO.tripGroupId( tripGroupEntity.getTripGroupId() );
        tripGroupUpdateDTO.groupName( tripGroupEntity.getGroupName() );
        tripGroupUpdateDTO.groupDescription( tripGroupEntity.getGroupDescription() );
        tripGroupUpdateDTO.numberOfTourists( tripGroupEntity.getNumberOfTourists() );
        tripGroupUpdateDTO.groupNumberLemit( tripGroupEntity.getGroupNumberLemit() );
        tripGroupUpdateDTO.updatedAt( tripGroupEntity.getUpdatedAt() );

        return tripGroupUpdateDTO.build();
    }
}
