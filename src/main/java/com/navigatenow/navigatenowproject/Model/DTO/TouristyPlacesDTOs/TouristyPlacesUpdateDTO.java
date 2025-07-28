package com.navigatenow.navigatenowproject.Model.DTO.TouristyPlacesDTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TouristyPlacesUpdateDTO {
    private Integer touristyPlacesId;
    @NotNull(message = "placeName required")
    @Size(min = 2,message = "placeName should be more than 2 letters")
    private String placeName;
    @NotNull(message = "placeLocation required")
    @Size(min = 2,message = "place Location should be more than 2 letters")
    private String placeLocation;
    @NotNull(message = "placeOpeningDays required")
    @Size(min = 2,message = "place Opening Days should be more than 2 letters")
    private String placeOpeningDays;
    @NotNull(message = "placeOpeningTimes required")
    @Size(min = 2,message = "place Opening Times should be more than 2 letters")
    private String placeOpeningTimes;
    @NotNull(message = "placeClosingTime required")
    @Size(min = 2,message = "place Closing Time should be more than 2 letters")
    private String placeClosingTime;
    @NotNull(message = "placeRate required")
    @Size(min = 2,message = "place Rate should be more than 2 letters")
    private String placeRate;
    @NotNull(message = "placePicture required")
    @Size(min = 2,message = "place Picture should be more than 2 letters")
    private String placePicture;
    private Integer userintrestId;
    @UpdateTimestamp
    private LocalDateTime updatedAt = LocalDateTime.now();
}
