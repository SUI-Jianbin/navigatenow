package com.navigatenow.navigatenowproject;

import com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs.TripGroupPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.UserDTOs.UserPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.User_TripPlan_TripGroupDTOs.User_TripPlan_TripGroupPostDTO;
import com.navigatenow.navigatenowproject.Model.Entity.*;
import com.navigatenow.navigatenowproject.Model.Mapper.UserIntrestMapper;
import com.navigatenow.navigatenowproject.Model.Mapper.User_TripPlan_TripGroupMapper;
import com.navigatenow.navigatenowproject.Repository.*;
import com.navigatenow.navigatenowproject.Service.Impl.TouristyPlacesServicesImpl;
import com.navigatenow.navigatenowproject.Service.Impl.UserServicesImpl;
import com.navigatenow.navigatenowproject.Service.Impl.User_TripPlan_TripGroupServicesImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.time.LocalDateTime;
import java.util.*;

import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = NavigateNowProjectApplication.class
)
@AutoConfigureMockMvc
public class NavigateNowProjectApplicationTests {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private UserServicesImpl userServices;
	@Autowired
	private UserIntrestRepo userIntrestRepo;
	@Autowired
	private UserIntrestMapper userIntrestMapper;
	@Autowired
	private User_TripPlan_TripGroupRepo user_tripPlanTripGroupEntityRepo;
	@Autowired
	private User_TripPlan_TripGroupServicesImpl user_tripPlanServices;
	@Autowired
	private TouristyPlacesServicesImpl touristyPlacesServices;
	@Autowired
	private User_TripPlan_TripGroupMapper user_tripPlanTripGroupEntityMapper;
	@Autowired
	private TripGroupRepo tripGroupRepo;
	@Autowired
	private ExpencesCalculatorRepo expencesCalculatorRepo;
	@Autowired
	MockMvc mockMvc;


	// JUnit Testing
	@Test
	void CheckUserAgeEqualTwenty() {
		Optional<UserEntity> entity = this.userRepo.getUserEntityByUserId(96);
		assertEquals(20,entity.get().getAge().intValue());

	}

	@Test
	void NumberOfTouristsIsNotZero(){
		Optional<TripGroupEntity> entity = this.tripGroupRepo.getTripGroupEntityByTripGroupId(1);
		assertTrue("Error the group number is less than 1",entity.get().getNumberOfTourists() >= 1);
	}

	@Test
	void UserHasNoTripGroup(){
		List<User_TripPlan_TripGroupEntity> entity = this.user_tripPlanTripGroupEntityRepo.getUser_TripPlan_TripGroupByUserId(3);
		assertFalse("Error the group number is less than 1",entity.get(0).getTripGroupEntity().getTripGroupId() < 0);
	}

	@Test
	void deleteUserSuccess() {
		Optional<UserEntity> user = this.userRepo.findByUserIdAndDeletedAtIsNull(3);
			user.get().setDeletedAt(LocalDateTime.now());
			this.userRepo.save(user.get());
			// if deleted_at is null means that user is not deleted
		Assertions.assertThat(user.get().getDeletedAt()).isNotNull();
	}

	@Test
	void updateUserIntrestNotNull() {
		 Optional<UserIntrestEntity> entity = this.userIntrestRepo.getUserIntrestEntityByUserintrestId(1);
		this.userIntrestRepo.updateUserIntrestNativeQuery(entity.get().getUserintrestId(),"Edited Description", "music", LocalDateTime.now());
		Optional<UserIntrestEntity> editedEntity = this.userIntrestRepo.getUserIntrestEntityByUserintrestId(89);
		Assertions.assertThat(entity).isNotEqualTo(editedEntity);
	}



