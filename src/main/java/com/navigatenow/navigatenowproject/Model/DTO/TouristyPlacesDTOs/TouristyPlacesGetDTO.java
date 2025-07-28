package com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs;

import com.navigatenow.navigatenowproject.Model.Entity.UserIntrestEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TouristyPlacesGetDTO {
    private Integer touristyPlacesId;
    private String placeName;
    private String placeLocation;
    private String placeOpeningDays;
    private String placeOpeningTimes;
    private String placeClosingTime;
    private String placeRate;
    private String placePicture;
    private UserIntrestEntity userIntrestEntity;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
