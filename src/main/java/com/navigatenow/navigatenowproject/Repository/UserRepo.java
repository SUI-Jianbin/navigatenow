package com.navigatenow.navigatenowproject.Repository;

import com.navigatenow.navigatenowproject.Model.Entity.FeedbackEntity;
import com.navigatenow.navigatenowproject.Model.Entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity,Integer> {
    Optional<UserEntity> getUserEntityByUserId(Integer id);
    Optional<UserEntity> getUserEntityByUserNameAndDeletedAtIsNull(String username);
    Optional<UserEntity> getUserEntityByEmailAndDeletedAtIsNull(String email);
    Optional<UserEntity> findByUserIdAndDeletedAtIsNull(Integer id);

    @Modifying
    @Transactional
    @Query(value = "update UserEntity t set t.firstName =:firstName, t.lastName =:lastName," +
            " t.userName =:userName, t.password =:password, t.email =:email, t.age =:age," +
            " t.contactNumber =:contactNumber, t.gender =:gender, t.dateOfBirth =:dateOfBirth, t.nationality =:nationality, t.updatedAt =:updatedAt"+
            " where t.userId =:userId")
    void updateUserNativeQuery(Integer userId,String firstName,
    String lastName,
    String userName,
    String password,
    String email,
    Integer age,
    String contactNumber,
    Integer gender,
    Date dateOfBirth,
    String nationality, LocalDateTime updatedAt);

    @Modifying
    @Transactional
    @Query(value = "update UserEntity t set t.password =:password where t.userName =:username")
    void updateUserpasswordNativeQuery(String username,String password);


    @Modifying
    @Transactional
    @Query(value = "update UserEntity t set t.firstName =:firstName, t.lastName =:lastName," +
            " t.email =:email, t.age =:age," +
            " t.contactNumber =:contactNumber, t.gender =:gender, t.dateOfBirth =:dateOfBirth, t.nationality =:nationality, t.updatedAt =:updatedAt"+
            " where t.userId =:userId")
    void updateUserWithoutPasswordNativeQuery(Integer userId,String firstName,
                               String lastName,
                               String email,
                               Integer age,
                               String contactNumber,
                               Integer gender,
                               Date dateOfBirth,
                               String nationality, LocalDateTime updatedAt);
}
