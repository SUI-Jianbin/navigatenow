package com.navigatenow.navigatenowproject.Model.DTO.UserDTOs;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class UserGetDTO {


    private Integer userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private Integer age;
    private String contactNumber;
    private Integer gender;
    private Date dateOfBirth;
    private String nationality;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
