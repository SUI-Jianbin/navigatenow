package com.navigatenow.navigatenowproject.Controller;

import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackPostDTO;
import com.navigatenow.navigatenowproject.Service.FeedBackServices;
import com.navigatenow.navigatenowproject.Service.Impl.FeedBackServicesImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/feedbacks")
@CrossOrigin
@RequiredArgsConstructor
public class FeedBackController {

    public final FeedBackServicesImpl feedBackServices;
    @PostMapping(path = "/feedback/add-feadback")
    public FeedBackPostDTO addFeedBack(@RequestBody @Valid FeedBackPostDTO feedBackPostDTO){
        return this.feedBackServices.addFeedBack(feedBackPostDTO);
    }

    @GetMapping(path = "/feedback/get-feedbackbyid/{id}")
    public FeedBackGetDTO getFeedBacksById(@PathVariable Integer id){
        return this.feedBackServices.getFeedBackById(id);
    }

    // Get All feedbacks by user Id
    @GetMapping(path = "/feedback/get-feedbackbyuserid/{userid}")
    public List<FeedBackGetDTO> getFeedBacksByUserId(@PathVariable Integer userid){
        return this.feedBackServices.getFeedbacksByUserId(userid);
    }

    @GetMapping(path = "/feedback/get-allfeedbacks")
    public List<FeedBackGetDTO> getAllFeedBacks(){
        return this.feedBackServices.getAllFeedBacks();
    }
}
