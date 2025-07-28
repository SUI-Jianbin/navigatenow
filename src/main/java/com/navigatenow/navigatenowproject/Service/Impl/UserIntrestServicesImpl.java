package com.navigatenow.navigatenowproject.Service.Impl;

import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserIntrestDTOs.UserIntrestUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.UserEntity;
import com.navigatenow.navigatenowproject.Model.Entity.UserIntrestEntity;
import com.navigatenow.navigatenowproject.Model.Mapper.UserIntrestMapper;
import com.navigatenow.navigatenowproject.Model.Mapper.UserMapper;
import com.navigatenow.navigatenowproject.Repository.UserIntrestRepo;
import com.navigatenow.navigatenowproject.Repository.UserRepo;
import com.navigatenow.navigatenowproject.Service.UserIntrestServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserIntrestServicesImpl implements UserIntrestServices {

    private final UserIntrestRepo userIntrestRepo;
    private final UserIntrestMapper userIntrestMapper;
    @Override
    public UserIntrestPostDTO addUserIntrest(UserIntrestPostDTO userIntrestPostDTO) {

        List<UserIntrestEntity> exactEntity = this.userIntrestRepo.findUserIntrestEntityByIntrestValueLike(userIntrestPostDTO.getIntrestValue());
        UserIntrestEntity entity = this.userIntrestMapper.ToEntity(userIntrestPostDTO);

        if(!exactEntity.isEmpty()){
            return null;
        }
        else {
            this.userIntrestRepo.save(entity);
            return userIntrestPostDTO;
        }
    }

    @Override
    public UserIntrestGetDTO getUserIntrestById(Integer id) {
        Optional<UserIntrestEntity> entity = this.userIntrestRepo.getUserIntrestEntityByUserintrestId(id);
        if (entity.isPresent()){
            return this.userIntrestMapper.ToUserIntrestGetDTO(entity.get());
        }else {
            return null;
        }
    }

    @Override
    public List<UserIntrestGetDTO> getAllUserIntrests() {
        List<UserIntrestEntity> userEntities = this.userIntrestRepo.findAll();
        if (userEntities.isEmpty()) {
            return null;
        } else {
            List<UserIntrestGetDTO> userIntrestGetDTOS = new ArrayList<>();
            userEntities.forEach(entity -> {
                userIntrestGetDTOS.add(this.userIntrestMapper.ToUserIntrestGetDTO(entity));
            });
            return userIntrestGetDTOS;
        }
    }

    @Override
    public String deleteUserIntrest(Integer id) {
        Optional<UserIntrestEntity> userIntrestEntity = this.userIntrestRepo.findByUserintrestIdAndDeletedAtIsNull(id);
        if (userIntrestEntity.isPresent()) {
            userIntrestEntity.get().setDeletedAt(LocalDateTime.now());
            this.userIntrestRepo.save(userIntrestEntity.get());
            return "user Intrest has deleted Successfully";
        } else {
            return "user not exist";
        }
    }

    @Override
    public UserIntrestUpdateDTO updateUserIntrest(UserIntrestUpdateDTO userIntrestUpdateDTO) {
        UserIntrestEntity entity = this.userIntrestMapper.ToEntity(userIntrestUpdateDTO);
        this.userIntrestRepo.updateUserIntrestNativeQuery(entity.getUserintrestId(),entity.getIntrestDescription(), entity.getIntrestValue(), entity.getUpdatedAt());
        return userIntrestUpdateDTO;
    }


}
