package com.navigatenow.navigatenowproject.Repository;

import com.navigatenow.navigatenowproject.Model.Entity.FeedbackEntity;
import com.navigatenow.navigatenowproject.Model.Entity.TripGroupEntity;
import com.navigatenow.navigatenowproject.Model.Entity.TripPlanEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TripPlanRepo extends JpaRepository<TripPlanEntity,Integer> {

    //@Query(value = "select t from TripPlanEntity t where t.tripPlanId =:id")
    Optional<TripPlanEntity> getTripPlanEntityByTripPlanId(Integer id);

    Optional<TripPlanEntity> findByTripPlanIdAndDeletedAtIsNull(Integer id);

    @Query(value = "select t from TripPlanEntity t where t.userEntity.userId =:userid")
    List<TripPlanEntity> getTripPlanEntitiesByUserId(Integer userid);

    @Modifying
    @Transactional
    @Query(value = "update TripPlanEntity t set t.planName =:planName," +
            " t.planDescription =:planDescription,t.startDate =:startDate ," +
            "t.endDate =:endDate, t.updatedAt =:updatedAt"+
            " where t.tripPlanId =:tripPlanId")
    void updateTripPlanNativeQuery(Integer tripPlanId, String planName,
                                           String planDescription, Date startDate,
                                           Date endDate, LocalDateTime updatedAt );
}
