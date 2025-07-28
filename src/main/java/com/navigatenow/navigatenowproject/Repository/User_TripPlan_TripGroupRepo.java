package com.navigatenow.navigatenowproject.Repository;

import com.navigatenow.navigatenowproject.Model.Entity.User_TripPlan_TripGroupEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface User_TripPlan_TripGroupRepo extends JpaRepository<User_TripPlan_TripGroupEntity,Integer> {


    @Query(value = "select t from User_TripPlan_TripGroupEntity t where t.user_TripPlan_TripGroupId =:id")
    Optional<User_TripPlan_TripGroupEntity> getUser_TripPlan_TripGroupByUser_TripPlanId(Integer id);

    @Query(value = "select t from User_TripPlan_TripGroupEntity t where t.userId =:userid and t.tripPlanId =:tripplan and t.tripGroupId =:tripgroup")
    Optional<User_TripPlan_TripGroupEntity> getallByUserIdAndTripPlanIdAndTripGroupId(Integer userid, Integer tripplan, Integer tripgroup);

    @Query(value = "select t from User_TripPlan_TripGroupEntity t where t.userId =:userid")
    List<User_TripPlan_TripGroupEntity> getUser_TripPlan_TripGroupByUserId(Integer userid);
    @Query(value = "select t from User_TripPlan_TripGroupEntity t where t.userId !=:userid")
    List<User_TripPlan_TripGroupEntity> getOtherUsersGroupsByUserId(Integer userid);

    @Query(value = "select t from User_TripPlan_TripGroupEntity t where t.user_TripPlan_TripGroupId =:user_TripPlan_TripGroupId and t.deletedAt =null")
    Optional<User_TripPlan_TripGroupEntity> findByUserIdAndDeletedAtIsNull(Integer user_TripPlan_TripGroupId);

    @Modifying
    @Transactional
    @Query(value = "update User_TripPlan_TripGroupEntity u set u.tripPlanId =:tripPlanId , u.updatedAt =:updatedAt where u.user_TripPlan_TripGroupId =:user_TripPlan_TripGroupId")
    void updateUser_TripPlanNativeQuery(Integer user_TripPlan_TripGroupId, Integer tripPlanId, LocalDateTime updatedAt);

    @Modifying
    @Transactional
    @Query(value = "update User_TripPlan_TripGroupEntity u set u.tripGroupId =:groupId , u.updatedAt =:updatedAt where u.user_TripPlan_TripGroupId =:user_TripPlan_TripGroupId")
    void updateUser_TripGroupNativeQuery(Integer user_TripPlan_TripGroupId, Integer groupId, LocalDateTime updatedAt);
}
