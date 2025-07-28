package com.navigatenow.navigatenowproject.Controller;

import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs.ContactUsPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ExpencesCalculatorDTOs.ExpencesCalculatorGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ExpencesCalculatorDTOs.ExpencesCalculatorPostDTO;
import com.navigatenow.navigatenowproject.Model.DTO.ExpencesCalculatorDTOs.ExpencesCalculatorUpdateDTO;
import com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs.FeedBackGetDTO;
import com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs.TripPlanUpdateDTO;
import com.navigatenow.navigatenowproject.Service.Impl.ExpencesCalculatorServicesImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/expencescalculators")
@CrossOrigin
@RequiredArgsConstructor
public class ExpencesCalculatorController {
    public final ExpencesCalculatorServicesImpl expencesCalculatorServices;

    @PostMapping(path = "/expencescalculator/add-expencescalculator")
    public ExpencesCalculatorPostDTO addExpencesCalculator(@RequestBody @Valid ExpencesCalculatorPostDTO expencesCalculatorPostDTO){
        return this.expencesCalculatorServices.addExpencesCalculator(expencesCalculatorPostDTO);
    }

    @GetMapping(path = "/expencescalculator/get-expencescalculatorbyid/{id}")
    public ExpencesCalculatorGetDTO getExpencesCalculatorById(@PathVariable Integer id){
        return this.expencesCalculatorServices.getExpencesCalculatorById(id);
    }

    @GetMapping(path = "/expencescalculator/checkif-touristyplacehas-expences-bytouristyplaceid/{touristyplaceid}")
    public Boolean checkIfTouristyPlaceHasExpencesByTouristyPlaceId(@PathVariable Integer touristyplaceid){
        return this.expencesCalculatorServices.checkIfTouristyPlaceHasExpencesByTouristyPlaceId(touristyplaceid);
    }

    @GetMapping(path = "/expencescalculator/get-allexpencescalculator")
    public List<ExpencesCalculatorGetDTO> getAllExpencesCalculator(){
        return this.expencesCalculatorServices.getAllExpencesCalculator();
    }

    @PutMapping(path = "/expencescalculator/update-expencescalculator")
    public ExpencesCalculatorUpdateDTO updateExpencesCalculator(@RequestBody @Valid ExpencesCalculatorUpdateDTO expencesCalculatorUpdateDTO){
        return this.expencesCalculatorServices.updateExpencesCalculator(expencesCalculatorUpdateDTO);
    }

    @DeleteMapping(path = "/expencescalculator/delete-expencescalculatorbyid/{id}")
    public String deleteExpencesCalculator(@PathVariable Integer id) {
        return this.expencesCalculatorServices.deleteExpencesCalculator(id);
    }

    @GetMapping(path = "/expencescalculator/get-expencescalculatorbytouristyplacesid/{touristyplacesid}")
    public List<ExpencesCalculatorGetDTO> getExpencesCalculatorsByTouristyPlacesId(@PathVariable Integer touristyplacesid){
        return this.expencesCalculatorServices.getExpencesCalculatorsByTouristyPlacesId(touristyplacesid);
    }
}
