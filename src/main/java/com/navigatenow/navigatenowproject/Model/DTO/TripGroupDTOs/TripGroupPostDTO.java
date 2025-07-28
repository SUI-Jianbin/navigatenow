package com.navigatenow.navigatenowproject.Model.DTO.TripGroupDTOs;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class TripGroupPostDTO {
    private Integer tripGroupId;
    @NotNull(message = "groupName required")
    @Size(min = 2,message = "group name should be more than 2 letters")
    private String groupName;
    @NotNull(message = "groupDescription required")
    @Size(min = 2,message = "group name should be more than 2 letters")
    private String groupDescription;
    @Min(value = 1, message = "Number Of Tourists should be more than 0")
    @Max(value = 20, message = "Number Of Tourists should be less than 20")
    private Integer numberOfTourists;
    @Min(value = 2, message = "Group number limit should be more than 2")
    @Max(value = 20, message = "Group number limit should be less than 20")
    private Integer groupNumberLemit;
    private Integer tripplan_id;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
