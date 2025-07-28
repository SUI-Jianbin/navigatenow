package com.navigatenow.navigatenowproject.Repository;

import com.navigatenow.navigatenowproject.Model.Entity.ChecklistEntity;
import com.navigatenow.navigatenowproject.Model.Entity.ExpencesCalculatorEntity;
import com.navigatenow.navigatenowproject.Model.Entity.FeedbackEntity;
import com.navigatenow.navigatenowproject.Model.Entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface ExpencesCalculatorRepo extends JpaRepository<ExpencesCalculatorEntity, Integer> {
    Optional<ExpencesCalculatorEntity> getExpencesCalculatorEntityByExpencesCalculatorId(Integer id);

    Optional<ExpencesCalculatorEntity> findByExpencesCalculatorIdAndDeletedAtIsNull(Integer id);
    @Query(value = "select t from ExpencesCalculatorEntity t where t.touristyPlacesEntity.touristyPlacesId =:touristyPlacesId")
    List<ExpencesCalculatorEntity> getExpencesCalculatorEntitiesByTouristyPlacesId(Integer touristyPlacesId);


    @Modifying
    @Transactional
    @Query(value = "update ExpencesCalculatorEntity t set t.name =:name, t.description =:description," +
            " t.periority =:periority, t.price =:price, t.totalCost =:totalCost, t.type =:type, t.updatedAt =:updatedAt" +
            " where t.expencesCalculatorId =:expencesCalculatorId")
    void updateExpencesCalculatorNativeQuery(
            Integer expencesCalculatorId,
            String name,
            String description,
            String periority,
            String price,
            String totalCost,
            String type,
            LocalDateTime updatedAt);
}
