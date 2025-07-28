package com.navigatenow.navigatenowproject.Service;

import com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs.TripGroupGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs.TripGroupPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs.TripGroupUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_TripPlan_TripGroupDTOs.User_TripPlans_TripGroupsGetDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TripGroupServices {
    TripGroupPostDTO addTripGroup(TripGroupPostDTO TripGroupPostDTO);
    TripGroupGetDTO getTripGroupById(Integer id);
    TripGroupGetDTO getTripGroupByTripPlanId(Integer id);
    List<TripGroupGetDTO> getAllTripGroup();
    List<TripGroupGetDTO> getOtherUsersGroupsByUserId(Integer userid);

    List<TripGroupGetDTO> getAllTripGroupsByGroupName(String groupName);
    String deleteTripGroup(Integer id);
    TripGroupUpdateDTO updateTripGroup(TripGroupUpdateDTO tripGroupUpdateDTO);
    Boolean checkIfUserHasCreatedGroupsByUserId(Integer userid);

}