	// Integration testing
	@Test
	void addUser_TripPlan() throws Exception {

		User_TripPlan_TripGroupPostDTO user_tripPlanTripGroupEntityPostDTO = new User_TripPlan_TripGroupPostDTO();
		user_tripPlanTripGroupEntityPostDTO.setUserId(2);
		user_tripPlanTripGroupEntityPostDTO.setTripPlanId(1);

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post("/user-tripplans/user-user-tripplan/add-user-tripplan", user_tripPlanTripGroupEntityPostDTO)
						.accept(MediaType.APPLICATION_JSON)
		).andReturn();
		System.out.println(mvcResult.getResponse());

	}

	@Test
	void getAllUser_TripPlansIntegrationTest() throws Exception {

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/user-tripplans/user-user-tripplan/get-alluser-tripplans")
						.accept(MediaType.APPLICATION_JSON)
		).andReturn();
		System.out.println(mvcResult.getResponse());

	}

	@Test
	void addUserSuccessfully() {

		UserPostDTO userPostDTO = new UserPostDTO();

		userPostDTO.setUserName("Azzam321");
		userPostDTO.setFirstName("Azzam");
		userPostDTO.setLastName("Althunayyan");
		userPostDTO.setPassword("123456");
		userPostDTO.setEmail("developer.azzam@gmail.com");
		userPostDTO.setAge(29);
		userPostDTO.setContactNumber("0406058540");
		userPostDTO.setGender(1);
		userPostDTO.setDateOfBirth(new Date("1994/8/28"));
		userPostDTO.setNationality("Saudi");
		this.userServices.addUser(userPostDTO);

		Assertions.assertThat(userPostDTO).isNotNull();

		Optional<UserEntity> addedEntity = this.userRepo.getUserEntityByUserNameAndDeletedAtIsNull(userPostDTO.getEmail());

		Assertions.assertThat(addedEntity).isNotNull();
	}

	@Test
	void getAllTripsIntegrationTest() throws Exception {

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/tripplans/tripplan/get-alltripplans")
						.accept(MediaType.APPLICATION_JSON)
		).andReturn();
		System.out.println(mvcResult.getResponse());
	}

	@Test
	void addUserIntegrationTest() throws Exception {

		UserPostDTO userPostDTO = new UserPostDTO();
		userPostDTO.setUserName("Azzam321");
		userPostDTO.setFirstName("Azzam");
		userPostDTO.setLastName("Althunayyan");
		userPostDTO.setPassword("123456");
		userPostDTO.setEmail("developer.azzam@gmail.com");
		userPostDTO.setAge(29);
		userPostDTO.setContactNumber("0406058540");
		userPostDTO.setGender(1);
		userPostDTO.setDateOfBirth(new Date("1994/8/28"));
		userPostDTO.setNationality("Saudi");

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post("/users/user/add-user",userPostDTO)
						.accept(MediaType.APPLICATION_JSON)
		).andReturn();
		System.out.println(mvcResult.getResponse());
	}

	@Test
	void addUser_TripPlanIntegrationTest() throws Exception{

		User_TripPlan_TripGroupPostDTO user_tripPlanTripGroupEntityPostDTO = new User_TripPlan_TripGroupPostDTO();

		user_tripPlanTripGroupEntityPostDTO.setUserId(1);
		user_tripPlanTripGroupEntityPostDTO.setTripPlanId(1);

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post("/user-tripplans/user-user-tripplan/add-user-tripplan", user_tripPlanTripGroupEntityPostDTO)
						.accept(MediaType.APPLICATION_JSON)
		).andReturn();
		System.out.println(mvcResult.getResponse());
	}

	@Test
	void addTripGroupIntegrationTest() throws Exception {

		TripGroupPostDTO tripGroupPostDTO = new TripGroupPostDTO();
		tripGroupPostDTO.setGroupName("Group 1");
		tripGroupPostDTO.setGroupDescription("Great group");
		tripGroupPostDTO.setGroupNumberLemit(8);
		tripGroupPostDTO.setNumberOfTourists(7);

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post("/tripgroups/tripgroup/add-tripgroup",tripGroupPostDTO)
						.accept(MediaType.APPLICATION_JSON)
		).andReturn();
		System.out.println(mvcResult.getResponse());
	}

	@Test
	void getAllTouristyPlacesIntegrationTest() throws Exception {

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/touristyplacess/touristyplaces/add-touristyplaces")
						.accept(MediaType.APPLICATION_JSON)
		).andReturn();
		System.out.println(mvcResult.getResponse());
	}

}
