package com.navigatenow.navigatenowproject.Repository;

import com.navigatenow.navigatenowproject.Model.Entity.ChecklistEntity;
import com.navigatenow.navigatenowproject.Model.Entity.FeedbackEntity;
import com.navigatenow.navigatenowproject.Model.Entity.TripGroupEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ChecklistRepo extends JpaRepository<ChecklistEntity, Integer> {

    Optional<ChecklistEntity> getChecklistEntityByChecklistId(Integer id);

    Optional<ChecklistEntity> findByChecklistIdAndDeletedAtIsNull(Integer id);

    @Query(value = "select t from ChecklistEntity t where t.tripPlanEntity.tripPlanId =:tripplanid")
    List<ChecklistEntity> getChecklistEntitiesByTripPlanId(Integer tripplanid);

    @Query(value = "select t from ChecklistEntity t where t.tripPlanEntity.tripPlanId =:tripplanid")
    List<ChecklistEntity> checkIfTripPlanHasCheckList(Integer tripplanid);

    @Modifying
    @Transactional
    @Query(value = "update ChecklistEntity t set t.itemName =:itemName, t.itemDescription =:itemDescription," +
            " t.itemImportance =:itemImportance, t.updatedAt =:updatedAt where t.checklistId =:checklistId")
    void updateChecklistNativeQuery(Integer checklistId, String itemName, String itemDescription,
                                    String itemImportance, LocalDateTime updatedAt);
}
