package com.navigatenow.navigatenowproject.Service.Impl;

import com.navigatenow.navigatenowproject.Model.DTO.ChecklistDTOs.ChecklistGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ChecklistDTOs.ChecklistPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ChecklistDTOs.ChecklistUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackGetDTO;
import com.navigatenow.navigatenowproject.Model.Entity.*;
import com.navigatenow.navigatenowproject.Repository.ChecklistRepo;
import com.navigatenow.navigatenowproject.Model.Mapper.ChecklistMapper;
import com.navigatenow.navigatenowproject.Service.ChecklistServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChecklistServicesImpl implements ChecklistServices{
    private final ChecklistRepo checklistRepo;
    private final ChecklistMapper checklistMapper;

    @Override
    public ChecklistPostDTO addChecklist(ChecklistPostDTO ChecklistPostDTO) {
        ChecklistEntity entity = this.checklistMapper.ToEntity(ChecklistPostDTO);
        TripPlanEntity tripPlan = new TripPlanEntity();
        tripPlan.setTripPlanId(ChecklistPostDTO.getTripplan_id());
        entity.setTripPlanEntity(tripPlan);
        this.checklistRepo.save(entity);
        return ChecklistPostDTO;
    }

    @Override
    public ChecklistGetDTO getChecklistById(Integer id) {
        Optional<ChecklistEntity> entity = this.checklistRepo.getChecklistEntityByChecklistId(id);
        if (entity.isPresent()){
            return this.checklistMapper.ToChecklistGetDTO(entity.get());
        }else {
            return null;
        }
    }

    @Override
    public List<ChecklistGetDTO> getAllChecklist() {
        List<ChecklistEntity> checklistEntities = this.checklistRepo.findAll();
        if(checklistEntities.isEmpty()){
            return null;
        }
        else {
            List<ChecklistGetDTO> checklistGetDTOS = new ArrayList<>();
            checklistEntities.forEach(entity -> {
                checklistGetDTOS.add(this.checklistMapper.ToChecklistGetDTO(entity));
            });
            return checklistGetDTOS;
        }
    }

    @Override
    public String deleteChecklist(Integer id) {
        Optional<ChecklistEntity> checklistEntity = this.checklistRepo.findByChecklistIdAndDeletedAtIsNull(id);
        if (checklistEntity.isPresent()) {
            checklistEntity.get().setDeletedAt(LocalDateTime.now());
            this.checklistRepo.save(checklistEntity.get());
            return "Checklist has deleted Successfully";
        } else {
            return "user not exist";
        }
    }

    @Override
    public ChecklistUpdateDTO updateChecklist(ChecklistUpdateDTO checklistUpdateDTO) {
        ChecklistEntity entity = this.checklistMapper.ToEntity(checklistUpdateDTO);
        this.checklistRepo.updateChecklistNativeQuery(entity.getChecklistId(), entity.getItemName(),
                entity.getItemDescription(), entity.getItemImportance(), entity.getUpdatedAt());
        return checklistUpdateDTO;
    }

    @Override
    public List<ChecklistGetDTO> getChecklistsByTripPlanId(Integer tripPlanId) {
        List<ChecklistEntity> checklistEntities = this.checklistRepo.getChecklistEntitiesByTripPlanId(tripPlanId);
        if (checklistEntities.isEmpty()) {
            return null;
        } else {
            List<ChecklistGetDTO> checklistGetDTOS = new ArrayList<>();
            checklistEntities.forEach(entity -> {
                checklistGetDTOS.add(this.checklistMapper.ToChecklistGetDTO(entity));
            });
            return checklistGetDTOS;
        }
    }

    @Override
    public Boolean checkIfTripPlanHasCheckList(Integer tripplanid) {
        List<ChecklistEntity> checklistEntities = this.checklistRepo.checkIfTripPlanHasCheckList(tripplanid);
        if (!checklistEntities.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
