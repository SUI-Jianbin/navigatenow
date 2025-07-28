package com.navigatenow.navigatenowproject.Controller;

import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackPostDTO;
import com.navigatenow.navigatenowproject.Service.FeedBackServices;
import com.navigatenow.navigatenowproject.Service.Impl.ContactUsServicesImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/contactuss")
@CrossOrigin
@RequiredArgsConstructor
public class ContactUsController {
    public final ContactUsServicesImpl contactUsServices;

    @PostMapping(path = "/contactus/add-contactus")
    public ContactUsPostDTO addContactUs(@RequestBody @Valid ContactUsPostDTO contactUsPostDTO){
        return this.contactUsServices.addContactUs(contactUsPostDTO);
    }

    @GetMapping(path = "/contactus/get-contactusbyid/{id}")
    public ContactUsGetDTO getContactUsById(@PathVariable Integer id){
        return this.contactUsServices.getContactUsById(id);
    }

    @GetMapping(path = "/contactus/get-allcontactus")
    public List<ContactUsGetDTO> getAllContactUs(){
        return this.contactUsServices.getAllContactUs();
    }

}
