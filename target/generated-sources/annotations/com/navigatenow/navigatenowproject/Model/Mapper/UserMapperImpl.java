package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserLoginDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserUpdateWithoutPasswordDTO;
import com.navigatenow.navigatenowproject.Model.Entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-28T20:10:08+1000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity ToEntity(UserPostDTO userPostDTO) {
        if ( userPostDTO == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.userId( userPostDTO.getUserId() );
        userEntity.firstName( userPostDTO.getFirstName() );
        userEntity.lastName( userPostDTO.getLastName() );
        userEntity.userName( userPostDTO.getUserName() );
        userEntity.password( userPostDTO.getPassword() );
        userEntity.email( userPostDTO.getEmail() );
        userEntity.age( userPostDTO.getAge() );
        userEntity.contactNumber( userPostDTO.getContactNumber() );
        userEntity.gender( userPostDTO.getGender() );
        userEntity.dateOfBirth( userPostDTO.getDateOfBirth() );
        userEntity.nationality( userPostDTO.getNationality() );
        userEntity.createdAt( userPostDTO.getCreatedAt() );

        return userEntity.build();
    }

    @Override
    public UserEntity ToEntity(UserUpdateDTO userUpdateDTO) {
        if ( userUpdateDTO == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.userId( userUpdateDTO.getUserId() );
        userEntity.firstName( userUpdateDTO.getFirstName() );
        userEntity.lastName( userUpdateDTO.getLastName() );
        userEntity.userName( userUpdateDTO.getUserName() );
        userEntity.password( userUpdateDTO.getPassword() );
        userEntity.email( userUpdateDTO.getEmail() );
        userEntity.age( userUpdateDTO.getAge() );
        userEntity.contactNumber( userUpdateDTO.getContactNumber() );
        userEntity.gender( userUpdateDTO.getGender() );
        userEntity.dateOfBirth( userUpdateDTO.getDateOfBirth() );
        userEntity.nationality( userUpdateDTO.getNationality() );
        userEntity.updatedAt( userUpdateDTO.getUpdatedAt() );

        return userEntity.build();
    }

    @Override
    public UserEntity ToEntity(UserGetDTO userGetDTO) {
        if ( userGetDTO == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.userId( userGetDTO.getUserId() );
        userEntity.firstName( userGetDTO.getFirstName() );
        userEntity.lastName( userGetDTO.getLastName() );
        userEntity.userName( userGetDTO.getUserName() );
        userEntity.password( userGetDTO.getPassword() );
        userEntity.email( userGetDTO.getEmail() );
        userEntity.age( userGetDTO.getAge() );
        userEntity.contactNumber( userGetDTO.getContactNumber() );
        userEntity.gender( userGetDTO.getGender() );
        userEntity.dateOfBirth( userGetDTO.getDateOfBirth() );
        userEntity.nationality( userGetDTO.getNationality() );
        userEntity.createdAt( userGetDTO.getCreatedAt() );
        userEntity.updatedAt( userGetDTO.getUpdatedAt() );

        return userEntity.build();
    }

    @Override
    public UserEntity ToEntity(UserUpdateWithoutPasswordDTO userUpdateWithoutPasswordDTO) {
        if ( userUpdateWithoutPasswordDTO == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.userId( userUpdateWithoutPasswordDTO.getUserId() );
        userEntity.firstName( userUpdateWithoutPasswordDTO.getFirstName() );
        userEntity.lastName( userUpdateWithoutPasswordDTO.getLastName() );
        userEntity.email( userUpdateWithoutPasswordDTO.getEmail() );
        userEntity.age( userUpdateWithoutPasswordDTO.getAge() );
        userEntity.contactNumber( userUpdateWithoutPasswordDTO.getContactNumber() );
        userEntity.gender( userUpdateWithoutPasswordDTO.getGender() );
        userEntity.dateOfBirth( userUpdateWithoutPasswordDTO.getDateOfBirth() );
        userEntity.nationality( userUpdateWithoutPasswordDTO.getNationality() );
        userEntity.updatedAt( userUpdateWithoutPasswordDTO.getUpdatedAt() );

        return userEntity.build();
    }

    @Override
    public UserPostDTO ToUserPostDTO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserPostDTO.UserPostDTOBuilder userPostDTO = UserPostDTO.builder();

        userPostDTO.userId( userEntity.getUserId() );
        userPostDTO.firstName( userEntity.getFirstName() );
        userPostDTO.lastName( userEntity.getLastName() );
        userPostDTO.userName( userEntity.getUserName() );
        userPostDTO.password( userEntity.getPassword() );
        userPostDTO.email( userEntity.getEmail() );
        userPostDTO.age( userEntity.getAge() );
        userPostDTO.contactNumber( userEntity.getContactNumber() );
        userPostDTO.gender( userEntity.getGender() );
        userPostDTO.dateOfBirth( userEntity.getDateOfBirth() );
        userPostDTO.nationality( userEntity.getNationality() );
        userPostDTO.createdAt( userEntity.getCreatedAt() );

        return userPostDTO.build();
    }

    @Override
    public UserGetDTO ToUserGetDTO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserGetDTO.UserGetDTOBuilder userGetDTO = UserGetDTO.builder();

        userGetDTO.userId( userEntity.getUserId() );
        userGetDTO.firstName( userEntity.getFirstName() );
        userGetDTO.lastName( userEntity.getLastName() );
        userGetDTO.userName( userEntity.getUserName() );
        userGetDTO.password( userEntity.getPassword() );
        userGetDTO.email( userEntity.getEmail() );
        userGetDTO.age( userEntity.getAge() );
        userGetDTO.contactNumber( userEntity.getContactNumber() );
        userGetDTO.gender( userEntity.getGender() );
        userGetDTO.dateOfBirth( userEntity.getDateOfBirth() );
        userGetDTO.nationality( userEntity.getNationality() );
        userGetDTO.createdAt( userEntity.getCreatedAt() );
        userGetDTO.updatedAt( userEntity.getUpdatedAt() );

        return userGetDTO.build();
    }

    @Override
    public UserUpdateDTO ToUserUpdateDTO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserUpdateDTO.UserUpdateDTOBuilder userUpdateDTO = UserUpdateDTO.builder();

        userUpdateDTO.userId( userEntity.getUserId() );
        userUpdateDTO.firstName( userEntity.getFirstName() );
        userUpdateDTO.lastName( userEntity.getLastName() );
        userUpdateDTO.userName( userEntity.getUserName() );
        userUpdateDTO.password( userEntity.getPassword() );
        userUpdateDTO.email( userEntity.getEmail() );
        userUpdateDTO.age( userEntity.getAge() );
        userUpdateDTO.contactNumber( userEntity.getContactNumber() );
        userUpdateDTO.gender( userEntity.getGender() );
        userUpdateDTO.dateOfBirth( userEntity.getDateOfBirth() );
        userUpdateDTO.nationality( userEntity.getNationality() );
        userUpdateDTO.updatedAt( userEntity.getUpdatedAt() );

        return userUpdateDTO.build();
    }

    @Override
    public UserUpdateWithoutPasswordDTO ToUserUpdateWithoutPasswordDTODTO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserUpdateWithoutPasswordDTO.UserUpdateWithoutPasswordDTOBuilder userUpdateWithoutPasswordDTO = UserUpdateWithoutPasswordDTO.builder();

        userUpdateWithoutPasswordDTO.userId( userEntity.getUserId() );
        userUpdateWithoutPasswordDTO.firstName( userEntity.getFirstName() );
        userUpdateWithoutPasswordDTO.lastName( userEntity.getLastName() );
        userUpdateWithoutPasswordDTO.email( userEntity.getEmail() );
        userUpdateWithoutPasswordDTO.age( userEntity.getAge() );
        userUpdateWithoutPasswordDTO.contactNumber( userEntity.getContactNumber() );
        userUpdateWithoutPasswordDTO.gender( userEntity.getGender() );
        userUpdateWithoutPasswordDTO.dateOfBirth( userEntity.getDateOfBirth() );
        userUpdateWithoutPasswordDTO.nationality( userEntity.getNationality() );
        userUpdateWithoutPasswordDTO.updatedAt( userEntity.getUpdatedAt() );

        return userUpdateWithoutPasswordDTO.build();
    }

    @Override
    public UserLoginDTO ToUserLoginDTO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserLoginDTO.UserLoginDTOBuilder userLoginDTO = UserLoginDTO.builder();

        userLoginDTO.userId( userEntity.getUserId() );

        return userLoginDTO.build();
    }
}
