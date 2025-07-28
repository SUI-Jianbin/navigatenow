package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlaces_TripPlanDTOs.TouristyPlaces_TripPlanGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlaces_TripPlanDTOs.TouristyPlaces_TripPlanPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlaces_TripPlanDTOs.TouristyPlaces_TripPlanUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.TouristyPlaces_TripPlanEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-28T20:10:08+1000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class TouristyPlaces_TripPlanMapperImpl implements TouristyPlaces_TripPlanMapper {

    @Override
    public TouristyPlaces_TripPlanEntity ToEntity(TouristyPlaces_TripPlanPostDTO touristyPlaces_tripPlanPostDTO) {
        if ( touristyPlaces_tripPlanPostDTO == null ) {
            return null;
        }

        TouristyPlaces_TripPlanEntity.TouristyPlaces_TripPlanEntityBuilder touristyPlaces_TripPlanEntity = TouristyPlaces_TripPlanEntity.builder();

        touristyPlaces_TripPlanEntity.touristyPlaces_tripPlanId( touristyPlaces_tripPlanPostDTO.getTouristyPlaces_tripPlanId() );
        touristyPlaces_TripPlanEntity.tripPlanId( touristyPlaces_tripPlanPostDTO.getTripPlanId() );
        touristyPlaces_TripPlanEntity.touristyPlacesId( touristyPlaces_tripPlanPostDTO.getTouristyPlacesId() );
        touristyPlaces_TripPlanEntity.createdAt( touristyPlaces_tripPlanPostDTO.getCreatedAt() );

        return touristyPlaces_TripPlanEntity.build();
    }

    @Override
    public TouristyPlaces_TripPlanEntity ToEntity(TouristyPlaces_TripPlanUpdateDTO touristyPlaces_tripPlanUpdateDTO) {
        if ( touristyPlaces_tripPlanUpdateDTO == null ) {
            return null;
        }

        TouristyPlaces_TripPlanEntity.TouristyPlaces_TripPlanEntityBuilder touristyPlaces_TripPlanEntity = TouristyPlaces_TripPlanEntity.builder();

        touristyPlaces_TripPlanEntity.touristyPlaces_tripPlanId( touristyPlaces_tripPlanUpdateDTO.getTouristyPlaces_tripPlanId() );
        touristyPlaces_TripPlanEntity.tripPlanId( touristyPlaces_tripPlanUpdateDTO.getTripPlanId() );
        touristyPlaces_TripPlanEntity.touristyPlacesId( touristyPlaces_tripPlanUpdateDTO.getTouristyPlacesId() );
        touristyPlaces_TripPlanEntity.updatedAt( touristyPlaces_tripPlanUpdateDTO.getUpdatedAt() );

        return touristyPlaces_TripPlanEntity.build();
    }

    @Override
    public TouristyPlaces_TripPlanPostDTO ToTouristyPlaces_TripPlanPostDTO(TouristyPlaces_TripPlanEntity touristyPlaces_tripPlanEntity) {
        if ( touristyPlaces_tripPlanEntity == null ) {
            return null;
        }

        TouristyPlaces_TripPlanPostDTO.TouristyPlaces_TripPlanPostDTOBuilder touristyPlaces_TripPlanPostDTO = TouristyPlaces_TripPlanPostDTO.builder();

        touristyPlaces_TripPlanPostDTO.touristyPlaces_tripPlanId( touristyPlaces_tripPlanEntity.getTouristyPlaces_tripPlanId() );
        touristyPlaces_TripPlanPostDTO.tripPlanId( touristyPlaces_tripPlanEntity.getTripPlanId() );
        touristyPlaces_TripPlanPostDTO.touristyPlacesId( touristyPlaces_tripPlanEntity.getTouristyPlacesId() );
        touristyPlaces_TripPlanPostDTO.createdAt( touristyPlaces_tripPlanEntity.getCreatedAt() );

        return touristyPlaces_TripPlanPostDTO.build();
    }

    @Override
    public TouristyPlaces_TripPlanGetDTO ToTouristyPlaces_TripPlanGetDTO(TouristyPlaces_TripPlanEntity touristyPlaces_tripPlanEntity) {
        if ( touristyPlaces_tripPlanEntity == null ) {
            return null;
        }

        TouristyPlaces_TripPlanGetDTO.TouristyPlaces_TripPlanGetDTOBuilder touristyPlaces_TripPlanGetDTO = TouristyPlaces_TripPlanGetDTO.builder();

        touristyPlaces_TripPlanGetDTO.touristyPlaces_tripPlanId( touristyPlaces_tripPlanEntity.getTouristyPlaces_tripPlanId() );
        touristyPlaces_TripPlanGetDTO.tripPlanId( touristyPlaces_tripPlanEntity.getTripPlanId() );
        touristyPlaces_TripPlanGetDTO.touristyPlacesId( touristyPlaces_tripPlanEntity.getTouristyPlacesId() );
        touristyPlaces_TripPlanGetDTO.createdAt( touristyPlaces_tripPlanEntity.getCreatedAt() );
        touristyPlaces_TripPlanGetDTO.updatedAt( touristyPlaces_tripPlanEntity.getUpdatedAt() );

        return touristyPlaces_TripPlanGetDTO.build();
    }

    @Override
    public TouristyPlaces_TripPlanUpdateDTO ToTouristyPlaces_TripPlanUpdateDTO(TouristyPlaces_TripPlanEntity touristyPlaces_tripPlanEntity) {
        if ( touristyPlaces_tripPlanEntity == null ) {
            return null;
        }

        TouristyPlaces_TripPlanUpdateDTO.TouristyPlaces_TripPlanUpdateDTOBuilder touristyPlaces_TripPlanUpdateDTO = TouristyPlaces_TripPlanUpdateDTO.builder();

        touristyPlaces_TripPlanUpdateDTO.touristyPlaces_tripPlanId( touristyPlaces_tripPlanEntity.getTouristyPlaces_tripPlanId() );
        touristyPlaces_TripPlanUpdateDTO.tripPlanId( touristyPlaces_tripPlanEntity.getTripPlanId() );
        touristyPlaces_TripPlanUpdateDTO.touristyPlacesId( touristyPlaces_tripPlanEntity.getTouristyPlacesId() );
        touristyPlaces_TripPlanUpdateDTO.updatedAt( touristyPlaces_tripPlanEntity.getUpdatedAt() );

        return touristyPlaces_TripPlanUpdateDTO.build();
    }
}
