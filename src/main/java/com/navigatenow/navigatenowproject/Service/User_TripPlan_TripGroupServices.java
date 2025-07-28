package com.navigatenow.navigatenowproject.Service;

import com.navigatenow.navigatenowproject.Model.DTO.User_TripPlan_TripGroupDTOs.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface User_TripPlan_TripGroupServices {

    User_TripPlan_TripGroupPostDTO addUser_TripPlan_TripGroup(User_TripPlan_TripGroupPostDTO user_tripPlanTripGroupEntityPostDTO);
    List<User_TripPlans_TripGroupsGetDTO> getUser_TripPlan_TripGroupByUserId(Integer id);
    List<User_TripPlans_TripGroupsGetDTO> getOtherUsersGroupsByUserId(Integer userid);
    String leaveJoinedGroupByUserId(Integer userid);

}
