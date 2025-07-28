package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ExpencesCalculatorDTOs.ExpencesCalculatorGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ExpencesCalculatorDTOs.ExpencesCalculatorPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ExpencesCalculatorDTOs.ExpencesCalculatorUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.ContactUsEntity;
import com.navigatenow.navigatenowproject.Model.Entity.ExpencesCalculatorEntity;
import com.navigatenow.navigatenowproject.Model.Entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpencesCalculatorMapper {
    // Convert ExpencesCalculatorPostDTO to ExpencesCalculatorEntity
    ExpencesCalculatorEntity ToEntity(ExpencesCalculatorPostDTO expencesCalculatorPostDTO);

    // Convert ExpencesCalculatorGetDTO to ExpencesCalculatorEntity
    ExpencesCalculatorEntity ToEntity(ExpencesCalculatorUpdateDTO expencesCalculatorUpdateDTO);

    // Convert ExpencesCalculatorEntity to ExpencesCalculatorPostDTO
    ExpencesCalculatorPostDTO ToExpencesCalculatorPostDTO(ExpencesCalculatorEntity expencesCalculatorEntity);
    // Convert ExpencesCalculatorEntity to ExpencesCalculatorGetDTO
    ExpencesCalculatorGetDTO ToExpencesCalculatorGetDTO(ExpencesCalculatorEntity expencesCalculatorEntity);

    ExpencesCalculatorUpdateDTO ToExpencesCalculatorUpdateDTO(ExpencesCalculatorEntity expencesCalculatorEntity);

}
