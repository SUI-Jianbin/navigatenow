package com.navigatenow.navigatenowproject.Service;

import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactUsServices {
    ContactUsPostDTO addContactUs(ContactUsPostDTO ContactUsPostDTO);
    ContactUsGetDTO getContactUsById(Integer id);
    List<ContactUsGetDTO> getAllContactUs();

}
