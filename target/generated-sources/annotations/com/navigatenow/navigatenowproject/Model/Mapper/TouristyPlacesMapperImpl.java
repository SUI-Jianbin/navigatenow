package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs.TouristyPlacesGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs.TouristyPlacesPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs.TouristyPlacesUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.TouristyPlacesEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-28T20:10:08+1000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class TouristyPlacesMapperImpl implements TouristyPlacesMapper {

    @Override
    public TouristyPlacesEntity ToEntity(TouristyPlacesPostDTO touristyPlacesPostDTO) {
        if ( touristyPlacesPostDTO == null ) {
            return null;
        }

        TouristyPlacesEntity.TouristyPlacesEntityBuilder touristyPlacesEntity = TouristyPlacesEntity.builder();

        touristyPlacesEntity.touristyPlacesId( touristyPlacesPostDTO.getTouristyPlacesId() );
        touristyPlacesEntity.placeName( touristyPlacesPostDTO.getPlaceName() );
        touristyPlacesEntity.placeLocation( touristyPlacesPostDTO.getPlaceLocation() );
        touristyPlacesEntity.placeOpeningDays( touristyPlacesPostDTO.getPlaceOpeningDays() );
        touristyPlacesEntity.placeOpeningTimes( touristyPlacesPostDTO.getPlaceOpeningTimes() );
        touristyPlacesEntity.placeClosingTime( touristyPlacesPostDTO.getPlaceClosingTime() );
        touristyPlacesEntity.placeRate( touristyPlacesPostDTO.getPlaceRate() );
        touristyPlacesEntity.placePicture( touristyPlacesPostDTO.getPlacePicture() );
        touristyPlacesEntity.createdAt( touristyPlacesPostDTO.getCreatedAt() );

        return touristyPlacesEntity.build();
    }

    @Override
    public TouristyPlacesEntity ToEntity(TouristyPlacesUpdateDTO touristyPlacesUpdateDTO) {
        if ( touristyPlacesUpdateDTO == null ) {
            return null;
        }

        TouristyPlacesEntity.TouristyPlacesEntityBuilder touristyPlacesEntity = TouristyPlacesEntity.builder();

        touristyPlacesEntity.touristyPlacesId( touristyPlacesUpdateDTO.getTouristyPlacesId() );
        touristyPlacesEntity.placeName( touristyPlacesUpdateDTO.getPlaceName() );
        touristyPlacesEntity.placeLocation( touristyPlacesUpdateDTO.getPlaceLocation() );
        touristyPlacesEntity.placeOpeningDays( touristyPlacesUpdateDTO.getPlaceOpeningDays() );
        touristyPlacesEntity.placeOpeningTimes( touristyPlacesUpdateDTO.getPlaceOpeningTimes() );
        touristyPlacesEntity.placeClosingTime( touristyPlacesUpdateDTO.getPlaceClosingTime() );
        touristyPlacesEntity.placeRate( touristyPlacesUpdateDTO.getPlaceRate() );
        touristyPlacesEntity.placePicture( touristyPlacesUpdateDTO.getPlacePicture() );
        touristyPlacesEntity.updatedAt( touristyPlacesUpdateDTO.getUpdatedAt() );

        return touristyPlacesEntity.build();
    }

    @Override
    public TouristyPlacesPostDTO ToTouristyPlacesPostDTO(TouristyPlacesEntity touristyPlacesEntity) {
        if ( touristyPlacesEntity == null ) {
            return null;
        }

        TouristyPlacesPostDTO.TouristyPlacesPostDTOBuilder touristyPlacesPostDTO = TouristyPlacesPostDTO.builder();

        touristyPlacesPostDTO.touristyPlacesId( touristyPlacesEntity.getTouristyPlacesId() );
        touristyPlacesPostDTO.placeName( touristyPlacesEntity.getPlaceName() );
        touristyPlacesPostDTO.placeLocation( touristyPlacesEntity.getPlaceLocation() );
        touristyPlacesPostDTO.placeOpeningDays( touristyPlacesEntity.getPlaceOpeningDays() );
        touristyPlacesPostDTO.placeOpeningTimes( touristyPlacesEntity.getPlaceOpeningTimes() );
        touristyPlacesPostDTO.placeClosingTime( touristyPlacesEntity.getPlaceClosingTime() );
        touristyPlacesPostDTO.placeRate( touristyPlacesEntity.getPlaceRate() );
        touristyPlacesPostDTO.placePicture( touristyPlacesEntity.getPlacePicture() );
        touristyPlacesPostDTO.createdAt( touristyPlacesEntity.getCreatedAt() );

        return touristyPlacesPostDTO.build();
    }

    @Override
    public TouristyPlacesGetDTO ToTouristyPlacesGetDTO(TouristyPlacesEntity touristyPlacesEntity) {
        if ( touristyPlacesEntity == null ) {
            return null;
        }

        TouristyPlacesGetDTO.TouristyPlacesGetDTOBuilder touristyPlacesGetDTO = TouristyPlacesGetDTO.builder();

        touristyPlacesGetDTO.touristyPlacesId( touristyPlacesEntity.getTouristyPlacesId() );
        touristyPlacesGetDTO.placeName( touristyPlacesEntity.getPlaceName() );
        touristyPlacesGetDTO.placeLocation( touristyPlacesEntity.getPlaceLocation() );
        touristyPlacesGetDTO.placeOpeningDays( touristyPlacesEntity.getPlaceOpeningDays() );
        touristyPlacesGetDTO.placeOpeningTimes( touristyPlacesEntity.getPlaceOpeningTimes() );
        touristyPlacesGetDTO.placeClosingTime( touristyPlacesEntity.getPlaceClosingTime() );
        touristyPlacesGetDTO.placeRate( touristyPlacesEntity.getPlaceRate() );
        touristyPlacesGetDTO.placePicture( touristyPlacesEntity.getPlacePicture() );
        touristyPlacesGetDTO.userIntrestEntity( touristyPlacesEntity.getUserIntrestEntity() );
        touristyPlacesGetDTO.createdAt( touristyPlacesEntity.getCreatedAt() );

        return touristyPlacesGetDTO.build();
    }

    @Override
    public TouristyPlacesUpdateDTO ToTouristyPlacesUpdateDTO(TouristyPlacesEntity touristyPlacesEntity) {
        if ( touristyPlacesEntity == null ) {
            return null;
        }

        TouristyPlacesUpdateDTO.TouristyPlacesUpdateDTOBuilder touristyPlacesUpdateDTO = TouristyPlacesUpdateDTO.builder();

        touristyPlacesUpdateDTO.touristyPlacesId( touristyPlacesEntity.getTouristyPlacesId() );
        touristyPlacesUpdateDTO.placeName( touristyPlacesEntity.getPlaceName() );
        touristyPlacesUpdateDTO.placeLocation( touristyPlacesEntity.getPlaceLocation() );
        touristyPlacesUpdateDTO.placeOpeningDays( touristyPlacesEntity.getPlaceOpeningDays() );
        touristyPlacesUpdateDTO.placeOpeningTimes( touristyPlacesEntity.getPlaceOpeningTimes() );
        touristyPlacesUpdateDTO.placeClosingTime( touristyPlacesEntity.getPlaceClosingTime() );
        touristyPlacesUpdateDTO.placeRate( touristyPlacesEntity.getPlaceRate() );
        touristyPlacesUpdateDTO.placePicture( touristyPlacesEntity.getPlacePicture() );
        touristyPlacesUpdateDTO.updatedAt( touristyPlacesEntity.getUpdatedAt() );

        return touristyPlacesUpdateDTO.build();
    }
}
