package com.navigatenow.navigatenowproject.Repository;

import com.navigatenow.navigatenowproject.Model.Entity.TripGroupEntity;
import com.navigatenow.navigatenowproject.Model.Entity.User_TripPlan_TripGroupEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TripGroupRepo extends JpaRepository<TripGroupEntity, Integer> {
    Optional<TripGroupEntity> getTripGroupEntityByTripGroupId(Integer id);
    Optional<TripGroupEntity> getTripGroupEntitiesByTripPlanEntity_TripPlanId(Integer id);
    Optional<TripGroupEntity> findByTripGroupIdAndDeletedAtIsNull(Integer id);
    @Query(value = "select t from TripGroupEntity t where t.tripPlanEntity.userEntity.userId !=:userid")
    List<TripGroupEntity> getOtherUsersGroupsByUserId(Integer userid);
    List<TripGroupEntity> getTripGroupEntitiesByGroupNameContaining(String groupName);

    @Query(value = "select t from TripGroupEntity t where t.tripPlanEntity.userEntity.userId =:userid")
    List<TripGroupEntity> checkIfUserHasCreatedGroupsByUserId(Integer userid);

    @Modifying
    @Transactional
    @Query(value = "update TripGroupEntity t set t.groupName =:GroupName, t.groupDescription =:groupDescription," +
            " t.groupNumberLemit =:groupNumberLemit, t.updatedAt =:updatedAt"+
            " where t.tripGroupId =:tripGroupId")
    void updateTripGroupNativeQuery(Integer tripGroupId,
                                    String GroupName,
                                    String groupDescription,
                                    Integer groupNumberLemit, LocalDateTime updatedAt);

    @Modifying
    @Transactional
    @Query(value = "update TripGroupEntity t set t.numberOfTourists =:numberOfTourists, t.updatedAt =:updatedAt where t.tripGroupId =:tripGroupId")
    void updateNumberOfTourists(Integer tripGroupId, Integer numberOfTourists, LocalDateTime updatedAt);
}
