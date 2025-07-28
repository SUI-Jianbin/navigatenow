package com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs;

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
public class TripGroupUpdateDTO {
    private Integer tripGroupId;
    private String groupName;
    private String groupDescription;
    private Integer numberOfTourists;
    private Integer groupNumberLemit;
    private Integer tripplan_id;
    @UpdateTimestamp
    private LocalDateTime updatedAt = LocalDateTime.now();

}
