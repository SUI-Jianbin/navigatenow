package com.navigatenow.navigatenowproject.Model.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "touristy_places")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Where(clause = "deleted_at is null")
public class TouristyPlacesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "touristyplaces_id")
    private Integer touristyPlacesId;
    @Column(name = "place_name")
    private String placeName;
    @Column(name = "place_location")
    private String placeLocation;
    @Column(name = "place_opening_days")
    private String placeOpeningDays;
    @Column(name = "place_opening_times")
    private String placeOpeningTimes;
    @Column(name = "place_closing_times")
    private String placeClosingTime;
    @Column(name = "place_rate")
    private String placeRate;
    @Lob
    @Column(name = "place_picture", length = 100000)
    private String placePicture;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @JsonManagedReference
    @OneToMany(mappedBy = "touristyPlacesEntity")
    private List<TouristyPlaces_TripPlanEntity> touristyPlacesTripPlans;

    @JsonManagedReference
    @OneToOne(mappedBy = "touristyPlacesEntity")
    private ExpencesCalculatorEntity expencesCalculatorEntity;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userintrest_id")
    private UserIntrestEntity userIntrestEntity;
}
