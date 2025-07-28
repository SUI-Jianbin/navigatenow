package com.navigatenow.navigatenowproject.Service;

import com.navigatenow.navigatenowproject.Model.DTO.ChecklistDTOs.ChecklistGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ChecklistDTOs.ChecklistPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ChecklistDTOs.ChecklistUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChecklistServices {
    ChecklistPostDTO addChecklist(ChecklistPostDTO ChecklistPostDTO);
    ChecklistGetDTO getChecklistById(Integer id);
    List<ChecklistGetDTO> getAllChecklist();
    String deleteChecklist(Integer id);
    ChecklistUpdateDTO updateChecklist(ChecklistUpdateDTO checklistUpdateDTO);
    List<ChecklistGetDTO> getChecklistsByTripPlanId(Integer tripPlanId);
    Boolean checkIfTripPlanHasCheckList(Integer tripplanid);


}
