package com.navigatenow.navigatenowproject.Service.Impl;

import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackPostDTO;
import com.navigatenow.navigatenowproject.Model.Entity.FeedbackEntity;
import com.navigatenow.navigatenowproject.Model.Entity.UserEntity;
import com.navigatenow.navigatenowproject.Model.Mapper.FeedBackMapper;
import com.navigatenow.navigatenowproject.Repository.FeedBackRepo;
import com.navigatenow.navigatenowproject.Service.FeedBackServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FeedBackServicesImpl implements FeedBackServices {

    private final FeedBackRepo feedBackRepo;
    private final FeedBackMapper feedBackMapper;

    @Override
    public FeedBackPostDTO addFeedBack(FeedBackPostDTO feedBackPostDTO) {
        FeedbackEntity entity = this.feedBackMapper.ToEntity(feedBackPostDTO);
        UserEntity user = new UserEntity();
        user.setUserId(feedBackPostDTO.getUser_id());
        entity.setUserEntity(user);
        this.feedBackRepo.save(entity);
        return feedBackPostDTO;
    }

    @Override
    public FeedBackGetDTO getFeedBackById(Integer id) {
        Optional<FeedbackEntity> entity = this.feedBackRepo.getFeedbackEntityByFeedbackId(id);
        if (entity.isPresent()) {
            return this.feedBackMapper.ToGetFeedBackDTO(entity.get());
        } else {
            return null;
        }
    }

    @Override
    public List<FeedBackGetDTO> getAllFeedBacks() {
        List<FeedbackEntity> feedbackEntities = this.feedBackRepo.findAll();
        if (feedbackEntities.isEmpty()) {
            return null;
        } else {
            List<FeedBackGetDTO> feedBackGetDTOS = new ArrayList<>();
            feedbackEntities.forEach(entity -> {
                feedBackGetDTOS.add(this.feedBackMapper.ToGetFeedBackDTO(entity));
            });
            return feedBackGetDTOS;
        }
    }

    @Override
    public List<FeedBackGetDTO> getFeedbacksByUserId(Integer userid) {
        List<FeedbackEntity> feedbackEntities = this.feedBackRepo.getFeedbackEntitiesByUserId(userid);
        if (feedbackEntities.isEmpty()) {
            return null;
        } else {
            List<FeedBackGetDTO> feedBackGetDTOS = new ArrayList<>();
            feedbackEntities.forEach(entity -> {
                feedBackGetDTOS.add(this.feedBackMapper.ToGetFeedBackDTO(entity));
            });
            return feedBackGetDTOS;
        }
    }
}
