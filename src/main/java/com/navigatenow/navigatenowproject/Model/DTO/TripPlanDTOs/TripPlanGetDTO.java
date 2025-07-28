package com.navigatenow.navigatenowproject.Model.DTO.TripPlanDTOs;

import com.navigatenow.navigatenowproject.Model.Entity.UserEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripPlanGetDTO {
    private Integer tripPlanId;
    private String planName;
    private String planDescription;
    private Date startDate;
    private Date endDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserEntity userEntity;

}
