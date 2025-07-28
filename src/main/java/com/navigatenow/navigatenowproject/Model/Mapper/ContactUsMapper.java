package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsPostDTO;
import com.navigatenow.navigatenowproject.Model.Entity.ContactUsEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactUsMapper {

    // Convert ContactUsPostDTO to ContactUsEntity
    ContactUsEntity ToEntity(ContactUsPostDTO contactUsPostDTO);
    ContactUsEntity ToEntity(ContactUsGetDTO contactUsGetDTO);

    // Convert ContactUsEntity to ContactUsPostDTO
    ContactUsPostDTO ToContactUsPostDTO(ContactUsEntity contactUsEntity);
    // Convert ContactUsEntity to ContactUsGetDTO
    ContactUsGetDTO ToContactUsGetDTO(ContactUsEntity contactUsEntity);
}
