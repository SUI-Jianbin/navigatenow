package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsPostDTO;
import com.navigatenow.navigatenowproject.Model.Entity.ContactUsEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-28T20:10:08+1000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class ContactUsMapperImpl implements ContactUsMapper {

    @Override
    public ContactUsEntity ToEntity(ContactUsPostDTO contactUsPostDTO) {
        if ( contactUsPostDTO == null ) {
            return null;
        }

        ContactUsEntity.ContactUsEntityBuilder contactUsEntity = ContactUsEntity.builder();

        contactUsEntity.contactusId( contactUsPostDTO.getContactusId() );
        contactUsEntity.firstName( contactUsPostDTO.getFirstName() );
        contactUsEntity.lastName( contactUsPostDTO.getLastName() );
        contactUsEntity.email( contactUsPostDTO.getEmail() );
        contactUsEntity.description( contactUsPostDTO.getDescription() );
        contactUsEntity.createdAt( contactUsPostDTO.getCreatedAt() );

        return contactUsEntity.build();
    }

    @Override
    public ContactUsEntity ToEntity(ContactUsGetDTO contactUsGetDTO) {
        if ( contactUsGetDTO == null ) {
            return null;
        }

        ContactUsEntity.ContactUsEntityBuilder contactUsEntity = ContactUsEntity.builder();

        contactUsEntity.contactusId( contactUsGetDTO.getContactusId() );
        contactUsEntity.firstName( contactUsGetDTO.getFirstName() );
        contactUsEntity.lastName( contactUsGetDTO.getLastName() );
        contactUsEntity.email( contactUsGetDTO.getEmail() );
        contactUsEntity.description( contactUsGetDTO.getDescription() );
        contactUsEntity.createdAt( contactUsGetDTO.getCreatedAt() );

        return contactUsEntity.build();
    }

    @Override
    public ContactUsPostDTO ToContactUsPostDTO(ContactUsEntity contactUsEntity) {
        if ( contactUsEntity == null ) {
            return null;
        }

        ContactUsPostDTO.ContactUsPostDTOBuilder contactUsPostDTO = ContactUsPostDTO.builder();

        contactUsPostDTO.contactusId( contactUsEntity.getContactusId() );
        contactUsPostDTO.firstName( contactUsEntity.getFirstName() );
        contactUsPostDTO.lastName( contactUsEntity.getLastName() );
        contactUsPostDTO.email( contactUsEntity.getEmail() );
        contactUsPostDTO.description( contactUsEntity.getDescription() );
        contactUsPostDTO.createdAt( contactUsEntity.getCreatedAt() );

        return contactUsPostDTO.build();
    }

    @Override
    public ContactUsGetDTO ToContactUsGetDTO(ContactUsEntity contactUsEntity) {
        if ( contactUsEntity == null ) {
            return null;
        }

        ContactUsGetDTO.ContactUsGetDTOBuilder contactUsGetDTO = ContactUsGetDTO.builder();

        contactUsGetDTO.contactusId( contactUsEntity.getContactusId() );
        contactUsGetDTO.firstName( contactUsEntity.getFirstName() );
        contactUsGetDTO.lastName( contactUsEntity.getLastName() );
        contactUsGetDTO.email( contactUsEntity.getEmail() );
        contactUsGetDTO.description( contactUsEntity.getDescription() );
        contactUsGetDTO.createdAt( contactUsEntity.getCreatedAt() );

        return contactUsGetDTO.build();
    }
}
