package com.navigatenow.navigatenowproject.Model.DTO.ChecklistDTOs;

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
public class ChecklistPostDTO {
    private Integer checklistId;
    @NotNull(message = "Item name required")
    @Size(min = 2,message = "item Name should be more than 2 letters")
    private String itemName;
    @NotNull(message = "Item description required")
    @Size(min = 2,message = "item Description should be more than 2 letters")
    private String itemDescription;
    @NotNull(message = "Item importance required")
    @Size(min = 2,message = "item Importance should be more than 2 letters")
    private String itemImportance;
    private Integer tripplan_id;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
