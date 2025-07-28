package com.navigatenow.navigatenowproject.Service;

import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FeedBackServices {

    FeedBackPostDTO addFeedBack(FeedBackPostDTO feedBackPostDTO);
    FeedBackGetDTO getFeedBackById(Integer id);
    List<FeedBackGetDTO> getAllFeedBacks();
    List<FeedBackGetDTO> getFeedbacksByUserId(Integer userid);
}
