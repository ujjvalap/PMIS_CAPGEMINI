package com.quickrelief.model;

public record SupplyRequest(
    long id,
    String itemName,
    int quantity,
    String status,
    String requestedBy
) {
}
