package com.navigatenow.navigatenowproject.Model.DTO.UserDTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPostDTO {

    private Integer userId;
    @NotNull(message = "firstName required")
    @Size(min = 2,message = "firstName should be more than 2 letters")
    private String firstName;
    @NotNull(message = "lastName required")
    @Size(min = 2, message = "lastName should be more than 2 letters")
    private String lastName;
    @NotNull(message = "userName required")
    @Size(min = 5, max = 20, message = "userName should be more than 5 letters and less than 20")
    private String userName;
    @NotNull(message = "password required")
    @Size(min = 8, max = 20, message = "password should be more than 7 and less than 20")
    private String password;
    @NotNull(message = "email required")
    @Email(message = "Please write correct email format")
    private String email;
    @NotNull(message = "age required")
    @Min(value = 18, message = "age should be more than 17")
    @Max(value = 90, message = "age should be less than 90")
    private Integer age;
    @NotNull(message = "contactNumber required")
    @Size(min = 10,max = 10, message = "contactNumber should be 10 numbers")
    private String contactNumber;
    @NotNull(message = "gender required")
    private Integer gender;
    @NotNull(message = "dateOfBirth required")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date dateOfBirth;
    @NotNull(message = "nationality required")
    private String nationality;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
