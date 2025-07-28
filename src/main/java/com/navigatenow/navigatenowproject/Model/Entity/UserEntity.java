package com.navigatenow.navigatenowproject.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Where(clause = "deleted_at is null")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "age")
    private Integer age;
    @Column(name = "contact_number")
    private String contactNumber;
    @Column(name = "gender")
    private Integer gender;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @JsonManagedReference
    @OneToMany(mappedBy = "userEntity")
    private List<FeedbackEntity> feedbackEntities;

    @JsonManagedReference
    @OneToMany(mappedBy = "userEntity")
    private List<User_UserIntrestEntity> user_userIntrestEntities;

    @JsonManagedReference
    @OneToMany(mappedBy = "userEntity")
    private List<User_TripPlan_TripGroupEntity> userTripPlanTripGroupEntities;

    @JsonManagedReference
    @OneToMany(mappedBy = "userEntity")
    private List<TripPlanEntity> tripPlanEntities;
}