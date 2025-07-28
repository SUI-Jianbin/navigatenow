package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.ChecklistDTOs.ChecklistGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ChecklistDTOs.ChecklistPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ChecklistDTOs.ChecklistUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.ChecklistEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-28T20:10:08+1000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class ChecklistMapperImpl implements ChecklistMapper {

    @Override
    public ChecklistEntity ToEntity(ChecklistPostDTO checklistPostDTO) {
        if ( checklistPostDTO == null ) {
            return null;
        }

        ChecklistEntity.ChecklistEntityBuilder checklistEntity = ChecklistEntity.builder();

        checklistEntity.checklistId( checklistPostDTO.getChecklistId() );
        checklistEntity.itemName( checklistPostDTO.getItemName() );
        checklistEntity.itemDescription( checklistPostDTO.getItemDescription() );
        checklistEntity.itemImportance( checklistPostDTO.getItemImportance() );
        checklistEntity.createdAt( checklistPostDTO.getCreatedAt() );

        return checklistEntity.build();
    }

    @Override
    public ChecklistEntity ToEntity(ChecklistUpdateDTO checklistUpdateDTO) {
        if ( checklistUpdateDTO == null ) {
            return null;
        }

        ChecklistEntity.ChecklistEntityBuilder checklistEntity = ChecklistEntity.builder();

        checklistEntity.checklistId( checklistUpdateDTO.getChecklistId() );
        checklistEntity.itemName( checklistUpdateDTO.getItemName() );
        checklistEntity.itemDescription( checklistUpdateDTO.getItemDescription() );
        checklistEntity.itemImportance( checklistUpdateDTO.getItemImportance() );
        checklistEntity.updatedAt( checklistUpdateDTO.getUpdatedAt() );

        return checklistEntity.build();
    }

    @Override
    public ChecklistPostDTO ToChecklistPostDTO(ChecklistEntity checklistEntity) {
        if ( checklistEntity == null ) {
            return null;
        }

        ChecklistPostDTO.ChecklistPostDTOBuilder checklistPostDTO = ChecklistPostDTO.builder();

        checklistPostDTO.checklistId( checklistEntity.getChecklistId() );
        checklistPostDTO.itemName( checklistEntity.getItemName() );
        checklistPostDTO.itemDescription( checklistEntity.getItemDescription() );
        checklistPostDTO.itemImportance( checklistEntity.getItemImportance() );
        checklistPostDTO.createdAt( checklistEntity.getCreatedAt() );

        return checklistPostDTO.build();
    }

    @Override
    public ChecklistGetDTO ToChecklistGetDTO(ChecklistEntity checklistEntity) {
        if ( checklistEntity == null ) {
            return null;
        }

        ChecklistGetDTO.ChecklistGetDTOBuilder checklistGetDTO = ChecklistGetDTO.builder();

        checklistGetDTO.checklistId( checklistEntity.getChecklistId() );
        checklistGetDTO.itemName( checklistEntity.getItemName() );
        checklistGetDTO.itemDescription( checklistEntity.getItemDescription() );
        checklistGetDTO.itemImportance( checklistEntity.getItemImportance() );
        checklistGetDTO.createdAt( checklistEntity.getCreatedAt() );
        checklistGetDTO.tripPlanEntity( checklistEntity.getTripPlanEntity() );

        return checklistGetDTO.build();
    }

    @Override
    public ChecklistUpdateDTO ToChecklistUpdateDTO(ChecklistEntity checklistEntity) {
        if ( checklistEntity == null ) {
            return null;
        }

        ChecklistUpdateDTO.ChecklistUpdateDTOBuilder checklistUpdateDTO = ChecklistUpdateDTO.builder();

        checklistUpdateDTO.checklistId( checklistEntity.getChecklistId() );
        checklistUpdateDTO.itemName( checklistEntity.getItemName() );
        checklistUpdateDTO.itemDescription( checklistEntity.getItemDescription() );
        checklistUpdateDTO.itemImportance( checklistEntity.getItemImportance() );
        checklistUpdateDTO.updatedAt( checklistEntity.getUpdatedAt() );

        return checklistUpdateDTO.build();
    }
}
