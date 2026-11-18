package com.quickrelief.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record AllocateSupplyRequest(
    @NotBlank(message = "itemName is required")
    @Size(max = 100, message = "itemName must be at most 100 characters")
    String itemName,

    @NotNull(message = "quantity is required")
    @Positive(message = "quantity must be greater than zero")
    Integer quantity,

    @NotBlank(message = "requestedBy is required")
    @Size(max = 100, message = "requestedBy must be at most 100 characters")
    String requestedBy
) {
}
