package com.navigatenow.navigatenowproject.Model.DTO.ChecklistDTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChecklistUpdateDTO {

    @NotNull(message = "Checklist Id required")
    private Integer checklistId;
    @NotNull(message = "Item Name required")
    @Size(min = 2,message = "item Name should be more than 2 letters")
    private String itemName;
    @NotNull(message = "Item Description required")
    @Size(min = 2,message = "item Description should be more than 2 letters")
    private String itemDescription;
    @NotNull(message = "Item Importance required")
    @Size(min = 2,message = "item Importance should be more than 2 letters")
    private String itemImportance;
    private Integer tripplan_id;
    @UpdateTimestamp
    private LocalDateTime updatedAt = LocalDateTime.now();
}
