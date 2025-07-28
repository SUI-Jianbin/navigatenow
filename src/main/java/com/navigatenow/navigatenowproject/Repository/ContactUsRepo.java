package com.navigatenow.navigatenowproject.Repository;

import com.navigatenow.navigatenowproject.Model.Entity.ContactUsEntity;
import com.navigatenow.navigatenowproject.Model.Entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactUsRepo extends JpaRepository<ContactUsEntity,Integer> {

    Optional<ContactUsEntity> getContactUsEntityByContactusId(Integer id);

}
