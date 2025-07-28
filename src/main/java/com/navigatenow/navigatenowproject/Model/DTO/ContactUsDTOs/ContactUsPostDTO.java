package com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs;

import jakarta.validation.constraints.Email;
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
public class ContactUsPostDTO {

    private Integer contactusId;
    @NotNull(message = "firstName required")
    @Size(min = 2,message = "firstName should be more than 2 letters")
    private String firstName;
    @NotNull(message = "lastName required")
    @Size(min = 2,message = "lastName should be more than 2 letters")
    private String lastName;
    @NotNull(message = "email required")
    @Email(message = "Please write correct email format")
    private String email;
    @NotNull(message = "description required")
    @Size(min = 2,message = "description should be more than 2 letters")
    private String description;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
