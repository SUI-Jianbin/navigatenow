package com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs;

import com.navigatenow.navigatenowproject.Model.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedBackGetDTO {

    private Integer feedbackId;
    private String firstName;
    private String lastName;
    private String email;
    private String description;
    private Integer experienceRate;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private UserEntity userEntity;

}
