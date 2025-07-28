package com.navigatenow.navigatenowproject.Model.DTO.FeedBackDTOs;


import com.navigatenow.navigatenowproject.Model.Entity.FeedbackEntity;
import com.navigatenow.navigatenowproject.Model.Entity.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedBackPostDTO {

    private Integer feedbackId;
    @NotNull(message = "First name required")
    @Size(min = 2,message = "firstName should be more than 2 letters")
    private String firstName;
    @NotNull(message = "Last name required")
    @Size(min = 2,message = "lastName should be more than 2 letters")
    private String lastName;
    @NotNull(message = "Email required")
    @Email(message = "Please write correct email format")
    private String email;
    @NotNull(message = "Description required")
    @Size(min = 2,message = "description should be more than 2 letters")
    private String description;
    @NotNull(message = "Experience Rate required")
    private Integer experienceRate;
    private Integer user_id;
    @CreationTimestamp
    private LocalDateTime createdAt;

}
