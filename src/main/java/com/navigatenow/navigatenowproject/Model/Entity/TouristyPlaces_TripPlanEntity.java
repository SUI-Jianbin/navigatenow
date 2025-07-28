package com.navigatenow.navigatenowproject.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Table(name = "touristyplaces_tripplan")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "deleted_at is null")
public class TouristyPlaces_TripPlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "touristyplaces_tripplan_id")
    private Integer touristyPlaces_tripPlanId;
    @Column(name = "tripplan_id")
    private Integer tripPlanId;
    @Column(name = "touristyplaces_id")
    private Integer touristyPlacesId;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "tripplan_id",insertable = false,updatable = false)
    private TripPlanEntity tripPlanEntity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "touristyplaces_id",insertable = false,updatable = false)
    private TouristyPlacesEntity touristyPlacesEntity;
}
