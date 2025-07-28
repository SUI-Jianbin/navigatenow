package com.navigatenow.navigatenowproject.Model.DTO.ContactUsDTOs;

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
public class ContactUsGetDTO {

    private Integer contactusId;
    private String firstName;
    private String lastName;
    private String email;
    private String description;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
