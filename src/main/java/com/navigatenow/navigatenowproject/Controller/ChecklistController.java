package com.navigatenow.navigatenowproject.Controller;

import com.navigatenow.navigatenowproject.Model.DTO.ChecklistDTOs.ChecklistGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ChecklistDTOs.ChecklistPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ChecklistDTOs.ChecklistUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanUpdateDTO;
import com.navigatenow.navigatenowproject.Service.Impl.ChecklistServicesImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/checklists")
@CrossOrigin
@RequiredArgsConstructor
public class ChecklistController {
    public final ChecklistServicesImpl checklistServices;

    @PostMapping(path = "/checklist/add-checklist")
    public ChecklistPostDTO addChecklist(@RequestBody @Valid ChecklistPostDTO checklistPostDTO){
        return this.checklistServices.addChecklist(checklistPostDTO);
    }

    @GetMapping(path = "/checklist/get-checklistbyid/{id}")
    public ChecklistGetDTO getChecklistById(@PathVariable Integer id){
        return this.checklistServices.getChecklistById(id);
    }

    @GetMapping(path = "/checklist/checkif-userhas-checklist-bytripplanid/{tripplanid}")
    public Boolean checkIfTripPlanHasCheckList(@PathVariable Integer tripplanid){
        return this.checklistServices.checkIfTripPlanHasCheckList(tripplanid);
    }

    @GetMapping(path = "/checklist/get-allchecklist")
    public List<ChecklistGetDTO> getAllChecklist(){
        return this.checklistServices.getAllChecklist();
    }

    @PutMapping(path = "/checklist/update-checklist")
    public ChecklistUpdateDTO updateChecklist(@RequestBody @Valid ChecklistUpdateDTO checklistUpdateDTO){
        return this.checklistServices.updateChecklist(checklistUpdateDTO);
    }

    @DeleteMapping(path = "/checklist/delete-checklistbyid/{id}")
    public String deleteChecklist(@PathVariable Integer id) {
        return this.checklistServices.deleteChecklist(id);
    }

    @GetMapping(path = "/checklist/get-checklistbytripplanid/{tripplanid}")
    public List<ChecklistGetDTO> getChecklistsByTripPlanId(@PathVariable Integer tripplanid){
        return this.checklistServices.getChecklistsByTripPlanId(tripplanid);
    }
}
