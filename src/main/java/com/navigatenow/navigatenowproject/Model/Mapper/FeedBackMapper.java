package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackPostDTO;
import com.navigatenow.navigatenowproject.Model.Entity.FeedbackEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedBackMapper {

    // Convert FeedBackPostDTO to FeedbackEntity
    FeedbackEntity ToEntity(FeedBackPostDTO feedBackPostDTO);
    FeedBackPostDTO ToPostFeedBackDTO(FeedbackEntity feedbackEntity);
    FeedBackGetDTO ToGetFeedBackDTO(FeedbackEntity feedbackEntity);

}
