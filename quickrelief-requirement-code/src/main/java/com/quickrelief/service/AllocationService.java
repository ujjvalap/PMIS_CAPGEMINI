package com.quickrelief.service;

import com.quickrelief.dto.AllocateSupplyRequest;
import com.quickrelief.exception.InsufficientStockException;
import com.quickrelief.model.SupplyRequest;
import com.quickrelief.repository.RequestRepository;
import com.quickrelief.repository.SupplyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AllocationService {

    private final SupplyRepository supplyRepository;
    private final RequestRepository requestRepository;

    public AllocationService(
            SupplyRepository supplyRepository,
            RequestRepository requestRepository) {
        this.supplyRepository = supplyRepository;
        this.requestRepository = requestRepository;
    }

    @Transactional
    public SupplyRequest allocate(AllocateSupplyRequest request) {
        String itemName = request.itemName().trim();
        int quantity = request.quantity();

        int updatedRows =
            supplyRepository.deductIfAvailable(itemName, quantity);

        if (updatedRows == 0) {
            throw new InsufficientStockException(
                "Supply item does not exist or available stock is insufficient");
        }

        // If this insert fails, the runtime exception causes the stock deduction
        // to roll back because both operations are in the same transaction.
        return requestRepository.insert(
            itemName, quantity, request.requestedBy().trim());
    }
}
