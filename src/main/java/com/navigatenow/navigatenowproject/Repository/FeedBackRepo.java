package com.navigatenow.navigatenowproject.Repository;

import com.navigatenow.navigatenowproject.Model.Entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FeedBackRepo extends JpaRepository<FeedbackEntity,Integer> {


    Optional<FeedbackEntity> getFeedbackEntityByFeedbackId(Integer id);

    @Query(value = "select t from FeedbackEntity t where t.userEntity.userId =:userid")
    List<FeedbackEntity> getFeedbackEntitiesByUserId(Integer userid);
}
