package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.ExpencesCalculatorDTOs.ExpencesCalculatorGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ExpencesCalculatorDTOs.ExpencesCalculatorPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ExpencesCalculatorDTOs.ExpencesCalculatorUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.ExpencesCalculatorEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-28T20:10:08+1000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class ExpencesCalculatorMapperImpl implements ExpencesCalculatorMapper {

    @Override
    public ExpencesCalculatorEntity ToEntity(ExpencesCalculatorPostDTO expencesCalculatorPostDTO) {
        if ( expencesCalculatorPostDTO == null ) {
            return null;
        }

        ExpencesCalculatorEntity.ExpencesCalculatorEntityBuilder expencesCalculatorEntity = ExpencesCalculatorEntity.builder();

        expencesCalculatorEntity.expencesCalculatorId( expencesCalculatorPostDTO.getExpencesCalculatorId() );
        expencesCalculatorEntity.name( expencesCalculatorPostDTO.getName() );
        expencesCalculatorEntity.description( expencesCalculatorPostDTO.getDescription() );
        expencesCalculatorEntity.periority( expencesCalculatorPostDTO.getPeriority() );
        expencesCalculatorEntity.price( expencesCalculatorPostDTO.getPrice() );
        expencesCalculatorEntity.totalCost( expencesCalculatorPostDTO.getTotalCost() );
        expencesCalculatorEntity.type( expencesCalculatorPostDTO.getType() );
        expencesCalculatorEntity.createdAt( expencesCalculatorPostDTO.getCreatedAt() );

        return expencesCalculatorEntity.build();
    }

    @Override
    public ExpencesCalculatorEntity ToEntity(ExpencesCalculatorUpdateDTO expencesCalculatorUpdateDTO) {
        if ( expencesCalculatorUpdateDTO == null ) {
            return null;
        }

        ExpencesCalculatorEntity.ExpencesCalculatorEntityBuilder expencesCalculatorEntity = ExpencesCalculatorEntity.builder();

        expencesCalculatorEntity.expencesCalculatorId( expencesCalculatorUpdateDTO.getExpencesCalculatorId() );
        expencesCalculatorEntity.name( expencesCalculatorUpdateDTO.getName() );
        expencesCalculatorEntity.description( expencesCalculatorUpdateDTO.getDescription() );
        expencesCalculatorEntity.periority( expencesCalculatorUpdateDTO.getPeriority() );
        expencesCalculatorEntity.price( expencesCalculatorUpdateDTO.getPrice() );
        expencesCalculatorEntity.totalCost( expencesCalculatorUpdateDTO.getTotalCost() );
        expencesCalculatorEntity.type( expencesCalculatorUpdateDTO.getType() );
        expencesCalculatorEntity.updatedAt( expencesCalculatorUpdateDTO.getUpdatedAt() );

        return expencesCalculatorEntity.build();
    }

    @Override
    public ExpencesCalculatorPostDTO ToExpencesCalculatorPostDTO(ExpencesCalculatorEntity expencesCalculatorEntity) {
        if ( expencesCalculatorEntity == null ) {
            return null;
        }

        ExpencesCalculatorPostDTO.ExpencesCalculatorPostDTOBuilder expencesCalculatorPostDTO = ExpencesCalculatorPostDTO.builder();

        expencesCalculatorPostDTO.expencesCalculatorId( expencesCalculatorEntity.getExpencesCalculatorId() );
        expencesCalculatorPostDTO.name( expencesCalculatorEntity.getName() );
        expencesCalculatorPostDTO.description( expencesCalculatorEntity.getDescription() );
        expencesCalculatorPostDTO.periority( expencesCalculatorEntity.getPeriority() );
        expencesCalculatorPostDTO.price( expencesCalculatorEntity.getPrice() );
        expencesCalculatorPostDTO.totalCost( expencesCalculatorEntity.getTotalCost() );
        expencesCalculatorPostDTO.type( expencesCalculatorEntity.getType() );
        expencesCalculatorPostDTO.createdAt( expencesCalculatorEntity.getCreatedAt() );

        return expencesCalculatorPostDTO.build();
    }

    @Override
    public ExpencesCalculatorGetDTO ToExpencesCalculatorGetDTO(ExpencesCalculatorEntity expencesCalculatorEntity) {
        if ( expencesCalculatorEntity == null ) {
            return null;
        }

        ExpencesCalculatorGetDTO.ExpencesCalculatorGetDTOBuilder expencesCalculatorGetDTO = ExpencesCalculatorGetDTO.builder();

        expencesCalculatorGetDTO.expencesCalculatorId( expencesCalculatorEntity.getExpencesCalculatorId() );
        expencesCalculatorGetDTO.name( expencesCalculatorEntity.getName() );
        expencesCalculatorGetDTO.description( expencesCalculatorEntity.getDescription() );
        expencesCalculatorGetDTO.periority( expencesCalculatorEntity.getPeriority() );
        expencesCalculatorGetDTO.price( expencesCalculatorEntity.getPrice() );
        expencesCalculatorGetDTO.totalCost( expencesCalculatorEntity.getTotalCost() );
        expencesCalculatorGetDTO.type( expencesCalculatorEntity.getType() );
        expencesCalculatorGetDTO.createdAt( expencesCalculatorEntity.getCreatedAt() );
        expencesCalculatorGetDTO.touristyPlacesEntity( expencesCalculatorEntity.getTouristyPlacesEntity() );

        return expencesCalculatorGetDTO.build();
    }

    @Override
    public ExpencesCalculatorUpdateDTO ToExpencesCalculatorUpdateDTO(ExpencesCalculatorEntity expencesCalculatorEntity) {
        if ( expencesCalculatorEntity == null ) {
            return null;
        }

        ExpencesCalculatorUpdateDTO.ExpencesCalculatorUpdateDTOBuilder expencesCalculatorUpdateDTO = ExpencesCalculatorUpdateDTO.builder();

        expencesCalculatorUpdateDTO.expencesCalculatorId( expencesCalculatorEntity.getExpencesCalculatorId() );
        expencesCalculatorUpdateDTO.name( expencesCalculatorEntity.getName() );
        expencesCalculatorUpdateDTO.description( expencesCalculatorEntity.getDescription() );
        expencesCalculatorUpdateDTO.periority( expencesCalculatorEntity.getPeriority() );
        expencesCalculatorUpdateDTO.price( expencesCalculatorEntity.getPrice() );
        expencesCalculatorUpdateDTO.totalCost( expencesCalculatorEntity.getTotalCost() );
        expencesCalculatorUpdateDTO.type( expencesCalculatorEntity.getType() );
        expencesCalculatorUpdateDTO.updatedAt( expencesCalculatorEntity.getUpdatedAt() );

        return expencesCalculatorUpdateDTO.build();
    }
}
