package com.navigatenow.navigatenowproject.Repository;

import com.navigatenow.navigatenowproject.Model.Entity.UserIntrestEntity;
import com.navigatenow.navigatenowproject.Model.Entity.User_UserIntrestEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserIntrestRepo  extends JpaRepository<UserIntrestEntity,Integer> {

    Optional<UserIntrestEntity> getUserIntrestEntityByUserintrestId(Integer id);

    Optional<UserIntrestEntity> findByUserintrestIdAndDeletedAtIsNull(Integer id);
    //@Query(value = "select t from UserIntrestEntity t where t.intrestValue LIKE %:intrestValue% ")
    List<UserIntrestEntity> findUserIntrestEntityByIntrestValueLike(String intrestValue);
    @Modifying
    @Transactional
    @Query(value = "update UserIntrestEntity t set t.intrestDescription =:intrestDescription, t.intrestValue =:intrestValue, t.updatedAt =:updatedAt"+
            " where t.userintrestId =:userintrestId")
    void updateUserIntrestNativeQuery(Integer userintrestId, String intrestDescription, String intrestValue, LocalDateTime updatedAt );
}
