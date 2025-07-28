package com.navigatenow.navigatenowproject.Repository;

import com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs.TouristyPlacesGetDTO;
import com.navigatenow.navigatenowproject.Model.Entity.TouristyPlacesEntity;
import com.navigatenow.navigatenowproject.Model.Entity.TouristyPlaces_TripPlanEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TouristyPlaces_TripPlanRepo extends JpaRepository<TouristyPlaces_TripPlanEntity, Integer> {
    @Query(value = "select t from TouristyPlaces_TripPlanEntity t where t.touristyPlaces_tripPlanId =:id")
    Optional<TouristyPlaces_TripPlanEntity> getTouristyPlaces_TripPlanEntityByTouristyPlaces_TripPlanId(Integer id);

    @Query(value = "select t from TouristyPlaces_TripPlanEntity t where t.touristyPlaces_tripPlanId =:id and t.deletedAt =null")
    Optional<TouristyPlaces_TripPlanEntity> findByTouristyPlaces_TripPlanIdAndDeletedAtIsNull(Integer id);

    @Query(value = "select t from TouristyPlaces_TripPlanEntity t where t.touristyPlacesId =:touristyPlacesId")
    List<TouristyPlaces_TripPlanEntity> findAllTouristyPlaces_TripPlanEntitiesByTouristyPlacesId(int touristyPlacesId);

    @Query(value = "select t from TouristyPlaces_TripPlanEntity t where t.tripPlanId =:tripplanid")
    List<TouristyPlaces_TripPlanEntity> getAllTouristyPlacesByTripPlanId(int tripplanid);

    @Modifying
    @Transactional
    @Query(value = "update TouristyPlaces_TripPlanEntity u set u.touristyPlacesId =:touristyPlacesId , u.tripPlanId =:tripPlanId , u.updatedAt =:updatedAt where u.touristyPlaces_tripPlanId =:touristyPlaces_tripPlanId")
    void updateTouristyPlaces_TripPlanNativeQuery(Integer touristyPlaces_tripPlanId, Integer touristyPlacesId, Integer tripPlanId, LocalDateTime updatedAt);
}
