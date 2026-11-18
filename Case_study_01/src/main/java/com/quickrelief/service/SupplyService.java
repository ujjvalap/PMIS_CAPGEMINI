package com.quickrelief.service;

import com.quickrelief.dto.CreateSupplyRequest;
import com.quickrelief.model.Supply;
import com.quickrelief.repository.SupplyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplyService {

    private final SupplyRepository supplyRepository;

    public SupplyService(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    public List<Supply> getAllSupplies() {
        return supplyRepository.findAll();
    }

    @Transactional
    public Supply addOrRestock(CreateSupplyRequest request) {
        String itemName = request.itemName().trim();

        // A unique constraint on item_name prevents duplicate inventory rows.
        // For this small challenge, inventory creation/restocking is kept simple.
        var existing = supplyRepository.findByItemName(itemName);

        if (existing.isPresent()) {
            supplyRepository.restock(existing.get().id(), request.quantity());
        } else {
            supplyRepository.insert(itemName, request.quantity());
        }

        return supplyRepository.findByItemName(itemName)
            .orElseThrow(() -> new IllegalStateException(
                "Supply was not available after saving"));
    }
}
