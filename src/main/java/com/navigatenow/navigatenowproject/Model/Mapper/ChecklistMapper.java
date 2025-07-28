package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.ChecklistDTOs.ChecklistGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ChecklistDTOs.ChecklistPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ChecklistDTOs.ChecklistUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.ChecklistEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChecklistMapper {
    // Convert ChecklistPostDTO to ChecklistEntity
    ChecklistEntity ToEntity(ChecklistPostDTO checklistPostDTO);
    ChecklistEntity ToEntity(ChecklistUpdateDTO checklistUpdateDTO);

    // Convert ChecklistEntity to ChecklistPostDTO
    ChecklistPostDTO ToChecklistPostDTO(ChecklistEntity checklistEntity);
    // Convert ChecklistEntity to ChecklistGetDTO
    ChecklistGetDTO ToChecklistGetDTO(ChecklistEntity checklistEntity);
    ChecklistUpdateDTO ToChecklistUpdateDTO(ChecklistEntity checklistEntity);
}
