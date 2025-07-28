package com.navigatenow.navigatenowproject.Model.DTO.ExpencesCalculatorDTOs;

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
public class ExpencesCalculatorPostDTO {
    private Integer expencesCalculatorId;
    @NotNull(message = " name required")
    @Size(min = 2,message = "name should be more than 2 letters")
    private String name;
    @NotNull(message = " description required")
    @Size(min = 2,message = "description should be more than 2 letters")
    private String description;
    @NotNull(message = " periority required")
    @Size(min = 2,message = "periority should be more than 2 letters")
    private String periority;
    @NotNull(message = " price required")
    @Size(min = 2,message = "price should be more than 2 letters")
    private String price;
    private String totalCost;
    @NotNull(message = " type required")
    @Size(min = 2,message = "type should be more than 2 letters")
    private String type;
    @NotNull(message = " type required")
    private Integer touristyplaces_id;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
