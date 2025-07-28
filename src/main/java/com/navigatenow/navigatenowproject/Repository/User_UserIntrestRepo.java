package com.navigatenow.navigatenowproject.Repository;


import com.navigatenow.navigatenowproject.Model.Entity.User_UserIntrestEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface User_UserIntrestRepo extends JpaRepository<User_UserIntrestEntity,Integer> {

    Optional<User_UserIntrestEntity> getUser_UserIntrestEntityByUserUserintrestId(Integer id);
    Optional<User_UserIntrestEntity> getUser_UserIntrestEntityByUserIdAndUserintrestId(Integer userid, Integer interestid);

    Optional<User_UserIntrestEntity> findByUserUserintrestIdAndDeletedAtIsNull(Integer id);
    List<User_UserIntrestEntity> getUser_UserIntrestEntitiesByUserId(Integer id);

    @Query(value = "select t from User_UserIntrestEntity t where t.userId =:userId")
    List<User_UserIntrestEntity> findAllUser_UserIntrestEntityByUserId(int userId);
    @Modifying
    @Transactional
    @Query(value = "update User_UserIntrestEntity t set t.userId =:userId, t.userintrestId =:userintrestId, t.updatedAt =:updatedAt"+
            " where t.userUserintrestId =:userUserintrestId")
    void updateUser_UserIntrestNativeQuery(Integer userUserintrestId, Integer userId, Integer userintrestId, LocalDateTime updatedAt );

    @Modifying
    @Transactional
    @Query(value = "update User_UserIntrestEntity t set t.deletedAt =:deletedAt"+
            " where t.userUserintrestId =:userUserintrestId")
    void deleteUser_UserInterestNativeQuery(Integer userUserintrestId, LocalDateTime deletedAt );
}
