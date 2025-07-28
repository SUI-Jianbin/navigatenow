package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.UserIntrestEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-28T20:10:08+1000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class UserIntrestMapperImpl implements UserIntrestMapper {

    @Override
    public UserIntrestEntity ToEntity(UserIntrestPostDTO userIntrestPostDTO) {
        if ( userIntrestPostDTO == null ) {
            return null;
        }

        UserIntrestEntity.UserIntrestEntityBuilder userIntrestEntity = UserIntrestEntity.builder();

        userIntrestEntity.userintrestId( userIntrestPostDTO.getUserintrestId() );
        userIntrestEntity.intrestDescription( userIntrestPostDTO.getIntrestDescription() );
        userIntrestEntity.intrestValue( userIntrestPostDTO.getIntrestValue() );
        userIntrestEntity.createdAt( userIntrestPostDTO.getCreatedAt() );

        return userIntrestEntity.build();
    }

    @Override
    public UserIntrestEntity ToEntity(UserIntrestUpdateDTO userIntrestUpdateDTO) {
        if ( userIntrestUpdateDTO == null ) {
            return null;
        }

        UserIntrestEntity.UserIntrestEntityBuilder userIntrestEntity = UserIntrestEntity.builder();

        userIntrestEntity.userintrestId( userIntrestUpdateDTO.getUserintrestId() );
        userIntrestEntity.intrestDescription( userIntrestUpdateDTO.getIntrestDescription() );
        userIntrestEntity.intrestValue( userIntrestUpdateDTO.getIntrestValue() );
        userIntrestEntity.updatedAt( userIntrestUpdateDTO.getUpdatedAt() );

        return userIntrestEntity.build();
    }

    @Override
    public UserIntrestPostDTO ToUserIntrestPostDTO(UserIntrestEntity userIntrestEntity) {
        if ( userIntrestEntity == null ) {
            return null;
        }

        UserIntrestPostDTO.UserIntrestPostDTOBuilder userIntrestPostDTO = UserIntrestPostDTO.builder();

        userIntrestPostDTO.userintrestId( userIntrestEntity.getUserintrestId() );
        userIntrestPostDTO.intrestDescription( userIntrestEntity.getIntrestDescription() );
        userIntrestPostDTO.intrestValue( userIntrestEntity.getIntrestValue() );
        userIntrestPostDTO.createdAt( userIntrestEntity.getCreatedAt() );

        return userIntrestPostDTO.build();
    }

    @Override
    public UserIntrestGetDTO ToUserIntrestGetDTO(UserIntrestEntity userIntrestEntity) {
        if ( userIntrestEntity == null ) {
            return null;
        }

        UserIntrestGetDTO.UserIntrestGetDTOBuilder userIntrestGetDTO = UserIntrestGetDTO.builder();

        userIntrestGetDTO.userintrestId( userIntrestEntity.getUserintrestId() );
        userIntrestGetDTO.intrestDescription( userIntrestEntity.getIntrestDescription() );
        userIntrestGetDTO.intrestValue( userIntrestEntity.getIntrestValue() );
        userIntrestGetDTO.createdAt( userIntrestEntity.getCreatedAt() );
        userIntrestGetDTO.updatedAt( userIntrestEntity.getUpdatedAt() );

        return userIntrestGetDTO.build();
    }

    @Override
    public UserIntrestUpdateDTO ToUserIntrestUpdateDTO(UserIntrestEntity userIntrestEntity) {
        if ( userIntrestEntity == null ) {
            return null;
        }

        UserIntrestUpdateDTO.UserIntrestUpdateDTOBuilder userIntrestUpdateDTO = UserIntrestUpdateDTO.builder();

        userIntrestUpdateDTO.userintrestId( userIntrestEntity.getUserintrestId() );
        userIntrestUpdateDTO.intrestDescription( userIntrestEntity.getIntrestDescription() );
        userIntrestUpdateDTO.intrestValue( userIntrestEntity.getIntrestValue() );
        userIntrestUpdateDTO.updatedAt( userIntrestEntity.getUpdatedAt() );

        return userIntrestUpdateDTO.build();
    }
}
