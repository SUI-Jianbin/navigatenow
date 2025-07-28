package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.DeleteUser_UserIntrestDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.User_UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.User_UserIntrestPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.User_UserIntrestUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.UserIntrestEntity;
import com.navigatenow.navigatenowproject.Model.Entity.User_UserIntrestEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-28T20:10:08+1000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class User_UserIntrestMapperImpl implements User_UserIntrestMapper {

    @Override
    public User_UserIntrestEntity ToEntity(User_UserIntrestPostDTO user_userIntrestPostDTO) {
        if ( user_userIntrestPostDTO == null ) {
            return null;
        }

        User_UserIntrestEntity.User_UserIntrestEntityBuilder user_UserIntrestEntity = User_UserIntrestEntity.builder();

        user_UserIntrestEntity.userUserintrestId( user_userIntrestPostDTO.getUserUserintrestId() );
        user_UserIntrestEntity.userId( user_userIntrestPostDTO.getUserId() );
        user_UserIntrestEntity.userintrestId( user_userIntrestPostDTO.getUserintrestId() );
        user_UserIntrestEntity.createdAt( user_userIntrestPostDTO.getCreatedAt() );

        return user_UserIntrestEntity.build();
    }

    @Override
    public User_UserIntrestEntity ToEntity(User_UserIntrestUpdateDTO user_userIntrestUpdateDTO) {
        if ( user_userIntrestUpdateDTO == null ) {
            return null;
        }

        User_UserIntrestEntity.User_UserIntrestEntityBuilder user_UserIntrestEntity = User_UserIntrestEntity.builder();

        user_UserIntrestEntity.userUserintrestId( user_userIntrestUpdateDTO.getUserUserintrestId() );
        user_UserIntrestEntity.userId( user_userIntrestUpdateDTO.getUserId() );
        user_UserIntrestEntity.userintrestId( user_userIntrestUpdateDTO.getUserintrestId() );
        user_UserIntrestEntity.updatedAt( user_userIntrestUpdateDTO.getUpdatedAt() );

        return user_UserIntrestEntity.build();
    }

    @Override
    public User_UserIntrestEntity ToEntity(DeleteUser_UserIntrestDTO deleteUserUserIntrestDTO) {
        if ( deleteUserUserIntrestDTO == null ) {
            return null;
        }

        User_UserIntrestEntity.User_UserIntrestEntityBuilder user_UserIntrestEntity = User_UserIntrestEntity.builder();

        user_UserIntrestEntity.userUserintrestId( deleteUserUserIntrestDTO.getUserUserintrestId() );
        user_UserIntrestEntity.userId( deleteUserUserIntrestDTO.getUserId() );
        user_UserIntrestEntity.userintrestId( deleteUserUserIntrestDTO.getUserintrestId() );
        user_UserIntrestEntity.deletedAt( deleteUserUserIntrestDTO.getDeletedAt() );

        return user_UserIntrestEntity.build();
    }

    @Override
    public User_UserIntrestPostDTO ToUser_UserIntrestPostDTO(User_UserIntrestEntity user_userIntrestEntity) {
        if ( user_userIntrestEntity == null ) {
            return null;
        }

        User_UserIntrestPostDTO.User_UserIntrestPostDTOBuilder user_UserIntrestPostDTO = User_UserIntrestPostDTO.builder();

        user_UserIntrestPostDTO.userUserintrestId( user_userIntrestEntity.getUserUserintrestId() );
        user_UserIntrestPostDTO.userId( user_userIntrestEntity.getUserId() );
        user_UserIntrestPostDTO.userintrestId( user_userIntrestEntity.getUserintrestId() );
        user_UserIntrestPostDTO.createdAt( user_userIntrestEntity.getCreatedAt() );

        return user_UserIntrestPostDTO.build();
    }

    @Override
    public User_UserIntrestGetDTO ToUser_UserIntrestGetDTO(User_UserIntrestEntity user_userIntrestEntity) {
        if ( user_userIntrestEntity == null ) {
            return null;
        }

        User_UserIntrestGetDTO.User_UserIntrestGetDTOBuilder user_UserIntrestGetDTO = User_UserIntrestGetDTO.builder();

        user_UserIntrestGetDTO.userUserintrestId( user_userIntrestEntity.getUserUserintrestId() );
        user_UserIntrestGetDTO.userId( user_userIntrestEntity.getUserId() );
        user_UserIntrestGetDTO.userintrestId( user_userIntrestEntity.getUserintrestId() );
        user_UserIntrestGetDTO.createdAt( user_userIntrestEntity.getCreatedAt() );
        user_UserIntrestGetDTO.updatedAt( user_userIntrestEntity.getUpdatedAt() );
        user_UserIntrestGetDTO.userIntrestEntity( userIntrestEntityToUserIntrestGetDTO( user_userIntrestEntity.getUserIntrestEntity() ) );

        return user_UserIntrestGetDTO.build();
    }

    @Override
    public User_UserIntrestUpdateDTO ToUser_UserIntrestUpdateDTO(User_UserIntrestEntity user_userIntrestEntity) {
        if ( user_userIntrestEntity == null ) {
            return null;
        }

        User_UserIntrestUpdateDTO.User_UserIntrestUpdateDTOBuilder user_UserIntrestUpdateDTO = User_UserIntrestUpdateDTO.builder();

        user_UserIntrestUpdateDTO.userUserintrestId( user_userIntrestEntity.getUserUserintrestId() );
        user_UserIntrestUpdateDTO.userId( user_userIntrestEntity.getUserId() );
        user_UserIntrestUpdateDTO.userintrestId( user_userIntrestEntity.getUserintrestId() );
        user_UserIntrestUpdateDTO.updatedAt( user_userIntrestEntity.getUpdatedAt() );

        return user_UserIntrestUpdateDTO.build();
    }

    @Override
    public DeleteUser_UserIntrestDTO ToDeleteUser_UserIntrestDTO(User_UserIntrestEntity user_userIntrestEntity) {
        if ( user_userIntrestEntity == null ) {
            return null;
        }

        DeleteUser_UserIntrestDTO.DeleteUser_UserIntrestDTOBuilder deleteUser_UserIntrestDTO = DeleteUser_UserIntrestDTO.builder();

        deleteUser_UserIntrestDTO.userUserintrestId( user_userIntrestEntity.getUserUserintrestId() );
        deleteUser_UserIntrestDTO.userId( user_userIntrestEntity.getUserId() );
        deleteUser_UserIntrestDTO.userintrestId( user_userIntrestEntity.getUserintrestId() );
        deleteUser_UserIntrestDTO.deletedAt( user_userIntrestEntity.getDeletedAt() );

        return deleteUser_UserIntrestDTO.build();
    }

    protected UserIntrestGetDTO userIntrestEntityToUserIntrestGetDTO(UserIntrestEntity userIntrestEntity) {
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
}
