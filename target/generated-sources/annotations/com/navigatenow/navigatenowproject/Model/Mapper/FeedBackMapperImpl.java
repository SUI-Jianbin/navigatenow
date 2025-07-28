package com.navigatenow.navigatenowproject.Model.Mapper;

import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackPostDTO;
import com.navigatenow.navigatenowproject.Model.Entity.FeedbackEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-28T20:10:08+1000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class FeedBackMapperImpl implements FeedBackMapper {

    @Override
    public FeedbackEntity ToEntity(FeedBackPostDTO feedBackPostDTO) {
        if ( feedBackPostDTO == null ) {
            return null;
        }

        FeedbackEntity.FeedbackEntityBuilder feedbackEntity = FeedbackEntity.builder();

        feedbackEntity.feedbackId( feedBackPostDTO.getFeedbackId() );
        feedbackEntity.firstName( feedBackPostDTO.getFirstName() );
        feedbackEntity.lastName( feedBackPostDTO.getLastName() );
        feedbackEntity.email( feedBackPostDTO.getEmail() );
        feedbackEntity.description( feedBackPostDTO.getDescription() );
        feedbackEntity.experienceRate( feedBackPostDTO.getExperienceRate() );
        feedbackEntity.createdAt( feedBackPostDTO.getCreatedAt() );

        return feedbackEntity.build();
    }

    @Override
    public FeedBackPostDTO ToPostFeedBackDTO(FeedbackEntity feedbackEntity) {
        if ( feedbackEntity == null ) {
            return null;
        }

        FeedBackPostDTO.FeedBackPostDTOBuilder feedBackPostDTO = FeedBackPostDTO.builder();

        feedBackPostDTO.feedbackId( feedbackEntity.getFeedbackId() );
        feedBackPostDTO.firstName( feedbackEntity.getFirstName() );
        feedBackPostDTO.lastName( feedbackEntity.getLastName() );
        feedBackPostDTO.email( feedbackEntity.getEmail() );
        feedBackPostDTO.description( feedbackEntity.getDescription() );
        feedBackPostDTO.experienceRate( feedbackEntity.getExperienceRate() );
        feedBackPostDTO.createdAt( feedbackEntity.getCreatedAt() );

        return feedBackPostDTO.build();
    }

    @Override
    public FeedBackGetDTO ToGetFeedBackDTO(FeedbackEntity feedbackEntity) {
        if ( feedbackEntity == null ) {
            return null;
        }

        FeedBackGetDTO.FeedBackGetDTOBuilder feedBackGetDTO = FeedBackGetDTO.builder();

        feedBackGetDTO.feedbackId( feedbackEntity.getFeedbackId() );
        feedBackGetDTO.firstName( feedbackEntity.getFirstName() );
        feedBackGetDTO.lastName( feedbackEntity.getLastName() );
        feedBackGetDTO.email( feedbackEntity.getEmail() );
        feedBackGetDTO.description( feedbackEntity.getDescription() );
        feedBackGetDTO.experienceRate( feedbackEntity.getExperienceRate() );
        feedBackGetDTO.createdAt( feedbackEntity.getCreatedAt() );
        feedBackGetDTO.userEntity( feedbackEntity.getUserEntity() );

        return feedBackGetDTO.build();
    }
}
