package com.navigatenow.navigatenowproject.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_tripplan_tripgroup")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "deleted_at is null")
public class User_TripPlan_TripGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_tripplan_tripgroup_id")
    private Integer user_TripPlan_TripGroupId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "tripplan_id")
    private Integer tripPlanId;
    @Column(name = "trip_group_id")
    private Integer tripGroupId;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity userEntity;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tripplan_id" , insertable = false, updatable = false)
    private TripPlanEntity tripPlanEntity;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trip_group_id", insertable = false, updatable = false)
    private TripGroupEntity tripGroupEntity;
}
