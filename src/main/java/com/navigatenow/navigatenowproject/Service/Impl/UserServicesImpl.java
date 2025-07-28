package com.navigatenow.navigatenowproject.Service.Impl;

import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.*;
import com.navigatenow.navigatenowproject.Model.Entity.FeedbackEntity;
import com.navigatenow.navigatenowproject.Model.Entity.UserEntity;
import com.navigatenow.navigatenowproject.Model.Mapper.FeedBackMapper;
import com.navigatenow.navigatenowproject.Model.Mapper.UserMapper;
import com.navigatenow.navigatenowproject.Repository.FeedBackRepo;
import com.navigatenow.navigatenowproject.Repository.UserRepo;
import com.navigatenow.navigatenowproject.Service.UserServices;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices {

    private final UserRepo userRepo;
    private final UserMapper userMapper;
//    private PasswordEncoder passwordEncoder;

    @Override
    public UserPostDTO addUser(UserPostDTO userPostDTO) {
        Optional<UserEntity> existingUser = this.userRepo.getUserEntityByEmailAndDeletedAtIsNull(userPostDTO.getEmail());

        if(existingUser.isEmpty()){
            UserEntity entity = this.userMapper.ToEntity(userPostDTO);
            this.userRepo.save(entity);
            return userPostDTO;
        }
        String currentUsername = existingUser.get().getUserName();

        if (currentUsername.equals(userPostDTO.getUserName())) {
            return null;
        } else {
            return null;
        }
    }

    @Override
    public UserGetDTO getUserById(Integer id) {
        Optional<UserEntity> entity = this.userRepo.getUserEntityByUserId(id);
        if (entity.isPresent()) {
            return this.userMapper.ToUserGetDTO(entity.get());
        } else {
            return null;
        }
    }

    @Override
    public UserGetDTO getUserByUsername(String username) {
        Optional<UserEntity> entity = this.userRepo.getUserEntityByUserNameAndDeletedAtIsNull(username);
        if (entity.isPresent()) {
            return this.userMapper.ToUserGetDTO(entity.get());
        } else {
            return null;
        }
    }

    @Override
    public List<UserGetDTO> getAllUsers() {
        List<UserEntity> userEntities = this.userRepo.findAll();
        if (userEntities.isEmpty()) {
            return null;
        } else {
            List<UserGetDTO> userGetDTOS = new ArrayList<>();
            userEntities.forEach(entity -> {
                userGetDTOS.add(this.userMapper.ToUserGetDTO(entity));
            });
            //log.info("Getting all products " + productDTOS);
            return userGetDTOS;
        }
    }


    @Override
    public String deleteUser(Integer id) {
        Optional<UserEntity> user = this.userRepo.findByUserIdAndDeletedAtIsNull(id);
        if (user.isPresent()) {
            user.get().setDeletedAt(LocalDateTime.now());
            this.userRepo.save(user.get());
            return "user has deleted Successfully";
        } else {
            return "user not exist";
        }
    }

    @Override
    public UserUpdateDTO updateUser(UserUpdateDTO userUpdateDTO) {
        UserEntity entity = this.userMapper.ToEntity(userUpdateDTO);
        this.userRepo.updateUserNativeQuery(entity.getUserId(), entity.getFirstName(), entity.getLastName()
                , entity.getUserName(), entity.getPassword(), entity.getEmail(), entity.getAge()
                , entity.getContactNumber(), entity.getGender(), entity.getDateOfBirth()
                , entity.getNationality(), entity.getUpdatedAt());
        return userUpdateDTO;
    }

    @Override
    public UserUpdateWithoutPasswordDTO updateUserWithoutPassword(UserUpdateWithoutPasswordDTO userUpdateWithoutPasswordDTO) {
        UserEntity entity = this.userMapper.ToEntity(userUpdateWithoutPasswordDTO);
        this.userRepo.updateUserWithoutPasswordNativeQuery(entity.getUserId(), entity.getFirstName(), entity.getLastName()
                , entity.getEmail(), entity.getAge()
                , entity.getContactNumber(), entity.getGender(), entity.getDateOfBirth()
                , entity.getNationality(), entity.getUpdatedAt());
        return userUpdateWithoutPasswordDTO;
    }

    @Override
    public String updateUserPassword(UserPasswordUpdateDTO userPasswordUpdateDTO) {

        String message = "User password has updated successfully";
        this.userRepo.updateUserpasswordNativeQuery(userPasswordUpdateDTO.getUserName(), userPasswordUpdateDTO.getPassword());
        Optional<UserEntity> updateduser = this.userRepo.getUserEntityByUserNameAndDeletedAtIsNull(userPasswordUpdateDTO.getUserName());
        if(updateduser.isPresent() && updateduser.get().getPassword().equals(userPasswordUpdateDTO.getPassword())){
            return message;
        }
        else {
            return "Something wrong happen with update service";
        }
    }

    @Override
    public UserLoginDTO UserLogin(String email, String password) {

            Optional<UserEntity> entity = this.userRepo.getUserEntityByEmailAndDeletedAtIsNull(email);

            if (entity.isPresent() && entity.get().getPassword().equals(password)) {
                return this.userMapper.ToUserLoginDTO(entity.get());
            }
            else {
                throw new NullPointerException();
            }

    }

}
