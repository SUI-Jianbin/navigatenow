package com.navigatenow.navigatenowproject.Service.Impl;

import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.DeleteUser_UserIntrestDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.User_UserIntrestGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.User_UserIntrestPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_UserIntrestDTOs.User_UserIntrestUpdateDTO;
import com.navigatenow.navigatenowproject.Model.Entity.UserIntrestEntity;
import com.navigatenow.navigatenowproject.Model.Entity.User_UserIntrestEntity;
import com.navigatenow.navigatenowproject.Model.Mapper.User_UserIntrestMapper;
import com.navigatenow.navigatenowproject.Repository.User_UserIntrestRepo;
import com.navigatenow.navigatenowproject.Service.UserIntrestServices;
import com.navigatenow.navigatenowproject.Service.User_UserIntrestServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class User_UserIntrestServicesImpl implements User_UserIntrestServices {

    private final User_UserIntrestRepo user_userIntrestRepo;
    private final User_UserIntrestMapper user_userIntrestMapper;
    private final UserIntrestServices userIntrestServices;


    // Add many interest to a user
    @Override
    public List<User_UserIntrestPostDTO> addUser_UserIntrest(List<User_UserIntrestPostDTO> user_userIntrestPostDTO) {

        List<User_UserIntrestPostDTO> toBeAdded = new ArrayList<>();
        for (int i = 0; i < user_userIntrestPostDTO.size(); i++) {

            var interestExist = this.user_userIntrestRepo.getUser_UserIntrestEntityByUserIdAndUserintrestId(user_userIntrestPostDTO.get(i).getUserId(), user_userIntrestPostDTO.get(i).getUserintrestId());
            if (interestExist.isPresent()) {
                continue;
            } else {
                toBeAdded.add(user_userIntrestPostDTO.get(i));
                this.user_userIntrestRepo.save(this.user_userIntrestMapper.ToEntity(user_userIntrestPostDTO.get(i)));
            }
        }
        return toBeAdded;
    }

    @Override
    public List<User_UserIntrestGetDTO> getUser_UserIntrestEntitiesByUserId(Integer id) {
        List<User_UserIntrestEntity> user_userIntrestEntities = this.user_userIntrestRepo.getUser_UserIntrestEntitiesByUserId(id);
        List<User_UserIntrestGetDTO> user_userIntrestGetDTOS = new ArrayList<>();
        if (user_userIntrestEntities.isEmpty()) {
            return null;
        } else {
            for (int i = 0; i < user_userIntrestEntities.size(); i++){
                user_userIntrestGetDTOS.add(this.user_userIntrestMapper.ToUser_UserIntrestGetDTO(user_userIntrestEntities.get(i)));
                user_userIntrestGetDTOS.get(i).setUserIntrestEntity(this.userIntrestServices.getUserIntrestById(user_userIntrestEntities.get(i).getUserintrestId()));
            }

        }
        return user_userIntrestGetDTOS;
    }

    @Override
    public List<User_UserIntrestGetDTO> getAllUser_UserIntrests() {
        List<User_UserIntrestEntity> user_userIntrestEntities = this.user_userIntrestRepo.findAll();
        if (user_userIntrestEntities.isEmpty()) {
            return null;
        } else {
            List<User_UserIntrestGetDTO> user_userIntrestGetDTOS = new ArrayList<>();
            user_userIntrestEntities.forEach(entity -> {
                user_userIntrestGetDTOS.add(this.user_userIntrestMapper.ToUser_UserIntrestGetDTO(entity));
            });
            //log.info("Getting all products " + productDTOS);
            return user_userIntrestGetDTOS;
        }
    }

    @Override
    public String deleteUser_UserIntrest(List<DeleteUser_UserIntrestDTO> deleteUserUserIntrestDTOS) {
        List<User_UserIntrestEntity> user_userIntrest = this.user_userIntrestRepo.getUser_UserIntrestEntitiesByUserId(deleteUserUserIntrestDTOS.get(0).getUserId());
        User_UserIntrestEntity entity = new User_UserIntrestEntity();
        if (!user_userIntrest.isEmpty()) {

            for (int i = 0; i < deleteUserUserIntrestDTOS.size(); i++) {

                if (deleteUserUserIntrestDTOS.get(i).getDeletedAt() == null) {
                    deleteUserUserIntrestDTOS.get(i).setDeletedAt(LocalDateTime.now());
                    this.user_userIntrestMapper.ToEntity(deleteUserUserIntrestDTOS.get(i));
                    this.user_userIntrestRepo.deleteUser_UserInterestNativeQuery(deleteUserUserIntrestDTOS.get(i).getUserUserintrestId(), deleteUserUserIntrestDTOS.get(i).getDeletedAt());
                }
            }
            return "user Interest has deleted Successfully";
        } else {
            return "user Interest not exist";
        }
    }

    @Override
    public List<User_UserIntrestUpdateDTO> updateUser_UserIntrest(List<User_UserIntrestUpdateDTO> user_userIntrestUpdateDTO) {

        List<User_UserIntrestUpdateDTO> toBeUpdated = new ArrayList<>();
        List<User_UserIntrestEntity> user_userIntrestEntities = new ArrayList<>();
        for (int i = 0; i < user_userIntrestUpdateDTO.size(); i++) {

            var interestExist = this.user_userIntrestRepo.getUser_UserIntrestEntityByUserIdAndUserintrestId(user_userIntrestUpdateDTO.get(i).getUserId(), user_userIntrestUpdateDTO.get(i).getUserintrestId());
            if (interestExist.isPresent()) {
                continue;
            } else {
                toBeUpdated.add(user_userIntrestUpdateDTO.get(i));
                user_userIntrestEntities.add(this.user_userIntrestMapper.ToEntity(user_userIntrestUpdateDTO.get(i)));
                this.user_userIntrestRepo.updateUser_UserIntrestNativeQuery(user_userIntrestEntities.get(i).getUserUserintrestId(), user_userIntrestEntities.get(i).getUserId(), user_userIntrestEntities.get(i).getUserintrestId(), user_userIntrestEntities.get(i).getUpdatedAt());
            }
        }
        return toBeUpdated;
    }

}
