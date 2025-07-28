package com.navigatenow.navigatenowproject.Service.Impl;

import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackGetDTO;
import com.navigatenow.navigatenowproject.Model.Entity.ContactUsEntity;
import com.navigatenow.navigatenowproject.Model.Entity.FeedbackEntity;
import com.navigatenow.navigatenowproject.Model.Mapper.ContactUsMapper;
import com.navigatenow.navigatenowproject.Model.Mapper.FeedBackMapper;
import com.navigatenow.navigatenowproject.Repository.ContactUsRepo;
import com.navigatenow.navigatenowproject.Repository.FeedBackRepo;
import com.navigatenow.navigatenowproject.Service.ContactUsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactUsServicesImpl implements ContactUsServices {
    private final ContactUsRepo contactUsRepo;
    private final ContactUsMapper contactUsMapper;
    @Override
    public ContactUsPostDTO addContactUs(ContactUsPostDTO ContactUsPostDTO) {
        ContactUsEntity entity = this.contactUsMapper.ToEntity(ContactUsPostDTO);
        this.contactUsRepo.save(entity);
        return ContactUsPostDTO;
    }

    @Override
    public ContactUsGetDTO getContactUsById(Integer id) {
        Optional<ContactUsEntity> entity = this.contactUsRepo.getContactUsEntityByContactusId(id);
        if (entity.isPresent()){
            return this.contactUsMapper.ToContactUsGetDTO(entity.get());
        }else {
            return null;
        }
    }

    @Override
    public List<ContactUsGetDTO> getAllContactUs() {
        List<ContactUsEntity> contactUsEntities = this.contactUsRepo.findAll();
        if(contactUsEntities.isEmpty()){
            return null;
        }
        else {
            List<ContactUsGetDTO> contactUsGetDTOS = new ArrayList<>();
            contactUsEntities.forEach(entity -> {
                contactUsGetDTOS.add(this.contactUsMapper.ToContactUsGetDTO(entity));
            });
            return contactUsGetDTOS;
        }
    }
}
