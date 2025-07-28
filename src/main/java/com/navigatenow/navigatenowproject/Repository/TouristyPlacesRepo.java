package com.navigatenow.navigatenowproject.Repository;

import com.navigatenow.navigatenowproject.Model.Entity.TouristyPlacesEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TouristyPlacesRepo extends JpaRepository<TouristyPlacesEntity, Integer> {
    Optional<TouristyPlacesEntity> getTouristyPlacesEntityByTouristyPlacesId(Integer id);
    Optional<TouristyPlacesEntity> findByTouristyPlacesIdAndDeletedAtIsNull(Integer id);
    List<TouristyPlacesEntity> getTouristyPlacesEntityByUserIntrestEntity_UserintrestId(Integer id);

    @Query("SELECT tp FROM TouristyPlacesEntity tp " +
            "JOIN tp.userIntrestEntity ui " +
            "JOIN ui.userUserIntrests uui " +
            "WHERE uui.userId =:userId")
    List<TouristyPlacesEntity> findTouristyPlacesByUserId(Integer userId);

    @Modifying
    @Transactional
    @Query(value = "update TouristyPlacesEntity t set t.placeLocation =:placeLocation,"+
            "t.placeOpeningDays =:placeOpeningDays, t.placeOpeningTimes =:placeOpeningTimes," +
            "t.placeClosingTime =:placeClosingTime, t.placeRate =:placeRate, t.placePicture =:placePicture,"+
            "t.userIntrestEntity.userintrestId =:userintrestId,t.updatedAt =:updatedAt where t.touristyPlacesId =:touristyPlacesId")
    void updateTouristyPlacesNativeQuery(Integer touristyPlacesId,
                                         String placeLocation,
                                         String placeOpeningDays,
                                         String placeOpeningTimes,
                                         String placeClosingTime,
                                         String placeRate,
                                         String placePicture,
                                         Integer userintrestId,
                                         LocalDateTime updatedAt);
}
